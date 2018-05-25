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
 * Aggregation of maximum and minimum for each series.
 */
public class AggregateMaximumAndMinimumConcept extends AbstractAggregationConcept
{
	private final Map<String, ConstraintConfiguration> constraints;

	private Map<TimeSeriesSpecificConcept, List<AbstractConcept>> timeSeriesSpecificConcepts;

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
		// List<AbstractConcept> maximumRequiredConcepts = this.timeSeriesSpecificConcepts
		// .get(TimeSeriesSpecificConcept.MAXIMUM);
		//
		// if (!maximumRequiredConcepts.isEmpty())
		// {
		// for (AbstractConcept eachConcept : maximumRequiredConcepts)
		// {
		// addPhraseSpecification(eachConcept.getPhraseSpecifications().get(0));
		// }
		//
		// setConjunction("whilst");
		// }
	}

	@Override
	protected void assessConstraints()
	{
		assessMaximumRequiredConstraint();
		assessMinimumRequiredConstraint();
		assessMaximaAndMinimaAllPresent();
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

	private void assessMaximaAndMinimaAllPresent()
	{
		BigDecimal maximaAndMinimaAllPresent = this.constraints
				.get(ConstraintType.MAXIMA_AND_MINIMA_ALL_PRESENT.getTextualForm()).getValue();

		final int expectedTotalSeriesCount = Integer
				.parseInt(WriteNlgProperties.getInstance().getProperty("ExpectedTotalSeriesCount"));

		if (this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.MAXIMUM).size() == expectedTotalSeriesCount)
		{
			maximaAndMinimaAllPresent = maximaAndMinimaAllPresent.multiply(GlobalConstants.ONE);
		}
		else
		{
			maximaAndMinimaAllPresent = maximaAndMinimaAllPresent.multiply(GlobalConstants.ZERO);
		}

		if (this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.MINIMUM).size() == expectedTotalSeriesCount)
		{
			maximaAndMinimaAllPresent = maximaAndMinimaAllPresent.multiply(GlobalConstants.ONE);
		}
		else
		{
			maximaAndMinimaAllPresent = maximaAndMinimaAllPresent.multiply(GlobalConstants.ZERO);
		}

		final Constraint<ConstraintType> maximaAndMinimaAllPresentConstraint = new HardConstraint<ConstraintType>(
				ConstraintType.MAXIMA_AND_MINIMA_ALL_PRESENT, new SatisfactionLevel(maximaAndMinimaAllPresent));

		addConstraint(maximaAndMinimaAllPresentConstraint);
	}
}
