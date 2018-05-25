// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.aggregation.concepts;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.constrain.Constraints;
import analysis.linguistics.aggregation.AggregationConcept;
import analysis.linguistics.contentdetermination.ConstraintType;
import analysis.utilities.GlobalConstants;
import writenlg.AbstractConcept;
import writenlg.aggregation.AbstractAggregationConcept;
import writenlg.constrain.BooleanConstraintProcessor;
import writenlg.constrain.Constraint;
import writenlg.constrain.ConstraintConfiguration;
import writenlg.constrain.HardConstraint;
import writenlg.constrain.HardConstraintGroup;
import writenlg.constrain.SatisfactionLevel;
import writenlg.linguistics.phrase.PhraseSpecification;

/**
 * Rationalises time slice declarations. Current implementation cannot cater for series with time intervals that differ,
 * so this should always be used, with an exception thrown if there is a discrepancy.
 */
public class IdenticalTimeSlicesConcept extends AbstractAggregationConcept
{
	private static final Logger LOGGER = LogManager.getLogger("IdenticalTimeSlicesConcept.class");

	private final Map<String, ConstraintConfiguration> constraints;

	private List<AbstractConcept> timeSliceConcepts;

	/**
	 * Creates a new IdenticalTimeSlicesConcept instance.
	 */
	public IdenticalTimeSlicesConcept()
	{
		this(new ArrayList<>());
	}

	/**
	 * Creates a new IdenticalTimeSlicesConcept instance.
	 * 
	 * @param phraseSpecifications
	 * @param timeSliceConcepts
	 */
	public IdenticalTimeSlicesConcept(final List<PhraseSpecification> phraseSpecifications)
	{
		super(phraseSpecifications, new HardConstraintGroup<>(new BooleanConstraintProcessor()));

		this.constraints = Constraints.getInstance()
				.getConfigurationsForAggregationConcept(AggregationConcept.IDENTICAL_TIME_SLICES);
	}

	/**
	 * @param timeSliceConcepts
	 *            the timeSliceConcepts to set
	 */
	public void setTimeSliceConcepts(List<AbstractConcept> timeSliceConcepts)
	{
		this.timeSliceConcepts = timeSliceConcepts;
	}

	@Override
	protected void prepareAggregatedPhraseSpecification()
	{
		if (!this.timeSliceConcepts.isEmpty())
		{
			addPhraseSpecification(this.timeSliceConcepts.get(0).getPhraseSpecifications().get(0));
		}
	}

	@Override
	protected void assessConstraints()
	{
		assessTimeSlicesPresentConstraint();
		assessIdenticalTimeSlicesConstraint();
	}

	private void assessTimeSlicesPresentConstraint()
	{
		BigDecimal seriesTimeSlicesArePresent = this.constraints
				.get(ConstraintType.TIME_SLICE_REQUIRED.getTextualForm()).getValue();

		if (this.timeSliceConcepts.size() == 2)
		{
			seriesTimeSlicesArePresent = seriesTimeSlicesArePresent.multiply(GlobalConstants.ONE);
		}
		else if (this.timeSliceConcepts.size() == 0)
		{
			seriesTimeSlicesArePresent = seriesTimeSlicesArePresent.multiply(GlobalConstants.ZERO);
		}
		else
		{
			LOGGER.error(String.format(
					"Current implementation is only for two time series, but there were %s, and time slice phrase specifications have not been removed",
					this.timeSliceConcepts.size()));
			throw new RuntimeException("Current implementation is for exactly two time series");
		}

		final Constraint<ConstraintType> timeSlicesPresentConstraint = new HardConstraint<ConstraintType>(
				ConstraintType.TIME_SLICE_REQUIRED, new SatisfactionLevel(seriesTimeSlicesArePresent));

		addConstraint(timeSlicesPresentConstraint);
	}

	private void assessIdenticalTimeSlicesConstraint()
	{
		BigDecimal seriesTimeSlicesAreIdentical = this.constraints
				.get(ConstraintType.IDENTICAL_TIME_SLICES.getTextualForm()).getValue();

		if (this.timeSliceConcepts.isEmpty())
		{
			seriesTimeSlicesAreIdentical = seriesTimeSlicesAreIdentical.multiply(GlobalConstants.ZERO);
		}
		else if (this.timeSliceConcepts.get(0).getPhraseSpecifications().get(0)
				.equals(this.timeSliceConcepts.get(1).getPhraseSpecifications().get(0)))
		{
			seriesTimeSlicesAreIdentical = seriesTimeSlicesAreIdentical.multiply(GlobalConstants.ONE);
		}
		else
		{
			LOGGER.error("Current implementation is for two time series both sampled at the same interval");
			throw new RuntimeException(
					"Current implementation is for two time series both sampled at the same interval");
		}

		final Constraint<ConstraintType> identicalTimeSlicesConstraint = new HardConstraint<ConstraintType>(
				ConstraintType.IDENTICAL_TIME_SLICES, new SatisfactionLevel(seriesTimeSlicesAreIdentical));

		addConstraint(identicalTimeSlicesConstraint);
	}
}
