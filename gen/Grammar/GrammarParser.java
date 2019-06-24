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
		OCUR=1, CCUR=2, OPAR=3, CPAR=4, OSQR=5, CSQR=6, COL=7, SCOL=8, COM=9, 
		ASGN=10, EQ=11, NEQ=12, LT=13, LET=14, GT=15, GET=16, PLUS=17, MIN=18, 
		TIMES=19, INT=20, BOOL=21, STR=22, CHAR=23, ARRAY=24, IF=25, ELIF=26, 
		ELSE=27, WHILE=28, FOR=29, TRUE=30, FALSE=31, VARNAME=32, NUM=33, STRING=34, 
		WHITESPACE=35;
	public static final int
		RULE_program = 0, RULE_line = 1, RULE_list = 2, RULE_sqrlist = 3, RULE_expr = 4, 
		RULE_comp = 5, RULE_target = 6, RULE_types = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "line", "list", "sqrlist", "expr", "comp", "target", "types"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'('", "')'", "'['", "']'", "':'", "';'", "','", 
			"'='", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'*'", 
			"'Int'", "'Bool'", "'Str'", "'Char'", "'Arr'", "'if'", "'elif'", "'else'", 
			"'while'", "'for'", "'false'", "'true'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "OCUR", "CCUR", "OPAR", "CPAR", "OSQR", "CSQR", "COL", "SCOL", 
			"COM", "ASGN", "EQ", "NEQ", "LT", "LET", "GT", "GET", "PLUS", "MIN", 
			"TIMES", "INT", "BOOL", "STR", "CHAR", "ARRAY", "IF", "ELIF", "ELSE", 
			"WHILE", "FOR", "TRUE", "FALSE", "VARNAME", "NUM", "STRING", "WHITESPACE"
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
			setState(17); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(16);
				line();
				}
				}
				setState(19); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STR) | (1L << CHAR) | (1L << ARRAY) | (1L << IF) | (1L << FOR) | (1L << VARNAME))) != 0) );
			setState(21);
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
	public static class AsgnLineContext extends LineContext {
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TerminalNode ASGN() { return getToken(GrammarParser.ASGN, 0); }
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
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
	public static class AsgnArrLineContext extends LineContext {
		public TypesContext types() {
			return getRuleContext(TypesContext.class,0);
		}
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TerminalNode ASGN() { return getToken(GrammarParser.ASGN, 0); }
		public TerminalNode OSQR() { return getToken(GrammarParser.OSQR, 0); }
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public TerminalNode CSQR() { return getToken(GrammarParser.CSQR, 0); }
		public TerminalNode SCOL() { return getToken(GrammarParser.SCOL, 0); }
		public List<TerminalNode> ARRAY() { return getTokens(GrammarParser.ARRAY); }
		public TerminalNode ARRAY(int i) {
			return getToken(GrammarParser.ARRAY, i);
		}
		public AsgnArrLineContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterAsgnArrLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitAsgnArrLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitAsgnArrLine(this);
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
		enterRule(_localctx, 2, RULE_line);
		int _la;
		try {
			int _alt;
			setState(108);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new IfLineContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(23);
				match(IF);
				setState(24);
				expr(0);
				setState(25);
				match(OCUR);
				setState(27); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(26);
					line();
					}
					}
					setState(29); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STR) | (1L << CHAR) | (1L << ARRAY) | (1L << IF) | (1L << FOR) | (1L << VARNAME))) != 0) );
				setState(31);
				match(CCUR);
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ELIF) {
					{
					{
					setState(32);
					match(ELIF);
					setState(33);
					expr(0);
					setState(34);
					match(OCUR);
					setState(36); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(35);
						line();
						}
						}
						setState(38); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STR) | (1L << CHAR) | (1L << ARRAY) | (1L << IF) | (1L << FOR) | (1L << VARNAME))) != 0) );
					setState(40);
					match(CCUR);
					}
					}
					setState(46);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(47);
					match(ELSE);
					setState(48);
					expr(0);
					setState(49);
					match(OCUR);
					setState(51); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(50);
						line();
						}
						}
						setState(53); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STR) | (1L << CHAR) | (1L << ARRAY) | (1L << IF) | (1L << FOR) | (1L << VARNAME))) != 0) );
					setState(55);
					match(CCUR);
					}
				}

				}
				break;
			case 2:
				_localctx = new ForLineContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				match(FOR);
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STR) | (1L << CHAR) | (1L << ARRAY))) != 0)) {
					{
					setState(60);
					types();
					}
				}

				setState(63);
				match(VARNAME);
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASGN) {
					{
					setState(64);
					match(ASGN);
					setState(65);
					expr(0);
					}
				}

				setState(68);
				match(SCOL);
				setState(69);
				expr(0);
				setState(70);
				match(SCOL);
				setState(71);
				match(VARNAME);
				setState(72);
				match(ASGN);
				setState(73);
				expr(0);
				setState(74);
				match(SCOL);
				setState(75);
				match(OCUR);
				setState(77); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(76);
					line();
					}
					}
					setState(79); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STR) | (1L << CHAR) | (1L << ARRAY) | (1L << IF) | (1L << FOR) | (1L << VARNAME))) != 0) );
				setState(81);
				match(CCUR);
				}
				break;
			case 3:
				_localctx = new DeclLineContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(83);
				types();
				setState(84);
				match(VARNAME);
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASGN) {
					{
					setState(85);
					match(ASGN);
					setState(86);
					expr(0);
					}
				}

				setState(89);
				match(SCOL);
				}
				break;
			case 4:
				_localctx = new AsgnLineContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(91);
				target();
				setState(92);
				match(ASGN);
				setState(93);
				list();
				}
				break;
			case 5:
				_localctx = new AsgnArrLineContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(96); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(95);
						match(ARRAY);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(98); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(100);
				types();
				setState(101);
				target();
				setState(102);
				match(ASGN);
				setState(103);
				match(OSQR);
				setState(104);
				list();
				setState(105);
				match(CSQR);
				setState(106);
				match(SCOL);
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

	public static class ListContext extends ParserRuleContext {
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
	 
		public ListContext() { }
		public void copyFrom(ListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NestedListContext extends ListContext {
		public SqrlistContext sqrlist() {
			return getRuleContext(SqrlistContext.class,0);
		}
		public NestedListContext(ListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterNestedList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitNestedList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitNestedList(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CommaListContext extends ListContext {
		public List<SqrlistContext> sqrlist() {
			return getRuleContexts(SqrlistContext.class);
		}
		public SqrlistContext sqrlist(int i) {
			return getRuleContext(SqrlistContext.class,i);
		}
		public List<TerminalNode> COM() { return getTokens(GrammarParser.COM); }
		public TerminalNode COM(int i) {
			return getToken(GrammarParser.COM, i);
		}
		public CommaListContext(ListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterCommaList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitCommaList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitCommaList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_list);
		int _la;
		try {
			setState(121);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new CommaListContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OSQR) {
					{
					setState(110);
					sqrlist();
					setState(115);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COM) {
						{
						{
						setState(111);
						match(COM);
						setState(112);
						sqrlist();
						}
						}
						setState(117);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				}
				break;
			case 2:
				_localctx = new NestedListContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				sqrlist();
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

	public static class SqrlistContext extends ParserRuleContext {
		public SqrlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqrlist; }
	 
		public SqrlistContext() { }
		public void copyFrom(SqrlistContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprListContext extends SqrlistContext {
		public TerminalNode OSQR() { return getToken(GrammarParser.OSQR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CSQR() { return getToken(GrammarParser.CSQR, 0); }
		public ExprListContext(SqrlistContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitExprList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitExprList(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NestedContext extends SqrlistContext {
		public TerminalNode OSQR() { return getToken(GrammarParser.OSQR, 0); }
		public SqrlistContext sqrlist() {
			return getRuleContext(SqrlistContext.class,0);
		}
		public TerminalNode CSQR() { return getToken(GrammarParser.CSQR, 0); }
		public NestedContext(SqrlistContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterNested(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitNested(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitNested(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SqrlistContext sqrlist() throws RecognitionException {
		SqrlistContext _localctx = new SqrlistContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sqrlist);
		try {
			setState(131);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new NestedContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				match(OSQR);
				setState(124);
				sqrlist();
				setState(125);
				match(CSQR);
				}
				break;
			case 2:
				_localctx = new ExprListContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				match(OSQR);
				setState(128);
				expr(0);
				setState(129);
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
	public static class AddExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(GrammarParser.PLUS, 0); }
		public AddExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitAddExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitAddExpr(this);
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
	public static class SubExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MIN() { return getToken(GrammarParser.MIN, 0); }
		public SubExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterSubExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitSubExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitSubExpr(this);
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
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				_localctx = new ConstExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(134);
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
			case 2:
				{
				_localctx = new ArrExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(135);
				match(VARNAME);
				setState(136);
				match(OSQR);
				setState(137);
				expr(0);
				setState(138);
				match(CSQR);
				}
				break;
			case 3:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(140);
				match(VARNAME);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(158);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(156);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new CompExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(143);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(144);
						comp();
						setState(145);
						expr(8);
						}
						break;
					case 2:
						{
						_localctx = new AddExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(147);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(148);
						match(PLUS);
						setState(149);
						expr(7);
						}
						break;
					case 3:
						{
						_localctx = new SubExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(150);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(151);
						match(MIN);
						setState(152);
						expr(6);
						}
						break;
					case 4:
						{
						_localctx = new MultExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(153);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(154);
						match(TIMES);
						setState(155);
						expr(5);
						}
						break;
					}
					} 
				}
				setState(160);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
			setState(161);
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
			setState(169);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new VarTargetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				match(VARNAME);
				}
				break;
			case 2:
				_localctx = new ArrayTargetContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				match(VARNAME);
				setState(165);
				match(OSQR);
				setState(166);
				expr(0);
				setState(167);
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
		enterRule(_localctx, 14, RULE_types);
		try {
			setState(177);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				match(INT);
				}
				break;
			case BOOL:
				_localctx = new BoolContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				match(BOOL);
				}
				break;
			case CHAR:
				_localctx = new CharContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(173);
				match(CHAR);
				}
				break;
			case STR:
				_localctx = new StrContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(174);
				match(STR);
				}
				break;
			case ARRAY:
				_localctx = new ArrayContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(175);
				match(ARRAY);
				setState(176);
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
		case 3:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3%\u00b6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\6\2\24\n\2"+
		"\r\2\16\2\25\3\2\3\2\3\3\3\3\3\3\3\3\6\3\36\n\3\r\3\16\3\37\3\3\3\3\3"+
		"\3\3\3\3\3\6\3\'\n\3\r\3\16\3(\3\3\3\3\7\3-\n\3\f\3\16\3\60\13\3\3\3\3"+
		"\3\3\3\3\3\6\3\66\n\3\r\3\16\3\67\3\3\3\3\5\3<\n\3\3\3\3\3\5\3@\n\3\3"+
		"\3\3\3\3\3\5\3E\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3P\n\3\r\3\16"+
		"\3Q\3\3\3\3\3\3\3\3\3\3\3\3\5\3Z\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3c"+
		"\n\3\r\3\16\3d\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3o\n\3\3\4\3\4\3\4\7"+
		"\4t\n\4\f\4\16\4w\13\4\5\4y\n\4\3\4\5\4|\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\5\5\u0086\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0090\n\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u009f\n\6\f\6\16"+
		"\6\u00a2\13\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00ac\n\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\5\t\u00b4\n\t\3\t\2\3\n\n\2\4\6\b\n\f\16\20\2\4\4\2 !#"+
		"#\3\2\r\22\2\u00cb\2\23\3\2\2\2\4n\3\2\2\2\6{\3\2\2\2\b\u0085\3\2\2\2"+
		"\n\u008f\3\2\2\2\f\u00a3\3\2\2\2\16\u00ab\3\2\2\2\20\u00b3\3\2\2\2\22"+
		"\24\5\4\3\2\23\22\3\2\2\2\24\25\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26"+
		"\27\3\2\2\2\27\30\7\2\2\3\30\3\3\2\2\2\31\32\7\33\2\2\32\33\5\n\6\2\33"+
		"\35\7\3\2\2\34\36\5\4\3\2\35\34\3\2\2\2\36\37\3\2\2\2\37\35\3\2\2\2\37"+
		" \3\2\2\2 !\3\2\2\2!.\7\4\2\2\"#\7\34\2\2#$\5\n\6\2$&\7\3\2\2%\'\5\4\3"+
		"\2&%\3\2\2\2\'(\3\2\2\2(&\3\2\2\2()\3\2\2\2)*\3\2\2\2*+\7\4\2\2+-\3\2"+
		"\2\2,\"\3\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/;\3\2\2\2\60.\3\2\2\2"+
		"\61\62\7\35\2\2\62\63\5\n\6\2\63\65\7\3\2\2\64\66\5\4\3\2\65\64\3\2\2"+
		"\2\66\67\3\2\2\2\67\65\3\2\2\2\678\3\2\2\289\3\2\2\29:\7\4\2\2:<\3\2\2"+
		"\2;\61\3\2\2\2;<\3\2\2\2<o\3\2\2\2=?\7\37\2\2>@\5\20\t\2?>\3\2\2\2?@\3"+
		"\2\2\2@A\3\2\2\2AD\7\"\2\2BC\7\f\2\2CE\5\n\6\2DB\3\2\2\2DE\3\2\2\2EF\3"+
		"\2\2\2FG\7\n\2\2GH\5\n\6\2HI\7\n\2\2IJ\7\"\2\2JK\7\f\2\2KL\5\n\6\2LM\7"+
		"\n\2\2MO\7\3\2\2NP\5\4\3\2ON\3\2\2\2PQ\3\2\2\2QO\3\2\2\2QR\3\2\2\2RS\3"+
		"\2\2\2ST\7\4\2\2To\3\2\2\2UV\5\20\t\2VY\7\"\2\2WX\7\f\2\2XZ\5\n\6\2YW"+
		"\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2[\\\7\n\2\2\\o\3\2\2\2]^\5\16\b\2^_\7\f\2"+
		"\2_`\5\6\4\2`o\3\2\2\2ac\7\32\2\2ba\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3\2"+
		"\2\2ef\3\2\2\2fg\5\20\t\2gh\5\16\b\2hi\7\f\2\2ij\7\7\2\2jk\5\6\4\2kl\7"+
		"\b\2\2lm\7\n\2\2mo\3\2\2\2n\31\3\2\2\2n=\3\2\2\2nU\3\2\2\2n]\3\2\2\2n"+
		"b\3\2\2\2o\5\3\2\2\2pu\5\b\5\2qr\7\13\2\2rt\5\b\5\2sq\3\2\2\2tw\3\2\2"+
		"\2us\3\2\2\2uv\3\2\2\2vy\3\2\2\2wu\3\2\2\2xp\3\2\2\2xy\3\2\2\2y|\3\2\2"+
		"\2z|\5\b\5\2{x\3\2\2\2{z\3\2\2\2|\7\3\2\2\2}~\7\7\2\2~\177\5\b\5\2\177"+
		"\u0080\7\b\2\2\u0080\u0086\3\2\2\2\u0081\u0082\7\7\2\2\u0082\u0083\5\n"+
		"\6\2\u0083\u0084\7\b\2\2\u0084\u0086\3\2\2\2\u0085}\3\2\2\2\u0085\u0081"+
		"\3\2\2\2\u0086\t\3\2\2\2\u0087\u0088\b\6\1\2\u0088\u0090\t\2\2\2\u0089"+
		"\u008a\7\"\2\2\u008a\u008b\7\7\2\2\u008b\u008c\5\n\6\2\u008c\u008d\7\b"+
		"\2\2\u008d\u0090\3\2\2\2\u008e\u0090\7\"\2\2\u008f\u0087\3\2\2\2\u008f"+
		"\u0089\3\2\2\2\u008f\u008e\3\2\2\2\u0090\u00a0\3\2\2\2\u0091\u0092\f\t"+
		"\2\2\u0092\u0093\5\f\7\2\u0093\u0094\5\n\6\n\u0094\u009f\3\2\2\2\u0095"+
		"\u0096\f\b\2\2\u0096\u0097\7\23\2\2\u0097\u009f\5\n\6\t\u0098\u0099\f"+
		"\7\2\2\u0099\u009a\7\24\2\2\u009a\u009f\5\n\6\b\u009b\u009c\f\6\2\2\u009c"+
		"\u009d\7\25\2\2\u009d\u009f\5\n\6\7\u009e\u0091\3\2\2\2\u009e\u0095\3"+
		"\2\2\2\u009e\u0098\3\2\2\2\u009e\u009b\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0"+
		"\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\13\3\2\2\2\u00a2\u00a0\3\2\2"+
		"\2\u00a3\u00a4\t\3\2\2\u00a4\r\3\2\2\2\u00a5\u00ac\7\"\2\2\u00a6\u00a7"+
		"\7\"\2\2\u00a7\u00a8\7\7\2\2\u00a8\u00a9\5\n\6\2\u00a9\u00aa\7\b\2\2\u00aa"+
		"\u00ac\3\2\2\2\u00ab\u00a5\3\2\2\2\u00ab\u00a6\3\2\2\2\u00ac\17\3\2\2"+
		"\2\u00ad\u00b4\7\26\2\2\u00ae\u00b4\7\27\2\2\u00af\u00b4\7\31\2\2\u00b0"+
		"\u00b4\7\30\2\2\u00b1\u00b2\7\32\2\2\u00b2\u00b4\5\20\t\2\u00b3\u00ad"+
		"\3\2\2\2\u00b3\u00ae\3\2\2\2\u00b3\u00af\3\2\2\2\u00b3\u00b0\3\2\2\2\u00b3"+
		"\u00b1\3\2\2\2\u00b4\21\3\2\2\2\27\25\37(.\67;?DQYdnux{\u0085\u008f\u009e"+
		"\u00a0\u00ab\u00b3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}