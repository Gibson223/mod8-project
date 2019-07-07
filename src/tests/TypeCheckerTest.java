package tests;

import Grammar.GrammarLexer;
import Grammar.GrammarParser;
import TypeChecker.TypeChecker;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TypeCheckerTest {

	@Test
	public void programTest(){
		program("Int a = 3; if a == 3 {}", true);
		program("Int a; if a == 3 {}", true);
		program("Int a = 3; if a == 3 {a = 1;}", true);

		program("Bool t = true; while t {t = false;}", true);

		program("Bool t = true; while t {lock t; t = false; unlock t;}", true);

		program("Int i = 0; Int i2 = i;", true);
		program("Bool b = true; Bool b2 = b;", true);
		program("Str s = \"str\"; Str s2 = s;", true);
		program("Arr Int ai = [0]; Arr Int ai2 = ai;", true);
		program("Int i = 0; Bool i2 = i;", false);
		program("Bool b = true; Str b2 = b;", false);
		program("Str s = \"str\"; Arr Int s2 = s;", false);
		program("Arr Int ai = [0]; Int ai2 = ai;", false);
		program("Int i = i;", false);
		program("Bool b = b;", false);
		program("Str s = s1;", false);
		program("Arr Int ai = ai1;", false);
		program("Int i; i = 1;", true);
		program("Bool b; b = true;", true);
		program("Str s; s = \"str\";", true);
		program("Arr Int ai; ai = [0];", true);

		program("Int i = 0; Bool b = true; parallel { " +
				"sequential {Str a = \"test\"; a = \"notest\"; " +
				"if b {i = 20;} else {a = \"nope\";}}}", true);
		program("parallel {Int i = 0; Bool b = true; " +
				"sequential {Str a = \"test\"; a = \"notest\";}} " +
				"if b {i = 20;} else {a = \"nope\";}", false);

		program("Int i = 0; Bool check = true; " +
				"while check {if i < 3 {i = i + 1;} elif i < 20 {i = i + 5;} else {check = false;}}", true);
		program("Int i = 0; Bool check = true; " +
				"while check {if i < 3 {i = i + 1} elif i < 20 {i = i + 5;} else {check = false;}}", false);
		program("Int i = 0; Bool check = true; " +
				"while check {if i < 3 {i = i + 1;} elif i < 20 {i = i + 5;} else {i = false;}}", false);
	}

	@Test
	public void lineTest() {
		line("if true {}", true);
		line("if false {} elif true {}", true);
		line("if true {} elif true {} elif false {}", true);
		line("if 3 == 5 {} elif 3 < 5 {} elif 3 > 5 {} else {}", true);
		line("if true {} else {}", true);
		line("if 5 {}", false);
		line("elif true {}", false);
		line("else {}", false);
		line("if true {} elif {}", false);
		line("if true {} else if true {}", false);

//		for lines not supported for now
//		line("for Int i = 0; 1 < 3; i = i+1; {}", true);

		line("while true {}", true);
		line("while 1 < 2 {}", true);
		line("while \"x\" {}", false);
		line("while [1,2,3] {}", false);
		line("while true", false);

		line("parallel {Int i = 0;}", false);
		line("parallel {}", false);
		line("parallel", false);

		line("sequential {Int i = 0;}", false);
		line("sequential {}", false);
		line("sequential", false);

		line("Int i = 0;", true);
		line("Int i;", true);
		line("Int i = 0", false);
		line("Int i = true;", false);
		line("Bool b = true;", true);
		line("Bool b;", true);
		line("Bool b = 0;", false);
		line("Bool = 0;", false);
		line("Bool Wrong = false;", false);
		line("Str s = \"hey\";", true);
		line("Str s;", true);
		line("Str s = 1;", false);
		line("Arr Int a = [1];", true);
		line("Arr a = [1];", false);
		line("Arr Arr Int a = [[1]];", true);
		line("Arr Arr Int a;", true);
		line("Arr Arr Bool aab;", true);
		line("Arr Arr Bool aab = [[true]];", true);
		line("Arr Arr = [[],[]];", false);

		line("Int i;", true);
		line("Int i = 1;", true);
		line("Int i = true;", false);
		line("Bool b;", true);
		line("Bool b = true;", true);
		line("Bool b = \"false\";", false);
		line("Str s;", true);
		line("Str s = \"sting\";", true);
		line("Str s = [1,2];", false);
		line("Str s = [1,2];", false);
		line("Arr Int ai;", true);
		line("Arr Int ai = [1,2];", true);
		line("Arr = [1]", false);
		line("Arr = [1]", false);

		line("lock ;", false);
		line("unlock ;", false);

		line("Bool b = 3<3;", true);
		line("Bool b = 3<=3;", true);
		line("Bool b = 3>3;", true);
		line("Bool b = 3>=3;", true);
		line("Bool b = 3==3;", true);
		line("Bool b = 3!=3;", true);
		line("Bool b = 3=3;", false);
		line("Bool b = 3=>3;", false);
		line("Bool b = 3=<3;", false);

//		function calls not supported for now
	}

	@Test
	public void exprTest() {
		expr("(1*1)", true);
		expr("(true)", true);
		expr("(false", false);
		expr("1*1", true);
		expr("1*\"hello\"", false);
		expr("1+1", true);
		expr("\"x\" + \"y\"", true);
		expr("1+false", false);
		expr("1+1*3", true);
		expr("(1+1)*3", true);
		expr("1-1", true);
		expr("\"x\" - \"y\"", false);
		expr("1-true", false);
		expr("1-1*3", true);
		expr("(1-1)*3", true);

		expr("[1]", true);
		expr("[1,2,3]", true);
		expr("[1,2,true]", false);
		expr("[1,2,]", false);
		expr("[1,1+1,1+1+1]", true);
		expr("[true, false, false]", true);
		expr("[\"x\", \"y\", \"z\"]", true);
		expr("[]", false);
		expr("[[],[]]", false);
		expr("[[1],[1]]", true);
		expr("[[1],[(1+1)]]", true);
	}

	@Test
	public void typesTest() {
		types("Int", true);
		types("Bool", true);
		types("Str", true);
		types("Arr Int", true);
		types("Arr Arr Int", true);
		types("Arr Arr", false);
	}

	private static void program(String s, boolean bool) {
		GrammarParser parser = newParser(s);
		if(bool) {
			assertTrue(noErrors(parser, parser.program(), s));
		} else {
			assertFalse(noErrors(parser, parser.program(), s));
		}
	}

	private static void line(String s, boolean bool) {
		GrammarParser parser = newParser(s);
		if(bool) {
			assertTrue(noErrors(parser, parser.line(), s));
		} else {
			assertFalse(noErrors(parser, parser.line(), s));
		}
	}

	private static void expr(String s, boolean bool) {
		GrammarParser parser = newParser(s);
		if(bool) {
			assertTrue(noErrors(parser, parser.expr(), s));
		} else {
			assertFalse(noErrors(parser, parser.expr(), s));
		}
	}

	private static void types(String s, boolean bool) {
		GrammarParser parser = newParser(s);
		if(bool) {
			assertTrue(noErrors(parser, parser.types(), s));
		} else {
			assertFalse(noErrors(parser, parser.types(), s));
		}
	}

	private static GrammarParser newParser(String s) {
		CharStream stream = CharStreams.fromString(s);
		Lexer lexer = new GrammarLexer(stream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		GrammarParser parser = new GrammarParser(tokens);
		parser.removeErrorListeners();
		return parser;
	}

	private static boolean noErrors(Parser parser, ParseTree parseTree, String s) {
		if (parser.getNumberOfSyntaxErrors() != 0) {
			System.out.println("Rejected because of Syntax Error(s): " + s);
			return false;
		} else {
			ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
			TypeChecker typeChecker = new TypeChecker();
			parseTreeWalker.walk(typeChecker, parseTree);

			if(!typeChecker.typeCorrect()) {
				System.out.println("Rejected because of Type Error(s) -> " + typeChecker.getError(s));
				return false;
			} else {
				return true;
			}
		}
	}
}
