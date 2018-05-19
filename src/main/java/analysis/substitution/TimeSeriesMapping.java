// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.substitution;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.TimeSeriesWithDerivedInformation;
import writenlg.substitution.Substitutions;

/**
 * Container for Substitutions for this TimeSeries.
 */
public class TimeSeriesMapping
{
	private static final Logger LOGGER = LogManager.getLogger("TimeSeriesMapping.class");

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

		LOGGER.info(
				String.format("TimeSeriesMapping created for %s", timeSeriesWithDerivedInformation.getSeriesLegend()));

		for (String placeHolder : substitutions.getSubstitutions().keySet())
		{
			LOGGER.info(String.format("%s substituted for %s", substitutions.getSubstitutions().get(placeHolder),
					placeHolder));
		}
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
