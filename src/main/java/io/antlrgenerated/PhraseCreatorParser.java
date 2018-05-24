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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, GLOBAL_CONCEPT=16, 
		TIME_SERIES_CONCEPT=17, AGGREGATION_CONCEPT=18, GLOBAL_CONCEPT_TYPE=19, 
		TIME_SERIES_CONCEPT_TYPE=20, AGGREGATION_CONCEPT_TYPE=21, PHRASE_SPECIFICATION=22, 
		SUBJECT=23, PREDICATE=24, FEATURES=25, PART_OF_SPEECH=26, STRING=27, NEW_LINE=28, 
		WHITE_SPACE=29, PLACE_HOLDER_MARKER=30;
	public static final int
		RULE_writeDocument = 0, RULE_concept = 1, RULE_globalConcept = 2, RULE_globalConceptType = 3, 
		RULE_timeSeriesConcept = 4, RULE_timeSeriesConceptType = 5, RULE_aggregationConcept = 6, 
		RULE_aggregationConceptType = 7, RULE_phraseSpecifications = 8, RULE_phraseSpecification = 9, 
		RULE_subject = 10, RULE_predicate = 11, RULE_assignments = 12, RULE_assignment = 13, 
		RULE_identifier = 14, RULE_expression = 15, RULE_features = 16, RULE_feature = 17, 
		RULE_tense = 18, RULE_tenseValue = 19, RULE_complementiser = 20, RULE_complementiserValue = 21, 
		RULE_conjunction = 22, RULE_conjunctionValue = 23, RULE_subjectNumber = 24, 
		RULE_verbNumber = 25, RULE_objectNumber = 26, RULE_complementNumber = 27, 
		RULE_numberValue = 28;
	public static final String[] ruleNames = {
		"writeDocument", "concept", "globalConcept", "globalConceptType", "timeSeriesConcept", 
		"timeSeriesConceptType", "aggregationConcept", "aggregationConceptType", 
		"phraseSpecifications", "phraseSpecification", "subject", "predicate", 
		"assignments", "assignment", "identifier", "expression", "features", "feature", 
		"tense", "tenseValue", "complementiser", "complementiserValue", "conjunction", 
		"conjunctionValue", "subjectNumber", "verbNumber", "objectNumber", "complementNumber", 
		"numberValue"
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
			setState(63);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(58);
					concept();
					setState(59);
					match(NEW_LINE);
					}
					} 
				}
				setState(65);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(66);
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
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GLOBAL_CONCEPT:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				globalConcept();
				}
				break;
			case TIME_SERIES_CONCEPT:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				timeSeriesConcept();
				}
				break;
			case AGGREGATION_CONCEPT:
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
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
			setState(73);
			match(GLOBAL_CONCEPT);
			setState(74);
			match(T__0);
			setState(75);
			globalConceptType();
			setState(76);
			match(NEW_LINE);
			setState(77);
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
			setState(79);
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
			setState(81);
			match(TIME_SERIES_CONCEPT);
			setState(82);
			match(T__0);
			setState(83);
			timeSeriesConceptType();
			setState(84);
			match(NEW_LINE);
			setState(85);
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
			setState(87);
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
			setState(89);
			match(AGGREGATION_CONCEPT);
			setState(90);
			match(T__0);
			setState(91);
			aggregationConceptType();
			setState(92);
			match(NEW_LINE);
			setState(93);
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
			setState(95);
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
			setState(102);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(97);
					phraseSpecification();
					setState(98);
					match(NEW_LINE);
					}
					} 
				}
				setState(104);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(105);
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
		public FeaturesContext features() {
			return getRuleContext(FeaturesContext.class,0);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(PHRASE_SPECIFICATION);
			setState(108);
			match(NEW_LINE);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FEATURES) {
				{
				setState(109);
				features();
				}
			}

			setState(112);
			subject();
			setState(113);
			match(NEW_LINE);
			setState(114);
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
		enterRule(_localctx, 20, RULE_subject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(SUBJECT);
			setState(117);
			match(NEW_LINE);
			setState(118);
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
		enterRule(_localctx, 22, RULE_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(PREDICATE);
			setState(121);
			match(NEW_LINE);
			setState(122);
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
		enterRule(_localctx, 24, RULE_assignments);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(124);
					assignment();
					setState(125);
					match(NEW_LINE);
					}
					} 
				}
				setState(131);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(132);
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
		enterRule(_localctx, 26, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			identifier();
			setState(135);
			match(T__1);
			setState(136);
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
		enterRule(_localctx, 28, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
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
		enterRule(_localctx, 30, RULE_expression);
		int _la;
		try {
			setState(151);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLACE_HOLDER_MARKER:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				match(PLACE_HOLDER_MARKER);
				setState(141);
				match(STRING);
				setState(142);
				match(PLACE_HOLDER_MARKER);
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(143);
					match(T__2);
					setState(144);
					match(STRING);
					}
					}
					setState(149);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				match(STRING);
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
		enterRule(_localctx, 32, RULE_features);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(FEATURES);
			setState(154);
			match(NEW_LINE);
			setState(156); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(155);
				feature();
				}
				}
				setState(158); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12))) != 0) );
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
		public SubjectNumberContext subjectNumber() {
			return getRuleContext(SubjectNumberContext.class,0);
		}
		public VerbNumberContext verbNumber() {
			return getRuleContext(VerbNumberContext.class,0);
		}
		public ObjectNumberContext objectNumber() {
			return getRuleContext(ObjectNumberContext.class,0);
		}
		public ComplementNumberContext complementNumber() {
			return getRuleContext(ComplementNumberContext.class,0);
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
		enterRule(_localctx, 34, RULE_feature);
		try {
			setState(181);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				complementiser();
				setState(161);
				match(NEW_LINE);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				tense();
				setState(164);
				match(NEW_LINE);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(166);
				conjunction();
				setState(167);
				match(NEW_LINE);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 4);
				{
				setState(169);
				subjectNumber();
				setState(170);
				match(NEW_LINE);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 5);
				{
				setState(172);
				verbNumber();
				setState(173);
				match(NEW_LINE);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 6);
				{
				setState(175);
				objectNumber();
				setState(176);
				match(NEW_LINE);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 7);
				{
				setState(178);
				complementNumber();
				setState(179);
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
		enterRule(_localctx, 36, RULE_tense);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(T__3);
			setState(184);
			match(T__0);
			setState(185);
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
		enterRule(_localctx, 38, RULE_tenseValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6))) != 0)) ) {
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
		enterRule(_localctx, 40, RULE_complementiser);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(T__7);
			setState(190);
			match(T__0);
			setState(191);
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
		enterRule(_localctx, 42, RULE_complementiserValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
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
		enterRule(_localctx, 44, RULE_conjunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(T__8);
			setState(196);
			match(T__0);
			setState(197);
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
		enterRule(_localctx, 46, RULE_conjunctionValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
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

	public static class SubjectNumberContext extends ParserRuleContext {
		public NumberValueContext numberValue() {
			return getRuleContext(NumberValueContext.class,0);
		}
		public SubjectNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subjectNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).enterSubjectNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).exitSubjectNumber(this);
		}
	}

	public final SubjectNumberContext subjectNumber() throws RecognitionException {
		SubjectNumberContext _localctx = new SubjectNumberContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_subjectNumber);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(T__9);
			setState(202);
			match(T__0);
			setState(203);
			numberValue();
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

	public static class VerbNumberContext extends ParserRuleContext {
		public NumberValueContext numberValue() {
			return getRuleContext(NumberValueContext.class,0);
		}
		public VerbNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verbNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).enterVerbNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).exitVerbNumber(this);
		}
	}

	public final VerbNumberContext verbNumber() throws RecognitionException {
		VerbNumberContext _localctx = new VerbNumberContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_verbNumber);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(T__10);
			setState(206);
			match(T__0);
			setState(207);
			numberValue();
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

	public static class ObjectNumberContext extends ParserRuleContext {
		public NumberValueContext numberValue() {
			return getRuleContext(NumberValueContext.class,0);
		}
		public ObjectNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).enterObjectNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).exitObjectNumber(this);
		}
	}

	public final ObjectNumberContext objectNumber() throws RecognitionException {
		ObjectNumberContext _localctx = new ObjectNumberContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_objectNumber);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(T__11);
			setState(210);
			match(T__0);
			setState(211);
			numberValue();
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

	public static class ComplementNumberContext extends ParserRuleContext {
		public NumberValueContext numberValue() {
			return getRuleContext(NumberValueContext.class,0);
		}
		public ComplementNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complementNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).enterComplementNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).exitComplementNumber(this);
		}
	}

	public final ComplementNumberContext complementNumber() throws RecognitionException {
		ComplementNumberContext _localctx = new ComplementNumberContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_complementNumber);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(T__12);
			setState(214);
			match(T__0);
			setState(215);
			numberValue();
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

	public static class NumberValueContext extends ParserRuleContext {
		public NumberValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).enterNumberValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).exitNumberValue(this);
		}
	}

	public final NumberValueContext numberValue() throws RecognitionException {
		NumberValueContext _localctx = new NumberValueContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_numberValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			_la = _input.LA(1);
			if ( !(_la==T__13 || _la==T__14) ) {
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3 \u00de\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\7\2@\n"+
		"\2\f\2\16\2C\13\2\3\2\3\2\3\3\3\3\3\3\5\3J\n\3\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\n\3\n\3\n\7\ng\n\n\f\n\16\nj\13\n\3\n\3\n\3\13\3\13\3\13\5\13q\n"+
		"\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\7\16\u0082\n\16\f\16\16\16\u0085\13\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\7\21\u0094\n\21\f\21\16\21\u0097\13"+
		"\21\3\21\5\21\u009a\n\21\3\22\3\22\3\22\6\22\u009f\n\22\r\22\16\22\u00a0"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00b8\n\23\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31"+
		"\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35"+
		"\3\35\3\35\3\36\3\36\3\36\2\2\37\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:\2\4\3\2\7\t\3\2\20\21\2\u00cf\2A\3\2\2\2\4I\3"+
		"\2\2\2\6K\3\2\2\2\bQ\3\2\2\2\nS\3\2\2\2\fY\3\2\2\2\16[\3\2\2\2\20a\3\2"+
		"\2\2\22h\3\2\2\2\24m\3\2\2\2\26v\3\2\2\2\30z\3\2\2\2\32\u0083\3\2\2\2"+
		"\34\u0088\3\2\2\2\36\u008c\3\2\2\2 \u0099\3\2\2\2\"\u009b\3\2\2\2$\u00b7"+
		"\3\2\2\2&\u00b9\3\2\2\2(\u00bd\3\2\2\2*\u00bf\3\2\2\2,\u00c3\3\2\2\2."+
		"\u00c5\3\2\2\2\60\u00c9\3\2\2\2\62\u00cb\3\2\2\2\64\u00cf\3\2\2\2\66\u00d3"+
		"\3\2\2\28\u00d7\3\2\2\2:\u00db\3\2\2\2<=\5\4\3\2=>\7\36\2\2>@\3\2\2\2"+
		"?<\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2CA\3\2\2\2DE\5\4\3\2"+
		"E\3\3\2\2\2FJ\5\6\4\2GJ\5\n\6\2HJ\5\16\b\2IF\3\2\2\2IG\3\2\2\2IH\3\2\2"+
		"\2J\5\3\2\2\2KL\7\22\2\2LM\7\3\2\2MN\5\b\5\2NO\7\36\2\2OP\5\22\n\2P\7"+
		"\3\2\2\2QR\7\25\2\2R\t\3\2\2\2ST\7\23\2\2TU\7\3\2\2UV\5\f\7\2VW\7\36\2"+
		"\2WX\5\22\n\2X\13\3\2\2\2YZ\7\26\2\2Z\r\3\2\2\2[\\\7\24\2\2\\]\7\3\2\2"+
		"]^\5\20\t\2^_\7\36\2\2_`\5\22\n\2`\17\3\2\2\2ab\7\27\2\2b\21\3\2\2\2c"+
		"d\5\24\13\2de\7\36\2\2eg\3\2\2\2fc\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2"+
		"\2ik\3\2\2\2jh\3\2\2\2kl\5\24\13\2l\23\3\2\2\2mn\7\30\2\2np\7\36\2\2o"+
		"q\5\"\22\2po\3\2\2\2pq\3\2\2\2qr\3\2\2\2rs\5\26\f\2st\7\36\2\2tu\5\30"+
		"\r\2u\25\3\2\2\2vw\7\31\2\2wx\7\36\2\2xy\5\32\16\2y\27\3\2\2\2z{\7\32"+
		"\2\2{|\7\36\2\2|}\5\32\16\2}\31\3\2\2\2~\177\5\34\17\2\177\u0080\7\36"+
		"\2\2\u0080\u0082\3\2\2\2\u0081~\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0086\3\2\2\2\u0085\u0083\3\2\2\2\u0086"+
		"\u0087\5\34\17\2\u0087\33\3\2\2\2\u0088\u0089\5\36\20\2\u0089\u008a\7"+
		"\4\2\2\u008a\u008b\5 \21\2\u008b\35\3\2\2\2\u008c\u008d\7\34\2\2\u008d"+
		"\37\3\2\2\2\u008e\u008f\7 \2\2\u008f\u0090\7\35\2\2\u0090\u0095\7 \2\2"+
		"\u0091\u0092\7\5\2\2\u0092\u0094\7\35\2\2\u0093\u0091\3\2\2\2\u0094\u0097"+
		"\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u009a\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0098\u009a\7\35\2\2\u0099\u008e\3\2\2\2\u0099\u0098\3"+
		"\2\2\2\u009a!\3\2\2\2\u009b\u009c\7\33\2\2\u009c\u009e\7\36\2\2\u009d"+
		"\u009f\5$\23\2\u009e\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u009e\3\2"+
		"\2\2\u00a0\u00a1\3\2\2\2\u00a1#\3\2\2\2\u00a2\u00a3\5*\26\2\u00a3\u00a4"+
		"\7\36\2\2\u00a4\u00b8\3\2\2\2\u00a5\u00a6\5&\24\2\u00a6\u00a7\7\36\2\2"+
		"\u00a7\u00b8\3\2\2\2\u00a8\u00a9\5.\30\2\u00a9\u00aa\7\36\2\2\u00aa\u00b8"+
		"\3\2\2\2\u00ab\u00ac\5\62\32\2\u00ac\u00ad\7\36\2\2\u00ad\u00b8\3\2\2"+
		"\2\u00ae\u00af\5\64\33\2\u00af\u00b0\7\36\2\2\u00b0\u00b8\3\2\2\2\u00b1"+
		"\u00b2\5\66\34\2\u00b2\u00b3\7\36\2\2\u00b3\u00b8\3\2\2\2\u00b4\u00b5"+
		"\58\35\2\u00b5\u00b6\7\36\2\2\u00b6\u00b8\3\2\2\2\u00b7\u00a2\3\2\2\2"+
		"\u00b7\u00a5\3\2\2\2\u00b7\u00a8\3\2\2\2\u00b7\u00ab\3\2\2\2\u00b7\u00ae"+
		"\3\2\2\2\u00b7\u00b1\3\2\2\2\u00b7\u00b4\3\2\2\2\u00b8%\3\2\2\2\u00b9"+
		"\u00ba\7\6\2\2\u00ba\u00bb\7\3\2\2\u00bb\u00bc\5(\25\2\u00bc\'\3\2\2\2"+
		"\u00bd\u00be\t\2\2\2\u00be)\3\2\2\2\u00bf\u00c0\7\n\2\2\u00c0\u00c1\7"+
		"\3\2\2\u00c1\u00c2\5,\27\2\u00c2+\3\2\2\2\u00c3\u00c4\7\35\2\2\u00c4-"+
		"\3\2\2\2\u00c5\u00c6\7\13\2\2\u00c6\u00c7\7\3\2\2\u00c7\u00c8\5\60\31"+
		"\2\u00c8/\3\2\2\2\u00c9\u00ca\7\35\2\2\u00ca\61\3\2\2\2\u00cb\u00cc\7"+
		"\f\2\2\u00cc\u00cd\7\3\2\2\u00cd\u00ce\5:\36\2\u00ce\63\3\2\2\2\u00cf"+
		"\u00d0\7\r\2\2\u00d0\u00d1\7\3\2\2\u00d1\u00d2\5:\36\2\u00d2\65\3\2\2"+
		"\2\u00d3\u00d4\7\16\2\2\u00d4\u00d5\7\3\2\2\u00d5\u00d6\5:\36\2\u00d6"+
		"\67\3\2\2\2\u00d7\u00d8\7\17\2\2\u00d8\u00d9\7\3\2\2\u00d9\u00da\5:\36"+
		"\2\u00da9\3\2\2\2\u00db\u00dc\t\3\2\2\u00dc;\3\2\2\2\13AIhp\u0083\u0095"+
		"\u0099\u00a0\u00b7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}