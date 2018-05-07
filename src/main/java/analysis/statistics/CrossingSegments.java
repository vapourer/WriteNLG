// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.statistics;

import analysis.graph.Segment;

/**
 * Identifies a pair of crossing segments from two time series.
 */
public class CrossingSegments
{
	private final Segment segment1;
	private final Segment segment2;
	private final boolean firstPointsAreEqual;

	/**
	 * Creates a new CrossingSegments instance.
	 * 
	 * @param segment1
	 * @param segment2
	 * @param firstPointsAreEqual
	 */
	public CrossingSegments(final Segment segment1, final Segment segment2, final boolean firstPointsAreEqual)
	{
		this.segment1 = segment1;
		this.segment2 = segment2;
		this.firstPointsAreEqual = firstPointsAreEqual;
	}

	/**
	 * @return the segment1
	 */
	public Segment getSegment1()
	{
		return segment1;
	}

	/**
	 * @return the segment2
	 */
	public Segment getSegment2()
	{
		return segment2;
	}

	/**
	 * @return the firstPointsAreEqual
	 */
	public boolean firstPointsAreEqual()
	{
		return firstPointsAreEqual;
	}
}
