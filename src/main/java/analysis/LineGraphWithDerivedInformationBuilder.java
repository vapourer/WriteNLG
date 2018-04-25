// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis;

import java.util.List;

/**
 * Builder for the LineGraphWithDerivedInformation class.
 */
public class LineGraphWithDerivedInformationBuilder
{
	private List<TimeSeriesWithDerivedInformation> timeSeriesWithDerivedInformation;

	/**
	 * Create a new LineGraphWithDerivedInformation instance.
	 * 
	 * @return LineGraphWithDerivedInformation
	 */
	public LineGraphWithDerivedInformation createLineGraphDerivedInformation()
	{
		return new LineGraphWithDerivedInformation(timeSeriesWithDerivedInformation);
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
}
