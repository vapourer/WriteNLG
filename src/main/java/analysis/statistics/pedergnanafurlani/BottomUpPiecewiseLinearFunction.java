package analysis.statistics.pedergnanafurlani;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.AbstractQueue;
import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.graph.Segment;
import analysis.interfaces.Smoothing;

/**
 * An implementation of a bottom-up piecewise linear function.
 */
public class BottomUpPiecewiseLinearFunction implements Smoothing
{
	private static final Logger LOGGER = LogManager.getLogger("BottomUpPiecewiseLinearFunction.class");

	private final List<Segment> segments;
	private final SortedMap<Long, BigDecimal> timeSeriesSmoothed;
	private final BigDecimal maximumError;
	private final DateFormat dateFormatter;

	/**
	 * Creates a BottomUpPiecewiseLinearFunction instance.
	 *
	 * @param timeSeries
	 *            A SortedMap containing a time series to be segmented using a
	 *            bottom-up piecewise linear function.
	 * @param pointCount
	 *            The target point count.
	 */
	public BottomUpPiecewiseLinearFunction(final List<Segment> segments, final Properties properties)
	{
		this.segments = segments;
		this.dateFormatter = new SimpleDateFormat(properties.getProperty("DateFormat"));
		this.maximumError = new BigDecimal(properties.getProperty("MaximumError"));
		this.timeSeriesSmoothed = new TreeMap<>();

		LOGGER.info("BottomUpPiecewiseLinearFunction object created");
		LOGGER.info(String.format("BottomUpPiecewiseLinearFunction maximum error = %s", this.maximumError.toString()));
	}

	/**
	 * Returns a segmented sequence of values for a time series.
	 * This implementation uses a bottom-up piecewise linear function.
	 *
	 * @return a TreeMap of a segmented time series with the sequence of times as
	 *         key set.
	 */
	@Override
	public SortedMap<Long, BigDecimal> smoothGraph()
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
		while (cheapestSegmentPair.getCost().compareTo(this.maximumError) <= 0)
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

		populateTimeSeriesSmoothed(queue);

		logSegmentation();

		return this.timeSeriesSmoothed;
	}

	private void populateTimeSeriesSmoothed(final AbstractQueue<SegmentPair> queue)
	{
		// TODO: explore whether the algorithm might be made more concise here.
		for (final SegmentPair segmentPair : queue)
		{
			final Long startTime1 = segmentPair.getSegment1().getStartTime();
			final BigDecimal value1 = segmentPair.getSegment1().getPoint1().getY();
			this.timeSeriesSmoothed.put(startTime1, value1);

			final Long startTime2 = segmentPair.getSegment2().getStartTime();
			final BigDecimal value2 = segmentPair.getSegment2().getPoint1().getY();
			this.timeSeriesSmoothed.put(startTime2, value2);
		}

		final Segment lastSegment = this.segments.get(this.segments.size() - 1);
		this.timeSeriesSmoothed.put(lastSegment.getEndTime(), lastSegment.getPoint2().getY());
	}

	private void logSegmentation()
	{
		LOGGER.info("Segmentation - output from bottom-up piecewise linear function");

		for (final Long eachTime : this.timeSeriesSmoothed.keySet())
		{
			final String formattedDate = this.dateFormatter.format(new Date(eachTime));
			LOGGER.info(String.format("%s\t%s\t", formattedDate, this.timeSeriesSmoothed.get(eachTime).toString()));
		}

		LOGGER.info("End of segmentation output");
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
