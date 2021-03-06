// Generated from Constraints.g4 by ANTLR 4.7
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
public class ConstraintsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, GLOBAL_CONCEPT=4, TIME_SERIES_CONCEPT=5, AGGREGATION_CONCEPT=6, 
		GLOBAL_CONCEPT_TYPE=7, TIME_SERIES_CONCEPT_TYPE=8, AGGREGATION_CONCEPT_TYPE=9, 
		CONSTRAINT_NAME=10, INITIAL_VALUE=11, WEIGHTING=12, STRING=13, DIGIT=14, 
		NEW_LINE=15, WHITE_SPACE=16;
	public static final int
		RULE_constraintConfiguration = 0, RULE_concept = 1, RULE_globalConcept = 2, 
		RULE_globalConceptType = 3, RULE_timeSeriesConcept = 4, RULE_timeSeriesConceptType = 5, 
		RULE_aggregationConcept = 6, RULE_aggregationConceptType = 7, RULE_constraints = 8, 
		RULE_constraint = 9, RULE_constraintName = 10, RULE_initialValue = 11, 
		RULE_weighting = 12;
	public static final String[] ruleNames = {
		"constraintConfiguration", "concept", "globalConcept", "globalConceptType", 
		"timeSeriesConcept", "timeSeriesConceptType", "aggregationConcept", "aggregationConceptType", 
		"constraints", "constraint", "constraintName", "initialValue", "weighting"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'('", "')'", "'GlobalConcept'", "'TimeSeriesConcept'", "'AggregationConcept'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "GLOBAL_CONCEPT", "TIME_SERIES_CONCEPT", "AGGREGATION_CONCEPT", 
		"GLOBAL_CONCEPT_TYPE", "TIME_SERIES_CONCEPT_TYPE", "AGGREGATION_CONCEPT_TYPE", 
		"CONSTRAINT_NAME", "INITIAL_VALUE", "WEIGHTING", "STRING", "DIGIT", "NEW_LINE", 
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

	@Override
	public String getGrammarFileName() { return "Constraints.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ConstraintsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ConstraintConfigurationContext extends ParserRuleContext {
		public List<ConceptContext> concept() {
			return getRuleContexts(ConceptContext.class);
		}
		public ConceptContext concept(int i) {
			return getRuleContext(ConceptContext.class,i);
		}
		public List<TerminalNode> NEW_LINE() { return getTokens(ConstraintsParser.NEW_LINE); }
		public TerminalNode NEW_LINE(int i) {
			return getToken(ConstraintsParser.NEW_LINE, i);
		}
		public ConstraintConfigurationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraintConfiguration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintsListener ) ((ConstraintsListener)listener).enterConstraintConfiguration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintsListener ) ((ConstraintsListener)listener).exitConstraintConfiguration(this);
		}
	}

	public final ConstraintConfigurationContext constraintConfiguration() throws RecognitionException {
		ConstraintConfigurationContext _localctx = new ConstraintConfigurationContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_constraintConfiguration);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(26);
					concept();
					setState(27);
					match(NEW_LINE);
					}
					} 
				}
				setState(33);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(34);
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
		public AggregationConceptContext aggregationConcept() {
			return getRuleContext(AggregationConceptContext.class,0);
		}
		public ConceptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_concept; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintsListener ) ((ConstraintsListener)listener).enterConcept(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintsListener ) ((ConstraintsListener)listener).exitConcept(this);
		}
	}

	public final ConceptContext concept() throws RecognitionException {
		ConceptContext _localctx = new ConceptContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_concept);
		try {
			setState(39);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GLOBAL_CONCEPT:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				globalConcept();
				}
				break;
			case TIME_SERIES_CONCEPT:
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				timeSeriesConcept();
				}
				break;
			case AGGREGATION_CONCEPT:
				enterOuterAlt(_localctx, 3);
				{
				setState(38);
				aggregationConcept();
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
		public TerminalNode GLOBAL_CONCEPT() { return getToken(ConstraintsParser.GLOBAL_CONCEPT, 0); }
		public GlobalConceptTypeContext globalConceptType() {
			return getRuleContext(GlobalConceptTypeContext.class,0);
		}
		public TerminalNode NEW_LINE() { return getToken(ConstraintsParser.NEW_LINE, 0); }
		public ConstraintsContext constraints() {
			return getRuleContext(ConstraintsContext.class,0);
		}
		public GlobalConceptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalConcept; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintsListener ) ((ConstraintsListener)listener).enterGlobalConcept(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintsListener ) ((ConstraintsListener)listener).exitGlobalConcept(this);
		}
	}

	public final GlobalConceptContext globalConcept() throws RecognitionException {
		GlobalConceptContext _localctx = new GlobalConceptContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_globalConcept);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(GLOBAL_CONCEPT);
			setState(42);
			match(T__0);
			setState(43);
			globalConceptType();
			setState(44);
			match(NEW_LINE);
			setState(45);
			constraints();
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

	public static class GlobalConceptTypeContext extends ParserRuleContext {
		public TerminalNode GLOBAL_CONCEPT_TYPE() { return getToken(ConstraintsParser.GLOBAL_CONCEPT_TYPE, 0); }
		public GlobalConceptTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalConceptType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintsListener ) ((ConstraintsListener)listener).enterGlobalConceptType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintsListener ) ((ConstraintsListener)listener).exitGlobalConceptType(this);
		}
	}

	public final GlobalConceptTypeContext globalConceptType() throws RecognitionException {
		GlobalConceptTypeContext _localctx = new GlobalConceptTypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_globalConceptType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(GLOBAL_CONCEPT_TYPE);
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
		public TerminalNode TIME_SERIES_CONCEPT() { return getToken(ConstraintsParser.TIME_SERIES_CONCEPT, 0); }
		public TimeSeriesConceptTypeContext timeSeriesConceptType() {
			return getRuleContext(TimeSeriesConceptTypeContext.class,0);
		}
		public TerminalNode NEW_LINE() { return getToken(ConstraintsParser.NEW_LINE, 0); }
		public ConstraintsContext constraints() {
			return getRuleContext(ConstraintsContext.class,0);
		}
		public TimeSeriesConceptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeSeriesConcept; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintsListener ) ((ConstraintsListener)listener).enterTimeSeriesConcept(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintsListener ) ((ConstraintsListener)listener).exitTimeSeriesConcept(this);
		}
	}

	public final TimeSeriesConceptContext timeSeriesConcept() throws RecognitionException {
		TimeSeriesConceptContext _localctx = new TimeSeriesConceptContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_timeSeriesConcept);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(TIME_SERIES_CONCEPT);
			setState(50);
			match(T__0);
			setState(51);
			timeSeriesConceptType();
			setState(52);
			match(NEW_LINE);
			setState(53);
			constraints();
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

	public static class TimeSeriesConceptTypeContext extends ParserRuleContext {
		public TerminalNode TIME_SERIES_CONCEPT_TYPE() { return getToken(ConstraintsParser.TIME_SERIES_CONCEPT_TYPE, 0); }
		public TimeSeriesConceptTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeSeriesConceptType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintsListener ) ((ConstraintsListener)listener).enterTimeSeriesConceptType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintsListener ) ((ConstraintsListener)listener).exitTimeSeriesConceptType(this);
		}
	}

	public final TimeSeriesConceptTypeContext timeSeriesConceptType() throws RecognitionException {
		TimeSeriesConceptTypeContext _localctx = new TimeSeriesConceptTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_timeSeriesConceptType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(TIME_SERIES_CONCEPT_TYPE);
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

	public static class AggregationConceptContext extends ParserRuleContext {
		public TerminalNode AGGREGATION_CONCEPT() { return getToken(ConstraintsParser.AGGREGATION_CONCEPT, 0); }
		public AggregationConceptTypeContext aggregationConceptType() {
			return getRuleContext(AggregationConceptTypeContext.class,0);
		}
		public TerminalNode NEW_LINE() { return getToken(ConstraintsParser.NEW_LINE, 0); }
		public ConstraintsContext constraints() {
			return getRuleContext(ConstraintsContext.class,0);
		}
		public AggregationConceptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregationConcept; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintsListener ) ((ConstraintsListener)listener).enterAggregationConcept(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintsListener ) ((ConstraintsListener)listener).exitAggregationConcept(this);
		}
	}

	public final AggregationConceptContext aggregationConcept() throws RecognitionException {
		AggregationConceptContext _localctx = new AggregationConceptContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_aggregationConcept);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(AGGREGATION_CONCEPT);
			setState(58);
			match(T__0);
			setState(59);
			aggregationConceptType();
			setState(60);
			match(NEW_LINE);
			setState(61);
			constraints();
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

	public static class AggregationConceptTypeContext extends ParserRuleContext {
		public TerminalNode AGGREGATION_CONCEPT_TYPE() { return getToken(ConstraintsParser.AGGREGATION_CONCEPT_TYPE, 0); }
		public AggregationConceptTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregationConceptType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintsListener ) ((ConstraintsListener)listener).enterAggregationConceptType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintsListener ) ((ConstraintsListener)listener).exitAggregationConceptType(this);
		}
	}

	public final AggregationConceptTypeContext aggregationConceptType() throws RecognitionException {
		AggregationConceptTypeContext _localctx = new AggregationConceptTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_aggregationConceptType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(AGGREGATION_CONCEPT_TYPE);
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

	public static class ConstraintsContext extends ParserRuleContext {
		public List<ConstraintContext> constraint() {
			return getRuleContexts(ConstraintContext.class);
		}
		public ConstraintContext constraint(int i) {
			return getRuleContext(ConstraintContext.class,i);
		}
		public List<TerminalNode> NEW_LINE() { return getTokens(ConstraintsParser.NEW_LINE); }
		public TerminalNode NEW_LINE(int i) {
			return getToken(ConstraintsParser.NEW_LINE, i);
		}
		public ConstraintsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraints; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintsListener ) ((ConstraintsListener)listener).enterConstraints(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintsListener ) ((ConstraintsListener)listener).exitConstraints(this);
		}
	}

	public final ConstraintsContext constraints() throws RecognitionException {
		ConstraintsContext _localctx = new ConstraintsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_constraints);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(65);
					constraint();
					setState(66);
					match(NEW_LINE);
					}
					} 
				}
				setState(72);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(73);
			constraint();
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

	public static class ConstraintContext extends ParserRuleContext {
		public ConstraintNameContext constraintName() {
			return getRuleContext(ConstraintNameContext.class,0);
		}
		public InitialValueContext initialValue() {
			return getRuleContext(InitialValueContext.class,0);
		}
		public WeightingContext weighting() {
			return getRuleContext(WeightingContext.class,0);
		}
		public ConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintsListener ) ((ConstraintsListener)listener).enterConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintsListener ) ((ConstraintsListener)listener).exitConstraint(this);
		}
	}

	public final ConstraintContext constraint() throws RecognitionException {
		ConstraintContext _localctx = new ConstraintContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			constraintName();
			setState(76);
			match(T__0);
			setState(77);
			initialValue();
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(78);
				match(T__1);
				setState(79);
				weighting();
				setState(80);
				match(T__2);
				}
			}

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

	public static class ConstraintNameContext extends ParserRuleContext {
		public TerminalNode CONSTRAINT_NAME() { return getToken(ConstraintsParser.CONSTRAINT_NAME, 0); }
		public ConstraintNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraintName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintsListener ) ((ConstraintsListener)listener).enterConstraintName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintsListener ) ((ConstraintsListener)listener).exitConstraintName(this);
		}
	}

	public final ConstraintNameContext constraintName() throws RecognitionException {
		ConstraintNameContext _localctx = new ConstraintNameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_constraintName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(CONSTRAINT_NAME);
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

	public static class InitialValueContext extends ParserRuleContext {
		public TerminalNode INITIAL_VALUE() { return getToken(ConstraintsParser.INITIAL_VALUE, 0); }
		public InitialValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initialValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintsListener ) ((ConstraintsListener)listener).enterInitialValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintsListener ) ((ConstraintsListener)listener).exitInitialValue(this);
		}
	}

	public final InitialValueContext initialValue() throws RecognitionException {
		InitialValueContext _localctx = new InitialValueContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_initialValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(INITIAL_VALUE);
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

	public static class WeightingContext extends ParserRuleContext {
		public TerminalNode WEIGHTING() { return getToken(ConstraintsParser.WEIGHTING, 0); }
		public WeightingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weighting; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintsListener ) ((ConstraintsListener)listener).enterWeighting(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintsListener ) ((ConstraintsListener)listener).exitWeighting(this);
		}
	}

	public final WeightingContext weighting() throws RecognitionException {
		WeightingContext _localctx = new WeightingContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_weighting);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(WEIGHTING);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\22]\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\7\2 \n\2\f\2\16\2#\13\2\3\2\3\2\3"+
		"\3\3\3\3\3\5\3*\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\7\nG\n\n\f"+
		"\n\16\nJ\13\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13U\n\13\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\16\2\2\17\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\2\2\2T\2!\3\2\2\2\4)\3\2\2\2\6+\3\2\2\2\b\61\3\2\2\2\n\63\3\2\2\2\f9"+
		"\3\2\2\2\16;\3\2\2\2\20A\3\2\2\2\22H\3\2\2\2\24M\3\2\2\2\26V\3\2\2\2\30"+
		"X\3\2\2\2\32Z\3\2\2\2\34\35\5\4\3\2\35\36\7\21\2\2\36 \3\2\2\2\37\34\3"+
		"\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"$\3\2\2\2#!\3\2\2\2$%\5\4\3\2"+
		"%\3\3\2\2\2&*\5\6\4\2\'*\5\n\6\2(*\5\16\b\2)&\3\2\2\2)\'\3\2\2\2)(\3\2"+
		"\2\2*\5\3\2\2\2+,\7\6\2\2,-\7\3\2\2-.\5\b\5\2./\7\21\2\2/\60\5\22\n\2"+
		"\60\7\3\2\2\2\61\62\7\t\2\2\62\t\3\2\2\2\63\64\7\7\2\2\64\65\7\3\2\2\65"+
		"\66\5\f\7\2\66\67\7\21\2\2\678\5\22\n\28\13\3\2\2\29:\7\n\2\2:\r\3\2\2"+
		"\2;<\7\b\2\2<=\7\3\2\2=>\5\20\t\2>?\7\21\2\2?@\5\22\n\2@\17\3\2\2\2AB"+
		"\7\13\2\2B\21\3\2\2\2CD\5\24\13\2DE\7\21\2\2EG\3\2\2\2FC\3\2\2\2GJ\3\2"+
		"\2\2HF\3\2\2\2HI\3\2\2\2IK\3\2\2\2JH\3\2\2\2KL\5\24\13\2L\23\3\2\2\2M"+
		"N\5\26\f\2NO\7\3\2\2OT\5\30\r\2PQ\7\4\2\2QR\5\32\16\2RS\7\5\2\2SU\3\2"+
		"\2\2TP\3\2\2\2TU\3\2\2\2U\25\3\2\2\2VW\7\f\2\2W\27\3\2\2\2XY\7\r\2\2Y"+
		"\31\3\2\2\2Z[\7\16\2\2[\33\3\2\2\2\6!)HT";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}