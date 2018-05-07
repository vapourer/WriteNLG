// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.interfaces;

/**
 * Establishes constraint values, based on initial values and weightings input from ANTLR Constraints text file, and
 * analysis of time series data.
 */
public interface Assessor
{
	/**
	 * Implementing classes make initial assessment of loaded constraints, adjusting according to time series data
	 * analysis.
	 */
	void assessConstraints();
}
