// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.graph;

import java.math.BigDecimal;
import java.math.MathContext;

import writenlg.control.WriteNlgProperties;

/**
 * A line connecting two points on a two-dimensional line-graph.
 */
public class Segment
{
	private final Point point1;
	private final Point point2;
	private BigDecimal euclideanDistance;
	private BigDecimal xDistance;
	private BigDecimal yDistance;
	private BigDecimal gradient;
	private Slope slope;

	/**
	 * Creates a Segment instance.
	 *
	 * @param point1
	 * @param point2
	 */
	public Segment(final Point point1, final Point point2)
	{
		this.point1 = point1;
		this.point2 = point2;
	}

	/**
	 * @return the point1
	 */
	public Point getPoint1()
	{
		return this.point1;
	}

	/**
	 * @return the point2
	 */
	public Point getPoint2()
	{
		return this.point2;
	}

	/**
	 * @return the startTime
	 */
	public Long getStartTime()
	{
		return point1.getDate();
	}

	/**
	 * @return the endTime
	 */
	public Long getEndTime()
	{
		return point2.getDate();
	}

	/**
	 * @return the euclideanDistance
	 */
	public BigDecimal getEuclideanDistance()
	{
		if (this.euclideanDistance == null)
		{
			this.euclideanDistance = GraphUtilities.calculateEuclideanDistance(this.point1, this.point2);
		}

		return this.euclideanDistance;
	}

	/**
	 * @return the xDistance
	 */
	public BigDecimal getXDistance()
	{
		if (this.xDistance == null)
		{
			this.xDistance = this.point2.getX().subtract(this.point1.getX());
		}

		return this.xDistance;
	}

	/**
	 * @return the yDistance
	 */
	public BigDecimal getYDistance()
	{
		if (this.yDistance == null)
		{
			this.yDistance = this.point2.getY().subtract(this.point1.getY());
		}

		return this.yDistance;
	}

	/**
	 * @return the gradient
	 */
	public BigDecimal getGradient()
	{
		if (this.gradient == null)
		{
			String mathContextConfiguration = WriteNlgProperties.getInstance().getProperty("MathContext");
			MathContext context = new MathContext(mathContextConfiguration);
			this.gradient = getYDistance().divide(getXDistance(), context);
		}

		return gradient;
	}

	/**
	 * @return the slope
	 */
	public Slope getSlope()
	{
		if (this.slope == null)
		{
			setSlopeFromGradient();
		}

		return this.slope;
	}

	private void setSlopeFromGradient()
	{
		BigDecimal zero = new BigDecimal("0");

		if (getGradient().compareTo(zero) > 0)
		{
			this.slope = Slope.ASCENDING;
		}
		else if (getGradient().compareTo(zero) < 0)
		{
			this.slope = Slope.DESCENDING;
		}
		else
		{
			this.slope = Slope.FLAT;
		}
	}

	@Override
	public String toString()
	{
		MathContext context = new MathContext(WriteNlgProperties.getInstance().getProperty("MathContext"));

		return String.format(
				"Point 1 = %s; Point 2 = %s; Euclidean distance = %s; x distance = %s; y distance = %s; Gradient = %s; Slope = %s",
				this.point1, this.point2, getEuclideanDistance().round(context), getXDistance(), getYDistance(),
				getGradient(), getSlope().getTextualForm());
	}
}
