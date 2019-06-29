package codeGeneration;

import Grammar.GrammarBaseVisitor;
import Grammar.GrammarLexer;
import Grammar.GrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import javax.xml.stream.events.Comment;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static codeGeneration.SPRILGenerator.types.*;
import static codeGeneration.SPRILGenerator.registers.*;


//Fun Int Mult2 Int a Int v {a = a*2 ;return a}
//        Fun Int Stupid Int f {Int t = f + f; return t+t}
//        Int a = Mult2 5 4;

public class SPRILGenerator extends GrammarBaseVisitor {
    private List<String> program;
    private boolean errors;
    private int currLine;
    private int heaptop;
    private symtable symtable;
    // string: varname, type: [types(static vals)], value: register value 2-7 for a-f and 0 if not assigned
    private boolean[] registers; // true: register in use, false: register NOT in use
    private HashMap<String, RuleContext> validFunctions;

    public SPRILGenerator() {
        this.program = new ArrayList<>();
        this.errors = false;
        this.currLine = 0;
        this.heaptop = 0;
        this.validFunctions = new HashMap();
        this.firstTime = true;
        this.registers = new boolean[6];
    }

    public static class types{ // TODO capitalize all finals
    //	0 = Int
    //	1 = Boolean
    //	2 = Char (currently unused)
    //	3 = String
    //	4 = Array
        //	The types belonging to each int are as follows:
        public static final int INT = 0;
        public static final int BOOLEAN = 1;
        public static final int STRING = 3;
        public static final int ARRAY = 4;
    }

    public static class registers { // TODO capitalize all finals
        // register values for instruction usage
        // same values as defined in the sprockell BasicFunctions.hs file
        public static final int ra = 2; // registers 0
        public static final int rb = 3; // registers 1
        public static final int rc = 4; // registers 2
        public static final int rd = 5; // registers 3
        public static final int re = 6; // registers 4
        public static final int rf = 7; // registers 5
        public static final int rnone = 0;
    }

    public static class op {
        String push(int r) {return "Push "+ r;}
        String pop(int r) {return "Pop "+ r;}
    }

    public String store(int reg) {
        return "Store " + reg + " (DirAddr "+ this.heaptop++ + ")"; // heaptop++ increments after so if 100, then store ... 100 and
    }


    private int getemptyreg() {
        for (int i = 0; i < 6; i++) {
            if (!registers[i]) { // so register is empty
                System.out.println("register was: "+ registers[i]);
                registers[i] = true;
                System.out.println("returned register "+ (i+2));
                return (i +2);
            }
        }
        System.out.println("all registers already in use");
        return rnone;
    }

    private void clearreg(int reg) { // reg+2 since it starts at 2
        int actualreg = reg -2;
        if (!registers[actualreg]) { // when register is already clear/false
            System.out.println("tried to clear register that was already cleared");
        }
        System.out.println("cleared register(-2): "+ actualreg);
        this.registers[actualreg] = false;
    }

    private boolean firstTime;
    @Override
    public Object visitProgram(GrammarParser.ProgramContext ctx) {
        this.symtable = new symtable(true);
        for (RuleContext fun: ctx.function() ) {
            visit(fun);
        }
        System.out.println(this.validFunctions.entrySet());
        System.out.println("in program");
        this.firstTime = false;
        for (RuleContext line : ctx.line()) {
            visit(line);
        }
//        for (RuleContext fun: ctx.function() ) {
//            visit(fun);
//        }
        System.out.println("registers: "+ java.util.Arrays.toString(this.registers));
        return null;
    }

    @Override
    public Object visitFunction(GrammarParser.FunctionContext ctx) {
        if (this.firstTime) {
            System.out.println("first time in: "+ctx.FUNNAME().getSymbol().getText());
            this.validFunctions.put(ctx.FUNNAME().getSymbol().getText(), ctx);
            return null;
        }
        // when it is called by a functioncall
        // remove args from stack
        commment("start of function:" + "Mult2");
        for (RuleContext line : ctx.line()){
            visit(line);
        }
        if (ctx.RETURN() != null) {
            commment("return present");
        }
        commment("end of function: "+ "mult2");
        System.out.println("end of function "+ ctx.FUNNAME().getSymbol().getText()+" for 2nd time");
        return visit(ctx.RETURN());
    }

    @Override
    public Object visitFunctioncall(GrammarParser.FunctioncallContext ctx) {
        int resultreg;
//        System.out.println(ctx.FUNNAME().getText());
        System.out.println("----------in functioncall: "+ctx.getText());
        System.out.println(ctx.expr().size());
        System.out.println(ctx.expr(0).getText());
        switch (ctx.FUNNAME().getSymbol().getText()) {
            case "InNumber":
                resultreg = getemptyreg();
                instr("ReadInstr numberIO");
                instr("Receive " + resultreg);
                commment("end InNumber");
                return resultreg;
            case "InChar":
                resultreg = getemptyreg();
                instr("ReadInstr CharIO");
                instr("Receive "+ resultreg);
                commment("end InChar");
                return resultreg;
            case "OutNumber":
                resultreg = (int) visit(ctx.expr(0));
                instr("WriteInstr " + resultreg + " numberIO");
                commment("end OutNumber");
                return resultreg; // since it can not be used ain an assignment
            case "OutChar":
                resultreg = (int) visit(ctx.expr(0));
                instr("WriteInstr "+ resultreg + " r CharIO");
                commment("end OutChar");
                return resultreg; // since it can not be used ain an assignment
            default:
                visit(validFunctions.get(ctx.FUNNAME().getSymbol().getText()));
                throw new RuntimeException("functioncall case not defined");
        }
    }

    @Override
    public Object visitFuncallLine(GrammarParser.FuncallLineContext ctx) {
        System.out.println("---------funtext: "+ ctx.getText());
        System.out.println(ctx.functioncall().getText());
        System.out.println(ctx.functioncall().expr(0));
        clearreg((int) visit(ctx.functioncall()));
        return null;
    }

    //  ----------------------------lines-------------------------------------------------
    private void not(int register) {
        int truereg = getemptyreg();
        instr("Load (ImmValue " + "1)" + " " + truereg);
        instr("Compute Xor "+ truereg + " " + register + " " + register);
        clearreg(truereg);
    }

    @Override
    public Object visitDeclLine(GrammarParser.DeclLineContext ctx) {
        String varname = ctx.VARNAME().getText();
        List<Integer> types = (List<Integer>) visit(ctx.types());
        // visit the expression, its return value is the register in which the value resides
        if (ctx.ASGN() != null) {
            int storedaddr = this.heaptop;
            int value;
            System.out.println("assign not null");
            if (ctx.expr() != null) {
                // expr assignment
                value = (int) visit(ctx.expr());
            }else {
                // functioncall assignment
                System.out.println("functioncall assignment");
                value = (int) visit(ctx.functioncall());
            }
            instr(store(value));
            clearreg(value);
            symtable.add(varname, types,  storedaddr);
            commment("declLine: "+ "varname: "+ varname + " stored at "+ storedaddr +" types: "+ types + " expr: "+ ctx.expr().getText());
            System.out.println("declLine: "+ "varname: "+ varname +" types: "+ types + " expr: "+ ctx.expr().getText());
        } else {
            // in case of type declaration
            System.out.println("should be last print");
            symtable.currentscope.addType(varname, types);
        }
        return null;
    }

    @Override
    public Object visitAsgnLine(GrammarParser.AsgnLineContext ctx) {
        String varname = (String)visit(ctx.target());
        if (ctx.expr() != null) {
            // when expr
            int expr = (int) visit(ctx.expr());
            int heaploc =symtable.getHeapLoc(varname);
            List<Integer> types = symtable.getType(varname);
            instr("Store "+ expr + " DirAddr "+ heaploc);
            clearreg(expr);
            commment("asgnline: "+ "varname: "+ varname + " overwritten at heaploc "+ heaploc +" types: "+ types + " expr: "+ ctx.expr().getText());
        } else {
            // when functioncall
        }
        return null;
    }

    @Override
    public Object visitIfLine(GrammarParser.IfLineContext ctx) {
        List<Integer> nopsendblock = new ArrayList<>();
        for (int i= 0; i < ctx.OCUR().size(); i++) {
            int opencur = ctx.children.indexOf(ctx.OCUR((i)));
            int closecur = ctx.children.indexOf(ctx.CCUR(i));
            int heap_backup = this.heaptop;
            symtable.openScope();
            // so if or elif
            int expr = rnone;
            if (! ctx.getChild(opencur-1).getText().equals("else")) {
                expr = (int) visit(ctx.expr(i));
                not(expr);
                instr("Nop");
            }
            int nop_index = this.currLine - 1;
            for (int j = opencur+1; j < closecur; j++) {
                visit(ctx.getChild(j));
            }
            symtable.closeScope();
            this.heaptop = heap_backup;
            if (! ctx.getChild(opencur-1).getText().equals("else")) {
                if (expr == rnone) {
                    System.out.println("should not have rnone as expr");
                }
                program.set(nop_index, "{-" + nop_index + "-}\t\t" + "Branch " + expr + " (Abs " + (currLine+1) + ")\t{- if/elif -}");
                clearreg(expr);
                instr("Nop"); // otherwise jump can be after last instruction
                nopsendblock.add(currLine-1);
            }
        }
        instr("Nop");
        for (int nop_instr : nopsendblock) {
            this.program.set(nop_instr, "{-"+ nop_instr + "-}\t\tJump (Abs " + (currLine-1) + ")" + "\t\t\t{- Jump to after if, elif and else statements -}");
        }
        System.out.println(currLine-1);
        return null;
    }

    @Override
    public Object visitWhileLine(GrammarParser.WhileLineContext ctx) {
        int heap_backup = this.heaptop;
        symtable.openScope();
        int expr = rnone;
        expr = (int) visit(ctx.expr());
        not(expr);
        instr("Nop");
        int nop_index = this.currLine - 1;
        for (ParseTree line: ctx.line()) {
            visit(line);
        }
        symtable.closeScope();
        this.heaptop = heap_backup;
        program.set(nop_index, "{-" + nop_index + "-}\t\t" + "Branch " + expr + "(Abs " + (currLine) + ")");
        clearreg(expr);
        instr("Nop"); // otherwise jump can be after last instruction
        return null;
    }

    //  ----------------------------target-------------------------------------------------
    // returns a string of the varname

    @Override
    public Object visitVarTarget(GrammarParser.VarTargetContext ctx) {
        System.out.println("varTarget: "+ ctx.VARNAME().getSymbol().getText());
        return ctx.VARNAME().getSymbol().getText();
    }

    //  ----------------------------Expressions-------------------------------------------------
//  always return a valid register number: a:2 f:7
    // missing : arreExpr, varExpr, listExpr
    @Override
    public Object visitParensExpr(GrammarParser.ParensExprContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Object visitCompExpr(GrammarParser.CompExprContext ctx) {
        int expr1 = (int) visit(ctx.expr(0));// register where expression situated
        int expr2 = (int) visit(ctx.expr(1));// register where expression situated
        String operation = (String) visit(ctx.comp());// operation which contains the spaces on both sides
        operation = "Compute " + operation + " "+ expr1 + " " + expr2 +" "+  expr1;
        clearreg(expr2);
        instr(operation);
        return expr1;
    }

    @Override
    public Object visitMultExpr(GrammarParser.MultExprContext ctx) {
        int expr1 = (int) visit(ctx.expr(0));// register where expression situated
        int expr2 = (int) visit(ctx.expr(1));// register where expression situated
        instr("Compute Mul "+ expr1 +" "+  expr2 +" "+  expr1);
        clearreg(expr2);
        return expr1;
    }

    @Override
    public Object visitAddorsubExpr(GrammarParser.AddorsubExprContext ctx) {
        int expr1 = (int) visit(ctx.expr(0));// register where expression situated
        int expr2 = (int) visit(ctx.expr(1));// register where expression situated
        if (ctx.PLUS() != null) {
            instr("Compute Add "+ expr1 +" "+ expr2 + " "+ expr1);
        } else {
            instr("Compute Sub "+ expr1 + " "+ expr2 + " "+ expr1);
        }
        clearreg(expr2);
        return expr1;
    }

    @Override
    public Object visitConstExpr(GrammarParser.ConstExprContext ctx) {
        int resultreg = getemptyreg();
        if (ctx.NUM() != null) {
            // case num
            int val = Integer.parseInt(ctx.NUM().getText());
            instr("Load (ImmValue " + val + ") " + resultreg);
            commment("loaded integer " + val);
            return resultreg;
        } else if (ctx.TRUE() != null) {
            // case true
            instr("Load (ImmValue " + "1)" + " " + resultreg);
            commment("loaded true");
            return resultreg;
        } else if (ctx.FALSE() != null) {
            // case false
            instr("Load (ImmValue " + "0)" + " " + resultreg);
            commment("loaded false");
            return resultreg;
        } else { // todo: figure out how to handle strings
            // case string
            System.out.println("got to visitconstExpr String case!!! not yet implemented....");
            return null;
        }
    }

    @Override
    public Object visitVarExpr(GrammarParser.VarExprContext ctx) {
        String varname = ctx.getText();
        int resultreg = getemptyreg();
        int heaploc = symtable.getHeapLoc(varname);
        instr("Load (DirAddr "+ heaploc + ") "+ resultreg);
        return resultreg;
    }

    //  ----------------------------comp-------------------------------------------------
    @Override
    public Object visitComp(GrammarParser.CompContext ctx) {
        System.out.println("comp symbol: "+ ctx.getText());
        String operation = ctx.getText();
        switch (operation) {
            case "+":
                operation = "Add ";
                break;
            case "-":
                operation = "Sub ";
                break;
            case "*":
                operation = "Mul ";
                break;
            case ">=":
                operation = "GtE ";
                break;
            case ">":
                operation = "Gt ";
                break;
            case "<=":
                operation = "LtE ";
                break;
            case "<":
                operation = "Lt ";
                break;
            case "!=":
                operation = "NEq ";
                break;
            case "==":
                operation = "Equal ";
                break;
            default:
                throw new RuntimeException("found invalid operation: " + operation);
        }
        return operation;
    }

    //  ----------------------------types: always return an integer-------------------------------------------------
    @Override
    public Object visitStr(GrammarParser.StrContext ctx) {
        return new ArrayList<>(List.of(STRING));
    }

    @Override
    public Object visitArray(GrammarParser.ArrayContext ctx) {
        List<Integer> prevtypes = (List<Integer>) visit(ctx.types());
        prevtypes.add(ARRAY);
        return prevtypes;
    }

    @Override
    public Object visitInt(GrammarParser.IntContext ctx) {
        return new ArrayList<>(List.of(INT));
    }

    @Override
    public Object visitBool(GrammarParser.BoolContext ctx) {
        return new ArrayList<>(List.of(BOOLEAN));
    }

//  ----------------------------utilities-------------------------------------------------

    private void instr(String s) {
        this.program.add("{-"+currLine+"-}\t\t"+ s);
        this.currLine++;
    }
    //never end with a comma for prog
    private void commment(String s){
        int lastindex = this.program.size()-1;
        String lastLine = this.program.get(lastindex);
        lastLine = lastLine + "\t{-  "+s + "  -}";
        this.program.set(lastindex, lastLine);
    }



    public static void main(String[] args) {
//        convertProgToFile("Fun Int Mult2 Int a Int v {a = a*2 ;return a}\n" +
//                "Fun Int Stupid Int f {Int t = f + f; return t+t} Int a = Mult2 5 4;","");
//        convertProgToFile("Fun Int Mult2 Int a Int v {a = a*2 ;return a}", "/newfile");


//        convertProgToFile("Arr Arr Int a = 5;Int b = 10;", ""); // store and load work

//        convertProgToFile("Int a = 1 + 2 - 2 * 3;", ""); // to check calculations
//        convertProgToFile("Int a = 5; a = 10+ a;",""); // to check asgnline and varExpr

//        convertProgToFile("if true {Int b = 10;}","");
//        convertProgToFile("if 5 {Bool a = true;Int b= 5;} elif 2 {Bool trueurue = true;} else {Int f = 10;}", ""); // to check ifline
//        convertProgToFile("Bool a = false;if a {OutNumber a;} else {OutNumber 2;}","");
        System.out.println(convertProgToFile("Int a = 0; Int b = 5; if a == 0 "+
                "{if b == 4 {OutNumber 10;} else {OutNumber 1;}} elif a == 1 {OutNumber 1;} else {OutNumber 2;}", ""));
    }

    public static String convertProgToFile(String program, String location) {
        GrammarLexer lexer = new GrammarLexer(CharStreams.fromString(program));
        TokenStream tokens = new CommonTokenStream(lexer);
        GrammarParser parser = new GrammarParser(tokens);
        SPRILGenerator generator = new SPRILGenerator();
        generator.visit(parser.program());
        System.out.println("---------------------------");
        System.out.println(program);
        System.out.println("---------------------------");
        if (location.equals("")) {
            location = "temp";
        }
        return generateFile(generator.program, program,location);
    }

    public static final String src = "src\\sprockell\\src\\";
    private static String generateFile(List<String> a, String program, String location) {
        Writer writer;
        String fileloc = null;
        try {
            fileloc = src + location;
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(fileloc+".hs"), StandardCharsets.UTF_8));
            try {
                System.out.println("import Sprockell\n\n");
                System.out.println("--\t" + program);
                System.out.println("prog :: [Instruction]");
                System.out.println("prog = [");
                writer.write("import Sprockell\n\n");
                writer.write("--\t"+ program + "\n");
                writer.write("prog :: [Instruction]\n");
                writer.write("prog = [\n");
                int i;
                for (i=0; i <= a.size()-2; i++) {
                    System.out.println(a.get(i)+ ",");
//                    System.out.println("\n");
                    writer.write(a.get(i) + ",");
                    writer.write("\n");
                }
//                System.out.println("last index: "+ i + (a.size()-1));
                System.out.println(a.get(i));
                writer.write(a.get(i));
                writer.write("\n\t\t\t,EndProg\n\t]");
                System.out.println("\t\t\t,EndProg");
                System.out.println("\t]");
                writer.write("\nmain = run [prog]\n");
                System.out.println("\nmain = run [prog]");
                writer.close();
            } catch (IOException f) {
                f.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (fileloc == null) {
            System.out.println("fileloc = null, should not happen");
        }
        return fileloc;
    }

}
