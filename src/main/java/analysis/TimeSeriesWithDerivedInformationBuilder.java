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
 * Builder for the TimeSeriesWithDerivedInformation class.
 */
public class TimeSeriesWithDerivedInformationBuilder
{
	private TimeSeries timeSeries;
	private Point pointWithMaximumValue;
	private Point pointWithMinimumValue;
	private List<Segment> segments;
	private TimeSlice timeSlice;
	private SortedMap<Long, BigDecimal> timeSeriesSmoothed;
	private Slope directionOfLongestSegment;

	/**
	 * Creates a new TimeSeriesWithDerivedInformation instance.
	 *
	 * @return TimeSeriesWithDerivedInformation
	 */
	public TimeSeriesWithDerivedInformation createTimeSeriesDerivedInformation()
	{
		return new TimeSeriesWithDerivedInformation(this.timeSeries, this.pointWithMaximumValue,
				this.pointWithMinimumValue, this.segments, this.timeSlice, this.timeSeriesSmoothed,
				this.directionOfLongestSegment);
	}

	/**
	 * @param timeSeries
	 *            the timeSeries to set
	 */
	public void setTimeSeries(TimeSeries timeSeries)
	{
		this.timeSeries = timeSeries;
	}

	/**
	 * @param pointWithMaximumValue
	 *            the pointWithMaximumValue to set
	 */
	public void setPointWithMaximumValue(Point pointWithMaximumValue)
	{
		this.pointWithMaximumValue = pointWithMaximumValue;
	}

	/**
	 * @param pointWithMinimumValue
	 *            the pointWithMinimumValue to set
	 */
	public void setPointWithMinimumValue(Point pointWithMinimumValue)
	{
		this.pointWithMinimumValue = pointWithMinimumValue;
	}

	/**
	 * @param segments
	 *            the segments to set
	 */
	public void setSegments(final List<Segment> segments)
	{
		this.segments = segments;
	}

	/**
	 * @param timeSlice
	 *            the timeSlice to set
	 */
	public void setTimeSlice(TimeSlice timeSlice)
	{
		this.timeSlice = timeSlice;
	}

	/**
	 * @param timeSeriesSmoothed
	 *            the timeSeriesSmoothed to set
	 */
	public void setTimeSeriesSmoothed(SortedMap<Long, BigDecimal> timeSeriesSmoothed)
	{
		this.timeSeriesSmoothed = timeSeriesSmoothed;
	}

	/**
	 * @param directionOfLongestSegment
	 *            the directionOfLongestSegment to set
	 */
	public void setDirectionOfLongestSegment(Slope directionOfLongestSegment)
	{
		this.directionOfLongestSegment = directionOfLongestSegment;
	}
}
