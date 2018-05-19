// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.constrain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.CharStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.GlobalConcept;
import analysis.TimeSeriesSpecificConcept;
import io.AntlrInputReader;
import io.LexerParser;

public class Constraints
{
	private static final Logger LOGGER = LogManager.getLogger("Constraints.class");

	private static Constraints INSTANCE;

	private final Map<GlobalConcept, Map<String, ConstraintConfiguration>> constraintConfigurationsForGlobalConcepts;
	private final Map<TimeSeriesSpecificConcept, Map<String, ConstraintConfiguration>> constraintConfigurationsForTimeSeriesSpecificConcepts;

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
		this.constraintConfigurationsForGlobalConcepts = new HashMap<>();
		this.constraintConfigurationsForTimeSeriesSpecificConcepts = new HashMap<>();
		LOGGER.info("Constraints instance created");
	}

	/**
	 * Creates a new ConstraintConfiguration instance, and adds it to this Map of ConstraintConfiguration instances.
	 * 
	 * @param concept
	 * @param name
	 * @param value
	 * @param weighting
	 */
	public void addConstraintConfigurationForGlobalConcept(final GlobalConcept concept, final String name,
			final BigDecimal value, final BigDecimal weighting)
	{
		ConstraintConfiguration configuration = new ConstraintConfiguration(value, weighting);

		if (this.constraintConfigurationsForGlobalConcepts.containsKey(concept))
		{
			this.constraintConfigurationsForGlobalConcepts.get(concept).put(name, configuration);
		}
		else
		{
			Map<String, ConstraintConfiguration> constraintConfigurations = new HashMap<>();
			constraintConfigurations.put(name, configuration);
			this.constraintConfigurationsForGlobalConcepts.put(concept, constraintConfigurations);
		}

		LOGGER.info(
				String.format("Global constraint configuration loaded for %s: %s - %s", concept, name, configuration));
	}

	/**
	 * Creates a new ConstraintConfiguration instance, and adds it to this Map of ConstraintConfiguration instances.
	 * 
	 * @param concept
	 * @param name
	 * @param value
	 * @param weighting
	 */
	public void addConstraintConfigurationForTimeSeriesSpecificConcept(final TimeSeriesSpecificConcept concept,
			final String name, final BigDecimal value, final BigDecimal weighting)
	{
		ConstraintConfiguration configuration = new ConstraintConfiguration(value, weighting);

		if (this.constraintConfigurationsForTimeSeriesSpecificConcepts.containsKey(concept))
		{
			this.constraintConfigurationsForTimeSeriesSpecificConcepts.get(concept).put(name, configuration);
		}
		else
		{
			Map<String, ConstraintConfiguration> constraintConfigurations = new HashMap<>();
			constraintConfigurations.put(name, configuration);
			this.constraintConfigurationsForTimeSeriesSpecificConcepts.put(concept, constraintConfigurations);
		}

		LOGGER.info(String.format("Time series specific constraint configuration loaded for %s: %s - %s", concept, name,
				configuration));
	}

	/**
	 * @param concept
	 * @return the Map<String, ConstraintConfiguration> associated with concept
	 */
	public Map<String, ConstraintConfiguration> getConstraintConfigurationsForGlobalConcept(final GlobalConcept concept)
	{
		return this.constraintConfigurationsForGlobalConcepts.get(concept);
	}

	/**
	 * @param concept
	 * @return the Map<String, ConstraintConfiguration> associated with concept
	 */
	public Map<String, ConstraintConfiguration> getConfigurationsForTimeSeriesSpecificConcept(
			final TimeSeriesSpecificConcept concept)
	{
		return this.constraintConfigurationsForTimeSeriesSpecificConcepts.get(concept);
	}
}
