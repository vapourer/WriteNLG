// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.aggregation.concepts;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
 * Aggregation of fluctuating series.
 */
public class AggregateTurningPointsConcept extends AbstractAggregationConcept
{
	private static final Logger LOGGER = LogManager.getLogger("AggregateTurningPointsConcept.class");

	private final Map<String, ConstraintConfiguration> constraints;

	private Map<TimeSeriesSpecificConcept, List<AbstractConcept>> timeSeriesSpecificConcepts;

	public AggregateTurningPointsConcept()
	{
		this(new ArrayList<>());
	}

	public AggregateTurningPointsConcept(List<PhraseSpecification> phraseSpecifications)
	{
		super(phraseSpecifications, new HardConstraintGroup<>(new HardConstraintProcessor()));

		this.constraints = Constraints.getInstance()
				.getConfigurationsForAggregationConcept(AggregationConcept.AGGREGATE_TURNING_POINTS);
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
		if (this.getPhraseSpecifications().size() == 0)
		{
			LOGGER.error(
					"List of phrase specifications was empty, but current implementation expects a prepared phrase specification from ANTLR input");
			throw new RuntimeException(
					"Current implementation expects a prepared phrase specification from ANTLR input");
		}
	}

	@Override
	protected void assessConstraints()
	{
		processTurningPointCountExceedsLowerThresholdConstraint();
		processBothSeriesFluctuateConstraint();
	}

	private void processTurningPointCountExceedsLowerThresholdConstraint()
	{
		BigDecimal turningPointCountExceedsLowerThreshold = this.constraints
				.get(ConstraintType.TURNING_POINT_COUNT_EXCEEDS_LOWER_THRESHOLD.getTextualForm()).getValue();

		final int turningPointCountExceedsLowerThresholdCount = this.timeSeriesSpecificConcepts
				.get(TimeSeriesSpecificConcept.TURNING_POINTS).size();

		for (int i = 0; i < turningPointCountExceedsLowerThresholdCount; i++)
		{
			final Constraint<ConstraintType> turningPointCountExceedsLowerThresholdConstraint = new HardConstraint<ConstraintType>(
					ConstraintType.TURNING_POINT_COUNT_EXCEEDS_LOWER_THRESHOLD,
					new SatisfactionLevel(turningPointCountExceedsLowerThreshold.multiply(GlobalConstants.ONE)));

			addConstraint(turningPointCountExceedsLowerThresholdConstraint);
		}
	}

	private void processBothSeriesFluctuateConstraint()
	{
		BigDecimal bothSeriesFluctuate = this.constraints.get(ConstraintType.BOTH_SERIES_FLUCTUATE.getTextualForm())
				.getValue();

		final int expectedTotalSeriesCount = Integer
				.parseInt(WriteNlgProperties.getInstance().getProperty("ExpectedTotalSeriesCount"));

		if (this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.TURNING_POINTS)
				.size() == expectedTotalSeriesCount)
		{
			bothSeriesFluctuate = bothSeriesFluctuate.multiply(GlobalConstants.ONE);
		}
		else
		{
			bothSeriesFluctuate = bothSeriesFluctuate.multiply(GlobalConstants.ZERO);
		}

		final Constraint<ConstraintType> bothSeriesFluctuateConstraint = new HardConstraint<ConstraintType>(
				ConstraintType.BOTH_SERIES_FLUCTUATE, new SatisfactionLevel(bothSeriesFluctuate));

		addConstraint(bothSeriesFluctuateConstraint);
	}

}
