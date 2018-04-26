// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis;

import java.util.List;

import analysis.graph.LineGraph;

/**
 * Builder for the LineGraphWithDerivedInformation class.
 */
public class LineGraphWithDerivedInformationBuilder
{
	private LineGraph lineGraph;
	private List<TimeSeriesWithDerivedInformation> timeSeriesWithDerivedInformation;
	private int timeSeriesCount;

	/**
	 * Create a new LineGraphWithDerivedInformation instance.
	 * 
	 * @return LineGraphWithDerivedInformation
	 */
	public LineGraphWithDerivedInformation createLineGraphDerivedInformation()
	{
		return new LineGraphWithDerivedInformation(this.lineGraph, this.timeSeriesWithDerivedInformation,
				this.timeSeriesCount);
	}

	/**
	 * @param timeSeriesWithDerivedInformation
	 *            the timeSeriesWithDerivedInformation to set
	 */
	public void setTimeSeriesWithDerivedInformation(
			List<TimeSeriesWithDerivedInformation> timeSeriesWithDerivedInformation)
	{
		this.timeSeriesWithDerivedInformation = timeSeriesWithDerivedInformation;
	}

	/**
	 * @param lineGraph
	 *            the lineGraph to set
	 */
	public void setLineGraph(LineGraph lineGraph)
	{
		this.lineGraph = lineGraph;
	}

	/**
	 * @param timeSeriesCount
	 *            the timeSeriesCount to set
	 */
	public void setTimeSeriesCount(int timeSeriesCount)
	{
		this.timeSeriesCount = timeSeriesCount;
	}
}
