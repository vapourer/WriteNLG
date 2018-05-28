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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\b\u025f\b\1\4\2\t"+
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
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0184"+
		"\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u01f9\n\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\5\6\u0259\n\6\3\7\5\7\u025c\n\7\3\7\3\7\2\2\b\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\3\2\2\2\u0277\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\3\17\3\2\2\2\5\21\3\2\2\2\7\u0183\3"+
		"\2\2\2\t\u01f8\3\2\2\2\13\u0258\3\2\2\2\r\u025b\3\2\2\2\17\20\7?\2\2\20"+
		"\4\3\2\2\2\21\22\7C\2\2\22\23\7i\2\2\23\24\7i\2\2\24\25\7t\2\2\25\26\7"+
		"g\2\2\26\27\7i\2\2\27\30\7c\2\2\30\31\7v\2\2\31\32\7k\2\2\32\33\7q\2\2"+
		"\33\34\7p\2\2\34\35\7E\2\2\35\36\7q\2\2\36\37\7p\2\2\37 \7e\2\2 !\7g\2"+
		"\2!\"\7r\2\2\"#\7v\2\2#$\7I\2\2$%\7t\2\2%&\7q\2\2&\'\7w\2\2\'(\7r\2\2"+
		"(\6\3\2\2\2)*\7C\2\2*+\7N\2\2+,\7N\2\2,-\7a\2\2-.\7K\2\2./\7P\2\2/\60"+
		"\7V\2\2\60\61\7T\2\2\61\62\7Q\2\2\62\63\7F\2\2\63\64\7W\2\2\64\65\7E\2"+
		"\2\65\66\7V\2\2\66\67\7Q\2\2\678\7T\2\289\7[\2\29:\7a\2\2:;\7K\2\2;<\7"+
		"P\2\2<=\7H\2\2=>\7Q\2\2>?\7T\2\2?@\7O\2\2@A\7C\2\2AB\7V\2\2BC\7K\2\2C"+
		"D\7Q\2\2DE\7P\2\2EF\7a\2\2FG\7R\2\2GH\7T\2\2HI\7G\2\2IJ\7U\2\2JK\7G\2"+
		"\2KL\7P\2\2L\u0184\7V\2\2MN\7D\2\2NO\7Q\2\2OP\7V\2\2PQ\7J\2\2QR\7a\2\2"+
		"RS\7U\2\2ST\7G\2\2TU\7T\2\2UV\7K\2\2VW\7G\2\2WX\7U\2\2XY\7a\2\2YZ\7J\2"+
		"\2Z[\7C\2\2[\\\7X\2\2\\]\7G\2\2]^\7a\2\2^_\7C\2\2_`\7N\2\2`a\7N\2\2ab"+
		"\7a\2\2bc\7U\2\2cd\7G\2\2de\7I\2\2ef\7O\2\2fg\7G\2\2gh\7P\2\2hi\7V\2\2"+
		"ij\7U\2\2jk\7a\2\2kl\7C\2\2lm\7U\2\2mn\7E\2\2no\7G\2\2op\7P\2\2pq\7F\2"+
		"\2qr\7K\2\2rs\7P\2\2s\u0184\7I\2\2tu\7D\2\2uv\7Q\2\2vw\7V\2\2wx\7J\2\2"+
		"xy\7a\2\2yz\7U\2\2z{\7G\2\2{|\7T\2\2|}\7K\2\2}~\7G\2\2~\177\7U\2\2\177"+
		"\u0080\7a\2\2\u0080\u0081\7J\2\2\u0081\u0082\7C\2\2\u0082\u0083\7X\2\2"+
		"\u0083\u0084\7G\2\2\u0084\u0085\7a\2\2\u0085\u0086\7C\2\2\u0086\u0087"+
		"\7N\2\2\u0087\u0088\7N\2\2\u0088\u0089\7a\2\2\u0089\u008a\7U\2\2\u008a"+
		"\u008b\7G\2\2\u008b\u008c\7I\2\2\u008c\u008d\7O\2\2\u008d\u008e\7G\2\2"+
		"\u008e\u008f\7P\2\2\u008f\u0090\7V\2\2\u0090\u0091\7U\2\2\u0091\u0092"+
		"\7a\2\2\u0092\u0093\7F\2\2\u0093\u0094\7G\2\2\u0094\u0095\7U\2\2\u0095"+
		"\u0096\7E\2\2\u0096\u0097\7G\2\2\u0097\u0098\7P\2\2\u0098\u0099\7F\2\2"+
		"\u0099\u009a\7K\2\2\u009a\u009b\7P\2\2\u009b\u0184\7I\2\2\u009c\u009d"+
		"\7D\2\2\u009d\u009e\7Q\2\2\u009e\u009f\7V\2\2\u009f\u00a0\7J\2\2\u00a0"+
		"\u00a1\7a\2\2\u00a1\u00a2\7U\2\2\u00a2\u00a3\7G\2\2\u00a3\u00a4\7T\2\2"+
		"\u00a4\u00a5\7K\2\2\u00a5\u00a6\7G\2\2\u00a6\u00a7\7U\2\2\u00a7\u00a8"+
		"\7a\2\2\u00a8\u00a9\7J\2\2\u00a9\u00aa\7C\2\2\u00aa\u00ab\7X\2\2\u00ab"+
		"\u00ac\7G\2\2\u00ac\u00ad\7a\2\2\u00ad\u00ae\7O\2\2\u00ae\u00af\7Q\2\2"+
		"\u00af\u00b0\7U\2\2\u00b0\u00b1\7V\2\2\u00b1\u00b2\7a\2\2\u00b2\u00b3"+
		"\7U\2\2\u00b3\u00b4\7G\2\2\u00b4\u00b5\7I\2\2\u00b5\u00b6\7O\2\2\u00b6"+
		"\u00b7\7G\2\2\u00b7\u00b8\7P\2\2\u00b8\u00b9\7V\2\2\u00b9\u00ba\7U\2\2"+
		"\u00ba\u00bb\7a\2\2\u00bb\u00bc\7C\2\2\u00bc\u00bd\7U\2\2\u00bd\u00be"+
		"\7E\2\2\u00be\u00bf\7G\2\2\u00bf\u00c0\7P\2\2\u00c0\u00c1\7F\2\2\u00c1"+
		"\u00c2\7K\2\2\u00c2\u00c3\7P\2\2\u00c3\u0184\7I\2\2\u00c4\u00c5\7D\2\2"+
		"\u00c5\u00c6\7Q\2\2\u00c6\u00c7\7V\2\2\u00c7\u00c8\7J\2\2\u00c8\u00c9"+
		"\7a\2\2\u00c9\u00ca\7U\2\2\u00ca\u00cb\7G\2\2\u00cb\u00cc\7T\2\2\u00cc"+
		"\u00cd\7K\2\2\u00cd\u00ce\7G\2\2\u00ce\u00cf\7U\2\2\u00cf\u00d0\7a\2\2"+
		"\u00d0\u00d1\7J\2\2\u00d1\u00d2\7C\2\2\u00d2\u00d3\7X\2\2\u00d3\u00d4"+
		"\7G\2\2\u00d4\u00d5\7a\2\2\u00d5\u00d6\7O\2\2\u00d6\u00d7\7Q\2\2\u00d7"+
		"\u00d8\7U\2\2\u00d8\u00d9\7V\2\2\u00d9\u00da\7a\2\2\u00da\u00db\7U\2\2"+
		"\u00db\u00dc\7G\2\2\u00dc\u00dd\7I\2\2\u00dd\u00de\7O\2\2\u00de\u00df"+
		"\7G\2\2\u00df\u00e0\7P\2\2\u00e0\u00e1\7V\2\2\u00e1\u00e2\7U\2\2\u00e2"+
		"\u00e3\7a\2\2\u00e3\u00e4\7F\2\2\u00e4\u00e5\7G\2\2\u00e5\u00e6\7U\2\2"+
		"\u00e6\u00e7\7E\2\2\u00e7\u00e8\7G\2\2\u00e8\u00e9\7P\2\2\u00e9\u00ea"+
		"\7F\2\2\u00ea\u00eb\7K\2\2\u00eb\u00ec\7P\2\2\u00ec\u0184\7I\2\2\u00ed"+
		"\u00ee\7K\2\2\u00ee\u00ef\7F\2\2\u00ef\u00f0\7G\2\2\u00f0\u00f1\7P\2\2"+
		"\u00f1\u00f2\7V\2\2\u00f2\u00f3\7K\2\2\u00f3\u00f4\7E\2\2\u00f4\u00f5"+
		"\7C\2\2\u00f5\u00f6\7N\2\2\u00f6\u00f7\7a\2\2\u00f7\u00f8\7V\2\2\u00f8"+
		"\u00f9\7K\2\2\u00f9\u00fa\7O\2\2\u00fa\u00fb\7G\2\2\u00fb\u00fc\7a\2\2"+
		"\u00fc\u00fd\7U\2\2\u00fd\u00fe\7N\2\2\u00fe\u00ff\7K\2\2\u00ff\u0100"+
		"\7E\2\2\u0100\u0101\7G\2\2\u0101\u0184\7U\2\2\u0102\u0103\7C\2\2\u0103"+
		"\u0104\7I\2\2\u0104\u0105\7I\2\2\u0105\u0106\7T\2\2\u0106\u0107\7G\2\2"+
		"\u0107\u0108\7I\2\2\u0108\u0109\7C\2\2\u0109\u010a\7V\2\2\u010a\u010b"+
		"\7G\2\2\u010b\u010c\7a\2\2\u010c\u010d\7O\2\2\u010d\u010e\7C\2\2\u010e"+
		"\u010f\7Z\2\2\u010f\u0110\7K\2\2\u0110\u0111\7O\2\2\u0111\u0184\7C\2\2"+
		"\u0112\u0113\7C\2\2\u0113\u0114\7I\2\2\u0114\u0115\7I\2\2\u0115\u0116"+
		"\7T\2\2\u0116\u0117\7G\2\2\u0117\u0118\7I\2\2\u0118\u0119\7C\2\2\u0119"+
		"\u011a\7V\2\2\u011a\u011b\7G\2\2\u011b\u011c\7a\2\2\u011c\u011d\7O\2\2"+
		"\u011d\u011e\7K\2\2\u011e\u011f\7P\2\2\u011f\u0120\7K\2\2\u0120\u0121"+
		"\7O\2\2\u0121\u0184\7C\2\2\u0122\u0123\7C\2\2\u0123\u0124\7I\2\2\u0124"+
		"\u0125\7I\2\2\u0125\u0126\7T\2\2\u0126\u0127\7G\2\2\u0127\u0128\7I\2\2"+
		"\u0128\u0129\7C\2\2\u0129\u012a\7V\2\2\u012a\u012b\7G\2\2\u012b\u012c"+
		"\7a\2\2\u012c\u012d\7O\2\2\u012d\u012e\7C\2\2\u012e\u012f\7Z\2\2\u012f"+
		"\u0130\7K\2\2\u0130\u0131\7O\2\2\u0131\u0132\7W\2\2\u0132\u0133\7O\2\2"+
		"\u0133\u0134\7a\2\2\u0134\u0135\7C\2\2\u0135\u0136\7P\2\2\u0136\u0137"+
		"\7F\2\2\u0137\u0138\7a\2\2\u0138\u0139\7O\2\2\u0139\u013a\7K\2\2\u013a"+
		"\u013b\7P\2\2\u013b\u013c\7K\2\2\u013c\u013d\7O\2\2\u013d\u013e\7W\2\2"+
		"\u013e\u0184\7O\2\2\u013f\u0140\7C\2\2\u0140\u0141\7I\2\2\u0141\u0142"+
		"\7I\2\2\u0142\u0143\7T\2\2\u0143\u0144\7G\2\2\u0144\u0145\7I\2\2\u0145"+
		"\u0146\7C\2\2\u0146\u0147\7V\2\2\u0147\u0148\7G\2\2\u0148\u0149\7a\2\2"+
		"\u0149\u014a\7V\2\2\u014a\u014b\7W\2\2\u014b\u014c\7T\2\2\u014c\u014d"+
		"\7P\2\2\u014d\u014e\7K\2\2\u014e\u014f\7P\2\2\u014f\u0150\7I\2\2\u0150"+
		"\u0151\7a\2\2\u0151\u0152\7R\2\2\u0152\u0153\7Q\2\2\u0153\u0154\7K\2\2"+
		"\u0154\u0155\7P\2\2\u0155\u0156\7V\2\2\u0156\u0184\7U\2\2\u0157\u0158"+
		"\7C\2\2\u0158\u0159\7I\2\2\u0159\u015a\7I\2\2\u015a\u015b\7T\2\2\u015b"+
		"\u015c\7G\2\2\u015c\u015d\7I\2\2\u015d\u015e\7C\2\2\u015e\u015f\7V\2\2"+
		"\u015f\u0160\7G\2\2\u0160\u0161\7a\2\2\u0161\u0162\7U\2\2\u0162\u0163"+
		"\7V\2\2\u0163\u0164\7C\2\2\u0164\u0165\7V\2\2\u0165\u0166\7K\2\2\u0166"+
		"\u0167\7Q\2\2\u0167\u0168\7P\2\2\u0168\u0169\7C\2\2\u0169\u016a\7T\2\2"+
		"\u016a\u0184\7[\2\2\u016b\u016c\7C\2\2\u016c\u016d\7I\2\2\u016d\u016e"+
		"\7I\2\2\u016e\u016f\7T\2\2\u016f\u0170\7G\2\2\u0170\u0171\7I\2\2\u0171"+
		"\u0172\7C\2\2\u0172\u0173\7V\2\2\u0173\u0174\7G\2\2\u0174\u0175\7a\2\2"+
		"\u0175\u0176\7N\2\2\u0176\u0177\7K\2\2\u0177\u0178\7P\2\2\u0178\u0179"+
		"\7G\2\2\u0179\u017a\7a\2\2\u017a\u017b\7D\2\2\u017b\u017c\7G\2\2\u017c"+
		"\u017d\7J\2\2\u017d\u017e\7C\2\2\u017e\u017f\7X\2\2\u017f\u0180\7K\2\2"+
		"\u0180\u0181\7Q\2\2\u0181\u0182\7W\2\2\u0182\u0184\7T\2\2\u0183)\3\2\2"+
		"\2\u0183M\3\2\2\2\u0183t\3\2\2\2\u0183\u009c\3\2\2\2\u0183\u00c4\3\2\2"+
		"\2\u0183\u00ed\3\2\2\2\u0183\u0102\3\2\2\2\u0183\u0112\3\2\2\2\u0183\u0122"+
		"\3\2\2\2\u0183\u013f\3\2\2\2\u0183\u0157\3\2\2\2\u0183\u016b\3\2\2\2\u0184"+
		"\b\3\2\2\2\u0185\u0186\7N\2\2\u0186\u0187\7K\2\2\u0187\u0188\7P\2\2\u0188"+
		"\u0189\7G\2\2\u0189\u018a\7U\2\2\u018a\u018b\7a\2\2\u018b\u018c\7E\2\2"+
		"\u018c\u018d\7T\2\2\u018d\u018e\7Q\2\2\u018e\u018f\7U\2\2\u018f\u01f9"+
		"\7U\2\2\u0190\u0191\7N\2\2\u0191\u0192\7K\2\2\u0192\u0193\7P\2\2\u0193"+
		"\u0194\7G\2\2\u0194\u0195\7U\2\2\u0195\u0196\7a\2\2\u0196\u0197\7F\2\2"+
		"\u0197\u0198\7Q\2\2\u0198\u0199\7a\2\2\u0199\u019a\7P\2\2\u019a\u019b"+
		"\7Q\2\2\u019b\u019c\7V\2\2\u019c\u019d\7a\2\2\u019d\u019e\7E\2\2\u019e"+
		"\u019f\7T\2\2\u019f\u01a0\7Q\2\2\u01a0\u01a1\7U\2\2\u01a1\u01f9\7U\2\2"+
		"\u01a2\u01a3\7N\2\2\u01a3\u01a4\7K\2\2\u01a4\u01a5\7P\2\2\u01a5\u01a6"+
		"\7G\2\2\u01a6\u01a7\7U\2\2\u01a7\u01a8\7a\2\2\u01a8\u01a9\7E\2\2\u01a9"+
		"\u01aa\7T\2\2\u01aa\u01ab\7Q\2\2\u01ab\u01ac\7U\2\2\u01ac\u01ad\7U\2\2"+
		"\u01ad\u01ae\7a\2\2\u01ae\u01af\7O\2\2\u01af\u01b0\7W\2\2\u01b0\u01b1"+
		"\7N\2\2\u01b1\u01b2\7V\2\2\u01b2\u01b3\7K\2\2\u01b3\u01b4\7R\2\2\u01b4"+
		"\u01b5\7N\2\2\u01b5\u01b6\7G\2\2\u01b6\u01b7\7a\2\2\u01b7\u01b8\7V\2\2"+
		"\u01b8\u01b9\7K\2\2\u01b9\u01ba\7O\2\2\u01ba\u01bb\7G\2\2\u01bb\u01f9"+
		"\7U\2\2\u01bc\u01bd\7N\2\2\u01bd\u01be\7K\2\2\u01be\u01bf\7P\2\2\u01bf"+
		"\u01c0\7G\2\2\u01c0\u01c1\7a\2\2\u01c1\u01c2\7E\2\2\u01c2\u01c3\7Q\2\2"+
		"\u01c3\u01c4\7W\2\2\u01c4\u01c5\7P\2\2\u01c5\u01f9\7V\2\2\u01c6\u01c7"+
		"\7U\2\2\u01c7\u01c8\7G\2\2\u01c8\u01c9\7T\2\2\u01c9\u01ca\7K\2\2\u01ca"+
		"\u01cb\7G\2\2\u01cb\u01cc\7U\2\2\u01cc\u01cd\7a\2\2\u01cd\u01ce\7F\2\2"+
		"\u01ce\u01cf\7K\2\2\u01cf\u01d0\7H\2\2\u01d0\u01d1\7H\2\2\u01d1\u01d2"+
		"\7G\2\2\u01d2\u01d3\7T\2\2\u01d3\u01d4\7G\2\2\u01d4\u01d5\7P\2\2\u01d5"+
		"\u01d6\7E\2\2\u01d6\u01d7\7G\2\2\u01d7\u01d8\7U\2\2\u01d8\u01d9\7a\2\2"+
		"\u01d9\u01da\7V\2\2\u01da\u01db\7T\2\2\u01db\u01dc\7G\2\2\u01dc\u01dd"+
		"\7P\2\2\u01dd\u01f9\7F\2\2\u01de\u01df\7U\2\2\u01df\u01e0\7G\2\2\u01e0"+
		"\u01e1\7T\2\2\u01e1\u01e2\7K\2\2\u01e2\u01e3\7G\2\2\u01e3\u01e4\7U\2\2"+
		"\u01e4\u01e5\7a\2\2\u01e5\u01e6\7F\2\2\u01e6\u01e7\7K\2\2\u01e7\u01e8"+
		"\7H\2\2\u01e8\u01e9\7H\2\2\u01e9\u01ea\7G\2\2\u01ea\u01eb\7T\2\2\u01eb"+
		"\u01ec\7G\2\2\u01ec\u01ed\7P\2\2\u01ed\u01ee\7E\2\2\u01ee\u01ef\7G\2\2"+
		"\u01ef\u01f0\7U\2\2\u01f0\u01f1\7a\2\2\u01f1\u01f2\7C\2\2\u01f2\u01f3"+
		"\7X\2\2\u01f3\u01f4\7G\2\2\u01f4\u01f5\7T\2\2\u01f5\u01f6\7C\2\2\u01f6"+
		"\u01f7\7I\2\2\u01f7\u01f9\7G\2\2\u01f8\u0185\3\2\2\2\u01f8\u0190\3\2\2"+
		"\2\u01f8\u01a2\3\2\2\2\u01f8\u01bc\3\2\2\2\u01f8\u01c6\3\2\2\2\u01f8\u01de"+
		"\3\2\2\2\u01f9\n\3\2\2\2\u01fa\u01fb\7O\2\2\u01fb\u01fc\7C\2\2\u01fc\u01fd"+
		"\7Z\2\2\u01fd\u01fe\7K\2\2\u01fe\u01ff\7O\2\2\u01ff\u0200\7W\2\2\u0200"+
		"\u0259\7O\2\2\u0201\u0202\7O\2\2\u0202\u0203\7K\2\2\u0203\u0204\7P\2\2"+
		"\u0204\u0205\7K\2\2\u0205\u0206\7O\2\2\u0206\u0207\7W\2\2\u0207\u0259"+
		"\7O\2\2\u0208\u0209\7T\2\2\u0209\u020a\7K\2\2\u020a\u020b\7U\2\2\u020b"+
		"\u020c\7K\2\2\u020c\u020d\7P\2\2\u020d\u020e\7I\2\2\u020e\u020f\7a\2\2"+
		"\u020f\u0210\7V\2\2\u0210\u0211\7T\2\2\u0211\u0212\7G\2\2\u0212\u0213"+
		"\7P\2\2\u0213\u0259\7F\2\2\u0214\u0215\7F\2\2\u0215\u0216\7G\2\2\u0216"+
		"\u0217\7U\2\2\u0217\u0218\7E\2\2\u0218\u0219\7G\2\2\u0219\u021a\7P\2\2"+
		"\u021a\u021b\7F\2\2\u021b\u021c\7K\2\2\u021c\u021d\7P\2\2\u021d\u021e"+
		"\7I\2\2\u021e\u021f\7a\2\2\u021f\u0220\7V\2\2\u0220\u0221\7T\2\2\u0221"+
		"\u0222\7G\2\2\u0222\u0223\7P\2\2\u0223\u0259\7F\2\2\u0224\u0225\7U\2\2"+
		"\u0225\u0226\7G\2\2\u0226\u0227\7T\2\2\u0227\u0228\7K\2\2\u0228\u0229"+
		"\7G\2\2\u0229\u022a\7U\2\2\u022a\u022b\7a\2\2\u022b\u022c\7N\2\2\u022c"+
		"\u022d\7G\2\2\u022d\u022e\7I\2\2\u022e\u022f\7G\2\2\u022f\u0230\7P\2\2"+
		"\u0230\u0259\7F\2\2\u0231\u0232\7V\2\2\u0232\u0233\7K\2\2\u0233\u0234"+
		"\7O\2\2\u0234\u0235\7G\2\2\u0235\u0236\7a\2\2\u0236\u0237\7U\2\2\u0237"+
		"\u0238\7N\2\2\u0238\u0239\7K\2\2\u0239\u023a\7E\2\2\u023a\u0259\7G\2\2"+
		"\u023b\u023c\7V\2\2\u023c\u023d\7T\2\2\u023d\u023e\7G\2\2\u023e\u023f"+
		"\7P\2\2\u023f\u0259\7F\2\2\u0240\u0241\7V\2\2\u0241\u0242\7W\2\2\u0242"+
		"\u0243\7T\2\2\u0243\u0244\7P\2\2\u0244\u0245\7K\2\2\u0245\u0246\7P\2\2"+
		"\u0246\u0247\7I\2\2\u0247\u0248\7a\2\2\u0248\u0249\7R\2\2\u0249\u024a"+
		"\7Q\2\2\u024a\u024b\7K\2\2\u024b\u024c\7P\2\2\u024c\u024d\7V\2\2\u024d"+
		"\u0259\7U\2\2\u024e\u024f\7U\2\2\u024f\u0250\7V\2\2\u0250\u0251\7C\2\2"+
		"\u0251\u0252\7V\2\2\u0252\u0253\7K\2\2\u0253\u0254\7Q\2\2\u0254\u0255"+
		"\7P\2\2\u0255\u0256\7C\2\2\u0256\u0257\7T\2\2\u0257\u0259\7[\2\2\u0258"+
		"\u01fa\3\2\2\2\u0258\u0201\3\2\2\2\u0258\u0208\3\2\2\2\u0258\u0214\3\2"+
		"\2\2\u0258\u0224\3\2\2\2\u0258\u0231\3\2\2\2\u0258\u023b\3\2\2\2\u0258"+
		"\u0240\3\2\2\2\u0258\u024e\3\2\2\2\u0259\f\3\2\2\2\u025a\u025c\7\17\2"+
		"\2\u025b\u025a\3\2\2\2\u025b\u025c\3\2\2\2\u025c\u025d\3\2\2\2\u025d\u025e"+
		"\7\f\2\2\u025e\16\3\2\2\2\7\2\u0183\u01f8\u0258\u025b\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}