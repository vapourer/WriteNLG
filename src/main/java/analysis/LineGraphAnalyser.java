// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis;

import java.util.ArrayList;
import java.util.List;

import analysis.graph.LineGraph;
import analysis.graph.TimeSeries;
import analysis.interfaces.LineGraphAnalysis;
import analysis.interfaces.TimeSeriesAnalysis;

public class LineGraphAnalyser implements LineGraphAnalysis
{
	private LineGraph graph;

	/**
	 * Creates a LineGraphAnalyser instance.
	 * 
	 * @param graph
	 */
	public LineGraphAnalyser(LineGraph graph)
	{
		this.graph = graph;
	}

	@Override
	public LineGraphDerivedInformation analyse()
	{
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
