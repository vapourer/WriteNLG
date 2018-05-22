// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.aggregation.concepts;

import java.util.ArrayList;
import java.util.List;

import writenlg.aggregation.AbstractAggregationConcept;
import writenlg.constrain.HardConstraintGroup;
import writenlg.constrain.HardConstraintProcessor;
import writenlg.linguistics.phrase.PhraseSpecification;

/**
 * Aggregates if both series have most segments descending.
 */
public class BothSeriesHaveMostSegmentsDescendingConcept extends AbstractAggregationConcept
{
	/**
	 * Creates a new BothSeriesHaveMostSegmentsDescendingConcept instance.
	 */
	public BothSeriesHaveMostSegmentsDescendingConcept()
	{
		this(new ArrayList<>());
	}

	/**
	 * Creates a new BothSeriesHaveMostSegmentsDescendingConcept instance.
	 * 
	 * @param phraseSpecifications
	 */
	public BothSeriesHaveMostSegmentsDescendingConcept(List<PhraseSpecification> phraseSpecifications)
	{
		super(phraseSpecifications, new HardConstraintGroup<>(new HardConstraintProcessor()));
	}
}
