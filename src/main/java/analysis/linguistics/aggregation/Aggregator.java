// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.aggregation;

import java.util.HashSet;
import java.util.Set;

/**
 * Performs aggregation in conjunction with document planning, according to constraints
 */
public class Aggregator
{
	private final Set<ConceptGroup> conceptGroups;

	public Aggregator()
	{
		this.conceptGroups = new HashSet<>();
	}

	/**
	 * @param group
	 */
	public void addConceptGroup(final ConceptGroup group)
	{
		this.conceptGroups.add(group);
	}
}
