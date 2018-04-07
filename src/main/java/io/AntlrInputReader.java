package io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AntlrInputReader
{
	private static final Logger LOGGER = LogManager.getLogger("AntlrInputReader.class");

	private final Path path;

	public AntlrInputReader(final String filePath)
	{
		LOGGER.info(String.format("Path to data file: %s", filePath));
		this.path = Paths.get(filePath);
	}

	public CharStream getAntlrInputFromFile()
	{
		LOGGER.info("Reading ANTLR input from file");
		CharStream antlrInput = null;

		try
		{
			antlrInput = CharStreams.fromPath(this.path);
			LOGGER.info("Reading of ANTLR input from file completed");
		}
		catch (final FileNotFoundException e)
		{
			LOGGER.error("Data file not found at the specified location", e);
		}
		catch (final IOException e)
		{
			LOGGER.error("Unanticipated IOException while loading data file", e);
		}

		return antlrInput;
	}
}
