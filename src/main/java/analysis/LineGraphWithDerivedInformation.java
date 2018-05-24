// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.graph.LineGraph;
import analysis.graph.TimeSeries;
import analysis.statistics.TimeSeriesCross;
import analysis.time.TimeSlice;

/**
 * Container for analyses and comparison of multiple time series, based on selected statistical algorithms.
 */
public class LineGraphWithDerivedInformation
{
	private static final Logger LOGGER = LogManager.getLogger("LineGraphWithDerivedInformation.class");

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

	/**
	 * @return the graph's title.
	 */
	public String getTitle()
	{
		return this.lineGraph.getTitle();
	}

	/**
	 * @return a List of all time series legends
	 */
	public List<String> getTimesSeriesLegends()
	{
		final List<String> legends = new ArrayList<>();

		for (TimeSeriesWithDerivedInformation timeSeries : this.timeSeriesWithDerivedInformation)
		{
			legends.add(timeSeries.getSeriesLegend());
		}

		return legends;
	}

	/**
	 * @return the timeSlice
	 */
	public TimeSlice getTimeSlice()
	{
		TimeSlice timeSlice = this.timeSeriesWithDerivedInformation.get(0).getTimeSlice();

		for (int i = 1; i < this.timeSeriesWithDerivedInformation.size(); i++)
		{
			if (!this.timeSeriesWithDerivedInformation.get(i).getTimeSlice().toString().equals(timeSlice.toString()))
			{
				LOGGER.error(
						"Multiple time slices identified. Current implementation does not cater for differing timeslices.");
				throw new RuntimeException("Current implementation does not cater for differing timeslices");
			}
		}

		return timeSlice;
	}
}
