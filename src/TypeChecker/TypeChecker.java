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
	private ParseTreeProperty<Integer> parseTreeProperty;
	private String error;
	private int erroroffset;
	private int errorend;

	public String decideType(String expression) throws ParseException {
		String type = null;
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
		Integer typeInt = typeChecker.parseTreeProperty.get(typeChecker.parseTree);
		if (typeChecker.error != null) {
			String errorspot = expression.substring(typeChecker.erroroffset, typeChecker.errorend+1);
			throw new ParseException(typeChecker.error + errorspot + "; Index in input: " + typeChecker.errorend + "; ", typeChecker.errorend);
		}
//		TODO: Check typeInt and decide type to return based on that
		return type;
	}

}
