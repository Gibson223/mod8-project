package tests;

import Grammar.GrammarLexer;
import Grammar.GrammarParser;
import org.antlr.v4.runtime.*;
import org.junit.Test;

import static org.junit.Assert.*;
public class LexerTest {
    @Test
    public void functionTest() {
        // without returns
        // no type for input
        wrongfun("Fun Name arg1 arg2 {Int x = 19;a[5] = 10;}");
        correctfun("Fun Name Int arg1 Bool arg2 {Int x = 19;a[5] = 10;}");
        correctfun("Fun Name Int arg1 Bool arg2 {\n" +
                    "   x = 1;" +
                    "   parallel {" +
                    "       sequential {lock x;x = 4;unlock x;y = 2;z = 3;}\n" +
                    "   }"+
                    "}");
        correctfun("Fun Name Str arg1 Arr Int arg2 {\n" +
                        "in = 4;\n" +
                        "}");
        // with returns
        // without type for input
        wrongfun("Fun Int Name arg1 arg2 {Int x = 19;a[5] = 10;}");
        correctfun("Fun Int Name Int arg1 Bool arg2 {Int x = 19;a[5] = 10;}");
        correctfun("Fun Bool Name {\n" +
                    "   x = 1;" +
                    "   parallel {" +
                    "       sequential {lock x;x = 4;unlock x;y = 2;z = 3;}\n" +
                    "   }" +
                    "   return x"+
                    "}");
        correctfun("Fun Arr Int Name Str arg1 Str arg2 {\n" +
                        "in = 4;\n" +
                        "return in\n" +
                        "}");
    }

    @Test
    public void returnTest() {
        String validproglines = "Fun Name Int arg1 Str arg2 Bool arg3 { Int a = 4; Bool c = true; parallel {sequential {Int a=10;}}";
        correctfun(validproglines +"return x}");
        wrongfun(validproglines +"Return x}");
        wrongfun(validproglines +"return x,y,z;}");
        wrongfun(validproglines +"return x[1,2];}");
        wrongfun(validproglines +"return Int x = 7;}");
    }

    //^^^^^^^^^^^^^^^^^^^^functionTests^^^^^^^^^^^^^^^^
    @Test //#ifLine
    public void ifTest(){
        // empty and filled bodies different exprs + optional else
        correctline("if a[0] {} elif b[a] {} elif c[i] {}");
        // optional elif
        correctline("if true {Bool omfd;} else {Int a;}");
        // diff amount of elifs
        correctline("if 5 {for i; i > 10 ; i = i -5; {a =10;}}");
        // mandatory if
        wrongline("else {Int a = 5}");
        wrongline("elif 5 {Bool b = 7;} ");

    }

    @Test //#forLine
    public void forTest() {
        // already declared var
        correctline("for i; i < 10; i = i+1; {Int a = 5;}");
        // init with assign
        correctline("for Int i = 5; i < a; i = i+1; {Arr Int a = [1,2,3];}");
        // initialization without assignment, so i = 0
        // this was the result of discussion/ default typechecker error
        wrongline("for Int i; i < 10; i = i+1; {Int a = 5;}");
        // reassignment
        wrongline("for i = 5; i < 10; i = i+1; {Int a = 5;}");
        correctline("for Int i = 5; i < 10; i = i+1; {Int a = 5;}");
        // incorrect types
        wrongline("for Bool a; i < 10; i = i+1; {Int a = 5;}");
        wrongline("for Arr Bool a; i < 10; i = i+1; {Int a = 5;}");
        //empty for body
        correctline("for Int a= 10; i < 10; i = i+1; {}");
    }

    @Test
    public void whileTest() {
        correctline("while a[0] < 10 {}");
        correctline("while true {parallel {sequential {Int a = 5;}}}");
        wrongline("while true; {sequential {parallel {Int a = 5;}}}");
        wrongline("while {}");
        correctline("while true {}");
    }
    @Test //#parallelLine
    public void parallelTest() {
        // empty
        wrongline("parallel {}");
        // invalid nesting parallel
        wrongline("parallel {sequential { parallel {OutNumber 10;}}}");
        // valid parallel nesting
        correctline("parallel {sequential {parallel {sequential {Int a =5;}}}}");
        // parallel with lines
        correctline("parallel {sequential { Int a = 5; Bool s;}}");
    }

    @Test //#sequentialLine
    public void sequentialTest() {
        // empty
        correctline("parallel {sequential {Int a;}}");
        wrongline("sequential {}");
        // invalid nesting sequential
        wrongline("sequential {sequential {Bool a = 10;}}");
        // sequential with lines
        wrongline("sequential { Int a = 5; Bool s;}");
    }

    @Test //#decLine & asgnLine
    public void TypeAndAssign() {
        correctline("Int a = 10;Int b; Int c = a;");
        correctline("Int a= 5;");
        correctline("Bool a= c;");

        wrongline("in t =23;");
        wrongline("Bool a == 4;");
        wrongline("Int a");
        // str is a valid varname
        correctline("str = 5;");
        correctline("Str a = \"lalala\";");
        correctline("Str a = \"a\"; Str b = \"b\"; aAndb = \"ab\"");
        wrongline("Str a aaaa;");
        wrongline("l = 'lala\";");
        correctline("l = \"lalala\";");

        // arrays
        correctline("Bool a = [1,2,3];"); //this is allowed here, will be rejected by TypeChecker
        wrongline("Bool a = 5");
        wrongline("Arr Int a = []");
        correctline("Arr Int a = [1];Arr Int a = c;");

        correctline("Arr Int a = [1,2,3,4];");
        wrongline("Arr Int a = 1 2 3 ;");

        // function assignment
        correctline("Int a = Fib 5;");
        wrongline("Str a, b  = Tuple a b ;");
        wrongline("Arr Str a[0]  = Tuple a b ;");
        correctline("Arr Str a  = Tuple a b ;");
        wrongline("Str a, b  = Tuple a b ");
    }

    @Test  //#declLine
    public void declTest() {
        correctline("Int a;Int b; Int c;");
        correctline("Int a;");
        correctline("Bool a;");
        correctline("Bool a;");
        correctline("Str a;");
        correctline("Arr Int a;");
        correctline("Int a;Arr Int a;");
        wrongline("Int a");

        wrongline("str;");
        wrongline("in t a;");
        wrongline("arr t ;");
    }

    @Test //# asgnLine
    public void assignTest() {
        correctline("a = 5;");
        wrongline("a a int; ");
        wrongline("a - 5;");
        correctline("a[0] = 5;");
    }

    @Test
    public void lockTest() {
        correctline("lock x;");
        correctline("unlock x;");
        // seen as a valid
        correctline("Unlock x;");
        wrongline("lock Int x = 5;");
        wrongline("lock Bool x = [1,2,3,4]");
    }

    //^^^^^^^^^^^^^^^^^^^^LineTests^^^^^^^^^^^^^^^^
    @Test
    public void exprTest() {
        // parens
        correctexpr("(1)");
        correctexpr("(1+2)");
        // comp
        correctexpr("1 == 2");
        correctexpr("1 != 2");
        correctexpr("1 < 2");
        correctexpr("1 > 2");
        correctexpr("1 >= 2");
        correctexpr("1 <= 2");
        // mult
        correctexpr("1*(2)");
        // const
        correctexpr("34342");
        correctexpr("111111");
        correctexpr("1,2,3,4"); // correct here, will be rejected later on if not inside array
        correctexpr("true");
        correctexpr("false");
        //arr
        correctexpr("a[1]");
        //var
        correctexpr("a");
        wrongexpr("1+=2");
        //list
        correctexpr("[1,23,3,4,5]");
        wrongexpr("[1,2,23,3,4,5");
        wrongexpr("[1,23,4,5,6,7,]");
    }


    //^^^^^^^^^^^^^^^^^^^^exprTest^^^^^^^^^^^^^^^^
    public static void correctfun(String s) {
        GrammarParser parser = newParser(s);
        parser.function();
        assertTrue(check(parser));
    }

    public static void wrongfun(String s){
        GrammarParser parser = newParser(s);
        parser.function();
        assertFalse(check(parser));
    }

    public static void correctline(String s) {
        GrammarParser parser = newParser(s);
        parser.line();
        assertTrue(check(parser));
    }

    public static void wrongline(String s){
        GrammarParser parser = newParser(s);
        parser.line();
        assertFalse(check(parser));
    }

    public static void correctexpr(String s) {
        GrammarParser parser = newParser(s);
        parser.expr();
        assertTrue(check(parser));
    }

    public static void wrongexpr(String s){
        GrammarParser parser = newParser(s);
        parser.expr();
        assertFalse(check(parser));
    }

    private static GrammarParser newParser(String s) {
        CharStream stream = CharStreams.fromString(s);
        Lexer lexer = new GrammarLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammarParser parser = new GrammarParser(tokens);
        parser.removeErrorListeners();
        return parser;
    }

    private static boolean check(Parser parser) {
//        System.out.println(parser.getNumberOfSyntaxErrors());
        return parser.getNumberOfSyntaxErrors() == 0;
    }

}
