// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package control;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.LexerParser;
import io.expertinput.WriterLexerParser;
import io.expertinput.listener.WriterListener;
import writenlg.simplenlg.DocumentGenerator;

/**
 * Processes input data using linguistic rules based on the Writer ANTLR grammar.
 */
public class WriterController extends Controller
{
	private static final Logger LOGGER = LogManager.getLogger("WriterController.class");

	/**
	 * Creates a WriterController instance.
	 */
	public WriterController()
	{
		super(WriteNlgProperties.getInstance().getProperty("AntlrInputWriter"));
		LOGGER.info("WriterController created");
	}

	/**
	 * Runs the Writer process.
	 */
	@Override
	public String process()
	{
		LOGGER.info("Starting the Writer process");

		final LexerParser lexerParser = new WriterLexerParser(getCharStream());
		final WriterListener listener = new WriterListener();
		lexerParser.walkParseTree(listener);

		final DocumentGenerator documentGenerator = listener.selectDocumentGenerator();
		return documentGenerator.generate();
	}
}
