// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.interfaces;

import analysis.TimeSeriesWithDerivedInformation;

/**
 * Analyses input data which represents a time series, and stores results in a TimeSeriesWithDerivedInformation object.
 */
public interface TimeSeriesAnalysis
{
	/**
	 * Analyses input time series, storing results in a TimeSeriesWithDerivedInformation object.
	 * 
	 * @return TimeSeriesWithDerivedInformation
	 */
	TimeSeriesWithDerivedInformation analyse();
}
