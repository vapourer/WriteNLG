// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.control;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Reads properties from WriteNLG.properties and stores them in a Properties object.
 */
class PropertyReader
{
	private static final Logger LOGGER = LogManager.getLogger("PropertyReader.class");

	private final String propertiesPath;

	/**
	 * Creates a PropertyReader instance.
	 */
	PropertyReader(final String propertiesPath)
	{
		this.propertiesPath = propertiesPath;
	}

	/**
	 * Loads and logs the properties.
	 * 
	 * @return Properties
	 */
	Properties loadProperties()
	{
		LOGGER.info("Loading properties");
		LOGGER.info(String.format("Path to properties file: %s", this.propertiesPath));

		final Properties properties = new Properties();

		try
		{
			properties.load(new FileInputStream(this.propertiesPath));
		}
		catch (final FileNotFoundException e)
		{
			LOGGER.error("Properties file not found at the specified location", e);
		}
		catch (final IOException e)
		{
			LOGGER.error("Unanticipated IOException while loading Properties file", e);
		}

		LOGGER.info("Properties file loaded");

		LOGGER.info(String.format("Property MaximumError = %s", properties.getProperty("MaximumError")));
		LOGGER.info(String.format("Property MovingAverageWindow = %s", properties.getProperty("MovingAverageWindow")));
		LOGGER.info(String.format("Property MathContext: %s", properties.getProperty("MathContext")));
		LOGGER.info(String.format("Property AntlrGrammar = %s", properties.getProperty("AntlrGrammar")));
		LOGGER.info(String.format("Property AntlrInputPhraseCreator = %s",
				properties.getProperty("AntlrInputPhraseCreator")));
		LOGGER.info(String.format("Property AntlrInputWriter = %s", properties.getProperty("AntlrInputWriter")));
		LOGGER.info(String.format("Property DateFormat = %s", properties.getProperty("DateFormat")));

		return properties;
	}
}
