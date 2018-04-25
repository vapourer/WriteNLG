// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.graph.LineGraph;
import analysis.graph.TimeSeries;
import analysis.interfaces.LineGraphAnalysis;
import analysis.interfaces.TimeSeriesAnalysis;

/**
 * Analyses a LineGraph instance, from which derived information is stored in a LineGraphDerivedInformation instance.
 */
public class LineGraphAnalyser implements LineGraphAnalysis
{
	private static final Logger LOGGER = LogManager.getLogger("LineGraphAnalyser.class");

	private LineGraph graph;

	/**
	 * Creates a LineGraphAnalyser instance.
	 * 
	 * @param graph
	 */
	public LineGraphAnalyser(LineGraph graph)
	{
		this.graph = graph;

		LOGGER.info("LineGraphAnalyser created");
	}

	/**
	 * Collects TimeSeriesDerivedInformation instances from TimeSeriesAnalysis analyse calls, for further analysis and
	 * comparison.
	 * 
	 * @return LineGraphDerivedInformation
	 */
	@Override
	public LineGraphDerivedInformation analyse()
	{
		LOGGER.info("Analysing LineGraph and building LineGraphDerivedInformation");

		List<TimeSeriesDerivedInformation> timeSeriesDerivedInformation = new ArrayList<>();

		List<TimeSeries> timeSeriesGroup = this.graph.getTimeSeriesGroup();

		for (TimeSeries eachTimeSeries : timeSeriesGroup)
		{
			TimeSeriesAnalysis timeSeriesAnalysis = new TimeSeriesAnalyser(eachTimeSeries);
			timeSeriesDerivedInformation.add(timeSeriesAnalysis.analyse());
		}

		LineGraphDerivedInformationBuilder builder = new LineGraphDerivedInformationBuilder();
		builder.setTimeSeriesDerivedInformation(timeSeriesDerivedInformation);
		return builder.createLineGraphDerivedInformation();
	}
}
