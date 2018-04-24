// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis;

import java.util.ArrayList;
import java.util.List;

/**
 * Container for analyses and comparison of multiple time series, based on selected statistical algorithms.
 */
public class LineGraphDerivedInformation
{
	private final List<TimeSeriesDerivedInformation> timeSeriesDerivedInformation;

	/**
	 * Create a new LineGraphDerivedInformation instance.
	 * 
	 * @param timeSeriesDerivedInformation
	 */
	public LineGraphDerivedInformation(List<TimeSeriesDerivedInformation> timeSeriesDerivedInformation)
	{
		this.timeSeriesDerivedInformation = timeSeriesDerivedInformation;
	}

	/**
	 * @return the timeSeriesDerivedInformation
	 */
	public List<TimeSeriesDerivedInformation> getTimeSeriesDerivedInformation()
	{
		return new ArrayList<>(this.timeSeriesDerivedInformation);
	}
}
