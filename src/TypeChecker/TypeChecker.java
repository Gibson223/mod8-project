package TypeChecker;

import Grammar.GrammarBaseListener;
import Grammar.GrammarLexer;
import Grammar.GrammarParser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.text.ParseException;
import java.util.HashMap;

public class TypeChecker extends GrammarBaseListener {

//	private HashMap<String, int[]> symbolTable = new HashMap<>();
	private ParseTree parseTree;
	private ParseTreeProperty<int[]> parseTreeProperty;
	private String error;
	private int erroroffset;
	private int errorend;

//	Types are given in the form of an array.
//	This array declares what the thing or type is in the first index.
//	In the next indices it declares possible subtypes
//
//	The types belonging to each int are as follows:
//	0 = Int
//	1 = Boolean
//	2 = Char
//	3 = String
//	4 = Array
//  TODO: check if number 5 will work this way
//	5 = variable
//
//	Some examples:
//	Int is given as [0]
//	Array Array Int is given as [4, 4, 0]
//	a variable of type Int is given as [5,0]

	public String decideType(String expression) throws ParseException {
		String typeString = null;
		CharStream charStream = CharStreams.fromString(expression);
		Lexer lexer = new GrammarLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		GrammarParser grammarParser = new GrammarParser(tokenStream);
//      TODO: Decide the right thing to use (program() or line() or ...)
		ParseTree tree = grammarParser.program();
		TypeChecker typeChecker = new TypeChecker();
		typeChecker.parseTreeProperty = new ParseTreeProperty<>();
		typeChecker.parseTree = tree;
		new ParseTreeWalker().walk(typeChecker, tree);
		int[] typeArray = typeChecker.parseTreeProperty.get(typeChecker.parseTree);
		if (typeChecker.error != null) {
			String errorSpot = expression.substring(typeChecker.erroroffset, typeChecker.errorend+1);
			throw new ParseException(typeChecker.error + errorSpot + "; Index in input: " + typeChecker.errorend + "; ", typeChecker.errorend);
		}
//		TODO: Check typeArray and decide type to return based on that
		return typeString;
	}

//	============================================================
//	------------------- Basic types below ----------------------
//	============================================================

	@Override
	public void exitInt(GrammarParser.IntContext ctx) {
		//put the integer array belonging to Int (== [0]) in the parseTree
		int[] type = {0};
		this.parseTreeProperty.put(ctx, type);

		//if an exception happened, give an error message and location
		if (ctx.exception != null) {
			this.error = "No valid Int found; At: ";
			this.erroroffset = ctx.getStart().getStartIndex();
			this.errorend = ctx.getStop().getStopIndex();
		}
	}

	@Override
	public void exitBool(GrammarParser.BoolContext ctx) {
		//put the integer array belonging to Bool (== [1]) in the parseTree
		int[] type = {1};
		this.parseTreeProperty.put(ctx, type);

		//if an exception happened, give an error message and location
		if (ctx.exception != null) {
			this.error = "No valid Bool found; At: ";
			this.erroroffset = ctx.getStart().getStartIndex();
			this.errorend = ctx.getStop().getStopIndex();
		}
	}

	@Override
	public void exitStr(GrammarParser.StrContext ctx) {
		//put the integer array belonging to String (== [2]) in the parseTree
		int[] type = {2};
		this.parseTreeProperty.put(ctx, type);

		//if an exception happened, give an error message and location
		if (ctx.exception != null) {
			this.error = "No valid Str found; At: ";
			this.erroroffset = ctx.getStart().getStartIndex();
			this.errorend = ctx.getStop().getStopIndex();
		}
	}

	@Override
	public void exitChar(GrammarParser.CharContext ctx) {
		//put the integer array belonging to Char (== [3]) in the parseTree
		int[] type = {3};
		this.parseTreeProperty.put(ctx, type);

		//if an exception happened, give an error message and location
		if (ctx.exception != null) {
			this.error = "No valid Char found; At: ";
			this.erroroffset = ctx.getStart().getStartIndex();
			this.errorend = ctx.getStop().getStopIndex();
		}
	}
}
