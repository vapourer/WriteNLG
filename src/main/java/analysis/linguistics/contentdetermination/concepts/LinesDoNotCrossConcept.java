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
import writenlg.AbstractConcept;
import writenlg.constrain.BooleanConstraintProcessor;
import writenlg.constrain.Constraint;
import writenlg.constrain.ConstraintConfiguration;
import writenlg.constrain.HardConstraint;
import writenlg.constrain.HardConstraintGroup;
import writenlg.constrain.SatisfactionLevel;
import writenlg.linguistics.phrase.PhraseSpecification;

/**
 * Representation of a lines not crossing concept.
 * Establishes constraint values for lines not crossing, based on initial values and weightings input from ANTLR
 * Constraints text file, and analysis of time series data.
 */
public class LinesDoNotCrossConcept extends AbstractConcept
{
	private final LineGraphWithDerivedInformation lineGraph;
	private final Map<String, ConstraintConfiguration> constraints;

	/**
	 * Creates a new LinesDoNotCrossConcept instance.
	 * 
	 * @param phraseSpecifications
	 * @param constraintGroup
	 */
	public LinesDoNotCrossConcept(List<PhraseSpecification> phraseSpecifications,
			final LineGraphWithDerivedInformation lineGraph)
	{
		super(phraseSpecifications, new HardConstraintGroup<>(new BooleanConstraintProcessor()));

		this.lineGraph = lineGraph;

		this.constraints = Constraints.getInstance()
				.getConstraintConfigurationsForGlobalConcept(GlobalConcept.LINES_DO_NOT_CROSS);

		assessConstraints();
	}

	private void assessConstraints()
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
		addConstraint(hardConstraint1);
	}
}
