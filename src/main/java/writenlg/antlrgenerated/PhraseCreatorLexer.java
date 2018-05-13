// Generated from PhraseCreator.g4 by ANTLR 4.7
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
public class PhraseCreatorLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, GLOBAL_CONCEPT=4, TIME_SERIES_CONCEPT=5, GLOBAL_CONCEPT_TYPE=6, 
		TIME_SERIES_CONCEPT_TYPE=7, PHRASE_SPECIFICATION=8, SUBJECT=9, PREDICATE=10, 
		PART_OF_SPEECH=11, STRING=12, NEW_LINE=13, WHITE_SPACE=14, PLACE_HOLDER_MARKER=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "GLOBAL_CONCEPT", "TIME_SERIES_CONCEPT", "GLOBAL_CONCEPT_TYPE", 
		"TIME_SERIES_CONCEPT_TYPE", "PHRASE_SPECIFICATION", "SUBJECT", "PREDICATE", 
		"PART_OF_SPEECH", "STRING", "NEW_LINE", "WHITE_SPACE", "PLACE_HOLDER_MARKER"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "':'", "' '", "'GlobalConcept'", "'TimeSeriesConcept'", null, 
		null, "'PhraseSpecification'", "'Subject'", "'Predicate'", null, null, 
		null, null, "'@@'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "GLOBAL_CONCEPT", "TIME_SERIES_CONCEPT", "GLOBAL_CONCEPT_TYPE", 
		"TIME_SERIES_CONCEPT_TYPE", "PHRASE_SPECIFICATION", "SUBJECT", "PREDICATE", 
		"PART_OF_SPEECH", "STRING", "NEW_LINE", "WHITE_SPACE", "PLACE_HOLDER_MARKER"
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


	public PhraseCreatorLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PhraseCreator.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\21\u015f\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\3\3\3"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0089\n\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00cc\n\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0148"+
		"\n\f\3\r\3\r\7\r\u014c\n\r\f\r\16\r\u014f\13\r\3\16\5\16\u0152\n\16\3"+
		"\16\3\16\3\17\6\17\u0157\n\17\r\17\16\17\u0158\3\17\3\17\3\20\3\20\3\20"+
		"\2\2\21\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21\3\2\5\5\2\62;C\\c|\6\2\"\"\62;C\\c|\4\2\13\13\"\"\2\u0172"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\3!\3\2\2\2\5#\3\2"+
		"\2\2\7%\3\2\2\2\t\'\3\2\2\2\13\65\3\2\2\2\r\u0088\3\2\2\2\17\u00cb\3\2"+
		"\2\2\21\u00cd\3\2\2\2\23\u00e1\3\2\2\2\25\u00e9\3\2\2\2\27\u0147\3\2\2"+
		"\2\31\u0149\3\2\2\2\33\u0151\3\2\2\2\35\u0156\3\2\2\2\37\u015c\3\2\2\2"+
		"!\"\7?\2\2\"\4\3\2\2\2#$\7<\2\2$\6\3\2\2\2%&\7\"\2\2&\b\3\2\2\2\'(\7I"+
		"\2\2()\7n\2\2)*\7q\2\2*+\7d\2\2+,\7c\2\2,-\7n\2\2-.\7E\2\2./\7q\2\2/\60"+
		"\7p\2\2\60\61\7e\2\2\61\62\7g\2\2\62\63\7r\2\2\63\64\7v\2\2\64\n\3\2\2"+
		"\2\65\66\7V\2\2\66\67\7k\2\2\678\7o\2\289\7g\2\29:\7U\2\2:;\7g\2\2;<\7"+
		"t\2\2<=\7k\2\2=>\7g\2\2>?\7u\2\2?@\7E\2\2@A\7q\2\2AB\7p\2\2BC\7e\2\2C"+
		"D\7g\2\2DE\7r\2\2EF\7v\2\2F\f\3\2\2\2GH\7N\2\2HI\7K\2\2IJ\7P\2\2JK\7G"+
		"\2\2KL\7U\2\2LM\7a\2\2MN\7E\2\2NO\7T\2\2OP\7Q\2\2PQ\7U\2\2Q\u0089\7U\2"+
		"\2RS\7N\2\2ST\7K\2\2TU\7P\2\2UV\7G\2\2VW\7U\2\2WX\7a\2\2XY\7F\2\2YZ\7"+
		"Q\2\2Z[\7a\2\2[\\\7P\2\2\\]\7Q\2\2]^\7V\2\2^_\7a\2\2_`\7E\2\2`a\7T\2\2"+
		"ab\7Q\2\2bc\7U\2\2c\u0089\7U\2\2de\7N\2\2ef\7K\2\2fg\7P\2\2gh\7G\2\2h"+
		"i\7U\2\2ij\7a\2\2jk\7E\2\2kl\7T\2\2lm\7Q\2\2mn\7U\2\2no\7U\2\2op\7a\2"+
		"\2pq\7O\2\2qr\7W\2\2rs\7N\2\2st\7V\2\2tu\7K\2\2uv\7R\2\2vw\7N\2\2wx\7"+
		"G\2\2xy\7a\2\2yz\7V\2\2z{\7K\2\2{|\7O\2\2|}\7G\2\2}\u0089\7U\2\2~\177"+
		"\7N\2\2\177\u0080\7K\2\2\u0080\u0081\7P\2\2\u0081\u0082\7G\2\2\u0082\u0083"+
		"\7a\2\2\u0083\u0084\7E\2\2\u0084\u0085\7Q\2\2\u0085\u0086\7W\2\2\u0086"+
		"\u0087\7P\2\2\u0087\u0089\7V\2\2\u0088G\3\2\2\2\u0088R\3\2\2\2\u0088d"+
		"\3\2\2\2\u0088~\3\2\2\2\u0089\16\3\2\2\2\u008a\u008b\7O\2\2\u008b\u008c"+
		"\7C\2\2\u008c\u008d\7Z\2\2\u008d\u008e\7K\2\2\u008e\u008f\7O\2\2\u008f"+
		"\u0090\7W\2\2\u0090\u00cc\7O\2\2\u0091\u0092\7O\2\2\u0092\u0093\7K\2\2"+
		"\u0093\u0094\7P\2\2\u0094\u0095\7K\2\2\u0095\u0096\7O\2\2\u0096\u0097"+
		"\7W\2\2\u0097\u00cc\7O\2\2\u0098\u0099\7T\2\2\u0099\u009a\7K\2\2\u009a"+
		"\u009b\7U\2\2\u009b\u009c\7K\2\2\u009c\u009d\7P\2\2\u009d\u009e\7I\2\2"+
		"\u009e\u009f\7a\2\2\u009f\u00a0\7V\2\2\u00a0\u00a1\7T\2\2\u00a1\u00a2"+
		"\7G\2\2\u00a2\u00a3\7P\2\2\u00a3\u00cc\7F\2\2\u00a4\u00a5\7F\2\2\u00a5"+
		"\u00a6\7G\2\2\u00a6\u00a7\7U\2\2\u00a7\u00a8\7E\2\2\u00a8\u00a9\7G\2\2"+
		"\u00a9\u00aa\7P\2\2\u00aa\u00ab\7F\2\2\u00ab\u00ac\7K\2\2\u00ac\u00ad"+
		"\7P\2\2\u00ad\u00ae\7I\2\2\u00ae\u00af\7a\2\2\u00af\u00b0\7V\2\2\u00b0"+
		"\u00b1\7T\2\2\u00b1\u00b2\7G\2\2\u00b2\u00b3\7P\2\2\u00b3\u00cc\7F\2\2"+
		"\u00b4\u00b5\7U\2\2\u00b5\u00b6\7G\2\2\u00b6\u00b7\7T\2\2\u00b7\u00b8"+
		"\7K\2\2\u00b8\u00b9\7G\2\2\u00b9\u00ba\7U\2\2\u00ba\u00bb\7a\2\2\u00bb"+
		"\u00bc\7N\2\2\u00bc\u00bd\7G\2\2\u00bd\u00be\7I\2\2\u00be\u00bf\7G\2\2"+
		"\u00bf\u00c0\7P\2\2\u00c0\u00cc\7F\2\2\u00c1\u00c2\7V\2\2\u00c2\u00c3"+
		"\7K\2\2\u00c3\u00c4\7O\2\2\u00c4\u00c5\7G\2\2\u00c5\u00c6\7a\2\2\u00c6"+
		"\u00c7\7U\2\2\u00c7\u00c8\7N\2\2\u00c8\u00c9\7K\2\2\u00c9\u00ca\7E\2\2"+
		"\u00ca\u00cc\7G\2\2\u00cb\u008a\3\2\2\2\u00cb\u0091\3\2\2\2\u00cb\u0098"+
		"\3\2\2\2\u00cb\u00a4\3\2\2\2\u00cb\u00b4\3\2\2\2\u00cb\u00c1\3\2\2\2\u00cc"+
		"\20\3\2\2\2\u00cd\u00ce\7R\2\2\u00ce\u00cf\7j\2\2\u00cf\u00d0\7t\2\2\u00d0"+
		"\u00d1\7c\2\2\u00d1\u00d2\7u\2\2\u00d2\u00d3\7g\2\2\u00d3\u00d4\7U\2\2"+
		"\u00d4\u00d5\7r\2\2\u00d5\u00d6\7g\2\2\u00d6\u00d7\7e\2\2\u00d7\u00d8"+
		"\7k\2\2\u00d8\u00d9\7h\2\2\u00d9\u00da\7k\2\2\u00da\u00db\7e\2\2\u00db"+
		"\u00dc\7c\2\2\u00dc\u00dd\7v\2\2\u00dd\u00de\7k\2\2\u00de\u00df\7q\2\2"+
		"\u00df\u00e0\7p\2\2\u00e0\22\3\2\2\2\u00e1\u00e2\7U\2\2\u00e2\u00e3\7"+
		"w\2\2\u00e3\u00e4\7d\2\2\u00e4\u00e5\7l\2\2\u00e5\u00e6\7g\2\2\u00e6\u00e7"+
		"\7e\2\2\u00e7\u00e8\7v\2\2\u00e8\24\3\2\2\2\u00e9\u00ea\7R\2\2\u00ea\u00eb"+
		"\7t\2\2\u00eb\u00ec\7g\2\2\u00ec\u00ed\7f\2\2\u00ed\u00ee\7k\2\2\u00ee"+
		"\u00ef\7e\2\2\u00ef\u00f0\7c\2\2\u00f0\u00f1\7v\2\2\u00f1\u00f2\7g\2\2"+
		"\u00f2\26\3\2\2\2\u00f3\u00f4\7P\2\2\u00f4\u00f5\7Q\2\2\u00f5\u00f6\7"+
		"W\2\2\u00f6\u0148\7P\2\2\u00f7\u00f8\7R\2\2\u00f8\u00f9\7T\2\2\u00f9\u00fa"+
		"\7Q\2\2\u00fa\u00fb\7P\2\2\u00fb\u00fc\7Q\2\2\u00fc\u00fd\7W\2\2\u00fd"+
		"\u0148\7P\2\2\u00fe\u00ff\7C\2\2\u00ff\u0100\7F\2\2\u0100\u0101\7L\2\2"+
		"\u0101\u0102\7G\2\2\u0102\u0103\7E\2\2\u0103\u0104\7V\2\2\u0104\u0105"+
		"\7K\2\2\u0105\u0106\7X\2\2\u0106\u0148\7G\2\2\u0107\u0108\7F\2\2\u0108"+
		"\u0109\7G\2\2\u0109\u010a\7V\2\2\u010a\u010b\7G\2\2\u010b\u010c\7T\2\2"+
		"\u010c\u010d\7O\2\2\u010d\u010e\7K\2\2\u010e\u010f\7P\2\2\u010f\u0110"+
		"\7G\2\2\u0110\u0148\7T\2\2\u0111\u0112\7X\2\2\u0112\u0113\7G\2\2\u0113"+
		"\u0114\7T\2\2\u0114\u0148\7D\2\2\u0115\u0116\7C\2\2\u0116\u0117\7F\2\2"+
		"\u0117\u0118\7X\2\2\u0118\u0119\7G\2\2\u0119\u011a\7T\2\2\u011a\u0148"+
		"\7D\2\2\u011b\u011c\7R\2\2\u011c\u011d\7T\2\2\u011d\u011e\7G\2\2\u011e"+
		"\u011f\7R\2\2\u011f\u0120\7Q\2\2\u0120\u0121\7U\2\2\u0121\u0122\7K\2\2"+
		"\u0122\u0123\7V\2\2\u0123\u0124\7K\2\2\u0124\u0125\7Q\2\2\u0125\u0148"+
		"\7P\2\2\u0126\u0127\7E\2\2\u0127\u0128\7Q\2\2\u0128\u0129\7P\2\2\u0129"+
		"\u012a\7L\2\2\u012a\u012b\7W\2\2\u012b\u012c\7P\2\2\u012c\u012d\7E\2\2"+
		"\u012d\u012e\7V\2\2\u012e\u012f\7K\2\2\u012f\u0130\7Q\2\2\u0130\u0148"+
		"\7P\2\2\u0131\u0132\7K\2\2\u0132\u0133\7P\2\2\u0133\u0134\7V\2\2\u0134"+
		"\u0135\7G\2\2\u0135\u0136\7T\2\2\u0136\u0137\7L\2\2\u0137\u0138\7G\2\2"+
		"\u0138\u0139\7E\2\2\u0139\u013a\7V\2\2\u013a\u013b\7K\2\2\u013b\u013c"+
		"\7Q\2\2\u013c\u0148\7P\2\2\u013d\u013e\7E\2\2\u013e\u013f\7Q\2\2\u013f"+
		"\u0140\7O\2\2\u0140\u0141\7R\2\2\u0141\u0142\7N\2\2\u0142\u0143\7G\2\2"+
		"\u0143\u0144\7O\2\2\u0144\u0145\7G\2\2\u0145\u0146\7P\2\2\u0146\u0148"+
		"\7V\2\2\u0147\u00f3\3\2\2\2\u0147\u00f7\3\2\2\2\u0147\u00fe\3\2\2\2\u0147"+
		"\u0107\3\2\2\2\u0147\u0111\3\2\2\2\u0147\u0115\3\2\2\2\u0147\u011b\3\2"+
		"\2\2\u0147\u0126\3\2\2\2\u0147\u0131\3\2\2\2\u0147\u013d\3\2\2\2\u0148"+
		"\30\3\2\2\2\u0149\u014d\t\2\2\2\u014a\u014c\t\3\2\2\u014b\u014a\3\2\2"+
		"\2\u014c\u014f\3\2\2\2\u014d\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e\32"+
		"\3\2\2\2\u014f\u014d\3\2\2\2\u0150\u0152\7\17\2\2\u0151\u0150\3\2\2\2"+
		"\u0151\u0152\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0154\7\f\2\2\u0154\34"+
		"\3\2\2\2\u0155\u0157\t\4\2\2\u0156\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158"+
		"\u0156\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015b\b\17"+
		"\2\2\u015b\36\3\2\2\2\u015c\u015d\7B\2\2\u015d\u015e\7B\2\2\u015e \3\2"+
		"\2\2\t\2\u0088\u00cb\u0147\u014d\u0151\u0158\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}