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
		T__0=1, T__1=2, GLOBAL_CONCEPT=3, TIME_SERIES_CONCEPT=4, CONSTRAINTS=5, 
		WEIGHTING=6, GLOBAL_CONCEPT_TYPE=7, TIME_SERIES_CONCEPT_TYPE=8, PHRASE_SPECIFICATION=9, 
		SUBJECT=10, PREDICATE=11, PART_OF_SPEECH=12, NUMERIC=13, STRING=14, NEW_LINE=15, 
		WHITE_SPACE=16, PLACE_HOLDER_MARKER=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "GLOBAL_CONCEPT", "TIME_SERIES_CONCEPT", "CONSTRAINTS", 
		"WEIGHTING", "GLOBAL_CONCEPT_TYPE", "TIME_SERIES_CONCEPT_TYPE", "PHRASE_SPECIFICATION", 
		"SUBJECT", "PREDICATE", "PART_OF_SPEECH", "NUMERIC", "STRING", "NEW_LINE", 
		"WHITE_SPACE", "PLACE_HOLDER_MARKER"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "':'", "'GlobalConcept'", "'TimeSeriesConcept'", "'Constraints'", 
		null, null, null, "'PhraseSpecification'", "'Subject'", "'Predicate'", 
		null, null, null, null, null, "'@@'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "GLOBAL_CONCEPT", "TIME_SERIES_CONCEPT", "CONSTRAINTS", 
		"WEIGHTING", "GLOBAL_CONCEPT_TYPE", "TIME_SERIES_CONCEPT_TYPE", "PHRASE_SPECIFICATION", 
		"SUBJECT", "PREDICATE", "PART_OF_SPEECH", "NUMERIC", "STRING", "NEW_LINE", 
		"WHITE_SPACE", "PLACE_HOLDER_MARKER"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\23\u0191\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0086\n\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\5\t\u00f9\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0175\n\r\3\16\6\16\u0178\n\16"+
		"\r\16\16\16\u0179\3\17\3\17\7\17\u017e\n\17\f\17\16\17\u0181\13\17\3\20"+
		"\5\20\u0184\n\20\3\20\3\20\3\21\6\21\u0189\n\21\r\21\16\21\u018a\3\21"+
		"\3\21\3\22\3\22\3\22\2\2\23\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23\3\2\7\3\2\63\67\3\2\62;\5\2\62"+
		";C\\c|\6\2\"\"\62;C\\c|\4\2\13\13\"\"\2\u01a8\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\3%\3\2\2\2\5\'\3\2"+
		"\2\2\7)\3\2\2\2\t\67\3\2\2\2\13I\3\2\2\2\rU\3\2\2\2\17\u0085\3\2\2\2\21"+
		"\u00f8\3\2\2\2\23\u00fa\3\2\2\2\25\u010e\3\2\2\2\27\u0116\3\2\2\2\31\u0174"+
		"\3\2\2\2\33\u0177\3\2\2\2\35\u017b\3\2\2\2\37\u0183\3\2\2\2!\u0188\3\2"+
		"\2\2#\u018e\3\2\2\2%&\7?\2\2&\4\3\2\2\2\'(\7<\2\2(\6\3\2\2\2)*\7I\2\2"+
		"*+\7n\2\2+,\7q\2\2,-\7d\2\2-.\7c\2\2./\7n\2\2/\60\7E\2\2\60\61\7q\2\2"+
		"\61\62\7p\2\2\62\63\7e\2\2\63\64\7g\2\2\64\65\7r\2\2\65\66\7v\2\2\66\b"+
		"\3\2\2\2\678\7V\2\289\7k\2\29:\7o\2\2:;\7g\2\2;<\7U\2\2<=\7g\2\2=>\7t"+
		"\2\2>?\7k\2\2?@\7g\2\2@A\7u\2\2AB\7E\2\2BC\7q\2\2CD\7p\2\2DE\7e\2\2EF"+
		"\7g\2\2FG\7r\2\2GH\7v\2\2H\n\3\2\2\2IJ\7E\2\2JK\7q\2\2KL\7p\2\2LM\7u\2"+
		"\2MN\7v\2\2NO\7t\2\2OP\7c\2\2PQ\7k\2\2QR\7p\2\2RS\7v\2\2ST\7u\2\2T\f\3"+
		"\2\2\2UV\t\2\2\2V\16\3\2\2\2WX\7E\2\2XY\7Q\2\2YZ\7P\2\2Z[\7U\2\2[\\\7"+
		"K\2\2\\]\7U\2\2]^\7V\2\2^_\7G\2\2_`\7P\2\2`a\7V\2\2ab\7a\2\2bc\7F\2\2"+
		"cd\7K\2\2de\7U\2\2ef\7V\2\2fg\7C\2\2gh\7P\2\2hi\7E\2\2ij\7G\2\2jk\7a\2"+
		"\2kl\7C\2\2lm\7R\2\2mn\7C\2\2no\7T\2\2o\u0086\7V\2\2pq\7N\2\2qr\7K\2\2"+
		"rs\7P\2\2st\7G\2\2tu\7U\2\2uv\7a\2\2vw\7E\2\2wx\7T\2\2xy\7Q\2\2yz\7U\2"+
		"\2z\u0086\7U\2\2{|\7N\2\2|}\7K\2\2}~\7P\2\2~\177\7G\2\2\177\u0080\7U\2"+
		"\2\u0080\u0081\7a\2\2\u0081\u0082\7O\2\2\u0082\u0083\7G\2\2\u0083\u0084"+
		"\7G\2\2\u0084\u0086\7V\2\2\u0085W\3\2\2\2\u0085p\3\2\2\2\u0085{\3\2\2"+
		"\2\u0086\20\3\2\2\2\u0087\u0088\7O\2\2\u0088\u0089\7C\2\2\u0089\u008a"+
		"\7Z\2\2\u008a\u008b\7K\2\2\u008b\u008c\7O\2\2\u008c\u008d\7W\2\2\u008d"+
		"\u00f9\7O\2\2\u008e\u008f\7O\2\2\u008f\u0090\7K\2\2\u0090\u0091\7P\2\2"+
		"\u0091\u0092\7K\2\2\u0092\u0093\7O\2\2\u0093\u0094\7W\2\2\u0094\u00f9"+
		"\7O\2\2\u0095\u0096\7T\2\2\u0096\u0097\7K\2\2\u0097\u0098\7U\2\2\u0098"+
		"\u0099\7K\2\2\u0099\u009a\7P\2\2\u009a\u009b\7I\2\2\u009b\u009c\7a\2\2"+
		"\u009c\u009d\7V\2\2\u009d\u009e\7T\2\2\u009e\u009f\7G\2\2\u009f\u00a0"+
		"\7P\2\2\u00a0\u00f9\7F\2\2\u00a1\u00a2\7F\2\2\u00a2\u00a3\7G\2\2\u00a3"+
		"\u00a4\7U\2\2\u00a4\u00a5\7E\2\2\u00a5\u00a6\7G\2\2\u00a6\u00a7\7P\2\2"+
		"\u00a7\u00a8\7F\2\2\u00a8\u00a9\7K\2\2\u00a9\u00aa\7P\2\2\u00aa\u00ab"+
		"\7I\2\2\u00ab\u00ac\7a\2\2\u00ac\u00ad\7V\2\2\u00ad\u00ae\7T\2\2\u00ae"+
		"\u00af\7G\2\2\u00af\u00b0\7P\2\2\u00b0\u00f9\7F\2\2\u00b1\u00b2\7O\2\2"+
		"\u00b2\u00b3\7W\2\2\u00b3\u00b4\7N\2\2\u00b4\u00b5\7V\2\2\u00b5\u00b6"+
		"\7K\2\2\u00b6\u00b7\7R\2\2\u00b7\u00b8\7N\2\2\u00b8\u00b9\7G\2\2\u00b9"+
		"\u00ba\7a\2\2\u00ba\u00bb\7V\2\2\u00bb\u00bc\7T\2\2\u00bc\u00bd\7G\2\2"+
		"\u00bd\u00be\7P\2\2\u00be\u00bf\7F\2\2\u00bf\u00f9\7U\2\2\u00c0\u00c1"+
		"\7N\2\2\u00c1\u00c2\7Q\2\2\u00c2\u00c3\7P\2\2\u00c3\u00c4\7I\2\2\u00c4"+
		"\u00c5\7G\2\2\u00c5\u00c6\7U\2\2\u00c6\u00c7\7V\2\2\u00c7\u00c8\7a\2\2"+
		"\u00c8\u00c9\7V\2\2\u00c9\u00ca\7T\2\2\u00ca\u00cb\7G\2\2\u00cb\u00cc"+
		"\7P\2\2\u00cc\u00f9\7F\2\2\u00cd\u00ce\7U\2\2\u00ce\u00cf\7R\2\2\u00cf"+
		"\u00d0\7K\2\2\u00d0\u00d1\7M\2\2\u00d1\u00d2\7G\2\2\u00d2\u00f9\7U\2\2"+
		"\u00d3\u00d4\7V\2\2\u00d4\u00d5\7W\2\2\u00d5\u00d6\7T\2\2\u00d6\u00d7"+
		"\7P\2\2\u00d7\u00d8\7K\2\2\u00d8\u00d9\7P\2\2\u00d9\u00da\7I\2\2\u00da"+
		"\u00db\7a\2\2\u00db\u00dc\7R\2\2\u00dc\u00dd\7Q\2\2\u00dd\u00de\7K\2\2"+
		"\u00de\u00df\7P\2\2\u00df\u00e0\7V\2\2\u00e0\u00f9\7U\2\2\u00e1\u00e2"+
		"\7U\2\2\u00e2\u00e3\7G\2\2\u00e3\u00e4\7T\2\2\u00e4\u00e5\7K\2\2\u00e5"+
		"\u00e6\7G\2\2\u00e6\u00e7\7U\2\2\u00e7\u00e8\7a\2\2\u00e8\u00e9\7N\2\2"+
		"\u00e9\u00ea\7G\2\2\u00ea\u00eb\7I\2\2\u00eb\u00ec\7G\2\2\u00ec\u00ed"+
		"\7P\2\2\u00ed\u00f9\7F\2\2\u00ee\u00ef\7V\2\2\u00ef\u00f0\7K\2\2\u00f0"+
		"\u00f1\7O\2\2\u00f1\u00f2\7G\2\2\u00f2\u00f3\7a\2\2\u00f3\u00f4\7U\2\2"+
		"\u00f4\u00f5\7N\2\2\u00f5\u00f6\7K\2\2\u00f6\u00f7\7E\2\2\u00f7\u00f9"+
		"\7G\2\2\u00f8\u0087\3\2\2\2\u00f8\u008e\3\2\2\2\u00f8\u0095\3\2\2\2\u00f8"+
		"\u00a1\3\2\2\2\u00f8\u00b1\3\2\2\2\u00f8\u00c0\3\2\2\2\u00f8\u00cd\3\2"+
		"\2\2\u00f8\u00d3\3\2\2\2\u00f8\u00e1\3\2\2\2\u00f8\u00ee\3\2\2\2\u00f9"+
		"\22\3\2\2\2\u00fa\u00fb\7R\2\2\u00fb\u00fc\7j\2\2\u00fc\u00fd\7t\2\2\u00fd"+
		"\u00fe\7c\2\2\u00fe\u00ff\7u\2\2\u00ff\u0100\7g\2\2\u0100\u0101\7U\2\2"+
		"\u0101\u0102\7r\2\2\u0102\u0103\7g\2\2\u0103\u0104\7e\2\2\u0104\u0105"+
		"\7k\2\2\u0105\u0106\7h\2\2\u0106\u0107\7k\2\2\u0107\u0108\7e\2\2\u0108"+
		"\u0109\7c\2\2\u0109\u010a\7v\2\2\u010a\u010b\7k\2\2\u010b\u010c\7q\2\2"+
		"\u010c\u010d\7p\2\2\u010d\24\3\2\2\2\u010e\u010f\7U\2\2\u010f\u0110\7"+
		"w\2\2\u0110\u0111\7d\2\2\u0111\u0112\7l\2\2\u0112\u0113\7g\2\2\u0113\u0114"+
		"\7e\2\2\u0114\u0115\7v\2\2\u0115\26\3\2\2\2\u0116\u0117\7R\2\2\u0117\u0118"+
		"\7t\2\2\u0118\u0119\7g\2\2\u0119\u011a\7f\2\2\u011a\u011b\7k\2\2\u011b"+
		"\u011c\7e\2\2\u011c\u011d\7c\2\2\u011d\u011e\7v\2\2\u011e\u011f\7g\2\2"+
		"\u011f\30\3\2\2\2\u0120\u0121\7P\2\2\u0121\u0122\7Q\2\2\u0122\u0123\7"+
		"W\2\2\u0123\u0175\7P\2\2\u0124\u0125\7R\2\2\u0125\u0126\7T\2\2\u0126\u0127"+
		"\7Q\2\2\u0127\u0128\7P\2\2\u0128\u0129\7Q\2\2\u0129\u012a\7W\2\2\u012a"+
		"\u0175\7P\2\2\u012b\u012c\7C\2\2\u012c\u012d\7F\2\2\u012d\u012e\7L\2\2"+
		"\u012e\u012f\7G\2\2\u012f\u0130\7E\2\2\u0130\u0131\7V\2\2\u0131\u0132"+
		"\7K\2\2\u0132\u0133\7X\2\2\u0133\u0175\7G\2\2\u0134\u0135\7F\2\2\u0135"+
		"\u0136\7G\2\2\u0136\u0137\7V\2\2\u0137\u0138\7G\2\2\u0138\u0139\7T\2\2"+
		"\u0139\u013a\7O\2\2\u013a\u013b\7K\2\2\u013b\u013c\7P\2\2\u013c\u013d"+
		"\7G\2\2\u013d\u0175\7T\2\2\u013e\u013f\7X\2\2\u013f\u0140\7G\2\2\u0140"+
		"\u0141\7T\2\2\u0141\u0175\7D\2\2\u0142\u0143\7C\2\2\u0143\u0144\7F\2\2"+
		"\u0144\u0145\7X\2\2\u0145\u0146\7G\2\2\u0146\u0147\7T\2\2\u0147\u0175"+
		"\7D\2\2\u0148\u0149\7R\2\2\u0149\u014a\7T\2\2\u014a\u014b\7G\2\2\u014b"+
		"\u014c\7R\2\2\u014c\u014d\7Q\2\2\u014d\u014e\7U\2\2\u014e\u014f\7K\2\2"+
		"\u014f\u0150\7V\2\2\u0150\u0151\7K\2\2\u0151\u0152\7Q\2\2\u0152\u0175"+
		"\7P\2\2\u0153\u0154\7E\2\2\u0154\u0155\7Q\2\2\u0155\u0156\7P\2\2\u0156"+
		"\u0157\7L\2\2\u0157\u0158\7W\2\2\u0158\u0159\7P\2\2\u0159\u015a\7E\2\2"+
		"\u015a\u015b\7V\2\2\u015b\u015c\7K\2\2\u015c\u015d\7Q\2\2\u015d\u0175"+
		"\7P\2\2\u015e\u015f\7K\2\2\u015f\u0160\7P\2\2\u0160\u0161\7V\2\2\u0161"+
		"\u0162\7G\2\2\u0162\u0163\7T\2\2\u0163\u0164\7L\2\2\u0164\u0165\7G\2\2"+
		"\u0165\u0166\7E\2\2\u0166\u0167\7V\2\2\u0167\u0168\7K\2\2\u0168\u0169"+
		"\7Q\2\2\u0169\u0175\7P\2\2\u016a\u016b\7E\2\2\u016b\u016c\7Q\2\2\u016c"+
		"\u016d\7O\2\2\u016d\u016e\7R\2\2\u016e\u016f\7N\2\2\u016f\u0170\7G\2\2"+
		"\u0170\u0171\7O\2\2\u0171\u0172\7G\2\2\u0172\u0173\7P\2\2\u0173\u0175"+
		"\7V\2\2\u0174\u0120\3\2\2\2\u0174\u0124\3\2\2\2\u0174\u012b\3\2\2\2\u0174"+
		"\u0134\3\2\2\2\u0174\u013e\3\2\2\2\u0174\u0142\3\2\2\2\u0174\u0148\3\2"+
		"\2\2\u0174\u0153\3\2\2\2\u0174\u015e\3\2\2\2\u0174\u016a\3\2\2\2\u0175"+
		"\32\3\2\2\2\u0176\u0178\t\3\2\2\u0177\u0176\3\2\2\2\u0178\u0179\3\2\2"+
		"\2\u0179\u0177\3\2\2\2\u0179\u017a\3\2\2\2\u017a\34\3\2\2\2\u017b\u017f"+
		"\t\4\2\2\u017c\u017e\t\5\2\2\u017d\u017c\3\2\2\2\u017e\u0181\3\2\2\2\u017f"+
		"\u017d\3\2\2\2\u017f\u0180\3\2\2\2\u0180\36\3\2\2\2\u0181\u017f\3\2\2"+
		"\2\u0182\u0184\7\17\2\2\u0183\u0182\3\2\2\2\u0183\u0184\3\2\2\2\u0184"+
		"\u0185\3\2\2\2\u0185\u0186\7\f\2\2\u0186 \3\2\2\2\u0187\u0189\t\6\2\2"+
		"\u0188\u0187\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u0188\3\2\2\2\u018a\u018b"+
		"\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018d\b\21\2\2\u018d\"\3\2\2\2\u018e"+
		"\u018f\7B\2\2\u018f\u0190\7B\2\2\u0190$\3\2\2\2\n\2\u0085\u00f8\u0174"+
		"\u0179\u017f\u0183\u018a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}