package writenlg.control;

import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.linguistics.phrase.PhraseSpecification;
import simplenlg.phrasespec.SPhraseSpec;
import writenlg.expertinput.LexerParser;
import writenlg.expertinput.PhraseCreatorLexerParser;
import writenlg.expertinput.listener.PhraseCreatorListener;
import writenlg.simplenlg.SimpleNlg;

/**
 * Processes input data using linguistic rules based on the PhraseCreator ANTLR grammar.
 */
public class PhraseCreatorController extends Controller
{
	private static final Logger LOGGER = LogManager.getLogger("PhraseCreatorController.class");

	/**
	 * Creates a PhraseCreatorController instance.
	 *
	 * @param charStream
	 * @param properties
	 */
	public PhraseCreatorController(final Properties properties)
	{
		super(properties.getProperty("AntlrInputPhraseCreator"), properties);
		LOGGER.info("PhraseCreatorController created");
	}

	/**
	 * Runs the PhraseCreator process.
	 */
	@Override
	public String process()
	{
		LOGGER.info("Starting the PhraseCreator process");

		final LexerParser lexerParser = new PhraseCreatorLexerParser(getCharStream());
		final PhraseCreatorListener listener = new PhraseCreatorListener(getProperties());
		lexerParser.walkParseTree(listener);

		final List<PhraseSpecification> phraseSpecifications = listener.getPhraseSpecifications();

		final StringBuilder builder = new StringBuilder();

		final SimpleNlg simpleNlg = SimpleNlg.getInstance();

		for (final PhraseSpecification phraseSpecification : phraseSpecifications)
		{
			final SPhraseSpec clause = simpleNlg.createClause();
			clause.setSubject(phraseSpecification.getSubject().getNounPhrase().getText());
			clause.setVerb(phraseSpecification.getPredicate().getVerb().getText());
			clause.setObject(phraseSpecification.getPredicate().getNounPhrase().getText());
			builder.append(simpleNlg.realise(clause));
			builder.append(System.lineSeparator());
		}

		return builder.toString();
	}

}
