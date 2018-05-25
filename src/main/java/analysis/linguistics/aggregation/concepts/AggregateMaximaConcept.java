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
 * Aggregation of series maxima.
 */
public class AggregateMaximaConcept extends AbstractAggregationConcept
{
	private final Map<String, ConstraintConfiguration> constraints;

	private Map<TimeSeriesSpecificConcept, List<AbstractConcept>> timeSeriesSpecificConcepts;

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
		List<AbstractConcept> maximumRequiredConcepts = this.timeSeriesSpecificConcepts
				.get(TimeSeriesSpecificConcept.MAXIMUM);

		if (!maximumRequiredConcepts.isEmpty())
		{
			for (AbstractConcept eachConcept : maximumRequiredConcepts)
			{
				addPhraseSpecification(eachConcept.getPhraseSpecifications().get(0));
			}

			setConjunction("whilst");
		}
	}

	@Override
	protected void assessConstraints()
	{
		assessMaximumRequiredConstraint();
		assessMaximaAllPresent();
	}

	private void assessMaximumRequiredConstraint()
	{
		BigDecimal maximumRequired = this.constraints.get(ConstraintType.MAXIMUM_REQUIRED.getTextualForm()).getValue();

		final int maximumRequiredCount = this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.MAXIMUM).size();

		for (int i = 0; i < maximumRequiredCount; i++)
		{
			final Constraint<ConstraintType> maximumRequiredConstraint = new HardConstraint<ConstraintType>(
					ConstraintType.MAXIMUM_REQUIRED,
					new SatisfactionLevel(maximumRequired.multiply(GlobalConstants.ONE)));

			addConstraint(maximumRequiredConstraint);
		}
	}

	private void assessMaximaAllPresent()
	{
		BigDecimal maximaAllPresent = this.constraints.get(ConstraintType.MAXIMA_ALL_PRESENT.getTextualForm())
				.getValue();

		final int expectedTotalSeriesCount = Integer
				.parseInt(WriteNlgProperties.getInstance().getProperty("ExpectedTotalSeriesCount"));

		if (this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.MAXIMUM).size() == expectedTotalSeriesCount)
		{
			maximaAllPresent = maximaAllPresent.multiply(GlobalConstants.ONE);
		}
		else
		{
			maximaAllPresent = maximaAllPresent.multiply(GlobalConstants.ZERO);
		}

		final Constraint<ConstraintType> maximaAllPresentConstraint = new HardConstraint<ConstraintType>(
				ConstraintType.MAXIMA_ALL_PRESENT, new SatisfactionLevel(maximaAllPresent));

		addConstraint(maximaAllPresentConstraint);
	}
}
