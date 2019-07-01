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

    public void assertProg(String program, List<String> expected_outputs) {
        try {
            List<String> res= runprog(program);
            System.out.println("-------------------");
            System.out.println("res: "+ res);
            System.out.println(res.size() + "------" + expected_outputs.size());
            for (int i = res.size() - expected_outputs.size(); i < res.size(); i++) {
                int adjusted_index_expected = i-res.size()+expected_outputs.size();
                System.out.println("I: "+ i+ "  adjustedindex: "+ adjusted_index_expected);
                System.out.println("expected: "+ expected_outputs.get(adjusted_index_expected));
                System.out.println("actual: "+ res.get(i));
                assertEquals(expected_outputs.get(adjusted_index_expected), res.get(i));
            }
            if (res.get(res.size()-expected_outputs.size()-1).startsWith("Sprockell")) {
                fail();
            } else {
                System.out.println("last line not output sprockell---------");
            }
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
        assertProg("Int a = 5;Int b = 8; while a == 5 {" +
                        "if b < 10 {b = b+ 1;} else {a = 6;}} OutNumber a;"
                , Arrays.asList(sprolprint(0, 6))
                );
        assertProg("Bool a = false; while a {OutNumber 10;} OutNumber 5;"
                , Arrays.asList(sprolprint(0, 5)));
        assertProg("Bool a = true; while a {OutNumber 10;a = false;} OutNumber 5;"
                , Arrays.asList(sprolprint(0, 10), sprolprint(0, 5)));
        assertProg("Bool a = true; while a {OutNumber 10;a = false;} OutNumber 5;"
                , Arrays.asList(sprolprint(0, 10)));
    }

}
