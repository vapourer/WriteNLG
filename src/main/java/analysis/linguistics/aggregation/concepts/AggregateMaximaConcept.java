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
 * Aggregation of series maxima.
 */
public class AggregateMaximaConcept extends AbstractAggregationConcept
{
	private final Map<String, ConstraintConfiguration> constraints;

	/**
	 * Creates a new AggregateMaximaConcept instance.
	 */
	public AggregateMaximaConcept()
	{
		this(new ArrayList<>());
	}

	/**
	 * Creates a new AggregateMaximaConcept instance.
	 * 
	 * @param phraseSpecifications
	 */
	public AggregateMaximaConcept(List<PhraseSpecification> phraseSpecifications)
	{
		super(phraseSpecifications, new HardConstraintGroup<>(new HardConstraintProcessor()));

		this.constraints = Constraints.getInstance()
				.getConfigurationsForAggregationConcept(AggregationConcept.AGGREGATE_MAXIMA);
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
