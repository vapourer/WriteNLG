// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.contentdetermination.concepts;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.TimeSeriesSpecificConcept;
import analysis.TimeSeriesWithDerivedInformation;
import analysis.constrain.Constraints;
import analysis.linguistics.contentdetermination.ConstraintType;
import analysis.utilities.GlobalConstants;
import control.WriteNlgProperties;
import writenlg.AbstractConcept;
import writenlg.constrain.BoundedWeightedConstraint;
import writenlg.constrain.Constraint;
import writenlg.constrain.ConstraintConfiguration;
import writenlg.constrain.SatisfactionLevel;
import writenlg.constrain.SoftConstraintGroup;
import writenlg.constrain.WeightedAverageConstraintProcessor;
import writenlg.linguistics.phrase.PhraseSpecification;

/**
 * Determines whether a comment about a time series' fluctuation should be included.
 */
public class TurningPointsConcept extends AbstractConcept
{
	private static final Logger LOGGER = LogManager.getLogger("TurningPointsConcept.class");

	private final TimeSeriesWithDerivedInformation timeSeries;
	private final Map<String, ConstraintConfiguration> constraints;

	public TurningPointsConcept(List<PhraseSpecification> phraseSpecifications,
			final TimeSeriesWithDerivedInformation timeSeriesWithDerivedInformation)
	{
		super(phraseSpecifications, new SoftConstraintGroup<>(new WeightedAverageConstraintProcessor()));

		this.timeSeries = timeSeriesWithDerivedInformation;

		this.constraints = Constraints.getInstance()
				.getConfigurationsForTimeSeriesSpecificConcept(TimeSeriesSpecificConcept.TURNING_POINTS);

		assessConstraints();
	}

	private void assessConstraints()
	{
		final ConstraintConfiguration turningPointCountExceedsLowerThresholdConstraintConfiguration = this.constraints
				.get(ConstraintType.TURNING_POINT_COUNT_EXCEEDS_LOWER_THRESHOLD.getTextualForm());

		final int turningPointCount = this.timeSeries.getUpperTurningPoints().size()
				+ this.timeSeries.getLowerTurningPoints().size();
		final int smoothedPointCount = this.timeSeries.getSmoothedPoints().size();
		final int lowerThresholdAsPercentage = Integer.parseInt(
				WriteNlgProperties.getInstance().getProperty("TimeSeriesFluctuatesSlightlyThresholdAsPercentage"));

		final BigDecimal turningPointCountExceedsLowerThresholdConstraintValue = ((turningPointCount * 100)
				/ smoothedPointCount) > lowerThresholdAsPercentage ? GlobalConstants.ONE : GlobalConstants.ZERO;

		LOGGER.info(String.format("TimeSeriesFluctuatesSlightlyThresholdAsPercentage constraint value: %s",
				turningPointCountExceedsLowerThresholdConstraintValue));

		final Constraint<ConstraintType> turningPointCountExceedsLowerThresholdConstraint = new BoundedWeightedConstraint<ConstraintType>(
				ConstraintType.TURNING_POINT_COUNT_EXCEEDS_LOWER_THRESHOLD,
				new SatisfactionLevel(
						turningPointCountExceedsLowerThresholdConstraintValue
								.multiply(turningPointCountExceedsLowerThresholdConstraintConfiguration.getValue()),
						turningPointCountExceedsLowerThresholdConstraintConfiguration.getWeighting()),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintLowerBound")),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintUpperBound")));

		addConstraint(turningPointCountExceedsLowerThresholdConstraint);
	}
}
