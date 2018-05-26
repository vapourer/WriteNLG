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
 * Representation of a time series rising trend.
 * Establishes constraint values for time series with a rising trend, based on initial values and weightings input from
 * ANTLR Constraints text file, and analysis of time series data.
 */
public class RisingTrendConcept extends AbstractConcept
{
	private static final Logger LOGGER = LogManager.getLogger("RisingTrendConcept.class");

	private final TimeSeriesWithDerivedInformation timeSeries;
	private final Map<String, ConstraintConfiguration> constraints;

	/**
	 * Creates a new RisingTrendConcept instance.
	 * 
	 * @param phraseSpecifications
	 * @param timeSeriesWithDerivedInformation
	 */
	public RisingTrendConcept(List<PhraseSpecification> phraseSpecifications,
			final TimeSeriesWithDerivedInformation timeSeriesWithDerivedInformation)
	{
		super(phraseSpecifications, new SoftConstraintGroup<>(new WeightedAverageConstraintProcessor()));

		this.timeSeries = timeSeriesWithDerivedInformation;
		this.constraints = Constraints.getInstance()
				.getConfigurationsForTimeSeriesSpecificConcept(TimeSeriesSpecificConcept.RISING_TREND);

		assessConstraints();
	}

	private void assessConstraints()
	{
		assessAllSegmentsAscendingConstraint();
		assessMostSegmentsAscendingConstraint();
	}

	private void assessMostSegmentsAscendingConstraint()
	{
		final ConstraintConfiguration mostSegmentsAscendingConstraintConfiguration = this.constraints
				.get(ConstraintType.MOST_SEGMENTS_ASCENDING.getTextualForm());

		final BigDecimal ascendingSmoothedSegmentPercentage = calculateAscendingSmoothedSegmentPercentage();

		final BigDecimal mostSegmentsAscendingPercentageThreshold = new BigDecimal(
				WriteNlgProperties.getInstance().getProperty("MostSegmentsSameSlopePercentageThreshold"));

		BigDecimal mostSegmentsAscendingConstraintValue = null;

		if (ascendingSmoothedSegmentPercentage.compareTo(mostSegmentsAscendingPercentageThreshold) >= 0)
		{
			mostSegmentsAscendingConstraintValue = GlobalConstants.ONE
					.multiply(mostSegmentsAscendingConstraintConfiguration.getValue());
		}
		else
		{
			mostSegmentsAscendingConstraintValue = GlobalConstants.ZERO
					.multiply(mostSegmentsAscendingConstraintConfiguration.getValue());
		}

		LOGGER.info(
				String.format("MOST_SEGMENTS_ASCENDING constraint value: %s", mostSegmentsAscendingConstraintValue));

		final Constraint<ConstraintType> mostSegmentsAscendingConstraint = new BoundedWeightedConstraint<ConstraintType>(
				ConstraintType.MOST_SEGMENTS_ASCENDING,
				new SatisfactionLevel(mostSegmentsAscendingConstraintValue,
						mostSegmentsAscendingConstraintConfiguration.getWeighting()),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintLowerBound")),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintUpperBound")));

		addConstraint(mostSegmentsAscendingConstraint);
	}

	private void assessAllSegmentsAscendingConstraint()
	{
		final ConstraintConfiguration allSegmentsAscendingConstraintConfiguration = this.constraints
				.get(ConstraintType.ALL_SEGMENTS_ASCENDING.getTextualForm());

		BigDecimal ascendingSmoothedSegmentPercentage = calculateAscendingSmoothedSegmentPercentage();

		BigDecimal allSegmentsAscendingConstraintValue = null;

		if (ascendingSmoothedSegmentPercentage.compareTo(new BigDecimal("100")) == 0)
		{
			allSegmentsAscendingConstraintValue = GlobalConstants.ONE
					.multiply(allSegmentsAscendingConstraintConfiguration.getValue());
		}
		else
		{
			allSegmentsAscendingConstraintValue = GlobalConstants.ZERO
					.multiply(allSegmentsAscendingConstraintConfiguration.getValue());
		}

		LOGGER.info(String.format("ALL_SEGMENTS_ASCENDING constraint value: %s", allSegmentsAscendingConstraintValue));

		final Constraint<ConstraintType> allSegmentsAscendingConstraint = new BoundedWeightedConstraint<ConstraintType>(
				ConstraintType.ALL_SEGMENTS_ASCENDING,
				new SatisfactionLevel(allSegmentsAscendingConstraintValue,
						allSegmentsAscendingConstraintConfiguration.getWeighting()),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintLowerBound")),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintUpperBound")));

		addConstraint(allSegmentsAscendingConstraint);
	}

	private BigDecimal calculateAscendingSmoothedSegmentPercentage()
	{
		final List<Segment> smoothedSegments = this.timeSeries.getSegments();
		final int totalSegments = smoothedSegments.size();
		int ascendingSegmentCount = 0;

		for (Segment eachSegment : smoothedSegments)
		{
			if (eachSegment.getSlope() == Slope.ASCENDING)
			{
				ascendingSegmentCount++;
			}
		}

		int percentage = (ascendingSegmentCount * 100) / totalSegments;

		LOGGER.info(String.format("Percentage of ascending segments: %d", percentage));

		return new BigDecimal(percentage);
	}
}
