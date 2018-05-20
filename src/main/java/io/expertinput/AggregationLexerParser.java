// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package io.expertinput;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.LexerParser;
import io.antlrgenerated.AggregationLexer;
import io.antlrgenerated.AggregationParser;

/**
 * Scans and parses input according to the ANTLR generated Aggregation grammar.
 */
public class AggregationLexerParser extends LexerParser
{
	private static final Logger LOGGER = LogManager.getLogger("AggregationLexerParser.class");

	/**
	 * Creates a new AggregationLexerParser instance.
	 * 
	 * @param lexer
	 */
	public AggregationLexerParser(final CharStream input)
	{
		super(new AggregationLexer(input));
		LOGGER.info("AggregationLexerParser created");
	}

	@Override
	protected ParseTree createParseTree(CommonTokenStream tokens)
	{
		return new AggregationParser(tokens).aggregationRules();
	}
}
