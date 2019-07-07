package RunLanguage;

import TypeChecker.TypeChecker;
import codeGeneration.SPRILGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class RunLanguage {


// ==================== ONLY CHANGE THE PROGRAM_STRING BELOW ====================

    private static final String PROGRAM_STRING = "Int i = 0;";

// ==================== ONLY CHANGE THE PROGRAM_STRING ABOVE ====================



    public static void main(String[] args) {
        TypeChecker typeChecker = new TypeChecker();
        Boolean proceed = false;
        try {
            proceed = typeChecker.checkProgram(PROGRAM_STRING);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(!proceed) {
            return;
        }
        List<String> res= null;
        try {
            res = runprog(PROGRAM_STRING);
            System.out.println("-------------------");
            System.out.println("res: "+ res);
            System.out.println("=================================================================");
            System.out.println("PROGRAM SPROCKELL CODE CAN BE FOUND IN src/sprockell/src/temp.hs");
            System.out.println("=================================================================");
            System.out.println("-------------------");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

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
}
