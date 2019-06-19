// Generated from C:/Users/Gibson/Nextcloud/Technical Computer Science/year2/module8/mod8-project/src/Grammar\Grammar.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"OCUR", "CCUR", "OPAR", "CPAR", "OSQR", "CSQR", "COL", "SCOL", "COM", 
			"ASGN", "EQ", "NEQ", "LT", "LET", "GT", "GET", "PLUS", "MIN", "TIMES", 
			"INT", "BOOL", "STR", "CHAR", "ARRAY", "IF", "ELIF", "ELSE", "WHILE", 
			"FOR", "TRUE", "FALSE", "LOWERCASE", "UPPERCASE", "LETTER", "DIGIT", 
			"COMP", "VARNAME", "NUM", "STRING", "WHITESPACE"
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2%\u00e6\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3"+
		"\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3"+
		"\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3"+
		"\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3"+
		"\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3 \3 \3 \3 \3 \3!\3!\3\"\3\"\3#\3#\5#\u00bc\n#\3$\3$\3%\3%\3"+
		"%\3%\3%\3%\5%\u00c6\n%\3&\3&\3&\7&\u00cb\n&\f&\16&\u00ce\13&\3\'\6\'\u00d1"+
		"\n\'\r\'\16\'\u00d2\3(\3(\3(\3(\7(\u00d9\n(\f(\16(\u00dc\13(\3(\3(\3)"+
		"\6)\u00e1\n)\r)\16)\u00e2\3)\3)\2\2*\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\2C\2E\2G\2I\2K\"M#O$Q%\3\2\7"+
		"\3\2c|\3\2C\\\3\2\62;\4\2$$^^\5\2\13\f\17\17\"\"\2\u00ec\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2"+
		"\2\2?\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\3S\3\2\2\2\5"+
		"U\3\2\2\2\7W\3\2\2\2\tY\3\2\2\2\13[\3\2\2\2\r]\3\2\2\2\17_\3\2\2\2\21"+
		"a\3\2\2\2\23c\3\2\2\2\25e\3\2\2\2\27g\3\2\2\2\31j\3\2\2\2\33m\3\2\2\2"+
		"\35o\3\2\2\2\37r\3\2\2\2!t\3\2\2\2#w\3\2\2\2%y\3\2\2\2\'{\3\2\2\2)}\3"+
		"\2\2\2+\u0081\3\2\2\2-\u0086\3\2\2\2/\u008a\3\2\2\2\61\u008f\3\2\2\2\63"+
		"\u0093\3\2\2\2\65\u0096\3\2\2\2\67\u009b\3\2\2\29\u00a0\3\2\2\2;\u00a6"+
		"\3\2\2\2=\u00aa\3\2\2\2?\u00b0\3\2\2\2A\u00b5\3\2\2\2C\u00b7\3\2\2\2E"+
		"\u00bb\3\2\2\2G\u00bd\3\2\2\2I\u00c5\3\2\2\2K\u00c7\3\2\2\2M\u00d0\3\2"+
		"\2\2O\u00d4\3\2\2\2Q\u00e0\3\2\2\2ST\7}\2\2T\4\3\2\2\2UV\7\177\2\2V\6"+
		"\3\2\2\2WX\7*\2\2X\b\3\2\2\2YZ\7+\2\2Z\n\3\2\2\2[\\\7]\2\2\\\f\3\2\2\2"+
		"]^\7_\2\2^\16\3\2\2\2_`\7<\2\2`\20\3\2\2\2ab\7=\2\2b\22\3\2\2\2cd\7.\2"+
		"\2d\24\3\2\2\2ef\7?\2\2f\26\3\2\2\2gh\7?\2\2hi\7?\2\2i\30\3\2\2\2jk\7"+
		"#\2\2kl\7?\2\2l\32\3\2\2\2mn\7>\2\2n\34\3\2\2\2op\7>\2\2pq\7?\2\2q\36"+
		"\3\2\2\2rs\7@\2\2s \3\2\2\2tu\7@\2\2uv\7?\2\2v\"\3\2\2\2wx\7-\2\2x$\3"+
		"\2\2\2yz\7/\2\2z&\3\2\2\2{|\7,\2\2|(\3\2\2\2}~\7K\2\2~\177\7p\2\2\177"+
		"\u0080\7v\2\2\u0080*\3\2\2\2\u0081\u0082\7D\2\2\u0082\u0083\7q\2\2\u0083"+
		"\u0084\7q\2\2\u0084\u0085\7n\2\2\u0085,\3\2\2\2\u0086\u0087\7U\2\2\u0087"+
		"\u0088\7v\2\2\u0088\u0089\7t\2\2\u0089.\3\2\2\2\u008a\u008b\7E\2\2\u008b"+
		"\u008c\7j\2\2\u008c\u008d\7c\2\2\u008d\u008e\7t\2\2\u008e\60\3\2\2\2\u008f"+
		"\u0090\7C\2\2\u0090\u0091\7t\2\2\u0091\u0092\7t\2\2\u0092\62\3\2\2\2\u0093"+
		"\u0094\7k\2\2\u0094\u0095\7h\2\2\u0095\64\3\2\2\2\u0096\u0097\7g\2\2\u0097"+
		"\u0098\7n\2\2\u0098\u0099\7k\2\2\u0099\u009a\7h\2\2\u009a\66\3\2\2\2\u009b"+
		"\u009c\7g\2\2\u009c\u009d\7n\2\2\u009d\u009e\7u\2\2\u009e\u009f\7g\2\2"+
		"\u009f8\3\2\2\2\u00a0\u00a1\7y\2\2\u00a1\u00a2\7j\2\2\u00a2\u00a3\7k\2"+
		"\2\u00a3\u00a4\7n\2\2\u00a4\u00a5\7g\2\2\u00a5:\3\2\2\2\u00a6\u00a7\7"+
		"h\2\2\u00a7\u00a8\7q\2\2\u00a8\u00a9\7t\2\2\u00a9<\3\2\2\2\u00aa\u00ab"+
		"\7h\2\2\u00ab\u00ac\7c\2\2\u00ac\u00ad\7n\2\2\u00ad\u00ae\7u\2\2\u00ae"+
		"\u00af\7g\2\2\u00af>\3\2\2\2\u00b0\u00b1\7v\2\2\u00b1\u00b2\7t\2\2\u00b2"+
		"\u00b3\7w\2\2\u00b3\u00b4\7g\2\2\u00b4@\3\2\2\2\u00b5\u00b6\t\2\2\2\u00b6"+
		"B\3\2\2\2\u00b7\u00b8\t\3\2\2\u00b8D\3\2\2\2\u00b9\u00bc\5C\"\2\u00ba"+
		"\u00bc\5A!\2\u00bb\u00b9\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bcF\3\2\2\2\u00bd"+
		"\u00be\t\4\2\2\u00beH\3\2\2\2\u00bf\u00c6\5\27\f\2\u00c0\u00c6\5\31\r"+
		"\2\u00c1\u00c6\5\33\16\2\u00c2\u00c6\5\35\17\2\u00c3\u00c6\5\37\20\2\u00c4"+
		"\u00c6\5!\21\2\u00c5\u00bf\3\2\2\2\u00c5\u00c0\3\2\2\2\u00c5\u00c1\3\2"+
		"\2\2\u00c5\u00c2\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6"+
		"J\3\2\2\2\u00c7\u00cc\5A!\2\u00c8\u00cb\5E#\2\u00c9\u00cb\5G$\2\u00ca"+
		"\u00c8\3\2\2\2\u00ca\u00c9\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2"+
		"\2\2\u00cc\u00cd\3\2\2\2\u00cdL\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d1"+
		"\5G$\2\u00d0\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3N\3\2\2\2\u00d4\u00da\7$\2\2\u00d5\u00d9\n\5\2\2\u00d6"+
		"\u00d7\7^\2\2\u00d7\u00d9\13\2\2\2\u00d8\u00d5\3\2\2\2\u00d8\u00d6\3\2"+
		"\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db"+
		"\u00dd\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00de\7$\2\2\u00deP\3\2\2\2\u00df"+
		"\u00e1\t\6\2\2\u00e0\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e0\3\2"+
		"\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\b)\2\2\u00e5"+
		"R\3\2\2\2\13\2\u00bb\u00c5\u00ca\u00cc\u00d2\u00d8\u00da\u00e2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}