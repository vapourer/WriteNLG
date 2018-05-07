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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20\u0231\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7"+
		"}\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00c0\n\b"+
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
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0206\n\t\3\n\6\n\u0209\n\n\r"+
		"\n\16\n\u020a\3\n\3\n\6\n\u020f\n\n\r\n\16\n\u0210\3\n\3\n\6\n\u0215\n"+
		"\n\r\n\16\n\u0216\5\n\u0219\n\n\3\13\3\13\3\f\3\f\7\f\u021f\n\f\f\f\16"+
		"\f\u0222\13\f\3\r\3\r\3\16\5\16\u0227\n\16\3\16\3\16\3\17\6\17\u022c\n"+
		"\17\r\17\16\17\u022d\3\17\3\17\2\2\20\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\3\2\6\3\2\63\67\5\2\62;C\\c|\3\2"+
		"\62;\4\2\13\13\"\"\2\u024f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\3\37\3"+
		"\2\2\2\5!\3\2\2\2\7#\3\2\2\2\t%\3\2\2\2\13\63\3\2\2\2\r|\3\2\2\2\17\u00bf"+
		"\3\2\2\2\21\u0205\3\2\2\2\23\u0218\3\2\2\2\25\u021a\3\2\2\2\27\u021c\3"+
		"\2\2\2\31\u0223\3\2\2\2\33\u0226\3\2\2\2\35\u022b\3\2\2\2\37 \7?\2\2 "+
		"\4\3\2\2\2!\"\7*\2\2\"\6\3\2\2\2#$\7+\2\2$\b\3\2\2\2%&\7I\2\2&\'\7n\2"+
		"\2\'(\7q\2\2()\7d\2\2)*\7c\2\2*+\7n\2\2+,\7E\2\2,-\7q\2\2-.\7p\2\2./\7"+
		"e\2\2/\60\7g\2\2\60\61\7r\2\2\61\62\7v\2\2\62\n\3\2\2\2\63\64\7V\2\2\64"+
		"\65\7k\2\2\65\66\7o\2\2\66\67\7g\2\2\678\7U\2\289\7g\2\29:\7t\2\2:;\7"+
		"k\2\2;<\7g\2\2<=\7u\2\2=>\7E\2\2>?\7q\2\2?@\7p\2\2@A\7e\2\2AB\7g\2\2B"+
		"C\7r\2\2CD\7v\2\2D\f\3\2\2\2EF\7N\2\2FG\7K\2\2GH\7P\2\2HI\7G\2\2IJ\7U"+
		"\2\2JK\7a\2\2KL\7E\2\2LM\7T\2\2MN\7Q\2\2NO\7U\2\2O}\7U\2\2PQ\7N\2\2QR"+
		"\7K\2\2RS\7P\2\2ST\7G\2\2TU\7U\2\2UV\7a\2\2VW\7F\2\2WX\7Q\2\2XY\7a\2\2"+
		"YZ\7P\2\2Z[\7Q\2\2[\\\7V\2\2\\]\7a\2\2]^\7E\2\2^_\7T\2\2_`\7Q\2\2`a\7"+
		"U\2\2a}\7U\2\2bc\7N\2\2cd\7K\2\2de\7P\2\2ef\7G\2\2fg\7U\2\2gh\7a\2\2h"+
		"i\7E\2\2ij\7T\2\2jk\7Q\2\2kl\7U\2\2lm\7U\2\2mn\7a\2\2no\7O\2\2op\7W\2"+
		"\2pq\7N\2\2qr\7V\2\2rs\7K\2\2st\7R\2\2tu\7N\2\2uv\7G\2\2vw\7a\2\2wx\7"+
		"V\2\2xy\7K\2\2yz\7O\2\2z{\7G\2\2{}\7U\2\2|E\3\2\2\2|P\3\2\2\2|b\3\2\2"+
		"\2}\16\3\2\2\2~\177\7O\2\2\177\u0080\7C\2\2\u0080\u0081\7Z\2\2\u0081\u0082"+
		"\7K\2\2\u0082\u0083\7O\2\2\u0083\u0084\7W\2\2\u0084\u00c0\7O\2\2\u0085"+
		"\u0086\7O\2\2\u0086\u0087\7K\2\2\u0087\u0088\7P\2\2\u0088\u0089\7K\2\2"+
		"\u0089\u008a\7O\2\2\u008a\u008b\7W\2\2\u008b\u00c0\7O\2\2\u008c\u008d"+
		"\7T\2\2\u008d\u008e\7K\2\2\u008e\u008f\7U\2\2\u008f\u0090\7K\2\2\u0090"+
		"\u0091\7P\2\2\u0091\u0092\7I\2\2\u0092\u0093\7a\2\2\u0093\u0094\7V\2\2"+
		"\u0094\u0095\7T\2\2\u0095\u0096\7G\2\2\u0096\u0097\7P\2\2\u0097\u00c0"+
		"\7F\2\2\u0098\u0099\7F\2\2\u0099\u009a\7G\2\2\u009a\u009b\7U\2\2\u009b"+
		"\u009c\7E\2\2\u009c\u009d\7G\2\2\u009d\u009e\7P\2\2\u009e\u009f\7F\2\2"+
		"\u009f\u00a0\7K\2\2\u00a0\u00a1\7P\2\2\u00a1\u00a2\7I\2\2\u00a2\u00a3"+
		"\7a\2\2\u00a3\u00a4\7V\2\2\u00a4\u00a5\7T\2\2\u00a5\u00a6\7G\2\2\u00a6"+
		"\u00a7\7P\2\2\u00a7\u00c0\7F\2\2\u00a8\u00a9\7U\2\2\u00a9\u00aa\7G\2\2"+
		"\u00aa\u00ab\7T\2\2\u00ab\u00ac\7K\2\2\u00ac\u00ad\7G\2\2\u00ad\u00ae"+
		"\7U\2\2\u00ae\u00af\7a\2\2\u00af\u00b0\7N\2\2\u00b0\u00b1\7G\2\2\u00b1"+
		"\u00b2\7I\2\2\u00b2\u00b3\7G\2\2\u00b3\u00b4\7P\2\2\u00b4\u00c0\7F\2\2"+
		"\u00b5\u00b6\7V\2\2\u00b6\u00b7\7K\2\2\u00b7\u00b8\7O\2\2\u00b8\u00b9"+
		"\7G\2\2\u00b9\u00ba\7a\2\2\u00ba\u00bb\7U\2\2\u00bb\u00bc\7N\2\2\u00bc"+
		"\u00bd\7K\2\2\u00bd\u00be\7E\2\2\u00be\u00c0\7G\2\2\u00bf~\3\2\2\2\u00bf"+
		"\u0085\3\2\2\2\u00bf\u008c\3\2\2\2\u00bf\u0098\3\2\2\2\u00bf\u00a8\3\2"+
		"\2\2\u00bf\u00b5\3\2\2\2\u00c0\20\3\2\2\2\u00c1\u00c2\7N\2\2\u00c2\u00c3"+
		"\7k\2\2\u00c3\u00c4\7p\2\2\u00c4\u00c5\7g\2\2\u00c5\u00c6\7u\2\2\u00c6"+
		"\u00c7\7E\2\2\u00c7\u00c8\7t\2\2\u00c8\u00c9\7q\2\2\u00c9\u00ca\7u\2\2"+
		"\u00ca\u0206\7u\2\2\u00cb\u00cc\7N\2\2\u00cc\u00cd\7k\2\2\u00cd\u00ce"+
		"\7p\2\2\u00ce\u00cf\7g\2\2\u00cf\u00d0\7u\2\2\u00d0\u00d1\7E\2\2\u00d1"+
		"\u00d2\7t\2\2\u00d2\u00d3\7q\2\2\u00d3\u00d4\7u\2\2\u00d4\u00d5\7u\2\2"+
		"\u00d5\u00d6\7O\2\2\u00d6\u00d7\7w\2\2\u00d7\u00d8\7n\2\2\u00d8\u00d9"+
		"\7v\2\2\u00d9\u00da\7k\2\2\u00da\u00db\7r\2\2\u00db\u00dc\7n\2\2\u00dc"+
		"\u00dd\7g\2\2\u00dd\u00de\7V\2\2\u00de\u00df\7k\2\2\u00df\u00e0\7o\2\2"+
		"\u00e0\u00e1\7g\2\2\u00e1\u0206\7u\2\2\u00e2\u00e3\7N\2\2\u00e3\u00e4"+
		"\7k\2\2\u00e4\u00e5\7p\2\2\u00e5\u00e6\7g\2\2\u00e6\u00e7\7u\2\2\u00e7"+
		"\u00e8\7F\2\2\u00e8\u00e9\7q\2\2\u00e9\u00ea\7P\2\2\u00ea\u00eb\7q\2\2"+
		"\u00eb\u00ec\7v\2\2\u00ec\u00ed\7E\2\2\u00ed\u00ee\7t\2\2\u00ee\u00ef"+
		"\7q\2\2\u00ef\u00f0\7u\2\2\u00f0\u0206\7u\2\2\u00f1\u00f2\7N\2\2\u00f2"+
		"\u00f3\7k\2\2\u00f3\u00f4\7p\2\2\u00f4\u00f5\7g\2\2\u00f5\u00f6\7u\2\2"+
		"\u00f6\u00f7\7E\2\2\u00f7\u00f8\7t\2\2\u00f8\u00f9\7q\2\2\u00f9\u00fa"+
		"\7u\2\2\u00fa\u00fb\7u\2\2\u00fb\u00fc\7Q\2\2\u00fc\u00fd\7p\2\2\u00fd"+
		"\u00fe\7e\2\2\u00fe\u0206\7g\2\2\u00ff\u0100\7U\2\2\u0100\u0101\7g\2\2"+
		"\u0101\u0102\7t\2\2\u0102\u0103\7k\2\2\u0103\u0104\7g\2\2\u0104\u0105"+
		"\7u\2\2\u0105\u0106\7N\2\2\u0106\u0107\7g\2\2\u0107\u0108\7i\2\2\u0108"+
		"\u0109\7g\2\2\u0109\u010a\7p\2\2\u010a\u010b\7f\2\2\u010b\u010c\7T\2\2"+
		"\u010c\u010d\7g\2\2\u010d\u010e\7s\2\2\u010e\u010f\7w\2\2\u010f\u0110"+
		"\7k\2\2\u0110\u0111\7t\2\2\u0111\u0112\7g\2\2\u0112\u0206\7f\2\2\u0113"+
		"\u0114\7U\2\2\u0114\u0115\7k\2\2\u0115\u0116\7p\2\2\u0116\u0117\7i\2\2"+
		"\u0117\u0118\7n\2\2\u0118\u0119\7g\2\2\u0119\u011a\7Q\2\2\u011a\u011b"+
		"\7d\2\2\u011b\u011c\7x\2\2\u011c\u011d\7k\2\2\u011d\u011e\7q\2\2\u011e"+
		"\u011f\7w\2\2\u011f\u0120\7u\2\2\u0120\u0121\7O\2\2\u0121\u0122\7c\2\2"+
		"\u0122\u0123\7z\2\2\u0123\u0124\7k\2\2\u0124\u0125\7o\2\2\u0125\u0126"+
		"\7w\2\2\u0126\u0206\7o\2\2\u0127\u0128\7O\2\2\u0128\u0129\7w\2\2\u0129"+
		"\u012a\7n\2\2\u012a\u012b\7v\2\2\u012b\u012c\7k\2\2\u012c\u012d\7r\2\2"+
		"\u012d\u012e\7n\2\2\u012e\u012f\7g\2\2\u012f\u0130\7J\2\2\u0130\u0131"+
		"\7k\2\2\u0131\u0132\7i\2\2\u0132\u0133\7j\2\2\u0133\u0134\7V\2\2\u0134"+
		"\u0135\7w\2\2\u0135\u0136\7t\2\2\u0136\u0137\7p\2\2\u0137\u0138\7k\2\2"+
		"\u0138\u0139\7p\2\2\u0139\u013a\7i\2\2\u013a\u013b\7R\2\2\u013b\u013c"+
		"\7q\2\2\u013c\u013d\7k\2\2\u013d\u013e\7p\2\2\u013e\u013f\7v\2\2\u013f"+
		"\u0206\7u\2\2\u0140\u0141\7O\2\2\u0141\u0142\7c\2\2\u0142\u0143\7z\2\2"+
		"\u0143\u0144\7k\2\2\u0144\u0145\7o\2\2\u0145\u0146\7w\2\2\u0146\u0147"+
		"\7o\2\2\u0147\u0148\7C\2\2\u0148\u0149\7v\2\2\u0149\u014a\7U\2\2\u014a"+
		"\u014b\7v\2\2\u014b\u014c\7c\2\2\u014c\u014d\7t\2\2\u014d\u0206\7v\2\2"+
		"\u014e\u014f\7O\2\2\u014f\u0150\7c\2\2\u0150\u0151\7z\2\2\u0151\u0152"+
		"\7k\2\2\u0152\u0153\7o\2\2\u0153\u0154\7w\2\2\u0154\u0155\7o\2\2\u0155"+
		"\u0156\7C\2\2\u0156\u0157\7v\2\2\u0157\u0158\7G\2\2\u0158\u0159\7p\2\2"+
		"\u0159\u0206\7f\2\2\u015a\u015b\7U\2\2\u015b\u015c\7k\2\2\u015c\u015d"+
		"\7p\2\2\u015d\u015e\7i\2\2\u015e\u015f\7n\2\2\u015f\u0160\7g\2\2\u0160"+
		"\u0161\7Q\2\2\u0161\u0162\7d\2\2\u0162\u0163\7x\2\2\u0163\u0164\7k\2\2"+
		"\u0164\u0165\7q\2\2\u0165\u0166\7w\2\2\u0166\u0167\7u\2\2\u0167\u0168"+
		"\7O\2\2\u0168\u0169\7k\2\2\u0169\u016a\7p\2\2\u016a\u016b\7k\2\2\u016b"+
		"\u016c\7o\2\2\u016c\u016d\7w\2\2\u016d\u0206\7o\2\2\u016e\u016f\7O\2\2"+
		"\u016f\u0170\7w\2\2\u0170\u0171\7n\2\2\u0171\u0172\7v\2\2\u0172\u0173"+
		"\7k\2\2\u0173\u0174\7r\2\2\u0174\u0175\7n\2\2\u0175\u0176\7g\2\2\u0176"+
		"\u0177\7N\2\2\u0177\u0178\7q\2\2\u0178\u0179\7y\2\2\u0179\u017a\7V\2\2"+
		"\u017a\u017b\7w\2\2\u017b\u017c\7t\2\2\u017c\u017d\7p\2\2\u017d\u017e"+
		"\7k\2\2\u017e\u017f\7p\2\2\u017f\u0180\7i\2\2\u0180\u0181\7R\2\2\u0181"+
		"\u0182\7q\2\2\u0182\u0183\7k\2\2\u0183\u0184\7p\2\2\u0184\u0185\7v\2\2"+
		"\u0185\u0206\7u\2\2\u0186\u0187\7O\2\2\u0187\u0188\7k\2\2\u0188\u0189"+
		"\7p\2\2\u0189\u018a\7k\2\2\u018a\u018b\7o\2\2\u018b\u018c\7w\2\2\u018c"+
		"\u018d\7o\2\2\u018d\u018e\7C\2\2\u018e\u018f\7v\2\2\u018f\u0190\7U\2\2"+
		"\u0190\u0191\7v\2\2\u0191\u0192\7c\2\2\u0192\u0193\7t\2\2\u0193\u0206"+
		"\7v\2\2\u0194\u0195\7O\2\2\u0195\u0196\7k\2\2\u0196\u0197\7p\2\2\u0197"+
		"\u0198\7k\2\2\u0198\u0199\7o\2\2\u0199\u019a\7w\2\2\u019a\u019b\7o\2\2"+
		"\u019b\u019c\7C\2\2\u019c\u019d\7v\2\2\u019d\u019e\7G\2\2\u019e\u019f"+
		"\7p\2\2\u019f\u0206\7f\2\2\u01a0\u01a1\7C\2\2\u01a1\u01a2\7n\2\2\u01a2"+
		"\u01a3\7n\2\2\u01a3\u01a4\7U\2\2\u01a4\u01a5\7g\2\2\u01a5\u01a6\7i\2\2"+
		"\u01a6\u01a7\7o\2\2\u01a7\u01a8\7g\2\2\u01a8\u01a9\7p\2\2\u01a9\u01aa"+
		"\7v\2\2\u01aa\u01ab\7u\2\2\u01ab\u01ac\7C\2\2\u01ac\u01ad\7u\2\2\u01ad"+
		"\u01ae\7e\2\2\u01ae\u01af\7g\2\2\u01af\u01b0\7p\2\2\u01b0\u01b1\7f\2\2"+
		"\u01b1\u01b2\7k\2\2\u01b2\u01b3\7p\2\2\u01b3\u0206\7i\2\2\u01b4\u01b5"+
		"\7O\2\2\u01b5\u01b6\7q\2\2\u01b6\u01b7\7u\2\2\u01b7\u01b8\7v\2\2\u01b8"+
		"\u01b9\7U\2\2\u01b9\u01ba\7g\2\2\u01ba\u01bb\7i\2\2\u01bb\u01bc\7o\2\2"+
		"\u01bc\u01bd\7g\2\2\u01bd\u01be\7p\2\2\u01be\u01bf\7v\2\2\u01bf\u01c0"+
		"\7u\2\2\u01c0\u01c1\7C\2\2\u01c1\u01c2\7u\2\2\u01c2\u01c3\7e\2\2\u01c3"+
		"\u01c4\7g\2\2\u01c4\u01c5\7p\2\2\u01c5\u01c6\7f\2\2\u01c6\u01c7\7k\2\2"+
		"\u01c7\u01c8\7p\2\2\u01c8\u0206\7i\2\2\u01c9\u01ca\7C\2\2\u01ca\u01cb"+
		"\7n\2\2\u01cb\u01cc\7n\2\2\u01cc\u01cd\7U\2\2\u01cd\u01ce\7g\2\2\u01ce"+
		"\u01cf\7i\2\2\u01cf\u01d0\7o\2\2\u01d0\u01d1\7g\2\2\u01d1\u01d2\7p\2\2"+
		"\u01d2\u01d3\7v\2\2\u01d3\u01d4\7u\2\2\u01d4\u01d5\7F\2\2\u01d5\u01d6"+
		"\7g\2\2\u01d6\u01d7\7u\2\2\u01d7\u01d8\7e\2\2\u01d8\u01d9\7g\2\2\u01d9"+
		"\u01da\7p\2\2\u01da\u01db\7f\2\2\u01db\u01dc\7k\2\2\u01dc\u01dd\7p\2\2"+
		"\u01dd\u0206\7i\2\2\u01de\u01df\7O\2\2\u01df\u01e0\7q\2\2\u01e0\u01e1"+
		"\7u\2\2\u01e1\u01e2\7v\2\2\u01e2\u01e3\7U\2\2\u01e3\u01e4\7g\2\2\u01e4"+
		"\u01e5\7i\2\2\u01e5\u01e6\7o\2\2\u01e6\u01e7\7g\2\2\u01e7\u01e8\7p\2\2"+
		"\u01e8\u01e9\7v\2\2\u01e9\u01ea\7u\2\2\u01ea\u01eb\7F\2\2\u01eb\u01ec"+
		"\7g\2\2\u01ec\u01ed\7u\2\2\u01ed\u01ee\7e\2\2\u01ee\u01ef\7g\2\2\u01ef"+
		"\u01f0\7p\2\2\u01f0\u01f1\7f\2\2\u01f1\u01f2\7k\2\2\u01f2\u01f3\7p\2\2"+
		"\u01f3\u0206\7i\2\2\u01f4\u01f5\7V\2\2\u01f5\u01f6\7k\2\2\u01f6\u01f7"+
		"\7o\2\2\u01f7\u01f8\7g\2\2\u01f8\u01f9\7U\2\2\u01f9\u01fa\7n\2\2\u01fa"+
		"\u01fb\7k\2\2\u01fb\u01fc\7e\2\2\u01fc\u01fd\7g\2\2\u01fd\u01fe\7T\2\2"+
		"\u01fe\u01ff\7g\2\2\u01ff\u0200\7s\2\2\u0200\u0201\7w\2\2\u0201\u0202"+
		"\7k\2\2\u0202\u0203\7t\2\2\u0203\u0204\7g\2\2\u0204\u0206\7f\2\2\u0205"+
		"\u00c1\3\2\2\2\u0205\u00cb\3\2\2\2\u0205\u00e2\3\2\2\2\u0205\u00f1\3\2"+
		"\2\2\u0205\u00ff\3\2\2\2\u0205\u0113\3\2\2\2\u0205\u0127\3\2\2\2\u0205"+
		"\u0140\3\2\2\2\u0205\u014e\3\2\2\2\u0205\u015a\3\2\2\2\u0205\u016e\3\2"+
		"\2\2\u0205\u0186\3\2\2\2\u0205\u0194\3\2\2\2\u0205\u01a0\3\2\2\2\u0205"+
		"\u01b4\3\2\2\2\u0205\u01c9\3\2\2\2\u0205\u01de\3\2\2\2\u0205\u01f4\3\2"+
		"\2\2\u0206\22\3\2\2\2\u0207\u0209\5\31\r\2\u0208\u0207\3\2\2\2\u0209\u020a"+
		"\3\2\2\2\u020a\u0208\3\2\2\2\u020a\u020b\3\2\2\2\u020b\u020c\3\2\2\2\u020c"+
		"\u020e\7\60\2\2\u020d\u020f\5\31\r\2\u020e\u020d\3\2\2\2\u020f\u0210\3"+
		"\2\2\2\u0210\u020e\3\2\2\2\u0210\u0211\3\2\2\2\u0211\u0219\3\2\2\2\u0212"+
		"\u0214\7\60\2\2\u0213\u0215\5\31\r\2\u0214\u0213\3\2\2\2\u0215\u0216\3"+
		"\2\2\2\u0216\u0214\3\2\2\2\u0216\u0217\3\2\2\2\u0217\u0219\3\2\2\2\u0218"+
		"\u0208\3\2\2\2\u0218\u0212\3\2\2\2\u0219\24\3\2\2\2\u021a\u021b\t\2\2"+
		"\2\u021b\26\3\2\2\2\u021c\u0220\t\3\2\2\u021d\u021f\t\3\2\2\u021e\u021d"+
		"\3\2\2\2\u021f\u0222\3\2\2\2\u0220\u021e\3\2\2\2\u0220\u0221\3\2\2\2\u0221"+
		"\30\3\2\2\2\u0222\u0220\3\2\2\2\u0223\u0224\t\4\2\2\u0224\32\3\2\2\2\u0225"+
		"\u0227\7\17\2\2\u0226\u0225\3\2\2\2\u0226\u0227\3\2\2\2\u0227\u0228\3"+
		"\2\2\2\u0228\u0229\7\f\2\2\u0229\34\3\2\2\2\u022a\u022c\t\5\2\2\u022b"+
		"\u022a\3\2\2\2\u022c\u022d\3\2\2\2\u022d\u022b\3\2\2\2\u022d\u022e\3\2"+
		"\2\2\u022e\u022f\3\2\2\2\u022f\u0230\b\17\2\2\u0230\36\3\2\2\2\r\2|\u00bf"+
		"\u0205\u020a\u0210\u0216\u0218\u0220\u0226\u022d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}