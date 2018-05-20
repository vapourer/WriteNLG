// Generated from Aggregation.g4 by ANTLR 4.7
package io.antlrgenerated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AggregationLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, AGGREGATION_CONCEPT_GROUP=2, AGGREGATION_CONCEPT_GROUP_TITLE=3, 
		GLOBAL_CONCEPT_NAME=4, TIME_SERIES_CONCEPT_NAME=5, GLOBAL_CONCEPT=6, TIME_SERIES_CONCEPT=7, 
		NEW_LINE=8, WHITE_SPACE=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "AGGREGATION_CONCEPT_GROUP", "AGGREGATION_CONCEPT_GROUP_TITLE", 
		"GLOBAL_CONCEPT_NAME", "TIME_SERIES_CONCEPT_NAME", "GLOBAL_CONCEPT", "TIME_SERIES_CONCEPT", 
		"NEW_LINE", "WHITE_SPACE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'AggregationConceptGroup'", null, "'GlobalConcept'", "'TimeSeriesConcept'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "AGGREGATION_CONCEPT_GROUP", "AGGREGATION_CONCEPT_GROUP_TITLE", 
		"GLOBAL_CONCEPT_NAME", "TIME_SERIES_CONCEPT_NAME", "GLOBAL_CONCEPT", "TIME_SERIES_CONCEPT", 
		"NEW_LINE", "WHITE_SPACE"
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


	public AggregationLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Aggregation.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\13\u01a3\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u00f0\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\5\7\u0153\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\5\b\u0196\n\b\3\t\5\t\u0199\n\t\3\t\3\t\3\n\6\n\u019e\n\n\r\n\16"+
		"\n\u019f\3\n\3\n\2\2\13\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\3\2\3"+
		"\4\2\13\13\"\"\2\u01b1\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\3\25"+
		"\3\2\2\2\5\27\3\2\2\2\7\u00ef\3\2\2\2\t\u00f1\3\2\2\2\13\u00ff\3\2\2\2"+
		"\r\u0152\3\2\2\2\17\u0195\3\2\2\2\21\u0198\3\2\2\2\23\u019d\3\2\2\2\25"+
		"\26\7?\2\2\26\4\3\2\2\2\27\30\7C\2\2\30\31\7i\2\2\31\32\7i\2\2\32\33\7"+
		"t\2\2\33\34\7g\2\2\34\35\7i\2\2\35\36\7c\2\2\36\37\7v\2\2\37 \7k\2\2 "+
		"!\7q\2\2!\"\7p\2\2\"#\7E\2\2#$\7q\2\2$%\7p\2\2%&\7e\2\2&\'\7g\2\2\'(\7"+
		"r\2\2()\7v\2\2)*\7I\2\2*+\7t\2\2+,\7q\2\2,-\7w\2\2-.\7r\2\2.\6\3\2\2\2"+
		"/\60\7C\2\2\60\61\7n\2\2\61\62\7n\2\2\62\63\7K\2\2\63\64\7p\2\2\64\65"+
		"\7v\2\2\65\66\7t\2\2\66\67\7q\2\2\678\7f\2\289\7w\2\29:\7e\2\2:;\7v\2"+
		"\2;<\7q\2\2<=\7t\2\2=>\7{\2\2>?\7K\2\2?@\7p\2\2@A\7h\2\2AB\7q\2\2BC\7"+
		"t\2\2CD\7o\2\2DE\7c\2\2EF\7v\2\2FG\7k\2\2GH\7q\2\2HI\7p\2\2IJ\7R\2\2J"+
		"K\7t\2\2KL\7g\2\2LM\7u\2\2MN\7g\2\2NO\7p\2\2O\u00f0\7v\2\2PQ\7D\2\2QR"+
		"\7q\2\2RS\7v\2\2ST\7j\2\2TU\7U\2\2UV\7g\2\2VW\7t\2\2WX\7k\2\2XY\7g\2\2"+
		"YZ\7u\2\2Z[\7J\2\2[\\\7c\2\2\\]\7x\2\2]^\7g\2\2^_\7C\2\2_`\7n\2\2`a\7"+
		"n\2\2ab\7U\2\2bc\7g\2\2cd\7i\2\2de\7o\2\2ef\7g\2\2fg\7p\2\2gh\7v\2\2h"+
		"i\7u\2\2ij\7C\2\2jk\7u\2\2kl\7e\2\2lm\7g\2\2mn\7p\2\2no\7f\2\2op\7k\2"+
		"\2pq\7p\2\2q\u00f0\7i\2\2rs\7D\2\2st\7q\2\2tu\7v\2\2uv\7j\2\2vw\7U\2\2"+
		"wx\7g\2\2xy\7t\2\2yz\7k\2\2z{\7g\2\2{|\7u\2\2|}\7J\2\2}~\7c\2\2~\177\7"+
		"x\2\2\177\u0080\7g\2\2\u0080\u0081\7C\2\2\u0081\u0082\7n\2\2\u0082\u0083"+
		"\7n\2\2\u0083\u0084\7U\2\2\u0084\u0085\7g\2\2\u0085\u0086\7i\2\2\u0086"+
		"\u0087\7o\2\2\u0087\u0088\7g\2\2\u0088\u0089\7p\2\2\u0089\u008a\7v\2\2"+
		"\u008a\u008b\7u\2\2\u008b\u008c\7F\2\2\u008c\u008d\7g\2\2\u008d\u008e"+
		"\7u\2\2\u008e\u008f\7e\2\2\u008f\u0090\7g\2\2\u0090\u0091\7p\2\2\u0091"+
		"\u0092\7f\2\2\u0092\u0093\7k\2\2\u0093\u0094\7p\2\2\u0094\u00f0\7i\2\2"+
		"\u0095\u0096\7D\2\2\u0096\u0097\7q\2\2\u0097\u0098\7v\2\2\u0098\u0099"+
		"\7j\2\2\u0099\u009a\7U\2\2\u009a\u009b\7g\2\2\u009b\u009c\7t\2\2\u009c"+
		"\u009d\7k\2\2\u009d\u009e\7g\2\2\u009e\u009f\7u\2\2\u009f\u00a0\7J\2\2"+
		"\u00a0\u00a1\7c\2\2\u00a1\u00a2\7x\2\2\u00a2\u00a3\7g\2\2\u00a3\u00a4"+
		"\7O\2\2\u00a4\u00a5\7q\2\2\u00a5\u00a6\7u\2\2\u00a6\u00a7\7v\2\2\u00a7"+
		"\u00a8\7U\2\2\u00a8\u00a9\7g\2\2\u00a9\u00aa\7i\2\2\u00aa\u00ab\7o\2\2"+
		"\u00ab\u00ac\7g\2\2\u00ac\u00ad\7p\2\2\u00ad\u00ae\7v\2\2\u00ae\u00af"+
		"\7u\2\2\u00af\u00b0\7C\2\2\u00b0\u00b1\7u\2\2\u00b1\u00b2\7e\2\2\u00b2"+
		"\u00b3\7g\2\2\u00b3\u00b4\7p\2\2\u00b4\u00b5\7f\2\2\u00b5\u00b6\7k\2\2"+
		"\u00b6\u00b7\7p\2\2\u00b7\u00f0\7i\2\2\u00b8\u00b9\7D\2\2\u00b9\u00ba"+
		"\7q\2\2\u00ba\u00bb\7v\2\2\u00bb\u00bc\7j\2\2\u00bc\u00bd\7U\2\2\u00bd"+
		"\u00be\7g\2\2\u00be\u00bf\7t\2\2\u00bf\u00c0\7k\2\2\u00c0\u00c1\7g\2\2"+
		"\u00c1\u00c2\7u\2\2\u00c2\u00c3\7J\2\2\u00c3\u00c4\7c\2\2\u00c4\u00c5"+
		"\7x\2\2\u00c5\u00c6\7g\2\2\u00c6\u00c7\7O\2\2\u00c7\u00c8\7q\2\2\u00c8"+
		"\u00c9\7u\2\2\u00c9\u00ca\7v\2\2\u00ca\u00cb\7U\2\2\u00cb\u00cc\7g\2\2"+
		"\u00cc\u00cd\7i\2\2\u00cd\u00ce\7o\2\2\u00ce\u00cf\7g\2\2\u00cf\u00d0"+
		"\7p\2\2\u00d0\u00d1\7v\2\2\u00d1\u00d2\7u\2\2\u00d2\u00d3\7F\2\2\u00d3"+
		"\u00d4\7g\2\2\u00d4\u00d5\7u\2\2\u00d5\u00d6\7e\2\2\u00d6\u00d7\7g\2\2"+
		"\u00d7\u00d8\7p\2\2\u00d8\u00d9\7f\2\2\u00d9\u00da\7k\2\2\u00da\u00db"+
		"\7p\2\2\u00db\u00f0\7i\2\2\u00dc\u00dd\7K\2\2\u00dd\u00de\7f\2\2\u00de"+
		"\u00df\7g\2\2\u00df\u00e0\7p\2\2\u00e0\u00e1\7v\2\2\u00e1\u00e2\7k\2\2"+
		"\u00e2\u00e3\7e\2\2\u00e3\u00e4\7c\2\2\u00e4\u00e5\7n\2\2\u00e5\u00e6"+
		"\7V\2\2\u00e6\u00e7\7k\2\2\u00e7\u00e8\7o\2\2\u00e8\u00e9\7g\2\2\u00e9"+
		"\u00ea\7U\2\2\u00ea\u00eb\7n\2\2\u00eb\u00ec\7k\2\2\u00ec\u00ed\7e\2\2"+
		"\u00ed\u00ee\7g\2\2\u00ee\u00f0\7u\2\2\u00ef/\3\2\2\2\u00efP\3\2\2\2\u00ef"+
		"r\3\2\2\2\u00ef\u0095\3\2\2\2\u00ef\u00b8\3\2\2\2\u00ef\u00dc\3\2\2\2"+
		"\u00f0\b\3\2\2\2\u00f1\u00f2\7I\2\2\u00f2\u00f3\7n\2\2\u00f3\u00f4\7q"+
		"\2\2\u00f4\u00f5\7d\2\2\u00f5\u00f6\7c\2\2\u00f6\u00f7\7n\2\2\u00f7\u00f8"+
		"\7E\2\2\u00f8\u00f9\7q\2\2\u00f9\u00fa\7p\2\2\u00fa\u00fb\7e\2\2\u00fb"+
		"\u00fc\7g\2\2\u00fc\u00fd\7r\2\2\u00fd\u00fe\7v\2\2\u00fe\n\3\2\2\2\u00ff"+
		"\u0100\7V\2\2\u0100\u0101\7k\2\2\u0101\u0102\7o\2\2\u0102\u0103\7g\2\2"+
		"\u0103\u0104\7U\2\2\u0104\u0105\7g\2\2\u0105\u0106\7t\2\2\u0106\u0107"+
		"\7k\2\2\u0107\u0108\7g\2\2\u0108\u0109\7u\2\2\u0109\u010a\7E\2\2\u010a"+
		"\u010b\7q\2\2\u010b\u010c\7p\2\2\u010c\u010d\7e\2\2\u010d\u010e\7g\2\2"+
		"\u010e\u010f\7r\2\2\u010f\u0110\7v\2\2\u0110\f\3\2\2\2\u0111\u0112\7N"+
		"\2\2\u0112\u0113\7K\2\2\u0113\u0114\7P\2\2\u0114\u0115\7G\2\2\u0115\u0116"+
		"\7U\2\2\u0116\u0117\7a\2\2\u0117\u0118\7E\2\2\u0118\u0119\7T\2\2\u0119"+
		"\u011a\7Q\2\2\u011a\u011b\7U\2\2\u011b\u0153\7U\2\2\u011c\u011d\7N\2\2"+
		"\u011d\u011e\7K\2\2\u011e\u011f\7P\2\2\u011f\u0120\7G\2\2\u0120\u0121"+
		"\7U\2\2\u0121\u0122\7a\2\2\u0122\u0123\7F\2\2\u0123\u0124\7Q\2\2\u0124"+
		"\u0125\7a\2\2\u0125\u0126\7P\2\2\u0126\u0127\7Q\2\2\u0127\u0128\7V\2\2"+
		"\u0128\u0129\7a\2\2\u0129\u012a\7E\2\2\u012a\u012b\7T\2\2\u012b\u012c"+
		"\7Q\2\2\u012c\u012d\7U\2\2\u012d\u0153\7U\2\2\u012e\u012f\7N\2\2\u012f"+
		"\u0130\7K\2\2\u0130\u0131\7P\2\2\u0131\u0132\7G\2\2\u0132\u0133\7U\2\2"+
		"\u0133\u0134\7a\2\2\u0134\u0135\7E\2\2\u0135\u0136\7T\2\2\u0136\u0137"+
		"\7Q\2\2\u0137\u0138\7U\2\2\u0138\u0139\7U\2\2\u0139\u013a\7a\2\2\u013a"+
		"\u013b\7O\2\2\u013b\u013c\7W\2\2\u013c\u013d\7N\2\2\u013d\u013e\7V\2\2"+
		"\u013e\u013f\7K\2\2\u013f\u0140\7R\2\2\u0140\u0141\7N\2\2\u0141\u0142"+
		"\7G\2\2\u0142\u0143\7a\2\2\u0143\u0144\7V\2\2\u0144\u0145\7K\2\2\u0145"+
		"\u0146\7O\2\2\u0146\u0147\7G\2\2\u0147\u0153\7U\2\2\u0148\u0149\7N\2\2"+
		"\u0149\u014a\7K\2\2\u014a\u014b\7P\2\2\u014b\u014c\7G\2\2\u014c\u014d"+
		"\7a\2\2\u014d\u014e\7E\2\2\u014e\u014f\7Q\2\2\u014f\u0150\7W\2\2\u0150"+
		"\u0151\7P\2\2\u0151\u0153\7V\2\2\u0152\u0111\3\2\2\2\u0152\u011c\3\2\2"+
		"\2\u0152\u012e\3\2\2\2\u0152\u0148\3\2\2\2\u0153\16\3\2\2\2\u0154\u0155"+
		"\7O\2\2\u0155\u0156\7C\2\2\u0156\u0157\7Z\2\2\u0157\u0158\7K\2\2\u0158"+
		"\u0159\7O\2\2\u0159\u015a\7W\2\2\u015a\u0196\7O\2\2\u015b\u015c\7O\2\2"+
		"\u015c\u015d\7K\2\2\u015d\u015e\7P\2\2\u015e\u015f\7K\2\2\u015f\u0160"+
		"\7O\2\2\u0160\u0161\7W\2\2\u0161\u0196\7O\2\2\u0162\u0163\7T\2\2\u0163"+
		"\u0164\7K\2\2\u0164\u0165\7U\2\2\u0165\u0166\7K\2\2\u0166\u0167\7P\2\2"+
		"\u0167\u0168\7I\2\2\u0168\u0169\7a\2\2\u0169\u016a\7V\2\2\u016a\u016b"+
		"\7T\2\2\u016b\u016c\7G\2\2\u016c\u016d\7P\2\2\u016d\u0196\7F\2\2\u016e"+
		"\u016f\7F\2\2\u016f\u0170\7G\2\2\u0170\u0171\7U\2\2\u0171\u0172\7E\2\2"+
		"\u0172\u0173\7G\2\2\u0173\u0174\7P\2\2\u0174\u0175\7F\2\2\u0175\u0176"+
		"\7K\2\2\u0176\u0177\7P\2\2\u0177\u0178\7I\2\2\u0178\u0179\7a\2\2\u0179"+
		"\u017a\7V\2\2\u017a\u017b\7T\2\2\u017b\u017c\7G\2\2\u017c\u017d\7P\2\2"+
		"\u017d\u0196\7F\2\2\u017e\u017f\7U\2\2\u017f\u0180\7G\2\2\u0180\u0181"+
		"\7T\2\2\u0181\u0182\7K\2\2\u0182\u0183\7G\2\2\u0183\u0184\7U\2\2\u0184"+
		"\u0185\7a\2\2\u0185\u0186\7N\2\2\u0186\u0187\7G\2\2\u0187\u0188\7I\2\2"+
		"\u0188\u0189\7G\2\2\u0189\u018a\7P\2\2\u018a\u0196\7F\2\2\u018b\u018c"+
		"\7V\2\2\u018c\u018d\7K\2\2\u018d\u018e\7O\2\2\u018e\u018f\7G\2\2\u018f"+
		"\u0190\7a\2\2\u0190\u0191\7U\2\2\u0191\u0192\7N\2\2\u0192\u0193\7K\2\2"+
		"\u0193\u0194\7E\2\2\u0194\u0196\7G\2\2\u0195\u0154\3\2\2\2\u0195\u015b"+
		"\3\2\2\2\u0195\u0162\3\2\2\2\u0195\u016e\3\2\2\2\u0195\u017e\3\2\2\2\u0195"+
		"\u018b\3\2\2\2\u0196\20\3\2\2\2\u0197\u0199\7\17\2\2\u0198\u0197\3\2\2"+
		"\2\u0198\u0199\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u019b\7\f\2\2\u019b\22"+
		"\3\2\2\2\u019c\u019e\t\2\2\2\u019d\u019c\3\2\2\2\u019e\u019f\3\2\2\2\u019f"+
		"\u019d\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1\u01a2\b\n"+
		"\2\2\u01a2\24\3\2\2\2\b\2\u00ef\u0152\u0195\u0198\u019f\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}