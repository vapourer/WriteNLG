// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.control;

import java.util.Properties;

import org.antlr.v4.runtime.CharStream;

import io.AntlrInputReader;

/**
 * Abstract factory class sub-classes of which create an appropriate LexerParser and trigger the associated natural
 * language generation process.
 */
public abstract class Controller
{
	private final Properties properties;
	private final CharStream charStream;

	public abstract String process();

	/**
	 * Creates a Controller instance.
	 *
	 * @param charStream
	 */
	public Controller(final String antlrFilePath, final Properties properties)
	{
		this.charStream = new AntlrInputReader(antlrFilePath).getAntlrInputFromFile();
		this.properties = properties;
	}

	/**
	 * @return the properties
	 */
	protected Properties getProperties()
	{
		return this.properties;
	}

	/**
	 * @return the charStream
	 */
	protected CharStream getCharStream()
	{
		return this.charStream;
	}
}
