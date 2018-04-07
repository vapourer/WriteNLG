// Generated from Writer.g4 by ANTLR 4.7
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
public class WriterParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, DOCUMENT=11, SECTION=12, PARAGRAPH=13, SENTENCE=14, CLAUSE=15, 
		SUBCLAUSE=16, FEATURES=17, PART_OF_SPEECH=18, DECIMAL_PLACES=19, NUMERIC=20, 
		STRING=21, NEW_LINE=22, WHITE_SPACE=23, PLACE_HOLDER_PREFIX=24;
	public static final int
		RULE_writeDocument = 0, RULE_document = 1, RULE_section = 2, RULE_paragraph = 3, 
		RULE_sentence = 4, RULE_clause = 5, RULE_subclause = 6, RULE_configuration = 7, 
		RULE_documentTitle = 8, RULE_documentTitleValue = 9, RULE_sectionTitle = 10, 
		RULE_sectionTitleValue = 11, RULE_features = 12, RULE_feature = 13, RULE_tense = 14, 
		RULE_tenseValue = 15, RULE_complementiser = 16, RULE_complementiserValue = 17, 
		RULE_conjunction = 18, RULE_conjunctionValue = 19, RULE_assignments = 20, 
		RULE_assignment = 21, RULE_identifier = 22, RULE_expression = 23, RULE_option = 24, 
		RULE_decimalPlaces = 25, RULE_decimalPlacesValue = 26;
	public static final String[] ruleNames = {
		"writeDocument", "document", "section", "paragraph", "sentence", "clause", 
		"subclause", "configuration", "documentTitle", "documentTitleValue", "sectionTitle", 
		"sectionTitleValue", "features", "feature", "tense", "tenseValue", "complementiser", 
		"complementiserValue", "conjunction", "conjunctionValue", "assignments", 
		"assignment", "identifier", "expression", "option", "decimalPlaces", "decimalPlacesValue"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'DocumentTitle'", "'='", "'SectionTitle'", "'tense'", "'present'", 
		"'past'", "'future'", "'complementiser'", "'conjunction'", "':'", "'Document'", 
		"'Section'", "'Paragraph'", "'Sentence'", "'Clause'", "'Subclause'", "'Features'", 
		null, "'DecimalPlaces'", null, null, null, null, "'@'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "DOCUMENT", 
		"SECTION", "PARAGRAPH", "SENTENCE", "CLAUSE", "SUBCLAUSE", "FEATURES", 
		"PART_OF_SPEECH", "DECIMAL_PLACES", "NUMERIC", "STRING", "NEW_LINE", "WHITE_SPACE", 
		"PLACE_HOLDER_PREFIX"
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
	public String getGrammarFileName() { return "Writer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public WriterParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class WriteDocumentContext extends ParserRuleContext {
		public DocumentContext document() {
			return getRuleContext(DocumentContext.class,0);
		}
		public SectionContext section() {
			return getRuleContext(SectionContext.class,0);
		}
		public ParagraphContext paragraph() {
			return getRuleContext(ParagraphContext.class,0);
		}
		public SentenceContext sentence() {
			return getRuleContext(SentenceContext.class,0);
		}
		public ClauseContext clause() {
			return getRuleContext(ClauseContext.class,0);
		}
		public AssignmentsContext assignments() {
			return getRuleContext(AssignmentsContext.class,0);
		}
		public WriteDocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeDocument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).enterWriteDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).exitWriteDocument(this);
		}
	}

	public final WriteDocumentContext writeDocument() throws RecognitionException {
		WriteDocumentContext _localctx = new WriteDocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_writeDocument);
		try {
			setState(60);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOCUMENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				document();
				}
				break;
			case SECTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				section();
				}
				break;
			case PARAGRAPH:
				enterOuterAlt(_localctx, 3);
				{
				setState(56);
				paragraph();
				}
				break;
			case SENTENCE:
				enterOuterAlt(_localctx, 4);
				{
				setState(57);
				sentence();
				}
				break;
			case CLAUSE:
				enterOuterAlt(_localctx, 5);
				{
				setState(58);
				clause();
				}
				break;
			case PART_OF_SPEECH:
			case DECIMAL_PLACES:
				enterOuterAlt(_localctx, 6);
				{
				setState(59);
				assignments();
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

	public static class DocumentContext extends ParserRuleContext {
		public TerminalNode DOCUMENT() { return getToken(WriterParser.DOCUMENT, 0); }
		public List<TerminalNode> NEW_LINE() { return getTokens(WriterParser.NEW_LINE); }
		public TerminalNode NEW_LINE(int i) {
			return getToken(WriterParser.NEW_LINE, i);
		}
		public List<SectionContext> section() {
			return getRuleContexts(SectionContext.class);
		}
		public SectionContext section(int i) {
			return getRuleContext(SectionContext.class,i);
		}
		public List<ConfigurationContext> configuration() {
			return getRuleContexts(ConfigurationContext.class);
		}
		public ConfigurationContext configuration(int i) {
			return getRuleContext(ConfigurationContext.class,i);
		}
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).enterDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).exitDocument(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_document);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(DOCUMENT);
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==T__2) {
				{
				{
				setState(63);
				configuration();
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69);
			match(NEW_LINE);
			setState(75);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(70);
					section();
					setState(71);
					match(NEW_LINE);
					}
					} 
				}
				setState(77);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(78);
			section();
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

	public static class SectionContext extends ParserRuleContext {
		public TerminalNode SECTION() { return getToken(WriterParser.SECTION, 0); }
		public List<TerminalNode> NEW_LINE() { return getTokens(WriterParser.NEW_LINE); }
		public TerminalNode NEW_LINE(int i) {
			return getToken(WriterParser.NEW_LINE, i);
		}
		public List<ParagraphContext> paragraph() {
			return getRuleContexts(ParagraphContext.class);
		}
		public ParagraphContext paragraph(int i) {
			return getRuleContext(ParagraphContext.class,i);
		}
		public List<ConfigurationContext> configuration() {
			return getRuleContexts(ConfigurationContext.class);
		}
		public ConfigurationContext configuration(int i) {
			return getRuleContext(ConfigurationContext.class,i);
		}
		public SectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).enterSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).exitSection(this);
		}
	}

	public final SectionContext section() throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_section);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(SECTION);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==T__2) {
				{
				{
				setState(81);
				configuration();
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87);
			match(NEW_LINE);
			setState(93);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(88);
					paragraph();
					setState(89);
					match(NEW_LINE);
					}
					} 
				}
				setState(95);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(96);
			paragraph();
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

	public static class ParagraphContext extends ParserRuleContext {
		public TerminalNode PARAGRAPH() { return getToken(WriterParser.PARAGRAPH, 0); }
		public List<TerminalNode> NEW_LINE() { return getTokens(WriterParser.NEW_LINE); }
		public TerminalNode NEW_LINE(int i) {
			return getToken(WriterParser.NEW_LINE, i);
		}
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public List<ConfigurationContext> configuration() {
			return getRuleContexts(ConfigurationContext.class);
		}
		public ConfigurationContext configuration(int i) {
			return getRuleContext(ConfigurationContext.class,i);
		}
		public ParagraphContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paragraph; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).enterParagraph(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).exitParagraph(this);
		}
	}

	public final ParagraphContext paragraph() throws RecognitionException {
		ParagraphContext _localctx = new ParagraphContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_paragraph);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(PARAGRAPH);
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==T__2) {
				{
				{
				setState(99);
				configuration();
				}
				}
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(105);
			match(NEW_LINE);
			setState(111);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(106);
					sentence();
					setState(107);
					match(NEW_LINE);
					}
					} 
				}
				setState(113);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(114);
			sentence();
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

	public static class SentenceContext extends ParserRuleContext {
		public TerminalNode SENTENCE() { return getToken(WriterParser.SENTENCE, 0); }
		public List<TerminalNode> NEW_LINE() { return getTokens(WriterParser.NEW_LINE); }
		public TerminalNode NEW_LINE(int i) {
			return getToken(WriterParser.NEW_LINE, i);
		}
		public List<ClauseContext> clause() {
			return getRuleContexts(ClauseContext.class);
		}
		public ClauseContext clause(int i) {
			return getRuleContext(ClauseContext.class,i);
		}
		public List<ConfigurationContext> configuration() {
			return getRuleContexts(ConfigurationContext.class);
		}
		public ConfigurationContext configuration(int i) {
			return getRuleContext(ConfigurationContext.class,i);
		}
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).enterSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).exitSentence(this);
		}
	}

	public final SentenceContext sentence() throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_sentence);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(SENTENCE);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==T__2) {
				{
				{
				setState(117);
				configuration();
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(123);
			match(NEW_LINE);
			setState(129);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(124);
					clause();
					setState(125);
					match(NEW_LINE);
					}
					} 
				}
				setState(131);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(132);
			clause();
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

	public static class ClauseContext extends ParserRuleContext {
		public TerminalNode CLAUSE() { return getToken(WriterParser.CLAUSE, 0); }
		public List<TerminalNode> NEW_LINE() { return getTokens(WriterParser.NEW_LINE); }
		public TerminalNode NEW_LINE(int i) {
			return getToken(WriterParser.NEW_LINE, i);
		}
		public List<SubclauseContext> subclause() {
			return getRuleContexts(SubclauseContext.class);
		}
		public SubclauseContext subclause(int i) {
			return getRuleContext(SubclauseContext.class,i);
		}
		public List<ConfigurationContext> configuration() {
			return getRuleContexts(ConfigurationContext.class);
		}
		public ConfigurationContext configuration(int i) {
			return getRuleContext(ConfigurationContext.class,i);
		}
		public FeaturesContext features() {
			return getRuleContext(FeaturesContext.class,0);
		}
		public AssignmentsContext assignments() {
			return getRuleContext(AssignmentsContext.class,0);
		}
		public ClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).enterClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).exitClause(this);
		}
	}

	public final ClauseContext clause() throws RecognitionException {
		ClauseContext _localctx = new ClauseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_clause);
		int _la;
		try {
			int _alt;
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				match(CLAUSE);
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0 || _la==T__2) {
					{
					{
					setState(135);
					configuration();
					}
					}
					setState(140);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(141);
				match(NEW_LINE);
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FEATURES) {
					{
					setState(142);
					features();
					}
				}

				setState(150);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(145);
						subclause();
						setState(146);
						match(NEW_LINE);
						}
						} 
					}
					setState(152);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				}
				setState(153);
				subclause();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				match(CLAUSE);
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0 || _la==T__2) {
					{
					{
					setState(155);
					configuration();
					}
					}
					setState(160);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(161);
				match(NEW_LINE);
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FEATURES) {
					{
					setState(162);
					features();
					}
				}

				setState(165);
				assignments();
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

	public static class SubclauseContext extends ParserRuleContext {
		public TerminalNode SUBCLAUSE() { return getToken(WriterParser.SUBCLAUSE, 0); }
		public TerminalNode NEW_LINE() { return getToken(WriterParser.NEW_LINE, 0); }
		public AssignmentsContext assignments() {
			return getRuleContext(AssignmentsContext.class,0);
		}
		public List<ConfigurationContext> configuration() {
			return getRuleContexts(ConfigurationContext.class);
		}
		public ConfigurationContext configuration(int i) {
			return getRuleContext(ConfigurationContext.class,i);
		}
		public FeaturesContext features() {
			return getRuleContext(FeaturesContext.class,0);
		}
		public SubclauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subclause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).enterSubclause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).exitSubclause(this);
		}
	}

	public final SubclauseContext subclause() throws RecognitionException {
		SubclauseContext _localctx = new SubclauseContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_subclause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(SUBCLAUSE);
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==T__2) {
				{
				{
				setState(169);
				configuration();
				}
				}
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(175);
			match(NEW_LINE);
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FEATURES) {
				{
				setState(176);
				features();
				}
			}

			setState(179);
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

	public static class ConfigurationContext extends ParserRuleContext {
		public DocumentTitleContext documentTitle() {
			return getRuleContext(DocumentTitleContext.class,0);
		}
		public SectionTitleContext sectionTitle() {
			return getRuleContext(SectionTitleContext.class,0);
		}
		public ConfigurationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_configuration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).enterConfiguration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).exitConfiguration(this);
		}
	}

	public final ConfigurationContext configuration() throws RecognitionException {
		ConfigurationContext _localctx = new ConfigurationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_configuration);
		try {
			setState(183);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				documentTitle();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(182);
				sectionTitle();
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

	public static class DocumentTitleContext extends ParserRuleContext {
		public DocumentTitleValueContext documentTitleValue() {
			return getRuleContext(DocumentTitleValueContext.class,0);
		}
		public DocumentTitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_documentTitle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).enterDocumentTitle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).exitDocumentTitle(this);
		}
	}

	public final DocumentTitleContext documentTitle() throws RecognitionException {
		DocumentTitleContext _localctx = new DocumentTitleContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_documentTitle);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(T__0);
			setState(186);
			match(T__1);
			setState(187);
			documentTitleValue();
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

	public static class DocumentTitleValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(WriterParser.STRING, 0); }
		public DocumentTitleValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_documentTitleValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).enterDocumentTitleValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).exitDocumentTitleValue(this);
		}
	}

	public final DocumentTitleValueContext documentTitleValue() throws RecognitionException {
		DocumentTitleValueContext _localctx = new DocumentTitleValueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_documentTitleValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
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

	public static class SectionTitleContext extends ParserRuleContext {
		public SectionTitleValueContext sectionTitleValue() {
			return getRuleContext(SectionTitleValueContext.class,0);
		}
		public SectionTitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sectionTitle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).enterSectionTitle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).exitSectionTitle(this);
		}
	}

	public final SectionTitleContext sectionTitle() throws RecognitionException {
		SectionTitleContext _localctx = new SectionTitleContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_sectionTitle);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(T__2);
			setState(192);
			match(T__1);
			setState(193);
			sectionTitleValue();
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

	public static class SectionTitleValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(WriterParser.STRING, 0); }
		public SectionTitleValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sectionTitleValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).enterSectionTitleValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).exitSectionTitleValue(this);
		}
	}

	public final SectionTitleValueContext sectionTitleValue() throws RecognitionException {
		SectionTitleValueContext _localctx = new SectionTitleValueContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_sectionTitleValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
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

	public static class FeaturesContext extends ParserRuleContext {
		public TerminalNode FEATURES() { return getToken(WriterParser.FEATURES, 0); }
		public TerminalNode NEW_LINE() { return getToken(WriterParser.NEW_LINE, 0); }
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
			if ( listener instanceof WriterListener ) ((WriterListener)listener).enterFeatures(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).exitFeatures(this);
		}
	}

	public final FeaturesContext features() throws RecognitionException {
		FeaturesContext _localctx = new FeaturesContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_features);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(FEATURES);
			setState(198);
			match(NEW_LINE);
			setState(200); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(199);
				feature();
				}
				}
				setState(202); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__7) | (1L << T__8))) != 0) );
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
		public TerminalNode NEW_LINE() { return getToken(WriterParser.NEW_LINE, 0); }
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
			if ( listener instanceof WriterListener ) ((WriterListener)listener).enterFeature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).exitFeature(this);
		}
	}

	public final FeatureContext feature() throws RecognitionException {
		FeatureContext _localctx = new FeatureContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_feature);
		try {
			setState(213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				complementiser();
				setState(205);
				match(NEW_LINE);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(207);
				tense();
				setState(208);
				match(NEW_LINE);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(210);
				conjunction();
				setState(211);
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
			if ( listener instanceof WriterListener ) ((WriterListener)listener).enterTense(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).exitTense(this);
		}
	}

	public final TenseContext tense() throws RecognitionException {
		TenseContext _localctx = new TenseContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_tense);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(T__3);
			setState(216);
			match(T__1);
			setState(217);
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
			if ( listener instanceof WriterListener ) ((WriterListener)listener).enterTenseValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).exitTenseValue(this);
		}
	}

	public final TenseValueContext tenseValue() throws RecognitionException {
		TenseValueContext _localctx = new TenseValueContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_tenseValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
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
			if ( listener instanceof WriterListener ) ((WriterListener)listener).enterComplementiser(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).exitComplementiser(this);
		}
	}

	public final ComplementiserContext complementiser() throws RecognitionException {
		ComplementiserContext _localctx = new ComplementiserContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_complementiser);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(T__7);
			setState(222);
			match(T__1);
			setState(223);
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
		public TerminalNode STRING() { return getToken(WriterParser.STRING, 0); }
		public ComplementiserValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complementiserValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).enterComplementiserValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).exitComplementiserValue(this);
		}
	}

	public final ComplementiserValueContext complementiserValue() throws RecognitionException {
		ComplementiserValueContext _localctx = new ComplementiserValueContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_complementiserValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
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
			if ( listener instanceof WriterListener ) ((WriterListener)listener).enterConjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).exitConjunction(this);
		}
	}

	public final ConjunctionContext conjunction() throws RecognitionException {
		ConjunctionContext _localctx = new ConjunctionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_conjunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(T__8);
			setState(228);
			match(T__1);
			setState(229);
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
		public TerminalNode STRING() { return getToken(WriterParser.STRING, 0); }
		public ConjunctionValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjunctionValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).enterConjunctionValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).exitConjunctionValue(this);
		}
	}

	public final ConjunctionValueContext conjunctionValue() throws RecognitionException {
		ConjunctionValueContext _localctx = new ConjunctionValueContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_conjunctionValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
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

	public static class AssignmentsContext extends ParserRuleContext {
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public List<TerminalNode> NEW_LINE() { return getTokens(WriterParser.NEW_LINE); }
		public TerminalNode NEW_LINE(int i) {
			return getToken(WriterParser.NEW_LINE, i);
		}
		public AssignmentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).enterAssignments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).exitAssignments(this);
		}
	}

	public final AssignmentsContext assignments() throws RecognitionException {
		AssignmentsContext _localctx = new AssignmentsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_assignments);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(233);
					assignment();
					setState(234);
					match(NEW_LINE);
					}
					} 
				}
				setState(240);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			setState(241);
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
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public List<TerminalNode> NEW_LINE() { return getTokens(WriterParser.NEW_LINE); }
		public TerminalNode NEW_LINE(int i) {
			return getToken(WriterParser.NEW_LINE, i);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DECIMAL_PLACES) {
				{
				{
				setState(243);
				option();
				setState(244);
				match(NEW_LINE);
				}
				}
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(251);
			identifier();
			setState(252);
			match(T__9);
			setState(253);
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
		public TerminalNode PART_OF_SPEECH() { return getToken(WriterParser.PART_OF_SPEECH, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
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
		public TerminalNode PLACE_HOLDER_PREFIX() { return getToken(WriterParser.PLACE_HOLDER_PREFIX, 0); }
		public TerminalNode STRING() { return getToken(WriterParser.STRING, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_expression);
		try {
			setState(260);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLACE_HOLDER_PREFIX:
				enterOuterAlt(_localctx, 1);
				{
				setState(257);
				match(PLACE_HOLDER_PREFIX);
				setState(258);
				match(STRING);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
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

	public static class OptionContext extends ParserRuleContext {
		public DecimalPlacesContext decimalPlaces() {
			return getRuleContext(DecimalPlacesContext.class,0);
		}
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).enterOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).exitOption(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_option);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			decimalPlaces();
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

	public static class DecimalPlacesContext extends ParserRuleContext {
		public TerminalNode DECIMAL_PLACES() { return getToken(WriterParser.DECIMAL_PLACES, 0); }
		public DecimalPlacesValueContext decimalPlacesValue() {
			return getRuleContext(DecimalPlacesValueContext.class,0);
		}
		public DecimalPlacesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decimalPlaces; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).enterDecimalPlaces(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).exitDecimalPlaces(this);
		}
	}

	public final DecimalPlacesContext decimalPlaces() throws RecognitionException {
		DecimalPlacesContext _localctx = new DecimalPlacesContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_decimalPlaces);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(DECIMAL_PLACES);
			setState(265);
			match(T__1);
			setState(266);
			decimalPlacesValue();
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

	public static class DecimalPlacesValueContext extends ParserRuleContext {
		public TerminalNode NUMERIC() { return getToken(WriterParser.NUMERIC, 0); }
		public DecimalPlacesValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decimalPlacesValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).enterDecimalPlacesValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WriterListener ) ((WriterListener)listener).exitDecimalPlacesValue(this);
		}
	}

	public final DecimalPlacesValueContext decimalPlacesValue() throws RecognitionException {
		DecimalPlacesValueContext _localctx = new DecimalPlacesValueContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_decimalPlacesValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(NUMERIC);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\32\u0111\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3\2\3\2\3\2\5\2?\n\2\3\3\3"+
		"\3\7\3C\n\3\f\3\16\3F\13\3\3\3\3\3\3\3\3\3\7\3L\n\3\f\3\16\3O\13\3\3\3"+
		"\3\3\3\4\3\4\7\4U\n\4\f\4\16\4X\13\4\3\4\3\4\3\4\3\4\7\4^\n\4\f\4\16\4"+
		"a\13\4\3\4\3\4\3\5\3\5\7\5g\n\5\f\5\16\5j\13\5\3\5\3\5\3\5\3\5\7\5p\n"+
		"\5\f\5\16\5s\13\5\3\5\3\5\3\6\3\6\7\6y\n\6\f\6\16\6|\13\6\3\6\3\6\3\6"+
		"\3\6\7\6\u0082\n\6\f\6\16\6\u0085\13\6\3\6\3\6\3\7\3\7\7\7\u008b\n\7\f"+
		"\7\16\7\u008e\13\7\3\7\3\7\5\7\u0092\n\7\3\7\3\7\3\7\7\7\u0097\n\7\f\7"+
		"\16\7\u009a\13\7\3\7\3\7\3\7\7\7\u009f\n\7\f\7\16\7\u00a2\13\7\3\7\3\7"+
		"\5\7\u00a6\n\7\3\7\5\7\u00a9\n\7\3\b\3\b\7\b\u00ad\n\b\f\b\16\b\u00b0"+
		"\13\b\3\b\3\b\5\b\u00b4\n\b\3\b\3\b\3\t\3\t\5\t\u00ba\n\t\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\6\16\u00cb\n\16"+
		"\r\16\16\16\u00cc\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00d8"+
		"\n\17\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26\7\26\u00ef\n\26\f\26\16\26\u00f2"+
		"\13\26\3\26\3\26\3\27\3\27\3\27\7\27\u00f9\n\27\f\27\16\27\u00fc\13\27"+
		"\3\27\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31\5\31\u0107\n\31\3\32\3\32"+
		"\3\33\3\33\3\33\3\33\3\34\3\34\3\34\2\2\35\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\62\64\66\2\3\3\2\7\t\2\u0111\2>\3\2\2\2\4@\3"+
		"\2\2\2\6R\3\2\2\2\bd\3\2\2\2\nv\3\2\2\2\f\u00a8\3\2\2\2\16\u00aa\3\2\2"+
		"\2\20\u00b9\3\2\2\2\22\u00bb\3\2\2\2\24\u00bf\3\2\2\2\26\u00c1\3\2\2\2"+
		"\30\u00c5\3\2\2\2\32\u00c7\3\2\2\2\34\u00d7\3\2\2\2\36\u00d9\3\2\2\2 "+
		"\u00dd\3\2\2\2\"\u00df\3\2\2\2$\u00e3\3\2\2\2&\u00e5\3\2\2\2(\u00e9\3"+
		"\2\2\2*\u00f0\3\2\2\2,\u00fa\3\2\2\2.\u0101\3\2\2\2\60\u0106\3\2\2\2\62"+
		"\u0108\3\2\2\2\64\u010a\3\2\2\2\66\u010e\3\2\2\28?\5\4\3\29?\5\6\4\2:"+
		"?\5\b\5\2;?\5\n\6\2<?\5\f\7\2=?\5*\26\2>8\3\2\2\2>9\3\2\2\2>:\3\2\2\2"+
		">;\3\2\2\2><\3\2\2\2>=\3\2\2\2?\3\3\2\2\2@D\7\r\2\2AC\5\20\t\2BA\3\2\2"+
		"\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2EG\3\2\2\2FD\3\2\2\2GM\7\30\2\2HI\5\6"+
		"\4\2IJ\7\30\2\2JL\3\2\2\2KH\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NP\3"+
		"\2\2\2OM\3\2\2\2PQ\5\6\4\2Q\5\3\2\2\2RV\7\16\2\2SU\5\20\t\2TS\3\2\2\2"+
		"UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2WY\3\2\2\2XV\3\2\2\2Y_\7\30\2\2Z[\5\b\5"+
		"\2[\\\7\30\2\2\\^\3\2\2\2]Z\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`b\3"+
		"\2\2\2a_\3\2\2\2bc\5\b\5\2c\7\3\2\2\2dh\7\17\2\2eg\5\20\t\2fe\3\2\2\2"+
		"gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2ik\3\2\2\2jh\3\2\2\2kq\7\30\2\2lm\5\n\6"+
		"\2mn\7\30\2\2np\3\2\2\2ol\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2rt\3\2"+
		"\2\2sq\3\2\2\2tu\5\n\6\2u\t\3\2\2\2vz\7\20\2\2wy\5\20\t\2xw\3\2\2\2y|"+
		"\3\2\2\2zx\3\2\2\2z{\3\2\2\2{}\3\2\2\2|z\3\2\2\2}\u0083\7\30\2\2~\177"+
		"\5\f\7\2\177\u0080\7\30\2\2\u0080\u0082\3\2\2\2\u0081~\3\2\2\2\u0082\u0085"+
		"\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0086\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0086\u0087\5\f\7\2\u0087\13\3\2\2\2\u0088\u008c\7\21\2"+
		"\2\u0089\u008b\5\20\t\2\u008a\u0089\3\2\2\2\u008b\u008e\3\2\2\2\u008c"+
		"\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f\3\2\2\2\u008e\u008c\3\2"+
		"\2\2\u008f\u0091\7\30\2\2\u0090\u0092\5\32\16\2\u0091\u0090\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0098\3\2\2\2\u0093\u0094\5\16\b\2\u0094\u0095\7"+
		"\30\2\2\u0095\u0097\3\2\2\2\u0096\u0093\3\2\2\2\u0097\u009a\3\2\2\2\u0098"+
		"\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009b\3\2\2\2\u009a\u0098\3\2"+
		"\2\2\u009b\u00a9\5\16\b\2\u009c\u00a0\7\21\2\2\u009d\u009f\5\20\t\2\u009e"+
		"\u009d\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2"+
		"\2\2\u00a1\u00a3\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a5\7\30\2\2\u00a4"+
		"\u00a6\5\32\16\2\u00a5\u00a4\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\3"+
		"\2\2\2\u00a7\u00a9\5*\26\2\u00a8\u0088\3\2\2\2\u00a8\u009c\3\2\2\2\u00a9"+
		"\r\3\2\2\2\u00aa\u00ae\7\22\2\2\u00ab\u00ad\5\20\t\2\u00ac\u00ab\3\2\2"+
		"\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b1"+
		"\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b3\7\30\2\2\u00b2\u00b4\5\32\16"+
		"\2\u00b3\u00b2\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6"+
		"\5*\26\2\u00b6\17\3\2\2\2\u00b7\u00ba\5\22\n\2\u00b8\u00ba\5\26\f\2\u00b9"+
		"\u00b7\3\2\2\2\u00b9\u00b8\3\2\2\2\u00ba\21\3\2\2\2\u00bb\u00bc\7\3\2"+
		"\2\u00bc\u00bd\7\4\2\2\u00bd\u00be\5\24\13\2\u00be\23\3\2\2\2\u00bf\u00c0"+
		"\7\27\2\2\u00c0\25\3\2\2\2\u00c1\u00c2\7\5\2\2\u00c2\u00c3\7\4\2\2\u00c3"+
		"\u00c4\5\30\r\2\u00c4\27\3\2\2\2\u00c5\u00c6\7\27\2\2\u00c6\31\3\2\2\2"+
		"\u00c7\u00c8\7\23\2\2\u00c8\u00ca\7\30\2\2\u00c9\u00cb\5\34\17\2\u00ca"+
		"\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2"+
		"\2\2\u00cd\33\3\2\2\2\u00ce\u00cf\5\"\22\2\u00cf\u00d0\7\30\2\2\u00d0"+
		"\u00d8\3\2\2\2\u00d1\u00d2\5\36\20\2\u00d2\u00d3\7\30\2\2\u00d3\u00d8"+
		"\3\2\2\2\u00d4\u00d5\5&\24\2\u00d5\u00d6\7\30\2\2\u00d6\u00d8\3\2\2\2"+
		"\u00d7\u00ce\3\2\2\2\u00d7\u00d1\3\2\2\2\u00d7\u00d4\3\2\2\2\u00d8\35"+
		"\3\2\2\2\u00d9\u00da\7\6\2\2\u00da\u00db\7\4\2\2\u00db\u00dc\5 \21\2\u00dc"+
		"\37\3\2\2\2\u00dd\u00de\t\2\2\2\u00de!\3\2\2\2\u00df\u00e0\7\n\2\2\u00e0"+
		"\u00e1\7\4\2\2\u00e1\u00e2\5$\23\2\u00e2#\3\2\2\2\u00e3\u00e4\7\27\2\2"+
		"\u00e4%\3\2\2\2\u00e5\u00e6\7\13\2\2\u00e6\u00e7\7\4\2\2\u00e7\u00e8\5"+
		"(\25\2\u00e8\'\3\2\2\2\u00e9\u00ea\7\27\2\2\u00ea)\3\2\2\2\u00eb\u00ec"+
		"\5,\27\2\u00ec\u00ed\7\30\2\2\u00ed\u00ef\3\2\2\2\u00ee\u00eb\3\2\2\2"+
		"\u00ef\u00f2\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f3"+
		"\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00f4\5,\27\2\u00f4+\3\2\2\2\u00f5"+
		"\u00f6\5\62\32\2\u00f6\u00f7\7\30\2\2\u00f7\u00f9\3\2\2\2\u00f8\u00f5"+
		"\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb"+
		"\u00fd\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd\u00fe\5.\30\2\u00fe\u00ff\7\f"+
		"\2\2\u00ff\u0100\5\60\31\2\u0100-\3\2\2\2\u0101\u0102\7\24\2\2\u0102/"+
		"\3\2\2\2\u0103\u0104\7\32\2\2\u0104\u0107\7\27\2\2\u0105\u0107\7\27\2"+
		"\2\u0106\u0103\3\2\2\2\u0106\u0105\3\2\2\2\u0107\61\3\2\2\2\u0108\u0109"+
		"\5\64\33\2\u0109\63\3\2\2\2\u010a\u010b\7\25\2\2\u010b\u010c\7\4\2\2\u010c"+
		"\u010d\5\66\34\2\u010d\65\3\2\2\2\u010e\u010f\7\26\2\2\u010f\67\3\2\2"+
		"\2\31>DMV_hqz\u0083\u008c\u0091\u0098\u00a0\u00a5\u00a8\u00ae\u00b3\u00b9"+
		"\u00cc\u00d7\u00f0\u00fa\u0106";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}