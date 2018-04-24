// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis;

import java.util.List;

import analysis.graph.Point;
import analysis.graph.Segment;

/**
 * Builder for the Analysis class.
 */
public class AnalysisBuilder
{
	private Point pointWithMaximumValue;
	private Point pointWithMinimumValue;
	private List<Segment> segments;

	/**
	 * Creates a new Analysis instance.
	 *
	 * @return Analysis
	 */
	public Analysis createAnalysis()
	{
		return new Analysis(this.pointWithMaximumValue, this.pointWithMinimumValue, this.segments);
	}

	/**
	 * @return the pointWithMaximumValue
	 */
	public Point getPointWithMaximumValue()
	{
		return pointWithMaximumValue;
	}

	/**
	 * @param pointWithMaximumValue
	 *            the pointWithMaximumValue to set
	 */
	public void setPointWithMaximumValue(Point pointWithMaximumValue)
	{
		this.pointWithMaximumValue = pointWithMaximumValue;
	}

	/**
	 * @return the pointWithMinimumValue
	 */
	public Point getPointWithMinimumValue()
	{
		return pointWithMinimumValue;
	}

	/**
	 * @param pointWithMinimumValue
	 *            the pointWithMinimumValue to set
	 */
	public void setPointWithMinimumValue(Point pointWithMinimumValue)
	{
		this.pointWithMinimumValue = pointWithMinimumValue;
	}

	/**
	 * @return the segments
	 */
	public List<Segment> getSegments()
	{
		return this.segments;
	}

	/**
	 * @param segments
	 *            the segments to set
	 */
	public void setSegments(final List<Segment> segments)
	{
		this.segments = segments;
	}
}
