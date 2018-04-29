// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.constrain;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import writenlg.antlrgenerated.ConstraintsLexer;
import writenlg.antlrgenerated.ConstraintsParser;
import writenlg.expertinput.LexerParser;

/**
 * Scans and parses input according to the ANTLR generated Constraints grammar.
 */
public class ConstraintsLexerParser extends LexerParser
{
	private static final Logger LOGGER = LogManager.getLogger("ConstraintsLexerParser.class");

	/**
	 * Creates a ConstraintsLexerParser instance.
	 *
	 * @param input
	 */
	public ConstraintsLexerParser(final CharStream input)
	{
		super(new ConstraintsLexer(input));
		LOGGER.info("ConstraintsLexerParser created");
	}

	@Override
	protected ParseTree createParseTree(CommonTokenStream tokens)
	{
		return new ConstraintsParser(tokens).constraintConfiguration();
	}
}
