// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.constrain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.CharStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.AntlrInputReader;
import writenlg.expertinput.LexerParser;

public class Constraints
{
	private static final Logger LOGGER = LogManager.getLogger("Constraints.class");

	private static Constraints INSTANCE;

	private final Map<String, ConstraintConfiguration> constraintConfigurations;

	/**
	 * Creates a Constraints instance.
	 * 
	 * @param propertiesPath
	 */
	public static void createInstance(final String path)
	{
		if (INSTANCE == null)
		{
			INSTANCE = new Constraints();
			loadConstraintConfigurations(path);
		}
	}

	private static void loadConstraintConfigurations(final String path)
	{
		LOGGER.info("Loading constraint configurations");
		LOGGER.info(String.format("Path to constraints file: %s", path));

		final CharStream charStream = new AntlrInputReader(path).getAntlrInputFromFile();
		final LexerParser lexerParser = new ConstraintsLexerParser(charStream);
		final ConstraintsListener listener = new ConstraintsListener();
		lexerParser.walkParseTree(listener);
	}

	/**
	 * @return a singleton Constraints instance
	 */
	public static Constraints getInstance()
	{
		return INSTANCE;
	}

	private Constraints()
	{
		constraintConfigurations = new HashMap<>();
		LOGGER.info("Constraints instance created");
	}

	/**
	 * Creates a new ConstraintConfiguration instance, and adds it to this Map of ConstraintConfiguration instances.
	 * 
	 * @param name
	 * @param value
	 * @param weighting
	 */
	public void addConstraint(final String name, final BigDecimal value, final BigDecimal weighting)
	{
		ConstraintConfiguration configuration = new ConstraintConfiguration(value, weighting);
		constraintConfigurations.put(name, configuration);
		LOGGER.info(String.format("Constraint configuration loaded for %s: %s", name, configuration));
	}

	/**
	 * @param name
	 * @return the ConstraintConfiguration associated with name
	 */
	public ConstraintConfiguration getConfiguration(String name)
	{
		return constraintConfigurations.get(name);
	}
}
