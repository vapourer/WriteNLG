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
		T__0=1, AGGREGATION_CONCEPT_GROUP_NAME=2, AGGREGATION_CONCEPT_GROUP=3, 
		GLOBAL_CONCEPT=4, TIME_SERIES_CONCEPT=5, NEW_LINE=6;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "AGGREGATION_CONCEPT_GROUP_NAME", "AGGREGATION_CONCEPT_GROUP", 
		"GLOBAL_CONCEPT", "TIME_SERIES_CONCEPT", "NEW_LINE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'AggregationConceptGroup'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "AGGREGATION_CONCEPT_GROUP_NAME", "AGGREGATION_CONCEPT_GROUP", 
		"GLOBAL_CONCEPT", "TIME_SERIES_CONCEPT", "NEW_LINE"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\b\u018f\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
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
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0103\n\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0146\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\5\6\u0189\n\6\3\7\5\7\u018c\n\7\3\7\3\7\2\2\b\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\3\2\2\2\u019c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\3\17\3\2\2\2\5\21\3\2\2\2\7"+
		"\u0102\3\2\2\2\t\u0145\3\2\2\2\13\u0188\3\2\2\2\r\u018b\3\2\2\2\17\20"+
		"\7?\2\2\20\4\3\2\2\2\21\22\7C\2\2\22\23\7i\2\2\23\24\7i\2\2\24\25\7t\2"+
		"\2\25\26\7g\2\2\26\27\7i\2\2\27\30\7c\2\2\30\31\7v\2\2\31\32\7k\2\2\32"+
		"\33\7q\2\2\33\34\7p\2\2\34\35\7E\2\2\35\36\7q\2\2\36\37\7p\2\2\37 \7e"+
		"\2\2 !\7g\2\2!\"\7r\2\2\"#\7v\2\2#$\7I\2\2$%\7t\2\2%&\7q\2\2&\'\7w\2\2"+
		"\'(\7r\2\2(\6\3\2\2\2)*\7C\2\2*+\7N\2\2+,\7N\2\2,-\7a\2\2-.\7K\2\2./\7"+
		"P\2\2/\60\7V\2\2\60\61\7T\2\2\61\62\7Q\2\2\62\63\7F\2\2\63\64\7W\2\2\64"+
		"\65\7E\2\2\65\66\7V\2\2\66\67\7Q\2\2\678\7T\2\289\7[\2\29:\7a\2\2:;\7"+
		"K\2\2;<\7P\2\2<=\7H\2\2=>\7Q\2\2>?\7T\2\2?@\7O\2\2@A\7C\2\2AB\7V\2\2B"+
		"C\7K\2\2CD\7Q\2\2DE\7P\2\2EF\7a\2\2FG\7R\2\2GH\7T\2\2HI\7G\2\2IJ\7U\2"+
		"\2JK\7G\2\2KL\7P\2\2L\u0103\7V\2\2MN\7D\2\2NO\7Q\2\2OP\7V\2\2PQ\7J\2\2"+
		"QR\7a\2\2RS\7U\2\2ST\7G\2\2TU\7T\2\2UV\7K\2\2VW\7G\2\2WX\7U\2\2XY\7a\2"+
		"\2YZ\7J\2\2Z[\7C\2\2[\\\7X\2\2\\]\7G\2\2]^\7a\2\2^_\7C\2\2_`\7N\2\2`a"+
		"\7N\2\2ab\7a\2\2bc\7U\2\2cd\7G\2\2de\7I\2\2ef\7O\2\2fg\7G\2\2gh\7P\2\2"+
		"hi\7V\2\2ij\7U\2\2jk\7a\2\2kl\7C\2\2lm\7U\2\2mn\7E\2\2no\7G\2\2op\7P\2"+
		"\2pq\7F\2\2qr\7K\2\2rs\7P\2\2s\u0103\7I\2\2tu\7D\2\2uv\7Q\2\2vw\7V\2\2"+
		"wx\7J\2\2xy\7a\2\2yz\7U\2\2z{\7G\2\2{|\7T\2\2|}\7K\2\2}~\7G\2\2~\177\7"+
		"U\2\2\177\u0080\7a\2\2\u0080\u0081\7J\2\2\u0081\u0082\7C\2\2\u0082\u0083"+
		"\7X\2\2\u0083\u0084\7G\2\2\u0084\u0085\7a\2\2\u0085\u0086\7C\2\2\u0086"+
		"\u0087\7N\2\2\u0087\u0088\7N\2\2\u0088\u0089\7a\2\2\u0089\u008a\7U\2\2"+
		"\u008a\u008b\7G\2\2\u008b\u008c\7I\2\2\u008c\u008d\7O\2\2\u008d\u008e"+
		"\7G\2\2\u008e\u008f\7P\2\2\u008f\u0090\7V\2\2\u0090\u0091\7U\2\2\u0091"+
		"\u0092\7a\2\2\u0092\u0093\7F\2\2\u0093\u0094\7G\2\2\u0094\u0095\7U\2\2"+
		"\u0095\u0096\7E\2\2\u0096\u0097\7G\2\2\u0097\u0098\7P\2\2\u0098\u0099"+
		"\7F\2\2\u0099\u009a\7K\2\2\u009a\u009b\7P\2\2\u009b\u0103\7I\2\2\u009c"+
		"\u009d\7D\2\2\u009d\u009e\7Q\2\2\u009e\u009f\7V\2\2\u009f\u00a0\7J\2\2"+
		"\u00a0\u00a1\7a\2\2\u00a1\u00a2\7U\2\2\u00a2\u00a3\7G\2\2\u00a3\u00a4"+
		"\7T\2\2\u00a4\u00a5\7K\2\2\u00a5\u00a6\7G\2\2\u00a6\u00a7\7U\2\2\u00a7"+
		"\u00a8\7a\2\2\u00a8\u00a9\7J\2\2\u00a9\u00aa\7C\2\2\u00aa\u00ab\7X\2\2"+
		"\u00ab\u00ac\7G\2\2\u00ac\u00ad\7a\2\2\u00ad\u00ae\7O\2\2\u00ae\u00af"+
		"\7Q\2\2\u00af\u00b0\7U\2\2\u00b0\u00b1\7V\2\2\u00b1\u00b2\7a\2\2\u00b2"+
		"\u00b3\7U\2\2\u00b3\u00b4\7G\2\2\u00b4\u00b5\7I\2\2\u00b5\u00b6\7O\2\2"+
		"\u00b6\u00b7\7G\2\2\u00b7\u00b8\7P\2\2\u00b8\u00b9\7V\2\2\u00b9\u00ba"+
		"\7U\2\2\u00ba\u00bb\7a\2\2\u00bb\u00bc\7C\2\2\u00bc\u00bd\7U\2\2\u00bd"+
		"\u00be\7E\2\2\u00be\u00bf\7G\2\2\u00bf\u00c0\7P\2\2\u00c0\u00c1\7F\2\2"+
		"\u00c1\u00c2\7K\2\2\u00c2\u00c3\7P\2\2\u00c3\u0103\7I\2\2\u00c4\u00c5"+
		"\7D\2\2\u00c5\u00c6\7Q\2\2\u00c6\u00c7\7V\2\2\u00c7\u00c8\7J\2\2\u00c8"+
		"\u00c9\7a\2\2\u00c9\u00ca\7U\2\2\u00ca\u00cb\7G\2\2\u00cb\u00cc\7T\2\2"+
		"\u00cc\u00cd\7K\2\2\u00cd\u00ce\7G\2\2\u00ce\u00cf\7U\2\2\u00cf\u00d0"+
		"\7a\2\2\u00d0\u00d1\7J\2\2\u00d1\u00d2\7C\2\2\u00d2\u00d3\7X\2\2\u00d3"+
		"\u00d4\7G\2\2\u00d4\u00d5\7a\2\2\u00d5\u00d6\7O\2\2\u00d6\u00d7\7Q\2\2"+
		"\u00d7\u00d8\7U\2\2\u00d8\u00d9\7V\2\2\u00d9\u00da\7a\2\2\u00da\u00db"+
		"\7U\2\2\u00db\u00dc\7G\2\2\u00dc\u00dd\7I\2\2\u00dd\u00de\7O\2\2\u00de"+
		"\u00df\7G\2\2\u00df\u00e0\7P\2\2\u00e0\u00e1\7V\2\2\u00e1\u00e2\7U\2\2"+
		"\u00e2\u00e3\7a\2\2\u00e3\u00e4\7F\2\2\u00e4\u00e5\7G\2\2\u00e5\u00e6"+
		"\7U\2\2\u00e6\u00e7\7E\2\2\u00e7\u00e8\7G\2\2\u00e8\u00e9\7P\2\2\u00e9"+
		"\u00ea\7F\2\2\u00ea\u00eb\7K\2\2\u00eb\u00ec\7P\2\2\u00ec\u0103\7I\2\2"+
		"\u00ed\u00ee\7K\2\2\u00ee\u00ef\7F\2\2\u00ef\u00f0\7G\2\2\u00f0\u00f1"+
		"\7P\2\2\u00f1\u00f2\7V\2\2\u00f2\u00f3\7K\2\2\u00f3\u00f4\7E\2\2\u00f4"+
		"\u00f5\7C\2\2\u00f5\u00f6\7N\2\2\u00f6\u00f7\7a\2\2\u00f7\u00f8\7V\2\2"+
		"\u00f8\u00f9\7K\2\2\u00f9\u00fa\7O\2\2\u00fa\u00fb\7G\2\2\u00fb\u00fc"+
		"\7a\2\2\u00fc\u00fd\7U\2\2\u00fd\u00fe\7N\2\2\u00fe\u00ff\7K\2\2\u00ff"+
		"\u0100\7E\2\2\u0100\u0101\7G\2\2\u0101\u0103\7U\2\2\u0102)\3\2\2\2\u0102"+
		"M\3\2\2\2\u0102t\3\2\2\2\u0102\u009c\3\2\2\2\u0102\u00c4\3\2\2\2\u0102"+
		"\u00ed\3\2\2\2\u0103\b\3\2\2\2\u0104\u0105\7N\2\2\u0105\u0106\7K\2\2\u0106"+
		"\u0107\7P\2\2\u0107\u0108\7G\2\2\u0108\u0109\7U\2\2\u0109\u010a\7a\2\2"+
		"\u010a\u010b\7E\2\2\u010b\u010c\7T\2\2\u010c\u010d\7Q\2\2\u010d\u010e"+
		"\7U\2\2\u010e\u0146\7U\2\2\u010f\u0110\7N\2\2\u0110\u0111\7K\2\2\u0111"+
		"\u0112\7P\2\2\u0112\u0113\7G\2\2\u0113\u0114\7U\2\2\u0114\u0115\7a\2\2"+
		"\u0115\u0116\7F\2\2\u0116\u0117\7Q\2\2\u0117\u0118\7a\2\2\u0118\u0119"+
		"\7P\2\2\u0119\u011a\7Q\2\2\u011a\u011b\7V\2\2\u011b\u011c\7a\2\2\u011c"+
		"\u011d\7E\2\2\u011d\u011e\7T\2\2\u011e\u011f\7Q\2\2\u011f\u0120\7U\2\2"+
		"\u0120\u0146\7U\2\2\u0121\u0122\7N\2\2\u0122\u0123\7K\2\2\u0123\u0124"+
		"\7P\2\2\u0124\u0125\7G\2\2\u0125\u0126\7U\2\2\u0126\u0127\7a\2\2\u0127"+
		"\u0128\7E\2\2\u0128\u0129\7T\2\2\u0129\u012a\7Q\2\2\u012a\u012b\7U\2\2"+
		"\u012b\u012c\7U\2\2\u012c\u012d\7a\2\2\u012d\u012e\7O\2\2\u012e\u012f"+
		"\7W\2\2\u012f\u0130\7N\2\2\u0130\u0131\7V\2\2\u0131\u0132\7K\2\2\u0132"+
		"\u0133\7R\2\2\u0133\u0134\7N\2\2\u0134\u0135\7G\2\2\u0135\u0136\7a\2\2"+
		"\u0136\u0137\7V\2\2\u0137\u0138\7K\2\2\u0138\u0139\7O\2\2\u0139\u013a"+
		"\7G\2\2\u013a\u0146\7U\2\2\u013b\u013c\7N\2\2\u013c\u013d\7K\2\2\u013d"+
		"\u013e\7P\2\2\u013e\u013f\7G\2\2\u013f\u0140\7a\2\2\u0140\u0141\7E\2\2"+
		"\u0141\u0142\7Q\2\2\u0142\u0143\7W\2\2\u0143\u0144\7P\2\2\u0144\u0146"+
		"\7V\2\2\u0145\u0104\3\2\2\2\u0145\u010f\3\2\2\2\u0145\u0121\3\2\2\2\u0145"+
		"\u013b\3\2\2\2\u0146\n\3\2\2\2\u0147\u0148\7O\2\2\u0148\u0149\7C\2\2\u0149"+
		"\u014a\7Z\2\2\u014a\u014b\7K\2\2\u014b\u014c\7O\2\2\u014c\u014d\7W\2\2"+
		"\u014d\u0189\7O\2\2\u014e\u014f\7O\2\2\u014f\u0150\7K\2\2\u0150\u0151"+
		"\7P\2\2\u0151\u0152\7K\2\2\u0152\u0153\7O\2\2\u0153\u0154\7W\2\2\u0154"+
		"\u0189\7O\2\2\u0155\u0156\7T\2\2\u0156\u0157\7K\2\2\u0157\u0158\7U\2\2"+
		"\u0158\u0159\7K\2\2\u0159\u015a\7P\2\2\u015a\u015b\7I\2\2\u015b\u015c"+
		"\7a\2\2\u015c\u015d\7V\2\2\u015d\u015e\7T\2\2\u015e\u015f\7G\2\2\u015f"+
		"\u0160\7P\2\2\u0160\u0189\7F\2\2\u0161\u0162\7F\2\2\u0162\u0163\7G\2\2"+
		"\u0163\u0164\7U\2\2\u0164\u0165\7E\2\2\u0165\u0166\7G\2\2\u0166\u0167"+
		"\7P\2\2\u0167\u0168\7F\2\2\u0168\u0169\7K\2\2\u0169\u016a\7P\2\2\u016a"+
		"\u016b\7I\2\2\u016b\u016c\7a\2\2\u016c\u016d\7V\2\2\u016d\u016e\7T\2\2"+
		"\u016e\u016f\7G\2\2\u016f\u0170\7P\2\2\u0170\u0189\7F\2\2\u0171\u0172"+
		"\7U\2\2\u0172\u0173\7G\2\2\u0173\u0174\7T\2\2\u0174\u0175\7K\2\2\u0175"+
		"\u0176\7G\2\2\u0176\u0177\7U\2\2\u0177\u0178\7a\2\2\u0178\u0179\7N\2\2"+
		"\u0179\u017a\7G\2\2\u017a\u017b\7I\2\2\u017b\u017c\7G\2\2\u017c\u017d"+
		"\7P\2\2\u017d\u0189\7F\2\2\u017e\u017f\7V\2\2\u017f\u0180\7K\2\2\u0180"+
		"\u0181\7O\2\2\u0181\u0182\7G\2\2\u0182\u0183\7a\2\2\u0183\u0184\7U\2\2"+
		"\u0184\u0185\7N\2\2\u0185\u0186\7K\2\2\u0186\u0187\7E\2\2\u0187\u0189"+
		"\7G\2\2\u0188\u0147\3\2\2\2\u0188\u014e\3\2\2\2\u0188\u0155\3\2\2\2\u0188"+
		"\u0161\3\2\2\2\u0188\u0171\3\2\2\2\u0188\u017e\3\2\2\2\u0189\f\3\2\2\2"+
		"\u018a\u018c\7\17\2\2\u018b\u018a\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018d"+
		"\3\2\2\2\u018d\u018e\7\f\2\2\u018e\16\3\2\2\2\7\2\u0102\u0145\u0188\u018b"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}