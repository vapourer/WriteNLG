// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.regulator;

/**
 * Manages substitutions for use during parsing.
 */
public class Regulator implements Regulatory
{
	private final Substitutions globalSubstitutions;
	// private final Map<String, Substitutions> seriesSubstitutions;

	/**
	 * Creates a Regulator instance.
	 */
	public Regulator()
	{
		this.globalSubstitutions = new Substitutions();
		// seriesSubstitutions = new HashMap<>();
	}

	/**
	 * Maps substitutions to placeholders.
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
	public Substitutions getSubstitutions()
	{
		return globalSubstitutions;
	}

}
