// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.constrain;

import java.util.Comparator;

/**
 * Compares weighted levels of two satisfaction levels. Note: this comparator imposes orderings that
 * are inconsistent with equals.
 */
public class SatisfactionLevelComparator implements Comparator<SatisfactionLevel>
{
	/**
	 * Returns -1, 0, or 1 as the weighted level of level1 is numerically less than, equal
	 * to, or greater than that of level2.
	 */
	@Override
	public int compare(SatisfactionLevel level1, SatisfactionLevel level2)
	{
		return level1.getWeightedLevel().compareTo(level2.getWeightedLevel());
	}
}
