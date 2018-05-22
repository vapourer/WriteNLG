// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package io.expertinput.listener;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.GlobalConcept;
import analysis.TimeSeriesSpecificConcept;
import analysis.constrain.Constraints;
import analysis.linguistics.aggregation.AggregationConcept;
import io.antlrgenerated.ConstraintsBaseListener;
import io.antlrgenerated.ConstraintsParser;
import io.antlrgenerated.ConstraintsParser.AggregationConceptContext;
import io.antlrgenerated.ConstraintsParser.GlobalConceptContext;
import io.antlrgenerated.ConstraintsParser.TimeSeriesConceptContext;

/**
 * ConstraintsBaseListener overrides specific to Constraints.
 */
public class ConstraintsListener extends ConstraintsBaseListener
{
	private static final Logger LOGGER = LogManager.getLogger("ConstraintsListener.class");

	private ConceptType conceptType;
	private GlobalConcept globalConcept;
	private TimeSeriesSpecificConcept timeSeriesSpecificConcept;
	private AggregationConcept aggregationConcept;

	/**
	 * Creates a new ConstraintsListener instance.
	 */
	public ConstraintsListener()
	{
		LOGGER.info("New ConstraintsListener created");
	}

	@Override
	public void exitConstraint(ConstraintsParser.ConstraintContext context)
	{
		final String constraintName = context.constraintName().getText();
		final BigDecimal initialValue = new BigDecimal(context.initialValue().getText());
		final BigDecimal weighting = context.weighting() == null ? new BigDecimal("1")
				: new BigDecimal(context.weighting().getText());

		switch (this.conceptType)
		{
			case AGGREGATION_CONCEPT:
				Constraints.getInstance().addConstraintConfigurationForAggregationConcept(this.aggregationConcept,
						constraintName, initialValue, weighting);
				LOGGER.info("Constraint configuration for aggregation concept loaded");
				break;
			case GLOBAL_CONCEPT:
				Constraints.getInstance().addConstraintConfigurationForGlobalConcept(this.globalConcept, constraintName,
						initialValue, weighting);
				LOGGER.info("Constraint configuration for global concept loaded");
				break;
			case TIME_SERIES_SPECIFIC_CONCEPT:
				Constraints.getInstance().addConstraintConfigurationForTimeSeriesSpecificConcept(
						timeSeriesSpecificConcept, constraintName, initialValue, weighting);
				LOGGER.info("Constraint configuration for time series specific concept loaded");
				break;
			default:
				LOGGER.error(String.format("%s not implemented", this.conceptType));
				throw new RuntimeException("Enum value not implemented");
		}
	}

	@Override
	public void enterGlobalConcept(GlobalConceptContext context)
	{
		this.timeSeriesSpecificConcept = null;
		this.aggregationConcept = null;

		this.globalConcept = Enum.valueOf(GlobalConcept.class, context.globalConceptType().getText());
		this.conceptType = ConceptType.GLOBAL_CONCEPT;

		LOGGER.info(String.format("Global concept is %s", context.globalConceptType().getText()));
	}

	@Override
	public void enterTimeSeriesConcept(TimeSeriesConceptContext context)
	{
		this.globalConcept = null;
		this.aggregationConcept = null;

		this.timeSeriesSpecificConcept = Enum.valueOf(TimeSeriesSpecificConcept.class,
				context.timeSeriesConceptType().getText());
		this.conceptType = ConceptType.TIME_SERIES_SPECIFIC_CONCEPT;

		LOGGER.info(String.format("Time series specific concept is %s", context.timeSeriesConceptType().getText()));
	}

	@Override
	public void enterAggregationConcept(AggregationConceptContext context)
	{
		this.globalConcept = null;
		this.timeSeriesSpecificConcept = null;

		this.aggregationConcept = Enum.valueOf(AggregationConcept.class, context.aggregationConceptType().getText());
		this.conceptType = ConceptType.AGGREGATION_CONCEPT;

		LOGGER.info(String.format("Aggregation concept is %s", context.aggregationConceptType().getText()));
	}

	private enum ConceptType
	{
		GLOBAL_CONCEPT, TIME_SERIES_SPECIFIC_CONCEPT, AGGREGATION_CONCEPT,
	}
}
