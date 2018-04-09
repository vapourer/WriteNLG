// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.graph;

import java.math.BigDecimal;

/**
 * A point on a two-dimensional line-graph.
 */
public class Point
{
	private final BigDecimal x;
	private final BigDecimal y;

	/**
	 * Creates an instance of a Point.
	 * 
	 * @param x
	 * @param y
	 */
	public Point(final BigDecimal x, final BigDecimal y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * @return the x value
	 */
	public BigDecimal getX()
	{
		return this.x;
	}

	/**
	 * @return the y value
	 */
	public BigDecimal getY()
	{
		return this.y;
	}
}
