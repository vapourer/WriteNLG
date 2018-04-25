// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.interfaces;

import analysis.LineGraphWithDerivedInformation;

/**
 * Analyses input data which represents multiple time series depicted on a line graph. Results are stored in a
 * LineGraphWithDerivedInformation object.
 */
public interface LineGraphAnalysis
{
	/**
	 * Collects TimeSeriesWithDerivedInformation instances from TimeSeriesAnalysis analyse calls, for further analysis and
	 * comparison.
	 * 
	 * @return LineGraphWithDerivedInformation
	 */
	LineGraphWithDerivedInformation analyse();
}
