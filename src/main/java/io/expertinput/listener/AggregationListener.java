// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package io.expertinput.listener;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.GlobalConcept;
import analysis.TimeSeriesSpecificConcept;
import analysis.linguistics.aggregation.AggregationConcept;
import analysis.linguistics.aggregation.AggregationConstraintType;
import io.antlrgenerated.AggregationBaseListener;
import io.antlrgenerated.AggregationParser;
import writenlg.aggregation.ConceptGroup;
import writenlg.constrain.HardConstraintGroup;
import writenlg.constrain.HardConstraintProcessor;

/**
 * AggregationBaseListener overrides specific to aggregation.
 */
public class AggregationListener extends AggregationBaseListener
{
	private static final Logger LOGGER = LogManager.getLogger("AggregationListener.class");

	private final Map<AggregationConcept, ConceptGroup> conceptGroups;

	private boolean isGlobal;
	private ConceptGroup conceptGroup;
	private GlobalConcept globalConcept;
	private TimeSeriesSpecificConcept timeSeriesSpecificConcept;
	private String groupTitle;

	/**
	 * Creates a new AggregationListener instance.
	 * 
	 * @param concepts
	 */
	public AggregationListener()
	{
		// this.aggregator = new Aggregator(concepts);
		this.conceptGroups = new HashMap<>();
		LOGGER.info("New AggregationListener created");
	}

	@Override
	public void enterAggregationRules(AggregationParser.AggregationRulesContext context)
	{
		LOGGER.info("enterAggregationRules");
	}

	@Override
	public void exitAggregationRules(AggregationParser.AggregationRulesContext context)
	{
		LOGGER.info("exitAggregationRules");
	}

	@Override
	public void enterAggregationConceptGroupTitle(AggregationParser.AggregationConceptGroupTitleContext ctx)
	{
		LOGGER.info("enterAggregationConceptGroupTitle");
	}

	@Override
	public void exitAggregationConceptGroupTitle(AggregationParser.AggregationConceptGroupTitleContext ctx)
	{
		LOGGER.info("exitAggregationConceptGroupTitle");
	}

	@Override
	public void enterConcepts(AggregationParser.ConceptsContext ctx)
	{
		LOGGER.info("enterConcepts");
	}

	@Override
	public void exitConcepts(AggregationParser.ConceptsContext ctx)
	{
		LOGGER.info("exitConcepts");
	}

	@Override
	public void enterAggregationConceptGroup(AggregationParser.AggregationConceptGroupContext context)
	{
		LOGGER.info("enterAggregationConceptGroup");
		this.groupTitle = context.aggregationConceptGroupTitle().getText();

		LOGGER.info(String.format("Concept group title: %s", this.groupTitle));

		HardConstraintGroup<AggregationConstraintType> constraintGroup = new HardConstraintGroup<>(
				new HardConstraintProcessor());
		this.conceptGroup = new ConceptGroup(constraintGroup);
	}

	@Override
	public void exitAggregationConceptGroup(AggregationParser.AggregationConceptGroupContext context)
	{
		LOGGER.info("exitAggregationConceptGroup");
		// this.aggregator.addConceptGroup(this.conceptGroup);
		this.conceptGroups.put(Enum.valueOf(AggregationConcept.class, this.groupTitle), this.conceptGroup);
		this.conceptGroup = null;
	}

	@Override
	public void enterConcept(AggregationParser.ConceptContext context)
	{
		LOGGER.info("enterConcept");
		// context.globalConcept();
		// context.timeSeriesConcept();
	}
	// Enum.valueOf(AggregationConcept.class, this.groupTitle)
	// Enum.valueOf(GlobalConcept.class, context.globalConcept().getText())
	// Enum.valueOf(TimeSeriesSpecificConcept.class, context.timeSeriesConcept().getText())

	@Override
	public void exitConcept(AggregationParser.ConceptContext context)
	{
		LOGGER.info("exitConcept");
		if (context.globalConcept() != null)
		{
			this.conceptGroup.addGlobalConcept(Enum.valueOf(GlobalConcept.class, context.globalConcept().getText()));
			// this.conceptName = context.globalConcept().getText();
		}
		else if (context.timeSeriesConcept() != null)
		{
			this.conceptGroup.addTimeSeriesSpecificConcept(
					Enum.valueOf(TimeSeriesSpecificConcept.class, context.timeSeriesConcept().getText()));
			// this.conceptName = context.timeSeriesConcept().getText();
		}
	}

	@Override
	public void enterGlobalConcept(AggregationParser.GlobalConceptContext context)
	{
		LOGGER.info("enterGlobalConcept");
		this.isGlobal = true;
	}

	@Override
	public void enterTimeSeriesConcept(AggregationParser.TimeSeriesConceptContext context)
	{
		LOGGER.info("enterTimeSeriesConcept");
		this.isGlobal = false;
	}
}
