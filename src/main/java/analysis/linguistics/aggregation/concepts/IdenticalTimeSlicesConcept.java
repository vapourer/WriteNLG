// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.aggregation.concepts;

import java.util.List;

import analysis.linguistics.contentdetermination.ConstraintType;
import writenlg.aggregation.AbstractAggregationConcept;
import writenlg.constrain.ConstraintGroup;
import writenlg.linguistics.phrase.PhraseSpecification;

/**
 * Rationalises time slice declarations. Current implementation cannot cater for series with time intervals that differ,
 * so this should always be used, with an exception thrown if there is a discrepancy.
 */
public class IdenticalTimeSlicesConcept extends AbstractAggregationConcept
{
	/**
	 * Creates a new IdenticalTimeSlicesConcept instance.
	 * 
	 * @param phraseSpecifications
	 * @param constraintGroup
	 */
	public IdenticalTimeSlicesConcept(List<PhraseSpecification> phraseSpecifications,
			ConstraintGroup<ConstraintType> constraintGroup)
	{
		super(phraseSpecifications, constraintGroup);
	}
}
