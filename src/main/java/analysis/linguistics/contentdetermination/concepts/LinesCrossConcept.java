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
 * Representation of a lines crossing concept.
 * Establishes constraint values for lines crossing, based on initial values and weightings input from ANTLR Constraints
 * text file, and analysis of time series data.
 */
public class LinesCrossConcept extends AbstractConcept
{
	private final LineGraphWithDerivedInformation lineGraph;
	private final Map<String, ConstraintConfiguration> constraints;

	/**
	 * Creates a new LinesCrossConcept instance.
	 * 
	 * @param phraseSpecifications
	 * @param lineGraph
	 */
	public LinesCrossConcept(final List<PhraseSpecification> phraseSpecifications,
			final LineGraphWithDerivedInformation lineGraph)
	{
		super(phraseSpecifications, new HardConstraintGroup<>(new BooleanConstraintProcessor()));

		this.lineGraph = lineGraph;

		this.constraints = Constraints.getInstance()
				.getConstraintConfigurationsForGlobalConcept(GlobalConcept.LINES_CROSS);

		assessConstraints();
	}

	private void assessConstraints()
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
		BigDecimal linesCross = GlobalConstants.ZERO;

		if (crossingPointCount > 0)
		{
			linesCross = GlobalConstants.ONE;
		}

		linesCross = linesCross.multiply(initialLinesCrossConstraintValue);
		final Constraint<ConstraintType> hardConstraint = new HardConstraint<ConstraintType>(ConstraintType.LINES_CROSS,
				new SatisfactionLevel(linesCross));
		addConstraint(hardConstraint);
	}

	private void assessLinesCrossMultipleTimesConstraint(int crossingPointCount)
	{
		final ConstraintConfiguration linesCrossMultipleTimesConstraintConfiguration = this.constraints
				.get(ConstraintType.LINES_CROSS_MULTIPLE_TIMES.getTextualForm());

		final BigDecimal initialLinesCrossMultipleTimesConstraintValue = linesCrossMultipleTimesConstraintConfiguration
				.getValue();
		BigDecimal linesCrossMultipleTimes = GlobalConstants.ONE;

		if (crossingPointCount > 1)
		{
			linesCrossMultipleTimes = GlobalConstants.ZERO;
		}

		linesCrossMultipleTimes = linesCrossMultipleTimes.multiply(initialLinesCrossMultipleTimesConstraintValue);
		final Constraint<ConstraintType> hardConstraint = new HardConstraint<ConstraintType>(
				ConstraintType.LINES_CROSS_MULTIPLE_TIMES, new SatisfactionLevel(linesCrossMultipleTimes));
		addConstraint(hardConstraint);
	}
}
