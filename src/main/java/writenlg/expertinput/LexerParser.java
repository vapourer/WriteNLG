// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.expertinput;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Abstract base class enables sub-classes to scan and parse input according to ANTLR generated NLG grammars.
 */
public abstract class LexerParser
{
	private static final Logger LOGGER = LogManager.getLogger("LexerParser.class");

	private final CommonTokenStream tokens;

	protected abstract ParseTree writeDocument(CommonTokenStream tokens);

	/**
	 * Creates a LexerParser instance.
	 *
	 * @param lexer
	 */
	public LexerParser(final Lexer lexer)
	{
		this.tokens = new CommonTokenStream(lexer);
	}

	/**
	 * Parses ANTLR input read via listener.
	 *
	 * @param listener
	 */
	public void walkParseTree(final ParseTreeListener listener)
	{
		final ParseTree tree = writeDocument(this.tokens);
		LOGGER.info("ParseTree created");

		LOGGER.info("Commencing ParseTree walk");
		final ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(listener, tree);
	}
}
