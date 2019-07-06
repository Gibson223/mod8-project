package codeGeneration;

import Grammar.GrammarBaseVisitor;
import Grammar.GrammarLexer;
import Grammar.GrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static codeGeneration.SPRILGenerator.types.*;
import static codeGeneration.SPRILGenerator.registersAndmemory.*;

public class SPRILGenerator extends GrammarBaseVisitor {
    private List<List<String>> programs;
    private List<String> program;
    private int currLine;
    private int heaptop;
    private symtable symtable;
    private boolean[] registers; // true: register in use, false: register NOT in use
    private HashMap<String, RuleContext> validFunctions;
    private boolean firstTime; // visit functions to save names then
    private int sprockellAndprogID;
    private boolean mergedto1;

    public static final int REGISTER_COUNT = 6;
    private static final boolean DEBUG = false;
    public SPRILGenerator() {
        this.program = new ArrayList<>();
        this.currLine = 0;
        this.heaptop = 0;
        this.validFunctions = new HashMap();
        this.firstTime = true;
        this.registers = new boolean[REGISTER_COUNT];
        this.sprockellAndprogID = 0;
        this.programs = new ArrayList<>();
        this.programs.add(program);

    }

    private void not(int register) {
        int truereg = getemptyreg();
        instr("Load (ImmValue " + "1)" + " " + truereg);
        instr("Compute Xor "+ truereg + " " + register + " " + register);
        clearreg(truereg);
    }


    // unknown heap location
    public String store(int reg) {
        this.heaptop = heaptop +1; // spot for lock on int after it
        return "Store " + reg + " (DirAddr "+ this.heaptop++ + ")"; // heaptop++ increments after so if 100, then store ... 100 and
    }

    // known heap location
    public String store(int reg, int heaplocation) {
        return "Store " + reg + " (DirAddr "+ heaplocation+ ")";
    }

    private int getemptyreg() {
        for (int i = 0; i < 6; i++) {
            if (!registers[i]) { // so register is empty
                registers[i] = true;
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
        this.registers[actualreg] = false;
    }
// ------------------------utility above------------------------
    @Override
    public Object visitProgram(GrammarParser.ProgramContext ctx) {
        this.symtable = new symtable(true);
        for (RuleContext fun: ctx.function() ) {
            visit(fun);
        }
        System.out.println("valid function: "+this.validFunctions.entrySet());
        System.out.println("in program");
        this.firstTime = false;

        for (RuleContext line : ctx.line()) {
            visit(line);
        }
        // to finish remaining threads
        program = programs.get(0); // main thread
        instr("\n\t\t\tNop");
        commment("start of terminateAllNotStartedPrograms");
        terminateAllNotStartedPrograms();
        System.out.println("registers: "+ java.util.Arrays.toString(this.registers));
        return null;
    }

//  ----------------------------concurrency stuff belov -------------------------------------------------
    public int readFromShared (int addr) { // 2 instructions
        int emptyreg = getemptyreg();
        instr(String.format("\n\n\t\t\tReadInstr (DirAddr %s)", addr));
        commment("start readFromShared");
        instr("Receive "+ emptyreg);
        return emptyreg;
    }

    public int writeImmToShared(int value, int addr) { // 2 instructions
        int emptyreg = getemptyreg();
        instr(String.format("\n\n\t\t\tLoad (ImmValue (%s)) " + emptyreg, value));
        commment("start writeImmToShared");
        instr(String.format("WriteInstr %s (DirAddr %s)", emptyreg, addr));
        return emptyreg;
    }

    public void writeRegisterToShared(int register, int addr) { // 2 instructions
        instr(String.format("WriteInstr %s (DirAddr %s)", register, addr));
        commment("end writeREgisterToShared");
        }

    public void looplock (int address) {
        instr(String.format("\n\n\t\t\tTestAndSet (DirAddr %s)",address));
        commment("start of looplock");
        int obtainedlock = getemptyreg();
        instr("Receive "+ obtainedlock);
        instr("Branch "+ obtainedlock + " (Rel 2)");
        instr("Jump (Rel (-3))\n");
        commment("end looplock");
        clearreg(obtainedlock);
    }

    // returns addr where the jump has to be placed to the part when lock not obtained
    public int trylock (int address) {
        instr(String.format("\n\n\t\t\tTestAndSet (DirAddr %s)",address));
        commment("start of trylock");
        int obtainedlock = getemptyreg();
        instr("Receive "+ obtainedlock);
        instr("Branch "+ obtainedlock + " (Rel 2)");
        instr("Jump should be changed, from trylock");
        commment("end trylock");
        clearreg(obtainedlock);
        return currLine -1;
    }

    // returns where the jump should be placed for when there is no match
    private int checkMatchSprockellID(int shmlocation){
        int read_sprockelID = readFromShared(shmlocation);
        commment("read shmemory address as part of checkmatchsprockelid");
        instr("Compute Equal "+ read_sprockelID + " " + regSprockelID + " " + read_sprockelID);
        instr(String.format("Branch %s (Rel 2)", read_sprockelID));
        commment("read sprockell id equals expected sprockellid, so continue after jump");
        clearreg(read_sprockelID);
        instr("Nop");
        return currLine -1;
    }

    public void push (int register) {
        instr("Push " + register);
    }

    public int pop() {
        int emptyreg = getemptyreg();
        instr("Pop " + emptyreg);
        return emptyreg;
    }


    private void activateSprockel(int dedicatedregister){
        int emptyreg = getemptyreg();
        commment("\n\n\t\t\tstart of activateSprockell");
        instr("Load (ImmValue 1) "+ emptyreg);
        instr(String.format("WriteInstr %s (DirAddr %s)", emptyreg,terminatedOrStart) );
        clearreg(emptyreg);
        int poppedsprillid = pop();
        if (DEBUG) {
            instr("WriteInstr "+ poppedsprillid + " numberIO");
            commment("which sprockell should now be activated");
        }
        instr(String.format("WriteInstr %s (DirAddr %s)", poppedsprillid, ProgID));
        // poll to check value changed

        // clearreg(checkPollChanged(poppedsprillid, ProgID)); was on
        clearreg(poppedsprillid);

        instr(String.format("Compute Decr %s %s %s", dedicatedregister, dedicatedregister, dedicatedregister));
        commment("decremented dedicated register for amount of to be activated threads");
        commment("\n\n\t\t\tend of activateSprockell");
    }

    private int checkPollChanged(int written_reg, int globalmemlocation){
        commment("\n\n\t\t\tstart of polling changed value");
        int obtained_value = readFromShared(globalmemlocation);
        instr(String.format("Compute Equal %s %s %s", written_reg, obtained_value, obtained_value));
        instr(String.format("Branch %s (Rel (%s))", obtained_value, -3)); // 3 since readfromshared is 2 instr +1 from compute
        commment("obtained value same as written so poll again");
        clearreg(obtained_value);
        obtained_value = readFromShared(globalmemlocation);
        commment("pulled fresh since reg used in compute above");
        clearreg(written_reg);
        return obtained_value;
    }


    public void terminateAllNotStartedPrograms() { // called by main to terminate uncalled sprockells
        writeImmToShared(1, terminateLoopingStartSprockells);
    }

    public static class registersAndmemory {
        public static final int req_Lock = 0; // 0 or 1
        public static final int req_Type = 1; // shown below
        public static final int req_SprillID = 2;
        public static final int heaplocOrValue = 3; // when writeback it is a value
        public static final int terminateLoopingStartSprockells = 4;
        public static final int startProgLock = 5;
        public static final int ProgID = 6; // same as sprill id
        public static final int terminatedOrStart = 7; // set to 1 if prog to start

        // vaules for shm address 1
        public static final int updaterequest= 0;
        public static final int purerequest = 1;
        public static final int requestAndlock = 2;
        public static final int unlockAndwriteBack = 3;

        public static final int rnone = -1; // no register to return
        public static final int reg0 = 0;
        public static final int regSprockelID = 1; // actual int used for sprockelID
        public static final int rega = 2; // actual int used for regA
        public static final int regb = 3; // actual int used for regA
    }

//  ----------------------------concurrency utility stuff -------------------------------------------------
    private int currParallelThread;
    @Override
    public Object visitParallelLine(GrammarParser.ParallelLineContext ctx) {
        boolean[] register_backup = this.registers;
        int heap_backup = this.heaptop;
        this.currParallelThread = this.sprockellAndprogID;
        int currline_backup = this.currLine;
        List<Integer> sequentialChildThreads = new ArrayList<>();
        for (RuleContext newProg: ctx.sequential()) {
            sequentialChildThreads.add((int) visit(newProg));
        }
        this.currLine = currline_backup;
        int spr_backup = this.currParallelThread;
        this.program = this.programs.get(spr_backup);
        this.heaptop = heap_backup;
        this.registers = register_backup;

        // loading amount of to be activated programs
        int amountstillonstacktobeactivated = getemptyreg();
        int tobeterminatedprograms = getemptyreg(); // starts at amount threads and goes to 0 as well
        instr("\n\n\t\tLoad (ImmValue "+ ctx.sequential().size() + ") "+ amountstillonstacktobeactivated); // to decrement if a child thread is activated
        commment("loaded amount of childs to be spawned into dedicated register\n\n\t\tstart of managing child threads");
        instr("\n\n\t\tLoad (ImmValue "+ ctx.sequential().size() + ") "+ tobeterminatedprograms); // to decrement if a child thread terminated
        commment("amount of threads still needed to be terminated for parallel-handler to terminate");
        int loadregister = getemptyreg();
        for (int i=0; i < sequentialChildThreads.size(); i++) {
            instr(String.format("Load (ImmValue %s) %s", sequentialChildThreads.get(i), loadregister));
            push(loadregister);
        }
        this.currParallelThread = spr_backup;
        clearreg(loadregister);
        //obtain write lock to activate first seq block, is always present according to grammar
//        looplock(startProgLock);
//        activateSprockel(amountstillonstacktobeactivated);

        // startloop
        int startloop = currLine;
        int failedtrylock = trylock(startProgLock);
        // when it did lock, first check if all already started- if all already started then dedicatedregcount is 0
        instr("Branch "+amountstillonstacktobeactivated+" (Rel (4))");// todo actually update: 2 (writeimmshare)+ over nop/jump
        clearreg(writeImmToShared(0, 5));commment("to release proglock");
        instr("nop all threads started jump to after activatesprockell"); // todo figure out end of checrequest
        int startedallProgs = currLine-1;
        activateSprockel(amountstillonstacktobeactivated); // resets occur in sequential
        // end of activating threads
        program.set(failedtrylock, "{-" + failedtrylock + "-}\t\t" + "Jump " + " (Rel " + (currLine - failedtrylock) + ")\t{- jump when trylock failed, going to check for terminated child threads-}");
        program.set(startedallProgs, "{-" + startedallProgs + "-}\t\t" + "Jump " + " (Rel " + (currLine - startedallProgs) + ")\t{- did obtain trylock but no more threads to activate-}");
        // start checking terminated thread
        int noTerminatedChild_jumpToVarRequest = checkMatchSprockellID(ProgID);
        // child thread terminated

        if (DEBUG) {
            instr("WriteInstr "+ tobeterminatedprograms+ " numberIO");
            commment("can be deleted after testing");
        }

        instr(String.format("Compute Decr %s %s %s", tobeterminatedprograms, tobeterminatedprograms, tobeterminatedprograms));commment("decremented amount of child threads needed to be terminated still");
        clearreg(writeImmToShared(0, terminatedOrStart));commment("reset terminateorStart to 0");
        clearreg(writeImmToShared(-1, ProgID));commment("reset progID to -1");
        clearreg(writeImmToShared(0, startProgLock));commment("release lock after read terminatedchild");

        instr("Branch "+ tobeterminatedprograms + "(Rel 2)"); commment("if all terminated jump over all in next jump");
        instr("nop to be replaced to after loop to finish this thread");
        int nop2Tofinishthisprog = currLine-1;

        // start of varrequest, already went through watching terminated thread
        program.set(noTerminatedChild_jumpToVarRequest, "{-" + noTerminatedChild_jumpToVarRequest + "-}\t\t" + "Jump " + " (Rel " + (currLine - noTerminatedChild_jumpToVarRequest) + ")\t{- no terminated child threads, start checkvar-}");

        // what has to be done for varrequest
        instr("Nop"); commment("after checking for terminated child thread \n\n\t\tand start of checking var Request");
        int noVarRequestSoBackToBeginLoop = checkMatchSprockellID(req_SprillID);
        // set back to begin loop
        program.set(noVarRequestSoBackToBeginLoop, "{-" + noVarRequestSoBackToBeginLoop + "-}\t\t" + "Jump " + " (Rel (" + (startloop-(currLine-1)) + "))\t{- jump back to start of loop variable request and terminatethread -}");

        // variable request for this thread
        int requestedHeapLoc = readFromShared(heaplocOrValue);
        //extra checks
        //check if it is locked. then return
        instr(String.format("Compute Decr %s %s %s", requestedHeapLoc, requestedHeapLoc, requestedHeapLoc));
        commment("check location of lock for variable on heap");
        int registerForRequestedVar = getemptyreg();
        instr("Load (IndAddr "+ requestedHeapLoc + ") "+ registerForRequestedVar);
        commment("loading lock value");
        instr(String.format("Branch %s (Rel (%s))"));
        // end extra checks

        instr("Load (IndAddr "+ requestedHeapLoc + ") "+ registerForRequestedVar);
        writeRegisterToShared(registerForRequestedVar, heaplocOrValue);
        clearreg(requestedHeapLoc);
        clearreg(registerForRequestedVar);
        writeImmToShared(-1, req_SprillID);
        instr("Jump (Rel (" + (startloop-currLine) + ") )"); commment("jump back to start of loop for Var Request and terminate/start Thread");

        // to clean up this thread
        program.set(nop2Tofinishthisprog, "{-" + nop2Tofinishthisprog + "-}\t\t" + "Jump " + " (Rel " + (currLine-nop2Tofinishthisprog) + ")\t{- all child progs terminated, finishing this threads tasks -}");
        if (currParallelThread != 0) {
            // when not main thread singal termination to parent thread
            commment("\n\n\t\t\tsending termination signal to parent parallel-handler");
            looplock(startProgLock);
            int parentthread = symtable.currentscope.parentId();
            clearreg(writeImmToShared(1, terminatedOrStart));
            System.out.println("parentthread: "+ parentthread);
            clearreg(writeImmToShared(currParallelThread, ProgID));
        }
        commment("\n\n\n\t\t\tend of parallelLine, continuing after join");
        this.mergedto1 = true;
        return null;
    }

    @Override
    public Object visitSequential(GrammarParser.SequentialContext ctx) {
        // setup
        this.registers = new boolean[REGISTER_COUNT];
        this.heaptop = 0;
        this.currLine = 0;
        this.sprockellAndprogID++;
        this.programs.add(new ArrayList<>());
        this.program = this.programs.get(sprockellAndprogID);
        System.out.println("prog and sprockel ID: " + sprockellAndprogID);


        // let it wait until activated
        int obtained_value = readFromShared(ProgID);
        instr(String.format("Compute Equal %s %s %s", regSprockelID, obtained_value, obtained_value));
        instr(String.format("Branch %s (Rel (%s))", obtained_value, 2));
        clearreg(obtained_value);
        instr(String.format("Jump (Rel (%s))", -4));// 2 from instr above and 2 from readfromShared

        if (DEBUG) {
            instr("WriteInstr 1 numberIO");
            commment("activated thread");
        }
        clearreg(writeImmToShared(-1, ProgID)); // order resets important, otherwise dirty write possiblecommment("reset ProgID");
        clearreg(writeImmToShared(0, terminatedOrStart));commment("reset terminatedOrStarted");
        clearreg(writeImmToShared(0, startProgLock));commment("reset startProgLock, so other threads can signal termination or activation of thread\n\n\t\t\tDone with cleanup start thread");
        // end wait instructions
        symtable.openScope(sprockellAndprogID);
        for (RuleContext line : ctx.line()) {
            visit(line);
        }
        symtable.closeScope();

        commment("\n\n\t\t\tcleanup for thread below");
        looplock(startProgLock);
        clearreg(writeImmToShared(1, terminatedOrStart));
        System.out.println("parentthread: "+ currParallelThread);
        clearreg(writeImmToShared(currParallelThread, ProgID));
        return sprockellAndprogID;
    }

    @Override
    public Object visitLockLine(GrammarParser.LockLineContext ctx) {
        if (ctx.LOCK() != null) {
        } else if (ctx.UNLOCK() != null) {

        } else {
            throw new RuntimeException("no other option than LOCKING or UNLOCKING in lockline");
        }
        return null;
    }



    //  ----------------------------function stuff-------------------------------------------------
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
        switch (ctx.FUNNAME().getSymbol().getText()) {
            case "Nop":
                resultreg = getemptyreg();
                instr("Nop");
                commment("end explicit Nop");
                return resultreg;
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

    @Override
    public Object visitDeclLine(GrammarParser.DeclLineContext ctx) {
        String varname = ctx.VARNAME().getText();
        List<Integer> types = (List<Integer>) visit(ctx.types());
        symtable table = this.symtable;
        // visit the expression, its return value is the register in which the value resides
        if (ctx.ASGN() != null) {
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
            int storedaddr = this.heaptop-1;
            clearreg(value);
            table.add(varname, types,  storedaddr);
            commment("declLine: "+ "varname: "+ varname + " stored at "+ storedaddr +" types: "+ types + " expr: "+ ctx.expr().getText());
            System.out.println("declLine: "+ "varname: "+ varname +" types: "+ types + " expr: "+ ctx.expr().getText());
        } else {
            // in case of type declaration
            System.out.println("should be last print");
            table.currentscope.addType(varname, types);

            // todo: check if this is appropriate solution for nullpointer
            // todo: for (valid) program: Int b; Int c; if true {Int b = 10;} else {Int c = 20;}OutNumber b;
            table.currentscope.addLoc(varname, heaptop++);
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
            instr(store(expr, heaploc));
            clearreg(expr);
            commment("asgnline: "+ "varname: "+ varname + " overwritten at heaploc "+ heaploc +" types: "+ types + " expr: "+ ctx.expr().getText());
        } else {
            int funcallregister = ((int) visit(ctx.functioncall()));
            store(funcallregister, symtable.getHeapLoc(varname));
            clearreg(funcallregister);
        }
        return null;
    }

    @Override
    public Object visitIfLine(GrammarParser.IfLineContext ctx) {
        List<Integer> nopsendblock = new ArrayList<>();
        symtable table = this.symtable;
        for (int i= 0; i < ctx.OCUR().size(); i++) {
            int opencur = ctx.children.indexOf(ctx.OCUR((i)));
            int closecur = ctx.children.indexOf(ctx.CCUR(i));
            int heap_backup = this.heaptop;
            table.openScope(sprockellAndprogID); // todo check needed
            // so if or elif
            int expr = rnone;
            if (! ctx.getChild(opencur-1).getText().equals("else")) {
                expr = (int) visit(ctx.expr(i));
                not(expr);
                instr("Nop");
                commment("jump over if body");
            }
            int nop_index = this.currLine - 1;
            if (expr != rnone) {
                clearreg(expr);
            }
            for (int j = opencur+1; j < closecur; j++) {
                visit(ctx.getChild(j));
            }
            table.closeScope();
            this.heaptop = heap_backup;
            if (! ctx.getChild(opencur-1).getText().equals("else")) {
                program.set(nop_index, "{-" + nop_index + "-}\t\t" + "Branch " + expr + " (Rel " + (currLine+1 - nop_index) + ")\t{- no if/elif conditional jump-}");
                instr("Nop"); // otherwise jump can be after last instruction
                nopsendblock.add(currLine-1);
            }
        }
        instr("Nop");
        for (int nop_instr : nopsendblock) {
            this.program.set(nop_instr, "{-"+ nop_instr + "-}\t\tJump (Rel " + (currLine-1- nop_instr) + ")" + "\t\t\t{- Jump to after if, elif and else statements -}");
        }
        return null;
    }

    @Override
    public Object visitWhileLine(GrammarParser.WhileLineContext ctx) {
        symtable table = symtable;
        int heap_backup = this.heaptop;
        table.openScope(sprockellAndprogID);
        int startwhile = currLine;
        int expr = (int) visit(ctx.expr());
        not(expr);
        instr("Nop");
        commment("jump over while body");
        int nop_index = this.currLine - 1;
        clearreg(expr);
        for (ParseTree line : ctx.line()) {
            visit(line);
        }
        symtable.closeScope();
        this.heaptop = heap_backup;
        System.out.println("startwhile: "+ startwhile);
        System.out.println("currline: "+ currLine);
        instr("Jump (Rel (" + (startwhile-currLine) + ") )");
        commment("jump back to start of while loop");
        instr("Nop");
        commment("after while");
        program.set(nop_index, "{-" + nop_index + "-}\t\t" + "Branch " + expr + " (Rel " + (currLine-1-nop_index) + ")\t{- start while loop -}");
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
        System.out.println("apparent sprockell var: "+ symtable.sprilID(varname));
        System.out.println("symtable id: "+ symtable.sprilID(varname));
        System.out.println("sprockellID: "+ sprockellAndprogID);
        System.out.println("currparallel: "+ currParallelThread);
        System.out.println("mergedto1: "+ mergedto1);
        if (symtable.sprilID(varname) != sprockellAndprogID ^ (mergedto1 && currParallelThread == 0)) { // so variable has to be requested from sprockell where declared
            // set proper values to shared memory addresses, polled last
            System.out.println("trying to request variable");
            clearreg(resultreg);
            int startloop = currLine;
            commment("\n\n\t\t\tstart of loop for varrequest, so when var locked try again");
            looplock(req_Lock);
            clearreg(writeImmToShared(purerequest, req_Type));
            int written_value = writeImmToShared(heaploc, heaplocOrValue);
            clearreg(written_value);
            int written_sprilID = writeImmToShared(symtable.sprilID(varname), req_SprillID); // as last since that one is polled

            // check whether value is locked, if locked new sprillid = -2
            int new_sprill_id = checkPollChanged(written_sprilID,req_SprillID); // set to -22 if locked var
            int expected_when_locked = getemptyreg();
            instr("Load (ImmValue (-2)) "+ expected_when_locked);
            instr(String.format("Compute NEq %s %s %s", new_sprill_id, expected_when_locked, expected_when_locked));
            clearreg(new_sprill_id);
            instr(String.format("Branch %s (Rel (%s))",expected_when_locked, 8 ));
            clearreg(writeImmToShared(0, req_Type));commment("reset since var locked"); // 2 instr
            clearreg(writeImmToShared(0, req_SprillID));commment("reset since var locked"); // 2 instr
            clearreg(writeImmToShared(0, req_Lock));commment("reset since var locked"); // 2 instr
            instr(String.format("Jump (Rel (%s))", startloop- (currLine-1))); // 1 instr
            clearreg(expected_when_locked);
            // var not locked, so proceed normally
            resultreg = readFromShared(heaplocOrValue);
            commment("poll part of regular read of request, since var not locked");
            // reset polled memory address
            clearreg(writeImmToShared(0, req_Type));
            clearreg(writeImmToShared(0, req_Lock));
        } else {
            // variable declared in this sprockell
            System.out.println("variable can be found in own heap");
            instr("Load (DirAddr "+ heaploc + ") "+ resultreg);
        }
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

//  ----------------------------utilities progs-------------------------------------------------

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
        convertProgToFile("Int a = 5; parallel {" +
                "sequential {OutNumber a;}}","");
//                "sequential {Int b = 5; OutNumber b; OutNumber 5;}}","");
//        convertProgToFile("Int a = 4; OutNumber a; OutNumber 4;","");
//        convertProgToFile("Fun Int Mult2 Int a Int v {a = a*2 ;return a}\n" +
//                "Fun Int Stupid Int f {Int t = f + f; return t+t} Int a = Mult2 5 4;","");
//        convertProgToFile("Fun Int Mult2 Int a Int v {a = a*2 ;return a}", "/newfile");


//        convertProgToFile("Arr Arr Int a = 5;Int b = 10;", ""); // store and load work

//        convertProgToFile("Int a = 1 + 2 - 2 * 3;", ""); // to check calculations
//        convertProgToFile("Int a = 5; a = 10+ a;",""); // to check asgnline and varExpr

//        convertProgToFile("if 5 {Bool a = true;Int b= 5;} elif 2 {Bool trueurue = true;} else {Int f = 10;}", ""); // to check ifline
//        convertProgToFile("Bool a = false;if a {OutNumber a;} else {OutNumber 2;}","");

//        System.out.println(convertProgToFile("Int a = 0; Int b = 5; if a == 0 "+
//                "{if b == 4 {OutNumber 10;} else {OutNumber 1;}} elif a == 1 {OutNumber 1;} else {OutNumber 2;}", ""));
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
        return generator.generateFile(generator.programs, program,location);
    }

    public static final String src = "src\\sprockell\\src\\";
    private String generateFile(List<List<String>> programs, String program, String location) {
        Writer writer;
        String fileloc = null;
        try {
            fileloc = src + location;
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(fileloc+".hs"), StandardCharsets.UTF_8));
            try {
                writer.write("import Sprockell\n\n");
                writer.write("--\t" + program + "\n");
                String allProgs = "";
                for (int prog=0; prog < programs.size(); prog++) {
                    writer.write("\n\nprog"+ prog+ " :: [Instruction]\n");
                    writer.write("\nprog"+ prog + " = [\n");
                    allProgs += "prog"+ prog+ ",";
                    List<String> proglines = programs.get(prog);
                    for (int i = 0; i <= proglines.size()-1; i++) {
                        writer.write(proglines.get(i) + ",");
                        writer.write("\n");
                    }
                    writer.write("\t\t\tEndProg\n\t\t]");
                }
                allProgs = allProgs.substring(0, allProgs.length()-1);
                writer.write("\nmain = run ["+allProgs+ "]\n");
                writer.write("\n\nmain2 = runWithDebugger (debuggerSimplePrintAndWait myShow) ["+allProgs+"]");
                writer.write("\n\nmain3 = runWithDebugger (debuggerPrintCondWaitCond showLocalMem doesLocalMemWrite never) ["+allProgs+"]");


                writer.write("\n\nshowLocalMem :: DbgInput -> String\n" +
                        "showLocalMem ( _ , systemState ) = show $ localMem $ head $ sprStates systemState");
                writer.write("\n\ndoesLocalMemWrite :: DbgInput -> Bool\n" +
                        "doesLocalMemWrite (instrs,st) = any isStoreInstr instrs\n" +
                        "    where\n" +
                        "        isStoreInstr (Store _ _) = True\n" +
                        "        isStoreInstr _ = False");
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
