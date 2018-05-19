// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package control;

import org.antlr.v4.runtime.CharStream;

import io.AntlrInputReader;

/**
 * Sub-classes create an appropriate LexerParser and trigger the associated natural language generation process.
 */
public abstract class Controller
{
	private final CharStream charStream;

	public abstract String process();

	/**
	 * Creates a Controller instance.
	 *
	 * @param charStream
	 */
	public Controller(final String antlrFilePath)
	{
		this.charStream = new AntlrInputReader(antlrFilePath).getAntlrInputFromFile();
	}

	/**
	 * @return the charStream
	 */
	protected CharStream getCharStream()
	{
		return this.charStream;
	}
}
