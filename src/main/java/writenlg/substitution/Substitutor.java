// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.substitution;

import java.util.ArrayList;
import java.util.List;

import analysis.LineGraphWithDerivedInformation;
import analysis.TimeSeriesWithDerivedInformation;

/**
 * Manages globalSubstitutions for use during parsing.
 */
public class Substitutor implements Mapper
{
	private final LineGraphWithDerivedInformation lineGraphWithDerivedInformation;
	private final Substitutions globalSubstitutions;
	private final List<TimeSeriesMapping> timeSeriesMappings;

	/**
	 * Creates a Substitutor instance.
	 */
	public Substitutor(final LineGraphWithDerivedInformation lineGraphWithDerivedInformation)
	{
		this.lineGraphWithDerivedInformation = lineGraphWithDerivedInformation;
		this.globalSubstitutions = new Substitutions();
		this.timeSeriesMappings = new ArrayList<>();
	}

	/**
	 * Maps substitutions to place-holders.
	 * 
	 * @param placeHolder
	 * @param substitute
	 */
	@Override
	public void mapValuesToPlaceHolders()
	{
		List<TimeSeriesWithDerivedInformation> timeSeriesWithDerivedInformation = lineGraphWithDerivedInformation
				.getTimeSeriesDerivedInformation();

		for (TimeSeriesWithDerivedInformation eachTimeSeriesWithDerivedInformation : timeSeriesWithDerivedInformation)
		{
			Substitutions substitutions = new Substitutions();
			substitutions.addSubstitution("@@SeriesLegend@@", eachTimeSeriesWithDerivedInformation.getSeriesLegend());
			substitutions.addSubstitution("@@TimeSlice@@",
					eachTimeSeriesWithDerivedInformation.getTimeSlice().toString());
			substitutions.addSubstitution("@@Maximum@@",
					eachTimeSeriesWithDerivedInformation.getPointWithMaximumValue().getY().toString());
			substitutions.addSubstitution("@@Minimum@@",
					eachTimeSeriesWithDerivedInformation.getPointWithMinimumValue().getY().toString());
			this.timeSeriesMappings.add(new TimeSeriesMapping(eachTimeSeriesWithDerivedInformation, substitutions));
		}
	}

	/**
	 * @return the globalSubstitutions
	 */
	public Substitutions getGlobalSubstitutions()
	{
		return globalSubstitutions;
	}

	/**
	 * @return the timeSeriesMappings
	 */
	public List<TimeSeriesMapping> getTimeSeriesMappings()
	{
		return new ArrayList<>(this.timeSeriesMappings);
	}
}
