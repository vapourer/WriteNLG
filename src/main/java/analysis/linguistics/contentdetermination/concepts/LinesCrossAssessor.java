// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.contentdetermination.concepts;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import analysis.GlobalConcept;
import analysis.LineGraphWithDerivedInformation;
import analysis.TimeSeriesWithDerivedInformation;
import analysis.constrain.BooleanConstraintProcessor;
import analysis.constrain.Constraint;
import analysis.constrain.ConstraintConfiguration;
import analysis.constrain.ConstraintGroup;
import analysis.constrain.ConstraintType;
import analysis.constrain.Constraints;
import analysis.constrain.HardConstraint;
import analysis.constrain.HardConstraintGroup;
import analysis.constrain.SatisfactionLevel;
import analysis.interfaces.Assessor;

/**
 * Establishes constraint values for lines crossing, based on initial values and weightings input from ANTLR Constraints
 * text file, and analysis of time series data.
 */
public class LinesCrossAssessor implements Assessor
{
	private final LineGraphWithDerivedInformation lineGraph;
	private final Map<String, ConstraintConfiguration> constraints;
	private final ConstraintGroup<ConstraintType> constraintTypes;

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
		List<TimeSeriesWithDerivedInformation> timeSeries = this.lineGraph.getTimeSeriesDerivedInformation();
		int crossingPointCount = this.lineGraph.getCrossingPointCount(timeSeries.get(0), timeSeries.get(1));

		ConstraintConfiguration linesCrossConstraintConfiguration = this.constraints
				.get(ConstraintType.LINES_CROSS.getTextualForm());

		BigDecimal initialLinesCrossConstraintValue = linesCrossConstraintConfiguration.getValue();
		BigDecimal linesCross = new BigDecimal("0");

		if (crossingPointCount > 0)
		{
			linesCross = new BigDecimal("1");
		}

		linesCross = linesCross.multiply(initialLinesCrossConstraintValue);
		Constraint<ConstraintType> hardConstraint1 = new HardConstraint<ConstraintType>(
				ConstraintType.LINES_CROSS, new SatisfactionLevel(linesCross));
		this.constraintTypes.addConstraint(hardConstraint1);

		ConstraintConfiguration linesCrossMultipleTimesConstraintConfiguration = this.constraints
				.get(ConstraintType.LINES_CROSS_MULTIPLE_TIMES.getTextualForm());

		BigDecimal initialLinesCrossMultipleTimesConstraintValue = linesCrossMultipleTimesConstraintConfiguration
				.getValue();
		BigDecimal linesCrossMultipleTimes = new BigDecimal("1");

		if (crossingPointCount > 1)
		{
			linesCross = new BigDecimal("0");
		}

		linesCrossMultipleTimes = linesCrossMultipleTimes.multiply(initialLinesCrossMultipleTimesConstraintValue);
		Constraint<ConstraintType> hardConstraint2 = new HardConstraint<ConstraintType>(
				ConstraintType.LINES_CROSS_MULTIPLE_TIMES, new SatisfactionLevel(linesCross));
		this.constraintTypes.addConstraint(hardConstraint2);
	}

	/**
	 * @return the constraintTypes
	 */
	public ConstraintGroup<ConstraintType> getLinesCrossConstraints()
	{
		return constraintTypes;
	}
}
