package analysis.statistics.engineeringstatisticshandbook;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.interfaces.MovingAverage;

/**
 * An implementation of a centred moving average algorithm.
 */
public class CentredMovingAverage implements MovingAverage
{
	private static final Logger LOGGER = LogManager.getLogger("CentredMovingAverage.class");

	private final int movingSubsetSize;
	private final SortedMap<Long, BigDecimal> timeSeries;
	private final SortedMap<Long, BigDecimal> lineGraphAveraged;

	/**
	 * Creates a CentredMovingAverage instance.
	 *
	 * @param timeSeries
	 *            A SortedMap containing a time series to be smoothed
	 *            using a centred moving average algorithm.
	 * @param movingSubsetSize
	 *            The size of the set of values from which each average is
	 *            calculated.
	 */
	public CentredMovingAverage(final SortedMap<Long, BigDecimal> timeSeries, final int movingSubsetSize)
	{
		this.timeSeries = timeSeries;
		this.movingSubsetSize = movingSubsetSize;
		this.lineGraphAveraged = new TreeMap<>();

		LOGGER.info("CentredMovingAverage object created");
		LOGGER.info(String.format("CentredMovingAverage moving subset size = %d", movingSubsetSize));
	}

	/**
	 * Returns a moving average sequence of values for each time series.
	 * TODO: this is not an optimal implementation of this algorithm.
	 *
	 * @return a TreeMap of a moving average from a time series with the sequence of times as
	 *         key set.
	 */
	@Override
	public SortedMap<Long, BigDecimal> averageGraph()
	{
		final Long[] times = ((SortedSet<Long>) this.timeSeries.keySet()).toArray(new Long[0]);

		int timeIndex = 0;
		long total = 0L;

		for (final Long time : times)
		{
			if (timeIndex < this.movingSubsetSize)
			{
				total += this.timeSeries.get(time).longValue();
				timeIndex++;
			}
			else
			{
				final int windowStartIndex = timeIndex - this.movingSubsetSize;
				calculateAndStoreAverage(total, calculateKey(times, windowStartIndex));

				total -= this.timeSeries.get(times[windowStartIndex]).longValue();
				total += this.timeSeries.get(time).longValue();

				timeIndex++;
			}
		}

		calculateAndStoreAverage(total, calculateKey(times, timeIndex - this.movingSubsetSize));

		log();

		return this.lineGraphAveraged;
	}

	private Long calculateKey(final Long[] times, final int windowStartIndex)
	{
		final int keyIndex = windowStartIndex + this.movingSubsetSize / 2;
		return times[keyIndex];
	}

	private void calculateAndStoreAverage(final long total, final Long key)
	{
		final BigDecimal average = new BigDecimal(total).divide(new BigDecimal(this.movingSubsetSize));
		this.lineGraphAveraged.put(key, average);
	}

	private void log()
	{
		final DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

		LOGGER.info("Centred moving average output");

		for (final Long eachTime : this.lineGraphAveraged.keySet())
		{

			final String formattedDate = dateFormatter.format(new Date(eachTime));
			LOGGER.info(String.format("%s\t%s", formattedDate, this.lineGraphAveraged.get(eachTime)));
		}

		LOGGER.info("End of centred moving average output");
	}
}
