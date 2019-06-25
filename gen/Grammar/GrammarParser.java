// Generated from C:/Users/Bjorn/Documents/Universiteit/Year 2/MOD08/mod8-project/src/Grammar\Grammar.g4 by ANTLR 4.7.2
package Grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FUN=1, RETURN=2, LOCK=3, UNLOCK=4, PARALLEL=5, SEQUENTIAL=6, OCUR=7, CCUR=8, 
		OPAR=9, CPAR=10, OSQR=11, CSQR=12, COL=13, SCOL=14, COM=15, ASGN=16, NOT=17, 
		EQ=18, NEQ=19, LT=20, LET=21, GT=22, GET=23, PLUS=24, MIN=25, TIMES=26, 
		INT=27, BOOL=28, STR=29, CHAR=30, ARRAY=31, IF=32, ELIF=33, ELSE=34, WHILE=35, 
		FOR=36, TRUE=37, FALSE=38, FUNNAME=39, VARNAME=40, NUM=41, STRING=42, 
		WHITESPACE=43;
	public static final int
		RULE_program = 0, RULE_function = 1, RULE_functioncall = 2, RULE_line = 3, 
		RULE_expr = 4, RULE_comp = 5, RULE_target = 6, RULE_types = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "function", "functioncall", "line", "expr", "comp", "target", 
			"types"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Fun'", "'return'", "'lock'", "'unlock'", "'parallel'", "'sequential'", 
			"'{'", "'}'", "'('", "')'", "'['", "']'", "':'", "';'", "','", "'='", 
			"'!'", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'*'", 
			"'Int'", "'Bool'", "'Str'", "'Char'", "'Arr'", "'if'", "'elif'", "'else'", 
			"'while'", "'for'", "'false'", "'true'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FUN", "RETURN", "LOCK", "UNLOCK", "PARALLEL", "SEQUENTIAL", "OCUR", 
			"CCUR", "OPAR", "CPAR", "OSQR", "CSQR", "COL", "SCOL", "COM", "ASGN", 
			"NOT", "EQ", "NEQ", "LT", "LET", "GT", "GET", "PLUS", "MIN", "TIMES", 
			"INT", "BOOL", "STR", "CHAR", "ARRAY", "IF", "ELIF", "ELSE", "WHILE", 
			"FOR", "TRUE", "FALSE", "FUNNAME", "VARNAME", "NUM", "STRING", "WHITESPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(18);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case FUN:
					{
					setState(16);
					function();
					}
					break;
				case LOCK:
				case UNLOCK:
				case PARALLEL:
				case SEQUENTIAL:
				case INT:
				case BOOL:
				case STR:
				case ARRAY:
				case IF:
				case WHILE:
				case FOR:
				case FUNNAME:
				case VARNAME:
					{
					setState(17);
					line();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(20); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FUN) | (1L << LOCK) | (1L << UNLOCK) | (1L << PARALLEL) | (1L << SEQUENTIAL) | (1L << INT) | (1L << BOOL) | (1L << STR) | (1L << ARRAY) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << FUNNAME) | (1L << VARNAME))) != 0) );
			setState(22);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode FUN() { return getToken(GrammarParser.FUN, 0); }
		public TerminalNode FUNNAME() { return getToken(GrammarParser.FUNNAME, 0); }
		public TerminalNode OCUR() { return getToken(GrammarParser.OCUR, 0); }
		public TerminalNode CCUR() { return getToken(GrammarParser.CCUR, 0); }
		public TypesContext types() {
			return getRuleContext(TypesContext.class,0);
		}
		public List<TerminalNode> VARNAME() { return getTokens(GrammarParser.VARNAME); }
		public TerminalNode VARNAME(int i) {
			return getToken(GrammarParser.VARNAME, i);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public TerminalNode RETURN() { return getToken(GrammarParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(FUN);
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STR) | (1L << ARRAY))) != 0)) {
				{
				setState(25);
				types();
				}
			}

			setState(28);
			match(FUNNAME);
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VARNAME) {
				{
				{
				setState(29);
				match(VARNAME);
				}
				}
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(35);
			match(OCUR);
			setState(37); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(36);
				line();
				}
				}
				setState(39); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOCK) | (1L << UNLOCK) | (1L << PARALLEL) | (1L << SEQUENTIAL) | (1L << INT) | (1L << BOOL) | (1L << STR) | (1L << ARRAY) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << FUNNAME) | (1L << VARNAME))) != 0) );
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RETURN) {
				{
				setState(41);
				match(RETURN);
				setState(42);
				expr(0);
				}
			}

			setState(45);
			match(CCUR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctioncallContext extends ParserRuleContext {
		public TerminalNode FUNNAME() { return getToken(GrammarParser.FUNNAME, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FunctioncallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functioncall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterFunctioncall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitFunctioncall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitFunctioncall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctioncallContext functioncall() throws RecognitionException {
		FunctioncallContext _localctx = new FunctioncallContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functioncall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(FUNNAME);
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPAR) | (1L << OSQR) | (1L << TRUE) | (1L << FALSE) | (1L << VARNAME) | (1L << NUM) | (1L << STRING))) != 0)) {
				{
				{
				setState(48);
				expr(0);
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LineContext extends ParserRuleContext {
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
	 
		public LineContext() { }
		public void copyFrom(LineContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WhileLineContext extends LineContext {
		public TerminalNode WHILE() { return getToken(GrammarParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode OCUR() { return getToken(GrammarParser.OCUR, 0); }
		public TerminalNode CCUR() { return getToken(GrammarParser.CCUR, 0); }
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public WhileLineContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterWhileLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitWhileLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitWhileLine(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SequentialLineContext extends LineContext {
		public TerminalNode SEQUENTIAL() { return getToken(GrammarParser.SEQUENTIAL, 0); }
		public TerminalNode OCUR() { return getToken(GrammarParser.OCUR, 0); }
		public TerminalNode CCUR() { return getToken(GrammarParser.CCUR, 0); }
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public SequentialLineContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterSequentialLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitSequentialLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitSequentialLine(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LockLineContext extends LineContext {
		public TerminalNode VARNAME() { return getToken(GrammarParser.VARNAME, 0); }
		public TerminalNode SCOL() { return getToken(GrammarParser.SCOL, 0); }
		public TerminalNode LOCK() { return getToken(GrammarParser.LOCK, 0); }
		public TerminalNode UNLOCK() { return getToken(GrammarParser.UNLOCK, 0); }
		public LockLineContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterLockLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitLockLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitLockLine(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncallLineContext extends LineContext {
		public FunctioncallContext functioncall() {
			return getRuleContext(FunctioncallContext.class,0);
		}
		public TerminalNode SCOL() { return getToken(GrammarParser.SCOL, 0); }
		public FuncallLineContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterFuncallLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitFuncallLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitFuncallLine(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AsgnLineContext extends LineContext {
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TerminalNode ASGN() { return getToken(GrammarParser.ASGN, 0); }
		public TerminalNode SCOL() { return getToken(GrammarParser.SCOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FunctioncallContext functioncall() {
			return getRuleContext(FunctioncallContext.class,0);
		}
		public AsgnLineContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterAsgnLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitAsgnLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitAsgnLine(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParallelLineContext extends LineContext {
		public TerminalNode PARALLEL() { return getToken(GrammarParser.PARALLEL, 0); }
		public TerminalNode OCUR() { return getToken(GrammarParser.OCUR, 0); }
		public TerminalNode CCUR() { return getToken(GrammarParser.CCUR, 0); }
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public ParallelLineContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterParallelLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitParallelLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitParallelLine(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForLineContext extends LineContext {
		public TerminalNode FOR() { return getToken(GrammarParser.FOR, 0); }
		public List<TerminalNode> VARNAME() { return getTokens(GrammarParser.VARNAME); }
		public TerminalNode VARNAME(int i) {
			return getToken(GrammarParser.VARNAME, i);
		}
		public List<TerminalNode> SCOL() { return getTokens(GrammarParser.SCOL); }
		public TerminalNode SCOL(int i) {
			return getToken(GrammarParser.SCOL, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> ASGN() { return getTokens(GrammarParser.ASGN); }
		public TerminalNode ASGN(int i) {
			return getToken(GrammarParser.ASGN, i);
		}
		public TerminalNode OCUR() { return getToken(GrammarParser.OCUR, 0); }
		public TerminalNode CCUR() { return getToken(GrammarParser.CCUR, 0); }
		public TerminalNode INT() { return getToken(GrammarParser.INT, 0); }
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public ForLineContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterForLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitForLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitForLine(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclLineContext extends LineContext {
		public TypesContext types() {
			return getRuleContext(TypesContext.class,0);
		}
		public TerminalNode VARNAME() { return getToken(GrammarParser.VARNAME, 0); }
		public TerminalNode SCOL() { return getToken(GrammarParser.SCOL, 0); }
		public TerminalNode ASGN() { return getToken(GrammarParser.ASGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FunctioncallContext functioncall() {
			return getRuleContext(FunctioncallContext.class,0);
		}
		public DeclLineContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterDeclLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitDeclLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitDeclLine(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfLineContext extends LineContext {
		public TerminalNode IF() { return getToken(GrammarParser.IF, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> OCUR() { return getTokens(GrammarParser.OCUR); }
		public TerminalNode OCUR(int i) {
			return getToken(GrammarParser.OCUR, i);
		}
		public List<TerminalNode> CCUR() { return getTokens(GrammarParser.CCUR); }
		public TerminalNode CCUR(int i) {
			return getToken(GrammarParser.CCUR, i);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public List<TerminalNode> ELIF() { return getTokens(GrammarParser.ELIF); }
		public TerminalNode ELIF(int i) {
			return getToken(GrammarParser.ELIF, i);
		}
		public TerminalNode ELSE() { return getToken(GrammarParser.ELSE, 0); }
		public IfLineContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterIfLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitIfLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitIfLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_line);
		int _la;
		try {
			setState(169);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				_localctx = new IfLineContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				match(IF);
				setState(55);
				expr(0);
				setState(56);
				match(OCUR);
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOCK) | (1L << UNLOCK) | (1L << PARALLEL) | (1L << SEQUENTIAL) | (1L << INT) | (1L << BOOL) | (1L << STR) | (1L << ARRAY) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << FUNNAME) | (1L << VARNAME))) != 0)) {
					{
					{
					setState(57);
					line();
					}
					}
					setState(62);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(63);
				match(CCUR);
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ELIF) {
					{
					{
					setState(64);
					match(ELIF);
					setState(65);
					expr(0);
					setState(66);
					match(OCUR);
					setState(70);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOCK) | (1L << UNLOCK) | (1L << PARALLEL) | (1L << SEQUENTIAL) | (1L << INT) | (1L << BOOL) | (1L << STR) | (1L << ARRAY) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << FUNNAME) | (1L << VARNAME))) != 0)) {
						{
						{
						setState(67);
						line();
						}
						}
						setState(72);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(73);
					match(CCUR);
					}
					}
					setState(79);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(80);
					match(ELSE);
					setState(81);
					match(OCUR);
					setState(85);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOCK) | (1L << UNLOCK) | (1L << PARALLEL) | (1L << SEQUENTIAL) | (1L << INT) | (1L << BOOL) | (1L << STR) | (1L << ARRAY) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << FUNNAME) | (1L << VARNAME))) != 0)) {
						{
						{
						setState(82);
						line();
						}
						}
						setState(87);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(88);
					match(CCUR);
					}
				}

				}
				break;
			case FOR:
				_localctx = new ForLineContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				match(FOR);
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INT) {
					{
					setState(92);
					match(INT);
					}
				}

				setState(95);
				match(VARNAME);
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASGN) {
					{
					setState(96);
					match(ASGN);
					setState(97);
					expr(0);
					}
				}

				setState(100);
				match(SCOL);
				setState(101);
				expr(0);
				setState(102);
				match(SCOL);
				setState(103);
				match(VARNAME);
				setState(104);
				match(ASGN);
				setState(105);
				expr(0);
				setState(106);
				match(SCOL);
				setState(107);
				match(OCUR);
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOCK) | (1L << UNLOCK) | (1L << PARALLEL) | (1L << SEQUENTIAL) | (1L << INT) | (1L << BOOL) | (1L << STR) | (1L << ARRAY) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << FUNNAME) | (1L << VARNAME))) != 0)) {
					{
					{
					setState(108);
					line();
					}
					}
					setState(113);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(114);
				match(CCUR);
				}
				break;
			case WHILE:
				_localctx = new WhileLineContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(116);
				match(WHILE);
				setState(117);
				expr(0);
				setState(118);
				match(OCUR);
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOCK) | (1L << UNLOCK) | (1L << PARALLEL) | (1L << SEQUENTIAL) | (1L << INT) | (1L << BOOL) | (1L << STR) | (1L << ARRAY) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << FUNNAME) | (1L << VARNAME))) != 0)) {
					{
					{
					setState(119);
					line();
					}
					}
					setState(124);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(125);
				match(CCUR);
				}
				break;
			case PARALLEL:
				_localctx = new ParallelLineContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(127);
				match(PARALLEL);
				setState(128);
				match(OCUR);
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOCK) | (1L << UNLOCK) | (1L << PARALLEL) | (1L << SEQUENTIAL) | (1L << INT) | (1L << BOOL) | (1L << STR) | (1L << ARRAY) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << FUNNAME) | (1L << VARNAME))) != 0)) {
					{
					{
					setState(129);
					line();
					}
					}
					setState(134);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(135);
				match(CCUR);
				}
				break;
			case SEQUENTIAL:
				_localctx = new SequentialLineContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(136);
				match(SEQUENTIAL);
				setState(137);
				match(OCUR);
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOCK) | (1L << UNLOCK) | (1L << PARALLEL) | (1L << SEQUENTIAL) | (1L << INT) | (1L << BOOL) | (1L << STR) | (1L << ARRAY) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << FUNNAME) | (1L << VARNAME))) != 0)) {
					{
					{
					setState(138);
					line();
					}
					}
					setState(143);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(144);
				match(CCUR);
				}
				break;
			case INT:
			case BOOL:
			case STR:
			case ARRAY:
				_localctx = new DeclLineContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(145);
				types();
				setState(146);
				match(VARNAME);
				setState(151);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(147);
					match(ASGN);
					setState(148);
					expr(0);
					}
					break;
				case 2:
					{
					setState(149);
					match(ASGN);
					setState(150);
					functioncall();
					}
					break;
				}
				setState(153);
				match(SCOL);
				}
				break;
			case VARNAME:
				_localctx = new AsgnLineContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(155);
				target();
				setState(156);
				match(ASGN);
				setState(159);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case OPAR:
				case OSQR:
				case TRUE:
				case FALSE:
				case VARNAME:
				case NUM:
				case STRING:
					{
					setState(157);
					expr(0);
					}
					break;
				case FUNNAME:
					{
					setState(158);
					functioncall();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(161);
				match(SCOL);
				}
				break;
			case LOCK:
			case UNLOCK:
				_localctx = new LockLineContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(163);
				_la = _input.LA(1);
				if ( !(_la==LOCK || _la==UNLOCK) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(164);
				match(VARNAME);
				setState(165);
				match(SCOL);
				}
				break;
			case FUNNAME:
				_localctx = new FuncallLineContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(166);
				functioncall();
				setState(167);
				match(SCOL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AddorsubExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(GrammarParser.PLUS, 0); }
		public TerminalNode MIN() { return getToken(GrammarParser.MIN, 0); }
		public AddorsubExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterAddorsubExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitAddorsubExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitAddorsubExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarExprContext extends ExprContext {
		public TerminalNode VARNAME() { return getToken(GrammarParser.VARNAME, 0); }
		public VarExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterVarExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitVarExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitVarExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CompContext comp() {
			return getRuleContext(CompContext.class,0);
		}
		public CompExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterCompExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitCompExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitCompExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrExprContext extends ExprContext {
		public TerminalNode VARNAME() { return getToken(GrammarParser.VARNAME, 0); }
		public TerminalNode OSQR() { return getToken(GrammarParser.OSQR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CSQR() { return getToken(GrammarParser.CSQR, 0); }
		public ArrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterArrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitArrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitArrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensExprContext extends ExprContext {
		public TerminalNode OPAR() { return getToken(GrammarParser.OPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CPAR() { return getToken(GrammarParser.CPAR, 0); }
		public ParensExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterParensExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitParensExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitParensExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListExprContext extends ExprContext {
		public TerminalNode OSQR() { return getToken(GrammarParser.OSQR, 0); }
		public TerminalNode CSQR() { return getToken(GrammarParser.CSQR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COM() { return getTokens(GrammarParser.COM); }
		public TerminalNode COM(int i) {
			return getToken(GrammarParser.COM, i);
		}
		public ListExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterListExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitListExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitListExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode TIMES() { return getToken(GrammarParser.TIMES, 0); }
		public MultExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterMultExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitMultExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitMultExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstExprContext extends ExprContext {
		public TerminalNode NUM() { return getToken(GrammarParser.NUM, 0); }
		public TerminalNode TRUE() { return getToken(GrammarParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(GrammarParser.FALSE, 0); }
		public TerminalNode STRING() { return getToken(GrammarParser.STRING, 0); }
		public ConstExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterConstExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitConstExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitConstExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				_localctx = new ParensExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(172);
				match(OPAR);
				setState(173);
				expr(0);
				setState(174);
				match(CPAR);
				}
				break;
			case 2:
				{
				_localctx = new ConstExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(176);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << NUM) | (1L << STRING))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 3:
				{
				_localctx = new ArrExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(177);
				match(VARNAME);
				setState(178);
				match(OSQR);
				setState(179);
				expr(0);
				setState(180);
				match(CSQR);
				}
				break;
			case 4:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(182);
				match(VARNAME);
				}
				break;
			case 5:
				{
				_localctx = new ListExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(183);
				match(OSQR);
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPAR) | (1L << OSQR) | (1L << TRUE) | (1L << FALSE) | (1L << VARNAME) | (1L << NUM) | (1L << STRING))) != 0)) {
					{
					setState(184);
					expr(0);
					setState(189);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COM) {
						{
						{
						setState(185);
						match(COM);
						setState(186);
						expr(0);
						}
						}
						setState(191);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(194);
				match(CSQR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(209);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(207);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new CompExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(197);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(198);
						comp();
						setState(199);
						expr(8);
						}
						break;
					case 2:
						{
						_localctx = new MultExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(201);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(202);
						match(TIMES);
						setState(203);
						expr(7);
						}
						break;
					case 3:
						{
						_localctx = new AddorsubExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(204);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(205);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MIN) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(206);
						expr(6);
						}
						break;
					}
					} 
				}
				setState(211);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class CompContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(GrammarParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(GrammarParser.NEQ, 0); }
		public TerminalNode LT() { return getToken(GrammarParser.LT, 0); }
		public TerminalNode GT() { return getToken(GrammarParser.GT, 0); }
		public TerminalNode GET() { return getToken(GrammarParser.GET, 0); }
		public TerminalNode LET() { return getToken(GrammarParser.LET, 0); }
		public CompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterComp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitComp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitComp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompContext comp() throws RecognitionException {
		CompContext _localctx = new CompContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_comp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << LT) | (1L << LET) | (1L << GT) | (1L << GET))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TargetContext extends ParserRuleContext {
		public TargetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_target; }
	 
		public TargetContext() { }
		public void copyFrom(TargetContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayTargetContext extends TargetContext {
		public TerminalNode VARNAME() { return getToken(GrammarParser.VARNAME, 0); }
		public TerminalNode OSQR() { return getToken(GrammarParser.OSQR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CSQR() { return getToken(GrammarParser.CSQR, 0); }
		public ArrayTargetContext(TargetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterArrayTarget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitArrayTarget(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitArrayTarget(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarTargetContext extends TargetContext {
		public TerminalNode VARNAME() { return getToken(GrammarParser.VARNAME, 0); }
		public VarTargetContext(TargetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterVarTarget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitVarTarget(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitVarTarget(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TargetContext target() throws RecognitionException {
		TargetContext _localctx = new TargetContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_target);
		try {
			setState(220);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				_localctx = new VarTargetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(214);
				match(VARNAME);
				}
				break;
			case 2:
				_localctx = new ArrayTargetContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(215);
				match(VARNAME);
				setState(216);
				match(OSQR);
				setState(217);
				expr(0);
				setState(218);
				match(CSQR);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypesContext extends ParserRuleContext {
		public TypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_types; }
	 
		public TypesContext() { }
		public void copyFrom(TypesContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StrContext extends TypesContext {
		public TerminalNode STR() { return getToken(GrammarParser.STR, 0); }
		public StrContext(TypesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterStr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitStr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitStr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolContext extends TypesContext {
		public TerminalNode BOOL() { return getToken(GrammarParser.BOOL, 0); }
		public BoolContext(TypesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayContext extends TypesContext {
		public TerminalNode ARRAY() { return getToken(GrammarParser.ARRAY, 0); }
		public TypesContext types() {
			return getRuleContext(TypesContext.class,0);
		}
		public ArrayContext(TypesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntContext extends TypesContext {
		public TerminalNode INT() { return getToken(GrammarParser.INT, 0); }
		public IntContext(TypesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypesContext types() throws RecognitionException {
		TypesContext _localctx = new TypesContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_types);
		try {
			setState(227);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				match(INT);
				}
				break;
			case BOOL:
				_localctx = new BoolContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				match(BOOL);
				}
				break;
			case STR:
				_localctx = new StrContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(224);
				match(STR);
				}
				break;
			case ARRAY:
				_localctx = new ArrayContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(225);
				match(ARRAY);
				setState(226);
				types();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u00e8\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\6\2\25"+
		"\n\2\r\2\16\2\26\3\2\3\2\3\3\3\3\5\3\35\n\3\3\3\3\3\7\3!\n\3\f\3\16\3"+
		"$\13\3\3\3\3\3\6\3(\n\3\r\3\16\3)\3\3\3\3\5\3.\n\3\3\3\3\3\3\4\3\4\7\4"+
		"\64\n\4\f\4\16\4\67\13\4\3\5\3\5\3\5\3\5\7\5=\n\5\f\5\16\5@\13\5\3\5\3"+
		"\5\3\5\3\5\3\5\7\5G\n\5\f\5\16\5J\13\5\3\5\3\5\7\5N\n\5\f\5\16\5Q\13\5"+
		"\3\5\3\5\3\5\7\5V\n\5\f\5\16\5Y\13\5\3\5\5\5\\\n\5\3\5\3\5\5\5`\n\5\3"+
		"\5\3\5\3\5\5\5e\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5p\n\5\f\5\16"+
		"\5s\13\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5{\n\5\f\5\16\5~\13\5\3\5\3\5\3\5\3"+
		"\5\3\5\7\5\u0085\n\5\f\5\16\5\u0088\13\5\3\5\3\5\3\5\3\5\7\5\u008e\n\5"+
		"\f\5\16\5\u0091\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u009a\n\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\5\5\u00a2\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u00ac"+
		"\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7"+
		"\6\u00be\n\6\f\6\16\6\u00c1\13\6\5\6\u00c3\n\6\3\6\5\6\u00c6\n\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00d2\n\6\f\6\16\6\u00d5\13\6\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00df\n\b\3\t\3\t\3\t\3\t\3\t\5\t\u00e6"+
		"\n\t\3\t\2\3\n\n\2\4\6\b\n\f\16\20\2\6\3\2\5\6\4\2\'(+,\3\2\32\33\3\2"+
		"\24\31\2\u0109\2\24\3\2\2\2\4\32\3\2\2\2\6\61\3\2\2\2\b\u00ab\3\2\2\2"+
		"\n\u00c5\3\2\2\2\f\u00d6\3\2\2\2\16\u00de\3\2\2\2\20\u00e5\3\2\2\2\22"+
		"\25\5\4\3\2\23\25\5\b\5\2\24\22\3\2\2\2\24\23\3\2\2\2\25\26\3\2\2\2\26"+
		"\24\3\2\2\2\26\27\3\2\2\2\27\30\3\2\2\2\30\31\7\2\2\3\31\3\3\2\2\2\32"+
		"\34\7\3\2\2\33\35\5\20\t\2\34\33\3\2\2\2\34\35\3\2\2\2\35\36\3\2\2\2\36"+
		"\"\7)\2\2\37!\7*\2\2 \37\3\2\2\2!$\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#%\3\2"+
		"\2\2$\"\3\2\2\2%\'\7\t\2\2&(\5\b\5\2\'&\3\2\2\2()\3\2\2\2)\'\3\2\2\2)"+
		"*\3\2\2\2*-\3\2\2\2+,\7\4\2\2,.\5\n\6\2-+\3\2\2\2-.\3\2\2\2./\3\2\2\2"+
		"/\60\7\n\2\2\60\5\3\2\2\2\61\65\7)\2\2\62\64\5\n\6\2\63\62\3\2\2\2\64"+
		"\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\7\3\2\2\2\67\65\3\2\2\289\7"+
		"\"\2\29:\5\n\6\2:>\7\t\2\2;=\5\b\5\2<;\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3"+
		"\2\2\2?A\3\2\2\2@>\3\2\2\2AO\7\n\2\2BC\7#\2\2CD\5\n\6\2DH\7\t\2\2EG\5"+
		"\b\5\2FE\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2IK\3\2\2\2JH\3\2\2\2KL\7"+
		"\n\2\2LN\3\2\2\2MB\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2P[\3\2\2\2QO\3"+
		"\2\2\2RS\7$\2\2SW\7\t\2\2TV\5\b\5\2UT\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3"+
		"\2\2\2XZ\3\2\2\2YW\3\2\2\2Z\\\7\n\2\2[R\3\2\2\2[\\\3\2\2\2\\\u00ac\3\2"+
		"\2\2]_\7&\2\2^`\7\35\2\2_^\3\2\2\2_`\3\2\2\2`a\3\2\2\2ad\7*\2\2bc\7\22"+
		"\2\2ce\5\n\6\2db\3\2\2\2de\3\2\2\2ef\3\2\2\2fg\7\20\2\2gh\5\n\6\2hi\7"+
		"\20\2\2ij\7*\2\2jk\7\22\2\2kl\5\n\6\2lm\7\20\2\2mq\7\t\2\2np\5\b\5\2o"+
		"n\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2rt\3\2\2\2sq\3\2\2\2tu\7\n\2\2"+
		"u\u00ac\3\2\2\2vw\7%\2\2wx\5\n\6\2x|\7\t\2\2y{\5\b\5\2zy\3\2\2\2{~\3\2"+
		"\2\2|z\3\2\2\2|}\3\2\2\2}\177\3\2\2\2~|\3\2\2\2\177\u0080\7\n\2\2\u0080"+
		"\u00ac\3\2\2\2\u0081\u0082\7\7\2\2\u0082\u0086\7\t\2\2\u0083\u0085\5\b"+
		"\5\2\u0084\u0083\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\u0089\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u00ac\7\n"+
		"\2\2\u008a\u008b\7\b\2\2\u008b\u008f\7\t\2\2\u008c\u008e\5\b\5\2\u008d"+
		"\u008c\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2"+
		"\2\2\u0090\u0092\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u00ac\7\n\2\2\u0093"+
		"\u0094\5\20\t\2\u0094\u0099\7*\2\2\u0095\u0096\7\22\2\2\u0096\u009a\5"+
		"\n\6\2\u0097\u0098\7\22\2\2\u0098\u009a\5\6\4\2\u0099\u0095\3\2\2\2\u0099"+
		"\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\7\20"+
		"\2\2\u009c\u00ac\3\2\2\2\u009d\u009e\5\16\b\2\u009e\u00a1\7\22\2\2\u009f"+
		"\u00a2\5\n\6\2\u00a0\u00a2\5\6\4\2\u00a1\u009f\3\2\2\2\u00a1\u00a0\3\2"+
		"\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\7\20\2\2\u00a4\u00ac\3\2\2\2\u00a5"+
		"\u00a6\t\2\2\2\u00a6\u00a7\7*\2\2\u00a7\u00ac\7\20\2\2\u00a8\u00a9\5\6"+
		"\4\2\u00a9\u00aa\7\20\2\2\u00aa\u00ac\3\2\2\2\u00ab8\3\2\2\2\u00ab]\3"+
		"\2\2\2\u00abv\3\2\2\2\u00ab\u0081\3\2\2\2\u00ab\u008a\3\2\2\2\u00ab\u0093"+
		"\3\2\2\2\u00ab\u009d\3\2\2\2\u00ab\u00a5\3\2\2\2\u00ab\u00a8\3\2\2\2\u00ac"+
		"\t\3\2\2\2\u00ad\u00ae\b\6\1\2\u00ae\u00af\7\13\2\2\u00af\u00b0\5\n\6"+
		"\2\u00b0\u00b1\7\f\2\2\u00b1\u00c6\3\2\2\2\u00b2\u00c6\t\3\2\2\u00b3\u00b4"+
		"\7*\2\2\u00b4\u00b5\7\r\2\2\u00b5\u00b6\5\n\6\2\u00b6\u00b7\7\16\2\2\u00b7"+
		"\u00c6\3\2\2\2\u00b8\u00c6\7*\2\2\u00b9\u00c2\7\r\2\2\u00ba\u00bf\5\n"+
		"\6\2\u00bb\u00bc\7\21\2\2\u00bc\u00be\5\n\6\2\u00bd\u00bb\3\2\2\2\u00be"+
		"\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c3\3\2"+
		"\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00ba\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3"+
		"\u00c4\3\2\2\2\u00c4\u00c6\7\16\2\2\u00c5\u00ad\3\2\2\2\u00c5\u00b2\3"+
		"\2\2\2\u00c5\u00b3\3\2\2\2\u00c5\u00b8\3\2\2\2\u00c5\u00b9\3\2\2\2\u00c6"+
		"\u00d3\3\2\2\2\u00c7\u00c8\f\t\2\2\u00c8\u00c9\5\f\7\2\u00c9\u00ca\5\n"+
		"\6\n\u00ca\u00d2\3\2\2\2\u00cb\u00cc\f\b\2\2\u00cc\u00cd\7\34\2\2\u00cd"+
		"\u00d2\5\n\6\t\u00ce\u00cf\f\7\2\2\u00cf\u00d0\t\4\2\2\u00d0\u00d2\5\n"+
		"\6\b\u00d1\u00c7\3\2\2\2\u00d1\u00cb\3\2\2\2\u00d1\u00ce\3\2\2\2\u00d2"+
		"\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\13\3\2\2"+
		"\2\u00d5\u00d3\3\2\2\2\u00d6\u00d7\t\5\2\2\u00d7\r\3\2\2\2\u00d8\u00df"+
		"\7*\2\2\u00d9\u00da\7*\2\2\u00da\u00db\7\r\2\2\u00db\u00dc\5\n\6\2\u00dc"+
		"\u00dd\7\16\2\2\u00dd\u00df\3\2\2\2\u00de\u00d8\3\2\2\2\u00de\u00d9\3"+
		"\2\2\2\u00df\17\3\2\2\2\u00e0\u00e6\7\35\2\2\u00e1\u00e6\7\36\2\2\u00e2"+
		"\u00e6\7\37\2\2\u00e3\u00e4\7!\2\2\u00e4\u00e6\5\20\t\2\u00e5\u00e0\3"+
		"\2\2\2\u00e5\u00e1\3\2\2\2\u00e5\u00e2\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6"+
		"\21\3\2\2\2\36\24\26\34\")-\65>HOW[_dq|\u0086\u008f\u0099\u00a1\u00ab"+
		"\u00bf\u00c2\u00c5\u00d1\u00d3\u00de\u00e5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}