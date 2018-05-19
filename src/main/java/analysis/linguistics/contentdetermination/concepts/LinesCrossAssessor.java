// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.contentdetermination.concepts;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import analysis.GlobalConcept;
import analysis.LineGraphWithDerivedInformation;
import analysis.TimeSeriesWithDerivedInformation;
import analysis.constrain.Constraints;
import analysis.interfaces.Assessor;
import analysis.linguistics.contentdetermination.ConstraintType;
import writenlg.constrain.BooleanConstraintProcessor;
import writenlg.constrain.Constraint;
import writenlg.constrain.ConstraintConfiguration;
import writenlg.constrain.ConstraintGroup;
import writenlg.constrain.HardConstraint;
import writenlg.constrain.HardConstraintGroup;
import writenlg.constrain.SatisfactionLevel;

/**
 * Establishes constraint values for lines crossing, based on initial values and weightings input from ANTLR Constraints
 * text file, and analysis of time series data.
 */
public class LinesCrossAssessor implements Assessor
{
	private final LineGraphWithDerivedInformation lineGraph;
	private final Map<String, ConstraintConfiguration> constraints;
	private final ConstraintGroup<ConstraintType> constraintTypes;

	/**
	 * Creates a LinesCrossAssessor instance.
	 * 
	 * @param lineGraph
	 */
	public LinesCrossAssessor(final LineGraphWithDerivedInformation lineGraph)
	{
		this.lineGraph = lineGraph;

		this.constraints = Constraints.getInstance()
				.getConstraintConfigurationsForGlobalConcept(GlobalConcept.LINES_CROSS);

		this.constraintTypes = new HardConstraintGroup<>(new BooleanConstraintProcessor());
	}

	@Override
	public void assessConstraints()
	{
		final List<TimeSeriesWithDerivedInformation> timeSeries = this.lineGraph.getTimeSeriesDerivedInformation();
		final int crossingPointCount = this.lineGraph.getCrossingPointCount(timeSeries.get(0), timeSeries.get(1));

		assessLinesCrossConstraint(crossingPointCount);
		assessLinesCrossMultipleTimesConstraint(crossingPointCount);
	}

	private void assessLinesCrossConstraint(int crossingPointCount)
	{
		final ConstraintConfiguration linesCrossConstraintConfiguration = this.constraints
				.get(ConstraintType.LINES_CROSS.getTextualForm());

		final BigDecimal initialLinesCrossConstraintValue = linesCrossConstraintConfiguration.getValue();
		BigDecimal linesCross = new BigDecimal("0");

		if (crossingPointCount > 0)
		{
			linesCross = new BigDecimal("1");
		}

		linesCross = linesCross.multiply(initialLinesCrossConstraintValue);
		final Constraint<ConstraintType> hardConstraint = new HardConstraint<ConstraintType>(ConstraintType.LINES_CROSS,
				new SatisfactionLevel(linesCross));
		this.constraintTypes.addConstraint(hardConstraint);
	}

	private void assessLinesCrossMultipleTimesConstraint(int crossingPointCount)
	{
		final ConstraintConfiguration linesCrossMultipleTimesConstraintConfiguration = this.constraints
				.get(ConstraintType.LINES_CROSS_MULTIPLE_TIMES.getTextualForm());

		final BigDecimal initialLinesCrossMultipleTimesConstraintValue = linesCrossMultipleTimesConstraintConfiguration
				.getValue();
		BigDecimal linesCrossMultipleTimes = new BigDecimal("1");

		if (crossingPointCount > 1)
		{
			linesCrossMultipleTimes = new BigDecimal("0");
		}

		linesCrossMultipleTimes = linesCrossMultipleTimes.multiply(initialLinesCrossMultipleTimesConstraintValue);
		final Constraint<ConstraintType> hardConstraint = new HardConstraint<ConstraintType>(
				ConstraintType.LINES_CROSS_MULTIPLE_TIMES, new SatisfactionLevel(linesCrossMultipleTimes));
		this.constraintTypes.addConstraint(hardConstraint);
	}

	/**
	 * @return the constraintTypes
	 */
	public ConstraintGroup<ConstraintType> getLinesCrossConstraints()
	{
		return constraintTypes;
	}
}
