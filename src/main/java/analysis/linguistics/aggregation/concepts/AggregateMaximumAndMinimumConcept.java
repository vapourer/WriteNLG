// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.aggregation.concepts;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import analysis.constrain.Constraints;
import analysis.linguistics.aggregation.AggregationConcept;
import analysis.linguistics.contentdetermination.ConstraintType;
import writenlg.aggregation.AbstractAggregationConcept;
import writenlg.constrain.ConstraintConfiguration;
import writenlg.constrain.HardConstraintGroup;
import writenlg.constrain.HardConstraintProcessor;
import writenlg.linguistics.phrase.PhraseSpecification;

/**
 * Aggregation of maximum and minimum for each series.
 */
public class AggregateMaximumAndMinimumConcept extends AbstractAggregationConcept
{
	private final Map<String, ConstraintConfiguration> constraints;

	/**
	 * Creates a new AggregateMaximumAndMinimumConcept instance.
	 */
	public AggregateMaximumAndMinimumConcept()
	{
		this(new ArrayList<>());
	}

	/**
	 * Creates a new AggregateMaximumAndMinimumConcept instance.
	 * 
	 * @param phraseSpecifications
	 */
	public AggregateMaximumAndMinimumConcept(List<PhraseSpecification> phraseSpecifications)
	{
		super(phraseSpecifications, new HardConstraintGroup<>(new HardConstraintProcessor()));

		this.constraints = Constraints.getInstance()
				.getConfigurationsForAggregationConcept(AggregationConcept.AGGREGATE_MAXIMUM_AND_MINIMUM);
	}

	@Override
	protected void prepareAggregatedPhraseSpecification()
	{
		// TODO Auto-generated method stub

	}

	@Override
	protected void assessConstraints()
	{
		assessMaximumRequiredConstraint();
	}

	private void assessMaximumRequiredConstraint()
	{
		BigDecimal maximumRequired = this.constraints.get(ConstraintType.MAXIMUM_REQUIRED.getTextualForm()).getValue();
	}
}
