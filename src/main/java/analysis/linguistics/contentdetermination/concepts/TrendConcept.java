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
 * TODO: Perhaps a flaw in the overall structure. The intended eventual sentence does not really fit the current
 * PhraseSpecification/SimpleNLG model. Needs a discrete approach.
 * Initial trend for presentation of overall trend outline.
 */
public class TrendConcept extends AbstractConcept
{
	private static final Logger LOGGER = LogManager.getLogger("TrendConcept.class");

	private final TimeSeriesWithDerivedInformation timeSeries;
	private final Map<String, ConstraintConfiguration> constraints;

	public TrendConcept(List<PhraseSpecification> phraseSpecifications,
			final TimeSeriesWithDerivedInformation timeSeriesWithDerivedInformation)
	{
		super(phraseSpecifications, new SoftConstraintGroup<>(new WeightedAverageConstraintProcessor()));

		this.timeSeries = timeSeriesWithDerivedInformation;
		this.constraints = Constraints.getInstance()
				.getConfigurationsForTimeSeriesSpecificConcept(TimeSeriesSpecificConcept.TREND);

		assessConstraints();
	}

	private void assessConstraints()
	{
		assessMultipleTrendsConstraint();
		assessAscendingAndDescendingConstraint();
	}

	private void assessMultipleTrendsConstraint()
	{
		final ConstraintConfiguration multipleTrendsConstraintConfiguration = this.constraints
				.get(ConstraintType.MULTIPLE_TRENDS.getTextualForm());

		final int smoothedSegmentCount = this.timeSeries.getSmoothedSegments().size();
		final int outlineSegmentCount = this.timeSeries.getOutlineSegments().size();

		LOGGER.info(String.format("smoothedSegmentCount: %d; outlineSegmentCount: %d", smoothedSegmentCount,
				outlineSegmentCount));

		final int segmentCount = outlineSegmentCount < smoothedSegmentCount ? outlineSegmentCount
				: smoothedSegmentCount;

		if (segmentCount != getPhraseSpecifications().size())
		{
			LOGGER.error(
					"Inconsistent values for reported trend size. PhraseSpecification list should have been adjusted to match smallest smoothed segment collection");

			// throw new RuntimeException(
			// "Inconsistent values for reported trend size. PhraseSpecification list should have been adjusted to match
			// smallest smoothed segment collection");
		}

		final BigDecimal multipleTrendsConstraintValue = segmentCount > 1 ? GlobalConstants.ONE : GlobalConstants.ZERO;

		final Constraint<ConstraintType> multipleTrendsConstraint = new BoundedWeightedConstraint<ConstraintType>(
				ConstraintType.MOST_SEGMENTS_ASCENDING,
				new SatisfactionLevel(
						multipleTrendsConstraintValue.multiply(multipleTrendsConstraintConfiguration.getValue()),
						multipleTrendsConstraintConfiguration.getWeighting()),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintLowerBound")),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintUpperBound")));

		addConstraint(multipleTrendsConstraint);
	}

	private void assessAscendingAndDescendingConstraint()
	{
		final ConstraintConfiguration ascendingAndDescendingConstraintConfiguration = this.constraints
				.get(ConstraintType.ASCENDING_AND_DESCENDING.getTextualForm());
	}
}
