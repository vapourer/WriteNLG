// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.graph.LineGraph;
import analysis.graph.Segment;
import analysis.graph.Segmenter;
import analysis.graph.TimeSeries;
import analysis.interfaces.Smoothing;
import analysis.statistics.CrossingSegments;
import analysis.statistics.TimeSeriesCross;
import analysis.statistics.pedergnanafurlani.BottomUpPiecewiseLinearFunction;
import analysis.time.TimeSlice;
import analysis.utilities.GlobalConstants;
import control.WriteNlgProperties;

/**
 * Container for analyses and comparison of multiple time series, based on selected statistical algorithms.
 */
public class LineGraphWithDerivedInformation
{
	private static final Logger LOGGER = LogManager.getLogger("LineGraphWithDerivedInformation.class");

	private final LineGraph lineGraph;
	private final List<TimeSeriesWithDerivedInformation> timeSeriesWithDerivedInformation;
	private final int timeSeriesCount;
	private SortedMap<Long, BigDecimal> averagedDifferencesSmoothed;
	private List<Segment> smoothedAveragedDifferenceSegments;
	private BigDecimal averagedDifferenceMean;

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

		populateAveragedDifferenceInformation();
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
	 * TODO: consider refactoring to use TimesAndWindows class.
	 * 
	 * @param series1
	 * @param series2
	 * @return a List of String representations of time intervals during which lines cross.
	 */
	public List<String> getCrossingPointWindows(TimeSeriesWithDerivedInformation series1,
			TimeSeriesWithDerivedInformation series2)
	{
		final List<CrossingSegments> crossingSegments = new TimeSeriesCross(series1, series2)
				.identifySegmentsWithCrossingPoints();

		final TimeSlice timeSlice = getTimeSlice();

		if (timeSlice.toString().equals("week"))
		{
			return getCrossingPointWindowsByWeek(crossingSegments);
		}
		else
		{
			return getCrossingPointWindowsByTime(crossingSegments, timeSlice);
		}
	}

	private List<String> getCrossingPointWindowsByWeek(final List<CrossingSegments> crossingSegments)
	{
		List<String> crossingPointTimes = new ArrayList<>();

		for (CrossingSegments eachCrossingPair : crossingSegments)
		{
			String window = "during week "
					+ eachCrossingPair.getSegment1().getPoint1().getX().add(GlobalConstants.ONE).intValue();
			crossingPointTimes.add(window);
		}

		return crossingPointTimes;
	}

	private List<String> getCrossingPointWindowsByTime(final List<CrossingSegments> crossingSegments,
			final TimeSlice timeSlice)
	{
		List<String> crossingPointTimes = new ArrayList<>();

		for (CrossingSegments eachCrossingPair : crossingSegments)
		{
			final Segment segment1 = eachCrossingPair.getSegment1();
			final Segment segment2 = eachCrossingPair.getSegment2();

			final Long segment1StartTime = segment1.getStartTime();
			final Long segment2StartTime = segment2.getStartTime();
			final Long segment1EndTime = segment1.getEndTime();
			final Long segment2EndTime = segment2.getEndTime();

			final Long windowStart = segment1StartTime.compareTo(segment2StartTime) < 0 ? segment1StartTime
					: segment2StartTime;
			final Long windowEnd = segment1EndTime.compareTo(segment2EndTime) < 0 ? segment1EndTime : segment2EndTime;

			crossingPointTimes.add(getCrossingPointWindow(windowStart, windowEnd, timeSlice));
		}

		return crossingPointTimes;
	}

	private String getCrossingPointWindow(Long time1, Long time2, TimeSlice timeSlice)
	{
		final Calendar calendar = Calendar.getInstance();

		if (timeSlice.toString().equals("year"))
		{
			calendar.setTimeInMillis(time1.longValue());

			return "during " + calendar.get(Calendar.YEAR);
		}
		else
		{
			DateFormat dateFormatter = new SimpleDateFormat(WriteNlgProperties.getInstance().getProperty("DateFormat"));
			return "between " + dateFormatter.format(new Date(time1)) + " and " + dateFormatter.format(new Date(time2));
		}
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

	/**
	 * @return the averagedDifferencesSmoothed
	 */
	public SortedMap<Long, BigDecimal> getAveragedDifferencesSmoothed()
	{
		return new TreeMap<>(this.averagedDifferencesSmoothed);
	}

	/**
	 * @return the smoothedAveragedDifferenceSegments
	 */
	public List<Segment> getSmoothedAveragedDifferenceSegments()
	{
		return new ArrayList<>(this.smoothedAveragedDifferenceSegments);
	}

	/**
	 * @return the averagedDifferenceMean
	 */
	public BigDecimal getAveragedDifferenceMean()
	{
		return this.averagedDifferenceMean;
	}

	private void populateAveragedDifferenceInformation()
	{
		smoothAveragedDifferences(calculateAveragedDifferences());
		calculateAveragedDifferencesMean();
	}

	private void calculateAveragedDifferencesMean()
	{
		BigDecimal totalValues = GlobalConstants.ZERO;

		for (BigDecimal eachValue : this.averagedDifferencesSmoothed.values())
		{
			totalValues = totalValues.add(eachValue);
		}

		this.averagedDifferenceMean = totalValues.divide(new BigDecimal(this.averagedDifferencesSmoothed.size()),
				new MathContext(WriteNlgProperties.getInstance().getProperty("MathContext")));
	}

	private SortedMap<Long, BigDecimal> calculateAveragedDifferences()
	{
		LOGGER.info(String.format("TimeSeriesWithDerivedInformation size: %d",
				this.timeSeriesWithDerivedInformation.size()));

		SortedMap<Long, BigDecimal> centredMovingAverages1 = this.timeSeriesWithDerivedInformation.get(0)
				.getCentredMovingAverages();
		SortedMap<Long, BigDecimal> centredMovingAverages2 = this.timeSeriesWithDerivedInformation.get(1)
				.getCentredMovingAverages();

		if (centredMovingAverages1.size() != centredMovingAverages2.size())
		{
			LOGGER.error(String.format("Map sizes unequal - centredMovingAverages1: %d; centredMovingAverages2: %d",
					centredMovingAverages1.size(), centredMovingAverages2.size()));
			throw new RuntimeException("Map sizes unequal");
		}

		int averagesCount = centredMovingAverages1.size();

		Long[] keys = centredMovingAverages1.keySet().toArray(new Long[0]);
		BigDecimal[] values1 = centredMovingAverages1.values().toArray(new BigDecimal[0]);
		BigDecimal[] values2 = centredMovingAverages2.values().toArray(new BigDecimal[0]);

		SortedMap<Long, BigDecimal> averagedDifferences = new TreeMap<>();

		for (int i = 0; i < averagesCount; i++)
		{
			averagedDifferences.put(keys[i], (values1[i].subtract(values2[i])).abs());
		}

		return averagedDifferences;
	}

	private void smoothAveragedDifferences(final SortedMap<Long, BigDecimal> averagedDifferences)
	{
		final Smoothing smoothing = new BottomUpPiecewiseLinearFunction(
				new Segmenter(averagedDifferences).createSegments(),
				Integer.parseInt(
						WriteNlgProperties.getInstance().getProperty("MovingAverageMaximumSegmentsAfterSmoothing")),
				true);

		this.averagedDifferencesSmoothed = smoothing.getTimeSeriesSmoothed();
		this.smoothedAveragedDifferenceSegments = smoothing.getSmoothedSegments();

		for (Long eachTime : this.averagedDifferencesSmoothed.keySet())
		{
			LOGGER.info(String.format("averagedDifferencesSmoothed - Time: %s; Difference: %s", eachTime,
					this.averagedDifferencesSmoothed.get(eachTime)));
		}

		for (Segment eachSegment : this.smoothedAveragedDifferenceSegments)
		{
			LOGGER.info(String.format("smoothedAveragedDifferenceSegments - %s", eachSegment));
		}
	}
}
