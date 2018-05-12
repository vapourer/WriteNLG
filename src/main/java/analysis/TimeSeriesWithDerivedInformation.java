// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis;

import java.math.BigDecimal;
import java.util.ArrayList;
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
	private final List<Segment> smoothedSegments;
	private final Slope directionOfLongestSegment;
	private List<Point> points;
	private List<Point> smoothedPoints;

	/**
	 * Creates a TimeSeriesWithDerivedInformation instance.
	 * 
	 * @param timeSeries
	 * @param pointWithMaximumValue
	 * @param pointWithMinimumValue
	 * @param segments
	 * @param timeSlice
	 * @param timeSeriesSmoothed
	 * @param smoothedSegments
	 * @param directionOfLongestSegment
	 */
	public TimeSeriesWithDerivedInformation(final TimeSeries timeSeries, final Point pointWithMaximumValue,
			final Point pointWithMinimumValue, final List<Segment> segments, final TimeSlice timeSlice,
			final SortedMap<Long, BigDecimal> timeSeriesSmoothed, final List<Segment> smoothedSegments,
			final Slope directionOfLongestSegment)
	{
		this.timeSeries = timeSeries;
		this.pointWithMaximumValue = pointWithMaximumValue;
		this.pointWithMinimumValue = pointWithMinimumValue;
		this.segments = segments;
		this.timeSlice = timeSlice;
		this.timeSeriesSmoothed = timeSeriesSmoothed;
		this.smoothedSegments = smoothedSegments;
		this.directionOfLongestSegment = directionOfLongestSegment;
	}

	/**
	 * @return the timeSeries
	 */
	public TimeSeries getTimeSeries()
	{
		return this.timeSeries;
	}

	/**
	 * @return the pointWithMaximumValue
	 */
	public Point getPointWithMaximumValue()
	{
		return this.pointWithMaximumValue;
	}

	/**
	 * @return the pointWithMinimumValue
	 */
	public Point getPointWithMinimumValue()
	{
		return this.pointWithMinimumValue;
	}

	/**
	 * @return the segments
	 */
	public List<Segment> getSegments()
	{
		return this.segments;
	}

	/**
	 * @return the timeLegend
	 */
	public String getTimeLegend()
	{
		return this.timeSeries.getTimeLegend();
	}

	/**
	 * @return the seriesLegend
	 */
	public String getSeriesLegend()
	{
		return this.timeSeries.getSeriesLegend();
	}

	/**
	 * @return the series
	 */
	public SortedMap<Long, BigDecimal> getSeries()
	{
		return this.timeSeries.getSeries();
	}

	/**
	 * @return the timeSlice
	 */
	public TimeSlice getTimeSlice()
	{
		return this.timeSlice;
	}

	/**
	 * @return the timeSeriesSmoothed
	 */
	public SortedMap<Long, BigDecimal> getTimeSeriesSmoothed()
	{
		return this.timeSeriesSmoothed;
	}

	/**
	 * @return the directionOfLongestSegment
	 */
	public Slope getDirectionOfLongestSegment()
	{
		return this.directionOfLongestSegment;
	}

	/**
	 * @return the smoothedSegments
	 */
	public List<Segment> getSmoothedSegments()
	{
		return this.smoothedSegments;
	}

	/**
	 * @return the points
	 */
	public List<Point> getPoints()
	{
		if (this.points == null)
		{
			this.points = new ArrayList<>();

			for (Segment eachSegment : this.segments)
			{
				this.points.add(eachSegment.getPoint1());
			}

			this.points.add(this.segments.get(this.segments.size() - 1).getPoint2());
		}

		return this.points;
	}

	/**
	 * @return the smoothedPoints
	 */
	public List<Point> getSmoothedPoints()
	{
		if (this.smoothedPoints == null)
		{
			this.smoothedPoints = new ArrayList<>();

			for (Segment eachSegment : this.smoothedSegments)
			{
				this.points.add(eachSegment.getPoint1());
			}

			this.points.add(this.segments.get(this.smoothedSegments.size() - 1).getPoint2());
		}

		return this.smoothedPoints;
	}
}
