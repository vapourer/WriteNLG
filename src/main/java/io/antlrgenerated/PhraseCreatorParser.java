// Generated from PhraseCreator.g4 by ANTLR 4.7
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
public class PhraseCreatorParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		GLOBAL_CONCEPT=10, TIME_SERIES_CONCEPT=11, AGGREGATION_CONCEPT=12, GLOBAL_CONCEPT_TYPE=13, 
		TIME_SERIES_CONCEPT_TYPE=14, AGGREGATION_CONCEPT_TYPE=15, PHRASE_SPECIFICATION=16, 
		SUBJECT=17, PREDICATE=18, FEATURES=19, PART_OF_SPEECH=20, STRING=21, NEW_LINE=22, 
		WHITE_SPACE=23, PLACE_HOLDER_MARKER=24;
	public static final int
		RULE_writeDocument = 0, RULE_concept = 1, RULE_globalConcept = 2, RULE_globalConceptType = 3, 
		RULE_timeSeriesConcept = 4, RULE_timeSeriesConceptType = 5, RULE_aggregationConcept = 6, 
		RULE_aggregationConceptType = 7, RULE_phraseSpecifications = 8, RULE_phraseSpecification = 9, 
		RULE_features = 10, RULE_feature = 11, RULE_tense = 12, RULE_tenseValue = 13, 
		RULE_complementiser = 14, RULE_complementiserValue = 15, RULE_conjunction = 16, 
		RULE_conjunctionValue = 17, RULE_subject = 18, RULE_predicate = 19, RULE_assignments = 20, 
		RULE_assignment = 21, RULE_identifier = 22, RULE_expression = 23;
	public static final String[] ruleNames = {
		"writeDocument", "concept", "globalConcept", "globalConceptType", "timeSeriesConcept", 
		"timeSeriesConceptType", "aggregationConcept", "aggregationConceptType", 
		"phraseSpecifications", "phraseSpecification", "features", "feature", 
		"tense", "tenseValue", "complementiser", "complementiserValue", "conjunction", 
		"conjunctionValue", "subject", "predicate", "assignments", "assignment", 
		"identifier", "expression"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'tense'", "'present'", "'past'", "'future'", "'complementiser'", 
		"'conjunction'", "':'", "' '", "'GlobalConcept'", "'TimeSeriesConcept'", 
		"'AggregationConcept'", null, null, null, "'PhraseSpecification'", "'Subject'", 
		"'Predicate'", "'Features'", null, null, null, null, "'@@'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "GLOBAL_CONCEPT", 
		"TIME_SERIES_CONCEPT", "AGGREGATION_CONCEPT", "GLOBAL_CONCEPT_TYPE", "TIME_SERIES_CONCEPT_TYPE", 
		"AGGREGATION_CONCEPT_TYPE", "PHRASE_SPECIFICATION", "SUBJECT", "PREDICATE", 
		"FEATURES", "PART_OF_SPEECH", "STRING", "NEW_LINE", "WHITE_SPACE", "PLACE_HOLDER_MARKER"
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
	public String getGrammarFileName() { return "PhraseCreator.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PhraseCreatorParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class WriteDocumentContext extends ParserRuleContext {
		public List<ConceptContext> concept() {
			return getRuleContexts(ConceptContext.class);
		}
		public ConceptContext concept(int i) {
			return getRuleContext(ConceptContext.class,i);
		}
		public List<TerminalNode> NEW_LINE() { return getTokens(PhraseCreatorParser.NEW_LINE); }
		public TerminalNode NEW_LINE(int i) {
			return getToken(PhraseCreatorParser.NEW_LINE, i);
		}
		public WriteDocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeDocument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).enterWriteDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).exitWriteDocument(this);
		}
	}

	public final WriteDocumentContext writeDocument() throws RecognitionException {
		WriteDocumentContext _localctx = new WriteDocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_writeDocument);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(48);
					concept();
					setState(49);
					match(NEW_LINE);
					}
					} 
				}
				setState(55);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(56);
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
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).enterConcept(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).exitConcept(this);
		}
	}

	public final ConceptContext concept() throws RecognitionException {
		ConceptContext _localctx = new ConceptContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_concept);
		try {
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GLOBAL_CONCEPT:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				globalConcept();
				}
				break;
			case TIME_SERIES_CONCEPT:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				timeSeriesConcept();
				}
				break;
			case AGGREGATION_CONCEPT:
				enterOuterAlt(_localctx, 3);
				{
				setState(60);
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
		public TerminalNode GLOBAL_CONCEPT() { return getToken(PhraseCreatorParser.GLOBAL_CONCEPT, 0); }
		public GlobalConceptTypeContext globalConceptType() {
			return getRuleContext(GlobalConceptTypeContext.class,0);
		}
		public TerminalNode NEW_LINE() { return getToken(PhraseCreatorParser.NEW_LINE, 0); }
		public PhraseSpecificationsContext phraseSpecifications() {
			return getRuleContext(PhraseSpecificationsContext.class,0);
		}
		public GlobalConceptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalConcept; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).enterGlobalConcept(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).exitGlobalConcept(this);
		}
	}

	public final GlobalConceptContext globalConcept() throws RecognitionException {
		GlobalConceptContext _localctx = new GlobalConceptContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_globalConcept);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(GLOBAL_CONCEPT);
			setState(64);
			match(T__0);
			setState(65);
			globalConceptType();
			setState(66);
			match(NEW_LINE);
			setState(67);
			phraseSpecifications();
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
		public TerminalNode GLOBAL_CONCEPT_TYPE() { return getToken(PhraseCreatorParser.GLOBAL_CONCEPT_TYPE, 0); }
		public GlobalConceptTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalConceptType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).enterGlobalConceptType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).exitGlobalConceptType(this);
		}
	}

	public final GlobalConceptTypeContext globalConceptType() throws RecognitionException {
		GlobalConceptTypeContext _localctx = new GlobalConceptTypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_globalConceptType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
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
		public TerminalNode TIME_SERIES_CONCEPT() { return getToken(PhraseCreatorParser.TIME_SERIES_CONCEPT, 0); }
		public TimeSeriesConceptTypeContext timeSeriesConceptType() {
			return getRuleContext(TimeSeriesConceptTypeContext.class,0);
		}
		public TerminalNode NEW_LINE() { return getToken(PhraseCreatorParser.NEW_LINE, 0); }
		public PhraseSpecificationsContext phraseSpecifications() {
			return getRuleContext(PhraseSpecificationsContext.class,0);
		}
		public TimeSeriesConceptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeSeriesConcept; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).enterTimeSeriesConcept(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).exitTimeSeriesConcept(this);
		}
	}

	public final TimeSeriesConceptContext timeSeriesConcept() throws RecognitionException {
		TimeSeriesConceptContext _localctx = new TimeSeriesConceptContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_timeSeriesConcept);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(TIME_SERIES_CONCEPT);
			setState(72);
			match(T__0);
			setState(73);
			timeSeriesConceptType();
			setState(74);
			match(NEW_LINE);
			setState(75);
			phraseSpecifications();
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
		public TerminalNode TIME_SERIES_CONCEPT_TYPE() { return getToken(PhraseCreatorParser.TIME_SERIES_CONCEPT_TYPE, 0); }
		public TimeSeriesConceptTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeSeriesConceptType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).enterTimeSeriesConceptType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).exitTimeSeriesConceptType(this);
		}
	}

	public final TimeSeriesConceptTypeContext timeSeriesConceptType() throws RecognitionException {
		TimeSeriesConceptTypeContext _localctx = new TimeSeriesConceptTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_timeSeriesConceptType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
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
		public TerminalNode AGGREGATION_CONCEPT() { return getToken(PhraseCreatorParser.AGGREGATION_CONCEPT, 0); }
		public AggregationConceptTypeContext aggregationConceptType() {
			return getRuleContext(AggregationConceptTypeContext.class,0);
		}
		public TerminalNode NEW_LINE() { return getToken(PhraseCreatorParser.NEW_LINE, 0); }
		public PhraseSpecificationsContext phraseSpecifications() {
			return getRuleContext(PhraseSpecificationsContext.class,0);
		}
		public AggregationConceptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregationConcept; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).enterAggregationConcept(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).exitAggregationConcept(this);
		}
	}

	public final AggregationConceptContext aggregationConcept() throws RecognitionException {
		AggregationConceptContext _localctx = new AggregationConceptContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_aggregationConcept);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(AGGREGATION_CONCEPT);
			setState(80);
			match(T__0);
			setState(81);
			aggregationConceptType();
			setState(82);
			match(NEW_LINE);
			setState(83);
			phraseSpecifications();
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
		public TerminalNode AGGREGATION_CONCEPT_TYPE() { return getToken(PhraseCreatorParser.AGGREGATION_CONCEPT_TYPE, 0); }
		public AggregationConceptTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregationConceptType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).enterAggregationConceptType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).exitAggregationConceptType(this);
		}
	}

	public final AggregationConceptTypeContext aggregationConceptType() throws RecognitionException {
		AggregationConceptTypeContext _localctx = new AggregationConceptTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_aggregationConceptType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
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

	public static class PhraseSpecificationsContext extends ParserRuleContext {
		public List<PhraseSpecificationContext> phraseSpecification() {
			return getRuleContexts(PhraseSpecificationContext.class);
		}
		public PhraseSpecificationContext phraseSpecification(int i) {
			return getRuleContext(PhraseSpecificationContext.class,i);
		}
		public List<TerminalNode> NEW_LINE() { return getTokens(PhraseCreatorParser.NEW_LINE); }
		public TerminalNode NEW_LINE(int i) {
			return getToken(PhraseCreatorParser.NEW_LINE, i);
		}
		public PhraseSpecificationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phraseSpecifications; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).enterPhraseSpecifications(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).exitPhraseSpecifications(this);
		}
	}

	public final PhraseSpecificationsContext phraseSpecifications() throws RecognitionException {
		PhraseSpecificationsContext _localctx = new PhraseSpecificationsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_phraseSpecifications);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(87);
					phraseSpecification();
					setState(88);
					match(NEW_LINE);
					}
					} 
				}
				setState(94);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(95);
			phraseSpecification();
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

	public static class PhraseSpecificationContext extends ParserRuleContext {
		public TerminalNode PHRASE_SPECIFICATION() { return getToken(PhraseCreatorParser.PHRASE_SPECIFICATION, 0); }
		public List<TerminalNode> NEW_LINE() { return getTokens(PhraseCreatorParser.NEW_LINE); }
		public TerminalNode NEW_LINE(int i) {
			return getToken(PhraseCreatorParser.NEW_LINE, i);
		}
		public SubjectContext subject() {
			return getRuleContext(SubjectContext.class,0);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public List<FeaturesContext> features() {
			return getRuleContexts(FeaturesContext.class);
		}
		public FeaturesContext features(int i) {
			return getRuleContext(FeaturesContext.class,i);
		}
		public PhraseSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phraseSpecification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).enterPhraseSpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).exitPhraseSpecification(this);
		}
	}

	public final PhraseSpecificationContext phraseSpecification() throws RecognitionException {
		PhraseSpecificationContext _localctx = new PhraseSpecificationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_phraseSpecification);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(PHRASE_SPECIFICATION);
			setState(104);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(98);
					match(NEW_LINE);
					setState(100);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==FEATURES) {
						{
						setState(99);
						features();
						}
					}

					}
					} 
				}
				setState(106);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(107);
			match(NEW_LINE);
			setState(108);
			subject();
			setState(109);
			match(NEW_LINE);
			setState(110);
			predicate();
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

	public static class FeaturesContext extends ParserRuleContext {
		public TerminalNode FEATURES() { return getToken(PhraseCreatorParser.FEATURES, 0); }
		public TerminalNode NEW_LINE() { return getToken(PhraseCreatorParser.NEW_LINE, 0); }
		public List<FeatureContext> feature() {
			return getRuleContexts(FeatureContext.class);
		}
		public FeatureContext feature(int i) {
			return getRuleContext(FeatureContext.class,i);
		}
		public FeaturesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_features; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).enterFeatures(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).exitFeatures(this);
		}
	}

	public final FeaturesContext features() throws RecognitionException {
		FeaturesContext _localctx = new FeaturesContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_features);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(FEATURES);
			setState(113);
			match(NEW_LINE);
			setState(115); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(114);
				feature();
				}
				}
				setState(117); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__5) | (1L << T__6))) != 0) );
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

	public static class FeatureContext extends ParserRuleContext {
		public ComplementiserContext complementiser() {
			return getRuleContext(ComplementiserContext.class,0);
		}
		public TerminalNode NEW_LINE() { return getToken(PhraseCreatorParser.NEW_LINE, 0); }
		public TenseContext tense() {
			return getRuleContext(TenseContext.class,0);
		}
		public ConjunctionContext conjunction() {
			return getRuleContext(ConjunctionContext.class,0);
		}
		public FeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).enterFeature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).exitFeature(this);
		}
	}

	public final FeatureContext feature() throws RecognitionException {
		FeatureContext _localctx = new FeatureContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_feature);
		try {
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				complementiser();
				setState(120);
				match(NEW_LINE);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				tense();
				setState(123);
				match(NEW_LINE);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(125);
				conjunction();
				setState(126);
				match(NEW_LINE);
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

	public static class TenseContext extends ParserRuleContext {
		public TenseValueContext tenseValue() {
			return getRuleContext(TenseValueContext.class,0);
		}
		public TenseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tense; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).enterTense(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).exitTense(this);
		}
	}

	public final TenseContext tense() throws RecognitionException {
		TenseContext _localctx = new TenseContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_tense);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(T__1);
			setState(131);
			match(T__0);
			setState(132);
			tenseValue();
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

	public static class TenseValueContext extends ParserRuleContext {
		public TenseValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tenseValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).enterTenseValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).exitTenseValue(this);
		}
	}

	public final TenseValueContext tenseValue() throws RecognitionException {
		TenseValueContext _localctx = new TenseValueContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_tenseValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class ComplementiserContext extends ParserRuleContext {
		public ComplementiserValueContext complementiserValue() {
			return getRuleContext(ComplementiserValueContext.class,0);
		}
		public ComplementiserContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complementiser; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).enterComplementiser(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).exitComplementiser(this);
		}
	}

	public final ComplementiserContext complementiser() throws RecognitionException {
		ComplementiserContext _localctx = new ComplementiserContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_complementiser);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(T__5);
			setState(137);
			match(T__0);
			setState(138);
			complementiserValue();
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

	public static class ComplementiserValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(PhraseCreatorParser.STRING, 0); }
		public ComplementiserValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complementiserValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).enterComplementiserValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).exitComplementiserValue(this);
		}
	}

	public final ComplementiserValueContext complementiserValue() throws RecognitionException {
		ComplementiserValueContext _localctx = new ComplementiserValueContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_complementiserValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(STRING);
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

	public static class ConjunctionContext extends ParserRuleContext {
		public ConjunctionValueContext conjunctionValue() {
			return getRuleContext(ConjunctionValueContext.class,0);
		}
		public ConjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).enterConjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).exitConjunction(this);
		}
	}

	public final ConjunctionContext conjunction() throws RecognitionException {
		ConjunctionContext _localctx = new ConjunctionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_conjunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(T__6);
			setState(143);
			match(T__0);
			setState(144);
			conjunctionValue();
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

	public static class ConjunctionValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(PhraseCreatorParser.STRING, 0); }
		public ConjunctionValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjunctionValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).enterConjunctionValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).exitConjunctionValue(this);
		}
	}

	public final ConjunctionValueContext conjunctionValue() throws RecognitionException {
		ConjunctionValueContext _localctx = new ConjunctionValueContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_conjunctionValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(STRING);
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

	public static class SubjectContext extends ParserRuleContext {
		public TerminalNode SUBJECT() { return getToken(PhraseCreatorParser.SUBJECT, 0); }
		public TerminalNode NEW_LINE() { return getToken(PhraseCreatorParser.NEW_LINE, 0); }
		public AssignmentsContext assignments() {
			return getRuleContext(AssignmentsContext.class,0);
		}
		public SubjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subject; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).enterSubject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).exitSubject(this);
		}
	}

	public final SubjectContext subject() throws RecognitionException {
		SubjectContext _localctx = new SubjectContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_subject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(SUBJECT);
			setState(149);
			match(NEW_LINE);
			setState(150);
			assignments();
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

	public static class PredicateContext extends ParserRuleContext {
		public TerminalNode PREDICATE() { return getToken(PhraseCreatorParser.PREDICATE, 0); }
		public TerminalNode NEW_LINE() { return getToken(PhraseCreatorParser.NEW_LINE, 0); }
		public AssignmentsContext assignments() {
			return getRuleContext(AssignmentsContext.class,0);
		}
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).exitPredicate(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(PREDICATE);
			setState(153);
			match(NEW_LINE);
			setState(154);
			assignments();
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

	public static class AssignmentsContext extends ParserRuleContext {
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public List<TerminalNode> NEW_LINE() { return getTokens(PhraseCreatorParser.NEW_LINE); }
		public TerminalNode NEW_LINE(int i) {
			return getToken(PhraseCreatorParser.NEW_LINE, i);
		}
		public AssignmentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).enterAssignments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).exitAssignments(this);
		}
	}

	public final AssignmentsContext assignments() throws RecognitionException {
		AssignmentsContext _localctx = new AssignmentsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_assignments);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(156);
					assignment();
					setState(157);
					match(NEW_LINE);
					}
					} 
				}
				setState(163);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(164);
			assignment();
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

	public static class AssignmentContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			identifier();
			setState(167);
			match(T__7);
			setState(168);
			expression();
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

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode PART_OF_SPEECH() { return getToken(PhraseCreatorParser.PART_OF_SPEECH, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(PART_OF_SPEECH);
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

	public static class ExpressionContext extends ParserRuleContext {
		public List<TerminalNode> PLACE_HOLDER_MARKER() { return getTokens(PhraseCreatorParser.PLACE_HOLDER_MARKER); }
		public TerminalNode PLACE_HOLDER_MARKER(int i) {
			return getToken(PhraseCreatorParser.PLACE_HOLDER_MARKER, i);
		}
		public List<TerminalNode> STRING() { return getTokens(PhraseCreatorParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(PhraseCreatorParser.STRING, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_expression);
		int _la;
		try {
			setState(193);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				match(PLACE_HOLDER_MARKER);
				setState(173);
				match(STRING);
				setState(174);
				match(PLACE_HOLDER_MARKER);
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(175);
					match(T__8);
					setState(176);
					match(STRING);
					}
					}
					setState(181);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==STRING) {
					{
					{
					setState(182);
					match(STRING);
					setState(183);
					match(T__8);
					}
					}
					setState(188);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(189);
				match(PLACE_HOLDER_MARKER);
				setState(190);
				match(STRING);
				setState(191);
				match(PLACE_HOLDER_MARKER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
				match(STRING);
				}
				break;
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\32\u00c6\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\3\2\7\2\66\n\2\f\2\16\29\13\2\3\2\3\2\3\3\3\3\3\3\5\3@\n\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\7\n]\n\n\f\n\16\n`\13\n\3\n\3\n\3"+
		"\13\3\13\3\13\5\13g\n\13\7\13i\n\13\f\13\16\13l\13\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\6\fv\n\f\r\f\16\fw\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\5\r\u0083\n\r\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\7\26\u00a2\n\26\f\26\16\26\u00a5\13\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\3\31\7\31\u00b4"+
		"\n\31\f\31\16\31\u00b7\13\31\3\31\3\31\7\31\u00bb\n\31\f\31\16\31\u00be"+
		"\13\31\3\31\3\31\3\31\3\31\5\31\u00c4\n\31\3\31\2\2\32\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\2\3\3\2\5\7\2\u00bb\2\67\3\2\2\2"+
		"\4?\3\2\2\2\6A\3\2\2\2\bG\3\2\2\2\nI\3\2\2\2\fO\3\2\2\2\16Q\3\2\2\2\20"+
		"W\3\2\2\2\22^\3\2\2\2\24c\3\2\2\2\26r\3\2\2\2\30\u0082\3\2\2\2\32\u0084"+
		"\3\2\2\2\34\u0088\3\2\2\2\36\u008a\3\2\2\2 \u008e\3\2\2\2\"\u0090\3\2"+
		"\2\2$\u0094\3\2\2\2&\u0096\3\2\2\2(\u009a\3\2\2\2*\u00a3\3\2\2\2,\u00a8"+
		"\3\2\2\2.\u00ac\3\2\2\2\60\u00c3\3\2\2\2\62\63\5\4\3\2\63\64\7\30\2\2"+
		"\64\66\3\2\2\2\65\62\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28:\3"+
		"\2\2\29\67\3\2\2\2:;\5\4\3\2;\3\3\2\2\2<@\5\6\4\2=@\5\n\6\2>@\5\16\b\2"+
		"?<\3\2\2\2?=\3\2\2\2?>\3\2\2\2@\5\3\2\2\2AB\7\f\2\2BC\7\3\2\2CD\5\b\5"+
		"\2DE\7\30\2\2EF\5\22\n\2F\7\3\2\2\2GH\7\17\2\2H\t\3\2\2\2IJ\7\r\2\2JK"+
		"\7\3\2\2KL\5\f\7\2LM\7\30\2\2MN\5\22\n\2N\13\3\2\2\2OP\7\20\2\2P\r\3\2"+
		"\2\2QR\7\16\2\2RS\7\3\2\2ST\5\20\t\2TU\7\30\2\2UV\5\22\n\2V\17\3\2\2\2"+
		"WX\7\21\2\2X\21\3\2\2\2YZ\5\24\13\2Z[\7\30\2\2[]\3\2\2\2\\Y\3\2\2\2]`"+
		"\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_a\3\2\2\2`^\3\2\2\2ab\5\24\13\2b\23\3\2"+
		"\2\2cj\7\22\2\2df\7\30\2\2eg\5\26\f\2fe\3\2\2\2fg\3\2\2\2gi\3\2\2\2hd"+
		"\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2km\3\2\2\2lj\3\2\2\2mn\7\30\2\2"+
		"no\5&\24\2op\7\30\2\2pq\5(\25\2q\25\3\2\2\2rs\7\25\2\2su\7\30\2\2tv\5"+
		"\30\r\2ut\3\2\2\2vw\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\27\3\2\2\2yz\5\36\20"+
		"\2z{\7\30\2\2{\u0083\3\2\2\2|}\5\32\16\2}~\7\30\2\2~\u0083\3\2\2\2\177"+
		"\u0080\5\"\22\2\u0080\u0081\7\30\2\2\u0081\u0083\3\2\2\2\u0082y\3\2\2"+
		"\2\u0082|\3\2\2\2\u0082\177\3\2\2\2\u0083\31\3\2\2\2\u0084\u0085\7\4\2"+
		"\2\u0085\u0086\7\3\2\2\u0086\u0087\5\34\17\2\u0087\33\3\2\2\2\u0088\u0089"+
		"\t\2\2\2\u0089\35\3\2\2\2\u008a\u008b\7\b\2\2\u008b\u008c\7\3\2\2\u008c"+
		"\u008d\5 \21\2\u008d\37\3\2\2\2\u008e\u008f\7\27\2\2\u008f!\3\2\2\2\u0090"+
		"\u0091\7\t\2\2\u0091\u0092\7\3\2\2\u0092\u0093\5$\23\2\u0093#\3\2\2\2"+
		"\u0094\u0095\7\27\2\2\u0095%\3\2\2\2\u0096\u0097\7\23\2\2\u0097\u0098"+
		"\7\30\2\2\u0098\u0099\5*\26\2\u0099\'\3\2\2\2\u009a\u009b\7\24\2\2\u009b"+
		"\u009c\7\30\2\2\u009c\u009d\5*\26\2\u009d)\3\2\2\2\u009e\u009f\5,\27\2"+
		"\u009f\u00a0\7\30\2\2\u00a0\u00a2\3\2\2\2\u00a1\u009e\3\2\2\2\u00a2\u00a5"+
		"\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5"+
		"\u00a3\3\2\2\2\u00a6\u00a7\5,\27\2\u00a7+\3\2\2\2\u00a8\u00a9\5.\30\2"+
		"\u00a9\u00aa\7\n\2\2\u00aa\u00ab\5\60\31\2\u00ab-\3\2\2\2\u00ac\u00ad"+
		"\7\26\2\2\u00ad/\3\2\2\2\u00ae\u00af\7\32\2\2\u00af\u00b0\7\27\2\2\u00b0"+
		"\u00b5\7\32\2\2\u00b1\u00b2\7\13\2\2\u00b2\u00b4\7\27\2\2\u00b3\u00b1"+
		"\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6"+
		"\u00c4\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00b9\7\27\2\2\u00b9\u00bb\7"+
		"\13\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc"+
		"\u00bd\3\2\2\2\u00bd\u00bf\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c0\7\32"+
		"\2\2\u00c0\u00c1\7\27\2\2\u00c1\u00c4\7\32\2\2\u00c2\u00c4\7\27\2\2\u00c3"+
		"\u00ae\3\2\2\2\u00c3\u00bc\3\2\2\2\u00c3\u00c2\3\2\2\2\u00c4\61\3\2\2"+
		"\2\r\67?^fjw\u0082\u00a3\u00b5\u00bc\u00c3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}