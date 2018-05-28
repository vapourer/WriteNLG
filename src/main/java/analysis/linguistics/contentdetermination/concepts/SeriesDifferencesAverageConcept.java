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
 * Represents the mean of the gaps between series, after calculating a centred moving average.
 */
public class SeriesDifferencesAverageConcept extends AbstractConcept
{
	private final LineGraphWithDerivedInformation lineGraph;
	private final Map<String, ConstraintConfiguration> constraints;

	public SeriesDifferencesAverageConcept(List<PhraseSpecification> phraseSpecifications,
			final LineGraphWithDerivedInformation lineGraph)
	{
		super(phraseSpecifications, new HardConstraintGroup<>(new BooleanConstraintProcessor()));

		this.lineGraph = lineGraph;

		this.constraints = Constraints.getInstance()
				.getConstraintConfigurationsForGlobalConcept(GlobalConcept.SERIES_DIFFERENCES_AVERAGE);

		assessConstraints();
	}

	private void assessConstraints()
	{
		List<TimeSeriesWithDerivedInformation> timeSeries = this.lineGraph.getTimeSeriesDerivedInformation();
		int crossingPointCount = this.lineGraph.getCrossingPointCount(timeSeries.get(0), timeSeries.get(1));

		ConstraintConfiguration linesDoNotCrossConstraintConfiguration = this.constraints
				.get(ConstraintType.LINES_DO_NOT_CROSS.getTextualForm());

		BigDecimal initialLinesDoNotCrossConstraintValue = linesDoNotCrossConstraintConfiguration.getValue();
		BigDecimal linesDoNotCross = GlobalConstants.ZERO;

		if (crossingPointCount == 0)
		{
			linesDoNotCross = GlobalConstants.ONE;
		}

		linesDoNotCross = linesDoNotCross.multiply(initialLinesDoNotCrossConstraintValue);
		Constraint<ConstraintType> hardConstraint1 = new HardConstraint<ConstraintType>(
				ConstraintType.LINES_DO_NOT_CROSS, new SatisfactionLevel(linesDoNotCross));
		addConstraint(hardConstraint1);
	}
}
