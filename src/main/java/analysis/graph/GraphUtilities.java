// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.graph;

import java.math.BigDecimal;

/**
 * Graphing utility classes.
 */
public class GraphUtilities
{
	/**
	 * Calculates the Euclidean distance of the segment represented by point1 and point2.
	 * 
	 * @return BigDecimal representing this segment's Euclidean distance.
	 */
	public static BigDecimal calculateEuclideanDistance(Point point1, Point point2)
	{
		double x1 = point1.getX().doubleValue();
		double y1 = point1.getY().doubleValue();
		double x2 = point2.getX().doubleValue();
		double y2 = point2.getY().doubleValue();

		double euclideanDistance = Math.sqrt((Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)));

		return new BigDecimal(euclideanDistance);
	}

	private GraphUtilities()
	{

	}
}
