// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.control;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.LineGraphAnalyser;
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

			loadError = 1;
			WriteNlgProperties.createInstance(args[1]);

			loadError = 2;
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
				LineGraphAnalysis lineGraphAnalysis = new LineGraphAnalyser(lineGraph);
				controller = new PhraseCreatorController(lineGraphAnalysis);
				break;
			case WRITER:
				controller = new WriterController();
				break;
		}

		System.out.println();
		System.out.println(controller.process());

		// outputMultipleTimeSeries(lineGraph);
		// outputBottomUpPiecewiseLinearFunctionResult(lineGraph);
		// outputCentredMovingAverageResult(lineGraph, properties);
	}

	// private static void outputMultipleTimeSeries(final LineGraph lineGraph)
	// {
	// System.out.println();
	// System.out.println("Datasets");
	//
	// final DateFormat dateFormatter = new SimpleDateFormat(
	// WriteNlgProperties.getInstance().getProperty("DateFormat"));
	// final List<TimeSeries> timeSeriesGroup = lineGraph.getTimeSeriesGroup();
	//
	// for (final TimeSeries timeSeries : timeSeriesGroup)
	// {
	// final SortedMap<Long, BigDecimal> graph = timeSeries.getSeries();
	//
	// System.out.println(timeSeries.getTimeLegend() + "\t" + timeSeries.getSeriesLegend());
	//
	// for (final Long eachTime : graph.keySet())
	// {
	// final String formattedDate = dateFormatter.format(new Date(eachTime));
	// System.out.println(formattedDate + "\t" + graph.get(eachTime));
	// }
	//
	// System.out.println();
	// }
	//
	// System.out.println();
	// }
	//
	// private static void outputBottomUpPiecewiseLinearFunctionResult(final LineGraph lineGraph)
	// {
	// final List<TimeSeries> timeSeriesGroup = lineGraph.getTimeSeriesGroup();
	//
	// System.out.println("BottomUpPiecewiseLinearFunction");
	//
	// for (final TimeSeries eachTimeSeries : timeSeriesGroup)
	// {
	// System.out.println(eachTimeSeries.getSeriesLegend());
	//
	// final Segmentation segmenter = new Segmenter(eachTimeSeries);
	//
	// // final Smoothing bottomUpPiecewiseLinearFunction = new BottomUpPiecewiseLinearFunction(
	// // eachTimeSeries.getTimeSeries(), properties);
	//
	// final Smoothing bottomUpPiecewiseLinearFunction = new BottomUpPiecewiseLinearFunction(
	// segmenter.createSegments());
	//
	// final SortedMap<Long, BigDecimal> timeSeriesSegmented = bottomUpPiecewiseLinearFunction.smoothGraph();
	//
	// System.out.println(eachTimeSeries.getTimeLegend() + "\t" + eachTimeSeries.getSeriesLegend());
	//
	// final DateFormat dateFormatter = new SimpleDateFormat(
	// WriteNlgProperties.getInstance().getProperty("DateFormat"));
	//
	// for (final Long eachTime : timeSeriesSegmented.keySet())
	// {
	// final String formattedDate = dateFormatter.format(new Date(eachTime));
	// System.out.println(formattedDate + "\t" + timeSeriesSegmented.get(eachTime));
	// }
	//
	// System.out.println();
	// }
	// }
	//
	// private static void outputCentredMovingAverageResult(final LineGraph lineGraph)
	// {
	// final List<TimeSeries> timeSeriesGroup = lineGraph.getTimeSeriesGroup();
	//
	// System.out.println("CentredMovingAverage");
	//
	// for (final TimeSeries eachTimeSeries : timeSeriesGroup)
	// {
	// System.out.println(eachTimeSeries.getSeriesLegend());
	//
	// final MovingAverage centredMovingAverage = new CentredMovingAverage(eachTimeSeries.getSeries(),
	// Integer.parseInt(WriteNlgProperties.getInstance().getProperty("MovingAverageWindow")));
	//
	// final SortedMap<Long, BigDecimal> timeSeriesSmoothed = centredMovingAverage.averageGraph();
	//
	// System.out.println(eachTimeSeries.getTimeLegend() + "\t" + eachTimeSeries.getSeriesLegend());
	//
	// final DateFormat dateFormatter = new SimpleDateFormat(
	// WriteNlgProperties.getInstance().getProperty("DateFormat"));
	//
	// for (final Long eachTime : timeSeriesSmoothed.keySet())
	// {
	// final String formattedDate = dateFormatter.format(new Date(eachTime));
	// System.out.println(formattedDate + "\t" + timeSeriesSmoothed.get(eachTime));
	// }
	//
	// System.out.println();
	// }
	// }
}
