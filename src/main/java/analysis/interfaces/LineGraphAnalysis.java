// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.interfaces;

import analysis.LineGraphDerivedInformation;

/**
 * Analyses input data which represents multiple time series depicted on a line graph. Results are stored in a
 * LineGraphDerivedInformation object.
 */
public interface LineGraphAnalysis
{
	/**
	 * Collects TimeSeriesDerivedInformation instances from TimeSeriesAnalysis analyse calls, for further analysis and
	 * comparison.
	 * 
	 * @return LineGraphDerivedInformation
	 */
	LineGraphDerivedInformation analyse();
}
