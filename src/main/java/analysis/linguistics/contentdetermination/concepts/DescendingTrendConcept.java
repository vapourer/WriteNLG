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
 * Representation of a time series falling trend.
 * Establishes constraint values for time series with a descending trend, based on initial values and weightings input
 * from ANTLR Constraints text file, and analysis of time series data.
 */
public class DescendingTrendConcept extends AbstractConcept
{
	private static final Logger LOGGER = LogManager.getLogger("DescendingTrendConcept.class");

	private final TimeSeriesWithDerivedInformation timeSeries;
	private final Map<String, ConstraintConfiguration> constraints;

	/**
	 * Creates a new DescendingTrendConcept instance.
	 * 
	 * @param phraseSpecifications
	 * @param timeSeriesWithDerivedInformation
	 */
	public DescendingTrendConcept(final List<PhraseSpecification> phraseSpecifications,
			final TimeSeriesWithDerivedInformation timeSeriesWithDerivedInformation)
	{
		super(phraseSpecifications, new SoftConstraintGroup<>(new WeightedAverageConstraintProcessor()));

		this.timeSeries = timeSeriesWithDerivedInformation;
		this.constraints = Constraints.getInstance()
				.getConfigurationsForTimeSeriesSpecificConcept(TimeSeriesSpecificConcept.DESCENDING_TREND);

		assessConstraints();
	}

	private void assessConstraints()
	{
		assessAllSegmentsDescendingConstraint();
		assessMostSegmentsDescendingConstraint();
	}

	private void assessMostSegmentsDescendingConstraint()
	{
		final ConstraintConfiguration mostSegmentsDescendingConstraintConfiguration = this.constraints
				.get(ConstraintType.MOST_SEGMENTS_DESCENDING.getTextualForm());

		final BigDecimal descendingSmoothedSegmentPercentage = calculateDescendingSmoothedSegmentPercentage();

		final BigDecimal mostSegmentsDescendingPercentageThreshold = new BigDecimal(
				WriteNlgProperties.getInstance().getProperty("MostSegmentsSameSlopePercentageThreshold"));

		BigDecimal mostSegmentsDescendingConstraintValue = null;

		if (descendingSmoothedSegmentPercentage.compareTo(mostSegmentsDescendingPercentageThreshold) >= 0)
		{
			mostSegmentsDescendingConstraintValue = GlobalConstants.ONE
					.multiply(mostSegmentsDescendingConstraintConfiguration.getValue());
		}
		else
		{
			mostSegmentsDescendingConstraintValue = GlobalConstants.ZERO
					.multiply(mostSegmentsDescendingConstraintConfiguration.getValue());
		}

		LOGGER.info(
				String.format("MOST_SEGMENTS_DESCENDING constraint value: %s", mostSegmentsDescendingConstraintValue));

		final Constraint<ConstraintType> mostSegmentsDescendingConstraint = new BoundedWeightedConstraint<ConstraintType>(
				ConstraintType.MOST_SEGMENTS_DESCENDING,
				new SatisfactionLevel(mostSegmentsDescendingConstraintValue,
						mostSegmentsDescendingConstraintConfiguration.getWeighting()),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintLowerBound")),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintUpperBound")));

		addConstraint(mostSegmentsDescendingConstraint);
	}

	private void assessAllSegmentsDescendingConstraint()
	{
		final ConstraintConfiguration allSegmentsDescendingConstraintConfiguration = this.constraints
				.get(ConstraintType.ALL_SEGMENTS_DESCENDING.getTextualForm());

		final BigDecimal descendingSmoothedSegmentPercentage = calculateDescendingSmoothedSegmentPercentage();

		BigDecimal allSegmentsDescendingConstraintValue = null;

		if (descendingSmoothedSegmentPercentage.compareTo(new BigDecimal("100")) == 0)
		{
			allSegmentsDescendingConstraintValue = GlobalConstants.ONE
					.multiply(allSegmentsDescendingConstraintConfiguration.getValue());
		}
		else
		{
			allSegmentsDescendingConstraintValue = GlobalConstants.ZERO
					.multiply(allSegmentsDescendingConstraintConfiguration.getValue());
		}

		LOGGER.info(
				String.format("ALL_SEGMENTS_DESCENDING constraint value: %s", allSegmentsDescendingConstraintValue));

		final Constraint<ConstraintType> allSegmentsDescendingConstraint = new BoundedWeightedConstraint<ConstraintType>(
				ConstraintType.ALL_SEGMENTS_DESCENDING,
				new SatisfactionLevel(allSegmentsDescendingConstraintValue,
						allSegmentsDescendingConstraintConfiguration.getWeighting()),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintLowerBound")),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintUpperBound")));

		addConstraint(allSegmentsDescendingConstraint);
	}

	private BigDecimal calculateDescendingSmoothedSegmentPercentage()
	{
		final List<Segment> smoothedSegments = this.timeSeries.getSegments();
		final int totalSegments = smoothedSegments.size();
		int descendingSegmentCount = 0;

		for (Segment eachSegment : smoothedSegments)
		{
			if (eachSegment.getSlope() == Slope.DESCENDING)
			{
				descendingSegmentCount++;
			}
		}

		int percentage = (descendingSegmentCount * 100) / totalSegments;

		LOGGER.info(String.format("Percentage of descending segments: %d", percentage));

		return new BigDecimal(percentage);
	}
}
