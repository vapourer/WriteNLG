// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.substitution;

import analysis.graph.TimeSeries;

/**
 * Container for Substitutions for this TimeSeries.
 */
public class TimeSeriesMapping
{
	private final TimeSeries timeSeries;
	private final Substitutions substitutions;

	/**
	 * Creates a new TimeSeriesMapping instance.
	 * 
	 * @param timeSeries
	 * @param substitutions
	 */
	public TimeSeriesMapping(final TimeSeries timeSeries, Substitutions substitutions)
	{
		this.timeSeries = timeSeries;
		this.substitutions = substitutions;
	}

	/**
	 * @return the timeSeries
	 */
	public TimeSeries getTimeSeries()
	{
		return timeSeries;
	}

	/**
	 * @return the substitutions
	 */
	public Substitutions getSubstitutions()
	{
		return substitutions;
	}
}
