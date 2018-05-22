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
 * Aggregates if both series have all segments descending.
 */
public class BothSeriesHaveAllSegmentsDescendingConcept extends AbstractAggregationConcept
{
	/**
	 * Creates a new BothSeriesHaveAllSegmentsDescendingConcept instance.
	 */
	public BothSeriesHaveAllSegmentsDescendingConcept()
	{
		this(new ArrayList<>());
	}

	/**
	 * Creates a new BothSeriesHaveAllSegmentsDescendingConcept instance.
	 * 
	 * @param phraseSpecifications
	 */
	public BothSeriesHaveAllSegmentsDescendingConcept(List<PhraseSpecification> phraseSpecifications)
	{
		super(phraseSpecifications, new HardConstraintGroup<>(new HardConstraintProcessor()));
	}
}
