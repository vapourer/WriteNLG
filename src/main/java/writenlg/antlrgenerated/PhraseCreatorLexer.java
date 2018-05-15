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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		GLOBAL_CONCEPT=10, TIME_SERIES_CONCEPT=11, GLOBAL_CONCEPT_TYPE=12, TIME_SERIES_CONCEPT_TYPE=13, 
		PHRASE_SPECIFICATION=14, SUBJECT=15, PREDICATE=16, FEATURES=17, PART_OF_SPEECH=18, 
		STRING=19, NEW_LINE=20, WHITE_SPACE=21, PLACE_HOLDER_MARKER=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"GLOBAL_CONCEPT", "TIME_SERIES_CONCEPT", "GLOBAL_CONCEPT_TYPE", "TIME_SERIES_CONCEPT_TYPE", 
		"PHRASE_SPECIFICATION", "SUBJECT", "PREDICATE", "FEATURES", "PART_OF_SPEECH", 
		"STRING", "NEW_LINE", "WHITE_SPACE", "PLACE_HOLDER_MARKER"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'tense'", "'present'", "'past'", "'future'", "'complementiser'", 
		"'conjunction'", "':'", "' '", "'GlobalConcept'", "'TimeSeriesConcept'", 
		null, null, "'PhraseSpecification'", "'Subject'", "'Predicate'", "'Features'", 
		null, null, null, null, "'@@'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "GLOBAL_CONCEPT", 
		"TIME_SERIES_CONCEPT", "GLOBAL_CONCEPT_TYPE", "TIME_SERIES_CONCEPT_TYPE", 
		"PHRASE_SPECIFICATION", "SUBJECT", "PREDICATE", "FEATURES", "PART_OF_SPEECH", 
		"STRING", "NEW_LINE", "WHITE_SPACE", "PLACE_HOLDER_MARKER"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\30\u01ab\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r"+
		"\u00cc\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u010f\n\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\5\23\u0194\n\23\3\24\3\24\7\24\u0198\n\24\f"+
		"\24\16\24\u019b\13\24\3\25\5\25\u019e\n\25\3\25\3\25\3\26\6\26\u01a3\n"+
		"\26\r\26\16\26\u01a4\3\26\3\26\3\27\3\27\3\27\2\2\30\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30\3\2\5\5\2\62;C\\c|\6\2\"\"\62;C\\c|\4\2\13\13\"\"\2\u01be"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\3/\3\2\2"+
		"\2\5\61\3\2\2\2\7\67\3\2\2\2\t?\3\2\2\2\13D\3\2\2\2\rK\3\2\2\2\17Z\3\2"+
		"\2\2\21f\3\2\2\2\23h\3\2\2\2\25j\3\2\2\2\27x\3\2\2\2\31\u00cb\3\2\2\2"+
		"\33\u010e\3\2\2\2\35\u0110\3\2\2\2\37\u0124\3\2\2\2!\u012c\3\2\2\2#\u0136"+
		"\3\2\2\2%\u0193\3\2\2\2\'\u0195\3\2\2\2)\u019d\3\2\2\2+\u01a2\3\2\2\2"+
		"-\u01a8\3\2\2\2/\60\7?\2\2\60\4\3\2\2\2\61\62\7v\2\2\62\63\7g\2\2\63\64"+
		"\7p\2\2\64\65\7u\2\2\65\66\7g\2\2\66\6\3\2\2\2\678\7r\2\289\7t\2\29:\7"+
		"g\2\2:;\7u\2\2;<\7g\2\2<=\7p\2\2=>\7v\2\2>\b\3\2\2\2?@\7r\2\2@A\7c\2\2"+
		"AB\7u\2\2BC\7v\2\2C\n\3\2\2\2DE\7h\2\2EF\7w\2\2FG\7v\2\2GH\7w\2\2HI\7"+
		"t\2\2IJ\7g\2\2J\f\3\2\2\2KL\7e\2\2LM\7q\2\2MN\7o\2\2NO\7r\2\2OP\7n\2\2"+
		"PQ\7g\2\2QR\7o\2\2RS\7g\2\2ST\7p\2\2TU\7v\2\2UV\7k\2\2VW\7u\2\2WX\7g\2"+
		"\2XY\7t\2\2Y\16\3\2\2\2Z[\7e\2\2[\\\7q\2\2\\]\7p\2\2]^\7l\2\2^_\7w\2\2"+
		"_`\7p\2\2`a\7e\2\2ab\7v\2\2bc\7k\2\2cd\7q\2\2de\7p\2\2e\20\3\2\2\2fg\7"+
		"<\2\2g\22\3\2\2\2hi\7\"\2\2i\24\3\2\2\2jk\7I\2\2kl\7n\2\2lm\7q\2\2mn\7"+
		"d\2\2no\7c\2\2op\7n\2\2pq\7E\2\2qr\7q\2\2rs\7p\2\2st\7e\2\2tu\7g\2\2u"+
		"v\7r\2\2vw\7v\2\2w\26\3\2\2\2xy\7V\2\2yz\7k\2\2z{\7o\2\2{|\7g\2\2|}\7"+
		"U\2\2}~\7g\2\2~\177\7t\2\2\177\u0080\7k\2\2\u0080\u0081\7g\2\2\u0081\u0082"+
		"\7u\2\2\u0082\u0083\7E\2\2\u0083\u0084\7q\2\2\u0084\u0085\7p\2\2\u0085"+
		"\u0086\7e\2\2\u0086\u0087\7g\2\2\u0087\u0088\7r\2\2\u0088\u0089\7v\2\2"+
		"\u0089\30\3\2\2\2\u008a\u008b\7N\2\2\u008b\u008c\7K\2\2\u008c\u008d\7"+
		"P\2\2\u008d\u008e\7G\2\2\u008e\u008f\7U\2\2\u008f\u0090\7a\2\2\u0090\u0091"+
		"\7E\2\2\u0091\u0092\7T\2\2\u0092\u0093\7Q\2\2\u0093\u0094\7U\2\2\u0094"+
		"\u00cc\7U\2\2\u0095\u0096\7N\2\2\u0096\u0097\7K\2\2\u0097\u0098\7P\2\2"+
		"\u0098\u0099\7G\2\2\u0099\u009a\7U\2\2\u009a\u009b\7a\2\2\u009b\u009c"+
		"\7F\2\2\u009c\u009d\7Q\2\2\u009d\u009e\7a\2\2\u009e\u009f\7P\2\2\u009f"+
		"\u00a0\7Q\2\2\u00a0\u00a1\7V\2\2\u00a1\u00a2\7a\2\2\u00a2\u00a3\7E\2\2"+
		"\u00a3\u00a4\7T\2\2\u00a4\u00a5\7Q\2\2\u00a5\u00a6\7U\2\2\u00a6\u00cc"+
		"\7U\2\2\u00a7\u00a8\7N\2\2\u00a8\u00a9\7K\2\2\u00a9\u00aa\7P\2\2\u00aa"+
		"\u00ab\7G\2\2\u00ab\u00ac\7U\2\2\u00ac\u00ad\7a\2\2\u00ad\u00ae\7E\2\2"+
		"\u00ae\u00af\7T\2\2\u00af\u00b0\7Q\2\2\u00b0\u00b1\7U\2\2\u00b1\u00b2"+
		"\7U\2\2\u00b2\u00b3\7a\2\2\u00b3\u00b4\7O\2\2\u00b4\u00b5\7W\2\2\u00b5"+
		"\u00b6\7N\2\2\u00b6\u00b7\7V\2\2\u00b7\u00b8\7K\2\2\u00b8\u00b9\7R\2\2"+
		"\u00b9\u00ba\7N\2\2\u00ba\u00bb\7G\2\2\u00bb\u00bc\7a\2\2\u00bc\u00bd"+
		"\7V\2\2\u00bd\u00be\7K\2\2\u00be\u00bf\7O\2\2\u00bf\u00c0\7G\2\2\u00c0"+
		"\u00cc\7U\2\2\u00c1\u00c2\7N\2\2\u00c2\u00c3\7K\2\2\u00c3\u00c4\7P\2\2"+
		"\u00c4\u00c5\7G\2\2\u00c5\u00c6\7a\2\2\u00c6\u00c7\7E\2\2\u00c7\u00c8"+
		"\7Q\2\2\u00c8\u00c9\7W\2\2\u00c9\u00ca\7P\2\2\u00ca\u00cc\7V\2\2\u00cb"+
		"\u008a\3\2\2\2\u00cb\u0095\3\2\2\2\u00cb\u00a7\3\2\2\2\u00cb\u00c1\3\2"+
		"\2\2\u00cc\32\3\2\2\2\u00cd\u00ce\7O\2\2\u00ce\u00cf\7C\2\2\u00cf\u00d0"+
		"\7Z\2\2\u00d0\u00d1\7K\2\2\u00d1\u00d2\7O\2\2\u00d2\u00d3\7W\2\2\u00d3"+
		"\u010f\7O\2\2\u00d4\u00d5\7O\2\2\u00d5\u00d6\7K\2\2\u00d6\u00d7\7P\2\2"+
		"\u00d7\u00d8\7K\2\2\u00d8\u00d9\7O\2\2\u00d9\u00da\7W\2\2\u00da\u010f"+
		"\7O\2\2\u00db\u00dc\7T\2\2\u00dc\u00dd\7K\2\2\u00dd\u00de\7U\2\2\u00de"+
		"\u00df\7K\2\2\u00df\u00e0\7P\2\2\u00e0\u00e1\7I\2\2\u00e1\u00e2\7a\2\2"+
		"\u00e2\u00e3\7V\2\2\u00e3\u00e4\7T\2\2\u00e4\u00e5\7G\2\2\u00e5\u00e6"+
		"\7P\2\2\u00e6\u010f\7F\2\2\u00e7\u00e8\7F\2\2\u00e8\u00e9\7G\2\2\u00e9"+
		"\u00ea\7U\2\2\u00ea\u00eb\7E\2\2\u00eb\u00ec\7G\2\2\u00ec\u00ed\7P\2\2"+
		"\u00ed\u00ee\7F\2\2\u00ee\u00ef\7K\2\2\u00ef\u00f0\7P\2\2\u00f0\u00f1"+
		"\7I\2\2\u00f1\u00f2\7a\2\2\u00f2\u00f3\7V\2\2\u00f3\u00f4\7T\2\2\u00f4"+
		"\u00f5\7G\2\2\u00f5\u00f6\7P\2\2\u00f6\u010f\7F\2\2\u00f7\u00f8\7U\2\2"+
		"\u00f8\u00f9\7G\2\2\u00f9\u00fa\7T\2\2\u00fa\u00fb\7K\2\2\u00fb\u00fc"+
		"\7G\2\2\u00fc\u00fd\7U\2\2\u00fd\u00fe\7a\2\2\u00fe\u00ff\7N\2\2\u00ff"+
		"\u0100\7G\2\2\u0100\u0101\7I\2\2\u0101\u0102\7G\2\2\u0102\u0103\7P\2\2"+
		"\u0103\u010f\7F\2\2\u0104\u0105\7V\2\2\u0105\u0106\7K\2\2\u0106\u0107"+
		"\7O\2\2\u0107\u0108\7G\2\2\u0108\u0109\7a\2\2\u0109\u010a\7U\2\2\u010a"+
		"\u010b\7N\2\2\u010b\u010c\7K\2\2\u010c\u010d\7E\2\2\u010d\u010f\7G\2\2"+
		"\u010e\u00cd\3\2\2\2\u010e\u00d4\3\2\2\2\u010e\u00db\3\2\2\2\u010e\u00e7"+
		"\3\2\2\2\u010e\u00f7\3\2\2\2\u010e\u0104\3\2\2\2\u010f\34\3\2\2\2\u0110"+
		"\u0111\7R\2\2\u0111\u0112\7j\2\2\u0112\u0113\7t\2\2\u0113\u0114\7c\2\2"+
		"\u0114\u0115\7u\2\2\u0115\u0116\7g\2\2\u0116\u0117\7U\2\2\u0117\u0118"+
		"\7r\2\2\u0118\u0119\7g\2\2\u0119\u011a\7e\2\2\u011a\u011b\7k\2\2\u011b"+
		"\u011c\7h\2\2\u011c\u011d\7k\2\2\u011d\u011e\7e\2\2\u011e\u011f\7c\2\2"+
		"\u011f\u0120\7v\2\2\u0120\u0121\7k\2\2\u0121\u0122\7q\2\2\u0122\u0123"+
		"\7p\2\2\u0123\36\3\2\2\2\u0124\u0125\7U\2\2\u0125\u0126\7w\2\2\u0126\u0127"+
		"\7d\2\2\u0127\u0128\7l\2\2\u0128\u0129\7g\2\2\u0129\u012a\7e\2\2\u012a"+
		"\u012b\7v\2\2\u012b \3\2\2\2\u012c\u012d\7R\2\2\u012d\u012e\7t\2\2\u012e"+
		"\u012f\7g\2\2\u012f\u0130\7f\2\2\u0130\u0131\7k\2\2\u0131\u0132\7e\2\2"+
		"\u0132\u0133\7c\2\2\u0133\u0134\7v\2\2\u0134\u0135\7g\2\2\u0135\"\3\2"+
		"\2\2\u0136\u0137\7H\2\2\u0137\u0138\7g\2\2\u0138\u0139\7c\2\2\u0139\u013a"+
		"\7v\2\2\u013a\u013b\7w\2\2\u013b\u013c\7t\2\2\u013c\u013d\7g\2\2\u013d"+
		"\u013e\7u\2\2\u013e$\3\2\2\2\u013f\u0140\7P\2\2\u0140\u0141\7Q\2\2\u0141"+
		"\u0142\7W\2\2\u0142\u0194\7P\2\2\u0143\u0144\7R\2\2\u0144\u0145\7T\2\2"+
		"\u0145\u0146\7Q\2\2\u0146\u0147\7P\2\2\u0147\u0148\7Q\2\2\u0148\u0149"+
		"\7W\2\2\u0149\u0194\7P\2\2\u014a\u014b\7C\2\2\u014b\u014c\7F\2\2\u014c"+
		"\u014d\7L\2\2\u014d\u014e\7G\2\2\u014e\u014f\7E\2\2\u014f\u0150\7V\2\2"+
		"\u0150\u0151\7K\2\2\u0151\u0152\7X\2\2\u0152\u0194\7G\2\2\u0153\u0154"+
		"\7F\2\2\u0154\u0155\7G\2\2\u0155\u0156\7V\2\2\u0156\u0157\7G\2\2\u0157"+
		"\u0158\7T\2\2\u0158\u0159\7O\2\2\u0159\u015a\7K\2\2\u015a\u015b\7P\2\2"+
		"\u015b\u015c\7G\2\2\u015c\u0194\7T\2\2\u015d\u015e\7X\2\2\u015e\u015f"+
		"\7G\2\2\u015f\u0160\7T\2\2\u0160\u0194\7D\2\2\u0161\u0162\7C\2\2\u0162"+
		"\u0163\7F\2\2\u0163\u0164\7X\2\2\u0164\u0165\7G\2\2\u0165\u0166\7T\2\2"+
		"\u0166\u0194\7D\2\2\u0167\u0168\7R\2\2\u0168\u0169\7T\2\2\u0169\u016a"+
		"\7G\2\2\u016a\u016b\7R\2\2\u016b\u016c\7Q\2\2\u016c\u016d\7U\2\2\u016d"+
		"\u016e\7K\2\2\u016e\u016f\7V\2\2\u016f\u0170\7K\2\2\u0170\u0171\7Q\2\2"+
		"\u0171\u0194\7P\2\2\u0172\u0173\7E\2\2\u0173\u0174\7Q\2\2\u0174\u0175"+
		"\7P\2\2\u0175\u0176\7L\2\2\u0176\u0177\7W\2\2\u0177\u0178\7P\2\2\u0178"+
		"\u0179\7E\2\2\u0179\u017a\7V\2\2\u017a\u017b\7K\2\2\u017b\u017c\7Q\2\2"+
		"\u017c\u0194\7P\2\2\u017d\u017e\7K\2\2\u017e\u017f\7P\2\2\u017f\u0180"+
		"\7V\2\2\u0180\u0181\7G\2\2\u0181\u0182\7T\2\2\u0182\u0183\7L\2\2\u0183"+
		"\u0184\7G\2\2\u0184\u0185\7E\2\2\u0185\u0186\7V\2\2\u0186\u0187\7K\2\2"+
		"\u0187\u0188\7Q\2\2\u0188\u0194\7P\2\2\u0189\u018a\7E\2\2\u018a\u018b"+
		"\7Q\2\2\u018b\u018c\7O\2\2\u018c\u018d\7R\2\2\u018d\u018e\7N\2\2\u018e"+
		"\u018f\7G\2\2\u018f\u0190\7O\2\2\u0190\u0191\7G\2\2\u0191\u0192\7P\2\2"+
		"\u0192\u0194\7V\2\2\u0193\u013f\3\2\2\2\u0193\u0143\3\2\2\2\u0193\u014a"+
		"\3\2\2\2\u0193\u0153\3\2\2\2\u0193\u015d\3\2\2\2\u0193\u0161\3\2\2\2\u0193"+
		"\u0167\3\2\2\2\u0193\u0172\3\2\2\2\u0193\u017d\3\2\2\2\u0193\u0189\3\2"+
		"\2\2\u0194&\3\2\2\2\u0195\u0199\t\2\2\2\u0196\u0198\t\3\2\2\u0197\u0196"+
		"\3\2\2\2\u0198\u019b\3\2\2\2\u0199\u0197\3\2\2\2\u0199\u019a\3\2\2\2\u019a"+
		"(\3\2\2\2\u019b\u0199\3\2\2\2\u019c\u019e\7\17\2\2\u019d\u019c\3\2\2\2"+
		"\u019d\u019e\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a0\7\f\2\2\u01a0*\3"+
		"\2\2\2\u01a1\u01a3\t\4\2\2\u01a2\u01a1\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4"+
		"\u01a2\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a7\b\26"+
		"\2\2\u01a7,\3\2\2\2\u01a8\u01a9\7B\2\2\u01a9\u01aa\7B\2\2\u01aa.\3\2\2"+
		"\2\t\2\u00cb\u010e\u0193\u0199\u019d\u01a4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}