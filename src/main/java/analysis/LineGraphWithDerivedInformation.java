// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis;

import java.util.ArrayList;
import java.util.List;

import analysis.graph.LineGraph;
import analysis.graph.TimeSeries;
import analysis.statistics.TimeSeriesCross;

/**
 * Container for analyses and comparison of multiple time series, based on selected statistical algorithms.
 */
public class LineGraphWithDerivedInformation
{
	private final LineGraph lineGraph;
	private final List<TimeSeriesWithDerivedInformation> timeSeriesWithDerivedInformation;
	private final int timeSeriesCount;

	/**
	 * Create a new LineGraphWithDerivedInformation instance.
	 * 
	 * @param timeSeriesWithDerivedInformation
	 */
	public LineGraphWithDerivedInformation(final LineGraph lineGraph,
			List<TimeSeriesWithDerivedInformation> timeSeriesWithDerivedInformation, final int timeSeriesCount)
	{
		this.lineGraph = lineGraph;
		this.timeSeriesWithDerivedInformation = timeSeriesWithDerivedInformation;
		this.timeSeriesCount = timeSeriesCount;
	}

	/**
	 * @return the timeSeriesWithDerivedInformation
	 */
	public List<TimeSeriesWithDerivedInformation> getTimeSeriesDerivedInformation()
	{
		return new ArrayList<>(this.timeSeriesWithDerivedInformation);
	}

	/**
	 * @return the timeSeriesGroup
	 */
	public List<TimeSeries> getTimeSeriesGroup()
	{
		return lineGraph.getTimeSeriesGroup();
	}

	/**
	 * @return the timeSeriesCount
	 */
	public int getTimeSeriesCount()
	{
		return timeSeriesCount;
	}

	/**
	 * @param series1
	 * @param series2
	 * @return the number of crossing points for a pair of series.
	 */
	public int getCrossingPointCount(TimeSeriesWithDerivedInformation series1, TimeSeriesWithDerivedInformation series2)
	{
		return new TimeSeriesCross(series1, series2).identifySegmentsWithCrossingPoints().size();
	}
}
