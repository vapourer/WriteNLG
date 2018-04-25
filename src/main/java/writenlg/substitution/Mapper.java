// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.substitution;

/**
 * Manages substitutions for use during parsing.
 */
public interface Mapper
{
	/**
	 * Maps substitutions to placeholders.
	 * 
	 * @param placeHolder
	 * @param substitute
	 */
	void mapPlaceHolder(String placeHolder, String substitute);

	/**
	 * @return Substitutions
	 */
	// Substitutions getSubstitutions();
}
