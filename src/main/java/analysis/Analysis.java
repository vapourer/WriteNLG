// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis;

import java.util.List;

import analysis.graph.Point;
import analysis.graph.Segment;

/**
 * Container for analyses, based on selected statistical algorithms.
 */
public class Analysis
{
	private final Point pointWithMaximumValue;
	private final Point pointWithMinimumValue;
	private final List<Segment> segments;

	/**
	 * Creates an Analysis instance.
	 * 
	 * @param pointWithMaximumValue
	 * @param pointWithMinimumValue
	 * @param segments
	 */
	public Analysis(final Point pointWithMaximumValue, final Point pointWithMinimumValue, final List<Segment> segments)
	{
		this.pointWithMaximumValue = pointWithMaximumValue;
		this.pointWithMinimumValue = pointWithMinimumValue;
		this.segments = segments;
	}

	/**
	 * @return the pointWithMaximumValue
	 */
	public Point getPointWithMaximumValue()
	{
		return pointWithMaximumValue;
	}

	/**
	 * @return the pointWithMinimumValue
	 */
	public Point getPointWithMinimumValue()
	{
		return pointWithMinimumValue;
	}

	/**
	 * @return the segments
	 */
	public List<Segment> getSegments()
	{
		return segments;
	}
}
