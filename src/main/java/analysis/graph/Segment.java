package analysis.graph;

import java.math.BigDecimal;

/**
 * A line connecting two points on a two-dimensional line-graph.
 */
public class Segment
{
	private final Point point1;
	private final Point point2;
	private final Long startTime;
	private final Long endTime;
	private BigDecimal euclideanDistance;
	private BigDecimal xDistance;
	private BigDecimal yDistance;
	private Long period;
	private int timeSlices;

	/**
	 * Creates a Segment instance.
	 *
	 * @param point1
	 * @param point2
	 * @param startTime
	 */
	public Segment(final Point point1, final Point point2, final Long startTime, final Long endTime)
	{
		this.point1 = point1;
		this.point2 = point2;
		this.startTime = startTime;
		this.endTime = endTime;
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
		return this.startTime;
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
	public BigDecimal getxDistance()
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
	public BigDecimal getyDistance()
	{
		if (this.yDistance == null)
		{
			this.yDistance = this.point2.getY().subtract(this.point1.getY());
		}

		return this.yDistance;
	}

	/**
	 * @return the period
	 */
	public Long getPeriod()
	{
		if (this.yDistance == null)
		{
			this.yDistance = this.point2.getY().subtract(this.point1.getY());
		}

		return this.period;
	}

	/**
	 * @return the timeSlices
	 */
	public int getTimeSlices()
	{
		return this.timeSlices;
	}

	/**
	 * @param timeSlices
	 *            the timeSlices to set
	 */
	public void setTimeSlices(final int timeSlices)
	{
		this.timeSlices = timeSlices;
	}

	/**
	 * @return the endTime
	 */
	public Long getEndTime()
	{
		return endTime;
	}
}
