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
            for (int i = res.size() - expected_outputs.size(); i < expected_outputs.size(); i++) {
                assertEquals(expected_outputs.get(i), res.get(i));
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
    public void simpleTest() {
        assertProg("Bool a = true; if a {OutNumber 2;} else {OutNumber 10;}",
                Arrays.asList(sprolprint(0, 2)));
        assertProg("Int a = true; if a {OutNumber 5;} else {OutNumber 10;}",
                Arrays.asList(sprolprint(0, 5)));
    }

}
