// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.substitution;

/**
 * Manages substitutions for use during parsing.
 */
public interface Mapper
{
	/**
	 * Maps values to placeholders.
	 */
	void mapValuesToPlaceHolders();
}
