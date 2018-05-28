// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.aggregation.concepts;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.GlobalConcept;
import analysis.constrain.Constraints;
import analysis.linguistics.aggregation.AggregationConcept;
import analysis.linguistics.contentdetermination.ConstraintType;
import analysis.utilities.GlobalConstants;
import writenlg.AbstractConcept;
import writenlg.aggregation.AbstractAggregationConcept;
import writenlg.constrain.BooleanConstraintProcessor;
import writenlg.constrain.Constraint;
import writenlg.constrain.ConstraintConfiguration;
import writenlg.constrain.HardConstraint;
import writenlg.constrain.HardConstraintGroup;
import writenlg.constrain.SatisfactionLevel;
import writenlg.linguistics.phrase.PhraseSpecification;

/**
 * Aggregation of SeriesDifferencesTrendConcept and SeriesDifferencesAverageConcept
 */
public class AggregateLineBehaviourConcept extends AbstractAggregationConcept
{
	private static final Logger LOGGER = LogManager.getLogger("AggregateLineBehaviourConcept.class");

	private final Map<String, ConstraintConfiguration> constraints;

	private Map<GlobalConcept, AbstractConcept> globalConcepts;

	/**
	 * Creates a new AggregateLineBehaviourConcept instance.
	 */
	public AggregateLineBehaviourConcept()
	{
		this(new ArrayList<>());
	}

	/**
	 * Creates a new AggregateLineBehaviourConcept instance.
	 * 
	 * @param phraseSpecifications
	 */
	public AggregateLineBehaviourConcept(final List<PhraseSpecification> phraseSpecifications)
	{
		super(phraseSpecifications, new HardConstraintGroup<>(new BooleanConstraintProcessor()));

		this.constraints = Constraints.getInstance()
				.getConfigurationsForAggregationConcept(AggregationConcept.AGGREGATE_LINE_BEHAVIOUR);
	}

	/**
	 * @param globalConcepts
	 *            the globalConcepts to set
	 */
	public void setGlobalConcepts(Map<GlobalConcept, AbstractConcept> globalConcepts)
	{
		this.globalConcepts = globalConcepts;
	}

	@Override
	protected void prepareAggregatedPhraseSpecification()
	{
		if (this.getPhraseSpecifications().size() == 0)
		{
			LOGGER.error(
					"List of phrase specifications was empty, but current implementation expects a prepared phrase specification from ANTLR input");
			throw new RuntimeException(
					"Current implementation expects a prepared phrase specification from ANTLR input");
		}
	}

	@Override
	protected void assessConstraints()
	{
		assessLinesDoNotCrossConstraint();
		assessGapAverageAndTrendPresentConstraint();
	}

	private void assessLinesDoNotCrossConstraint()
	{
		BigDecimal linesDoNotCross = this.constraints.get(ConstraintType.LINES_DO_NOT_CROSS.getTextualForm())
				.getValue();

		if (this.globalConcepts.get(GlobalConcept.LINES_DO_NOT_CROSS) != null)
		{
			linesDoNotCross = linesDoNotCross.multiply(GlobalConstants.ONE);
		}
		else
		{
			linesDoNotCross = linesDoNotCross.multiply(GlobalConstants.ZERO);
		}

		final Constraint<ConstraintType> linesDoNotCrossConstraint = new HardConstraint<ConstraintType>(
				ConstraintType.LINES_DO_NOT_CROSS, new SatisfactionLevel(linesDoNotCross));

		addConstraint(linesDoNotCrossConstraint);
	}

	private void assessGapAverageAndTrendPresentConstraint()
	{
		BigDecimal gapAverageAndTrendPresent = this.constraints
				.get(ConstraintType.GAP_AVERAGE_AND_TREND_PRESENT.getTextualForm()).getValue();

		if (this.globalConcepts.get(GlobalConcept.SERIES_DIFFERENCES_AVERAGE) != null)
		{
			gapAverageAndTrendPresent = gapAverageAndTrendPresent.multiply(GlobalConstants.ONE);
		}
		else
		{
			gapAverageAndTrendPresent = gapAverageAndTrendPresent.multiply(GlobalConstants.ZERO);
		}

		if (this.globalConcepts.get(GlobalConcept.SERIES_DIFFERENCES_TREND) != null)
		{
			gapAverageAndTrendPresent = gapAverageAndTrendPresent.multiply(GlobalConstants.ONE);
		}
		else
		{
			gapAverageAndTrendPresent = gapAverageAndTrendPresent.multiply(GlobalConstants.ZERO);
		}

		final Constraint<ConstraintType> gapAverageAndTrendPresentConstraint = new HardConstraint<ConstraintType>(
				ConstraintType.LINES_DO_NOT_CROSS, new SatisfactionLevel(gapAverageAndTrendPresent));

		addConstraint(gapAverageAndTrendPresentConstraint);
	}
}
