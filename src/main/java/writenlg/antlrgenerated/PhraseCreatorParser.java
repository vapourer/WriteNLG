// Generated from PhraseCreator.g4 by ANTLR 4.7
package writenlg.antlrgenerated;
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
		T__0=1, T__1=2, GLOBAL_CONCEPT=3, TIME_SERIES_CONCEPT=4, GLOBAL_CONCEPT_TYPE=5, 
		TIME_SERIES_CONCEPT_TYPE=6, PHRASE_SPECIFICATION=7, SUBJECT=8, PREDICATE=9, 
		PART_OF_SPEECH=10, STRING=11, NEW_LINE=12, WHITE_SPACE=13, PLACE_HOLDER_MARKER=14;
	public static final int
		RULE_writeDocument = 0, RULE_concept = 1, RULE_globalConcept = 2, RULE_globalConceptType = 3, 
		RULE_timeSeriesConcept = 4, RULE_timeSeriesConceptType = 5, RULE_phraseSpecifications = 6, 
		RULE_phraseSpecification = 7, RULE_constraint = 8, RULE_subject = 9, RULE_predicate = 10, 
		RULE_assignments = 11, RULE_assignment = 12, RULE_identifier = 13, RULE_expression = 14;
	public static final String[] ruleNames = {
		"writeDocument", "concept", "globalConcept", "globalConceptType", "timeSeriesConcept", 
		"timeSeriesConceptType", "phraseSpecifications", "phraseSpecification", 
		"constraint", "subject", "predicate", "assignments", "assignment", "identifier", 
		"expression"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "':'", "'GlobalConcept'", "'TimeSeriesConcept'", null, null, 
		"'PhraseSpecification'", "'Subject'", "'Predicate'", null, null, null, 
		null, "'@@'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "GLOBAL_CONCEPT", "TIME_SERIES_CONCEPT", "GLOBAL_CONCEPT_TYPE", 
		"TIME_SERIES_CONCEPT_TYPE", "PHRASE_SPECIFICATION", "SUBJECT", "PREDICATE", 
		"PART_OF_SPEECH", "STRING", "NEW_LINE", "WHITE_SPACE", "PLACE_HOLDER_MARKER"
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
			setState(35);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(30);
					concept();
					setState(31);
					match(NEW_LINE);
					}
					} 
				}
				setState(37);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(38);
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
			setState(42);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GLOBAL_CONCEPT:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				globalConcept();
				}
				break;
			case TIME_SERIES_CONCEPT:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
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
			setState(44);
			match(GLOBAL_CONCEPT);
			setState(45);
			match(T__0);
			setState(46);
			globalConceptType();
			setState(47);
			match(NEW_LINE);
			setState(48);
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
			setState(50);
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
			setState(52);
			match(TIME_SERIES_CONCEPT);
			setState(53);
			match(T__0);
			setState(54);
			timeSeriesConceptType();
			setState(55);
			match(NEW_LINE);
			setState(56);
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
			setState(58);
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
		enterRule(_localctx, 12, RULE_phraseSpecifications);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(60);
					phraseSpecification();
					setState(61);
					match(NEW_LINE);
					}
					} 
				}
				setState(67);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(68);
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
		enterRule(_localctx, 14, RULE_phraseSpecification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(PHRASE_SPECIFICATION);
			setState(71);
			match(NEW_LINE);
			setState(72);
			subject();
			setState(73);
			match(NEW_LINE);
			setState(74);
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

	public static class ConstraintContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(PhraseCreatorParser.STRING, 0); }
		public ConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).enterConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhraseCreatorListener ) ((PhraseCreatorListener)listener).exitConstraint(this);
		}
	}

	public final ConstraintContext constraint() throws RecognitionException {
		ConstraintContext _localctx = new ConstraintContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_constraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
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
		enterRule(_localctx, 18, RULE_subject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(SUBJECT);
			setState(79);
			match(NEW_LINE);
			setState(80);
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
		enterRule(_localctx, 20, RULE_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(PREDICATE);
			setState(83);
			match(NEW_LINE);
			setState(84);
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
		enterRule(_localctx, 22, RULE_assignments);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(86);
					assignment();
					setState(87);
					match(NEW_LINE);
					}
					} 
				}
				setState(93);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(94);
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
		enterRule(_localctx, 24, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			identifier();
			setState(97);
			match(T__1);
			setState(98);
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
		enterRule(_localctx, 26, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
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
		public TerminalNode STRING() { return getToken(PhraseCreatorParser.STRING, 0); }
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
		enterRule(_localctx, 28, RULE_expression);
		try {
			setState(106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLACE_HOLDER_MARKER:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				match(PLACE_HOLDER_MARKER);
				setState(103);
				match(STRING);
				setState(104);
				match(PLACE_HOLDER_MARKER);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\20o\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\7\2$\n\2\f\2"+
		"\16\2\'\13\2\3\2\3\2\3\3\3\3\5\3-\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\7\bB\n\b\f\b\16\bE\13\b\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\7\r\\\n\r\f\r\16\r_\13\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\5\20m\n\20\3\20\2\2\21\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36\2\2\2d\2%\3\2\2\2\4,\3\2\2\2\6.\3\2\2\2\b\64\3\2"+
		"\2\2\n\66\3\2\2\2\f<\3\2\2\2\16C\3\2\2\2\20H\3\2\2\2\22N\3\2\2\2\24P\3"+
		"\2\2\2\26T\3\2\2\2\30]\3\2\2\2\32b\3\2\2\2\34f\3\2\2\2\36l\3\2\2\2 !\5"+
		"\4\3\2!\"\7\16\2\2\"$\3\2\2\2# \3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2"+
		"&(\3\2\2\2\'%\3\2\2\2()\5\4\3\2)\3\3\2\2\2*-\5\6\4\2+-\5\n\6\2,*\3\2\2"+
		"\2,+\3\2\2\2-\5\3\2\2\2./\7\5\2\2/\60\7\3\2\2\60\61\5\b\5\2\61\62\7\16"+
		"\2\2\62\63\5\16\b\2\63\7\3\2\2\2\64\65\7\7\2\2\65\t\3\2\2\2\66\67\7\6"+
		"\2\2\678\7\3\2\289\5\f\7\29:\7\16\2\2:;\5\16\b\2;\13\3\2\2\2<=\7\b\2\2"+
		"=\r\3\2\2\2>?\5\20\t\2?@\7\16\2\2@B\3\2\2\2A>\3\2\2\2BE\3\2\2\2CA\3\2"+
		"\2\2CD\3\2\2\2DF\3\2\2\2EC\3\2\2\2FG\5\20\t\2G\17\3\2\2\2HI\7\t\2\2IJ"+
		"\7\16\2\2JK\5\24\13\2KL\7\16\2\2LM\5\26\f\2M\21\3\2\2\2NO\7\r\2\2O\23"+
		"\3\2\2\2PQ\7\n\2\2QR\7\16\2\2RS\5\30\r\2S\25\3\2\2\2TU\7\13\2\2UV\7\16"+
		"\2\2VW\5\30\r\2W\27\3\2\2\2XY\5\32\16\2YZ\7\16\2\2Z\\\3\2\2\2[X\3\2\2"+
		"\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^`\3\2\2\2_]\3\2\2\2`a\5\32\16\2a\31"+
		"\3\2\2\2bc\5\34\17\2cd\7\4\2\2de\5\36\20\2e\33\3\2\2\2fg\7\f\2\2g\35\3"+
		"\2\2\2hi\7\20\2\2ij\7\r\2\2jm\7\20\2\2km\7\r\2\2lh\3\2\2\2lk\3\2\2\2m"+
		"\37\3\2\2\2\7%,C]l";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}