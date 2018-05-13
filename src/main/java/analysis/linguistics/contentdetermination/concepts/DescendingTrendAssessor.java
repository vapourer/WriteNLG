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
import analysis.constrain.BoundedWeightedConstraint;
import analysis.constrain.Constraint;
import analysis.constrain.ConstraintConfiguration;
import analysis.constrain.ConstraintGroup;
import analysis.constrain.ConstraintType;
import analysis.constrain.Constraints;
import analysis.constrain.SatisfactionLevel;
import analysis.constrain.SoftConstraintGroup;
import analysis.constrain.WeightedAverageConstraintProcessor;
import analysis.graph.Segment;
import analysis.graph.Slope;
import analysis.interfaces.Assessor;
import writenlg.control.WriteNlgProperties;

/**
 * Establishes constraint values for time series with a descending trend, based on initial values and weightings input
 * from
 * ANTLR Constraints text file, and analysis of time series data.
 */
public class DescendingTrendAssessor implements Assessor
{
	private static final Logger LOGGER = LogManager.getLogger("DescendingTrendAssessor.class");

	private final TimeSeriesWithDerivedInformation timeSeries;
	private final Map<String, ConstraintConfiguration> constraints;
	private final ConstraintGroup<ConstraintType> constraintTypes;

	/**
	 * Creates a new DescendingTrendAssessor instance.
	 * 
	 * @param timeSeriesWithDerivedInformation
	 */
	public DescendingTrendAssessor(final TimeSeriesWithDerivedInformation timeSeriesWithDerivedInformation)
	{
		this.timeSeries = timeSeriesWithDerivedInformation;

		this.constraints = Constraints.getInstance()
				.getConfigurationsForTimeSeriesSpecificConcept(TimeSeriesSpecificConcept.DESCENDING_TREND);

		this.constraintTypes = new SoftConstraintGroup<>(new WeightedAverageConstraintProcessor());

		LOGGER.info("DescendingTrendAssessor created");
	}

	@Override
	public void assessConstraints()
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
			mostSegmentsDescendingConstraintValue = new BigDecimal("1")
					.multiply(mostSegmentsDescendingConstraintConfiguration.getValue());
		}
		else
		{
			mostSegmentsDescendingConstraintValue = new BigDecimal("0")
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

		this.constraintTypes.addConstraint(mostSegmentsDescendingConstraint);
	}

	private void assessAllSegmentsDescendingConstraint()
	{
		final ConstraintConfiguration allSegmentsDescendingConstraintConfiguration = this.constraints
				.get(ConstraintType.ALL_SEGMENTS_DESCENDING.getTextualForm());

		final BigDecimal descendingSmoothedSegmentPercentage = calculateDescendingSmoothedSegmentPercentage();

		BigDecimal allSegmentsDescendingConstraintValue = null;

		if (descendingSmoothedSegmentPercentage.compareTo(new BigDecimal("100")) == 0)
		{
			allSegmentsDescendingConstraintValue = new BigDecimal("1")
					.multiply(allSegmentsDescendingConstraintConfiguration.getValue());
		}
		else
		{
			allSegmentsDescendingConstraintValue = new BigDecimal("0")
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

		this.constraintTypes.addConstraint(allSegmentsDescendingConstraint);
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

	/**
	 * @return the constraintTypes
	 */
	public ConstraintGroup<ConstraintType> getDescendingTrendConstraints()
	{
		return this.constraintTypes;
	}
}
