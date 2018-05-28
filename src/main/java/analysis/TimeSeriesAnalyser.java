// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis;

import java.math.BigDecimal;
import java.util.List;
import java.util.SortedMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.graph.Segment;
import analysis.graph.Segmenter;
import analysis.graph.Slope;
import analysis.graph.TimeSeries;
import analysis.interfaces.Segmentation;
import analysis.interfaces.Smoothing;
import analysis.interfaces.TimeSeriesAnalysis;
import analysis.statistics.Maximum;
import analysis.statistics.Minimum;
import analysis.statistics.engineeringstatisticshandbook.CentredMovingAverage;
import analysis.statistics.pedergnanafurlani.BottomUpPiecewiseLinearFunction;
import analysis.time.TimeSlice;
import control.WriteNlgProperties;

/**
 * Analyses a TimeSeries instance, from which derived information is stored in a TimeSeriesWithDerivedInformation
 * instance.
 */
public class TimeSeriesAnalyser implements TimeSeriesAnalysis
{
	private static final Logger LOGGER = LogManager.getLogger("TimeSeriesAnalyser.class");

	private final TimeSeries timeSeries;
	List<Segment> segments;

	/**
	 * Creates a new TimeSeriesAnalyser instance.
	 * 
	 * @param timeSeries
	 */
	public TimeSeriesAnalyser(final TimeSeries timeSeries)
	{
		this.timeSeries = timeSeries;

		final Segmentation segmenter = new Segmenter(timeSeries);
		this.segments = segmenter.createSegments();

		LOGGER.info("TimeSeriesAnalyser created");
	}

	/**
	 * Analyses this TimeSeries, and stores derived information in a TimeSeriesWithDerivedInformation instance, via a
	 * builder.
	 */
	@Override
	public TimeSeriesWithDerivedInformation analyse()
	{
		LOGGER.info(String.format("Building statistical analysis for %s", this.timeSeries.getSeriesLegend()));

		final TimeSeriesWithDerivedInformationBuilder builder = new TimeSeriesWithDerivedInformationBuilder();

		builder.setTimeSeries(this.timeSeries);
		builder.setPointWithMaximumValue(new Maximum(this.timeSeries).calculate());
		builder.setPointWithMinimumValue(new Minimum(this.timeSeries).calculate());
		builder.setSegments(this.segments);
		builder.setTimeSlice(calculateTimeSlice());

		LOGGER.info("Commencing smoothing");
		final Smoothing smoothing = new BottomUpPiecewiseLinearFunction(this.segments);
		final SortedMap<Long, BigDecimal> timeSeriesSmoothed = smoothing.getTimeSeriesSmoothed();
		builder.setTimeSeriesSmoothed(timeSeriesSmoothed);
		builder.setSmoothedSegments(smoothing.getSmoothedSegments());
		builder.setDirectionOfLongestSegment(
				calculateDirectionOfLongestSegment(smoothing.getSmoothedSegments().toArray(new Segment[0])));

		LOGGER.info("Commencing outline smoothing");
		final int maximumSegmentsForOutlineSmoothing = Integer
				.parseInt(WriteNlgProperties.getInstance().getProperty("MaximumSegmentsAfterSmoothing"));
		final Smoothing outlineSmoothing = new BottomUpPiecewiseLinearFunction(this.segments,
				maximumSegmentsForOutlineSmoothing, true);
		final SortedMap<Long, BigDecimal> timeSeriesOutline = outlineSmoothing.getTimeSeriesSmoothed();
		builder.setTimeSeriesOutline(timeSeriesOutline);
		builder.setOutlineSegments(outlineSmoothing.getSmoothedSegments());

		builder.setCentredMovingAverages(new CentredMovingAverage(this.timeSeries.getSeries(),
				Integer.parseInt(WriteNlgProperties.getInstance().getProperty("MovingAverageWindow"))).averageGraph());

		return builder.createTimeSeriesDerivedInformation();
	}

	private TimeSlice calculateTimeSlice()
	{
		SortedMap<Long, BigDecimal> series = this.timeSeries.getSeries();
		Long[] times = series.keySet().toArray(new Long[0]);
		return new TimeSlice(times[0], times[1]);
	}

	private Slope calculateDirectionOfLongestSegment(final Segment[] smoothedSegments)
	{
		Segment longestSegment = smoothedSegments[0];

		for (int i = 1; i < smoothedSegments.length; i++)
		{
			if (smoothedSegments[i].getXDistance().compareTo(longestSegment.getXDistance()) > 0)
			{
				longestSegment = smoothedSegments[i];
			}
		}

		return longestSegment.getSlope();
	}
}
