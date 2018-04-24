// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.statistics.pedergnanafurlani;

import java.math.BigDecimal;

import analysis.graph.GraphUtilities;
import analysis.graph.Segment;

/**
 * A segment pair and associated cost. Required for piecewise linear function implementations.
 */
public class SegmentPair
{
	private final Segment segment1;
	private BigDecimal cost;
	private Segment segment2;

	/**
	 * Creates an instance of a SegmentPair.
	 *
	 * @param segment1
	 * @param segment2
	 * @param cost
	 */
	public SegmentPair(final Segment segment1, final Segment segment2)
	{
		this.segment1 = segment1;
		this.segment2 = segment2;

		final BigDecimal euclideanDistance = GraphUtilities.calculateEuclideanDistance(this.segment1.getPoint1(),
				this.segment2.getPoint2());
		this.cost = (this.segment1.getEuclideanDistance().add(this.segment2.getEuclideanDistance()))
				.subtract(euclideanDistance);
	}

	/**
	 * Converts this SegmentPair into a Segment joining the first point of segment 1 and the second point of segment 2.
	 *
	 * @return a new Segment which combines the two segments that comprise this SegmentPair.
	 */
	public Segment convert()
	{
		return new Segment(this.segment1.getPoint1(), this.segment2.getPoint2());
	}

	/**
	 * @return segment1
	 */
	public Segment getSegment1()
	{
		return this.segment1;
	}

	/**
	 * @return the cost
	 */
	public BigDecimal getCost()
	{
		return this.cost;
	}

	/**
	 * @return the segment2
	 */
	public Segment getSegment2()
	{
		return this.segment2;
	}

	/**
	 * @param segment2
	 *            the segment2 to set
	 */
	public void setSegment2(final Segment segment2)
	{
		this.segment2 = segment2;
		final BigDecimal euclideanDistance = GraphUtilities.calculateEuclideanDistance(this.segment1.getPoint1(),
				this.segment2.getPoint2());
		this.cost = (this.segment1.getEuclideanDistance().add(this.segment2.getEuclideanDistance()))
				.subtract(euclideanDistance);
	}
}
