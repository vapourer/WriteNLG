// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.aggregation.concepts;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import analysis.TimeSeriesSpecificConcept;
import analysis.constrain.Constraints;
import analysis.linguistics.aggregation.AggregationConcept;
import analysis.linguistics.contentdetermination.ConstraintType;
import analysis.utilities.GlobalConstants;
import control.WriteNlgProperties;
import writenlg.AbstractConcept;
import writenlg.aggregation.AbstractAggregationConcept;
import writenlg.constrain.Constraint;
import writenlg.constrain.ConstraintConfiguration;
import writenlg.constrain.HardConstraint;
import writenlg.constrain.HardConstraintGroup;
import writenlg.constrain.HardConstraintProcessor;
import writenlg.constrain.SatisfactionLevel;
import writenlg.linguistics.phrase.PhraseSpecification;

/**
 * Aggregation of series minima.
 */
public class AggregateMinimaConcept extends AbstractAggregationConcept
{
	private final Map<String, ConstraintConfiguration> constraints;

	private Map<TimeSeriesSpecificConcept, List<AbstractConcept>> timeSeriesSpecificConcepts;

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

	/**
	 * @param timeSeriesSpecificConcepts
	 *            the timeSeriesSpecificConcepts to set
	 */
	public void setTimeSeriesSpecificConcepts(
			Map<TimeSeriesSpecificConcept, List<AbstractConcept>> timeSeriesSpecificConcepts)
	{
		this.timeSeriesSpecificConcepts = timeSeriesSpecificConcepts;
	}

	@Override
	protected void prepareAggregatedPhraseSpecification()
	{
		List<AbstractConcept> minimumRequiredConcepts = this.timeSeriesSpecificConcepts
				.get(TimeSeriesSpecificConcept.MINIMUM);

		if (!minimumRequiredConcepts.isEmpty())
		{
			for (AbstractConcept eachConcept : minimumRequiredConcepts)
			{
				addPhraseSpecification(eachConcept.getPhraseSpecifications().get(0));
			}

			setConjunction("whilst");
		}
	}

	@Override
	protected void assessConstraints()
	{
		assessMinimumRequiredConstraint();
		assessMinimaAllPresent();
	}

	private void assessMinimumRequiredConstraint()
	{
		BigDecimal minimumRequired = this.constraints.get(ConstraintType.MINIMUM_REQUIRED.getTextualForm()).getValue();

		final int minimumRequiredCount = this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.MINIMUM).size();

		for (int i = 0; i < minimumRequiredCount; i++)
		{
			final Constraint<ConstraintType> minimumRequiredConstraint = new HardConstraint<ConstraintType>(
					ConstraintType.MINIMUM_REQUIRED,
					new SatisfactionLevel(minimumRequired.multiply(GlobalConstants.ONE)));

			addConstraint(minimumRequiredConstraint);
		}
	}

	private void assessMinimaAllPresent()
	{
		BigDecimal minimaAllPresent = this.constraints.get(ConstraintType.MINIMA_ALL_PRESENT.getTextualForm())
				.getValue();

		final int expectedTotalSeriesCount = Integer
				.parseInt(WriteNlgProperties.getInstance().getProperty("ExpectedTotalSeriesCount"));

		if (this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.MINIMUM).size() == expectedTotalSeriesCount)
		{
			minimaAllPresent = minimaAllPresent.multiply(GlobalConstants.ONE);
		}
		else
		{
			minimaAllPresent = minimaAllPresent.multiply(GlobalConstants.ZERO);
		}

		final Constraint<ConstraintType> minimaAllPresentConstraint = new HardConstraint<ConstraintType>(
				ConstraintType.MINIMA_ALL_PRESENT, new SatisfactionLevel(minimaAllPresent));

		addConstraint(minimaAllPresentConstraint);
	}
}
