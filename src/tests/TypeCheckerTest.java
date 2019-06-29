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
	public void typesTest() {
		types("Int", true);
		types("Bool", true);
		types("Str", true);
		types("Arr Int", true);
		types("Arr Arr Int", true);
		types("Arr Arr", false);
	}

	@Test
	public void exprTest() {
		expr("(1*1)", true);
		expr("(true)", true);
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
		expr("[1,1+1,1+1+1]", true);
		expr("[true, false, false]", true);
		expr("[\"x\", \"y\", \"z\"]", true);
		expr("[]", false);
		expr("[[],[]]", false);
		expr("[[1],[1]]", true);
		expr("[[1],[(1+1)]]", true);
	}

	private static void types(String s, boolean bool) {
		GrammarParser parser = newParser(s);
		if(bool) {
			assertTrue(noErrors(parser, parser.types(), s));
		} else {
			assertFalse(noErrors(parser, parser.types(), s));
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
			System.out.println("Rejected because of Syntax Error(s) " + s);
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
