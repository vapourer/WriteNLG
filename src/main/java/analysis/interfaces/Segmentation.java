// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.interfaces;

import java.util.List;

import analysis.graph.Segment;

/**
 * Segments a dataset which represents a time series.
 */
public interface Segmentation
{
	/**
	 * Returns a List of segments derived from a time series.
	 *
	 * @return a List of Segments.
	 */
	List<Segment> createSegments();
}
