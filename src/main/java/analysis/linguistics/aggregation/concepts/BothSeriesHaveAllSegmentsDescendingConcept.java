// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.aggregation.concepts;

import java.util.List;

import analysis.linguistics.contentdetermination.ConstraintType;
import writenlg.aggregation.AbstractAggregationConcept;
import writenlg.constrain.ConstraintGroup;
import writenlg.linguistics.phrase.PhraseSpecification;

/**
 * Aggregates if both series have all segments descending.
 */
public class BothSeriesHaveAllSegmentsDescendingConcept extends AbstractAggregationConcept
{
	/**
	 * Creates a new BothSeriesHaveAllSegmentsDescendingConcept instance.
	 * 
	 * @param phraseSpecifications
	 * @param constraintGroup
	 */
	public BothSeriesHaveAllSegmentsDescendingConcept(List<PhraseSpecification> phraseSpecifications,
			ConstraintGroup<ConstraintType> constraintGroup)
	{
		super(phraseSpecifications, constraintGroup);
	}
}
