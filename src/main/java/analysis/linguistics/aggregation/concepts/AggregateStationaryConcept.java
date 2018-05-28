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
 * Aggregation of stationary series.
 */
public class AggregateStationaryConcept extends AbstractAggregationConcept
{
	private static final Logger LOGGER = LogManager.getLogger("AggregateStationaryConcept.class");

	private final Map<String, ConstraintConfiguration> constraints;

	private Map<TimeSeriesSpecificConcept, List<AbstractConcept>> timeSeriesSpecificConcepts;

	public AggregateStationaryConcept()
	{
		this(new ArrayList<>());
	}

	public AggregateStationaryConcept(List<PhraseSpecification> phraseSpecifications)
	{
		super(phraseSpecifications, new HardConstraintGroup<>(new HardConstraintProcessor()));

		this.constraints = Constraints.getInstance()
				.getConfigurationsForAggregationConcept(AggregationConcept.AGGREGATE_STATIONARY);
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
		processNoSignificantTrendConstraint();
		processBothSeriesStationaryConstraint();
	}

	private void processNoSignificantTrendConstraint()
	{
		BigDecimal noSignificantTrend = this.constraints.get(ConstraintType.NO_SIGNIFICANT_TREND.getTextualForm())
				.getValue();

		final int noSignificantTrendCount = this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.STATIONARY)
				.size();

		for (int i = 0; i < noSignificantTrendCount; i++)
		{
			final Constraint<ConstraintType> noSignificantTrendConstraint = new HardConstraint<ConstraintType>(
					ConstraintType.NO_SIGNIFICANT_TREND,
					new SatisfactionLevel(noSignificantTrend.multiply(GlobalConstants.ONE)));

			addConstraint(noSignificantTrendConstraint);
		}
	}

	private void processBothSeriesStationaryConstraint()
	{
		BigDecimal bothSeriesStationary = this.constraints.get(ConstraintType.BOTH_SERIES_STATIONARY.getTextualForm())
				.getValue();

		final int expectedTotalSeriesCount = Integer
				.parseInt(WriteNlgProperties.getInstance().getProperty("ExpectedTotalSeriesCount"));

		if (this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.STATIONARY)
				.size() == expectedTotalSeriesCount)
		{
			bothSeriesStationary = bothSeriesStationary.multiply(GlobalConstants.ONE);
		}
		else
		{
			bothSeriesStationary = bothSeriesStationary.multiply(GlobalConstants.ZERO);
		}

		final Constraint<ConstraintType> bothSeriesStationaryConstraint = new HardConstraint<ConstraintType>(
				ConstraintType.BOTH_SERIES_STATIONARY, new SatisfactionLevel(bothSeriesStationary));

		addConstraint(bothSeriesStationaryConstraint);
	}
}
