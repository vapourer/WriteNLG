// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.aggregation.concepts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import analysis.constrain.Constraints;
import analysis.linguistics.aggregation.AggregationConcept;
import writenlg.aggregation.AbstractAggregationConcept;
import writenlg.constrain.ConstraintConfiguration;
import writenlg.constrain.HardConstraintGroup;
import writenlg.constrain.HardConstraintProcessor;
import writenlg.linguistics.phrase.PhraseSpecification;

/**
 * Aggregation of series minima.
 */
public class AggregateMinimaConcept extends AbstractAggregationConcept
{
	private final Map<String, ConstraintConfiguration> constraints;

	/**
	 * Creates a new AggregateMinimaConcept instance.
	 */
	public AggregateMinimaConcept()
	{
		this(new ArrayList<>());
	}

	/**
	 * Creates a new AggregateMinimaConcept instance.
	 * 
	 * @param phraseSpecifications
	 */
	public AggregateMinimaConcept(List<PhraseSpecification> phraseSpecifications)
	{
		super(phraseSpecifications, new HardConstraintGroup<>(new HardConstraintProcessor()));

		this.constraints = Constraints.getInstance()
				.getConfigurationsForAggregationConcept(AggregationConcept.AGGREGATE_MINIMA);
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
