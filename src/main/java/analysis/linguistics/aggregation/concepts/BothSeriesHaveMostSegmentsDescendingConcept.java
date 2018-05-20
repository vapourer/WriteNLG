// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.aggregation.concepts;

import java.util.List;

import analysis.linguistics.contentdetermination.ConstraintType;
import writenlg.aggregation.AbstractAggregationConcept;
import writenlg.constrain.ConstraintGroup;
import writenlg.linguistics.phrase.PhraseSpecification;

/**
 * Aggregates if both series have most segments descending.
 */
public class BothSeriesHaveMostSegmentsDescendingConcept extends AbstractAggregationConcept
{
	/**
	 * Creates a new BothSeriesHaveMostSegmentsDescendingConcept instance.
	 * 
	 * @param phraseSpecifications
	 * @param constraintGroup
	 */
	public BothSeriesHaveMostSegmentsDescendingConcept(List<PhraseSpecification> phraseSpecifications,
			ConstraintGroup<ConstraintType> constraintGroup)
	{
		super(phraseSpecifications, constraintGroup);
	}
}
