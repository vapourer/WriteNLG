// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package control;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.LineGraphWithDerivedInformation;
import analysis.interfaces.ConceptLoader;
import analysis.interfaces.ContentDeterminer;
import analysis.interfaces.LineGraphAnalysis;
import analysis.linguistics.contentdetermination.ContentDetermination;
import analysis.linguistics.documentplanning.DocumentPlanner;
import analysis.substitution.Substitutor;
import io.LexerParser;
import io.expertinput.PhraseCreatorLexerParser;
import io.expertinput.listener.PhraseCreatorListener;

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
		LineGraphWithDerivedInformation lineGraph = lineGraphAnalysis.analyse();
		final Substitutor substitutor = new Substitutor(lineGraph);
		final PhraseCreatorListener listener = new PhraseCreatorListener(lineGraph, substitutor);
		lexerParser.walkParseTree(listener);

		final ConceptLoader concepts = listener.getConcepts();
		final ContentDeterminer contentDeterminer = new ContentDetermination(concepts);

		DocumentPlanner planner = new DocumentPlanner(lineGraph, contentDeterminer.getSelectedConcepts());
		return planner.createDocument();
	}
}
