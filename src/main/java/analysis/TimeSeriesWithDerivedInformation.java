// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.graph.Point;
import analysis.graph.Segment;
import analysis.graph.Slope;
import analysis.graph.TimeSeries;
import analysis.statistics.TurningPoints;
import analysis.time.TimeSlice;
import control.WriteNlgProperties;

/**
 * Container for analysis of a time series, based on selected statistical algorithms.
 */
public class TimeSeriesWithDerivedInformation
{
	private static final Logger LOGGER = LogManager.getLogger("TimeSeriesWithDerivedInformation.class");

	private final static int HUNDRED = 100;

	private final TimeSeries timeSeries;
	private final Point pointWithMaximumValue;
	private final Point pointWithMinimumValue;
	private final List<Segment> segments;
	private final TimeSlice timeSlice;
	private final SortedMap<Long, BigDecimal> timeSeriesSmoothed;
	private final List<Segment> smoothedSegments;
	private final SortedMap<Long, BigDecimal> timeSeriesOutline;
	private final List<Segment> outlineSegments;
	private final Slope directionOfLongestSegment;
	private final SortedMap<Long, BigDecimal> centredMovingAverages;
	private List<Point> points;
	private List<Point> smoothedPoints;
	private List<Point> upperTurningPoints;
	private List<Point> lowerTurningPoints;

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
	 * @param timeSeriesOutline
	 * @param outlineSegments
	 * @param centredMovingAverages
	 */
	public TimeSeriesWithDerivedInformation(final TimeSeries timeSeries, final Point pointWithMaximumValue,
			final Point pointWithMinimumValue, final List<Segment> segments, final TimeSlice timeSlice,
			final SortedMap<Long, BigDecimal> timeSeriesSmoothed, final List<Segment> smoothedSegments,
			final Slope directionOfLongestSegment, final SortedMap<Long, BigDecimal> timeSeriesOutline,
			final List<Segment> outlineSegments, final SortedMap<Long, BigDecimal> centredMovingAverages)
	{
		this.timeSeries = timeSeries;
		this.pointWithMaximumValue = pointWithMaximumValue;
		this.pointWithMinimumValue = pointWithMinimumValue;
		this.segments = segments;
		this.timeSlice = timeSlice;
		this.timeSeriesSmoothed = timeSeriesSmoothed;
		this.smoothedSegments = smoothedSegments;
		this.directionOfLongestSegment = directionOfLongestSegment;
		this.timeSeriesOutline = timeSeriesOutline;
		this.outlineSegments = outlineSegments;
		this.centredMovingAverages = centredMovingAverages;
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
				this.smoothedPoints.add(eachSegment.getPoint1());
			}

			this.smoothedPoints.add(this.segments.get(this.smoothedSegments.size() - 1).getPoint2());
		}

		return this.smoothedPoints;
	}

	/**
	 * @return the timeSeriesOutline
	 */
	public SortedMap<Long, BigDecimal> getTimeSeriesOutline()
	{
		return this.timeSeriesOutline;
	}

	/**
	 * @return the outlineSegments
	 */
	public List<Segment> getOutlineSegments()
	{
		return this.outlineSegments;
	}

	/**
	 * @return the upperTurningPoints
	 */
	public List<Point> getUpperTurningPoints()
	{
		if (this.upperTurningPoints == null)
		{
			this.upperTurningPoints = TurningPoints.getInstance(getSmoothedPoints(), getSmoothedSegments())
					.getUpperTurningPoints();
		}

		return this.upperTurningPoints;
	}

	/**
	 * @return the lowerTurningPoints
	 */
	public List<Point> getLowerTurningPoints()
	{
		if (this.lowerTurningPoints == null)
		{
			this.lowerTurningPoints = TurningPoints.getInstance(getSmoothedPoints(), getSmoothedSegments())
					.getLowerTurningPoints();
		}

		return this.lowerTurningPoints;
	}

	public boolean timeSeriesFluctuates()
	{
		LOGGER.info("Checking for time series fluctuation");

		final int fluctuatesThreshold = getSmoothedPoints().size()
				* Integer.parseInt(
						WriteNlgProperties.getInstance().getProperty("TimeSeriesFluctuatesThresholdAsPercentage"))
				/ HUNDRED;

		LOGGER.info(String.format("Fluctuates threshold: %d", fluctuatesThreshold));

		final int turningPointCount = getUpperTurningPoints().size() + getLowerTurningPoints().size();

		LOGGER.info(String.format("Turning point count: %d", turningPointCount));

		return turningPointCount >= fluctuatesThreshold;
	}

	public boolean timeSeriesFluctuatesSlightly()
	{
		LOGGER.info("Checking for slight time series fluctuation");

		final int fluctuatesSlightlyThreshold = getSmoothedPoints().size() * Integer.parseInt(
				WriteNlgProperties.getInstance().getProperty("TimeSeriesFluctuatesSlightlyThresholdAsPercentage"))
				/ HUNDRED;

		LOGGER.info(String.format("Fluctuates slightly threshold: %d", fluctuatesSlightlyThreshold));

		final int turningPointCount = getUpperTurningPoints().size() + getLowerTurningPoints().size();

		LOGGER.info(String.format("Turning point count: %d", turningPointCount));

		return turningPointCount >= fluctuatesSlightlyThreshold;
	}

	/**
	 * @return the centredMovingAverages
	 */
	public SortedMap<Long, BigDecimal> getCentredMovingAverages()
	{
		return new TreeMap<>(this.centredMovingAverages);
	}
}
