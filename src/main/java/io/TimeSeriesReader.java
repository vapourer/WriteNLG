// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.graph.LineGraph;

/**
 * Reads multiple time series from a file, and creates a LineGraph instance representing the collection of time series.
 */
public class TimeSeriesReader
{
	private static final Logger LOGGER = LogManager.getLogger("TimeSeriesReader.class");

	private final Path path;

	/**
	 * Creates a TimeSeriesReader instance.
	 *
	 * @param filePath
	 */
	public TimeSeriesReader(final String filePath)
	{
		LOGGER.info(String.format("Path to data file: %s", filePath));
		this.path = Paths.get(filePath);
	}

	/**
	 * Reads multiple time series from the file located at this path. Returns a LineGraph which represents the
	 * collection of time series contained in the file.
	 *
	 * @return LineGraph
	 */
	public LineGraph createLineGraphFromFile()
	{
		final List<String> times = new ArrayList<>();
		final List<String> values = new ArrayList<>();

		BufferedReader reader = null;

		try
		{
			reader = new BufferedReader(new FileReader(this.path.toFile()));

			String line;
			boolean isTimes = true;

			LOGGER.info("Reading time series from data file");

			while ((line = reader.readLine()) != null)
			{
				LOGGER.info(line);

				if (isTimes)
				{
					times.add(line);
					isTimes = false;
				}
				else
				{
					values.add(line);
					isTimes = true;
				}
			}

			LOGGER.info("Reading of time series from data file completed");
		}
		catch (final FileNotFoundException e)
		{
			LOGGER.error("Data file not found at the specified location", e);
		}
		catch (final IOException e)
		{
			LOGGER.error("Unanticipated IOException while loading data file", e);
		}
		finally
		{
			if (reader != null)
			{
				try
				{
					reader.close();
				}
				catch (final IOException e)
				{
					LOGGER.error("Unanticipated IOException while closing BufferedReader", e);
				}
			}
		}

		return new LineGraph(times, values);
	}
}
