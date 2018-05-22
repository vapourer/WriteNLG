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
 * Aggregates if both series have most segments ascending.
 */
public class BothSeriesHaveMostSegmentsAscendingConcept extends AbstractAggregationConcept
{
	/**
	 * Creates a new BothSeriesHaveMostSegmentsAscendingConcept instance.
	 */
	public BothSeriesHaveMostSegmentsAscendingConcept()
	{
		this(new ArrayList<>());
	}

	/**
	 * Creates a new BothSeriesHaveMostSegmentsAscendingConcept instance.
	 * 
	 * @param phraseSpecifications
	 */
	public BothSeriesHaveMostSegmentsAscendingConcept(List<PhraseSpecification> phraseSpecifications)
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
