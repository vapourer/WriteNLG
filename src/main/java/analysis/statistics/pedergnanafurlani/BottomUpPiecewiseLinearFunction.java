// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.statistics.pedergnanafurlani;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.graph.Segment;
import analysis.interfaces.Smoothing;
import control.WriteNlgProperties;

/**
 * An implementation of a bottom-up piecewise linear function.
 */
public class BottomUpPiecewiseLinearFunction implements Smoothing
{
	private static final Logger LOGGER = LogManager.getLogger("BottomUpPiecewiseLinearFunction.class");

	private final List<Segment> segments;
	private final SortedMap<Long, BigDecimal> timeSeriesSmoothed;
	private final SortedSet<Segment> smoothedSegments;
	private final BigDecimal maximumError;
	private final DateFormat dateFormatter;
	private final int maximumSegments;
	private final boolean waiveMaximumErrorCheck;

	/**
	 * Creates a BottomUpPiecewiseLinearFunction instance.
	 * 
	 * @param segments
	 */
	public BottomUpPiecewiseLinearFunction(final List<Segment> segments)
	{
		this(segments, 1, false);
	}

	/**
	 * Creates a BottomUpPiecewiseLinearFunction instance.
	 * 
	 * @param segments
	 * @param maximumSegments
	 */
	public BottomUpPiecewiseLinearFunction(final List<Segment> segments, final int maximumSegments,
			final boolean waiveMaximumErrorCheck)
	{
		this.segments = segments;
		this.dateFormatter = new SimpleDateFormat(WriteNlgProperties.getInstance().getProperty("DateFormat"));
		this.maximumError = new BigDecimal(WriteNlgProperties.getInstance().getProperty("MaximumError"));
		this.timeSeriesSmoothed = new TreeMap<>();
		this.smoothedSegments = new TreeSet<>(new SegmentStartTimeComparator());
		this.maximumSegments = maximumSegments;
		this.waiveMaximumErrorCheck = waiveMaximumErrorCheck;

		LOGGER.info("BottomUpPiecewiseLinearFunction object created");
		LOGGER.info(String.format("BottomUpPiecewiseLinearFunction maximum error = %s", this.maximumError.toString()));

		smoothGraph();
	}

	/**
	 * @return the timeSeriesSmoothed
	 */
	@Override
	public SortedMap<Long, BigDecimal> getTimeSeriesSmoothed()
	{
		return new TreeMap<>(this.timeSeriesSmoothed);
	}

	/**
	 * @return the smoothedSegments
	 */
	@Override
	public List<Segment> getSmoothedSegments()
	{
		return new ArrayList<>(this.smoothedSegments);
	}

	/**
	 * Returns a segmented sequence of values for a time series.
	 * This implementation uses a bottom-up piecewise linear function.
	 *
	 * @return a TreeMap of a segmented time series with the sequence of times as
	 *         key set.
	 */
	private void smoothGraph()
	{
		final AbstractQueue<SegmentPair> queue = new PriorityQueue<>(new CostComparator());
		final int segmentPairCount = this.segments.size() - 1;

		for (int i = 0; i < segmentPairCount; i++)
		{
			queue.add(new SegmentPair(this.segments.get(i), this.segments.get(i + 1)));
		}

		LOGGER.info("PriorityQueue created");
		LOGGER.info("Queue - output initial state");
		logQueueState(queue, this.dateFormatter);
		LOGGER.info("Queue initial state output complete");

		SegmentPair cheapestSegmentPair = queue.peek();

		// TODO: explore whether the algorithm might be made more concise here.
		while ((cheapestSegmentPair.getCost().compareTo(this.maximumError) <= 0 || this.waiveMaximumErrorCheck)
				&& queue.size() > this.maximumSegments)
		{
			cheapestSegmentPair = queue.poll();
			SegmentPair nextSegmentPair = null;

			for (final SegmentPair segmentPair : queue)
			{
				final Segment segment1 = segmentPair.getSegment1();
				final Segment segment2 = cheapestSegmentPair.getSegment2();

				if (segment1.getStartTime().compareTo(segment2.getStartTime()) == 0)
				{
					nextSegmentPair = segmentPair;
					queue.remove(segmentPair);
					break;
				}
			}

			final Segment amalgamatedSegment = cheapestSegmentPair.convert();

			if (nextSegmentPair != null)
			{
				final SegmentPair amalgamatedSegmentPair = new SegmentPair(amalgamatedSegment,
						nextSegmentPair.getSegment2());
				queue.add(amalgamatedSegmentPair);
			}

			for (final SegmentPair segmentPair : queue)
			{
				final Segment segment1 = segmentPair.getSegment2();
				final Segment segment2 = cheapestSegmentPair.getSegment1();

				if (segment1.getStartTime().compareTo(segment2.getStartTime()) == 0)
				{
					segmentPair.setSegment2(amalgamatedSegment);
					break;
				}
			}

			LOGGER.info("Queue - output state after head removed");
			logQueueState(queue, this.dateFormatter);
			LOGGER.info("Queue - output of state after head removed complete");

			cheapestSegmentPair = queue.peek();
		}

		populateSmoothedCollections(queue);

		logSegmentation();
	}

	private void populateSmoothedCollections(final AbstractQueue<SegmentPair> queue)
	{
		LOGGER.info("Populating collections of smoothed time series data");

		// TODO: explore whether the algorithm might be made more concise here.
		for (final SegmentPair segmentPair : queue)
		{
			final Segment segment1 = segmentPair.getSegment1();
			this.smoothedSegments.add(segment1);

			final Segment segment2 = segmentPair.getSegment2();

			final Long startTime1 = segment1.getStartTime();
			final BigDecimal value1 = segment1.getPoint1().getY();
			this.timeSeriesSmoothed.put(startTime1, value1);

			final Long startTime2 = segment2.getStartTime();
			final BigDecimal value2 = segment2.getPoint1().getY();
			this.timeSeriesSmoothed.put(startTime2, value2);

			if (queue.peek() == null)
			{
				final Segment lastSmoothedSegment = this.smoothedSegments.last();
				this.smoothedSegments.remove(lastSmoothedSegment);
				this.smoothedSegments.add(
						new SegmentPair(lastSmoothedSegment, this.segments.get(this.segments.size() - 1)).convert());
			}
		}

		final Segment lastSegment = this.segments.get(this.segments.size() - 1);
		this.timeSeriesSmoothed.put(lastSegment.getEndTime(), lastSegment.getPoint2().getY());
	}

	private void logSegmentation()
	{
		LOGGER.info("Segmentation - output from bottom-up piecewise linear function as time/value pairs");

		for (final Long eachTime : this.timeSeriesSmoothed.keySet())
		{
			final String formattedDate = this.dateFormatter.format(new Date(eachTime));
			LOGGER.info(String.format("%s\t%s\t", formattedDate, this.timeSeriesSmoothed.get(eachTime).toString()));
		}

		LOGGER.info("End of time/value pair segmentation output");

		LOGGER.info("Segmentation - List of smoothed segments from bottom-up piecewise linear function");

		for (Segment eachSegment : this.smoothedSegments)
		{
			LOGGER.info(String.format("Smoothed segment: %s", eachSegment));
		}

		LOGGER.info("End of list of smoothed segments");
	}

	private void logQueueState(final AbstractQueue<SegmentPair> queue, final DateFormat dateFormatter)
	{
		for (final SegmentPair eachPair : queue)
		{
			final String formattedDate1 = dateFormatter.format(new Date(eachPair.getSegment1().getStartTime()));
			final String formattedDate2 = dateFormatter.format(new Date(eachPair.getSegment2().getStartTime()));
			LOGGER.info(String.format("Time 1: %s\tTime 2: %s\tCost: %f.", formattedDate1, formattedDate2,
					eachPair.getCost().doubleValue()));
		}
	}
}
