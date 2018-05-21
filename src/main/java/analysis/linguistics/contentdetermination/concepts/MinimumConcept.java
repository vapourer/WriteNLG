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
import analysis.statistics.LowerTurningPointsSmoothed;
import analysis.statistics.Minimum;
import analysis.statistics.TenPercentile;
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
 * Representation of a time series minimum.
 * Establishes constraint values for time series minimum values, based on initial values and weightings input from ANTLR
 * Constraints text file, and analysis of time series data.
 */
public class MinimumConcept extends AbstractConcept
{
	private static final Logger LOGGER = LogManager.getLogger("MinimumConcept.class");

	private final TimeSeriesWithDerivedInformation timeSeries;
	private final Map<String, ConstraintConfiguration> constraints;

	/**
	 * Creates a new MinimumConcept instance.
	 * 
	 * @param phraseSpecifications
	 * @param timeSeriesWithDerivedInformation
	 */
	public MinimumConcept(List<PhraseSpecification> phraseSpecifications,
			final TimeSeriesWithDerivedInformation timeSeriesWithDerivedInformation)
	{
		super(phraseSpecifications, new SoftConstraintGroup<>(new WeightedAverageConstraintProcessor()));

		this.timeSeries = timeSeriesWithDerivedInformation;
		this.constraints = Constraints.getInstance()
				.getConfigurationsForTimeSeriesSpecificConcept(TimeSeriesSpecificConcept.MINIMUM);

		assessConstraints();
	}

	private void assessConstraints()
	{
		assessMinimumAtStartConstraint();
		assessMinimumAtEndConstraint();
		assessMultipleLowTurningPointsConstraint();
		assessSingleObviousMinimumConstraint();
	}

	private void assessMinimumAtStartConstraint()
	{
		final ConstraintConfiguration minimumAtStartConstraintConfiguration = this.constraints
				.get(ConstraintType.MINIMUM_AT_START.getTextualForm());

		Minimum minimum = new Minimum(this.timeSeries.getTimeSeries());
		Point minimumPoint = minimum.calculate();

		BigDecimal minimumAtStartConstraintValue = null;

		if (minimumPoint.getX().compareTo(new BigDecimal("0")) == 0)
		{
			minimumAtStartConstraintValue = new BigDecimal("1")
					.multiply(minimumAtStartConstraintConfiguration.getValue());
		}
		else
		{
			minimumAtStartConstraintValue = new BigDecimal("0")
					.multiply(minimumAtStartConstraintConfiguration.getValue());
		}

		final Constraint<ConstraintType> minimumAtStartConstraint = new BoundedWeightedConstraint<ConstraintType>(
				ConstraintType.MINIMUM_AT_START,
				new SatisfactionLevel(minimumAtStartConstraintValue,
						minimumAtStartConstraintConfiguration.getWeighting()),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintLowerBound")),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintUpperBound")));

		addConstraint(minimumAtStartConstraint);
	}

	private void assessMinimumAtEndConstraint()
	{
		final ConstraintConfiguration minimumAtEndConstraintConfiguration = this.constraints
				.get(ConstraintType.MINIMUM_AT_END.getTextualForm());

		Minimum minimum = new Minimum(this.timeSeries.getTimeSeries());
		Point minimumPoint = minimum.calculate();

		BigDecimal minimumAtEndConstraintValue = null;

		if (minimumPoint.getX().compareTo(new BigDecimal(this.timeSeries.getPoints().size() - 1)) == 0)
		{
			minimumAtEndConstraintValue = new BigDecimal("1").multiply(minimumAtEndConstraintConfiguration.getValue());
		}
		else
		{
			minimumAtEndConstraintValue = new BigDecimal("0").multiply(minimumAtEndConstraintConfiguration.getValue());
		}

		final Constraint<ConstraintType> minimumAtEndConstraint = new BoundedWeightedConstraint<ConstraintType>(
				ConstraintType.MINIMUM_AT_END,
				new SatisfactionLevel(minimumAtEndConstraintValue, minimumAtEndConstraintConfiguration.getWeighting()),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintLowerBound")),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintUpperBound")));

		addConstraint(minimumAtEndConstraint);
	}

	private void assessMultipleLowTurningPointsConstraint()
	{
		final ConstraintConfiguration multipleLowTurningPointsConstraintConfiguration = this.constraints
				.get(ConstraintType.MULTIPLE_LOW_TURNING_POINTS.getTextualForm());

		int lowPointCount = calculateLowPointsCount();

		BigDecimal multipleLowTurningPointsConstraintValue = null;

		switch (lowPointCount)
		{
			case 1:
				multipleLowTurningPointsConstraintValue = new BigDecimal("0")
						.multiply(multipleLowTurningPointsConstraintConfiguration.getValue());
				break;
			case 2:
				multipleLowTurningPointsConstraintValue = new BigDecimal("0.3")
						.multiply(multipleLowTurningPointsConstraintConfiguration.getValue());
				break;
			case 3:
				multipleLowTurningPointsConstraintValue = new BigDecimal("0.6")
						.multiply(multipleLowTurningPointsConstraintConfiguration.getValue());
				break;
			default:
				multipleLowTurningPointsConstraintValue = new BigDecimal("1")
						.multiply(multipleLowTurningPointsConstraintConfiguration.getValue());
				break;
		}

		final Constraint<ConstraintType> multipleLowTurningPointsConstraint = new BoundedWeightedConstraint<ConstraintType>(
				ConstraintType.MULTIPLE_LOW_TURNING_POINTS,
				new SatisfactionLevel(multipleLowTurningPointsConstraintValue,
						multipleLowTurningPointsConstraintConfiguration.getWeighting()),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintLowerBound")),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintUpperBound")));

		addConstraint(multipleLowTurningPointsConstraint);
	}

	private void assessSingleObviousMinimumConstraint()
	{
		final ConstraintConfiguration singleObviousMinimumConstraintConfiguration = this.constraints
				.get(ConstraintType.SINGLE_OBVIOUS_MINIMUM.getTextualForm());

		int lowPointCount = calculateLowPointsCount();

		BigDecimal singleObviousMinimumConstraintValue = null;

		switch (lowPointCount)
		{
			case 1:
				singleObviousMinimumConstraintValue = new BigDecimal("1")
						.multiply(singleObviousMinimumConstraintConfiguration.getValue());
				break;
			case 2:
				singleObviousMinimumConstraintValue = new BigDecimal("0.6")
						.multiply(singleObviousMinimumConstraintConfiguration.getValue());
				break;
			case 3:
				singleObviousMinimumConstraintValue = new BigDecimal("0.3")
						.multiply(singleObviousMinimumConstraintConfiguration.getValue());
				break;
			default:
				singleObviousMinimumConstraintValue = new BigDecimal("0.1")
						.multiply(singleObviousMinimumConstraintConfiguration.getValue());
				break;
		}

		final Constraint<ConstraintType> singleObviousMinimumConstraint = new BoundedWeightedConstraint<ConstraintType>(
				ConstraintType.SINGLE_OBVIOUS_MINIMUM,
				new SatisfactionLevel(singleObviousMinimumConstraintValue,
						singleObviousMinimumConstraintConfiguration.getWeighting()),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintLowerBound")),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintUpperBound")));

		addConstraint(singleObviousMinimumConstraint);
	}

	private int calculateLowPointsCount()
	{
		final LowerTurningPointsSmoothed lowerTurningPoints = new LowerTurningPointsSmoothed(this.timeSeries);
		final List<Point> tenPercentileSmoothed = lowerTurningPoints.identify();

		int lowPointCount = tenPercentileSmoothed.size();

		final TenPercentile tenPercentile = new TenPercentile(this.timeSeries);
		final Point[] lowPoints = tenPercentile.identify();

		for (Point eachPoint : lowPoints)
		{
			if (eachPoint.getX().compareTo(this.timeSeries.getPoints().get(0).getX()) == 0)
			{
				lowPointCount++;
			}

			if (eachPoint.getX()
					.compareTo(this.timeSeries.getPoints().get(this.timeSeries.getPoints().size() - 1).getX()) == 0)
			{
				lowPointCount++;
			}
		}

		LOGGER.info(String.format("Count of low points, including minimum: %d", lowPointCount));

		return lowPointCount;
	}
}
