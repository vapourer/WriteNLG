// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

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
