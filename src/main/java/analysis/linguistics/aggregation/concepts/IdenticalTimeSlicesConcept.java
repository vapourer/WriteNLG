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

	private List<AbstractConcept> timeSliceConcepts;
	private final Map<String, ConstraintConfiguration> constraints;

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

		// prepareAggregatedPhraseSpecification();
		// assessConstraints();
	}

	@Override
	protected void prepareAggregatedPhraseSpecification()
	{
		addPhraseSpecification(this.timeSliceConcepts.get(0).getPhraseSpecifications().get(0));
	}

	@Override
	protected void assessConstraints()
	{
		BigDecimal seriesTimeSlicesAreIdentical = this.constraints
				.get(ConstraintType.IDENTICAL_TIME_SLICES.getTextualForm()).getValue();

		if (this.timeSliceConcepts.size() == 2)
		{
			seriesTimeSlicesAreIdentical = seriesTimeSlicesAreIdentical.multiply(new BigDecimal("1"));
		}
		else
		{
			LOGGER.error(String.format("Current implementation is only for two time series, but there were %s",
					this.timeSliceConcepts.size()));
			throw new RuntimeException("Current implementation is for exactly two time series");
		}

		if (this.timeSliceConcepts.get(0).getPhraseSpecifications().get(0)
				.equals(this.timeSliceConcepts.get(1).getPhraseSpecifications().get(0)))
		{
			seriesTimeSlicesAreIdentical = seriesTimeSlicesAreIdentical.multiply(new BigDecimal("1"));
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

	/**
	 * @return the timeSliceConcepts
	 */
	public List<AbstractConcept> getTimeSliceConcepts()
	{
		return timeSliceConcepts;
	}

	/**
	 * @param timeSliceConcepts
	 *            the timeSliceConcepts to set
	 */
	public void setTimeSliceConcepts(List<AbstractConcept> timeSliceConcepts)
	{
		this.timeSliceConcepts = timeSliceConcepts;
	}
}
