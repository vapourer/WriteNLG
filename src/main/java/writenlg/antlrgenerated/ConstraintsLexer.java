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
		T__0=1, CONCEPT_TYPE=2, CONSTRAINT_NAME=3, WEIGHTING=4, DIGIT=5, NEW_LINE=6, 
		WHITE_SPACE=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "CONCEPT_TYPE", "CONSTRAINT_NAME", "WEIGHTING", "DIGIT", "NEW_LINE", 
		"WHITE_SPACE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "CONCEPT_TYPE", "CONSTRAINT_NAME", "WEIGHTING", "DIGIT", "NEW_LINE", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\t\u00f3\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u00b3"+
		"\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u00e2\n\4\3\5\3\5\3\6"+
		"\3\6\3\7\5\7\u00e9\n\7\3\7\3\7\3\b\6\b\u00ee\n\b\r\b\16\b\u00ef\3\b\3"+
		"\b\2\2\t\3\3\5\4\7\5\t\6\13\7\r\b\17\t\3\2\5\3\2\63\67\3\2\62;\4\2\13"+
		"\13\"\"\2\u0102\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\3\21\3\2\2\2\5\u00b2\3\2\2\2\7\u00e1\3"+
		"\2\2\2\t\u00e3\3\2\2\2\13\u00e5\3\2\2\2\r\u00e8\3\2\2\2\17\u00ed\3\2\2"+
		"\2\21\22\7?\2\2\22\4\3\2\2\2\23\24\7O\2\2\24\25\7C\2\2\25\26\7Z\2\2\26"+
		"\27\7K\2\2\27\30\7O\2\2\30\31\7W\2\2\31\u00b3\7O\2\2\32\33\7O\2\2\33\34"+
		"\7K\2\2\34\35\7P\2\2\35\36\7K\2\2\36\37\7O\2\2\37 \7W\2\2 \u00b3\7O\2"+
		"\2!\"\7T\2\2\"#\7K\2\2#$\7U\2\2$%\7K\2\2%&\7P\2\2&\'\7I\2\2\'(\7a\2\2"+
		"()\7V\2\2)*\7T\2\2*+\7G\2\2+,\7P\2\2,\u00b3\7F\2\2-.\7F\2\2./\7G\2\2/"+
		"\60\7U\2\2\60\61\7E\2\2\61\62\7G\2\2\62\63\7P\2\2\63\64\7F\2\2\64\65\7"+
		"K\2\2\65\66\7P\2\2\66\67\7I\2\2\678\7a\2\289\7V\2\29:\7T\2\2:;\7G\2\2"+
		";<\7P\2\2<\u00b3\7F\2\2=>\7O\2\2>?\7W\2\2?@\7N\2\2@A\7V\2\2AB\7K\2\2B"+
		"C\7R\2\2CD\7N\2\2DE\7G\2\2EF\7a\2\2FG\7V\2\2GH\7T\2\2HI\7G\2\2IJ\7P\2"+
		"\2JK\7F\2\2K\u00b3\7U\2\2LM\7N\2\2MN\7Q\2\2NO\7P\2\2OP\7I\2\2PQ\7G\2\2"+
		"QR\7U\2\2RS\7V\2\2ST\7a\2\2TU\7V\2\2UV\7T\2\2VW\7G\2\2WX\7P\2\2X\u00b3"+
		"\7F\2\2YZ\7U\2\2Z[\7R\2\2[\\\7K\2\2\\]\7M\2\2]^\7G\2\2^\u00b3\7U\2\2_"+
		"`\7V\2\2`a\7W\2\2ab\7T\2\2bc\7P\2\2cd\7K\2\2de\7P\2\2ef\7I\2\2fg\7a\2"+
		"\2gh\7R\2\2hi\7Q\2\2ij\7K\2\2jk\7P\2\2kl\7V\2\2l\u00b3\7U\2\2mn\7U\2\2"+
		"no\7G\2\2op\7T\2\2pq\7K\2\2qr\7G\2\2rs\7U\2\2st\7a\2\2tu\7N\2\2uv\7G\2"+
		"\2vw\7I\2\2wx\7G\2\2xy\7P\2\2y\u00b3\7F\2\2z{\7V\2\2{|\7K\2\2|}\7O\2\2"+
		"}~\7G\2\2~\177\7a\2\2\177\u0080\7U\2\2\u0080\u0081\7N\2\2\u0081\u0082"+
		"\7K\2\2\u0082\u0083\7E\2\2\u0083\u00b3\7G\2\2\u0084\u0085\7E\2\2\u0085"+
		"\u0086\7Q\2\2\u0086\u0087\7P\2\2\u0087\u0088\7U\2\2\u0088\u0089\7K\2\2"+
		"\u0089\u008a\7U\2\2\u008a\u008b\7V\2\2\u008b\u008c\7G\2\2\u008c\u008d"+
		"\7P\2\2\u008d\u008e\7V\2\2\u008e\u008f\7a\2\2\u008f\u0090\7F\2\2\u0090"+
		"\u0091\7K\2\2\u0091\u0092\7U\2\2\u0092\u0093\7V\2\2\u0093\u0094\7C\2\2"+
		"\u0094\u0095\7P\2\2\u0095\u0096\7E\2\2\u0096\u0097\7G\2\2\u0097\u0098"+
		"\7a\2\2\u0098\u0099\7C\2\2\u0099\u009a\7R\2\2\u009a\u009b\7C\2\2\u009b"+
		"\u009c\7T\2\2\u009c\u00b3\7V\2\2\u009d\u009e\7N\2\2\u009e\u009f\7K\2\2"+
		"\u009f\u00a0\7P\2\2\u00a0\u00a1\7G\2\2\u00a1\u00a2\7U\2\2\u00a2\u00a3"+
		"\7a\2\2\u00a3\u00a4\7E\2\2\u00a4\u00a5\7T\2\2\u00a5\u00a6\7Q\2\2\u00a6"+
		"\u00a7\7U\2\2\u00a7\u00b3\7U\2\2\u00a8\u00a9\7N\2\2\u00a9\u00aa\7K\2\2"+
		"\u00aa\u00ab\7P\2\2\u00ab\u00ac\7G\2\2\u00ac\u00ad\7U\2\2\u00ad\u00ae"+
		"\7a\2\2\u00ae\u00af\7O\2\2\u00af\u00b0\7G\2\2\u00b0\u00b1\7G\2\2\u00b1"+
		"\u00b3\7V\2\2\u00b2\23\3\2\2\2\u00b2\32\3\2\2\2\u00b2!\3\2\2\2\u00b2-"+
		"\3\2\2\2\u00b2=\3\2\2\2\u00b2L\3\2\2\2\u00b2Y\3\2\2\2\u00b2_\3\2\2\2\u00b2"+
		"m\3\2\2\2\u00b2z\3\2\2\2\u00b2\u0084\3\2\2\2\u00b2\u009d\3\2\2\2\u00b2"+
		"\u00a8\3\2\2\2\u00b3\6\3\2\2\2\u00b4\u00b5\7V\2\2\u00b5\u00b6\7g\2\2\u00b6"+
		"\u00b7\7u\2\2\u00b7\u00b8\7v\2\2\u00b8\u00b9\7E\2\2\u00b9\u00ba\7q\2\2"+
		"\u00ba\u00bb\7p\2\2\u00bb\u00bc\7u\2\2\u00bc\u00bd\7v\2\2\u00bd\u00be"+
		"\7t\2\2\u00be\u00bf\7c\2\2\u00bf\u00c0\7k\2\2\u00c0\u00c1\7p\2\2\u00c1"+
		"\u00c2\7v\2\2\u00c2\u00e2\7\64\2\2\u00c3\u00c4\7V\2\2\u00c4\u00c5\7g\2"+
		"\2\u00c5\u00c6\7u\2\2\u00c6\u00c7\7v\2\2\u00c7\u00c8\7E\2\2\u00c8\u00c9"+
		"\7q\2\2\u00c9\u00ca\7p\2\2\u00ca\u00cb\7u\2\2\u00cb\u00cc\7v\2\2\u00cc"+
		"\u00cd\7t\2\2\u00cd\u00ce\7c\2\2\u00ce\u00cf\7k\2\2\u00cf\u00d0\7p\2\2"+
		"\u00d0\u00d1\7v\2\2\u00d1\u00e2\7\65\2\2\u00d2\u00d3\7V\2\2\u00d3\u00d4"+
		"\7g\2\2\u00d4\u00d5\7u\2\2\u00d5\u00d6\7v\2\2\u00d6\u00d7\7E\2\2\u00d7"+
		"\u00d8\7q\2\2\u00d8\u00d9\7p\2\2\u00d9\u00da\7u\2\2\u00da\u00db\7v\2\2"+
		"\u00db\u00dc\7t\2\2\u00dc\u00dd\7c\2\2\u00dd\u00de\7k\2\2\u00de\u00df"+
		"\7p\2\2\u00df\u00e0\7v\2\2\u00e0\u00e2\7\66\2\2\u00e1\u00b4\3\2\2\2\u00e1"+
		"\u00c3\3\2\2\2\u00e1\u00d2\3\2\2\2\u00e2\b\3\2\2\2\u00e3\u00e4\t\2\2\2"+
		"\u00e4\n\3\2\2\2\u00e5\u00e6\t\3\2\2\u00e6\f\3\2\2\2\u00e7\u00e9\7\17"+
		"\2\2\u00e8\u00e7\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea"+
		"\u00eb\7\f\2\2\u00eb\16\3\2\2\2\u00ec\u00ee\t\4\2\2\u00ed\u00ec\3\2\2"+
		"\2\u00ee\u00ef\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1"+
		"\3\2\2\2\u00f1\u00f2\b\b\2\2\u00f2\20\3\2\2\2\7\2\u00b2\u00e1\u00e8\u00ef"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}