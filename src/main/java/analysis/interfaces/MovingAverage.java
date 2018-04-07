package analysis.interfaces;

import java.math.BigDecimal;
import java.util.SortedMap;

/**
 * Produces a moving average of a dataset which represents a time series.
 */
public interface MovingAverage
{
	/**
	 * Returns a moving average sequence of values from a time series.
	 *
	 * @return a TreeMap of a moving average from a time series with the sequence of times as
	 *         key set.
	 */
	SortedMap<Long, BigDecimal> averageGraph();
}
