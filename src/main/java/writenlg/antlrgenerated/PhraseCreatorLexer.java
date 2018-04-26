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
		T__0=1, T__1=2, CONCEPT=3, CONCEPT_TYPE=4, PHRASE_SPECIFICATION=5, SUBJECT=6, 
		PREDICATE=7, PART_OF_SPEECH=8, NUMERIC=9, STRING=10, NEW_LINE=11, WHITE_SPACE=12, 
		PLACE_HOLDER_MARKER=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "CONCEPT", "CONCEPT_TYPE", "PHRASE_SPECIFICATION", "SUBJECT", 
		"PREDICATE", "PART_OF_SPEECH", "NUMERIC", "STRING", "NEW_LINE", "WHITE_SPACE", 
		"PLACE_HOLDER_MARKER"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "':'", "'Concept'", null, "'PhraseSpecification'", "'Subject'", 
		"'Predicate'", null, null, null, null, null, "'@@'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "CONCEPT", "CONCEPT_TYPE", "PHRASE_SPECIFICATION", "SUBJECT", 
		"PREDICATE", "PART_OF_SPEECH", "NUMERIC", "STRING", "NEW_LINE", "WHITE_SPACE", 
		"PLACE_HOLDER_MARKER"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\17\u013e\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\5\5\u00a6\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0122\n\t\3\n\6\n\u0125\n\n\r\n\16"+
		"\n\u0126\3\13\3\13\7\13\u012b\n\13\f\13\16\13\u012e\13\13\3\f\5\f\u0131"+
		"\n\f\3\f\3\f\3\r\6\r\u0136\n\r\r\r\16\r\u0137\3\r\3\r\3\16\3\16\3\16\2"+
		"\2\17\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\3"+
		"\2\6\3\2\62;\5\2\62;C\\c|\6\2\"\"\62;C\\c|\4\2\13\13\"\"\2\u0154\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\3\35\3\2\2\2\5\37\3\2\2\2\7!\3\2\2\2\t\u00a5\3\2\2"+
		"\2\13\u00a7\3\2\2\2\r\u00bb\3\2\2\2\17\u00c3\3\2\2\2\21\u0121\3\2\2\2"+
		"\23\u0124\3\2\2\2\25\u0128\3\2\2\2\27\u0130\3\2\2\2\31\u0135\3\2\2\2\33"+
		"\u013b\3\2\2\2\35\36\7?\2\2\36\4\3\2\2\2\37 \7<\2\2 \6\3\2\2\2!\"\7E\2"+
		"\2\"#\7q\2\2#$\7p\2\2$%\7e\2\2%&\7g\2\2&\'\7r\2\2\'(\7v\2\2(\b\3\2\2\2"+
		")*\7O\2\2*+\7C\2\2+,\7Z\2\2,-\7K\2\2-.\7O\2\2./\7W\2\2/\u00a6\7O\2\2\60"+
		"\61\7O\2\2\61\62\7K\2\2\62\63\7P\2\2\63\64\7K\2\2\64\65\7O\2\2\65\66\7"+
		"W\2\2\66\u00a6\7O\2\2\678\7T\2\289\7K\2\29:\7U\2\2:;\7K\2\2;<\7P\2\2<"+
		"=\7I\2\2=>\7a\2\2>?\7V\2\2?@\7T\2\2@A\7G\2\2AB\7P\2\2B\u00a6\7F\2\2CD"+
		"\7F\2\2DE\7G\2\2EF\7U\2\2FG\7E\2\2GH\7G\2\2HI\7P\2\2IJ\7F\2\2JK\7K\2\2"+
		"KL\7P\2\2LM\7I\2\2MN\7a\2\2NO\7V\2\2OP\7T\2\2PQ\7G\2\2QR\7P\2\2R\u00a6"+
		"\7F\2\2ST\7O\2\2TU\7W\2\2UV\7N\2\2VW\7V\2\2WX\7K\2\2XY\7R\2\2YZ\7N\2\2"+
		"Z[\7G\2\2[\\\7a\2\2\\]\7V\2\2]^\7T\2\2^_\7G\2\2_`\7P\2\2`a\7F\2\2a\u00a6"+
		"\7U\2\2bc\7N\2\2cd\7Q\2\2de\7P\2\2ef\7I\2\2fg\7G\2\2gh\7U\2\2hi\7V\2\2"+
		"ij\7a\2\2jk\7V\2\2kl\7T\2\2lm\7G\2\2mn\7P\2\2n\u00a6\7F\2\2op\7N\2\2p"+
		"q\7K\2\2qr\7P\2\2rs\7G\2\2st\7U\2\2tu\7a\2\2uv\7E\2\2vw\7T\2\2wx\7Q\2"+
		"\2xy\7U\2\2y\u00a6\7U\2\2z{\7U\2\2{|\7R\2\2|}\7K\2\2}~\7M\2\2~\177\7G"+
		"\2\2\177\u00a6\7U\2\2\u0080\u0081\7V\2\2\u0081\u0082\7W\2\2\u0082\u0083"+
		"\7T\2\2\u0083\u0084\7P\2\2\u0084\u0085\7K\2\2\u0085\u0086\7P\2\2\u0086"+
		"\u0087\7I\2\2\u0087\u0088\7a\2\2\u0088\u0089\7R\2\2\u0089\u008a\7Q\2\2"+
		"\u008a\u008b\7K\2\2\u008b\u008c\7P\2\2\u008c\u008d\7V\2\2\u008d\u00a6"+
		"\7U\2\2\u008e\u008f\7U\2\2\u008f\u0090\7G\2\2\u0090\u0091\7T\2\2\u0091"+
		"\u0092\7K\2\2\u0092\u0093\7G\2\2\u0093\u0094\7U\2\2\u0094\u0095\7a\2\2"+
		"\u0095\u0096\7N\2\2\u0096\u0097\7G\2\2\u0097\u0098\7I\2\2\u0098\u0099"+
		"\7G\2\2\u0099\u009a\7P\2\2\u009a\u00a6\7F\2\2\u009b\u009c\7V\2\2\u009c"+
		"\u009d\7K\2\2\u009d\u009e\7O\2\2\u009e\u009f\7G\2\2\u009f\u00a0\7a\2\2"+
		"\u00a0\u00a1\7U\2\2\u00a1\u00a2\7N\2\2\u00a2\u00a3\7K\2\2\u00a3\u00a4"+
		"\7E\2\2\u00a4\u00a6\7G\2\2\u00a5)\3\2\2\2\u00a5\60\3\2\2\2\u00a5\67\3"+
		"\2\2\2\u00a5C\3\2\2\2\u00a5S\3\2\2\2\u00a5b\3\2\2\2\u00a5o\3\2\2\2\u00a5"+
		"z\3\2\2\2\u00a5\u0080\3\2\2\2\u00a5\u008e\3\2\2\2\u00a5\u009b\3\2\2\2"+
		"\u00a6\n\3\2\2\2\u00a7\u00a8\7R\2\2\u00a8\u00a9\7j\2\2\u00a9\u00aa\7t"+
		"\2\2\u00aa\u00ab\7c\2\2\u00ab\u00ac\7u\2\2\u00ac\u00ad\7g\2\2\u00ad\u00ae"+
		"\7U\2\2\u00ae\u00af\7r\2\2\u00af\u00b0\7g\2\2\u00b0\u00b1\7e\2\2\u00b1"+
		"\u00b2\7k\2\2\u00b2\u00b3\7h\2\2\u00b3\u00b4\7k\2\2\u00b4\u00b5\7e\2\2"+
		"\u00b5\u00b6\7c\2\2\u00b6\u00b7\7v\2\2\u00b7\u00b8\7k\2\2\u00b8\u00b9"+
		"\7q\2\2\u00b9\u00ba\7p\2\2\u00ba\f\3\2\2\2\u00bb\u00bc\7U\2\2\u00bc\u00bd"+
		"\7w\2\2\u00bd\u00be\7d\2\2\u00be\u00bf\7l\2\2\u00bf\u00c0\7g\2\2\u00c0"+
		"\u00c1\7e\2\2\u00c1\u00c2\7v\2\2\u00c2\16\3\2\2\2\u00c3\u00c4\7R\2\2\u00c4"+
		"\u00c5\7t\2\2\u00c5\u00c6\7g\2\2\u00c6\u00c7\7f\2\2\u00c7\u00c8\7k\2\2"+
		"\u00c8\u00c9\7e\2\2\u00c9\u00ca\7c\2\2\u00ca\u00cb\7v\2\2\u00cb\u00cc"+
		"\7g\2\2\u00cc\20\3\2\2\2\u00cd\u00ce\7P\2\2\u00ce\u00cf\7Q\2\2\u00cf\u00d0"+
		"\7W\2\2\u00d0\u0122\7P\2\2\u00d1\u00d2\7R\2\2\u00d2\u00d3\7T\2\2\u00d3"+
		"\u00d4\7Q\2\2\u00d4\u00d5\7P\2\2\u00d5\u00d6\7Q\2\2\u00d6\u00d7\7W\2\2"+
		"\u00d7\u0122\7P\2\2\u00d8\u00d9\7C\2\2\u00d9\u00da\7F\2\2\u00da\u00db"+
		"\7L\2\2\u00db\u00dc\7G\2\2\u00dc\u00dd\7E\2\2\u00dd\u00de\7V\2\2\u00de"+
		"\u00df\7K\2\2\u00df\u00e0\7X\2\2\u00e0\u0122\7G\2\2\u00e1\u00e2\7F\2\2"+
		"\u00e2\u00e3\7G\2\2\u00e3\u00e4\7V\2\2\u00e4\u00e5\7G\2\2\u00e5\u00e6"+
		"\7T\2\2\u00e6\u00e7\7O\2\2\u00e7\u00e8\7K\2\2\u00e8\u00e9\7P\2\2\u00e9"+
		"\u00ea\7G\2\2\u00ea\u0122\7T\2\2\u00eb\u00ec\7X\2\2\u00ec\u00ed\7G\2\2"+
		"\u00ed\u00ee\7T\2\2\u00ee\u0122\7D\2\2\u00ef\u00f0\7C\2\2\u00f0\u00f1"+
		"\7F\2\2\u00f1\u00f2\7X\2\2\u00f2\u00f3\7G\2\2\u00f3\u00f4\7T\2\2\u00f4"+
		"\u0122\7D\2\2\u00f5\u00f6\7R\2\2\u00f6\u00f7\7T\2\2\u00f7\u00f8\7G\2\2"+
		"\u00f8\u00f9\7R\2\2\u00f9\u00fa\7Q\2\2\u00fa\u00fb\7U\2\2\u00fb\u00fc"+
		"\7K\2\2\u00fc\u00fd\7V\2\2\u00fd\u00fe\7K\2\2\u00fe\u00ff\7Q\2\2\u00ff"+
		"\u0122\7P\2\2\u0100\u0101\7E\2\2\u0101\u0102\7Q\2\2\u0102\u0103\7P\2\2"+
		"\u0103\u0104\7L\2\2\u0104\u0105\7W\2\2\u0105\u0106\7P\2\2\u0106\u0107"+
		"\7E\2\2\u0107\u0108\7V\2\2\u0108\u0109\7K\2\2\u0109\u010a\7Q\2\2\u010a"+
		"\u0122\7P\2\2\u010b\u010c\7K\2\2\u010c\u010d\7P\2\2\u010d\u010e\7V\2\2"+
		"\u010e\u010f\7G\2\2\u010f\u0110\7T\2\2\u0110\u0111\7L\2\2\u0111\u0112"+
		"\7G\2\2\u0112\u0113\7E\2\2\u0113\u0114\7V\2\2\u0114\u0115\7K\2\2\u0115"+
		"\u0116\7Q\2\2\u0116\u0122\7P\2\2\u0117\u0118\7E\2\2\u0118\u0119\7Q\2\2"+
		"\u0119\u011a\7O\2\2\u011a\u011b\7R\2\2\u011b\u011c\7N\2\2\u011c\u011d"+
		"\7G\2\2\u011d\u011e\7O\2\2\u011e\u011f\7G\2\2\u011f\u0120\7P\2\2\u0120"+
		"\u0122\7V\2\2\u0121\u00cd\3\2\2\2\u0121\u00d1\3\2\2\2\u0121\u00d8\3\2"+
		"\2\2\u0121\u00e1\3\2\2\2\u0121\u00eb\3\2\2\2\u0121\u00ef\3\2\2\2\u0121"+
		"\u00f5\3\2\2\2\u0121\u0100\3\2\2\2\u0121\u010b\3\2\2\2\u0121\u0117\3\2"+
		"\2\2\u0122\22\3\2\2\2\u0123\u0125\t\2\2\2\u0124\u0123\3\2\2\2\u0125\u0126"+
		"\3\2\2\2\u0126\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127\24\3\2\2\2\u0128"+
		"\u012c\t\3\2\2\u0129\u012b\t\4\2\2\u012a\u0129\3\2\2\2\u012b\u012e\3\2"+
		"\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d\26\3\2\2\2\u012e\u012c"+
		"\3\2\2\2\u012f\u0131\7\17\2\2\u0130\u012f\3\2\2\2\u0130\u0131\3\2\2\2"+
		"\u0131\u0132\3\2\2\2\u0132\u0133\7\f\2\2\u0133\30\3\2\2\2\u0134\u0136"+
		"\t\5\2\2\u0135\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u0135\3\2\2\2\u0137"+
		"\u0138\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013a\b\r\2\2\u013a\32\3\2\2"+
		"\2\u013b\u013c\7B\2\2\u013c\u013d\7B\2\2\u013d\34\3\2\2\2\t\2\u00a5\u0121"+
		"\u0126\u012c\u0130\u0137\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}