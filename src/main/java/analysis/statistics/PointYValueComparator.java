// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.statistics;

import java.util.Comparator;

import analysis.graph.Point;

/**
 * Compares y-values of two points. Note: this comparator imposes orderings that
 * are inconsistent with equals.
 */
public class PointYValueComparator implements Comparator<Point>
{
	/**
	 * Returns -1, 0, or 1 as the y-value of point1 is numerically less than, equal
	 * to, or greater than that of point2.
	 */
	@Override
	public int compare(Point point1, Point point2)
	{
		return point1.getY().compareTo(point2.getY());
	}
}
