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
		T__0=1, CONCEPT_GROUP=2, CONCEPT_GROUP_TITLE=3, GLOBAL_CONCEPT=4, TIME_SERIES_CONCEPT=5, 
		NEW_LINE=6;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "CONCEPT_GROUP", "CONCEPT_GROUP_TITLE", "GLOBAL_CONCEPT", "TIME_SERIES_CONCEPT", 
		"NEW_LINE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'ConceptGroup'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "CONCEPT_GROUP", "CONCEPT_GROUP_TITLE", "GLOBAL_CONCEPT", 
		"TIME_SERIES_CONCEPT", "NEW_LINE"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\b\u0158\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
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
		"\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u00cc\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\5\5\u010f\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\5\6\u0152\n\6\3\7\5\7\u0155\n\7\3\7\3\7\2\2\b\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\3\2\2\2\u0164\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\3\17\3\2\2\2\5\21\3\2\2\2\7\u00cb\3\2"+
		"\2\2\t\u010e\3\2\2\2\13\u0151\3\2\2\2\r\u0154\3\2\2\2\17\20\7?\2\2\20"+
		"\4\3\2\2\2\21\22\7E\2\2\22\23\7q\2\2\23\24\7p\2\2\24\25\7e\2\2\25\26\7"+
		"g\2\2\26\27\7r\2\2\27\30\7v\2\2\30\31\7I\2\2\31\32\7t\2\2\32\33\7q\2\2"+
		"\33\34\7w\2\2\34\35\7r\2\2\35\6\3\2\2\2\36\37\7C\2\2\37 \7n\2\2 !\7n\2"+
		"\2!\"\7K\2\2\"#\7p\2\2#$\7v\2\2$%\7t\2\2%&\7q\2\2&\'\7f\2\2\'(\7w\2\2"+
		"()\7e\2\2)*\7v\2\2*+\7q\2\2+,\7t\2\2,-\7{\2\2-.\7K\2\2./\7p\2\2/\60\7"+
		"h\2\2\60\61\7q\2\2\61\62\7t\2\2\62\63\7o\2\2\63\64\7c\2\2\64\65\7v\2\2"+
		"\65\66\7k\2\2\66\67\7q\2\2\678\7p\2\289\7R\2\29:\7t\2\2:;\7g\2\2;<\7u"+
		"\2\2<=\7g\2\2=>\7p\2\2>\u00cc\7v\2\2?@\7D\2\2@A\7q\2\2AB\7v\2\2BC\7j\2"+
		"\2CD\7U\2\2DE\7g\2\2EF\7t\2\2FG\7k\2\2GH\7g\2\2HI\7u\2\2IJ\7J\2\2JK\7"+
		"c\2\2KL\7x\2\2LM\7g\2\2MN\7C\2\2NO\7n\2\2OP\7n\2\2PQ\7U\2\2QR\7g\2\2R"+
		"S\7i\2\2ST\7o\2\2TU\7g\2\2UV\7p\2\2VW\7v\2\2WX\7u\2\2XY\7C\2\2YZ\7u\2"+
		"\2Z[\7e\2\2[\\\7g\2\2\\]\7p\2\2]^\7f\2\2^_\7k\2\2_`\7p\2\2`\u00cc\7i\2"+
		"\2ab\7D\2\2bc\7q\2\2cd\7v\2\2de\7j\2\2ef\7U\2\2fg\7g\2\2gh\7t\2\2hi\7"+
		"k\2\2ij\7g\2\2jk\7u\2\2kl\7J\2\2lm\7c\2\2mn\7x\2\2no\7g\2\2op\7C\2\2p"+
		"q\7n\2\2qr\7n\2\2rs\7U\2\2st\7g\2\2tu\7i\2\2uv\7o\2\2vw\7g\2\2wx\7p\2"+
		"\2xy\7v\2\2yz\7u\2\2z{\7F\2\2{|\7g\2\2|}\7u\2\2}~\7e\2\2~\177\7g\2\2\177"+
		"\u0080\7p\2\2\u0080\u0081\7f\2\2\u0081\u0082\7k\2\2\u0082\u0083\7p\2\2"+
		"\u0083\u00cc\7i\2\2\u0084\u0085\7D\2\2\u0085\u0086\7q\2\2\u0086\u0087"+
		"\7v\2\2\u0087\u0088\7j\2\2\u0088\u0089\7U\2\2\u0089\u008a\7g\2\2\u008a"+
		"\u008b\7t\2\2\u008b\u008c\7k\2\2\u008c\u008d\7g\2\2\u008d\u008e\7u\2\2"+
		"\u008e\u008f\7J\2\2\u008f\u0090\7c\2\2\u0090\u0091\7x\2\2\u0091\u0092"+
		"\7g\2\2\u0092\u0093\7O\2\2\u0093\u0094\7q\2\2\u0094\u0095\7u\2\2\u0095"+
		"\u0096\7v\2\2\u0096\u0097\7U\2\2\u0097\u0098\7g\2\2\u0098\u0099\7i\2\2"+
		"\u0099\u009a\7o\2\2\u009a\u009b\7g\2\2\u009b\u009c\7p\2\2\u009c\u009d"+
		"\7v\2\2\u009d\u009e\7u\2\2\u009e\u009f\7C\2\2\u009f\u00a0\7u\2\2\u00a0"+
		"\u00a1\7e\2\2\u00a1\u00a2\7g\2\2\u00a2\u00a3\7p\2\2\u00a3\u00a4\7f\2\2"+
		"\u00a4\u00a5\7k\2\2\u00a5\u00a6\7p\2\2\u00a6\u00cc\7i\2\2\u00a7\u00a8"+
		"\7D\2\2\u00a8\u00a9\7q\2\2\u00a9\u00aa\7v\2\2\u00aa\u00ab\7j\2\2\u00ab"+
		"\u00ac\7U\2\2\u00ac\u00ad\7g\2\2\u00ad\u00ae\7t\2\2\u00ae\u00af\7k\2\2"+
		"\u00af\u00b0\7g\2\2\u00b0\u00b1\7u\2\2\u00b1\u00b2\7J\2\2\u00b2\u00b3"+
		"\7c\2\2\u00b3\u00b4\7x\2\2\u00b4\u00b5\7g\2\2\u00b5\u00b6\7O\2\2\u00b6"+
		"\u00b7\7q\2\2\u00b7\u00b8\7u\2\2\u00b8\u00b9\7v\2\2\u00b9\u00ba\7U\2\2"+
		"\u00ba\u00bb\7g\2\2\u00bb\u00bc\7i\2\2\u00bc\u00bd\7o\2\2\u00bd\u00be"+
		"\7g\2\2\u00be\u00bf\7p\2\2\u00bf\u00c0\7v\2\2\u00c0\u00c1\7u\2\2\u00c1"+
		"\u00c2\7F\2\2\u00c2\u00c3\7g\2\2\u00c3\u00c4\7u\2\2\u00c4\u00c5\7e\2\2"+
		"\u00c5\u00c6\7g\2\2\u00c6\u00c7\7p\2\2\u00c7\u00c8\7f\2\2\u00c8\u00c9"+
		"\7k\2\2\u00c9\u00ca\7p\2\2\u00ca\u00cc\7i\2\2\u00cb\36\3\2\2\2\u00cb?"+
		"\3\2\2\2\u00cba\3\2\2\2\u00cb\u0084\3\2\2\2\u00cb\u00a7\3\2\2\2\u00cc"+
		"\b\3\2\2\2\u00cd\u00ce\7N\2\2\u00ce\u00cf\7K\2\2\u00cf\u00d0\7P\2\2\u00d0"+
		"\u00d1\7G\2\2\u00d1\u00d2\7U\2\2\u00d2\u00d3\7a\2\2\u00d3\u00d4\7E\2\2"+
		"\u00d4\u00d5\7T\2\2\u00d5\u00d6\7Q\2\2\u00d6\u00d7\7U\2\2\u00d7\u010f"+
		"\7U\2\2\u00d8\u00d9\7N\2\2\u00d9\u00da\7K\2\2\u00da\u00db\7P\2\2\u00db"+
		"\u00dc\7G\2\2\u00dc\u00dd\7U\2\2\u00dd\u00de\7a\2\2\u00de\u00df\7F\2\2"+
		"\u00df\u00e0\7Q\2\2\u00e0\u00e1\7a\2\2\u00e1\u00e2\7P\2\2\u00e2\u00e3"+
		"\7Q\2\2\u00e3\u00e4\7V\2\2\u00e4\u00e5\7a\2\2\u00e5\u00e6\7E\2\2\u00e6"+
		"\u00e7\7T\2\2\u00e7\u00e8\7Q\2\2\u00e8\u00e9\7U\2\2\u00e9\u010f\7U\2\2"+
		"\u00ea\u00eb\7N\2\2\u00eb\u00ec\7K\2\2\u00ec\u00ed\7P\2\2\u00ed\u00ee"+
		"\7G\2\2\u00ee\u00ef\7U\2\2\u00ef\u00f0\7a\2\2\u00f0\u00f1\7E\2\2\u00f1"+
		"\u00f2\7T\2\2\u00f2\u00f3\7Q\2\2\u00f3\u00f4\7U\2\2\u00f4\u00f5\7U\2\2"+
		"\u00f5\u00f6\7a\2\2\u00f6\u00f7\7O\2\2\u00f7\u00f8\7W\2\2\u00f8\u00f9"+
		"\7N\2\2\u00f9\u00fa\7V\2\2\u00fa\u00fb\7K\2\2\u00fb\u00fc\7R\2\2\u00fc"+
		"\u00fd\7N\2\2\u00fd\u00fe\7G\2\2\u00fe\u00ff\7a\2\2\u00ff\u0100\7V\2\2"+
		"\u0100\u0101\7K\2\2\u0101\u0102\7O\2\2\u0102\u0103\7G\2\2\u0103\u010f"+
		"\7U\2\2\u0104\u0105\7N\2\2\u0105\u0106\7K\2\2\u0106\u0107\7P\2\2\u0107"+
		"\u0108\7G\2\2\u0108\u0109\7a\2\2\u0109\u010a\7E\2\2\u010a\u010b\7Q\2\2"+
		"\u010b\u010c\7W\2\2\u010c\u010d\7P\2\2\u010d\u010f\7V\2\2\u010e\u00cd"+
		"\3\2\2\2\u010e\u00d8\3\2\2\2\u010e\u00ea\3\2\2\2\u010e\u0104\3\2\2\2\u010f"+
		"\n\3\2\2\2\u0110\u0111\7O\2\2\u0111\u0112\7C\2\2\u0112\u0113\7Z\2\2\u0113"+
		"\u0114\7K\2\2\u0114\u0115\7O\2\2\u0115\u0116\7W\2\2\u0116\u0152\7O\2\2"+
		"\u0117\u0118\7O\2\2\u0118\u0119\7K\2\2\u0119\u011a\7P\2\2\u011a\u011b"+
		"\7K\2\2\u011b\u011c\7O\2\2\u011c\u011d\7W\2\2\u011d\u0152\7O\2\2\u011e"+
		"\u011f\7T\2\2\u011f\u0120\7K\2\2\u0120\u0121\7U\2\2\u0121\u0122\7K\2\2"+
		"\u0122\u0123\7P\2\2\u0123\u0124\7I\2\2\u0124\u0125\7a\2\2\u0125\u0126"+
		"\7V\2\2\u0126\u0127\7T\2\2\u0127\u0128\7G\2\2\u0128\u0129\7P\2\2\u0129"+
		"\u0152\7F\2\2\u012a\u012b\7F\2\2\u012b\u012c\7G\2\2\u012c\u012d\7U\2\2"+
		"\u012d\u012e\7E\2\2\u012e\u012f\7G\2\2\u012f\u0130\7P\2\2\u0130\u0131"+
		"\7F\2\2\u0131\u0132\7K\2\2\u0132\u0133\7P\2\2\u0133\u0134\7I\2\2\u0134"+
		"\u0135\7a\2\2\u0135\u0136\7V\2\2\u0136\u0137\7T\2\2\u0137\u0138\7G\2\2"+
		"\u0138\u0139\7P\2\2\u0139\u0152\7F\2\2\u013a\u013b\7U\2\2\u013b\u013c"+
		"\7G\2\2\u013c\u013d\7T\2\2\u013d\u013e\7K\2\2\u013e\u013f\7G\2\2\u013f"+
		"\u0140\7U\2\2\u0140\u0141\7a\2\2\u0141\u0142\7N\2\2\u0142\u0143\7G\2\2"+
		"\u0143\u0144\7I\2\2\u0144\u0145\7G\2\2\u0145\u0146\7P\2\2\u0146\u0152"+
		"\7F\2\2\u0147\u0148\7V\2\2\u0148\u0149\7K\2\2\u0149\u014a\7O\2\2\u014a"+
		"\u014b\7G\2\2\u014b\u014c\7a\2\2\u014c\u014d\7U\2\2\u014d\u014e\7N\2\2"+
		"\u014e\u014f\7K\2\2\u014f\u0150\7E\2\2\u0150\u0152\7G\2\2\u0151\u0110"+
		"\3\2\2\2\u0151\u0117\3\2\2\2\u0151\u011e\3\2\2\2\u0151\u012a\3\2\2\2\u0151"+
		"\u013a\3\2\2\2\u0151\u0147\3\2\2\2\u0152\f\3\2\2\2\u0153\u0155\7\17\2"+
		"\2\u0154\u0153\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0157"+
		"\7\f\2\2\u0157\16\3\2\2\2\7\2\u00cb\u010e\u0151\u0154\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}