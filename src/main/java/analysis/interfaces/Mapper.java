// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.interfaces;

import java.util.List;

import analysis.substitution.TimeSeriesMapping;
import writenlg.substitution.Substitutions;

/**
 * Manages substitutions for use during parsing.
 */
public interface Mapper
{
	/**
	 * @return the globalMappings
	 */
	Substitutions getGlobalMappings();

	/**
	 * @return the timeSeriesMappings
	 */
	List<TimeSeriesMapping> getTimeSeriesMappings();
}
