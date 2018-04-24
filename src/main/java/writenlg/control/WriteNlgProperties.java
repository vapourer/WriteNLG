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
 * Reads properties from WriteNLG.properties and stores them in a WriteNlgProperties object.
 */
public class WriteNlgProperties
{
	private static final Logger LOGGER = LogManager.getLogger("WriteNlgProperties.class");

	private static WriteNlgProperties INSTANCE;

	private final Properties properties;

	/**
	 * Creates a WriteNlgProperties instance.
	 * 
	 * @param propertiesPath
	 */
	public static void createInstance(final String propertiesPath)
	{
		if (INSTANCE == null)
		{
			INSTANCE = new WriteNlgProperties(propertiesPath);
		}
	}

	/**
	 * @return a singleton WriteNlgProperties instance
	 */
	public static WriteNlgProperties getInstance()
	{
		return INSTANCE;
	}

	private WriteNlgProperties(final String propertiesPath)
	{
		this.properties = new Properties();
		LOGGER.info("WriteNlgProperties instance created");

		loadProperties(propertiesPath);
	}

	/**
	 * Loads and logs the properties.
	 */
	private void loadProperties(final String propertiesPath)
	{
		LOGGER.info("Loading properties");
		LOGGER.info(String.format("Path to properties file: %s", propertiesPath));

		try
		{
			this.properties.load(new FileInputStream(propertiesPath));
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

		LOGGER.info(String.format("Property MaximumError = %s", this.properties.getProperty("MaximumError")));
		LOGGER.info(
				String.format("Property MovingAverageWindow = %s", this.properties.getProperty("MovingAverageWindow")));
		LOGGER.info(String.format("Property MathContext: %s", this.properties.getProperty("MathContext")));
		LOGGER.info(String.format("Property AntlrGrammar = %s", this.properties.getProperty("AntlrGrammar")));
		LOGGER.info(String.format("Property AntlrInputPhraseCreator = %s",
				this.properties.getProperty("AntlrInputPhraseCreator")));
		LOGGER.info(String.format("Property AntlrInputWriter = %s", this.properties.getProperty("AntlrInputWriter")));
		LOGGER.info(String.format("Property DateFormat = %s", this.properties.getProperty("DateFormat")));
	}

	/**
	 * @param key
	 * @return a String representation of the property associated with key
	 */
	public String getProperty(final String key)
	{
		return this.properties.getProperty(key);
	}
}
