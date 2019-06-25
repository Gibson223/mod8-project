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
import java.util.*;

public class TypeChecker extends GrammarBaseListener {

//	private HashMap<String, int[]> symbolTable = new HashMap<>();
	private ParseTree parseTree;
	private ParseTreeProperty<ArrayList<Integer>> parseTreeProperty;
	private String error;
	private int errorOffset;
	private int errorEnd;

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
		//TODO: Decide the right thing to use (program() or line() or ...)
		ParseTree tree = grammarParser.program();

		this.parseTreeProperty = new ParseTreeProperty<>();
		this.parseTree = tree;
		new ParseTreeWalker().walk(this, tree);
		ArrayList typeArray = this.parseTreeProperty.get(this.parseTree);
		if (this.error != null) {
			String errorSpot = expression.substring(this.errorOffset, this.errorEnd+1);
			throw new ParseException(this.error + errorSpot + "; Index in input: " + this.errorEnd + "; ", this.errorEnd);
		}

		//TODO: Check typeArray and decide type to return based on that
		return typeString;
	}

//	============================================================
//	----------------------- Expr below -------------------------
//	============================================================

	@Override
	public void exitParensExpr(GrammarParser.ParensExprContext ctx) {
		//take the type between the ( ) and put it in the ParseTree
		ArrayList type = this.parseTreeProperty.get(ctx.getChild(1));
		this.parseTreeProperty.put(ctx, type);
	}

	//TODO: implement way for variables to be checked on type of that var when that symbolTable works
	@Override
	public void exitCompExpr(GrammarParser.CompExprContext ctx) {
		//check if the left and right hand side of the comparison have the same type
		ArrayList left = this.parseTreeProperty.get(ctx.getChild(0));
		ArrayList right = this.parseTreeProperty.get(ctx.getChild(2));
		if (left.size() != right.size())  {
			this.error = "Different types cannot be compared; At: " ;
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		} else {
			for (int i = 0; i < left.size(); i++) {
				if (left.get(i) != right.get(i)) {
					this.error = "Different types cannot be compared; At: " ;
					this.errorOffset = ctx.getStart().getStartIndex();
					this.errorEnd = ctx.getStop().getStopIndex();
				}
			}
		}

		//new type becomes boolean (== [1])
		ArrayList<Integer> type = new ArrayList<>();
		type.add(1);

		this.parseTreeProperty.put(ctx, type);
		if (ctx.exception != null) {
			this.error = "Different types cannot be compared; At: " ;
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}
	}

	@Override
	public void exitMultExpr(GrammarParser.MultExprContext ctx) {
		ArrayList left = this.parseTreeProperty.get(ctx.getChild(0));
		ArrayList right = this.parseTreeProperty.get(ctx.getChild(2));
		if (left.get(0) != )
	}

	//	============================================================
//	----------------------- Target below -----------------------
//	============================================================

	//  TODO: implement with the variable symbol table when it is there
	@Override
	public void exitVarTarget(GrammarParser.VarTargetContext ctx) {

	}

	//  TODO: implement with the variable symbol table when it is there
	@Override
	public void exitArrayTarget(GrammarParser.ArrayTargetContext ctx) {

	}

//	============================================================
//	----------------------- Types below ------------------------
//	============================================================

	@Override
	public void exitInt(GrammarParser.IntContext ctx) {
		//put the integer list belonging to Int (== [0]) in the parseTree
		ArrayList<Integer> type = new ArrayList<>();
		type.add(0);
		this.parseTreeProperty.put(ctx, type);

		//if an exception happened, give an error message and location
		if (ctx.exception != null) {
			this.error = "No valid Int found; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}
	}

	@Override
	public void exitBool(GrammarParser.BoolContext ctx) {
		//put the integer list belonging to Bool (== [1]) in the parseTree
		ArrayList<Integer> type = new ArrayList<>();
		type.add(1);
		this.parseTreeProperty.put(ctx, type);

		//if an exception happened, give an error message and location
		if (ctx.exception != null) {
			this.error = "No valid Bool found; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}
	}

//	@Override
//	public void exitChar(GrammarParser.CharContext ctx) {
//		//put the integer list belonging to Char (== [2]) in the parseTree
//		ArrayList<Integer> type = new ArrayList<>();
//		type.add(2);
//		this.parseTreeProperty.put(ctx, type);
//
//		//if an exception happened, give an error message and location
//		if (ctx.exception != null) {
//			this.error = "No valid Char found; At: ";
//			this.errorOffset = ctx.getStart().getStartIndex();
//			this.errorEnd = ctx.getStop().getStopIndex();
//		}
//	}

	@Override
	public void exitStr(GrammarParser.StrContext ctx) {
		//put the integer list belonging to String (== [3]) in the parseTree
		ArrayList<Integer> type = new ArrayList<>();
		type.add(3);
		this.parseTreeProperty.put(ctx, type);

		//if an exception happened, give an error message and location
		if (ctx.exception != null) {
			this.error = "No valid Str found; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}
	}

	@Override
	public void exitArray(GrammarParser.ArrayContext ctx) {
		//put the integer ArrayList belonging to String (== [3]) in the parseTree
		ArrayList<Integer> type = new ArrayList<>();
		type.add(4);
		type.addAll(this.parseTreeProperty.get(ctx.getChild(1)));
		this.parseTreeProperty.put(ctx, type);

		//if an exception happened, give an error message and location
		if (ctx.exception != null) {
			this.error = "No valid Arr found; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}
	}
}
