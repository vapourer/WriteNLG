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
		T__0=1, T__1=2, T__2=3, CONCEPT=4, VALUE=5, WEIGHTING=6, STRING=7, DIGIT=8, 
		NEW_LINE=9, WHITE_SPACE=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "CONCEPT", "VALUE", "WEIGHTING", "STRING", "DIGIT", 
		"NEW_LINE", "WHITE_SPACE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "CONCEPT", "VALUE", "WEIGHTING", "STRING", "DIGIT", 
		"NEW_LINE", "WHITE_SPACE"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\f\u00e9\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u00bd\n\5\3\6\6\6\u00c0\n\6\r"+
		"\6\16\6\u00c1\3\6\3\6\7\6\u00c6\n\6\f\6\16\6\u00c9\13\6\3\6\3\6\6\6\u00cd"+
		"\n\6\r\6\16\6\u00ce\5\6\u00d1\n\6\3\7\3\7\3\b\3\b\7\b\u00d7\n\b\f\b\16"+
		"\b\u00da\13\b\3\t\3\t\3\n\5\n\u00df\n\n\3\n\3\n\3\13\6\13\u00e4\n\13\r"+
		"\13\16\13\u00e5\3\13\3\13\2\2\f\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\3\2\7\3\2\63\67\5\2\62;C\\c|\6\2\"\"\62;C\\c|\3\2\62;\4\2\13"+
		"\13\"\"\2\u00fb\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\3\27\3\2\2\2\5\31\3\2\2\2\7\33\3\2\2\2\t\u00bc\3\2\2\2\13\u00d0\3\2\2"+
		"\2\r\u00d2\3\2\2\2\17\u00d4\3\2\2\2\21\u00db\3\2\2\2\23\u00de\3\2\2\2"+
		"\25\u00e3\3\2\2\2\27\30\7?\2\2\30\4\3\2\2\2\31\32\7*\2\2\32\6\3\2\2\2"+
		"\33\34\7+\2\2\34\b\3\2\2\2\35\36\7O\2\2\36\37\7C\2\2\37 \7Z\2\2 !\7K\2"+
		"\2!\"\7O\2\2\"#\7W\2\2#\u00bd\7O\2\2$%\7O\2\2%&\7K\2\2&\'\7P\2\2\'(\7"+
		"K\2\2()\7O\2\2)*\7W\2\2*\u00bd\7O\2\2+,\7T\2\2,-\7K\2\2-.\7U\2\2./\7K"+
		"\2\2/\60\7P\2\2\60\61\7I\2\2\61\62\7a\2\2\62\63\7V\2\2\63\64\7T\2\2\64"+
		"\65\7G\2\2\65\66\7P\2\2\66\u00bd\7F\2\2\678\7F\2\289\7G\2\29:\7U\2\2:"+
		";\7E\2\2;<\7G\2\2<=\7P\2\2=>\7F\2\2>?\7K\2\2?@\7P\2\2@A\7I\2\2AB\7a\2"+
		"\2BC\7V\2\2CD\7T\2\2DE\7G\2\2EF\7P\2\2F\u00bd\7F\2\2GH\7O\2\2HI\7W\2\2"+
		"IJ\7N\2\2JK\7V\2\2KL\7K\2\2LM\7R\2\2MN\7N\2\2NO\7G\2\2OP\7a\2\2PQ\7V\2"+
		"\2QR\7T\2\2RS\7G\2\2ST\7P\2\2TU\7F\2\2U\u00bd\7U\2\2VW\7N\2\2WX\7Q\2\2"+
		"XY\7P\2\2YZ\7I\2\2Z[\7G\2\2[\\\7U\2\2\\]\7V\2\2]^\7a\2\2^_\7V\2\2_`\7"+
		"T\2\2`a\7G\2\2ab\7P\2\2b\u00bd\7F\2\2cd\7U\2\2de\7R\2\2ef\7K\2\2fg\7M"+
		"\2\2gh\7G\2\2h\u00bd\7U\2\2ij\7V\2\2jk\7W\2\2kl\7T\2\2lm\7P\2\2mn\7K\2"+
		"\2no\7P\2\2op\7I\2\2pq\7a\2\2qr\7R\2\2rs\7Q\2\2st\7K\2\2tu\7P\2\2uv\7"+
		"V\2\2v\u00bd\7U\2\2wx\7U\2\2xy\7G\2\2yz\7T\2\2z{\7K\2\2{|\7G\2\2|}\7U"+
		"\2\2}~\7a\2\2~\177\7N\2\2\177\u0080\7G\2\2\u0080\u0081\7I\2\2\u0081\u0082"+
		"\7G\2\2\u0082\u0083\7P\2\2\u0083\u00bd\7F\2\2\u0084\u0085\7V\2\2\u0085"+
		"\u0086\7K\2\2\u0086\u0087\7O\2\2\u0087\u0088\7G\2\2\u0088\u0089\7a\2\2"+
		"\u0089\u008a\7U\2\2\u008a\u008b\7N\2\2\u008b\u008c\7K\2\2\u008c\u008d"+
		"\7E\2\2\u008d\u00bd\7G\2\2\u008e\u008f\7E\2\2\u008f\u0090\7Q\2\2\u0090"+
		"\u0091\7P\2\2\u0091\u0092\7U\2\2\u0092\u0093\7K\2\2\u0093\u0094\7U\2\2"+
		"\u0094\u0095\7V\2\2\u0095\u0096\7G\2\2\u0096\u0097\7P\2\2\u0097\u0098"+
		"\7V\2\2\u0098\u0099\7a\2\2\u0099\u009a\7F\2\2\u009a\u009b\7K\2\2\u009b"+
		"\u009c\7U\2\2\u009c\u009d\7V\2\2\u009d\u009e\7C\2\2\u009e\u009f\7P\2\2"+
		"\u009f\u00a0\7E\2\2\u00a0\u00a1\7G\2\2\u00a1\u00a2\7a\2\2\u00a2\u00a3"+
		"\7C\2\2\u00a3\u00a4\7R\2\2\u00a4\u00a5\7C\2\2\u00a5\u00a6\7T\2\2\u00a6"+
		"\u00bd\7V\2\2\u00a7\u00a8\7N\2\2\u00a8\u00a9\7K\2\2\u00a9\u00aa\7P\2\2"+
		"\u00aa\u00ab\7G\2\2\u00ab\u00ac\7U\2\2\u00ac\u00ad\7a\2\2\u00ad\u00ae"+
		"\7E\2\2\u00ae\u00af\7T\2\2\u00af\u00b0\7Q\2\2\u00b0\u00b1\7U\2\2\u00b1"+
		"\u00bd\7U\2\2\u00b2\u00b3\7N\2\2\u00b3\u00b4\7K\2\2\u00b4\u00b5\7P\2\2"+
		"\u00b5\u00b6\7G\2\2\u00b6\u00b7\7U\2\2\u00b7\u00b8\7a\2\2\u00b8\u00b9"+
		"\7O\2\2\u00b9\u00ba\7G\2\2\u00ba\u00bb\7G\2\2\u00bb\u00bd\7V\2\2\u00bc"+
		"\35\3\2\2\2\u00bc$\3\2\2\2\u00bc+\3\2\2\2\u00bc\67\3\2\2\2\u00bcG\3\2"+
		"\2\2\u00bcV\3\2\2\2\u00bcc\3\2\2\2\u00bci\3\2\2\2\u00bcw\3\2\2\2\u00bc"+
		"\u0084\3\2\2\2\u00bc\u008e\3\2\2\2\u00bc\u00a7\3\2\2\2\u00bc\u00b2\3\2"+
		"\2\2\u00bd\n\3\2\2\2\u00be\u00c0\5\21\t\2\u00bf\u00be\3\2\2\2\u00c0\u00c1"+
		"\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3"+
		"\u00c7\7\60\2\2\u00c4\u00c6\5\21\t\2\u00c5\u00c4\3\2\2\2\u00c6\u00c9\3"+
		"\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00d1\3\2\2\2\u00c9"+
		"\u00c7\3\2\2\2\u00ca\u00cc\7\60\2\2\u00cb\u00cd\5\21\t\2\u00cc\u00cb\3"+
		"\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf"+
		"\u00d1\3\2\2\2\u00d0\u00bf\3\2\2\2\u00d0\u00ca\3\2\2\2\u00d1\f\3\2\2\2"+
		"\u00d2\u00d3\t\2\2\2\u00d3\16\3\2\2\2\u00d4\u00d8\t\3\2\2\u00d5\u00d7"+
		"\t\4\2\2\u00d6\u00d5\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8"+
		"\u00d9\3\2\2\2\u00d9\20\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00dc\t\5\2"+
		"\2\u00dc\22\3\2\2\2\u00dd\u00df\7\17\2\2\u00de\u00dd\3\2\2\2\u00de\u00df"+
		"\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\7\f\2\2\u00e1\24\3\2\2\2\u00e2"+
		"\u00e4\t\6\2\2\u00e3\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e3\3\2"+
		"\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\b\13\2\2\u00e8"+
		"\26\3\2\2\2\13\2\u00bc\u00c1\u00c7\u00ce\u00d0\u00d8\u00de\u00e5\3\b\2"+
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