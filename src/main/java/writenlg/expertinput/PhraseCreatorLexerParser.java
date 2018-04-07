package writenlg.expertinput;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import writenlg.antlrgenerated.PhraseCreatorLexer;
import writenlg.antlrgenerated.PhraseCreatorParser;

/**
 * Scans and parses input according to the ANTLR generated PhraseCreator grammar.
 */
public class PhraseCreatorLexerParser extends LexerParser
{
	private static final Logger LOGGER = LogManager.getLogger("PhraseCreatorLexerParser.class");

	/**
	 * Creates a PhraseCreatorLexerParser instance.
	 *
	 * @param input
	 */
	public PhraseCreatorLexerParser(final CharStream input)
	{
		super(new PhraseCreatorLexer(input));
		LOGGER.info("PhraseCreatorLexerParser created");
	}

	@Override
	protected ParseTree writeDocument(final CommonTokenStream tokens)
	{
		return new PhraseCreatorParser(tokens).writeDocument();
	}
}
