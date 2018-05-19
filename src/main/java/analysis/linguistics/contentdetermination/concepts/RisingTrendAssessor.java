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
import analysis.graph.Segment;
import analysis.graph.Slope;
import analysis.interfaces.Assessor;
import analysis.linguistics.contentdetermination.ConstraintType;
import writenlg.constrain.BoundedWeightedConstraint;
import writenlg.constrain.Constraint;
import writenlg.constrain.ConstraintConfiguration;
import writenlg.constrain.ConstraintGroup;
import writenlg.constrain.Constraints;
import writenlg.constrain.SatisfactionLevel;
import writenlg.constrain.SoftConstraintGroup;
import writenlg.constrain.WeightedAverageConstraintProcessor;
import writenlg.control.WriteNlgProperties;

/**
 * Establishes constraint values for time series with a rising trend, based on initial values and weightings input from
 * ANTLR Constraints text file, and analysis of time series data.
 */
public class RisingTrendAssessor implements Assessor
{
	private static final Logger LOGGER = LogManager.getLogger("RisingTrendAssessor.class");

	private final TimeSeriesWithDerivedInformation timeSeries;
	private final Map<String, ConstraintConfiguration> constraints;
	private final ConstraintGroup<ConstraintType> constraintTypes;

	public RisingTrendAssessor(final TimeSeriesWithDerivedInformation timeSeriesWithDerivedInformation)
	{
		this.timeSeries = timeSeriesWithDerivedInformation;

		this.constraints = Constraints.getInstance()
				.getConfigurationsForTimeSeriesSpecificConcept(TimeSeriesSpecificConcept.RISING_TREND);

		this.constraintTypes = new SoftConstraintGroup<>(new WeightedAverageConstraintProcessor());

		LOGGER.info("RisingTrendAssessor created");
	}

	@Override
	public void assessConstraints()
	{
		assessAllSegmentsAscendingConstraint();
		assessMostSegmentsAscendingConstraint();
	}

	private void assessMostSegmentsAscendingConstraint()
	{
		final ConstraintConfiguration mostSegmentsAscendingConstraintConfiguration = this.constraints
				.get(ConstraintType.MOST_SEGMENTS_ASCENDING.getTextualForm());

		BigDecimal ascendingSmoothedSegmentPercentage = calculateAscendingSmoothedSegmentPercentage();

		BigDecimal mostSegmentsAscendingPercentageThreshold = new BigDecimal(
				WriteNlgProperties.getInstance().getProperty("MostSegmentsSameSlopePercentageThreshold"));

		BigDecimal mostSegmentsAscendingConstraintValue = null;

		if (ascendingSmoothedSegmentPercentage.compareTo(mostSegmentsAscendingPercentageThreshold) >= 0)
		{
			mostSegmentsAscendingConstraintValue = new BigDecimal("1")
					.multiply(mostSegmentsAscendingConstraintConfiguration.getValue());
		}
		else
		{
			mostSegmentsAscendingConstraintValue = new BigDecimal("0")
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

		this.constraintTypes.addConstraint(mostSegmentsAscendingConstraint);
	}

	private void assessAllSegmentsAscendingConstraint()
	{
		final ConstraintConfiguration allSegmentsAscendingConstraintConfiguration = this.constraints
				.get(ConstraintType.ALL_SEGMENTS_ASCENDING.getTextualForm());

		BigDecimal ascendingSmoothedSegmentPercentage = calculateAscendingSmoothedSegmentPercentage();

		BigDecimal allSegmentsAscendingConstraintValue = null;

		if (ascendingSmoothedSegmentPercentage.compareTo(new BigDecimal("100")) == 0)
		{
			allSegmentsAscendingConstraintValue = new BigDecimal("1")
					.multiply(allSegmentsAscendingConstraintConfiguration.getValue());
		}
		else
		{
			allSegmentsAscendingConstraintValue = new BigDecimal("0")
					.multiply(allSegmentsAscendingConstraintConfiguration.getValue());
		}

		LOGGER.info(String.format("ALL_SEGMENTS_ASCENDING constraint value: %s", allSegmentsAscendingConstraintValue));

		final Constraint<ConstraintType> allSegmentsAscendingConstraint = new BoundedWeightedConstraint<ConstraintType>(
				ConstraintType.ALL_SEGMENTS_ASCENDING,
				new SatisfactionLevel(allSegmentsAscendingConstraintValue,
						allSegmentsAscendingConstraintConfiguration.getWeighting()),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintLowerBound")),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintUpperBound")));

		this.constraintTypes.addConstraint(allSegmentsAscendingConstraint);
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

	/**
	 * @return the constraintTypes
	 */
	public ConstraintGroup<ConstraintType> getRisingTrendConstraints()
	{
		return this.constraintTypes;
	}
}
