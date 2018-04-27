// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.interfaces;

import java.math.BigDecimal;
import java.util.List;
import java.util.SortedMap;

import analysis.graph.Segment;

/**
 * Smoothes a time series.
 */
public interface Smoothing
{
	/**
	 * @return the timeSeriesSmoothed
	 */
	SortedMap<Long, BigDecimal> getTimeSeriesSmoothed();

	/**
	 * @return the smoothedSegments
	 */
	List<Segment> getSmoothedSegments();
}
