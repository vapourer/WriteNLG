// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.statistics.pedergnanafurlani;

import java.util.Comparator;

/**
 * Compares costs of two segment pairs. Note: this comparator imposes orderings that
 * are inconsistent with equals.
 */
public class CostComparator implements Comparator<SegmentPair>
{
	/**
	 * Returns -1, 0, or 1 as the cost of segmentPair1 is numerically less than, equal
	 * to, or greater than that of segmentPair2.
	 */
	@Override
	public int compare(SegmentPair segmentPair1, SegmentPair segmentPair2)
	{
		return segmentPair1.getCost().compareTo(segmentPair2.getCost());
	}
}
