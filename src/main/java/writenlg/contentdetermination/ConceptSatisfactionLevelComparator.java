// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.contentdetermination;

import java.util.Comparator;

import writenlg.AbstractConcept;

/**
 * Compares weighted satisfaction levels of two AbstractConcept instances. Note: this comparator imposes orderings that
 * are inconsistent with equals.
 */
public class ConceptSatisfactionLevelComparator implements Comparator<AbstractConcept>
{
	/**
	 * Returns -1, 0, or 1 as the weighted level of concept1 is numerically less than, equal
	 * to, or greater than that of concept2.
	 */
	@Override
	public int compare(AbstractConcept concept1, AbstractConcept concept2)
	{
		return concept1.calculateSatisfactionLevel().compareTo(concept2.calculateSatisfactionLevel());
	}
}
