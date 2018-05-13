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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20\u024c\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0087\n\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00ca\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3"+
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
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\5\t\u0221\n\t\3\n\6\n\u0224\n\n\r\n\16\n\u0225\3\n\3\n\6\n\u022a"+
		"\n\n\r\n\16\n\u022b\3\n\3\n\6\n\u0230\n\n\r\n\16\n\u0231\5\n\u0234\n\n"+
		"\3\13\3\13\3\f\3\f\7\f\u023a\n\f\f\f\16\f\u023d\13\f\3\r\3\r\3\16\5\16"+
		"\u0242\n\16\3\16\3\16\3\17\6\17\u0247\n\17\r\17\16\17\u0248\3\17\3\17"+
		"\2\2\20\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\3\2\6\3\2\63\67\5\2\62;C\\c|\3\2\62;\4\2\13\13\"\"\2\u026c\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\3\37\3\2\2\2\5!\3\2\2\2\7#\3\2\2\2"+
		"\t%\3\2\2\2\13\63\3\2\2\2\r\u0086\3\2\2\2\17\u00c9\3\2\2\2\21\u0220\3"+
		"\2\2\2\23\u0233\3\2\2\2\25\u0235\3\2\2\2\27\u0237\3\2\2\2\31\u023e\3\2"+
		"\2\2\33\u0241\3\2\2\2\35\u0246\3\2\2\2\37 \7?\2\2 \4\3\2\2\2!\"\7*\2\2"+
		"\"\6\3\2\2\2#$\7+\2\2$\b\3\2\2\2%&\7I\2\2&\'\7n\2\2\'(\7q\2\2()\7d\2\2"+
		")*\7c\2\2*+\7n\2\2+,\7E\2\2,-\7q\2\2-.\7p\2\2./\7e\2\2/\60\7g\2\2\60\61"+
		"\7r\2\2\61\62\7v\2\2\62\n\3\2\2\2\63\64\7V\2\2\64\65\7k\2\2\65\66\7o\2"+
		"\2\66\67\7g\2\2\678\7U\2\289\7g\2\29:\7t\2\2:;\7k\2\2;<\7g\2\2<=\7u\2"+
		"\2=>\7E\2\2>?\7q\2\2?@\7p\2\2@A\7e\2\2AB\7g\2\2BC\7r\2\2CD\7v\2\2D\f\3"+
		"\2\2\2EF\7N\2\2FG\7K\2\2GH\7P\2\2HI\7G\2\2IJ\7U\2\2JK\7a\2\2KL\7E\2\2"+
		"LM\7T\2\2MN\7Q\2\2NO\7U\2\2O\u0087\7U\2\2PQ\7N\2\2QR\7K\2\2RS\7P\2\2S"+
		"T\7G\2\2TU\7U\2\2UV\7a\2\2VW\7F\2\2WX\7Q\2\2XY\7a\2\2YZ\7P\2\2Z[\7Q\2"+
		"\2[\\\7V\2\2\\]\7a\2\2]^\7E\2\2^_\7T\2\2_`\7Q\2\2`a\7U\2\2a\u0087\7U\2"+
		"\2bc\7N\2\2cd\7K\2\2de\7P\2\2ef\7G\2\2fg\7U\2\2gh\7a\2\2hi\7E\2\2ij\7"+
		"T\2\2jk\7Q\2\2kl\7U\2\2lm\7U\2\2mn\7a\2\2no\7O\2\2op\7W\2\2pq\7N\2\2q"+
		"r\7V\2\2rs\7K\2\2st\7R\2\2tu\7N\2\2uv\7G\2\2vw\7a\2\2wx\7V\2\2xy\7K\2"+
		"\2yz\7O\2\2z{\7G\2\2{\u0087\7U\2\2|}\7N\2\2}~\7K\2\2~\177\7P\2\2\177\u0080"+
		"\7G\2\2\u0080\u0081\7a\2\2\u0081\u0082\7E\2\2\u0082\u0083\7Q\2\2\u0083"+
		"\u0084\7W\2\2\u0084\u0085\7P\2\2\u0085\u0087\7V\2\2\u0086E\3\2\2\2\u0086"+
		"P\3\2\2\2\u0086b\3\2\2\2\u0086|\3\2\2\2\u0087\16\3\2\2\2\u0088\u0089\7"+
		"O\2\2\u0089\u008a\7C\2\2\u008a\u008b\7Z\2\2\u008b\u008c\7K\2\2\u008c\u008d"+
		"\7O\2\2\u008d\u008e\7W\2\2\u008e\u00ca\7O\2\2\u008f\u0090\7O\2\2\u0090"+
		"\u0091\7K\2\2\u0091\u0092\7P\2\2\u0092\u0093\7K\2\2\u0093\u0094\7O\2\2"+
		"\u0094\u0095\7W\2\2\u0095\u00ca\7O\2\2\u0096\u0097\7T\2\2\u0097\u0098"+
		"\7K\2\2\u0098\u0099\7U\2\2\u0099\u009a\7K\2\2\u009a\u009b\7P\2\2\u009b"+
		"\u009c\7I\2\2\u009c\u009d\7a\2\2\u009d\u009e\7V\2\2\u009e\u009f\7T\2\2"+
		"\u009f\u00a0\7G\2\2\u00a0\u00a1\7P\2\2\u00a1\u00ca\7F\2\2\u00a2\u00a3"+
		"\7F\2\2\u00a3\u00a4\7G\2\2\u00a4\u00a5\7U\2\2\u00a5\u00a6\7E\2\2\u00a6"+
		"\u00a7\7G\2\2\u00a7\u00a8\7P\2\2\u00a8\u00a9\7F\2\2\u00a9\u00aa\7K\2\2"+
		"\u00aa\u00ab\7P\2\2\u00ab\u00ac\7I\2\2\u00ac\u00ad\7a\2\2\u00ad\u00ae"+
		"\7V\2\2\u00ae\u00af\7T\2\2\u00af\u00b0\7G\2\2\u00b0\u00b1\7P\2\2\u00b1"+
		"\u00ca\7F\2\2\u00b2\u00b3\7U\2\2\u00b3\u00b4\7G\2\2\u00b4\u00b5\7T\2\2"+
		"\u00b5\u00b6\7K\2\2\u00b6\u00b7\7G\2\2\u00b7\u00b8\7U\2\2\u00b8\u00b9"+
		"\7a\2\2\u00b9\u00ba\7N\2\2\u00ba\u00bb\7G\2\2\u00bb\u00bc\7I\2\2\u00bc"+
		"\u00bd\7G\2\2\u00bd\u00be\7P\2\2\u00be\u00ca\7F\2\2\u00bf\u00c0\7V\2\2"+
		"\u00c0\u00c1\7K\2\2\u00c1\u00c2\7O\2\2\u00c2\u00c3\7G\2\2\u00c3\u00c4"+
		"\7a\2\2\u00c4\u00c5\7U\2\2\u00c5\u00c6\7N\2\2\u00c6\u00c7\7K\2\2\u00c7"+
		"\u00c8\7E\2\2\u00c8\u00ca\7G\2\2\u00c9\u0088\3\2\2\2\u00c9\u008f\3\2\2"+
		"\2\u00c9\u0096\3\2\2\2\u00c9\u00a2\3\2\2\2\u00c9\u00b2\3\2\2\2\u00c9\u00bf"+
		"\3\2\2\2\u00ca\20\3\2\2\2\u00cb\u00cc\7N\2\2\u00cc\u00cd\7k\2\2\u00cd"+
		"\u00ce\7p\2\2\u00ce\u00cf\7g\2\2\u00cf\u00d0\7u\2\2\u00d0\u00d1\7E\2\2"+
		"\u00d1\u00d2\7t\2\2\u00d2\u00d3\7q\2\2\u00d3\u00d4\7u\2\2\u00d4\u0221"+
		"\7u\2\2\u00d5\u00d6\7N\2\2\u00d6\u00d7\7k\2\2\u00d7\u00d8\7p\2\2\u00d8"+
		"\u00d9\7g\2\2\u00d9\u00da\7u\2\2\u00da\u00db\7E\2\2\u00db\u00dc\7t\2\2"+
		"\u00dc\u00dd\7q\2\2\u00dd\u00de\7u\2\2\u00de\u00df\7u\2\2\u00df\u00e0"+
		"\7O\2\2\u00e0\u00e1\7w\2\2\u00e1\u00e2\7n\2\2\u00e2\u00e3\7v\2\2\u00e3"+
		"\u00e4\7k\2\2\u00e4\u00e5\7r\2\2\u00e5\u00e6\7n\2\2\u00e6\u00e7\7g\2\2"+
		"\u00e7\u00e8\7V\2\2\u00e8\u00e9\7k\2\2\u00e9\u00ea\7o\2\2\u00ea\u00eb"+
		"\7g\2\2\u00eb\u0221\7u\2\2\u00ec\u00ed\7N\2\2\u00ed\u00ee\7k\2\2\u00ee"+
		"\u00ef\7p\2\2\u00ef\u00f0\7g\2\2\u00f0\u00f1\7u\2\2\u00f1\u00f2\7F\2\2"+
		"\u00f2\u00f3\7q\2\2\u00f3\u00f4\7P\2\2\u00f4\u00f5\7q\2\2\u00f5\u00f6"+
		"\7v\2\2\u00f6\u00f7\7E\2\2\u00f7\u00f8\7t\2\2\u00f8\u00f9\7q\2\2\u00f9"+
		"\u00fa\7u\2\2\u00fa\u0221\7u\2\2\u00fb\u00fc\7N\2\2\u00fc\u00fd\7k\2\2"+
		"\u00fd\u00fe\7p\2\2\u00fe\u00ff\7g\2\2\u00ff\u0100\7u\2\2\u0100\u0101"+
		"\7E\2\2\u0101\u0102\7t\2\2\u0102\u0103\7q\2\2\u0103\u0104\7u\2\2\u0104"+
		"\u0105\7u\2\2\u0105\u0106\7Q\2\2\u0106\u0107\7p\2\2\u0107\u0108\7e\2\2"+
		"\u0108\u0221\7g\2\2\u0109\u010a\7U\2\2\u010a\u010b\7g\2\2\u010b\u010c"+
		"\7t\2\2\u010c\u010d\7k\2\2\u010d\u010e\7g\2\2\u010e\u010f\7u\2\2\u010f"+
		"\u0110\7N\2\2\u0110\u0111\7g\2\2\u0111\u0112\7i\2\2\u0112\u0113\7g\2\2"+
		"\u0113\u0114\7p\2\2\u0114\u0115\7f\2\2\u0115\u0116\7T\2\2\u0116\u0117"+
		"\7g\2\2\u0117\u0118\7s\2\2\u0118\u0119\7w\2\2\u0119\u011a\7k\2\2\u011a"+
		"\u011b\7t\2\2\u011b\u011c\7g\2\2\u011c\u0221\7f\2\2\u011d\u011e\7N\2\2"+
		"\u011e\u011f\7k\2\2\u011f\u0120\7p\2\2\u0120\u0121\7g\2\2\u0121\u0122"+
		"\7E\2\2\u0122\u0123\7q\2\2\u0123\u0124\7w\2\2\u0124\u0125\7p\2\2\u0125"+
		"\u0126\7v\2\2\u0126\u0127\7T\2\2\u0127\u0128\7g\2\2\u0128\u0129\7s\2\2"+
		"\u0129\u012a\7w\2\2\u012a\u012b\7k\2\2\u012b\u012c\7t\2\2\u012c\u012d"+
		"\7g\2\2\u012d\u0221\7f\2\2\u012e\u012f\7U\2\2\u012f\u0130\7k\2\2\u0130"+
		"\u0131\7p\2\2\u0131\u0132\7i\2\2\u0132\u0133\7n\2\2\u0133\u0134\7g\2\2"+
		"\u0134\u0135\7Q\2\2\u0135\u0136\7d\2\2\u0136\u0137\7x\2\2\u0137\u0138"+
		"\7k\2\2\u0138\u0139\7q\2\2\u0139\u013a\7w\2\2\u013a\u013b\7u\2\2\u013b"+
		"\u013c\7O\2\2\u013c\u013d\7c\2\2\u013d\u013e\7z\2\2\u013e\u013f\7k\2\2"+
		"\u013f\u0140\7o\2\2\u0140\u0141\7w\2\2\u0141\u0221\7o\2\2\u0142\u0143"+
		"\7O\2\2\u0143\u0144\7w\2\2\u0144\u0145\7n\2\2\u0145\u0146\7v\2\2\u0146"+
		"\u0147\7k\2\2\u0147\u0148\7r\2\2\u0148\u0149\7n\2\2\u0149\u014a\7g\2\2"+
		"\u014a\u014b\7J\2\2\u014b\u014c\7k\2\2\u014c\u014d\7i\2\2\u014d\u014e"+
		"\7j\2\2\u014e\u014f\7V\2\2\u014f\u0150\7w\2\2\u0150\u0151\7t\2\2\u0151"+
		"\u0152\7p\2\2\u0152\u0153\7k\2\2\u0153\u0154\7p\2\2\u0154\u0155\7i\2\2"+
		"\u0155\u0156\7R\2\2\u0156\u0157\7q\2\2\u0157\u0158\7k\2\2\u0158\u0159"+
		"\7p\2\2\u0159\u015a\7v\2\2\u015a\u0221\7u\2\2\u015b\u015c\7O\2\2\u015c"+
		"\u015d\7c\2\2\u015d\u015e\7z\2\2\u015e\u015f\7k\2\2\u015f\u0160\7o\2\2"+
		"\u0160\u0161\7w\2\2\u0161\u0162\7o\2\2\u0162\u0163\7C\2\2\u0163\u0164"+
		"\7v\2\2\u0164\u0165\7U\2\2\u0165\u0166\7v\2\2\u0166\u0167\7c\2\2\u0167"+
		"\u0168\7t\2\2\u0168\u0221\7v\2\2\u0169\u016a\7O\2\2\u016a\u016b\7c\2\2"+
		"\u016b\u016c\7z\2\2\u016c\u016d\7k\2\2\u016d\u016e\7o\2\2\u016e\u016f"+
		"\7w\2\2\u016f\u0170\7o\2\2\u0170\u0171\7C\2\2\u0171\u0172\7v\2\2\u0172"+
		"\u0173\7G\2\2\u0173\u0174\7p\2\2\u0174\u0221\7f\2\2\u0175\u0176\7U\2\2"+
		"\u0176\u0177\7k\2\2\u0177\u0178\7p\2\2\u0178\u0179\7i\2\2\u0179\u017a"+
		"\7n\2\2\u017a\u017b\7g\2\2\u017b\u017c\7Q\2\2\u017c\u017d\7d\2\2\u017d"+
		"\u017e\7x\2\2\u017e\u017f\7k\2\2\u017f\u0180\7q\2\2\u0180\u0181\7w\2\2"+
		"\u0181\u0182\7u\2\2\u0182\u0183\7O\2\2\u0183\u0184\7k\2\2\u0184\u0185"+
		"\7p\2\2\u0185\u0186\7k\2\2\u0186\u0187\7o\2\2\u0187\u0188\7w\2\2\u0188"+
		"\u0221\7o\2\2\u0189\u018a\7O\2\2\u018a\u018b\7w\2\2\u018b\u018c\7n\2\2"+
		"\u018c\u018d\7v\2\2\u018d\u018e\7k\2\2\u018e\u018f\7r\2\2\u018f\u0190"+
		"\7n\2\2\u0190\u0191\7g\2\2\u0191\u0192\7N\2\2\u0192\u0193\7q\2\2\u0193"+
		"\u0194\7y\2\2\u0194\u0195\7V\2\2\u0195\u0196\7w\2\2\u0196\u0197\7t\2\2"+
		"\u0197\u0198\7p\2\2\u0198\u0199\7k\2\2\u0199\u019a\7p\2\2\u019a\u019b"+
		"\7i\2\2\u019b\u019c\7R\2\2\u019c\u019d\7q\2\2\u019d\u019e\7k\2\2\u019e"+
		"\u019f\7p\2\2\u019f\u01a0\7v\2\2\u01a0\u0221\7u\2\2\u01a1\u01a2\7O\2\2"+
		"\u01a2\u01a3\7k\2\2\u01a3\u01a4\7p\2\2\u01a4\u01a5\7k\2\2\u01a5\u01a6"+
		"\7o\2\2\u01a6\u01a7\7w\2\2\u01a7\u01a8\7o\2\2\u01a8\u01a9\7C\2\2\u01a9"+
		"\u01aa\7v\2\2\u01aa\u01ab\7U\2\2\u01ab\u01ac\7v\2\2\u01ac\u01ad\7c\2\2"+
		"\u01ad\u01ae\7t\2\2\u01ae\u0221\7v\2\2\u01af\u01b0\7O\2\2\u01b0\u01b1"+
		"\7k\2\2\u01b1\u01b2\7p\2\2\u01b2\u01b3\7k\2\2\u01b3\u01b4\7o\2\2\u01b4"+
		"\u01b5\7w\2\2\u01b5\u01b6\7o\2\2\u01b6\u01b7\7C\2\2\u01b7\u01b8\7v\2\2"+
		"\u01b8\u01b9\7G\2\2\u01b9\u01ba\7p\2\2\u01ba\u0221\7f\2\2\u01bb\u01bc"+
		"\7C\2\2\u01bc\u01bd\7n\2\2\u01bd\u01be\7n\2\2\u01be\u01bf\7U\2\2\u01bf"+
		"\u01c0\7g\2\2\u01c0\u01c1\7i\2\2\u01c1\u01c2\7o\2\2\u01c2\u01c3\7g\2\2"+
		"\u01c3\u01c4\7p\2\2\u01c4\u01c5\7v\2\2\u01c5\u01c6\7u\2\2\u01c6\u01c7"+
		"\7C\2\2\u01c7\u01c8\7u\2\2\u01c8\u01c9\7e\2\2\u01c9\u01ca\7g\2\2\u01ca"+
		"\u01cb\7p\2\2\u01cb\u01cc\7f\2\2\u01cc\u01cd\7k\2\2\u01cd\u01ce\7p\2\2"+
		"\u01ce\u0221\7i\2\2\u01cf\u01d0\7O\2\2\u01d0\u01d1\7q\2\2\u01d1\u01d2"+
		"\7u\2\2\u01d2\u01d3\7v\2\2\u01d3\u01d4\7U\2\2\u01d4\u01d5\7g\2\2\u01d5"+
		"\u01d6\7i\2\2\u01d6\u01d7\7o\2\2\u01d7\u01d8\7g\2\2\u01d8\u01d9\7p\2\2"+
		"\u01d9\u01da\7v\2\2\u01da\u01db\7u\2\2\u01db\u01dc\7C\2\2\u01dc\u01dd"+
		"\7u\2\2\u01dd\u01de\7e\2\2\u01de\u01df\7g\2\2\u01df\u01e0\7p\2\2\u01e0"+
		"\u01e1\7f\2\2\u01e1\u01e2\7k\2\2\u01e2\u01e3\7p\2\2\u01e3\u0221\7i\2\2"+
		"\u01e4\u01e5\7C\2\2\u01e5\u01e6\7n\2\2\u01e6\u01e7\7n\2\2\u01e7\u01e8"+
		"\7U\2\2\u01e8\u01e9\7g\2\2\u01e9\u01ea\7i\2\2\u01ea\u01eb\7o\2\2\u01eb"+
		"\u01ec\7g\2\2\u01ec\u01ed\7p\2\2\u01ed\u01ee\7v\2\2\u01ee\u01ef\7u\2\2"+
		"\u01ef\u01f0\7F\2\2\u01f0\u01f1\7g\2\2\u01f1\u01f2\7u\2\2\u01f2\u01f3"+
		"\7e\2\2\u01f3\u01f4\7g\2\2\u01f4\u01f5\7p\2\2\u01f5\u01f6\7f\2\2\u01f6"+
		"\u01f7\7k\2\2\u01f7\u01f8\7p\2\2\u01f8\u0221\7i\2\2\u01f9\u01fa\7O\2\2"+
		"\u01fa\u01fb\7q\2\2\u01fb\u01fc\7u\2\2\u01fc\u01fd\7v\2\2\u01fd\u01fe"+
		"\7U\2\2\u01fe\u01ff\7g\2\2\u01ff\u0200\7i\2\2\u0200\u0201\7o\2\2\u0201"+
		"\u0202\7g\2\2\u0202\u0203\7p\2\2\u0203\u0204\7v\2\2\u0204\u0205\7u\2\2"+
		"\u0205\u0206\7F\2\2\u0206\u0207\7g\2\2\u0207\u0208\7u\2\2\u0208\u0209"+
		"\7e\2\2\u0209\u020a\7g\2\2\u020a\u020b\7p\2\2\u020b\u020c\7f\2\2\u020c"+
		"\u020d\7k\2\2\u020d\u020e\7p\2\2\u020e\u0221\7i\2\2\u020f\u0210\7V\2\2"+
		"\u0210\u0211\7k\2\2\u0211\u0212\7o\2\2\u0212\u0213\7g\2\2\u0213\u0214"+
		"\7U\2\2\u0214\u0215\7n\2\2\u0215\u0216\7k\2\2\u0216\u0217\7e\2\2\u0217"+
		"\u0218\7g\2\2\u0218\u0219\7T\2\2\u0219\u021a\7g\2\2\u021a\u021b\7s\2\2"+
		"\u021b\u021c\7w\2\2\u021c\u021d\7k\2\2\u021d\u021e\7t\2\2\u021e\u021f"+
		"\7g\2\2\u021f\u0221\7f\2\2\u0220\u00cb\3\2\2\2\u0220\u00d5\3\2\2\2\u0220"+
		"\u00ec\3\2\2\2\u0220\u00fb\3\2\2\2\u0220\u0109\3\2\2\2\u0220\u011d\3\2"+
		"\2\2\u0220\u012e\3\2\2\2\u0220\u0142\3\2\2\2\u0220\u015b\3\2\2\2\u0220"+
		"\u0169\3\2\2\2\u0220\u0175\3\2\2\2\u0220\u0189\3\2\2\2\u0220\u01a1\3\2"+
		"\2\2\u0220\u01af\3\2\2\2\u0220\u01bb\3\2\2\2\u0220\u01cf\3\2\2\2\u0220"+
		"\u01e4\3\2\2\2\u0220\u01f9\3\2\2\2\u0220\u020f\3\2\2\2\u0221\22\3\2\2"+
		"\2\u0222\u0224\5\31\r\2\u0223\u0222\3\2\2\2\u0224\u0225\3\2\2\2\u0225"+
		"\u0223\3\2\2\2\u0225\u0226\3\2\2\2\u0226\u0227\3\2\2\2\u0227\u0229\7\60"+
		"\2\2\u0228\u022a\5\31\r\2\u0229\u0228\3\2\2\2\u022a\u022b\3\2\2\2\u022b"+
		"\u0229\3\2\2\2\u022b\u022c\3\2\2\2\u022c\u0234\3\2\2\2\u022d\u022f\7\60"+
		"\2\2\u022e\u0230\5\31\r\2\u022f\u022e\3\2\2\2\u0230\u0231\3\2\2\2\u0231"+
		"\u022f\3\2\2\2\u0231\u0232\3\2\2\2\u0232\u0234\3\2\2\2\u0233\u0223\3\2"+
		"\2\2\u0233\u022d\3\2\2\2\u0234\24\3\2\2\2\u0235\u0236\t\2\2\2\u0236\26"+
		"\3\2\2\2\u0237\u023b\t\3\2\2\u0238\u023a\t\3\2\2\u0239\u0238\3\2\2\2\u023a"+
		"\u023d\3\2\2\2\u023b\u0239\3\2\2\2\u023b\u023c\3\2\2\2\u023c\30\3\2\2"+
		"\2\u023d\u023b\3\2\2\2\u023e\u023f\t\4\2\2\u023f\32\3\2\2\2\u0240\u0242"+
		"\7\17\2\2\u0241\u0240\3\2\2\2\u0241\u0242\3\2\2\2\u0242\u0243\3\2\2\2"+
		"\u0243\u0244\7\f\2\2\u0244\34\3\2\2\2\u0245\u0247\t\5\2\2\u0246\u0245"+
		"\3\2\2\2\u0247\u0248\3\2\2\2\u0248\u0246\3\2\2\2\u0248\u0249\3\2\2\2\u0249"+
		"\u024a\3\2\2\2\u024a\u024b\b\17\2\2\u024b\36\3\2\2\2\r\2\u0086\u00c9\u0220"+
		"\u0225\u022b\u0231\u0233\u023b\u0241\u0248\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}