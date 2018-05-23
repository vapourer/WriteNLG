// Generated from PhraseCreator.g4 by ANTLR 4.7
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
public class PhraseCreatorLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, GLOBAL_CONCEPT=16, 
		TIME_SERIES_CONCEPT=17, AGGREGATION_CONCEPT=18, GLOBAL_CONCEPT_TYPE=19, 
		TIME_SERIES_CONCEPT_TYPE=20, AGGREGATION_CONCEPT_TYPE=21, PHRASE_SPECIFICATION=22, 
		SUBJECT=23, PREDICATE=24, FEATURES=25, PART_OF_SPEECH=26, STRING=27, NEW_LINE=28, 
		WHITE_SPACE=29, PLACE_HOLDER_MARKER=30;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "GLOBAL_CONCEPT", 
		"TIME_SERIES_CONCEPT", "AGGREGATION_CONCEPT", "GLOBAL_CONCEPT_TYPE", "TIME_SERIES_CONCEPT_TYPE", 
		"AGGREGATION_CONCEPT_TYPE", "PHRASE_SPECIFICATION", "SUBJECT", "PREDICATE", 
		"FEATURES", "PART_OF_SPEECH", "STRING", "NEW_LINE", "WHITE_SPACE", "PLACE_HOLDER_MARKER"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "':'", "' '", "'tense'", "'present'", "'past'", "'future'", 
		"'complementiser'", "'conjunction'", "'SubjectNumber'", "'VerbNumber'", 
		"'ObjectNumber'", "'ComplementNumber'", "'singular'", "'plural'", "'GlobalConcept'", 
		"'TimeSeriesConcept'", "'AggregationConcept'", null, null, null, "'PhraseSpecification'", 
		"'Subject'", "'Predicate'", "'Features'", null, null, null, null, "'@@'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "GLOBAL_CONCEPT", "TIME_SERIES_CONCEPT", "AGGREGATION_CONCEPT", 
		"GLOBAL_CONCEPT_TYPE", "TIME_SERIES_CONCEPT_TYPE", "AGGREGATION_CONCEPT_TYPE", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2 \u02f0\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\5\24\u0136\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\5\25\u0179\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0254"+
		"\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u02d9\n\33\3\34\3\34\7\34\u02dd\n"+
		"\34\f\34\16\34\u02e0\13\34\3\35\5\35\u02e3\n\35\3\35\3\35\3\36\6\36\u02e8"+
		"\n\36\r\36\16\36\u02e9\3\36\3\36\3\37\3\37\3\37\2\2 \3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= \3\2\5\5\2\62;C\\"+
		"c|\6\2\"\"\62;C\\c|\4\2\13\13\"\"\2\u0308\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\3?\3\2\2\2"+
		"\5A\3\2\2\2\7C\3\2\2\2\tE\3\2\2\2\13K\3\2\2\2\rS\3\2\2\2\17X\3\2\2\2\21"+
		"_\3\2\2\2\23n\3\2\2\2\25z\3\2\2\2\27\u0088\3\2\2\2\31\u0093\3\2\2\2\33"+
		"\u00a0\3\2\2\2\35\u00b1\3\2\2\2\37\u00ba\3\2\2\2!\u00c1\3\2\2\2#\u00cf"+
		"\3\2\2\2%\u00e1\3\2\2\2\'\u0135\3\2\2\2)\u0178\3\2\2\2+\u0253\3\2\2\2"+
		"-\u0255\3\2\2\2/\u0269\3\2\2\2\61\u0271\3\2\2\2\63\u027b\3\2\2\2\65\u02d8"+
		"\3\2\2\2\67\u02da\3\2\2\29\u02e2\3\2\2\2;\u02e7\3\2\2\2=\u02ed\3\2\2\2"+
		"?@\7?\2\2@\4\3\2\2\2AB\7<\2\2B\6\3\2\2\2CD\7\"\2\2D\b\3\2\2\2EF\7v\2\2"+
		"FG\7g\2\2GH\7p\2\2HI\7u\2\2IJ\7g\2\2J\n\3\2\2\2KL\7r\2\2LM\7t\2\2MN\7"+
		"g\2\2NO\7u\2\2OP\7g\2\2PQ\7p\2\2QR\7v\2\2R\f\3\2\2\2ST\7r\2\2TU\7c\2\2"+
		"UV\7u\2\2VW\7v\2\2W\16\3\2\2\2XY\7h\2\2YZ\7w\2\2Z[\7v\2\2[\\\7w\2\2\\"+
		"]\7t\2\2]^\7g\2\2^\20\3\2\2\2_`\7e\2\2`a\7q\2\2ab\7o\2\2bc\7r\2\2cd\7"+
		"n\2\2de\7g\2\2ef\7o\2\2fg\7g\2\2gh\7p\2\2hi\7v\2\2ij\7k\2\2jk\7u\2\2k"+
		"l\7g\2\2lm\7t\2\2m\22\3\2\2\2no\7e\2\2op\7q\2\2pq\7p\2\2qr\7l\2\2rs\7"+
		"w\2\2st\7p\2\2tu\7e\2\2uv\7v\2\2vw\7k\2\2wx\7q\2\2xy\7p\2\2y\24\3\2\2"+
		"\2z{\7U\2\2{|\7w\2\2|}\7d\2\2}~\7l\2\2~\177\7g\2\2\177\u0080\7e\2\2\u0080"+
		"\u0081\7v\2\2\u0081\u0082\7P\2\2\u0082\u0083\7w\2\2\u0083\u0084\7o\2\2"+
		"\u0084\u0085\7d\2\2\u0085\u0086\7g\2\2\u0086\u0087\7t\2\2\u0087\26\3\2"+
		"\2\2\u0088\u0089\7X\2\2\u0089\u008a\7g\2\2\u008a\u008b\7t\2\2\u008b\u008c"+
		"\7d\2\2\u008c\u008d\7P\2\2\u008d\u008e\7w\2\2\u008e\u008f\7o\2\2\u008f"+
		"\u0090\7d\2\2\u0090\u0091\7g\2\2\u0091\u0092\7t\2\2\u0092\30\3\2\2\2\u0093"+
		"\u0094\7Q\2\2\u0094\u0095\7d\2\2\u0095\u0096\7l\2\2\u0096\u0097\7g\2\2"+
		"\u0097\u0098\7e\2\2\u0098\u0099\7v\2\2\u0099\u009a\7P\2\2\u009a\u009b"+
		"\7w\2\2\u009b\u009c\7o\2\2\u009c\u009d\7d\2\2\u009d\u009e\7g\2\2\u009e"+
		"\u009f\7t\2\2\u009f\32\3\2\2\2\u00a0\u00a1\7E\2\2\u00a1\u00a2\7q\2\2\u00a2"+
		"\u00a3\7o\2\2\u00a3\u00a4\7r\2\2\u00a4\u00a5\7n\2\2\u00a5\u00a6\7g\2\2"+
		"\u00a6\u00a7\7o\2\2\u00a7\u00a8\7g\2\2\u00a8\u00a9\7p\2\2\u00a9\u00aa"+
		"\7v\2\2\u00aa\u00ab\7P\2\2\u00ab\u00ac\7w\2\2\u00ac\u00ad\7o\2\2\u00ad"+
		"\u00ae\7d\2\2\u00ae\u00af\7g\2\2\u00af\u00b0\7t\2\2\u00b0\34\3\2\2\2\u00b1"+
		"\u00b2\7u\2\2\u00b2\u00b3\7k\2\2\u00b3\u00b4\7p\2\2\u00b4\u00b5\7i\2\2"+
		"\u00b5\u00b6\7w\2\2\u00b6\u00b7\7n\2\2\u00b7\u00b8\7c\2\2\u00b8\u00b9"+
		"\7t\2\2\u00b9\36\3\2\2\2\u00ba\u00bb\7r\2\2\u00bb\u00bc\7n\2\2\u00bc\u00bd"+
		"\7w\2\2\u00bd\u00be\7t\2\2\u00be\u00bf\7c\2\2\u00bf\u00c0\7n\2\2\u00c0"+
		" \3\2\2\2\u00c1\u00c2\7I\2\2\u00c2\u00c3\7n\2\2\u00c3\u00c4\7q\2\2\u00c4"+
		"\u00c5\7d\2\2\u00c5\u00c6\7c\2\2\u00c6\u00c7\7n\2\2\u00c7\u00c8\7E\2\2"+
		"\u00c8\u00c9\7q\2\2\u00c9\u00ca\7p\2\2\u00ca\u00cb\7e\2\2\u00cb\u00cc"+
		"\7g\2\2\u00cc\u00cd\7r\2\2\u00cd\u00ce\7v\2\2\u00ce\"\3\2\2\2\u00cf\u00d0"+
		"\7V\2\2\u00d0\u00d1\7k\2\2\u00d1\u00d2\7o\2\2\u00d2\u00d3\7g\2\2\u00d3"+
		"\u00d4\7U\2\2\u00d4\u00d5\7g\2\2\u00d5\u00d6\7t\2\2\u00d6\u00d7\7k\2\2"+
		"\u00d7\u00d8\7g\2\2\u00d8\u00d9\7u\2\2\u00d9\u00da\7E\2\2\u00da\u00db"+
		"\7q\2\2\u00db\u00dc\7p\2\2\u00dc\u00dd\7e\2\2\u00dd\u00de\7g\2\2\u00de"+
		"\u00df\7r\2\2\u00df\u00e0\7v\2\2\u00e0$\3\2\2\2\u00e1\u00e2\7C\2\2\u00e2"+
		"\u00e3\7i\2\2\u00e3\u00e4\7i\2\2\u00e4\u00e5\7t\2\2\u00e5\u00e6\7g\2\2"+
		"\u00e6\u00e7\7i\2\2\u00e7\u00e8\7c\2\2\u00e8\u00e9\7v\2\2\u00e9\u00ea"+
		"\7k\2\2\u00ea\u00eb\7q\2\2\u00eb\u00ec\7p\2\2\u00ec\u00ed\7E\2\2\u00ed"+
		"\u00ee\7q\2\2\u00ee\u00ef\7p\2\2\u00ef\u00f0\7e\2\2\u00f0\u00f1\7g\2\2"+
		"\u00f1\u00f2\7r\2\2\u00f2\u00f3\7v\2\2\u00f3&\3\2\2\2\u00f4\u00f5\7N\2"+
		"\2\u00f5\u00f6\7K\2\2\u00f6\u00f7\7P\2\2\u00f7\u00f8\7G\2\2\u00f8\u00f9"+
		"\7U\2\2\u00f9\u00fa\7a\2\2\u00fa\u00fb\7E\2\2\u00fb\u00fc\7T\2\2\u00fc"+
		"\u00fd\7Q\2\2\u00fd\u00fe\7U\2\2\u00fe\u0136\7U\2\2\u00ff\u0100\7N\2\2"+
		"\u0100\u0101\7K\2\2\u0101\u0102\7P\2\2\u0102\u0103\7G\2\2\u0103\u0104"+
		"\7U\2\2\u0104\u0105\7a\2\2\u0105\u0106\7F\2\2\u0106\u0107\7Q\2\2\u0107"+
		"\u0108\7a\2\2\u0108\u0109\7P\2\2\u0109\u010a\7Q\2\2\u010a\u010b\7V\2\2"+
		"\u010b\u010c\7a\2\2\u010c\u010d\7E\2\2\u010d\u010e\7T\2\2\u010e\u010f"+
		"\7Q\2\2\u010f\u0110\7U\2\2\u0110\u0136\7U\2\2\u0111\u0112\7N\2\2\u0112"+
		"\u0113\7K\2\2\u0113\u0114\7P\2\2\u0114\u0115\7G\2\2\u0115\u0116\7U\2\2"+
		"\u0116\u0117\7a\2\2\u0117\u0118\7E\2\2\u0118\u0119\7T\2\2\u0119\u011a"+
		"\7Q\2\2\u011a\u011b\7U\2\2\u011b\u011c\7U\2\2\u011c\u011d\7a\2\2\u011d"+
		"\u011e\7O\2\2\u011e\u011f\7W\2\2\u011f\u0120\7N\2\2\u0120\u0121\7V\2\2"+
		"\u0121\u0122\7K\2\2\u0122\u0123\7R\2\2\u0123\u0124\7N\2\2\u0124\u0125"+
		"\7G\2\2\u0125\u0126\7a\2\2\u0126\u0127\7V\2\2\u0127\u0128\7K\2\2\u0128"+
		"\u0129\7O\2\2\u0129\u012a\7G\2\2\u012a\u0136\7U\2\2\u012b\u012c\7N\2\2"+
		"\u012c\u012d\7K\2\2\u012d\u012e\7P\2\2\u012e\u012f\7G\2\2\u012f\u0130"+
		"\7a\2\2\u0130\u0131\7E\2\2\u0131\u0132\7Q\2\2\u0132\u0133\7W\2\2\u0133"+
		"\u0134\7P\2\2\u0134\u0136\7V\2\2\u0135\u00f4\3\2\2\2\u0135\u00ff\3\2\2"+
		"\2\u0135\u0111\3\2\2\2\u0135\u012b\3\2\2\2\u0136(\3\2\2\2\u0137\u0138"+
		"\7O\2\2\u0138\u0139\7C\2\2\u0139\u013a\7Z\2\2\u013a\u013b\7K\2\2\u013b"+
		"\u013c\7O\2\2\u013c\u013d\7W\2\2\u013d\u0179\7O\2\2\u013e\u013f\7O\2\2"+
		"\u013f\u0140\7K\2\2\u0140\u0141\7P\2\2\u0141\u0142\7K\2\2\u0142\u0143"+
		"\7O\2\2\u0143\u0144\7W\2\2\u0144\u0179\7O\2\2\u0145\u0146\7T\2\2\u0146"+
		"\u0147\7K\2\2\u0147\u0148\7U\2\2\u0148\u0149\7K\2\2\u0149\u014a\7P\2\2"+
		"\u014a\u014b\7I\2\2\u014b\u014c\7a\2\2\u014c\u014d\7V\2\2\u014d\u014e"+
		"\7T\2\2\u014e\u014f\7G\2\2\u014f\u0150\7P\2\2\u0150\u0179\7F\2\2\u0151"+
		"\u0152\7F\2\2\u0152\u0153\7G\2\2\u0153\u0154\7U\2\2\u0154\u0155\7E\2\2"+
		"\u0155\u0156\7G\2\2\u0156\u0157\7P\2\2\u0157\u0158\7F\2\2\u0158\u0159"+
		"\7K\2\2\u0159\u015a\7P\2\2\u015a\u015b\7I\2\2\u015b\u015c\7a\2\2\u015c"+
		"\u015d\7V\2\2\u015d\u015e\7T\2\2\u015e\u015f\7G\2\2\u015f\u0160\7P\2\2"+
		"\u0160\u0179\7F\2\2\u0161\u0162\7U\2\2\u0162\u0163\7G\2\2\u0163\u0164"+
		"\7T\2\2\u0164\u0165\7K\2\2\u0165\u0166\7G\2\2\u0166\u0167\7U\2\2\u0167"+
		"\u0168\7a\2\2\u0168\u0169\7N\2\2\u0169\u016a\7G\2\2\u016a\u016b\7I\2\2"+
		"\u016b\u016c\7G\2\2\u016c\u016d\7P\2\2\u016d\u0179\7F\2\2\u016e\u016f"+
		"\7V\2\2\u016f\u0170\7K\2\2\u0170\u0171\7O\2\2\u0171\u0172\7G\2\2\u0172"+
		"\u0173\7a\2\2\u0173\u0174\7U\2\2\u0174\u0175\7N\2\2\u0175\u0176\7K\2\2"+
		"\u0176\u0177\7E\2\2\u0177\u0179\7G\2\2\u0178\u0137\3\2\2\2\u0178\u013e"+
		"\3\2\2\2\u0178\u0145\3\2\2\2\u0178\u0151\3\2\2\2\u0178\u0161\3\2\2\2\u0178"+
		"\u016e\3\2\2\2\u0179*\3\2\2\2\u017a\u017b\7C\2\2\u017b\u017c\7N\2\2\u017c"+
		"\u017d\7N\2\2\u017d\u017e\7a\2\2\u017e\u017f\7K\2\2\u017f\u0180\7P\2\2"+
		"\u0180\u0181\7V\2\2\u0181\u0182\7T\2\2\u0182\u0183\7Q\2\2\u0183\u0184"+
		"\7F\2\2\u0184\u0185\7W\2\2\u0185\u0186\7E\2\2\u0186\u0187\7V\2\2\u0187"+
		"\u0188\7Q\2\2\u0188\u0189\7T\2\2\u0189\u018a\7[\2\2\u018a\u018b\7a\2\2"+
		"\u018b\u018c\7K\2\2\u018c\u018d\7P\2\2\u018d\u018e\7H\2\2\u018e\u018f"+
		"\7Q\2\2\u018f\u0190\7T\2\2\u0190\u0191\7O\2\2\u0191\u0192\7C\2\2\u0192"+
		"\u0193\7V\2\2\u0193\u0194\7K\2\2\u0194\u0195\7Q\2\2\u0195\u0196\7P\2\2"+
		"\u0196\u0197\7a\2\2\u0197\u0198\7R\2\2\u0198\u0199\7T\2\2\u0199\u019a"+
		"\7G\2\2\u019a\u019b\7U\2\2\u019b\u019c\7G\2\2\u019c\u019d\7P\2\2\u019d"+
		"\u0254\7V\2\2\u019e\u019f\7D\2\2\u019f\u01a0\7Q\2\2\u01a0\u01a1\7V\2\2"+
		"\u01a1\u01a2\7J\2\2\u01a2\u01a3\7a\2\2\u01a3\u01a4\7U\2\2\u01a4\u01a5"+
		"\7G\2\2\u01a5\u01a6\7T\2\2\u01a6\u01a7\7K\2\2\u01a7\u01a8\7G\2\2\u01a8"+
		"\u01a9\7U\2\2\u01a9\u01aa\7a\2\2\u01aa\u01ab\7J\2\2\u01ab\u01ac\7C\2\2"+
		"\u01ac\u01ad\7X\2\2\u01ad\u01ae\7G\2\2\u01ae\u01af\7a\2\2\u01af\u01b0"+
		"\7C\2\2\u01b0\u01b1\7N\2\2\u01b1\u01b2\7N\2\2\u01b2\u01b3\7a\2\2\u01b3"+
		"\u01b4\7U\2\2\u01b4\u01b5\7G\2\2\u01b5\u01b6\7I\2\2\u01b6\u01b7\7O\2\2"+
		"\u01b7\u01b8\7G\2\2\u01b8\u01b9\7P\2\2\u01b9\u01ba\7V\2\2\u01ba\u01bb"+
		"\7U\2\2\u01bb\u01bc\7a\2\2\u01bc\u01bd\7C\2\2\u01bd\u01be\7U\2\2\u01be"+
		"\u01bf\7E\2\2\u01bf\u01c0\7G\2\2\u01c0\u01c1\7P\2\2\u01c1\u01c2\7F\2\2"+
		"\u01c2\u01c3\7K\2\2\u01c3\u01c4\7P\2\2\u01c4\u0254\7I\2\2\u01c5\u01c6"+
		"\7D\2\2\u01c6\u01c7\7Q\2\2\u01c7\u01c8\7V\2\2\u01c8\u01c9\7J\2\2\u01c9"+
		"\u01ca\7a\2\2\u01ca\u01cb\7U\2\2\u01cb\u01cc\7G\2\2\u01cc\u01cd\7T\2\2"+
		"\u01cd\u01ce\7K\2\2\u01ce\u01cf\7G\2\2\u01cf\u01d0\7U\2\2\u01d0\u01d1"+
		"\7a\2\2\u01d1\u01d2\7J\2\2\u01d2\u01d3\7C\2\2\u01d3\u01d4\7X\2\2\u01d4"+
		"\u01d5\7G\2\2\u01d5\u01d6\7a\2\2\u01d6\u01d7\7C\2\2\u01d7\u01d8\7N\2\2"+
		"\u01d8\u01d9\7N\2\2\u01d9\u01da\7a\2\2\u01da\u01db\7U\2\2\u01db\u01dc"+
		"\7G\2\2\u01dc\u01dd\7I\2\2\u01dd\u01de\7O\2\2\u01de\u01df\7G\2\2\u01df"+
		"\u01e0\7P\2\2\u01e0\u01e1\7V\2\2\u01e1\u01e2\7U\2\2\u01e2\u01e3\7a\2\2"+
		"\u01e3\u01e4\7F\2\2\u01e4\u01e5\7G\2\2\u01e5\u01e6\7U\2\2\u01e6\u01e7"+
		"\7E\2\2\u01e7\u01e8\7G\2\2\u01e8\u01e9\7P\2\2\u01e9\u01ea\7F\2\2\u01ea"+
		"\u01eb\7K\2\2\u01eb\u01ec\7P\2\2\u01ec\u0254\7I\2\2\u01ed\u01ee\7D\2\2"+
		"\u01ee\u01ef\7Q\2\2\u01ef\u01f0\7V\2\2\u01f0\u01f1\7J\2\2\u01f1\u01f2"+
		"\7a\2\2\u01f2\u01f3\7U\2\2\u01f3\u01f4\7G\2\2\u01f4\u01f5\7T\2\2\u01f5"+
		"\u01f6\7K\2\2\u01f6\u01f7\7G\2\2\u01f7\u01f8\7U\2\2\u01f8\u01f9\7a\2\2"+
		"\u01f9\u01fa\7J\2\2\u01fa\u01fb\7C\2\2\u01fb\u01fc\7X\2\2\u01fc\u01fd"+
		"\7G\2\2\u01fd\u01fe\7a\2\2\u01fe\u01ff\7O\2\2\u01ff\u0200\7Q\2\2\u0200"+
		"\u0201\7U\2\2\u0201\u0202\7V\2\2\u0202\u0203\7a\2\2\u0203\u0204\7U\2\2"+
		"\u0204\u0205\7G\2\2\u0205\u0206\7I\2\2\u0206\u0207\7O\2\2\u0207\u0208"+
		"\7G\2\2\u0208\u0209\7P\2\2\u0209\u020a\7V\2\2\u020a\u020b\7U\2\2\u020b"+
		"\u020c\7a\2\2\u020c\u020d\7C\2\2\u020d\u020e\7U\2\2\u020e\u020f\7E\2\2"+
		"\u020f\u0210\7G\2\2\u0210\u0211\7P\2\2\u0211\u0212\7F\2\2\u0212\u0213"+
		"\7K\2\2\u0213\u0214\7P\2\2\u0214\u0254\7I\2\2\u0215\u0216\7D\2\2\u0216"+
		"\u0217\7Q\2\2\u0217\u0218\7V\2\2\u0218\u0219\7J\2\2\u0219\u021a\7a\2\2"+
		"\u021a\u021b\7U\2\2\u021b\u021c\7G\2\2\u021c\u021d\7T\2\2\u021d\u021e"+
		"\7K\2\2\u021e\u021f\7G\2\2\u021f\u0220\7U\2\2\u0220\u0221\7a\2\2\u0221"+
		"\u0222\7J\2\2\u0222\u0223\7C\2\2\u0223\u0224\7X\2\2\u0224\u0225\7G\2\2"+
		"\u0225\u0226\7a\2\2\u0226\u0227\7O\2\2\u0227\u0228\7Q\2\2\u0228\u0229"+
		"\7U\2\2\u0229\u022a\7V\2\2\u022a\u022b\7a\2\2\u022b\u022c\7U\2\2\u022c"+
		"\u022d\7G\2\2\u022d\u022e\7I\2\2\u022e\u022f\7O\2\2\u022f\u0230\7G\2\2"+
		"\u0230\u0231\7P\2\2\u0231\u0232\7V\2\2\u0232\u0233\7U\2\2\u0233\u0234"+
		"\7a\2\2\u0234\u0235\7F\2\2\u0235\u0236\7G\2\2\u0236\u0237\7U\2\2\u0237"+
		"\u0238\7E\2\2\u0238\u0239\7G\2\2\u0239\u023a\7P\2\2\u023a\u023b\7F\2\2"+
		"\u023b\u023c\7K\2\2\u023c\u023d\7P\2\2\u023d\u0254\7I\2\2\u023e\u023f"+
		"\7K\2\2\u023f\u0240\7F\2\2\u0240\u0241\7G\2\2\u0241\u0242\7P\2\2\u0242"+
		"\u0243\7V\2\2\u0243\u0244\7K\2\2\u0244\u0245\7E\2\2\u0245\u0246\7C\2\2"+
		"\u0246\u0247\7N\2\2\u0247\u0248\7a\2\2\u0248\u0249\7V\2\2\u0249\u024a"+
		"\7K\2\2\u024a\u024b\7O\2\2\u024b\u024c\7G\2\2\u024c\u024d\7a\2\2\u024d"+
		"\u024e\7U\2\2\u024e\u024f\7N\2\2\u024f\u0250\7K\2\2\u0250\u0251\7E\2\2"+
		"\u0251\u0252\7G\2\2\u0252\u0254\7U\2\2\u0253\u017a\3\2\2\2\u0253\u019e"+
		"\3\2\2\2\u0253\u01c5\3\2\2\2\u0253\u01ed\3\2\2\2\u0253\u0215\3\2\2\2\u0253"+
		"\u023e\3\2\2\2\u0254,\3\2\2\2\u0255\u0256\7R\2\2\u0256\u0257\7j\2\2\u0257"+
		"\u0258\7t\2\2\u0258\u0259\7c\2\2\u0259\u025a\7u\2\2\u025a\u025b\7g\2\2"+
		"\u025b\u025c\7U\2\2\u025c\u025d\7r\2\2\u025d\u025e\7g\2\2\u025e\u025f"+
		"\7e\2\2\u025f\u0260\7k\2\2\u0260\u0261\7h\2\2\u0261\u0262\7k\2\2\u0262"+
		"\u0263\7e\2\2\u0263\u0264\7c\2\2\u0264\u0265\7v\2\2\u0265\u0266\7k\2\2"+
		"\u0266\u0267\7q\2\2\u0267\u0268\7p\2\2\u0268.\3\2\2\2\u0269\u026a\7U\2"+
		"\2\u026a\u026b\7w\2\2\u026b\u026c\7d\2\2\u026c\u026d\7l\2\2\u026d\u026e"+
		"\7g\2\2\u026e\u026f\7e\2\2\u026f\u0270\7v\2\2\u0270\60\3\2\2\2\u0271\u0272"+
		"\7R\2\2\u0272\u0273\7t\2\2\u0273\u0274\7g\2\2\u0274\u0275\7f\2\2\u0275"+
		"\u0276\7k\2\2\u0276\u0277\7e\2\2\u0277\u0278\7c\2\2\u0278\u0279\7v\2\2"+
		"\u0279\u027a\7g\2\2\u027a\62\3\2\2\2\u027b\u027c\7H\2\2\u027c\u027d\7"+
		"g\2\2\u027d\u027e\7c\2\2\u027e\u027f\7v\2\2\u027f\u0280\7w\2\2\u0280\u0281"+
		"\7t\2\2\u0281\u0282\7g\2\2\u0282\u0283\7u\2\2\u0283\64\3\2\2\2\u0284\u0285"+
		"\7P\2\2\u0285\u0286\7Q\2\2\u0286\u0287\7W\2\2\u0287\u02d9\7P\2\2\u0288"+
		"\u0289\7R\2\2\u0289\u028a\7T\2\2\u028a\u028b\7Q\2\2\u028b\u028c\7P\2\2"+
		"\u028c\u028d\7Q\2\2\u028d\u028e\7W\2\2\u028e\u02d9\7P\2\2\u028f\u0290"+
		"\7C\2\2\u0290\u0291\7F\2\2\u0291\u0292\7L\2\2\u0292\u0293\7G\2\2\u0293"+
		"\u0294\7E\2\2\u0294\u0295\7V\2\2\u0295\u0296\7K\2\2\u0296\u0297\7X\2\2"+
		"\u0297\u02d9\7G\2\2\u0298\u0299\7F\2\2\u0299\u029a\7G\2\2\u029a\u029b"+
		"\7V\2\2\u029b\u029c\7G\2\2\u029c\u029d\7T\2\2\u029d\u029e\7O\2\2\u029e"+
		"\u029f\7K\2\2\u029f\u02a0\7P\2\2\u02a0\u02a1\7G\2\2\u02a1\u02d9\7T\2\2"+
		"\u02a2\u02a3\7X\2\2\u02a3\u02a4\7G\2\2\u02a4\u02a5\7T\2\2\u02a5\u02d9"+
		"\7D\2\2\u02a6\u02a7\7C\2\2\u02a7\u02a8\7F\2\2\u02a8\u02a9\7X\2\2\u02a9"+
		"\u02aa\7G\2\2\u02aa\u02ab\7T\2\2\u02ab\u02d9\7D\2\2\u02ac\u02ad\7R\2\2"+
		"\u02ad\u02ae\7T\2\2\u02ae\u02af\7G\2\2\u02af\u02b0\7R\2\2\u02b0\u02b1"+
		"\7Q\2\2\u02b1\u02b2\7U\2\2\u02b2\u02b3\7K\2\2\u02b3\u02b4\7V\2\2\u02b4"+
		"\u02b5\7K\2\2\u02b5\u02b6\7Q\2\2\u02b6\u02d9\7P\2\2\u02b7\u02b8\7E\2\2"+
		"\u02b8\u02b9\7Q\2\2\u02b9\u02ba\7P\2\2\u02ba\u02bb\7L\2\2\u02bb\u02bc"+
		"\7W\2\2\u02bc\u02bd\7P\2\2\u02bd\u02be\7E\2\2\u02be\u02bf\7V\2\2\u02bf"+
		"\u02c0\7K\2\2\u02c0\u02c1\7Q\2\2\u02c1\u02d9\7P\2\2\u02c2\u02c3\7K\2\2"+
		"\u02c3\u02c4\7P\2\2\u02c4\u02c5\7V\2\2\u02c5\u02c6\7G\2\2\u02c6\u02c7"+
		"\7T\2\2\u02c7\u02c8\7L\2\2\u02c8\u02c9\7G\2\2\u02c9\u02ca\7E\2\2\u02ca"+
		"\u02cb\7V\2\2\u02cb\u02cc\7K\2\2\u02cc\u02cd\7Q\2\2\u02cd\u02d9\7P\2\2"+
		"\u02ce\u02cf\7E\2\2\u02cf\u02d0\7Q\2\2\u02d0\u02d1\7O\2\2\u02d1\u02d2"+
		"\7R\2\2\u02d2\u02d3\7N\2\2\u02d3\u02d4\7G\2\2\u02d4\u02d5\7O\2\2\u02d5"+
		"\u02d6\7G\2\2\u02d6\u02d7\7P\2\2\u02d7\u02d9\7V\2\2\u02d8\u0284\3\2\2"+
		"\2\u02d8\u0288\3\2\2\2\u02d8\u028f\3\2\2\2\u02d8\u0298\3\2\2\2\u02d8\u02a2"+
		"\3\2\2\2\u02d8\u02a6\3\2\2\2\u02d8\u02ac\3\2\2\2\u02d8\u02b7\3\2\2\2\u02d8"+
		"\u02c2\3\2\2\2\u02d8\u02ce\3\2\2\2\u02d9\66\3\2\2\2\u02da\u02de\t\2\2"+
		"\2\u02db\u02dd\t\3\2\2\u02dc\u02db\3\2\2\2\u02dd\u02e0\3\2\2\2\u02de\u02dc"+
		"\3\2\2\2\u02de\u02df\3\2\2\2\u02df8\3\2\2\2\u02e0\u02de\3\2\2\2\u02e1"+
		"\u02e3\7\17\2\2\u02e2\u02e1\3\2\2\2\u02e2\u02e3\3\2\2\2\u02e3\u02e4\3"+
		"\2\2\2\u02e4\u02e5\7\f\2\2\u02e5:\3\2\2\2\u02e6\u02e8\t\4\2\2\u02e7\u02e6"+
		"\3\2\2\2\u02e8\u02e9\3\2\2\2\u02e9\u02e7\3\2\2\2\u02e9\u02ea\3\2\2\2\u02ea"+
		"\u02eb\3\2\2\2\u02eb\u02ec\b\36\2\2\u02ec<\3\2\2\2\u02ed\u02ee\7B\2\2"+
		"\u02ee\u02ef\7B\2\2\u02ef>\3\2\2\2\n\2\u0135\u0178\u0253\u02d8\u02de\u02e2"+
		"\u02e9\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}