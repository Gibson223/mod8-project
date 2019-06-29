package TypeChecker;

import Grammar.GrammarBaseListener;
import Grammar.GrammarLexer;
import Grammar.GrammarParser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.*;
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
	private SymbolTable variableTable = new SymbolTable(true);

//	Types are given in the form of an array.
//	This array declares what the thing or type is in the first index.
//	In the next indices it declares possible subtypes
//
//	The types belonging to each int are as follows:
//	0 = Int
//	1 = Boolean
//	2 = Char (currently unused)
//	3 = String
//	4 = Array
//
//	Some examples:
//	Int is given as [0]
//	Array Array Int is given as [4, 4, 0]

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

	public TypeChecker() {
		this.parseTreeProperty = new ParseTreeProperty<>();
	}

	public String getError() {
		return this.error + " " + this.errorOffset + " - " + this.errorEnd;
	}

	public String getError(String expression) {
		String errorSpot = expression.substring(this.errorOffset, this.errorEnd+1);
		return this.error + errorSpot + "; Index in input: " + this.errorEnd + ";";
	}

	public boolean typeCorrect() {
		return this.error == null;
	}

//	============================================================
//	--------------------- Function below -----------------------
//	============================================================

	@Override
	public void exitFunction(GrammarParser.FunctionContext ctx) {
		//if a typeError already occurred, then just return
		if(error != null) {
			return;
		}

		String funName = ctx.FUNNAME().getSymbol().getText();
		ArrayList<Integer> funType = null;
	}

// 	============================================================
//	----------------------- Line below -------------------------
//	============================================================

	@Override
	public void enterIfLine(GrammarParser.IfLineContext ctx) {
		//if a typeError already occurred, then just return
		if(error != null) {
			return;
		}

		variableTable.openScope();
	}
	//TODO: check if the for loop with expr works as expected
	@Override
	public void exitIfLine(GrammarParser.IfLineContext ctx) {
		//if a typeError already occurred, then just return
		if(error != null) {
			return;
		}

		List<GrammarParser.ExprContext> exprs = ctx.expr();
		for(GrammarParser.ExprContext expr : exprs) {
			ArrayList type = this.parseTreeProperty.get(expr);
			if(!type.get(0).equals(1)) {
				this.error = "If or Elif conditions have to be a boolean; At: ";
				this.errorOffset = ctx.getStart().getStartIndex();
				this.errorEnd = ctx.getStop().getStopIndex();
			}
		}
		//nothing to put in the parseTree
		variableTable.closeScope();

		if (ctx.exception != null) {
			this.error = "No valid If found; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}
	}

	@Override
	public void enterForLine(GrammarParser.ForLineContext ctx) {
		//if a typeError already occurred, then just return
		if(error != null) {
			return;
		}

		variableTable.openScope();
		String varName = ctx.VARNAME(0).getSymbol().getText();
		//in for, the type of the declared var should always be an int
		ArrayList<Integer> type = new ArrayList<>();
		type.add(0);
		variableTable.add(varName, type);
	}
	//TODO: second varname check
	@Override
	public void exitForLine(GrammarParser.ForLineContext ctx) {
		//if a typeError already occurred, then just return
		if(error != null) {
			return;
		}

		if(ctx.INT() != null) {
			ArrayList<Integer> type = this.parseTreeProperty.get(ctx.getChild(4));
			if(!type.get(0).equals(1)) {
				this.error = "No valid For loop found; At: ";
				this.errorOffset = ctx.getStart().getStartIndex();
				this.errorEnd = ctx.getStop().getStopIndex();
			}
		} else {
			//TODO: check if the varname will always work this way
			String varName = ctx.VARNAME(0).getSymbol().getText();
			if (variableTable.contains(varName)) {
				ArrayList<Integer> type = variableTable.getType(varName);
				this.parseTreeProperty.put(ctx,type);
			} else {
				this.error = "Variable does not exist; At: ";
				this.errorOffset = ctx.getStart().getStartIndex();
				this.errorEnd = ctx.getStop().getStopIndex();
			}
		}
		variableTable.closeScope();

		if (ctx.exception != null) {
			this.error = "No valid For loop found; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}
	}

	@Override
	public void enterWhileLine(GrammarParser.WhileLineContext ctx) {
		//if a typeError already occurred, then just return
		if(error != null) {
			return;
		}

		variableTable.openScope();
	}
	@Override
	public void exitWhileLine(GrammarParser.WhileLineContext ctx) {
		//if a typeError already occurred, then just return
		if(error != null) {
			return;
		}

		ArrayList type = this.parseTreeProperty.get(ctx.getChild(1));
		if(!type.get(0).equals(1)) {
			this.error = "While loop condition has to be a boolean; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}
		//nothing to put in the parseTree
		variableTable.closeScope();

		if (ctx.exception != null) {
			this.error = "No valid While loop found; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}
	}

	@Override
	public void enterParallelLine(GrammarParser.ParallelLineContext ctx) {
		//if a typeError already occurred, then just return
		if(error != null) {
			return;
		}

		variableTable.openScope();
	}
	@Override
	public void exitParallelLine(GrammarParser.ParallelLineContext ctx) {
		//if a typeError already occurred, then just return
		if(error != null) {
			return;
		}

		//nothing to typecheck
		variableTable.closeScope();
	}

	@Override
	public void enterSequentialLine(GrammarParser.SequentialLineContext ctx) {
		//if a typeError already occurred, then just return
		if(error != null) {
			return;
		}

		variableTable.openScope();
	}
	@Override
	public void exitSequentialLine(GrammarParser.SequentialLineContext ctx) {
		//if a typeError already occurred, then just return
		if(error != null) {
			return;
		}

		//nothing to typecheck
		variableTable.closeScope();
	}

	@Override
	public void exitDeclLine(GrammarParser.DeclLineContext ctx) {
		//if a typeError already occurred, then just return
		if(error != null) {
			return;
		}

		ArrayList<Integer> type = this.parseTreeProperty.get(ctx.getChild(0));
		if(ctx.getChildCount() != 3) {
			ArrayList<Integer> assignType = this.parseTreeProperty.get(ctx.getChild(3));
			if (!type.equals(assignType)) {
				this.error = "Cannot assign to declared variable, wrong variable type; At: ";
				this.errorOffset = ctx.getStart().getStartIndex();
				this.errorEnd = ctx.getStop().getStopIndex();
			}
		}
		this.parseTreeProperty.put(ctx, type);
		//add the newly declared variable to the variableTable
		String varName = ctx.VARNAME().getSymbol().getText();
		variableTable.add(varName, type);

		if (ctx.exception != null) {
			this.error = "No valid declaration found; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}
	}

	@Override
	public void exitAsgnLine(GrammarParser.AsgnLineContext ctx) {
		//if a typeError already occurred, then just return
		if(error != null) {
			return;
		}

		ArrayList<Integer> varType = this.parseTreeProperty.get(ctx.getChild(0));
		ArrayList<Integer> assignType = this.parseTreeProperty.get(ctx.getChild(2));
		if (!varType.equals(assignType)) {
			this.error = "Cannot assign to this variable, wrong variable type; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}
		this.parseTreeProperty.put(ctx, varType);

		if (ctx.exception != null) {
			this.error = "No valid assignment found; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}
	}

	@Override
	public void exitLockLine(GrammarParser.LockLineContext ctx) {
		//if a typeError already occurred, then just return
		if(error != null) {
			return;
		}

		String varName = ctx.VARNAME().getSymbol().getText();
		if(!variableTable.contains(varName)) {
			this.error = "Variable does not exist; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}

		if (ctx.exception != null) {
			this.error = "No valid variable to lock or unlock; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}
	}

	//TODO: check and change
	@Override
	public void exitFuncallLine(GrammarParser.FuncallLineContext ctx) {
		//if a typeError already occurred, then just return
		if(error != null) {
			return;
		}

		//get the (return)type of the function and put it in the parseTree
		ArrayList<Integer> type = this.parseTreeProperty.get(ctx.getChild(0));
		this.parseTreeProperty.put(ctx, type);

		if (ctx.exception != null) {
			this.error = "No valid variable to lock; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}
	}

// 	============================================================
//	----------------------- Expr below -------------------------
//	============================================================

	@Override
	public void exitParensExpr(GrammarParser.ParensExprContext ctx) {
		//if a typeError already occurred, then just return
		if(error != null) {
			return;
		}

		//take the type between the ( ) and put it in the ParseTree
		ArrayList<Integer> type = this.parseTreeProperty.get(ctx.getChild(1));
		this.parseTreeProperty.put(ctx, type);

		if (ctx.exception != null) {
			this.error = "No valid parentheses expression; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}
	}

	@Override
	public void exitCompExpr(GrammarParser.CompExprContext ctx) {
		//if a typeError already occurred, then just return
		if(error != null) {
			return;
		}

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
		//if a typeError already occurred, then just return
		if(error != null) {
			return;
		}

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
		//if a typeError already occurred, then just return
		if(error != null) {
			return;
		}

		ArrayList left = this.parseTreeProperty.get(ctx.getChild(0));
		ArrayList right = this.parseTreeProperty.get(ctx.getChild(2));
		ArrayList<Integer> type = new ArrayList<>();
		//addition or subtraction
		if (ctx.PLUS() != null) {
			//addition
			boolean leftEqualsRightInt = left.get(0).equals(0) && right.get(0).equals(0);
			boolean leftEqualsRightString = left.get(0).equals(3) && right.get(0).equals(3);
			if(!leftEqualsRightInt && !leftEqualsRightString) {
				//not both types are int, or not both types are string
				this.error = "Only two Int or two String types can be added; At: ";
				this.errorOffset = ctx.getStart().getStartIndex();
				this.errorEnd = ctx.getStop().getStopIndex();
			}
		} else if (ctx.MIN() != null) {
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
			this.error = "Only two Int types can be multiplied; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}
	}

	@Override
	public void exitConstExpr(GrammarParser.ConstExprContext ctx) {
		//if a typeError already occurred, then just return
		if(error != null) {
			return;
		}

		//no types to check, but do put the right type in the parseTree
		ArrayList<Integer> type = new ArrayList<>();
		if(ctx.NUM() != null) {
			type.add(0);
		} else if(ctx.STRING() != null) {
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

	@Override
	public void exitArrExpr(GrammarParser.ArrExprContext ctx) {
		//if a typeError already occurred, then just return
		if(error != null) {
			return;
		}

		String varName = ctx.VARNAME().getSymbol().getText();
		if(variableTable.contains(varName)) {
			ArrayList<Integer> type = variableTable.getType(varName);
			if(!type.get(0).equals(4)) {
				ArrayList<Integer> newType = new ArrayList<>(type.subList(1, type.size()));
				this.parseTreeProperty.put(ctx, type);
			} else {
				this.error = "Variable is not an Arr; At: ";
				this.errorOffset = ctx.getStart().getStartIndex();
				this.errorEnd = ctx.getStop().getStopIndex();
			}
		} else {
			this.error = "Variable does not exist; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}
		//TODO: will currently give nullpointer exceptions if the variable does not exist as no type can be put in the parseTree

		if (ctx.exception != null) {
			this.error = "No valid Arr variable found; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}
	}

	@Override
	public void exitVarExpr(GrammarParser.VarExprContext ctx) {
		//if a typeError already occurred, then just return
		if(error != null) {
			return;
		}

		String varName = ctx.VARNAME().getSymbol().getText();
		if(variableTable.contains(varName)) {
			ArrayList<Integer> type = variableTable.getType(varName);
			this.parseTreeProperty.put(ctx,type);
		} else {
			this.error = "Variable does not exist; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}
		//TODO: will currently give nullpointer exceptions if the variable does not exist as no type can be put in the parseTree

		if (ctx.exception != null) {
			this.error = "No valid variable found; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}
	}

	@Override
	public void exitListExpr(GrammarParser.ListExprContext ctx) {
		//if a typeError already occurred, then just return
		if(error != null) {
			return;
		}

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

	@Override
	public void exitVarTarget(GrammarParser.VarTargetContext ctx) {
		//if a typeError already occurred, then just return
		if(error != null) {
			return;
		}

		String varName = ctx.VARNAME().getSymbol().getText();
		if(variableTable.contains(varName)) {
			ArrayList<Integer> type = variableTable.getType(varName);
			this.parseTreeProperty.put(ctx,type);
		} else {
			this.error = "Variable does not exist; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}
		//TODO: will currently give nullpointer exceptions if the variable does not exist as no type can be put in the parseTree

		if (ctx.exception != null) {
			this.error = "No valid variable found; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}
	}

	@Override
	public void exitArrayTarget(GrammarParser.ArrayTargetContext ctx) {
		//if a typeError already occurred, then just return
		if(error != null) {
			return;
		}

		String varName = ctx.VARNAME().getSymbol().getText();
		if(variableTable.contains(varName)) {
			ArrayList<Integer> type = variableTable.getType(varName);
			if(!type.get(0).equals(4)) {
				ArrayList<Integer> newType = new ArrayList<>(type.subList(1, type.size()));
				this.parseTreeProperty.put(ctx, type);
			} else {
				this.error = "Variable is not an Arr; At: ";
				this.errorOffset = ctx.getStart().getStartIndex();
				this.errorEnd = ctx.getStop().getStopIndex();
			}
		} else {
			this.error = "Variable does not exist; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}
		//TODO: will currently give nullpointer exceptions if the variable does not exist as no type can be put in the parseTree

		if (ctx.exception != null) {
			this.error = "No valid Arr variable found; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}
	}

//	============================================================
//	-------------------- Functioncall below --------------------
//	============================================================

	//TODO: implement
	@Override
	public void exitFunctioncall(GrammarParser.FunctioncallContext ctx) {
		//if a typeError already occurred, then just return
		if(error != null) {
			return;
		}
	}

// 	============================================================
//	----------------------- Types below ------------------------
//	============================================================

	@Override
	public void exitInt(GrammarParser.IntContext ctx) {
		//if a typeError already occurred, then just return
		if(error != null) {
			return;
		}

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
		//if a typeError already occurred, then just return
		if(error != null) {
			return;
		}

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

	@Override
	public void exitStr(GrammarParser.StrContext ctx) {
		//if a typeError already occurred, then just return
		if(error != null) {
			return;
		}

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
		//if a typeError already occurred, then just return
		if(error != null) {
			return;
		}

		//put the integer ArrayList belonging to String (== [3]) in the parseTree
		ArrayList<Integer> type = new ArrayList<>();
		type.add(4);
		ArrayList<Integer> oldType = this.parseTreeProperty.get(ctx.getChild(1));
		type.addAll(oldType);
		this.parseTreeProperty.put(ctx, type);
//		}

		//if an exception happened, give an error message and location
		if (ctx.exception != null) {
			this.error = "No valid Arr found; At: ";
			this.errorOffset = ctx.getStart().getStartIndex();
			this.errorEnd = ctx.getStop().getStopIndex();
		}
	}
}
