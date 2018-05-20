// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.aggregation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import analysis.linguistics.contentdetermination.ConstraintType;
import writenlg.AbstractConcept;
import writenlg.constrain.ConstraintGroup;
import writenlg.linguistics.phrase.PhraseSpecification;

/**
 * Abstract class, extensions of which represent time series analysis concepts, for use in an aggregation stage of
 * creating NLG summaries of graphs representing time series.
 */
public abstract class AbstractAggregationConcept extends AbstractConcept
{
	private final Set<ConceptGroup> conceptGroups;

	public AbstractAggregationConcept(List<PhraseSpecification> phraseSpecifications,
			ConstraintGroup<ConstraintType> constraintGroup)
	{
		super(phraseSpecifications, constraintGroup);
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
