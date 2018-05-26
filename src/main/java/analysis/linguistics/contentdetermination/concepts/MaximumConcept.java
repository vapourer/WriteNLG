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
import analysis.graph.Point;
import analysis.linguistics.contentdetermination.ConstraintType;
import analysis.statistics.Maximum;
import analysis.statistics.NinetyPercentile;
import analysis.statistics.UpperTurningPointsNinetyPercentile;
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
 * Representation of a time series maximum.
 * Establishes constraint values for time series maximum values, based on initial values and weightings input from ANTLR
 * Constraints text file, and analysis of time series data.
 */
public class MaximumConcept extends AbstractConcept
{
	private static final Logger LOGGER = LogManager.getLogger("MaximumConcept.class");

	private final TimeSeriesWithDerivedInformation timeSeries;
	private final Map<String, ConstraintConfiguration> constraints;

	/**
	 * Creates a new MaximumConcept instance.
	 * 
	 * @param phraseSpecifications
	 * @param timeSeriesWithDerivedInformation
	 */
	public MaximumConcept(final List<PhraseSpecification> phraseSpecifications,
			final TimeSeriesWithDerivedInformation timeSeriesWithDerivedInformation)
	{
		super(phraseSpecifications, new SoftConstraintGroup<>(new WeightedAverageConstraintProcessor()));

		this.timeSeries = timeSeriesWithDerivedInformation;
		this.constraints = Constraints.getInstance()
				.getConfigurationsForTimeSeriesSpecificConcept(TimeSeriesSpecificConcept.MAXIMUM);

		assessConstraints();
	}

	private void assessConstraints()
	{
		assessSingleObviousMaximumConstraint();
		assessMultipleHighTurningPointsConstraint();
		assessMaximumAtStartConstraint();
		assessMaximumAtEndConstraint();
	}

	private void assessMaximumAtStartConstraint()
	{
		final ConstraintConfiguration maximumAtStartConstraintConfiguration = this.constraints
				.get(ConstraintType.MAXIMUM_AT_START.getTextualForm());

		final Maximum maximum = new Maximum(this.timeSeries.getTimeSeries());
		final Point maximumPoint = maximum.calculate();

		BigDecimal maximumAtStartConstraintValue = null;

		if (maximumPoint.getX().compareTo(GlobalConstants.ZERO) == 0)
		{
			maximumAtStartConstraintValue = GlobalConstants.ONE
					.multiply(maximumAtStartConstraintConfiguration.getValue());
		}
		else
		{
			maximumAtStartConstraintValue = GlobalConstants.ZERO
					.multiply(maximumAtStartConstraintConfiguration.getValue());
		}

		final Constraint<ConstraintType> maximumAtStartConstraint = new BoundedWeightedConstraint<ConstraintType>(
				ConstraintType.MAXIMUM_AT_START,
				new SatisfactionLevel(maximumAtStartConstraintValue,
						maximumAtStartConstraintConfiguration.getWeighting()),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintLowerBound")),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintUpperBound")));

		addConstraint(maximumAtStartConstraint);
	}

	private void assessMaximumAtEndConstraint()
	{
		final ConstraintConfiguration maximumAtEndConstraintConfiguration = this.constraints
				.get(ConstraintType.MAXIMUM_AT_END.getTextualForm());

		final Maximum maximum = new Maximum(this.timeSeries.getTimeSeries());
		final Point maximumPoint = maximum.calculate();

		BigDecimal maximumAtEndConstraintValue = null;

		if (maximumPoint.getX().compareTo(new BigDecimal(this.timeSeries.getPoints().size() - 1)) == 0)
		{
			maximumAtEndConstraintValue = GlobalConstants.ONE.multiply(maximumAtEndConstraintConfiguration.getValue());
		}
		else
		{
			maximumAtEndConstraintValue = GlobalConstants.ZERO.multiply(maximumAtEndConstraintConfiguration.getValue());
		}

		final Constraint<ConstraintType> maximumAtEndConstraint = new BoundedWeightedConstraint<ConstraintType>(
				ConstraintType.MAXIMUM_AT_END,
				new SatisfactionLevel(maximumAtEndConstraintValue, maximumAtEndConstraintConfiguration.getWeighting()),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintLowerBound")),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintUpperBound")));

		addConstraint(maximumAtEndConstraint);
	}

	private void assessMultipleHighTurningPointsConstraint()
	{
		final ConstraintConfiguration multipleHighTurningPointsConstraintConfiguration = this.constraints
				.get(ConstraintType.MULTIPLE_HIGH_TURNING_POINTS.getTextualForm());

		int highPointCount = calculateHighPointsCount();

		BigDecimal multipleHighTurningPointsConstraintValue = null;

		switch (highPointCount)
		{
			case 1:
				multipleHighTurningPointsConstraintValue = GlobalConstants.ZERO
						.multiply(multipleHighTurningPointsConstraintConfiguration.getValue());
				break;
			case 2:
				multipleHighTurningPointsConstraintValue = new BigDecimal("0.3")
						.multiply(multipleHighTurningPointsConstraintConfiguration.getValue());
				break;
			case 3:
				multipleHighTurningPointsConstraintValue = new BigDecimal("0.6")
						.multiply(multipleHighTurningPointsConstraintConfiguration.getValue());
				break;
			default:
				multipleHighTurningPointsConstraintValue = GlobalConstants.ONE
						.multiply(multipleHighTurningPointsConstraintConfiguration.getValue());
				break;
		}

		final Constraint<ConstraintType> multipleHighTurningPointsConstraint = new BoundedWeightedConstraint<ConstraintType>(
				ConstraintType.MULTIPLE_HIGH_TURNING_POINTS,
				new SatisfactionLevel(multipleHighTurningPointsConstraintValue,
						multipleHighTurningPointsConstraintConfiguration.getWeighting()),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintLowerBound")),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintUpperBound")));

		addConstraint(multipleHighTurningPointsConstraint);
	}

	private void assessSingleObviousMaximumConstraint()
	{
		final ConstraintConfiguration singleObviousMaximumConstraintConfiguration = this.constraints
				.get(ConstraintType.SINGLE_OBVIOUS_MAXIMUM.getTextualForm());

		int highPointCount = calculateHighPointsCount();
		BigDecimal singleObviousMaximumConstraintValue = null;

		switch (highPointCount)
		{
			case 1:
				singleObviousMaximumConstraintValue = GlobalConstants.ONE
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

		addConstraint(singleObviousMaximumConstraint);
	}

	private int calculateHighPointsCount()
	{
		final UpperTurningPointsNinetyPercentile upperTurningPoints = new UpperTurningPointsNinetyPercentile(this.timeSeries);
		final List<Point> ninetyPercentileSmoothed = upperTurningPoints.identify();

		int highPointCount = ninetyPercentileSmoothed.size();

		final NinetyPercentile ninetyPercentile = new NinetyPercentile(this.timeSeries);
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

		return highPointCount;
	}
}
