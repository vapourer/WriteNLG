// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.regulator;

/**
 * Manages substitutions for use during parsing.
 */
public interface Regulatory
{
	/**
	 * Maps substitutions to placeholders.
	 * 
	 * @param placeHolder
	 * @param substitute
	 */
	void mapPlaceHolder(String placeHolder, String substitute);
}
