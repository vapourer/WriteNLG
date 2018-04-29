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
		TIME_SERIES_CONCEPT_TYPE=7, VALUE=8, WEIGHTING=9, STRING=10, DIGIT=11, 
		NEW_LINE=12, WHITE_SPACE=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "GLOBAL_CONCEPT", "TIME_SERIES_CONCEPT", "GLOBAL_CONCEPT_TYPE", 
		"TIME_SERIES_CONCEPT_TYPE", "VALUE", "WEIGHTING", "STRING", "DIGIT", "NEW_LINE", 
		"WHITE_SPACE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'('", "')'", "'GlobalConcept'", "'TimeSeriesConcept'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "GLOBAL_CONCEPT", "TIME_SERIES_CONCEPT", "GLOBAL_CONCEPT_TYPE", 
		"TIME_SERIES_CONCEPT_TYPE", "VALUE", "WEIGHTING", "STRING", "DIGIT", "NEW_LINE", 
		"WHITE_SPACE"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\17\u0111\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\5\7r\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00e5"+
		"\n\b\3\t\6\t\u00e8\n\t\r\t\16\t\u00e9\3\t\3\t\7\t\u00ee\n\t\f\t\16\t\u00f1"+
		"\13\t\3\t\3\t\6\t\u00f5\n\t\r\t\16\t\u00f6\5\t\u00f9\n\t\3\n\3\n\3\13"+
		"\3\13\7\13\u00ff\n\13\f\13\16\13\u0102\13\13\3\f\3\f\3\r\5\r\u0107\n\r"+
		"\3\r\3\r\3\16\6\16\u010c\n\16\r\16\16\16\u010d\3\16\3\16\2\2\17\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\3\2\7\3\2\63"+
		"\67\5\2\62;C\\c|\6\2\"\"\62;C\\c|\3\2\62;\4\2\13\13\"\"\2\u0122\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\3\35\3\2\2\2\5\37\3\2\2\2\7!\3\2\2\2\t#\3\2\2\2\13"+
		"\61\3\2\2\2\rq\3\2\2\2\17\u00e4\3\2\2\2\21\u00f8\3\2\2\2\23\u00fa\3\2"+
		"\2\2\25\u00fc\3\2\2\2\27\u0103\3\2\2\2\31\u0106\3\2\2\2\33\u010b\3\2\2"+
		"\2\35\36\7?\2\2\36\4\3\2\2\2\37 \7*\2\2 \6\3\2\2\2!\"\7+\2\2\"\b\3\2\2"+
		"\2#$\7I\2\2$%\7n\2\2%&\7q\2\2&\'\7d\2\2\'(\7c\2\2()\7n\2\2)*\7E\2\2*+"+
		"\7q\2\2+,\7p\2\2,-\7e\2\2-.\7g\2\2./\7r\2\2/\60\7v\2\2\60\n\3\2\2\2\61"+
		"\62\7V\2\2\62\63\7k\2\2\63\64\7o\2\2\64\65\7g\2\2\65\66\7U\2\2\66\67\7"+
		"g\2\2\678\7t\2\289\7k\2\29:\7g\2\2:;\7u\2\2;<\7E\2\2<=\7q\2\2=>\7p\2\2"+
		">?\7e\2\2?@\7g\2\2@A\7r\2\2AB\7v\2\2B\f\3\2\2\2CD\7E\2\2DE\7Q\2\2EF\7"+
		"P\2\2FG\7U\2\2GH\7K\2\2HI\7U\2\2IJ\7V\2\2JK\7G\2\2KL\7P\2\2LM\7V\2\2M"+
		"N\7a\2\2NO\7F\2\2OP\7K\2\2PQ\7U\2\2QR\7V\2\2RS\7C\2\2ST\7P\2\2TU\7E\2"+
		"\2UV\7G\2\2VW\7a\2\2WX\7C\2\2XY\7R\2\2YZ\7C\2\2Z[\7T\2\2[r\7V\2\2\\]\7"+
		"N\2\2]^\7K\2\2^_\7P\2\2_`\7G\2\2`a\7U\2\2ab\7a\2\2bc\7E\2\2cd\7T\2\2d"+
		"e\7Q\2\2ef\7U\2\2fr\7U\2\2gh\7N\2\2hi\7K\2\2ij\7P\2\2jk\7G\2\2kl\7U\2"+
		"\2lm\7a\2\2mn\7O\2\2no\7G\2\2op\7G\2\2pr\7V\2\2qC\3\2\2\2q\\\3\2\2\2q"+
		"g\3\2\2\2r\16\3\2\2\2st\7O\2\2tu\7C\2\2uv\7Z\2\2vw\7K\2\2wx\7O\2\2xy\7"+
		"W\2\2y\u00e5\7O\2\2z{\7O\2\2{|\7K\2\2|}\7P\2\2}~\7K\2\2~\177\7O\2\2\177"+
		"\u0080\7W\2\2\u0080\u00e5\7O\2\2\u0081\u0082\7T\2\2\u0082\u0083\7K\2\2"+
		"\u0083\u0084\7U\2\2\u0084\u0085\7K\2\2\u0085\u0086\7P\2\2\u0086\u0087"+
		"\7I\2\2\u0087\u0088\7a\2\2\u0088\u0089\7V\2\2\u0089\u008a\7T\2\2\u008a"+
		"\u008b\7G\2\2\u008b\u008c\7P\2\2\u008c\u00e5\7F\2\2\u008d\u008e\7F\2\2"+
		"\u008e\u008f\7G\2\2\u008f\u0090\7U\2\2\u0090\u0091\7E\2\2\u0091\u0092"+
		"\7G\2\2\u0092\u0093\7P\2\2\u0093\u0094\7F\2\2\u0094\u0095\7K\2\2\u0095"+
		"\u0096\7P\2\2\u0096\u0097\7I\2\2\u0097\u0098\7a\2\2\u0098\u0099\7V\2\2"+
		"\u0099\u009a\7T\2\2\u009a\u009b\7G\2\2\u009b\u009c\7P\2\2\u009c\u00e5"+
		"\7F\2\2\u009d\u009e\7O\2\2\u009e\u009f\7W\2\2\u009f\u00a0\7N\2\2\u00a0"+
		"\u00a1\7V\2\2\u00a1\u00a2\7K\2\2\u00a2\u00a3\7R\2\2\u00a3\u00a4\7N\2\2"+
		"\u00a4\u00a5\7G\2\2\u00a5\u00a6\7a\2\2\u00a6\u00a7\7V\2\2\u00a7\u00a8"+
		"\7T\2\2\u00a8\u00a9\7G\2\2\u00a9\u00aa\7P\2\2\u00aa\u00ab\7F\2\2\u00ab"+
		"\u00e5\7U\2\2\u00ac\u00ad\7N\2\2\u00ad\u00ae\7Q\2\2\u00ae\u00af\7P\2\2"+
		"\u00af\u00b0\7I\2\2\u00b0\u00b1\7G\2\2\u00b1\u00b2\7U\2\2\u00b2\u00b3"+
		"\7V\2\2\u00b3\u00b4\7a\2\2\u00b4\u00b5\7V\2\2\u00b5\u00b6\7T\2\2\u00b6"+
		"\u00b7\7G\2\2\u00b7\u00b8\7P\2\2\u00b8\u00e5\7F\2\2\u00b9\u00ba\7U\2\2"+
		"\u00ba\u00bb\7R\2\2\u00bb\u00bc\7K\2\2\u00bc\u00bd\7M\2\2\u00bd\u00be"+
		"\7G\2\2\u00be\u00e5\7U\2\2\u00bf\u00c0\7V\2\2\u00c0\u00c1\7W\2\2\u00c1"+
		"\u00c2\7T\2\2\u00c2\u00c3\7P\2\2\u00c3\u00c4\7K\2\2\u00c4\u00c5\7P\2\2"+
		"\u00c5\u00c6\7I\2\2\u00c6\u00c7\7a\2\2\u00c7\u00c8\7R\2\2\u00c8\u00c9"+
		"\7Q\2\2\u00c9\u00ca\7K\2\2\u00ca\u00cb\7P\2\2\u00cb\u00cc\7V\2\2\u00cc"+
		"\u00e5\7U\2\2\u00cd\u00ce\7U\2\2\u00ce\u00cf\7G\2\2\u00cf\u00d0\7T\2\2"+
		"\u00d0\u00d1\7K\2\2\u00d1\u00d2\7G\2\2\u00d2\u00d3\7U\2\2\u00d3\u00d4"+
		"\7a\2\2\u00d4\u00d5\7N\2\2\u00d5\u00d6\7G\2\2\u00d6\u00d7\7I\2\2\u00d7"+
		"\u00d8\7G\2\2\u00d8\u00d9\7P\2\2\u00d9\u00e5\7F\2\2\u00da\u00db\7V\2\2"+
		"\u00db\u00dc\7K\2\2\u00dc\u00dd\7O\2\2\u00dd\u00de\7G\2\2\u00de\u00df"+
		"\7a\2\2\u00df\u00e0\7U\2\2\u00e0\u00e1\7N\2\2\u00e1\u00e2\7K\2\2\u00e2"+
		"\u00e3\7E\2\2\u00e3\u00e5\7G\2\2\u00e4s\3\2\2\2\u00e4z\3\2\2\2\u00e4\u0081"+
		"\3\2\2\2\u00e4\u008d\3\2\2\2\u00e4\u009d\3\2\2\2\u00e4\u00ac\3\2\2\2\u00e4"+
		"\u00b9\3\2\2\2\u00e4\u00bf\3\2\2\2\u00e4\u00cd\3\2\2\2\u00e4\u00da\3\2"+
		"\2\2\u00e5\20\3\2\2\2\u00e6\u00e8\5\27\f\2\u00e7\u00e6\3\2\2\2\u00e8\u00e9"+
		"\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb"+
		"\u00ef\7\60\2\2\u00ec\u00ee\5\27\f\2\u00ed\u00ec\3\2\2\2\u00ee\u00f1\3"+
		"\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f9\3\2\2\2\u00f1"+
		"\u00ef\3\2\2\2\u00f2\u00f4\7\60\2\2\u00f3\u00f5\5\27\f\2\u00f4\u00f3\3"+
		"\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7"+
		"\u00f9\3\2\2\2\u00f8\u00e7\3\2\2\2\u00f8\u00f2\3\2\2\2\u00f9\22\3\2\2"+
		"\2\u00fa\u00fb\t\2\2\2\u00fb\24\3\2\2\2\u00fc\u0100\t\3\2\2\u00fd\u00ff"+
		"\t\4\2\2\u00fe\u00fd\3\2\2\2\u00ff\u0102\3\2\2\2\u0100\u00fe\3\2\2\2\u0100"+
		"\u0101\3\2\2\2\u0101\26\3\2\2\2\u0102\u0100\3\2\2\2\u0103\u0104\t\5\2"+
		"\2\u0104\30\3\2\2\2\u0105\u0107\7\17\2\2\u0106\u0105\3\2\2\2\u0106\u0107"+
		"\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0109\7\f\2\2\u0109\32\3\2\2\2\u010a"+
		"\u010c\t\6\2\2\u010b\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010b\3\2"+
		"\2\2\u010d\u010e\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0110\b\16\2\2\u0110"+
		"\34\3\2\2\2\f\2q\u00e4\u00e9\u00ef\u00f6\u00f8\u0100\u0106\u010d\3\b\2"+
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