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
 * Aggregates if both series have all segments ascending.
 */
public class BothSeriesHaveAllSegmentsAscendingConcept extends AbstractAggregationConcept
{
	/**
	 * Creates a BothSeriesHaveAllSegmentsAscendingConcept instance.
	 */
	public BothSeriesHaveAllSegmentsAscendingConcept()
	{
		this(new ArrayList<>());
	}

	/**
	 * Creates a BothSeriesHaveAllSegmentsAscendingConcept instance.
	 * 
	 * @param phraseSpecifications
	 */
	public BothSeriesHaveAllSegmentsAscendingConcept(List<PhraseSpecification> phraseSpecifications)
	{
		super(phraseSpecifications, new HardConstraintGroup<>(new HardConstraintProcessor()));
	}

	@Override
	protected void prepareAggregatedPhraseSpecification()
	{
		// TODO Auto-generated method stub

	}

	@Override
	protected void assessConstraints()
	{
		// TODO Auto-generated method stub

	}
}