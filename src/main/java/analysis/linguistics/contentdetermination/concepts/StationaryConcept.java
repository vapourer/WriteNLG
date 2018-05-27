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
 * Representation of a time series exhibiting no trend.
 */
public class StationaryConcept extends AbstractConcept
{
	private static final Logger LOGGER = LogManager.getLogger("StationaryConcept.class");

	private final TimeSeriesWithDerivedInformation timeSeries;
	private final Map<String, ConstraintConfiguration> constraints;

	public StationaryConcept(List<PhraseSpecification> phraseSpecifications,
			final TimeSeriesWithDerivedInformation timeSeriesWithDerivedInformation)
	{
		super(phraseSpecifications, new SoftConstraintGroup<>(new WeightedAverageConstraintProcessor()));

		this.timeSeries = timeSeriesWithDerivedInformation;
		this.constraints = Constraints.getInstance()
				.getConfigurationsForTimeSeriesSpecificConcept(TimeSeriesSpecificConcept.STATIONARY);

		assessConstraints();
	}

	private void assessConstraints()
	{
		final ConstraintConfiguration noSignificantTrendConstraintConfiguration = this.constraints
				.get(ConstraintType.NO_SIGNIFICANT_TREND.getTextualForm());

		final int smoothedSegmentCount = this.timeSeries.getSmoothedSegments().size();
		final int outlineSegmentCount = this.timeSeries.getOutlineSegments().size();

		LOGGER.info(String.format("smoothedSegmentCount: %d; outlineSegmentCount: %d", smoothedSegmentCount,
				outlineSegmentCount));

		final int segmentCount = outlineSegmentCount < smoothedSegmentCount ? outlineSegmentCount
				: smoothedSegmentCount;

		final BigDecimal noSignificantTrendConstraintValue = segmentCount > 1 ? GlobalConstants.ZERO
				: GlobalConstants.ONE;

		final Constraint<ConstraintType> noSignificantTrendConstraint = new BoundedWeightedConstraint<ConstraintType>(
				ConstraintType.MOST_SEGMENTS_ASCENDING,
				new SatisfactionLevel(
						noSignificantTrendConstraintValue
								.multiply(noSignificantTrendConstraintConfiguration.getValue()),
						noSignificantTrendConstraintConfiguration.getWeighting()),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintLowerBound")),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintUpperBound")));

		addConstraint(noSignificantTrendConstraint);
	}
}
