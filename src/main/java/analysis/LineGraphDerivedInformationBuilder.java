// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis;

import java.util.List;

/**
 * Builder for the LineGraphDerivedInformation class.
 */
public class LineGraphDerivedInformationBuilder
{
	private List<TimeSeriesDerivedInformation> timeSeriesDerivedInformation;

	/**
	 * Create a new LineGraphDerivedInformation instance.
	 * 
	 * @return LineGraphDerivedInformation
	 */
	public LineGraphDerivedInformation createLineGraphDerivedInformation()
	{
		return new LineGraphDerivedInformation(timeSeriesDerivedInformation);
	}

	/**
	 * @param timeSeriesDerivedInformation
	 *            the timeSeriesDerivedInformation to set
	 */
	public void setTimeSeriesDerivedInformation(List<TimeSeriesDerivedInformation> timeSeriesDerivedInformation)
	{
		this.timeSeriesDerivedInformation = timeSeriesDerivedInformation;
	}
}
