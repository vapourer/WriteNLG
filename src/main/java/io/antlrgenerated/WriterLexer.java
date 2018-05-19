// Generated from Writer.g4 by ANTLR 4.7
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
public class WriterLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, DOCUMENT=11, SECTION=12, PARAGRAPH=13, SENTENCE=14, CLAUSE=15, 
		SUBCLAUSE=16, FEATURES=17, PART_OF_SPEECH=18, DECIMAL_PLACES=19, NUMERIC=20, 
		STRING=21, NEW_LINE=22, WHITE_SPACE=23, PLACE_HOLDER_PREFIX=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "DOCUMENT", "SECTION", "PARAGRAPH", "SENTENCE", "CLAUSE", "SUBCLAUSE", 
		"FEATURES", "PART_OF_SPEECH", "DECIMAL_PLACES", "NUMERIC", "STRING", "NEW_LINE", 
		"WHITE_SPACE", "PLACE_HOLDER_PREFIX"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'DocumentTitle'", "'='", "'SectionTitle'", "'tense'", "'present'", 
		"'past'", "'future'", "'complementiser'", "'conjunction'", "':'", "'Document'", 
		"'Section'", "'Paragraph'", "'Sentence'", "'Clause'", "'Subclause'", "'Features'", 
		null, "'DecimalPlaces'", null, null, null, null, "'@'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "DOCUMENT", 
		"SECTION", "PARAGRAPH", "SENTENCE", "CLAUSE", "SUBCLAUSE", "FEATURES", 
		"PART_OF_SPEECH", "DECIMAL_PLACES", "NUMERIC", "STRING", "NEW_LINE", "WHITE_SPACE", 
		"PLACE_HOLDER_PREFIX"
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


	public WriterLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Writer.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\32\u0127\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\5\23\u00fe\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\25\6\25\u010f\n\25\r\25\16\25\u0110\3\26\3"+
		"\26\7\26\u0115\n\26\f\26\16\26\u0118\13\26\3\27\5\27\u011b\n\27\3\27\3"+
		"\27\3\30\6\30\u0120\n\30\r\30\16\30\u0121\3\30\3\30\3\31\3\31\2\2\32\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\3\2\6\3\2\62;\5\2\62;C\\c|"+
		"\6\2\"\"\62;C\\c|\4\2\13\13\"\"\2\u0130\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\3\63\3\2\2\2\5"+
		"A\3\2\2\2\7C\3\2\2\2\tP\3\2\2\2\13V\3\2\2\2\r^\3\2\2\2\17c\3\2\2\2\21"+
		"j\3\2\2\2\23y\3\2\2\2\25\u0085\3\2\2\2\27\u0087\3\2\2\2\31\u0090\3\2\2"+
		"\2\33\u0098\3\2\2\2\35\u00a2\3\2\2\2\37\u00ab\3\2\2\2!\u00b2\3\2\2\2#"+
		"\u00bc\3\2\2\2%\u00fd\3\2\2\2\'\u00ff\3\2\2\2)\u010e\3\2\2\2+\u0112\3"+
		"\2\2\2-\u011a\3\2\2\2/\u011f\3\2\2\2\61\u0125\3\2\2\2\63\64\7F\2\2\64"+
		"\65\7q\2\2\65\66\7e\2\2\66\67\7w\2\2\678\7o\2\289\7g\2\29:\7p\2\2:;\7"+
		"v\2\2;<\7V\2\2<=\7k\2\2=>\7v\2\2>?\7n\2\2?@\7g\2\2@\4\3\2\2\2AB\7?\2\2"+
		"B\6\3\2\2\2CD\7U\2\2DE\7g\2\2EF\7e\2\2FG\7v\2\2GH\7k\2\2HI\7q\2\2IJ\7"+
		"p\2\2JK\7V\2\2KL\7k\2\2LM\7v\2\2MN\7n\2\2NO\7g\2\2O\b\3\2\2\2PQ\7v\2\2"+
		"QR\7g\2\2RS\7p\2\2ST\7u\2\2TU\7g\2\2U\n\3\2\2\2VW\7r\2\2WX\7t\2\2XY\7"+
		"g\2\2YZ\7u\2\2Z[\7g\2\2[\\\7p\2\2\\]\7v\2\2]\f\3\2\2\2^_\7r\2\2_`\7c\2"+
		"\2`a\7u\2\2ab\7v\2\2b\16\3\2\2\2cd\7h\2\2de\7w\2\2ef\7v\2\2fg\7w\2\2g"+
		"h\7t\2\2hi\7g\2\2i\20\3\2\2\2jk\7e\2\2kl\7q\2\2lm\7o\2\2mn\7r\2\2no\7"+
		"n\2\2op\7g\2\2pq\7o\2\2qr\7g\2\2rs\7p\2\2st\7v\2\2tu\7k\2\2uv\7u\2\2v"+
		"w\7g\2\2wx\7t\2\2x\22\3\2\2\2yz\7e\2\2z{\7q\2\2{|\7p\2\2|}\7l\2\2}~\7"+
		"w\2\2~\177\7p\2\2\177\u0080\7e\2\2\u0080\u0081\7v\2\2\u0081\u0082\7k\2"+
		"\2\u0082\u0083\7q\2\2\u0083\u0084\7p\2\2\u0084\24\3\2\2\2\u0085\u0086"+
		"\7<\2\2\u0086\26\3\2\2\2\u0087\u0088\7F\2\2\u0088\u0089\7q\2\2\u0089\u008a"+
		"\7e\2\2\u008a\u008b\7w\2\2\u008b\u008c\7o\2\2\u008c\u008d\7g\2\2\u008d"+
		"\u008e\7p\2\2\u008e\u008f\7v\2\2\u008f\30\3\2\2\2\u0090\u0091\7U\2\2\u0091"+
		"\u0092\7g\2\2\u0092\u0093\7e\2\2\u0093\u0094\7v\2\2\u0094\u0095\7k\2\2"+
		"\u0095\u0096\7q\2\2\u0096\u0097\7p\2\2\u0097\32\3\2\2\2\u0098\u0099\7"+
		"R\2\2\u0099\u009a\7c\2\2\u009a\u009b\7t\2\2\u009b\u009c\7c\2\2\u009c\u009d"+
		"\7i\2\2\u009d\u009e\7t\2\2\u009e\u009f\7c\2\2\u009f\u00a0\7r\2\2\u00a0"+
		"\u00a1\7j\2\2\u00a1\34\3\2\2\2\u00a2\u00a3\7U\2\2\u00a3\u00a4\7g\2\2\u00a4"+
		"\u00a5\7p\2\2\u00a5\u00a6\7v\2\2\u00a6\u00a7\7g\2\2\u00a7\u00a8\7p\2\2"+
		"\u00a8\u00a9\7e\2\2\u00a9\u00aa\7g\2\2\u00aa\36\3\2\2\2\u00ab\u00ac\7"+
		"E\2\2\u00ac\u00ad\7n\2\2\u00ad\u00ae\7c\2\2\u00ae\u00af\7w\2\2\u00af\u00b0"+
		"\7u\2\2\u00b0\u00b1\7g\2\2\u00b1 \3\2\2\2\u00b2\u00b3\7U\2\2\u00b3\u00b4"+
		"\7w\2\2\u00b4\u00b5\7d\2\2\u00b5\u00b6\7e\2\2\u00b6\u00b7\7n\2\2\u00b7"+
		"\u00b8\7c\2\2\u00b8\u00b9\7w\2\2\u00b9\u00ba\7u\2\2\u00ba\u00bb\7g\2\2"+
		"\u00bb\"\3\2\2\2\u00bc\u00bd\7H\2\2\u00bd\u00be\7g\2\2\u00be\u00bf\7c"+
		"\2\2\u00bf\u00c0\7v\2\2\u00c0\u00c1\7w\2\2\u00c1\u00c2\7t\2\2\u00c2\u00c3"+
		"\7g\2\2\u00c3\u00c4\7u\2\2\u00c4$\3\2\2\2\u00c5\u00c6\7U\2\2\u00c6\u00c7"+
		"\7w\2\2\u00c7\u00c8\7d\2\2\u00c8\u00c9\7l\2\2\u00c9\u00ca\7g\2\2\u00ca"+
		"\u00cb\7e\2\2\u00cb\u00fe\7v\2\2\u00cc\u00cd\7X\2\2\u00cd\u00ce\7g\2\2"+
		"\u00ce\u00cf\7t\2\2\u00cf\u00fe\7d\2\2\u00d0\u00d1\7Q\2\2\u00d1\u00d2"+
		"\7d\2\2\u00d2\u00d3\7l\2\2\u00d3\u00d4\7g\2\2\u00d4\u00d5\7e\2\2\u00d5"+
		"\u00fe\7v\2\2\u00d6\u00d7\7K\2\2\u00d7\u00d8\7p\2\2\u00d8\u00d9\7f\2\2"+
		"\u00d9\u00da\7k\2\2\u00da\u00db\7t\2\2\u00db\u00dc\7g\2\2\u00dc\u00dd"+
		"\7e\2\2\u00dd\u00de\7v\2\2\u00de\u00df\7Q\2\2\u00df\u00e0\7d\2\2\u00e0"+
		"\u00e1\7l\2\2\u00e1\u00e2\7g\2\2\u00e2\u00e3\7e\2\2\u00e3\u00fe\7v\2\2"+
		"\u00e4\u00e5\7E\2\2\u00e5\u00e6\7q\2\2\u00e6\u00e7\7o\2\2\u00e7\u00e8"+
		"\7r\2\2\u00e8\u00e9\7n\2\2\u00e9\u00ea\7g\2\2\u00ea\u00eb\7o\2\2\u00eb"+
		"\u00ec\7g\2\2\u00ec\u00ed\7p\2\2\u00ed\u00fe\7v\2\2\u00ee\u00ef\7O\2\2"+
		"\u00ef\u00f0\7q\2\2\u00f0\u00f1\7f\2\2\u00f1\u00f2\7k\2\2\u00f2\u00f3"+
		"\7h\2\2\u00f3\u00f4\7k\2\2\u00f4\u00f5\7g\2\2\u00f5\u00fe\7t\2\2\u00f6"+
		"\u00f7\7C\2\2\u00f7\u00f8\7t\2\2\u00f8\u00f9\7v\2\2\u00f9\u00fa\7k\2\2"+
		"\u00fa\u00fb\7e\2\2\u00fb\u00fc\7n\2\2\u00fc\u00fe\7g\2\2\u00fd\u00c5"+
		"\3\2\2\2\u00fd\u00cc\3\2\2\2\u00fd\u00d0\3\2\2\2\u00fd\u00d6\3\2\2\2\u00fd"+
		"\u00e4\3\2\2\2\u00fd\u00ee\3\2\2\2\u00fd\u00f6\3\2\2\2\u00fe&\3\2\2\2"+
		"\u00ff\u0100\7F\2\2\u0100\u0101\7g\2\2\u0101\u0102\7e\2\2\u0102\u0103"+
		"\7k\2\2\u0103\u0104\7o\2\2\u0104\u0105\7c\2\2\u0105\u0106\7n\2\2\u0106"+
		"\u0107\7R\2\2\u0107\u0108\7n\2\2\u0108\u0109\7c\2\2\u0109\u010a\7e\2\2"+
		"\u010a\u010b\7g\2\2\u010b\u010c\7u\2\2\u010c(\3\2\2\2\u010d\u010f\t\2"+
		"\2\2\u010e\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u010e\3\2\2\2\u0110"+
		"\u0111\3\2\2\2\u0111*\3\2\2\2\u0112\u0116\t\3\2\2\u0113\u0115\t\4\2\2"+
		"\u0114\u0113\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0117"+
		"\3\2\2\2\u0117,\3\2\2\2\u0118\u0116\3\2\2\2\u0119\u011b\7\17\2\2\u011a"+
		"\u0119\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011d\7\f"+
		"\2\2\u011d.\3\2\2\2\u011e\u0120\t\5\2\2\u011f\u011e\3\2\2\2\u0120\u0121"+
		"\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0123\3\2\2\2\u0123"+
		"\u0124\b\30\2\2\u0124\60\3\2\2\2\u0125\u0126\7B\2\2\u0126\62\3\2\2\2\b"+
		"\2\u00fd\u0110\u0116\u011a\u0121\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}