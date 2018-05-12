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
import analysis.graph.Point;
import analysis.interfaces.Assessor;
import analysis.statistics.NinetyPercentile;
import analysis.statistics.UpperTurningPointsSmoothed;
import writenlg.control.WriteNlgProperties;

/**
 * Establishes constraint values for time series maximum values, based on initial values and weightings input from ANTLR
 * Constraints text file, and analysis of time series data.
 */
public class MaximumAssessor implements Assessor
{
	private static final Logger LOGGER = LogManager.getLogger("MaximumAssessor.class");

	private final TimeSeriesWithDerivedInformation timeSeries;
	private final Map<String, ConstraintConfiguration> constraints;
	private final ConstraintGroup<ConstraintType> constraintTypes;

	/**
	 * Creates a MaximumAssessor instance.
	 * 
	 * @param timeSeriesWithDerivedInformation
	 */
	public MaximumAssessor(final TimeSeriesWithDerivedInformation timeSeriesWithDerivedInformation)
	{
		this.timeSeries = timeSeriesWithDerivedInformation;

		this.constraints = Constraints.getInstance()
				.getConfigurationsForTimeSeriesSpecificConcept(TimeSeriesSpecificConcept.MAXIMUM);

		this.constraintTypes = new SoftConstraintGroup<>(new WeightedAverageConstraintProcessor());

		LOGGER.info("MaximumAssessor created");
	}

	@Override
	public void assessConstraints()
	{
		assessSingleObviousMaximumConstraint();
	}

	private void assessSingleObviousMaximumConstraint()
	{
		final ConstraintConfiguration singleObviousMaximumConstraintConfiguration = this.constraints
				.get(ConstraintType.SINGLE_OBVIOUS_MAXIMUM.getTextualForm());

		UpperTurningPointsSmoothed upperTurningPoints = new UpperTurningPointsSmoothed(this.timeSeries);
		List<Point> ninetyPercentileSmoothed = upperTurningPoints.identify();

		int highPointCount = ninetyPercentileSmoothed.size();

		NinetyPercentile ninetyPercentile = new NinetyPercentile(this.timeSeries);
		Point[] highPoints = ninetyPercentile.identify();

		for (Point eachPoint : highPoints)
		{
			if (eachPoint.getX().compareTo(this.timeSeries.getPoints().get(0).getX()) == 0)
			{
				highPointCount++;
			}

			if (eachPoint.getX()
					.compareTo(this.timeSeries.getPoints().get(this.timeSeries.getPoints().size() - 1).getX()) == 0)
			{
				highPointCount++;
			}
		}

		LOGGER.info(String.format("Count of high points, including maximum: %d", highPointCount));

		BigDecimal singleObviousMaximumConstraintValue = null;

		switch (highPointCount)
		{
			case 1:
				singleObviousMaximumConstraintValue = new BigDecimal("1")
						.multiply(singleObviousMaximumConstraintConfiguration.getValue());
				break;
			case 2:
				singleObviousMaximumConstraintValue = new BigDecimal("0.6")
						.multiply(singleObviousMaximumConstraintConfiguration.getValue());
				break;
			case 3:
				singleObviousMaximumConstraintValue = new BigDecimal("0.3")
						.multiply(singleObviousMaximumConstraintConfiguration.getValue());
				break;
			default:
				singleObviousMaximumConstraintValue = new BigDecimal("0.1")
						.multiply(singleObviousMaximumConstraintConfiguration.getValue());
				break;
		}

		final Constraint<ConstraintType> singleObviousMaximumConstraint = new BoundedWeightedConstraint<ConstraintType>(
				ConstraintType.SINGLE_OBVIOUS_MAXIMUM,
				new SatisfactionLevel(singleObviousMaximumConstraintValue,
						singleObviousMaximumConstraintConfiguration.getWeighting()),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintLowerBound")),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintUpperBound")));

		this.constraintTypes.addConstraint(singleObviousMaximumConstraint);
	}

	/**
	 * @return the constraintTypes
	 */
	public ConstraintGroup<ConstraintType> getMaximumConstraints()
	{
		return this.constraintTypes;
	}
}
