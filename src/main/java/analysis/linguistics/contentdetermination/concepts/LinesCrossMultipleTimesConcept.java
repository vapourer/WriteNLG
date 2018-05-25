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
import analysis.linguistics.contentdetermination.ConstraintType;
import analysis.utilities.GlobalConstants;
import writenlg.AbstractConcept;
import writenlg.constrain.BooleanConstraintProcessor;
import writenlg.constrain.Constraint;
import writenlg.constrain.ConstraintConfiguration;
import writenlg.constrain.HardConstraint;
import writenlg.constrain.HardConstraintGroup;
import writenlg.constrain.SatisfactionLevel;
import writenlg.linguistics.phrase.PhraseSpecification;

/**
 * Representation of a lines crossing multiple times concept.
 * Establishes constraint values for lines crossing multiple times, based on initial values and weightings input from
 * ANTLR Constraintstext file, and analysis of time series data.
 */
public class LinesCrossMultipleTimesConcept extends AbstractConcept
{
	private final LineGraphWithDerivedInformation lineGraph;
	private final Map<String, ConstraintConfiguration> constraints;

	/**
	 * Creates a new LinesCrossMultipleTimesConcept instance.
	 * 
	 * @param phraseSpecifications
	 * @param lineGraph
	 */
	public LinesCrossMultipleTimesConcept(final List<PhraseSpecification> phraseSpecifications,
			final LineGraphWithDerivedInformation lineGraph)
	{
		super(phraseSpecifications, new HardConstraintGroup<>(new BooleanConstraintProcessor()));

		this.lineGraph = lineGraph;

		this.constraints = Constraints.getInstance()
				.getConstraintConfigurationsForGlobalConcept(GlobalConcept.LINES_CROSS_MULTIPLE_TIMES);

		assessConstraints();
	}

	private void assessConstraints()
	{
		List<TimeSeriesWithDerivedInformation> timeSeries = this.lineGraph.getTimeSeriesDerivedInformation();
		int crossingPointCount = this.lineGraph.getCrossingPointCount(timeSeries.get(0), timeSeries.get(1));

		ConstraintConfiguration linesCrossMultipleTimesConstraintConfiguration = this.constraints
				.get(ConstraintType.LINES_CROSS_MULTIPLE_TIMES.getTextualForm());

		BigDecimal initialLinesCrossMultipleTimesConstraintValue = linesCrossMultipleTimesConstraintConfiguration
				.getValue();
		BigDecimal linesCrossMultipleTimes = GlobalConstants.ZERO;

		if (crossingPointCount > 1)
		{
			linesCrossMultipleTimes = GlobalConstants.ONE;
		}

		linesCrossMultipleTimes = linesCrossMultipleTimes.multiply(initialLinesCrossMultipleTimesConstraintValue);
		Constraint<ConstraintType> hardConstraint1 = new HardConstraint<ConstraintType>(ConstraintType.LINES_CROSS,
				new SatisfactionLevel(linesCrossMultipleTimes));
		addConstraint(hardConstraint1);

		ConstraintConfiguration linesCrossOnceConstraintConfiguration = this.constraints
				.get(ConstraintType.LINES_CROSS_ONCE.getTextualForm());

		BigDecimal initialLinesCrossOnceConstraintValue = linesCrossOnceConstraintConfiguration.getValue();
		BigDecimal linesCrossOnce = GlobalConstants.ONE;

		if (crossingPointCount == 1)
		{
			linesCrossOnce = GlobalConstants.ZERO;
		}

		linesCrossOnce = linesCrossOnce.multiply(initialLinesCrossOnceConstraintValue);
		Constraint<ConstraintType> hardConstraint2 = new HardConstraint<ConstraintType>(ConstraintType.LINES_CROSS_ONCE,
				new SatisfactionLevel(linesCrossOnce));
		addConstraint(hardConstraint2);
	}
}
