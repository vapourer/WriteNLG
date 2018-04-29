// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.control;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.interfaces.ContentDeterminer;
import analysis.interfaces.LineGraphAnalysis;
import analysis.linguistics.contentdetermination.concepts.AbstractConcept;
import analysis.linguistics.phrase.PhraseSpecification;
import simplenlg.phrasespec.SPhraseSpec;
import writenlg.expertinput.LexerParser;
import writenlg.expertinput.PhraseCreatorLexerParser;
import writenlg.expertinput.listener.PhraseCreatorListener;
import writenlg.simplenlg.SimpleNlg;
import writenlg.substitution.Substitutor;
import writenlg.substitution.TimeSeriesMapping;

/**
 * Processes input data using linguistic rules based on the PhraseCreator ANTLR grammar.
 */
public class PhraseCreatorController extends Controller
{
	private static final Logger LOGGER = LogManager.getLogger("PhraseCreatorController.class");

	private LineGraphAnalysis lineGraphAnalysis;

	/**
	 * Creates a PhraseCreatorController instance.
	 *
	 * @param charStream
	 * @param properties
	 */
	public PhraseCreatorController(LineGraphAnalysis lineGraphAnalysis)
	{
		super(WriteNlgProperties.getInstance().getProperty("AntlrInputPhraseCreator"));

		this.lineGraphAnalysis = lineGraphAnalysis;

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
		final PhraseCreatorListener listener = new PhraseCreatorListener();
		lexerParser.walkParseTree(listener);

		final ContentDeterminer contentDeterminer = listener.getContentDeterminer();

		Substitutor substitutor = new Substitutor(lineGraphAnalysis.analyse());
		substitutor.mapValuesToPlaceHolders();

		List<TimeSeriesMapping> timeSeriesMappings = substitutor.getTimeSeriesMappings();

		final SimpleNlg simpleNlg = SimpleNlg.getInstance();
		String summary = "";

		for (TimeSeriesMapping eachTimeSeriesMapping : timeSeriesMappings)
		{
			final StringBuilder builder = new StringBuilder();

			for (AbstractConcept eachConcept : contentDeterminer.getSelectedConcepts())
			{
				for (final PhraseSpecification phraseSpecification : eachConcept.getPhraseSpecifications())
				{
					final SPhraseSpec clause = simpleNlg.createClause();
					clause.setSubject(phraseSpecification.getSubject().getNounPhrase().getText());
					clause.setVerb(phraseSpecification.getPredicate().getVerb().getText());

					if (phraseSpecification.getPredicate().getNounPhrase() != null)
					{
						clause.setObject(phraseSpecification.getPredicate().getNounPhrase().getText());
					}

					if (phraseSpecification.getPredicate().getComplement() != null)
					{
						clause.setComplement(phraseSpecification.getPredicate().getComplement().getText());
					}

					builder.append(simpleNlg.realise(clause));
					builder.append(System.lineSeparator());
				}
			}

			summary += builder.toString();

			Map<String, String> substitutions = eachTimeSeriesMapping.getSubstitutions();

			for (final String eachPlaceHolder : substitutions.keySet())
			{
				summary = summary.replaceAll(eachPlaceHolder, substitutions.get(eachPlaceHolder));
				LOGGER.info(summary);
			}
		}

		return summary;
	}
}
