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

	@Override
	public void exitCompExpr(GrammarParser.CompExprContext ctx) {
		//check if the left and right hand side of the comparison have the same type
		ArrayList left = this.parseTreeProperty.get(ctx.getChild(0));
		ArrayList right = this.parseTreeProperty.get(ctx.getChild(2));
		if (left.size() != right.size())  {
			this.error = "Different types cannot be compared; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		} else {
			for (int i = 0; i < left.size(); i++) {
				if (!left.get(i).equals(right.get(i))) {
					this.error = "Different types cannot be compared; At: ";
					this.errorOffset = ctx.getStart().getStartIndex();
					this.errorEnd = ctx.getStop().getStopIndex();
					break;
				}
			}
		}

		//new type becomes boolean (== [1])
		ArrayList<Integer> type = new ArrayList<>();
		type.add(1);
		this.parseTreeProperty.put(ctx, type);

		if (ctx.exception != null) {
			this.error = "Different types cannot be compared; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}
	}

	@Override
	public void exitMultExpr(GrammarParser.MultExprContext ctx) {
		ArrayList left = this.parseTreeProperty.get(ctx.getChild(0));
		ArrayList right = this.parseTreeProperty.get(ctx.getChild(2));
		if (!left.get(0).equals(0) || !right.get(0).equals(0)) {
			this.error = "Only Int types can be multiplied; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}

		//new type becomes int (== [0])
		ArrayList<Integer> type = new ArrayList<>();
		type.add(0);
		this.parseTreeProperty.put(ctx, type);

		if (ctx.exception != null) {
			this.error = "Only two Int types can be multiplied; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}
	}

	@Override
	public void exitAddorsubExpr(GrammarParser.AddorsubExprContext ctx) {
		ArrayList left = this.parseTreeProperty.get(ctx.getChild(0));
		ArrayList right = this.parseTreeProperty.get(ctx.getChild(2));
		ArrayList<Integer> type = new ArrayList<>();
		//addition or subtraction
		if (ctx.PLUS().getSymbol() != null) {
			//addition
			if(!(left.get(0).equals(0) && right.get(0).equals(0)) || !(left.get(0).equals(3) && right.get(0).equals(3))) {
				//not both types are int, or not both types are string
				this.error = "Only two Int or two String types can be added; At: ";
				this.errorOffset = ctx.getStart().getStartIndex();
				this.errorEnd = ctx.getStop().getStopIndex();
			}
		} else if (ctx.MIN().getSymbol() != null) {
			//subtraction
			if (!(left.get(0).equals(0) && right.get(0).equals(0))) {
				//not both types are int
				this.error = "Only two Int types can be subtracted; At: ";
				this.errorOffset = ctx.getStart().getStartIndex();
				this.errorEnd = ctx.getStop().getStopIndex();
			}
		}

		//put the right type in the parseTree (even if type checking went wrong to prevent nullpointers)
		if(left.get(0).equals(0)) {
			//type is int
			type.add(0);
		} else {
			//type is string
			type.add(3);
		}
		this.parseTreeProperty.put(ctx, type);

		if (ctx.exception != null) {
			this.error = "Only Int types can be multiplied; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}
	}

	@Override
	public void exitConstExpr(GrammarParser.ConstExprContext ctx) {
		//no types to check, but do put the right type in the parseTree
		ArrayList<Integer> type = new ArrayList<>();
		if(ctx.NUM().getSymbol() != null) {
			type.add(0);
		} else if (ctx.STRING().getSymbol() != null) {
			type.add(3);
		} else {
			type.add(1);
		}
		this.parseTreeProperty.put(ctx, type);

		if (ctx.exception != null) {
			this.error = "No valid constant found; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}
	}

	//  TODO: implement with the variable symbol table when it is there
	@Override
	public void exitArrExpr(GrammarParser.ArrExprContext ctx) {

	}

	//  TODO: implement with the variable symbol table when it is there
	@Override
	public void exitVarExpr(GrammarParser.VarExprContext ctx) {

	}

	@Override
	public void exitListExpr(GrammarParser.ListExprContext ctx) {
		//check if the types at all indices are the same
		ArrayList<Integer> first = this.parseTreeProperty.get(ctx.getChild(1));
		int childCount = ctx.getChildCount();
		if (childCount > 3) {
			for (int i = 3; i < childCount - 1; i += 2) {
				ArrayList current = this.parseTreeProperty.get(ctx.getChild(i));
				if (!first.equals(current)) {
					this.error = "Arrays cannot contain different types; At: ";
					this.errorOffset = ctx.getStart().getStartIndex();
					this.errorEnd = ctx.getStop().getStopIndex();
					break;
				}
			}
		}

		//add an array around the type of the first index
		//put that type in the parseTree
		ArrayList<Integer> type = new ArrayList<>();
		type.add(4);
		type.addAll(first);
		this.parseTreeProperty.put(ctx, type);

		if (ctx.exception != null) {
			this.error = "No valid array found; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}
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
