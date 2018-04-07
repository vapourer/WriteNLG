/**
 *
 */
package analysis.interfaces;

import java.math.BigDecimal;
import java.util.SortedMap;

/**
 * Smoothes a time series.
 */
public interface Smoothing
{
	SortedMap<Long, BigDecimal> smoothGraph();
}
