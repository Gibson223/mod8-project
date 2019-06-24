// Generated from C:/Users/Bjorn/Documents/Universiteit/Year 2/MOD08/mod8-project/src/Grammar\Grammar.g4 by ANTLR 4.7.2
package Grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifLine}
	 * labeled alternative in {@link GrammarParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfLine(GrammarParser.IfLineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forLine}
	 * labeled alternative in {@link GrammarParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLine(GrammarParser.ForLineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declLine}
	 * labeled alternative in {@link GrammarParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclLine(GrammarParser.DeclLineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code asgnLine}
	 * labeled alternative in {@link GrammarParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsgnLine(GrammarParser.AsgnLineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code asgnArrLine}
	 * labeled alternative in {@link GrammarParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsgnArrLine(GrammarParser.AsgnArrLineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code commaList}
	 * labeled alternative in {@link GrammarParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommaList(GrammarParser.CommaListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nestedList}
	 * labeled alternative in {@link GrammarParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedList(GrammarParser.NestedListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nested}
	 * labeled alternative in {@link GrammarParser#sqrlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNested(GrammarParser.NestedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprList}
	 * labeled alternative in {@link GrammarParser#sqrlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(GrammarParser.ExprListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarExpr(GrammarParser.VarExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(GrammarParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompExpr(GrammarParser.CompExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrExpr(GrammarParser.ArrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubExpr(GrammarParser.SubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExpr(GrammarParser.MultExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstExpr(GrammarParser.ConstExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#comp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp(GrammarParser.CompContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varTarget}
	 * labeled alternative in {@link GrammarParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarTarget(GrammarParser.VarTargetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayTarget}
	 * labeled alternative in {@link GrammarParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayTarget(GrammarParser.ArrayTargetContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#types}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypes(GrammarParser.TypesContext ctx);
}