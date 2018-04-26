// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.substitution;

import java.util.Map;

import analysis.TimeSeriesWithDerivedInformation;

/**
 * Container for Substitutions for this TimeSeries.
 */
public class TimeSeriesMapping
{
	private final TimeSeriesWithDerivedInformation timeSeriesWithDerivedInformation;
	private final Substitutions substitutions;

	/**
	 * Creates a new TimeSeriesMapping instance.
	 * 
	 * @param timeSeriesWithDerivedInformation
	 * @param substitutions
	 */
	public TimeSeriesMapping(final TimeSeriesWithDerivedInformation timeSeriesWithDerivedInformation,
			final Substitutions substitutions)
	{
		this.timeSeriesWithDerivedInformation = timeSeriesWithDerivedInformation;
		this.substitutions = substitutions;
	}

	/**
	 * @return the timeSeriesWithDerivedInformation
	 */
	public TimeSeriesWithDerivedInformation getTimeSeriesWithDerivedInformation()
	{
		return timeSeriesWithDerivedInformation;
	}

	/**
	 * @return the substitutions
	 */
	public Map<String, String> getSubstitutions()
	{
		return this.substitutions.getSubstitutions();
	}
}
