// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.graph;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import writenlg.control.WriteNlgProperties;

/**
 * A point on a two-dimensional line-graph.
 */
public class Point
{
	private final BigDecimal x;
	private final BigDecimal y;
	private final Long date;

	/**
	 * Creates an instance of a Point.
	 * 
	 * @param x
	 * @param y
	 */
	public Point(final BigDecimal x, final BigDecimal y, Long date)
	{
		this.x = x;
		this.y = y;
		this.date = date;
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

	/**
	 * @return the date
	 */
	public Long getDate()
	{
		return date;
	}

	@Override
	public String toString()
	{
		final DateFormat dateFormatter = new SimpleDateFormat(
				WriteNlgProperties.getInstance().getProperty("DateFormat"));
		final String formattedDate = dateFormatter.format(new Date(this.date));
		return String.format("x: %s, y: %s, Date: %s", this.x, this.y, formattedDate);
	}
}
