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
		FOR=36, TRUE=37, FALSE=38, VARNAME=39, NUM=40, STRING=41, WHITESPACE=42;
	public static final int
		RULE_program = 0, RULE_function = 1, RULE_line = 2, RULE_expr = 3, RULE_comp = 4, 
		RULE_target = 5, RULE_types = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "function", "line", "expr", "comp", "target", "types"
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
			"FOR", "TRUE", "FALSE", "VARNAME", "NUM", "STRING", "WHITESPACE"
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
			setState(16); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(16);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case FUN:
					{
					setState(14);
					function();
					}
					break;
				case RETURN:
				case LOCK:
				case UNLOCK:
				case PARALLEL:
				case SEQUENTIAL:
				case INT:
				case BOOL:
				case STR:
				case CHAR:
				case ARRAY:
				case IF:
				case FOR:
				case VARNAME:
					{
					setState(15);
					line();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(18); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FUN) | (1L << RETURN) | (1L << LOCK) | (1L << UNLOCK) | (1L << PARALLEL) | (1L << SEQUENTIAL) | (1L << INT) | (1L << BOOL) | (1L << STR) | (1L << CHAR) | (1L << ARRAY) | (1L << IF) | (1L << FOR) | (1L << VARNAME))) != 0) );
			setState(20);
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
			setState(22);
			match(FUN);
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STR) | (1L << CHAR) | (1L << ARRAY))) != 0)) {
				{
				setState(23);
				types();
				}
			}

			setState(27); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(26);
				match(VARNAME);
				}
				}
				setState(29); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==VARNAME );
			setState(31);
			match(OCUR);
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32);
				line();
				}
				}
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << LOCK) | (1L << UNLOCK) | (1L << PARALLEL) | (1L << SEQUENTIAL) | (1L << INT) | (1L << BOOL) | (1L << STR) | (1L << CHAR) | (1L << ARRAY) | (1L << IF) | (1L << FOR) | (1L << VARNAME))) != 0) );
			setState(37);
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
	public static class ReturnLineContext extends LineContext {
		public TerminalNode RETURN() { return getToken(GrammarParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SCOL() { return getToken(GrammarParser.SCOL, 0); }
		public ReturnLineContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterReturnLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitReturnLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitReturnLine(this);
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
	public static class AsgnLineContext extends LineContext {
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TerminalNode ASGN() { return getToken(GrammarParser.ASGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SCOL() { return getToken(GrammarParser.SCOL, 0); }
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
		public TypesContext types() {
			return getRuleContext(TypesContext.class,0);
		}
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
		enterRule(_localctx, 4, RULE_line);
		int _la;
		try {
			setState(137);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				_localctx = new IfLineContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				match(IF);
				setState(40);
				expr(0);
				setState(41);
				match(OCUR);
				setState(43); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(42);
					line();
					}
					}
					setState(45); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << LOCK) | (1L << UNLOCK) | (1L << PARALLEL) | (1L << SEQUENTIAL) | (1L << INT) | (1L << BOOL) | (1L << STR) | (1L << CHAR) | (1L << ARRAY) | (1L << IF) | (1L << FOR) | (1L << VARNAME))) != 0) );
				setState(47);
				match(CCUR);
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ELIF) {
					{
					{
					setState(48);
					match(ELIF);
					setState(49);
					expr(0);
					setState(50);
					match(OCUR);
					setState(52); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(51);
						line();
						}
						}
						setState(54); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << LOCK) | (1L << UNLOCK) | (1L << PARALLEL) | (1L << SEQUENTIAL) | (1L << INT) | (1L << BOOL) | (1L << STR) | (1L << CHAR) | (1L << ARRAY) | (1L << IF) | (1L << FOR) | (1L << VARNAME))) != 0) );
					setState(56);
					match(CCUR);
					}
					}
					setState(62);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(63);
					match(ELSE);
					setState(64);
					expr(0);
					setState(65);
					match(OCUR);
					setState(67); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(66);
						line();
						}
						}
						setState(69); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << LOCK) | (1L << UNLOCK) | (1L << PARALLEL) | (1L << SEQUENTIAL) | (1L << INT) | (1L << BOOL) | (1L << STR) | (1L << CHAR) | (1L << ARRAY) | (1L << IF) | (1L << FOR) | (1L << VARNAME))) != 0) );
					setState(71);
					match(CCUR);
					}
				}

				}
				break;
			case FOR:
				_localctx = new ForLineContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(FOR);
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STR) | (1L << CHAR) | (1L << ARRAY))) != 0)) {
					{
					setState(76);
					types();
					}
				}

				setState(79);
				match(VARNAME);
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASGN) {
					{
					setState(80);
					match(ASGN);
					setState(81);
					expr(0);
					}
				}

				setState(84);
				match(SCOL);
				setState(85);
				expr(0);
				setState(86);
				match(SCOL);
				setState(87);
				match(VARNAME);
				setState(88);
				match(ASGN);
				setState(89);
				expr(0);
				setState(90);
				match(SCOL);
				setState(91);
				match(OCUR);
				setState(93); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(92);
					line();
					}
					}
					setState(95); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << LOCK) | (1L << UNLOCK) | (1L << PARALLEL) | (1L << SEQUENTIAL) | (1L << INT) | (1L << BOOL) | (1L << STR) | (1L << CHAR) | (1L << ARRAY) | (1L << IF) | (1L << FOR) | (1L << VARNAME))) != 0) );
				setState(97);
				match(CCUR);
				}
				break;
			case PARALLEL:
				_localctx = new ParallelLineContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(99);
				match(PARALLEL);
				setState(100);
				match(OCUR);
				setState(102); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(101);
					line();
					}
					}
					setState(104); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << LOCK) | (1L << UNLOCK) | (1L << PARALLEL) | (1L << SEQUENTIAL) | (1L << INT) | (1L << BOOL) | (1L << STR) | (1L << CHAR) | (1L << ARRAY) | (1L << IF) | (1L << FOR) | (1L << VARNAME))) != 0) );
				setState(106);
				match(CCUR);
				}
				break;
			case SEQUENTIAL:
				_localctx = new SequentialLineContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(108);
				match(SEQUENTIAL);
				setState(109);
				match(OCUR);
				setState(111); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(110);
					line();
					}
					}
					setState(113); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << LOCK) | (1L << UNLOCK) | (1L << PARALLEL) | (1L << SEQUENTIAL) | (1L << INT) | (1L << BOOL) | (1L << STR) | (1L << CHAR) | (1L << ARRAY) | (1L << IF) | (1L << FOR) | (1L << VARNAME))) != 0) );
				setState(115);
				match(CCUR);
				}
				break;
			case INT:
			case BOOL:
			case STR:
			case CHAR:
			case ARRAY:
				_localctx = new DeclLineContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(117);
				types();
				setState(118);
				match(VARNAME);
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASGN) {
					{
					setState(119);
					match(ASGN);
					setState(120);
					expr(0);
					}
				}

				setState(123);
				match(SCOL);
				}
				break;
			case VARNAME:
				_localctx = new AsgnLineContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(125);
				target();
				setState(126);
				match(ASGN);
				setState(127);
				expr(0);
				setState(128);
				match(SCOL);
				}
				break;
			case LOCK:
			case UNLOCK:
				_localctx = new LockLineContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(130);
				_la = _input.LA(1);
				if ( !(_la==LOCK || _la==UNLOCK) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(131);
				match(VARNAME);
				setState(132);
				match(SCOL);
				}
				break;
			case RETURN:
				_localctx = new ReturnLineContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(133);
				match(RETURN);
				setState(134);
				expr(0);
				setState(135);
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
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				_localctx = new ParensExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(140);
				match(OPAR);
				setState(141);
				expr(0);
				setState(142);
				match(CPAR);
				}
				break;
			case 2:
				{
				_localctx = new ConstExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(144);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << NUM))) != 0)) ) {
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
				setState(145);
				match(VARNAME);
				setState(146);
				match(OSQR);
				setState(147);
				expr(0);
				setState(148);
				match(CSQR);
				}
				break;
			case 4:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(150);
				match(VARNAME);
				}
				break;
			case 5:
				{
				_localctx = new ListExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(151);
				match(OSQR);
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPAR) | (1L << OSQR) | (1L << TRUE) | (1L << FALSE) | (1L << VARNAME) | (1L << NUM))) != 0)) {
					{
					setState(152);
					expr(0);
					setState(157);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COM) {
						{
						{
						setState(153);
						match(COM);
						setState(154);
						expr(0);
						}
						}
						setState(159);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(162);
				match(CSQR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(177);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(175);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new CompExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(165);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(166);
						comp();
						setState(167);
						expr(8);
						}
						break;
					case 2:
						{
						_localctx = new MultExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(169);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(170);
						match(TIMES);
						setState(171);
						expr(7);
						}
						break;
					case 3:
						{
						_localctx = new AddorsubExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(172);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(173);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MIN) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(174);
						expr(6);
						}
						break;
					}
					} 
				}
				setState(179);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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
		enterRule(_localctx, 8, RULE_comp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
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
		enterRule(_localctx, 10, RULE_target);
		try {
			setState(188);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				_localctx = new VarTargetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				match(VARNAME);
				}
				break;
			case 2:
				_localctx = new ArrayTargetContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				match(VARNAME);
				setState(184);
				match(OSQR);
				setState(185);
				expr(0);
				setState(186);
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
	public static class CharContext extends TypesContext {
		public TerminalNode CHAR() { return getToken(GrammarParser.CHAR, 0); }
		public CharContext(TypesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterChar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitChar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitChar(this);
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
		enterRule(_localctx, 12, RULE_types);
		try {
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				match(INT);
				}
				break;
			case BOOL:
				_localctx = new BoolContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
				match(BOOL);
				}
				break;
			case CHAR:
				_localctx = new CharContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
				match(CHAR);
				}
				break;
			case STR:
				_localctx = new StrContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(193);
				match(STR);
				}
				break;
			case ARRAY:
				_localctx = new ArrayContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(194);
				match(ARRAY);
				setState(195);
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
		case 3:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u00c9\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\6\2\23\n\2\r\2"+
		"\16\2\24\3\2\3\2\3\3\3\3\5\3\33\n\3\3\3\6\3\36\n\3\r\3\16\3\37\3\3\3\3"+
		"\6\3$\n\3\r\3\16\3%\3\3\3\3\3\4\3\4\3\4\3\4\6\4.\n\4\r\4\16\4/\3\4\3\4"+
		"\3\4\3\4\3\4\6\4\67\n\4\r\4\16\48\3\4\3\4\7\4=\n\4\f\4\16\4@\13\4\3\4"+
		"\3\4\3\4\3\4\6\4F\n\4\r\4\16\4G\3\4\3\4\5\4L\n\4\3\4\3\4\5\4P\n\4\3\4"+
		"\3\4\3\4\5\4U\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\6\4`\n\4\r\4\16"+
		"\4a\3\4\3\4\3\4\3\4\3\4\6\4i\n\4\r\4\16\4j\3\4\3\4\3\4\3\4\3\4\6\4r\n"+
		"\4\r\4\16\4s\3\4\3\4\3\4\3\4\3\4\3\4\5\4|\n\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u008c\n\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u009e\n\5\f\5\16\5\u00a1"+
		"\13\5\5\5\u00a3\n\5\3\5\5\5\u00a6\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\7\5\u00b2\n\5\f\5\16\5\u00b5\13\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\5\7\u00bf\n\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00c7\n\b\3\b\2\3\b\t\2"+
		"\4\6\b\n\f\16\2\6\3\2\5\6\4\2\'(**\3\2\32\33\3\2\24\31\2\u00e6\2\22\3"+
		"\2\2\2\4\30\3\2\2\2\6\u008b\3\2\2\2\b\u00a5\3\2\2\2\n\u00b6\3\2\2\2\f"+
		"\u00be\3\2\2\2\16\u00c6\3\2\2\2\20\23\5\4\3\2\21\23\5\6\4\2\22\20\3\2"+
		"\2\2\22\21\3\2\2\2\23\24\3\2\2\2\24\22\3\2\2\2\24\25\3\2\2\2\25\26\3\2"+
		"\2\2\26\27\7\2\2\3\27\3\3\2\2\2\30\32\7\3\2\2\31\33\5\16\b\2\32\31\3\2"+
		"\2\2\32\33\3\2\2\2\33\35\3\2\2\2\34\36\7)\2\2\35\34\3\2\2\2\36\37\3\2"+
		"\2\2\37\35\3\2\2\2\37 \3\2\2\2 !\3\2\2\2!#\7\t\2\2\"$\5\6\4\2#\"\3\2\2"+
		"\2$%\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\'\3\2\2\2\'(\7\n\2\2(\5\3\2\2\2)*\7"+
		"\"\2\2*+\5\b\5\2+-\7\t\2\2,.\5\6\4\2-,\3\2\2\2./\3\2\2\2/-\3\2\2\2/\60"+
		"\3\2\2\2\60\61\3\2\2\2\61>\7\n\2\2\62\63\7#\2\2\63\64\5\b\5\2\64\66\7"+
		"\t\2\2\65\67\5\6\4\2\66\65\3\2\2\2\678\3\2\2\28\66\3\2\2\289\3\2\2\29"+
		":\3\2\2\2:;\7\n\2\2;=\3\2\2\2<\62\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2"+
		"\2?K\3\2\2\2@>\3\2\2\2AB\7$\2\2BC\5\b\5\2CE\7\t\2\2DF\5\6\4\2ED\3\2\2"+
		"\2FG\3\2\2\2GE\3\2\2\2GH\3\2\2\2HI\3\2\2\2IJ\7\n\2\2JL\3\2\2\2KA\3\2\2"+
		"\2KL\3\2\2\2L\u008c\3\2\2\2MO\7&\2\2NP\5\16\b\2ON\3\2\2\2OP\3\2\2\2PQ"+
		"\3\2\2\2QT\7)\2\2RS\7\22\2\2SU\5\b\5\2TR\3\2\2\2TU\3\2\2\2UV\3\2\2\2V"+
		"W\7\20\2\2WX\5\b\5\2XY\7\20\2\2YZ\7)\2\2Z[\7\22\2\2[\\\5\b\5\2\\]\7\20"+
		"\2\2]_\7\t\2\2^`\5\6\4\2_^\3\2\2\2`a\3\2\2\2a_\3\2\2\2ab\3\2\2\2bc\3\2"+
		"\2\2cd\7\n\2\2d\u008c\3\2\2\2ef\7\7\2\2fh\7\t\2\2gi\5\6\4\2hg\3\2\2\2"+
		"ij\3\2\2\2jh\3\2\2\2jk\3\2\2\2kl\3\2\2\2lm\7\n\2\2m\u008c\3\2\2\2no\7"+
		"\b\2\2oq\7\t\2\2pr\5\6\4\2qp\3\2\2\2rs\3\2\2\2sq\3\2\2\2st\3\2\2\2tu\3"+
		"\2\2\2uv\7\n\2\2v\u008c\3\2\2\2wx\5\16\b\2x{\7)\2\2yz\7\22\2\2z|\5\b\5"+
		"\2{y\3\2\2\2{|\3\2\2\2|}\3\2\2\2}~\7\20\2\2~\u008c\3\2\2\2\177\u0080\5"+
		"\f\7\2\u0080\u0081\7\22\2\2\u0081\u0082\5\b\5\2\u0082\u0083\7\20\2\2\u0083"+
		"\u008c\3\2\2\2\u0084\u0085\t\2\2\2\u0085\u0086\7)\2\2\u0086\u008c\7\20"+
		"\2\2\u0087\u0088\7\4\2\2\u0088\u0089\5\b\5\2\u0089\u008a\7\20\2\2\u008a"+
		"\u008c\3\2\2\2\u008b)\3\2\2\2\u008bM\3\2\2\2\u008be\3\2\2\2\u008bn\3\2"+
		"\2\2\u008bw\3\2\2\2\u008b\177\3\2\2\2\u008b\u0084\3\2\2\2\u008b\u0087"+
		"\3\2\2\2\u008c\7\3\2\2\2\u008d\u008e\b\5\1\2\u008e\u008f\7\13\2\2\u008f"+
		"\u0090\5\b\5\2\u0090\u0091\7\f\2\2\u0091\u00a6\3\2\2\2\u0092\u00a6\t\3"+
		"\2\2\u0093\u0094\7)\2\2\u0094\u0095\7\r\2\2\u0095\u0096\5\b\5\2\u0096"+
		"\u0097\7\16\2\2\u0097\u00a6\3\2\2\2\u0098\u00a6\7)\2\2\u0099\u00a2\7\r"+
		"\2\2\u009a\u009f\5\b\5\2\u009b\u009c\7\21\2\2\u009c\u009e\5\b\5\2\u009d"+
		"\u009b\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2"+
		"\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u009a\3\2\2\2\u00a2"+
		"\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6\7\16\2\2\u00a5\u008d\3"+
		"\2\2\2\u00a5\u0092\3\2\2\2\u00a5\u0093\3\2\2\2\u00a5\u0098\3\2\2\2\u00a5"+
		"\u0099\3\2\2\2\u00a6\u00b3\3\2\2\2\u00a7\u00a8\f\t\2\2\u00a8\u00a9\5\n"+
		"\6\2\u00a9\u00aa\5\b\5\n\u00aa\u00b2\3\2\2\2\u00ab\u00ac\f\b\2\2\u00ac"+
		"\u00ad\7\34\2\2\u00ad\u00b2\5\b\5\t\u00ae\u00af\f\7\2\2\u00af\u00b0\t"+
		"\4\2\2\u00b0\u00b2\5\b\5\b\u00b1\u00a7\3\2\2\2\u00b1\u00ab\3\2\2\2\u00b1"+
		"\u00ae\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2"+
		"\2\2\u00b4\t\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b7\t\5\2\2\u00b7\13"+
		"\3\2\2\2\u00b8\u00bf\7)\2\2\u00b9\u00ba\7)\2\2\u00ba\u00bb\7\r\2\2\u00bb"+
		"\u00bc\5\b\5\2\u00bc\u00bd\7\16\2\2\u00bd\u00bf\3\2\2\2\u00be\u00b8\3"+
		"\2\2\2\u00be\u00b9\3\2\2\2\u00bf\r\3\2\2\2\u00c0\u00c7\7\35\2\2\u00c1"+
		"\u00c7\7\36\2\2\u00c2\u00c7\7 \2\2\u00c3\u00c7\7\37\2\2\u00c4\u00c5\7"+
		"!\2\2\u00c5\u00c7\5\16\b\2\u00c6\u00c0\3\2\2\2\u00c6\u00c1\3\2\2\2\u00c6"+
		"\u00c2\3\2\2\2\u00c6\u00c3\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7\17\3\2\2"+
		"\2\32\22\24\32\37%/8>GKOTajs{\u008b\u009f\u00a2\u00a5\u00b1\u00b3\u00be"+
		"\u00c6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}