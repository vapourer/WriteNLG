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

	/**
	 * Create a new LineGraphWithDerivedInformation instance.
	 * 
	 * @return LineGraphWithDerivedInformation
	 */
	public LineGraphWithDerivedInformation createLineGraphDerivedInformation()
	{
		return new LineGraphWithDerivedInformation(this.lineGraph, this.timeSeriesWithDerivedInformation);
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
}
