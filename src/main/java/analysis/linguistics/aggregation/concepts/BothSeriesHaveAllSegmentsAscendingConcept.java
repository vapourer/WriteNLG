// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.aggregation.concepts;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.TimeSeriesSpecificConcept;
import analysis.constrain.Constraints;
import analysis.linguistics.aggregation.AggregationConcept;
import analysis.linguistics.contentdetermination.ConstraintType;
import analysis.utilities.GlobalConstants;
import control.WriteNlgProperties;
import writenlg.AbstractConcept;
import writenlg.aggregation.AbstractAggregationConcept;
import writenlg.constrain.Constraint;
import writenlg.constrain.ConstraintConfiguration;
import writenlg.constrain.HardConstraint;
import writenlg.constrain.HardConstraintGroup;
import writenlg.constrain.HardConstraintProcessor;
import writenlg.constrain.SatisfactionLevel;
import writenlg.linguistics.phrase.PhraseSpecification;

/**
 * Aggregates if both series have all segments ascending.
 */
public class BothSeriesHaveAllSegmentsAscendingConcept extends AbstractAggregationConcept
{
	private static final Logger LOGGER = LogManager.getLogger("BothSeriesHaveAllSegmentsAscendingConcept.class");

	private final Map<String, ConstraintConfiguration> constraints;

	private Map<TimeSeriesSpecificConcept, List<AbstractConcept>> timeSeriesSpecificConcepts;

	/**
	 * Creates a BothSeriesHaveAllSegmentsAscendingConcept instance.
	 */
	public BothSeriesHaveAllSegmentsAscendingConcept()
	{
		this(new ArrayList<>());
	}

	/**
	 * Creates a BothSeriesHaveAllSegmentsAscendingConcept instance.
	 * 
	 * @param phraseSpecifications
	 */
	public BothSeriesHaveAllSegmentsAscendingConcept(List<PhraseSpecification> phraseSpecifications)
	{
		super(phraseSpecifications, new HardConstraintGroup<>(new HardConstraintProcessor()));

		this.constraints = Constraints.getInstance()
				.getConfigurationsForAggregationConcept(AggregationConcept.BOTH_SERIES_HAVE_ALL_SEGMENTS_ASCENDING);

		LOGGER.info("BothSeriesHaveAllSegmentsAscendingConcept instance created");
	}

	/**
	 * @param timeSeriesSpecificConcepts
	 *            the timeSeriesSpecificConcepts to set
	 */
	public void setTimeSeriesSpecificConcepts(
			Map<TimeSeriesSpecificConcept, List<AbstractConcept>> timeSeriesSpecificConcepts)
	{
		this.timeSeriesSpecificConcepts = timeSeriesSpecificConcepts;
	}

	@Override
	protected void prepareAggregatedPhraseSpecification()
	{
		List<AbstractConcept> risingTrendConcepts = this.timeSeriesSpecificConcepts
				.get(TimeSeriesSpecificConcept.RISING_TREND);

		if (!risingTrendConcepts.isEmpty())
		{
			for (AbstractConcept eachConcept : risingTrendConcepts)
			{
				addPhraseSpecification(eachConcept.getPhraseSpecifications().get(0));
			}

			setConjunction("whilst");
		}
	}

	@Override
	protected void assessConstraints()
	{
		assessAllSegmentsAscendingConstraint();
		assessBothSeriesHaveAllSegmentsAscendingConstraint();
	}

	private void assessAllSegmentsAscendingConstraint()
	{
		BigDecimal allSegmentsAscending = this.constraints.get(ConstraintType.ALL_SEGMENTS_ASCENDING.getTextualForm())
				.getValue();

		final int allSegmentsAscendingCount = this.timeSeriesSpecificConcepts
				.get(TimeSeriesSpecificConcept.RISING_TREND).size();

		for (int i = 0; i < allSegmentsAscendingCount; i++)
		{
			final Constraint<ConstraintType> allSegmentsAscendingConstraint = new HardConstraint<ConstraintType>(
					ConstraintType.ALL_SEGMENTS_ASCENDING,
					new SatisfactionLevel(allSegmentsAscending.multiply(GlobalConstants.ONE)));

			addConstraint(allSegmentsAscendingConstraint);
		}
	}

	private void assessBothSeriesHaveAllSegmentsAscendingConstraint()
	{
		BigDecimal bothSeriesHaveAllSegmentsAscending = this.constraints
				.get(ConstraintType.BOTH_SERIES_HAVE_ALL_SEGMENTS_ASCENDING.getTextualForm()).getValue();

		int seriesWithAllSegmentsAscendingSize = Integer
				.parseInt(WriteNlgProperties.getInstance().getProperty("SeriesWithAllSegmentsAscendingSize"));

		if (this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.RISING_TREND)
				.size() == seriesWithAllSegmentsAscendingSize)
		{
			bothSeriesHaveAllSegmentsAscending = bothSeriesHaveAllSegmentsAscending.multiply(GlobalConstants.ONE);
		}
		else
		{
			bothSeriesHaveAllSegmentsAscending = bothSeriesHaveAllSegmentsAscending.multiply(GlobalConstants.ZERO);
		}

		final Constraint<ConstraintType> bothSeriesHaveAllSegmentsAscendingConstraint = new HardConstraint<ConstraintType>(
				ConstraintType.ALL_SEGMENTS_ASCENDING, new SatisfactionLevel(bothSeriesHaveAllSegmentsAscending));

		addConstraint(bothSeriesHaveAllSegmentsAscendingConstraint);
	}
}
