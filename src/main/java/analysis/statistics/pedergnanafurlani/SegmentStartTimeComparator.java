// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.statistics.pedergnanafurlani;

import java.math.BigDecimal;
import java.util.Comparator;

import analysis.graph.Segment;

/**
 * Orders Segment instances according to x-value of first point. Note: this comparator imposes orderings that
 * are inconsistent with equals.
 */
public class SegmentStartTimeComparator implements Comparator<Segment>
{
	/**
	 * Returns -1, 0, or 1 as the x-value of segment1's point1 is numerically less than, equal
	 * to, or greater than that of segment2's point1.
	 */
	@Override
	public int compare(Segment segment1, Segment segment2)
	{
		BigDecimal firstPoint = segment1.getPoint1().getX();
		BigDecimal secondPoint = segment2.getPoint1().getX();
		return firstPoint.compareTo(secondPoint);
	}
}
