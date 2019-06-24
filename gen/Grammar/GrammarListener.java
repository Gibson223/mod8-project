// Generated from C:/Users/Bjorn/Documents/Universiteit/Year 2/MOD08/mod8-project/src/Grammar\Grammar.g4 by ANTLR 4.7.2
package Grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifLine}
	 * labeled alternative in {@link GrammarParser#line}.
	 * @param ctx the parse tree
	 */
	void enterIfLine(GrammarParser.IfLineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifLine}
	 * labeled alternative in {@link GrammarParser#line}.
	 * @param ctx the parse tree
	 */
	void exitIfLine(GrammarParser.IfLineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forLine}
	 * labeled alternative in {@link GrammarParser#line}.
	 * @param ctx the parse tree
	 */
	void enterForLine(GrammarParser.ForLineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forLine}
	 * labeled alternative in {@link GrammarParser#line}.
	 * @param ctx the parse tree
	 */
	void exitForLine(GrammarParser.ForLineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declLine}
	 * labeled alternative in {@link GrammarParser#line}.
	 * @param ctx the parse tree
	 */
	void enterDeclLine(GrammarParser.DeclLineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declLine}
	 * labeled alternative in {@link GrammarParser#line}.
	 * @param ctx the parse tree
	 */
	void exitDeclLine(GrammarParser.DeclLineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code asgnLine}
	 * labeled alternative in {@link GrammarParser#line}.
	 * @param ctx the parse tree
	 */
	void enterAsgnLine(GrammarParser.AsgnLineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code asgnLine}
	 * labeled alternative in {@link GrammarParser#line}.
	 * @param ctx the parse tree
	 */
	void exitAsgnLine(GrammarParser.AsgnLineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code asgnArrLine}
	 * labeled alternative in {@link GrammarParser#line}.
	 * @param ctx the parse tree
	 */
	void enterAsgnArrLine(GrammarParser.AsgnArrLineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code asgnArrLine}
	 * labeled alternative in {@link GrammarParser#line}.
	 * @param ctx the parse tree
	 */
	void exitAsgnArrLine(GrammarParser.AsgnArrLineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code commaList}
	 * labeled alternative in {@link GrammarParser#list}.
	 * @param ctx the parse tree
	 */
	void enterCommaList(GrammarParser.CommaListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code commaList}
	 * labeled alternative in {@link GrammarParser#list}.
	 * @param ctx the parse tree
	 */
	void exitCommaList(GrammarParser.CommaListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nestedList}
	 * labeled alternative in {@link GrammarParser#list}.
	 * @param ctx the parse tree
	 */
	void enterNestedList(GrammarParser.NestedListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nestedList}
	 * labeled alternative in {@link GrammarParser#list}.
	 * @param ctx the parse tree
	 */
	void exitNestedList(GrammarParser.NestedListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nested}
	 * labeled alternative in {@link GrammarParser#sqrlist}.
	 * @param ctx the parse tree
	 */
	void enterNested(GrammarParser.NestedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nested}
	 * labeled alternative in {@link GrammarParser#sqrlist}.
	 * @param ctx the parse tree
	 */
	void exitNested(GrammarParser.NestedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprList}
	 * labeled alternative in {@link GrammarParser#sqrlist}.
	 * @param ctx the parse tree
	 */
	void enterExprList(GrammarParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprList}
	 * labeled alternative in {@link GrammarParser#sqrlist}.
	 * @param ctx the parse tree
	 */
	void exitExprList(GrammarParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVarExpr(GrammarParser.VarExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVarExpr(GrammarParser.VarExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(GrammarParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(GrammarParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCompExpr(GrammarParser.CompExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCompExpr(GrammarParser.CompExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArrExpr(GrammarParser.ArrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArrExpr(GrammarParser.ArrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSubExpr(GrammarParser.SubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSubExpr(GrammarParser.SubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultExpr(GrammarParser.MultExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultExpr(GrammarParser.MultExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstExpr(GrammarParser.ConstExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstExpr(GrammarParser.ConstExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#comp}.
	 * @param ctx the parse tree
	 */
	void enterComp(GrammarParser.CompContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#comp}.
	 * @param ctx the parse tree
	 */
	void exitComp(GrammarParser.CompContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varTarget}
	 * labeled alternative in {@link GrammarParser#target}.
	 * @param ctx the parse tree
	 */
	void enterVarTarget(GrammarParser.VarTargetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varTarget}
	 * labeled alternative in {@link GrammarParser#target}.
	 * @param ctx the parse tree
	 */
	void exitVarTarget(GrammarParser.VarTargetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayTarget}
	 * labeled alternative in {@link GrammarParser#target}.
	 * @param ctx the parse tree
	 */
	void enterArrayTarget(GrammarParser.ArrayTargetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayTarget}
	 * labeled alternative in {@link GrammarParser#target}.
	 * @param ctx the parse tree
	 */
	void exitArrayTarget(GrammarParser.ArrayTargetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link GrammarParser#types}.
	 * @param ctx the parse tree
	 */
	void enterInt(GrammarParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link GrammarParser#types}.
	 * @param ctx the parse tree
	 */
	void exitInt(GrammarParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bool}
	 * labeled alternative in {@link GrammarParser#types}.
	 * @param ctx the parse tree
	 */
	void enterBool(GrammarParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link GrammarParser#types}.
	 * @param ctx the parse tree
	 */
	void exitBool(GrammarParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code char}
	 * labeled alternative in {@link GrammarParser#types}.
	 * @param ctx the parse tree
	 */
	void enterChar(GrammarParser.CharContext ctx);
	/**
	 * Exit a parse tree produced by the {@code char}
	 * labeled alternative in {@link GrammarParser#types}.
	 * @param ctx the parse tree
	 */
	void exitChar(GrammarParser.CharContext ctx);
	/**
	 * Enter a parse tree produced by the {@code str}
	 * labeled alternative in {@link GrammarParser#types}.
	 * @param ctx the parse tree
	 */
	void enterStr(GrammarParser.StrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code str}
	 * labeled alternative in {@link GrammarParser#types}.
	 * @param ctx the parse tree
	 */
	void exitStr(GrammarParser.StrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code array}
	 * labeled alternative in {@link GrammarParser#types}.
	 * @param ctx the parse tree
	 */
	void enterArray(GrammarParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code array}
	 * labeled alternative in {@link GrammarParser#types}.
	 * @param ctx the parse tree
	 */
	void exitArray(GrammarParser.ArrayContext ctx);
}