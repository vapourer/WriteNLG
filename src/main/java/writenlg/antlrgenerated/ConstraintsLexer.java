// Generated from Constraints.g4 by ANTLR 4.7
package writenlg.antlrgenerated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ConstraintsLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, GLOBAL_CONCEPT=4, TIME_SERIES_CONCEPT=5, GLOBAL_CONCEPT_TYPE=6, 
		TIME_SERIES_CONCEPT_TYPE=7, CONSTRAINT_NAME=8, INITIAL_VALUE=9, WEIGHTING=10, 
		STRING=11, DIGIT=12, NEW_LINE=13, WHITE_SPACE=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "GLOBAL_CONCEPT", "TIME_SERIES_CONCEPT", "GLOBAL_CONCEPT_TYPE", 
		"TIME_SERIES_CONCEPT_TYPE", "CONSTRAINT_NAME", "INITIAL_VALUE", "WEIGHTING", 
		"STRING", "DIGIT", "NEW_LINE", "WHITE_SPACE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'('", "')'", "'GlobalConcept'", "'TimeSeriesConcept'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "GLOBAL_CONCEPT", "TIME_SERIES_CONCEPT", "GLOBAL_CONCEPT_TYPE", 
		"TIME_SERIES_CONCEPT_TYPE", "CONSTRAINT_NAME", "INITIAL_VALUE", "WEIGHTING", 
		"STRING", "DIGIT", "NEW_LINE", "WHITE_SPACE"
	};
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


	public ConstraintsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Constraints.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20\u0209\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7c\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\5\b\u00a6\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\5\t\u01de\n\t\3\n\6\n\u01e1\n\n\r\n\16\n\u01e2\3\n\3"+
		"\n\6\n\u01e7\n\n\r\n\16\n\u01e8\3\n\3\n\6\n\u01ed\n\n\r\n\16\n\u01ee\5"+
		"\n\u01f1\n\n\3\13\3\13\3\f\3\f\7\f\u01f7\n\f\f\f\16\f\u01fa\13\f\3\r\3"+
		"\r\3\16\5\16\u01ff\n\16\3\16\3\16\3\17\6\17\u0204\n\17\r\17\16\17\u0205"+
		"\3\17\3\17\2\2\20\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\3\2\6\3\2\63\67\5\2\62;C\\c|\3\2\62;\4\2\13\13\"\"\2\u0225"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\3\37\3\2\2\2\5!\3\2\2\2\7#\3\2"+
		"\2\2\t%\3\2\2\2\13\63\3\2\2\2\rb\3\2\2\2\17\u00a5\3\2\2\2\21\u01dd\3\2"+
		"\2\2\23\u01f0\3\2\2\2\25\u01f2\3\2\2\2\27\u01f4\3\2\2\2\31\u01fb\3\2\2"+
		"\2\33\u01fe\3\2\2\2\35\u0203\3\2\2\2\37 \7?\2\2 \4\3\2\2\2!\"\7*\2\2\""+
		"\6\3\2\2\2#$\7+\2\2$\b\3\2\2\2%&\7I\2\2&\'\7n\2\2\'(\7q\2\2()\7d\2\2)"+
		"*\7c\2\2*+\7n\2\2+,\7E\2\2,-\7q\2\2-.\7p\2\2./\7e\2\2/\60\7g\2\2\60\61"+
		"\7r\2\2\61\62\7v\2\2\62\n\3\2\2\2\63\64\7V\2\2\64\65\7k\2\2\65\66\7o\2"+
		"\2\66\67\7g\2\2\678\7U\2\289\7g\2\29:\7t\2\2:;\7k\2\2;<\7g\2\2<=\7u\2"+
		"\2=>\7E\2\2>?\7q\2\2?@\7p\2\2@A\7e\2\2AB\7g\2\2BC\7r\2\2CD\7v\2\2D\f\3"+
		"\2\2\2EF\7N\2\2FG\7K\2\2GH\7P\2\2HI\7G\2\2IJ\7U\2\2JK\7a\2\2KL\7E\2\2"+
		"LM\7T\2\2MN\7Q\2\2NO\7U\2\2Oc\7U\2\2PQ\7N\2\2QR\7K\2\2RS\7P\2\2ST\7G\2"+
		"\2TU\7U\2\2UV\7a\2\2VW\7F\2\2WX\7Q\2\2XY\7a\2\2YZ\7P\2\2Z[\7Q\2\2[\\\7"+
		"V\2\2\\]\7a\2\2]^\7E\2\2^_\7T\2\2_`\7Q\2\2`a\7U\2\2ac\7U\2\2bE\3\2\2\2"+
		"bP\3\2\2\2c\16\3\2\2\2de\7O\2\2ef\7C\2\2fg\7Z\2\2gh\7K\2\2hi\7O\2\2ij"+
		"\7W\2\2j\u00a6\7O\2\2kl\7O\2\2lm\7K\2\2mn\7P\2\2no\7K\2\2op\7O\2\2pq\7"+
		"W\2\2q\u00a6\7O\2\2rs\7T\2\2st\7K\2\2tu\7U\2\2uv\7K\2\2vw\7P\2\2wx\7I"+
		"\2\2xy\7a\2\2yz\7V\2\2z{\7T\2\2{|\7G\2\2|}\7P\2\2}\u00a6\7F\2\2~\177\7"+
		"F\2\2\177\u0080\7G\2\2\u0080\u0081\7U\2\2\u0081\u0082\7E\2\2\u0082\u0083"+
		"\7G\2\2\u0083\u0084\7P\2\2\u0084\u0085\7F\2\2\u0085\u0086\7K\2\2\u0086"+
		"\u0087\7P\2\2\u0087\u0088\7I\2\2\u0088\u0089\7a\2\2\u0089\u008a\7V\2\2"+
		"\u008a\u008b\7T\2\2\u008b\u008c\7G\2\2\u008c\u008d\7P\2\2\u008d\u00a6"+
		"\7F\2\2\u008e\u008f\7U\2\2\u008f\u0090\7G\2\2\u0090\u0091\7T\2\2\u0091"+
		"\u0092\7K\2\2\u0092\u0093\7G\2\2\u0093\u0094\7U\2\2\u0094\u0095\7a\2\2"+
		"\u0095\u0096\7N\2\2\u0096\u0097\7G\2\2\u0097\u0098\7I\2\2\u0098\u0099"+
		"\7G\2\2\u0099\u009a\7P\2\2\u009a\u00a6\7F\2\2\u009b\u009c\7V\2\2\u009c"+
		"\u009d\7K\2\2\u009d\u009e\7O\2\2\u009e\u009f\7G\2\2\u009f\u00a0\7a\2\2"+
		"\u00a0\u00a1\7U\2\2\u00a1\u00a2\7N\2\2\u00a2\u00a3\7K\2\2\u00a3\u00a4"+
		"\7E\2\2\u00a4\u00a6\7G\2\2\u00a5d\3\2\2\2\u00a5k\3\2\2\2\u00a5r\3\2\2"+
		"\2\u00a5~\3\2\2\2\u00a5\u008e\3\2\2\2\u00a5\u009b\3\2\2\2\u00a6\20\3\2"+
		"\2\2\u00a7\u00a8\7N\2\2\u00a8\u00a9\7k\2\2\u00a9\u00aa\7p\2\2\u00aa\u00ab"+
		"\7g\2\2\u00ab\u00ac\7u\2\2\u00ac\u00ad\7E\2\2\u00ad\u00ae\7t\2\2\u00ae"+
		"\u00af\7q\2\2\u00af\u00b0\7u\2\2\u00b0\u01de\7u\2\2\u00b1\u00b2\7N\2\2"+
		"\u00b2\u00b3\7k\2\2\u00b3\u00b4\7p\2\2\u00b4\u00b5\7g\2\2\u00b5\u00b6"+
		"\7u\2\2\u00b6\u00b7\7E\2\2\u00b7\u00b8\7t\2\2\u00b8\u00b9\7q\2\2\u00b9"+
		"\u00ba\7u\2\2\u00ba\u00bb\7u\2\2\u00bb\u00bc\7O\2\2\u00bc\u00bd\7w\2\2"+
		"\u00bd\u00be\7n\2\2\u00be\u00bf\7v\2\2\u00bf\u00c0\7k\2\2\u00c0\u00c1"+
		"\7r\2\2\u00c1\u00c2\7n\2\2\u00c2\u00c3\7g\2\2\u00c3\u00c4\7V\2\2\u00c4"+
		"\u00c5\7k\2\2\u00c5\u00c6\7o\2\2\u00c6\u00c7\7g\2\2\u00c7\u01de\7u\2\2"+
		"\u00c8\u00c9\7N\2\2\u00c9\u00ca\7k\2\2\u00ca\u00cb\7p\2\2\u00cb\u00cc"+
		"\7g\2\2\u00cc\u00cd\7u\2\2\u00cd\u00ce\7F\2\2\u00ce\u00cf\7q\2\2\u00cf"+
		"\u00d0\7P\2\2\u00d0\u00d1\7q\2\2\u00d1\u00d2\7v\2\2\u00d2\u00d3\7E\2\2"+
		"\u00d3\u00d4\7t\2\2\u00d4\u00d5\7q\2\2\u00d5\u00d6\7u\2\2\u00d6\u01de"+
		"\7u\2\2\u00d7\u00d8\7U\2\2\u00d8\u00d9\7g\2\2\u00d9\u00da\7t\2\2\u00da"+
		"\u00db\7k\2\2\u00db\u00dc\7g\2\2\u00dc\u00dd\7u\2\2\u00dd\u00de\7N\2\2"+
		"\u00de\u00df\7g\2\2\u00df\u00e0\7i\2\2\u00e0\u00e1\7g\2\2\u00e1\u00e2"+
		"\7p\2\2\u00e2\u00e3\7f\2\2\u00e3\u00e4\7T\2\2\u00e4\u00e5\7g\2\2\u00e5"+
		"\u00e6\7s\2\2\u00e6\u00e7\7w\2\2\u00e7\u00e8\7k\2\2\u00e8\u00e9\7t\2\2"+
		"\u00e9\u00ea\7g\2\2\u00ea\u01de\7f\2\2\u00eb\u00ec\7U\2\2\u00ec\u00ed"+
		"\7k\2\2\u00ed\u00ee\7p\2\2\u00ee\u00ef\7i\2\2\u00ef\u00f0\7n\2\2\u00f0"+
		"\u00f1\7g\2\2\u00f1\u00f2\7Q\2\2\u00f2\u00f3\7d\2\2\u00f3\u00f4\7x\2\2"+
		"\u00f4\u00f5\7k\2\2\u00f5\u00f6\7q\2\2\u00f6\u00f7\7w\2\2\u00f7\u00f8"+
		"\7u\2\2\u00f8\u00f9\7O\2\2\u00f9\u00fa\7c\2\2\u00fa\u00fb\7z\2\2\u00fb"+
		"\u00fc\7k\2\2\u00fc\u00fd\7o\2\2\u00fd\u00fe\7w\2\2\u00fe\u01de\7o\2\2"+
		"\u00ff\u0100\7O\2\2\u0100\u0101\7w\2\2\u0101\u0102\7n\2\2\u0102\u0103"+
		"\7v\2\2\u0103\u0104\7k\2\2\u0104\u0105\7r\2\2\u0105\u0106\7n\2\2\u0106"+
		"\u0107\7g\2\2\u0107\u0108\7J\2\2\u0108\u0109\7k\2\2\u0109\u010a\7i\2\2"+
		"\u010a\u010b\7j\2\2\u010b\u010c\7V\2\2\u010c\u010d\7w\2\2\u010d\u010e"+
		"\7t\2\2\u010e\u010f\7p\2\2\u010f\u0110\7k\2\2\u0110\u0111\7p\2\2\u0111"+
		"\u0112\7i\2\2\u0112\u0113\7R\2\2\u0113\u0114\7q\2\2\u0114\u0115\7k\2\2"+
		"\u0115\u0116\7p\2\2\u0116\u0117\7v\2\2\u0117\u01de\7u\2\2\u0118\u0119"+
		"\7O\2\2\u0119\u011a\7c\2\2\u011a\u011b\7z\2\2\u011b\u011c\7k\2\2\u011c"+
		"\u011d\7o\2\2\u011d\u011e\7w\2\2\u011e\u011f\7o\2\2\u011f\u0120\7C\2\2"+
		"\u0120\u0121\7v\2\2\u0121\u0122\7U\2\2\u0122\u0123\7v\2\2\u0123\u0124"+
		"\7c\2\2\u0124\u0125\7t\2\2\u0125\u01de\7v\2\2\u0126\u0127\7O\2\2\u0127"+
		"\u0128\7c\2\2\u0128\u0129\7z\2\2\u0129\u012a\7k\2\2\u012a\u012b\7o\2\2"+
		"\u012b\u012c\7w\2\2\u012c\u012d\7o\2\2\u012d\u012e\7C\2\2\u012e\u012f"+
		"\7v\2\2\u012f\u0130\7G\2\2\u0130\u0131\7p\2\2\u0131\u01de\7f\2\2\u0132"+
		"\u0133\7U\2\2\u0133\u0134\7k\2\2\u0134\u0135\7p\2\2\u0135\u0136\7i\2\2"+
		"\u0136\u0137\7n\2\2\u0137\u0138\7g\2\2\u0138\u0139\7Q\2\2\u0139\u013a"+
		"\7d\2\2\u013a\u013b\7x\2\2\u013b\u013c\7k\2\2\u013c\u013d\7q\2\2\u013d"+
		"\u013e\7w\2\2\u013e\u013f\7u\2\2\u013f\u0140\7O\2\2\u0140\u0141\7k\2\2"+
		"\u0141\u0142\7p\2\2\u0142\u0143\7k\2\2\u0143\u0144\7o\2\2\u0144\u0145"+
		"\7w\2\2\u0145\u01de\7o\2\2\u0146\u0147\7O\2\2\u0147\u0148\7w\2\2\u0148"+
		"\u0149\7n\2\2\u0149\u014a\7v\2\2\u014a\u014b\7k\2\2\u014b\u014c\7r\2\2"+
		"\u014c\u014d\7n\2\2\u014d\u014e\7g\2\2\u014e\u014f\7N\2\2\u014f\u0150"+
		"\7q\2\2\u0150\u0151\7y\2\2\u0151\u0152\7V\2\2\u0152\u0153\7w\2\2\u0153"+
		"\u0154\7t\2\2\u0154\u0155\7p\2\2\u0155\u0156\7k\2\2\u0156\u0157\7p\2\2"+
		"\u0157\u0158\7i\2\2\u0158\u0159\7R\2\2\u0159\u015a\7q\2\2\u015a\u015b"+
		"\7k\2\2\u015b\u015c\7p\2\2\u015c\u015d\7v\2\2\u015d\u01de\7u\2\2\u015e"+
		"\u015f\7O\2\2\u015f\u0160\7k\2\2\u0160\u0161\7p\2\2\u0161\u0162\7k\2\2"+
		"\u0162\u0163\7o\2\2\u0163\u0164\7w\2\2\u0164\u0165\7o\2\2\u0165\u0166"+
		"\7C\2\2\u0166\u0167\7v\2\2\u0167\u0168\7U\2\2\u0168\u0169\7v\2\2\u0169"+
		"\u016a\7c\2\2\u016a\u016b\7t\2\2\u016b\u01de\7v\2\2\u016c\u016d\7O\2\2"+
		"\u016d\u016e\7k\2\2\u016e\u016f\7p\2\2\u016f\u0170\7k\2\2\u0170\u0171"+
		"\7o\2\2\u0171\u0172\7w\2\2\u0172\u0173\7o\2\2\u0173\u0174\7C\2\2\u0174"+
		"\u0175\7v\2\2\u0175\u0176\7G\2\2\u0176\u0177\7p\2\2\u0177\u01de\7f\2\2"+
		"\u0178\u0179\7C\2\2\u0179\u017a\7n\2\2\u017a\u017b\7n\2\2\u017b\u017c"+
		"\7U\2\2\u017c\u017d\7g\2\2\u017d\u017e\7i\2\2\u017e\u017f\7o\2\2\u017f"+
		"\u0180\7g\2\2\u0180\u0181\7p\2\2\u0181\u0182\7v\2\2\u0182\u0183\7u\2\2"+
		"\u0183\u0184\7C\2\2\u0184\u0185\7u\2\2\u0185\u0186\7e\2\2\u0186\u0187"+
		"\7g\2\2\u0187\u0188\7p\2\2\u0188\u0189\7f\2\2\u0189\u018a\7k\2\2\u018a"+
		"\u018b\7p\2\2\u018b\u01de\7i\2\2\u018c\u018d\7O\2\2\u018d\u018e\7q\2\2"+
		"\u018e\u018f\7u\2\2\u018f\u0190\7v\2\2\u0190\u0191\7U\2\2\u0191\u0192"+
		"\7g\2\2\u0192\u0193\7i\2\2\u0193\u0194\7o\2\2\u0194\u0195\7g\2\2\u0195"+
		"\u0196\7p\2\2\u0196\u0197\7v\2\2\u0197\u0198\7u\2\2\u0198\u0199\7C\2\2"+
		"\u0199\u019a\7u\2\2\u019a\u019b\7e\2\2\u019b\u019c\7g\2\2\u019c\u019d"+
		"\7p\2\2\u019d\u019e\7f\2\2\u019e\u019f\7k\2\2\u019f\u01a0\7p\2\2\u01a0"+
		"\u01de\7i\2\2\u01a1\u01a2\7C\2\2\u01a2\u01a3\7n\2\2\u01a3\u01a4\7n\2\2"+
		"\u01a4\u01a5\7U\2\2\u01a5\u01a6\7g\2\2\u01a6\u01a7\7i\2\2\u01a7\u01a8"+
		"\7o\2\2\u01a8\u01a9\7g\2\2\u01a9\u01aa\7p\2\2\u01aa\u01ab\7v\2\2\u01ab"+
		"\u01ac\7u\2\2\u01ac\u01ad\7F\2\2\u01ad\u01ae\7g\2\2\u01ae\u01af\7u\2\2"+
		"\u01af\u01b0\7e\2\2\u01b0\u01b1\7g\2\2\u01b1\u01b2\7p\2\2\u01b2\u01b3"+
		"\7f\2\2\u01b3\u01b4\7k\2\2\u01b4\u01b5\7p\2\2\u01b5\u01de\7i\2\2\u01b6"+
		"\u01b7\7O\2\2\u01b7\u01b8\7q\2\2\u01b8\u01b9\7u\2\2\u01b9\u01ba\7v\2\2"+
		"\u01ba\u01bb\7U\2\2\u01bb\u01bc\7g\2\2\u01bc\u01bd\7i\2\2\u01bd\u01be"+
		"\7o\2\2\u01be\u01bf\7g\2\2\u01bf\u01c0\7p\2\2\u01c0\u01c1\7v\2\2\u01c1"+
		"\u01c2\7u\2\2\u01c2\u01c3\7F\2\2\u01c3\u01c4\7g\2\2\u01c4\u01c5\7u\2\2"+
		"\u01c5\u01c6\7e\2\2\u01c6\u01c7\7g\2\2\u01c7\u01c8\7p\2\2\u01c8\u01c9"+
		"\7f\2\2\u01c9\u01ca\7k\2\2\u01ca\u01cb\7p\2\2\u01cb\u01de\7i\2\2\u01cc"+
		"\u01cd\7V\2\2\u01cd\u01ce\7k\2\2\u01ce\u01cf\7o\2\2\u01cf\u01d0\7g\2\2"+
		"\u01d0\u01d1\7U\2\2\u01d1\u01d2\7n\2\2\u01d2\u01d3\7k\2\2\u01d3\u01d4"+
		"\7e\2\2\u01d4\u01d5\7g\2\2\u01d5\u01d6\7T\2\2\u01d6\u01d7\7g\2\2\u01d7"+
		"\u01d8\7s\2\2\u01d8\u01d9\7w\2\2\u01d9\u01da\7k\2\2\u01da\u01db\7t\2\2"+
		"\u01db\u01dc\7g\2\2\u01dc\u01de\7f\2\2\u01dd\u00a7\3\2\2\2\u01dd\u00b1"+
		"\3\2\2\2\u01dd\u00c8\3\2\2\2\u01dd\u00d7\3\2\2\2\u01dd\u00eb\3\2\2\2\u01dd"+
		"\u00ff\3\2\2\2\u01dd\u0118\3\2\2\2\u01dd\u0126\3\2\2\2\u01dd\u0132\3\2"+
		"\2\2\u01dd\u0146\3\2\2\2\u01dd\u015e\3\2\2\2\u01dd\u016c\3\2\2\2\u01dd"+
		"\u0178\3\2\2\2\u01dd\u018c\3\2\2\2\u01dd\u01a1\3\2\2\2\u01dd\u01b6\3\2"+
		"\2\2\u01dd\u01cc\3\2\2\2\u01de\22\3\2\2\2\u01df\u01e1\5\31\r\2\u01e0\u01df"+
		"\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e0\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3"+
		"\u01e4\3\2\2\2\u01e4\u01e6\7\60\2\2\u01e5\u01e7\5\31\r\2\u01e6\u01e5\3"+
		"\2\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9"+
		"\u01f1\3\2\2\2\u01ea\u01ec\7\60\2\2\u01eb\u01ed\5\31\r\2\u01ec\u01eb\3"+
		"\2\2\2\u01ed\u01ee\3\2\2\2\u01ee\u01ec\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef"+
		"\u01f1\3\2\2\2\u01f0\u01e0\3\2\2\2\u01f0\u01ea\3\2\2\2\u01f1\24\3\2\2"+
		"\2\u01f2\u01f3\t\2\2\2\u01f3\26\3\2\2\2\u01f4\u01f8\t\3\2\2\u01f5\u01f7"+
		"\t\3\2\2\u01f6\u01f5\3\2\2\2\u01f7\u01fa\3\2\2\2\u01f8\u01f6\3\2\2\2\u01f8"+
		"\u01f9\3\2\2\2\u01f9\30\3\2\2\2\u01fa\u01f8\3\2\2\2\u01fb\u01fc\t\4\2"+
		"\2\u01fc\32\3\2\2\2\u01fd\u01ff\7\17\2\2\u01fe\u01fd\3\2\2\2\u01fe\u01ff"+
		"\3\2\2\2\u01ff\u0200\3\2\2\2\u0200\u0201\7\f\2\2\u0201\34\3\2\2\2\u0202"+
		"\u0204\t\5\2\2\u0203\u0202\3\2\2\2\u0204\u0205\3\2\2\2\u0205\u0203\3\2"+
		"\2\2\u0205\u0206\3\2\2\2\u0206\u0207\3\2\2\2\u0207\u0208\b\17\2\2\u0208"+
		"\36\3\2\2\2\r\2b\u00a5\u01dd\u01e2\u01e8\u01ee\u01f0\u01f8\u01fe\u0205"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}