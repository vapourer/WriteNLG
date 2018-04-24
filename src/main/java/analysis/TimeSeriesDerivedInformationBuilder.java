// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis;

import java.util.List;

import analysis.graph.Point;
import analysis.graph.Segment;

/**
 * Builder for the TimeSeriesDerivedInformation class.
 */
public class TimeSeriesDerivedInformationBuilder
{
	private Point pointWithMaximumValue;
	private Point pointWithMinimumValue;
	private List<Segment> segments;

	/**
	 * Creates a new TimeSeriesDerivedInformation instance.
	 *
	 * @return TimeSeriesDerivedInformation
	 */
	public TimeSeriesDerivedInformation createTimeSeriesDerivedInformation()
	{
		return new TimeSeriesDerivedInformation(this.pointWithMaximumValue, this.pointWithMinimumValue, this.segments);
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
	 * @param pointWithMinimumValue
	 *            the pointWithMinimumValue to set
	 */
	public void setPointWithMinimumValue(Point pointWithMinimumValue)
	{
		this.pointWithMinimumValue = pointWithMinimumValue;
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
