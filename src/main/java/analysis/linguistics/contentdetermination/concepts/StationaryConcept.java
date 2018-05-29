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
import analysis.graph.Segment;
import analysis.graph.Slope;
import analysis.linguistics.contentdetermination.ConstraintType;
import analysis.utilities.GlobalConstants;
import writenlg.AbstractConcept;
import writenlg.constrain.Constraint;
import writenlg.constrain.ConstraintConfiguration;
import writenlg.constrain.HardConstraint;
import writenlg.constrain.HardConstraintGroup;
import writenlg.constrain.HardConstraintProcessor;
import writenlg.constrain.SatisfactionLevel;
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
		super(phraseSpecifications, new HardConstraintGroup<>(new HardConstraintProcessor()));

		this.timeSeries = timeSeriesWithDerivedInformation;
		this.constraints = Constraints.getInstance()
				.getConfigurationsForTimeSeriesSpecificConcept(TimeSeriesSpecificConcept.STATIONARY);

		assessConstraints();
	}

	private void assessConstraints()
	{
		assessNoSignificantTrendConstraint();
		assessAscendingAndDescendingConstraint();
	}

	private void assessNoSignificantTrendConstraint()
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

		final Constraint<ConstraintType> noSignificantTrendConstraint = new HardConstraint<ConstraintType>(
				ConstraintType.NO_SIGNIFICANT_TREND,
				new SatisfactionLevel(
						noSignificantTrendConstraintValue
								.multiply(noSignificantTrendConstraintConfiguration.getValue()),
						noSignificantTrendConstraintConfiguration.getWeighting()));

		addConstraint(noSignificantTrendConstraint);
	}

	private void assessAscendingAndDescendingConstraint()
	{
		final ConstraintConfiguration ascendingAndDescendingConstraintConfiguration = this.constraints
				.get(ConstraintType.ASCENDING_AND_DESCENDING.getTextualForm());

		final List<Segment> smoothedSegments = this.timeSeries.getSegments();

		int ascendingSegmentCount = 0;
		int descendingSegmentCount = 0;

		for (Segment eachSegment : smoothedSegments)
		{
			if (eachSegment.getSlope() == Slope.ASCENDING)
			{
				ascendingSegmentCount++;
			}

			if (eachSegment.getSlope() == Slope.DESCENDING)
			{
				descendingSegmentCount++;
			}
		}

		final BigDecimal ascendingAndDescendingConstraintValue = ascendingSegmentCount == 0
				|| descendingSegmentCount == 0 ? GlobalConstants.ZERO : GlobalConstants.ONE;

		LOGGER.info(
				String.format("Ascending and descending constraint value: %s", ascendingAndDescendingConstraintValue));

		final Constraint<ConstraintType> ascendingAndDescendingConstraint = new HardConstraint<ConstraintType>(
				ConstraintType.ASCENDING_AND_DESCENDING,
				new SatisfactionLevel(
						ascendingAndDescendingConstraintValue
								.multiply(ascendingAndDescendingConstraintConfiguration.getValue()),
						ascendingAndDescendingConstraintConfiguration.getWeighting()));

		addConstraint(ascendingAndDescendingConstraint);
	}
}
