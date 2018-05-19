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
 * Establishes constraint values for lines not crossing, based on initial values and weightings input from ANTLR
 * Constraints
 * text file, and analysis of time series data.
 */
public class LinesDoNotCrossAssessor implements Assessor
{
	private final LineGraphWithDerivedInformation lineGraph;
	private final Map<String, ConstraintConfiguration> constraints;
	private final ConstraintGroup<ConstraintType> constraintTypes;

	/**
	 * Creates a new LinesDoNotCrossAssessor instance.
	 * 
	 * @param lineGraph
	 */
	public LinesDoNotCrossAssessor(final LineGraphWithDerivedInformation lineGraph)
	{
		this.lineGraph = lineGraph;

		this.constraints = Constraints.getInstance()
				.getConstraintConfigurationsForGlobalConcept(GlobalConcept.LINES_DO_NOT_CROSS);

		this.constraintTypes = new HardConstraintGroup<>(new BooleanConstraintProcessor());
	}

	@Override
	public void assessConstraints()
	{
		List<TimeSeriesWithDerivedInformation> timeSeries = this.lineGraph.getTimeSeriesDerivedInformation();
		int crossingPointCount = this.lineGraph.getCrossingPointCount(timeSeries.get(0), timeSeries.get(1));

		ConstraintConfiguration linesDoNotCrossConstraintConfiguration = this.constraints
				.get(ConstraintType.LINES_DO_NOT_CROSS.getTextualForm());

		BigDecimal initialLinesDoNotCrossConstraintValue = linesDoNotCrossConstraintConfiguration.getValue();
		BigDecimal linesDoNotCross = new BigDecimal("0");

		if (crossingPointCount == 0)
		{
			linesDoNotCross = new BigDecimal("1");
		}

		linesDoNotCross = linesDoNotCross.multiply(initialLinesDoNotCrossConstraintValue);
		Constraint<ConstraintType> hardConstraint1 = new HardConstraint<ConstraintType>(
				ConstraintType.LINES_DO_NOT_CROSS, new SatisfactionLevel(linesDoNotCross));
		this.constraintTypes.addConstraint(hardConstraint1);
	}

	/**
	 * @return the constraintTypes
	 */
	public ConstraintGroup<ConstraintType> getLinesDoNotCrossConstraints()
	{
		return constraintTypes;
	}
}
