// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.expertinput;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import writenlg.antlrgenerated.WriterLexer;
import writenlg.antlrgenerated.WriterParser;

/**
 * Enables scanning and parsing of input acco0rding to an ANTLR generated Writer grammar.
 */
public class WriterLexerParser extends LexerParser
{
	private static final Logger LOGGER = LogManager.getLogger("WriterLexerParser.class");

	/**
	 * Creates a WriterLexerParser instance.
	 *
	 * @param input
	 */
	public WriterLexerParser(final CharStream input)
	{
		super(new WriterLexer(input));
		LOGGER.info("WriterLexerParser created");
	}

	@Override
	protected ParseTree writeDocument(final CommonTokenStream tokens)
	{
		return new WriterParser(tokens).writeDocument();
	}
}
