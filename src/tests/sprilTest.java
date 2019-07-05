package tests;

import org.junit.Rule;
import org.junit.Test;
import codeGeneration.SPRILGenerator;
import org.junit.rules.ExpectedException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class sprilTest {
    // ---------------------------------begin tests for the runtable---------------------------------
    public String typelessReAssignmentError = "tried to fetch undeclared var (in getHeapLoc)";
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private String addTypeError = "type redeclaration not allowed, already in scope";

    // source: decline
    public String addError = "redeclaration not allowed in 1 scope";
    @Test // in case var already declared and declared again WITH assignment
    public void addError() {
        runtimeError("Int a = 5; Bool a = true;", addError);
        runtimeError("Str a = 5; Bool a = true;", addError);
    }

    // source: decline
    @Test
    public void typeError() {
        runtimeError("Int f = 10; Bool f;", addTypeError);
        runtimeError("Int f = 10; Int a = 10; Bool f;", addTypeError);
    }

    // source: asgnline
    @Test // in case var not declared yet but trying to assign
    public void asgnError() {
        runtimeError("a = 5;", typelessReAssignmentError);
    }

    public void runtimeError(String prog, String errormessage) {
        try {
            SPRILGenerator.convertProgToFile(prog, "");
            fail();
        } catch (RuntimeException e) {
            assertEquals(e.getMessage(), errormessage);
        }
    }
    // todo figure out how to work with functions. start new symoltable and restore after functioncall?
    // like a = new Symboltable(false); a.root = a.currentscope = this.symtable.root;this.symtable = a;
// ---------------------------------end tests for the symtable---------------------------------
    private static String defaultLoc = "src\\sprockell\\src\\temp.hs";
    public static List<String> runprog(String program) throws IOException, InterruptedException {
        String fileloc = SPRILGenerator.convertProgToFile(program,"temp");
        Process cmd = new ProcessBuilder("cmd.exe", "/C", "bat", "\""+ fileloc + "\"")
                .redirectErrorStream(true).start();
        InputStream in = cmd.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line;
        List res = new ArrayList<String>();
        while ((line = br.readLine()) != null) {
            System.out.println("line: " + line);
            res.add(line);
        }
        cmd.waitFor();
        System.out.println("cmd done");
        return res;
    }

    public void checkOutput(List<String> expected_outputs, List<String> actual_output){
        for (int i = actual_output.size() - expected_outputs.size(); i < actual_output.size(); i++) {
            int adjusted_index_expected = i-actual_output.size()+expected_outputs.size();
            System.out.println("I: "+ i+ "  adjustedindex: "+ adjusted_index_expected);
            System.out.println("expected: "+ expected_outputs.get(adjusted_index_expected));
            System.out.println("actual: "+ actual_output.get(i));
            assertEquals(expected_outputs.get(adjusted_index_expected), actual_output.get(i));
        }
        if (actual_output.get(actual_output.size()-expected_outputs.size()-1).startsWith("Sprockell")) {
            fail();
        }
    }

    public void assertProg(String program, List<String> expected_outputs) {
        try {
            List<String> res= runprog(program);
            System.out.println("-------------------");
            System.out.println("res: "+ res);
            System.out.println(res.size() + "------" + expected_outputs.size());
            checkOutput(expected_outputs, res);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String sprolprint(int id, int number) {
        return "Sprockell "+ id + " says " + number;
    }

    @Test
    public void ifTest() {
        assertProg("Bool a = true; if a {OutNumber 2;} else {OutNumber 10;}",
                Arrays.asList(sprolprint(0, 2)));
        assertProg("Int a = true; if a {OutNumber 5;} else {OutNumber 10;}",
                Arrays.asList(sprolprint(0, 5)));
        assertProg("Int a = false; if a {OutNumber 5;} else {OutNumber 10;}",
                Arrays.asList(sprolprint(0, 10)));
        assertProg("Int b; Int c; if true {b = 10;} else {c = 20;}OutNumber b;",
                Arrays.asList(sprolprint(0, 10)));

    }

    @Test
    public void whileTest() {
        assertProg("Int a = 0; while a < 3 {OutNumber a;a = a + 1;}"
                , Arrays.asList(sprolprint(0, 0),sprolprint(0, 1),
                        sprolprint(0, 2)));
        assertProg("Int a = 0; while a < 3 {OutNumber a;a = a + 1;} OutNumber a;"
        , Arrays.asList(sprolprint(0, 0),sprolprint(0, 1),
                sprolprint(0, 2),sprolprint(0, 3)));
        assertProg("Bool a = false; while a {OutNumber 10;} OutNumber 5;"
                , Arrays.asList(sprolprint(0, 5)));
        assertProg("Bool a = true; while a {OutNumber 10;a = false;} OutNumber 5;"
                , Arrays.asList(sprolprint(0, 10), sprolprint(0, 5)));
    }

    @Test
    public void comExprTest() {
        assertProg("Bool a = true; Int b = 0;" +
                        "while a {" +
                        "   OutNumber b; " +
                        "   if b < 3 {" +
                        "       b = b+1;} " +
                        "   else {" +
                        "       a = false;}" +
                        "} " +
                        "OutNumber b;"
                , Arrays.asList(sprolprint(0, 0), sprolprint(0,1),
                        sprolprint(0, 2), sprolprint(0,3),
                        sprolprint(0,3))
        );
        assertProg("Int b = 0;" +
                        "while b < 3 {" +
                        "   OutNumber b; " +
                        "   b = b+1;" +
                        "} "
                , Arrays.asList(sprolprint(0, 0), sprolprint(0,1),
                        sprolprint(0, 2)));
        assertProg("Int b = 3;" +
                        "while b > 0 {" +
                        "   OutNumber b; " +
                        "   b = b-1;" +
                        "} "
                , Arrays.asList(sprolprint(0, 3), sprolprint(0,2),
                        sprolprint(0, 1)));
    }

    @Test
    public void concurTest() {
        assertProg("Int a = 5; parallel { sequential {Int a = 10; OutNumber a;}}",
                Arrays.asList(sprolprint(1, 10)));
        assertProg("Int a = 5; parallel { " +
                        "sequential {OutNumber a;}}",
                Arrays.asList(sprolprint(1, 5)));

//        assertProg("Int a = 15;parallel { sequential {" +
//                    "OutNumber a;}}" +
//                "OutNumber a;", Arrays.asList(sprolprint(0, 15)));
    }
//        assertProg("parallel {" +
//                "   sequential {OutNumber 2;} } " +
//                "OutNumber 3;", Arrays.asList());

//        assertProg("Int a = 10; Int b = 11; parallel {" +
//                "sequential {OutNumber a;} sequential {OutNumber b;}}", Arrays.asList());
//    }

// ---------------------------concurrency tests--------------------------------------------
    @Test
    public void properJoinTest() { // passed 100 times
//        assertProg("Int a = 5; parallel { " +
//                    "sequential {Int a = 10; OutNumber a;}" +
//                    "} OutNumber a;",
//                    Arrays.asList(sprolprint(1, 10),sprolprint(0,5)));

        assertProg("Int a = 5; parallel { " +
                        "sequential {Int a = 10; OutNumber a;}" +
                        "sequential {Int a = 10; OutNumber a;}" +
                        "} OutNumber a;",
                Arrays.asList(sprolprint(0,5),
                        sprolprint(1, 10),sprolprint(1, 10)));
//        assertProg("Int a = 5; parallel { " +
//                        "sequential {OutNumber 10;}} OutNumber a;",
//                Arrays.asList(sprolprint(1, 10)));
    }

    @Test
    public void stupidTest() {
        assertProg("Int a = 5;parallel {" +
                "sequential {OutNumber a;}" +
//                "sequential {OutNumber a;}" +
                "sequential {OutNumber a;}"+
                "}",new ArrayList<>());
    }

    @Test
    public void concurrencystuffTest() {
        assertProg("Int a = 5;parallel {" +
                "sequential {Nop;}" +
//                "sequential {OutNumber a;}" +
                "sequential {Nop;}"+
                "} OutNumber a;Nop;",new ArrayList<>());
    }
}
