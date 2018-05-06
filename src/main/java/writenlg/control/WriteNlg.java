// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.control;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.LineGraphAnalyser;
import analysis.constrain.Constraints;
import analysis.graph.LineGraph;
import analysis.interfaces.LineGraphAnalysis;
import io.AntlrGrammar;
import io.TimeSeriesReader;

public class WriteNlg
{
	private static Logger LOGGER;

	public static void main(final String[] args)
	{
		LineGraph lineGraph = null;

		int loadError = 0;

		try
		{
			System.setProperty("log4j.configurationFile", args[0]);
			LOGGER = LogManager.getLogger("WriteNlg.class");
			LOGGER.info("Starting WriteNlg application - logger initialised");

			loadError++;
			WriteNlgProperties.createInstance(args[1]);

			loadError++;
			final TimeSeriesReader timeSeriesReader = new TimeSeriesReader(args[2]);
			lineGraph = timeSeriesReader.createLineGraphFromFile();
			LOGGER.info("Time series data file loaded");
		}
		catch (final ArrayIndexOutOfBoundsException e)
		{
			switch (loadError)
			{
				case 0:
					throw new IllegalArgumentException(
							"First args parameter must be the path to a log4j2 configuration file");
				case 1:
					LOGGER.error("Path to the Java properties file is missing", e);
					throw new IllegalArgumentException(
							"Second args parameter must be the path to a Java properties file");
				case 2:
					LOGGER.error("Path to the time series data file is missing", e);
					throw new IllegalArgumentException(
							"Third args parameter must be the path to a datafile representing one or more time series");
			}
		}

		final AntlrGrammar antlrGrammar = Enum.valueOf(AntlrGrammar.class,
				WriteNlgProperties.getInstance().getProperty("AntlrGrammar"));
		Controller controller = null;

		switch (antlrGrammar)
		{
			case PHRASE_CREATOR:
				Constraints.createInstance(WriteNlgProperties.getInstance().getProperty("AntlrInputConstraints"));
				LineGraphAnalysis lineGraphAnalysis = new LineGraphAnalyser(lineGraph);
				controller = new PhraseCreatorController(lineGraphAnalysis);
				break;
			case WRITER:
				controller = new WriterController();
				break;
		}

		String output = controller.process();

		LOGGER.info(output);
		System.out.println();
		System.out.println(output);
	}
}
