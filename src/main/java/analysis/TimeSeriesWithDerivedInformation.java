// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis;

import java.math.BigDecimal;
import java.util.List;
import java.util.SortedMap;

import analysis.graph.Point;
import analysis.graph.Segment;
import analysis.graph.Slope;
import analysis.graph.TimeSeries;
import analysis.time.TimeSlice;

/**
 * Container for analysis of a time series, based on selected statistical algorithms.
 */
public class TimeSeriesWithDerivedInformation
{
	private final TimeSeries timeSeries;
	private final Point pointWithMaximumValue;
	private final Point pointWithMinimumValue;
	private final List<Segment> segments;
	private final TimeSlice timeSlice;
	private final SortedMap<Long, BigDecimal> timeSeriesSmoothed;
	private final Slope directionOfLongestSegment;

	/**
	 * Creates an TimeSeriesWithDerivedInformation instance.
	 * 
	 * @param pointWithMaximumValue
	 * @param pointWithMinimumValue
	 * @param segments
	 */
	public TimeSeriesWithDerivedInformation(final TimeSeries timeSeries, final Point pointWithMaximumValue,
			final Point pointWithMinimumValue, final List<Segment> segments, final TimeSlice timeSlice,
			final SortedMap<Long, BigDecimal> timeSeriesSmoothed, final Slope directionOfLongestSegment)
	{
		this.timeSeries = timeSeries;
		this.pointWithMaximumValue = pointWithMaximumValue;
		this.pointWithMinimumValue = pointWithMinimumValue;
		this.segments = segments;
		this.timeSlice = timeSlice;
		this.timeSeriesSmoothed = timeSeriesSmoothed;
		this.directionOfLongestSegment = directionOfLongestSegment;
	}

	/**
	 * @return the timeSeries
	 */
	public TimeSeries getTimeSeries()
	{
		return timeSeries;
	}

	/**
	 * @return the pointWithMaximumValue
	 */
	public Point getPointWithMaximumValue()
	{
		return pointWithMaximumValue;
	}

	/**
	 * @return the pointWithMinimumValue
	 */
	public Point getPointWithMinimumValue()
	{
		return pointWithMinimumValue;
	}

	/**
	 * @return the segments
	 */
	public List<Segment> getSegments()
	{
		return segments;
	}

	/**
	 * @return the timeLegend
	 */
	public String getTimeLegend()
	{
		return timeSeries.getTimeLegend();
	}

	/**
	 * @return the seriesLegend
	 */
	public String getSeriesLegend()
	{
		return timeSeries.getSeriesLegend();
	}

	/**
	 * @return the series
	 */
	public SortedMap<Long, BigDecimal> getSeries()
	{
		return timeSeries.getSeries();
	}

	/**
	 * @return the timeSlice
	 */
	public TimeSlice getTimeSlice()
	{
		return timeSlice;
	}

	/**
	 * @return the timeSeriesSmoothed
	 */
	public SortedMap<Long, BigDecimal> getTimeSeriesSmoothed()
	{
		return timeSeriesSmoothed;
	}

	/**
	 * @return the directionOfLongestSegment
	 */
	public Slope getDirectionOfLongestSegment()
	{
		return directionOfLongestSegment;
	}
}
