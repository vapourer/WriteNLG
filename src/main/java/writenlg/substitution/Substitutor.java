// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.substitution;

import java.util.HashMap;
import java.util.Map;

import analysis.LineGraphDerivedInformation;
import analysis.graph.TimeSeries;

/**
 * Manages globalSubstitutions for use during parsing.
 */
public class Substitutor implements Mapper
{
	private final LineGraphDerivedInformation lineGraphDerivedInformation;
	private final Substitutions globalSubstitutions;
	private final Map<TimeSeries, Substitutions> seriesSubstitutions;

	/**
	 * Creates a Substitutor instance.
	 */
	public Substitutor(final LineGraphDerivedInformation lineGraphDerivedInformation)
	{
		this.lineGraphDerivedInformation = lineGraphDerivedInformation;
		this.globalSubstitutions = new Substitutions();
		this.seriesSubstitutions = new HashMap<>();
	}

	public void mapPlaceHolders()
	{
		mapPlaceHolder("@@Maximum@@", lineGraphDerivedInformation.getTimeSeriesDerivedInformation().get(0)
				.getPointWithMaximumValue().getY().toString());

		mapPlaceHolder("@@Minimum@@", lineGraphDerivedInformation.getTimeSeriesDerivedInformation().get(0)
				.getPointWithMinimumValue().getY().toString());
	}

	/**
	 * Maps globalSubstitutions to placeholders.
	 * 
	 * @param placeHolder
	 * @param substitute
	 */
	@Override
	public void mapPlaceHolder(final String placeHolder, final String substitute)
	{
		this.globalSubstitutions.addSubstitution(placeHolder, substitute);
	}

	/**
	 * @return the globalSubstitutions
	 */
	public Substitutions getGlobalSubstitutions()
	{
		return globalSubstitutions;
	}

}
