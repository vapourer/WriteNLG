// Generated from Aggregation.g4 by ANTLR 4.7
package io.antlrgenerated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AggregationParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, AGGREGATION_CONCEPT_GROUP_NAME=2, AGGREGATION_CONCEPT_GROUP=3, 
		GLOBAL_CONCEPT=4, TIME_SERIES_CONCEPT=5, NEW_LINE=6;
	public static final int
		RULE_aggregationRules = 0, RULE_aggregationConceptGroup = 1, RULE_aggregationConceptGroupTitle = 2, 
		RULE_concepts = 3, RULE_concept = 4, RULE_globalConcept = 5, RULE_timeSeriesConcept = 6;
	public static final String[] ruleNames = {
		"aggregationRules", "aggregationConceptGroup", "aggregationConceptGroupTitle", 
		"concepts", "concept", "globalConcept", "timeSeriesConcept"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'AggregationConceptGroup'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "AGGREGATION_CONCEPT_GROUP_NAME", "AGGREGATION_CONCEPT_GROUP", 
		"GLOBAL_CONCEPT", "TIME_SERIES_CONCEPT", "NEW_LINE"
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

	@Override
	public String getGrammarFileName() { return "Aggregation.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AggregationParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class AggregationRulesContext extends ParserRuleContext {
		public List<AggregationConceptGroupContext> aggregationConceptGroup() {
			return getRuleContexts(AggregationConceptGroupContext.class);
		}
		public AggregationConceptGroupContext aggregationConceptGroup(int i) {
			return getRuleContext(AggregationConceptGroupContext.class,i);
		}
		public List<TerminalNode> NEW_LINE() { return getTokens(AggregationParser.NEW_LINE); }
		public TerminalNode NEW_LINE(int i) {
			return getToken(AggregationParser.NEW_LINE, i);
		}
		public AggregationRulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregationRules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AggregationListener ) ((AggregationListener)listener).enterAggregationRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AggregationListener ) ((AggregationListener)listener).exitAggregationRules(this);
		}
	}

	public final AggregationRulesContext aggregationRules() throws RecognitionException {
		AggregationRulesContext _localctx = new AggregationRulesContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_aggregationRules);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(14);
					aggregationConceptGroup();
					setState(15);
					match(NEW_LINE);
					}
					} 
				}
				setState(21);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(22);
			aggregationConceptGroup();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AggregationConceptGroupContext extends ParserRuleContext {
		public TerminalNode AGGREGATION_CONCEPT_GROUP_NAME() { return getToken(AggregationParser.AGGREGATION_CONCEPT_GROUP_NAME, 0); }
		public AggregationConceptGroupTitleContext aggregationConceptGroupTitle() {
			return getRuleContext(AggregationConceptGroupTitleContext.class,0);
		}
		public TerminalNode NEW_LINE() { return getToken(AggregationParser.NEW_LINE, 0); }
		public ConceptsContext concepts() {
			return getRuleContext(ConceptsContext.class,0);
		}
		public AggregationConceptGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregationConceptGroup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AggregationListener ) ((AggregationListener)listener).enterAggregationConceptGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AggregationListener ) ((AggregationListener)listener).exitAggregationConceptGroup(this);
		}
	}

	public final AggregationConceptGroupContext aggregationConceptGroup() throws RecognitionException {
		AggregationConceptGroupContext _localctx = new AggregationConceptGroupContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_aggregationConceptGroup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(AGGREGATION_CONCEPT_GROUP_NAME);
			setState(25);
			match(T__0);
			setState(26);
			aggregationConceptGroupTitle();
			setState(27);
			match(NEW_LINE);
			setState(28);
			concepts();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AggregationConceptGroupTitleContext extends ParserRuleContext {
		public TerminalNode AGGREGATION_CONCEPT_GROUP() { return getToken(AggregationParser.AGGREGATION_CONCEPT_GROUP, 0); }
		public AggregationConceptGroupTitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregationConceptGroupTitle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AggregationListener ) ((AggregationListener)listener).enterAggregationConceptGroupTitle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AggregationListener ) ((AggregationListener)listener).exitAggregationConceptGroupTitle(this);
		}
	}

	public final AggregationConceptGroupTitleContext aggregationConceptGroupTitle() throws RecognitionException {
		AggregationConceptGroupTitleContext _localctx = new AggregationConceptGroupTitleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_aggregationConceptGroupTitle);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(AGGREGATION_CONCEPT_GROUP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConceptsContext extends ParserRuleContext {
		public List<ConceptContext> concept() {
			return getRuleContexts(ConceptContext.class);
		}
		public ConceptContext concept(int i) {
			return getRuleContext(ConceptContext.class,i);
		}
		public List<TerminalNode> NEW_LINE() { return getTokens(AggregationParser.NEW_LINE); }
		public TerminalNode NEW_LINE(int i) {
			return getToken(AggregationParser.NEW_LINE, i);
		}
		public ConceptsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_concepts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AggregationListener ) ((AggregationListener)listener).enterConcepts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AggregationListener ) ((AggregationListener)listener).exitConcepts(this);
		}
	}

	public final ConceptsContext concepts() throws RecognitionException {
		ConceptsContext _localctx = new ConceptsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_concepts);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(32);
					concept();
					setState(33);
					match(NEW_LINE);
					}
					} 
				}
				setState(39);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(40);
			concept();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConceptContext extends ParserRuleContext {
		public GlobalConceptContext globalConcept() {
			return getRuleContext(GlobalConceptContext.class,0);
		}
		public TimeSeriesConceptContext timeSeriesConcept() {
			return getRuleContext(TimeSeriesConceptContext.class,0);
		}
		public ConceptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_concept; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AggregationListener ) ((AggregationListener)listener).enterConcept(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AggregationListener ) ((AggregationListener)listener).exitConcept(this);
		}
	}

	public final ConceptContext concept() throws RecognitionException {
		ConceptContext _localctx = new ConceptContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_concept);
		try {
			setState(44);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GLOBAL_CONCEPT:
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				globalConcept();
				}
				break;
			case TIME_SERIES_CONCEPT:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				timeSeriesConcept();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GlobalConceptContext extends ParserRuleContext {
		public TerminalNode GLOBAL_CONCEPT() { return getToken(AggregationParser.GLOBAL_CONCEPT, 0); }
		public GlobalConceptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalConcept; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AggregationListener ) ((AggregationListener)listener).enterGlobalConcept(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AggregationListener ) ((AggregationListener)listener).exitGlobalConcept(this);
		}
	}

	public final GlobalConceptContext globalConcept() throws RecognitionException {
		GlobalConceptContext _localctx = new GlobalConceptContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_globalConcept);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(GLOBAL_CONCEPT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TimeSeriesConceptContext extends ParserRuleContext {
		public TerminalNode TIME_SERIES_CONCEPT() { return getToken(AggregationParser.TIME_SERIES_CONCEPT, 0); }
		public TimeSeriesConceptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeSeriesConcept; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AggregationListener ) ((AggregationListener)listener).enterTimeSeriesConcept(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AggregationListener ) ((AggregationListener)listener).exitTimeSeriesConcept(this);
		}
	}

	public final TimeSeriesConceptContext timeSeriesConcept() throws RecognitionException {
		TimeSeriesConceptContext _localctx = new TimeSeriesConceptContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_timeSeriesConcept);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(TIME_SERIES_CONCEPT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\b\65\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\7\2\24\n\2\f"+
		"\2\16\2\27\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\7"+
		"\5&\n\5\f\5\16\5)\13\5\3\5\3\5\3\6\3\6\5\6/\n\6\3\7\3\7\3\b\3\b\3\b\2"+
		"\2\t\2\4\6\b\n\f\16\2\2\2\60\2\25\3\2\2\2\4\32\3\2\2\2\6 \3\2\2\2\b\'"+
		"\3\2\2\2\n.\3\2\2\2\f\60\3\2\2\2\16\62\3\2\2\2\20\21\5\4\3\2\21\22\7\b"+
		"\2\2\22\24\3\2\2\2\23\20\3\2\2\2\24\27\3\2\2\2\25\23\3\2\2\2\25\26\3\2"+
		"\2\2\26\30\3\2\2\2\27\25\3\2\2\2\30\31\5\4\3\2\31\3\3\2\2\2\32\33\7\4"+
		"\2\2\33\34\7\3\2\2\34\35\5\6\4\2\35\36\7\b\2\2\36\37\5\b\5\2\37\5\3\2"+
		"\2\2 !\7\5\2\2!\7\3\2\2\2\"#\5\n\6\2#$\7\b\2\2$&\3\2\2\2%\"\3\2\2\2&)"+
		"\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(*\3\2\2\2)\'\3\2\2\2*+\5\n\6\2+\t\3\2\2"+
		"\2,/\5\f\7\2-/\5\16\b\2.,\3\2\2\2.-\3\2\2\2/\13\3\2\2\2\60\61\7\6\2\2"+
		"\61\r\3\2\2\2\62\63\7\7\2\2\63\17\3\2\2\2\5\25\'.";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}