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
import io.antlrgenerated.AggregationBaseListener;
import io.antlrgenerated.AggregationParser;
import writenlg.aggregation.ConceptGroup;

/**
 * AggregationBaseListener overrides specific to aggregation.
 */
public class AggregationListener extends AggregationBaseListener
{
	private static final Logger LOGGER = LogManager.getLogger("AggregationListener.class");

	private final Map<AggregationConcept, ConceptGroup> conceptGroups;

	private ConceptGroup conceptGroup;
	private String groupTitle;

	/**
	 * Creates a new AggregationListener instance.
	 * 
	 * @param concepts
	 */
	public AggregationListener()
	{
		this.conceptGroups = new HashMap<>();
		LOGGER.info("New AggregationListener created");
	}

	@Override
	public void enterAggregationConceptGroup(AggregationParser.AggregationConceptGroupContext context)
	{
		this.groupTitle = context.aggregationConceptGroupTitle().getText();

		LOGGER.info(String.format("Concept group title: %s", this.groupTitle));

		this.conceptGroup = new ConceptGroup();
	}

	@Override
	public void exitAggregationConceptGroup(AggregationParser.AggregationConceptGroupContext context)
	{
		this.conceptGroups.put(Enum.valueOf(AggregationConcept.class, this.groupTitle), this.conceptGroup);
		this.conceptGroup = null;
		this.groupTitle = null;
	}

	@Override
	public void exitConcept(AggregationParser.ConceptContext context)
	{
		if (context.globalConcept() != null)
		{
			LOGGER.info(String.format("globalConcept: %s", context.globalConcept().getText()));
			this.conceptGroup.addGlobalConcept(Enum.valueOf(GlobalConcept.class, context.globalConcept().getText()));
		}
		else if (context.timeSeriesConcept() != null)
		{
			LOGGER.info(String.format("timeSeriesConcept: %s", context.timeSeriesConcept().getText()));
			this.conceptGroup.addTimeSeriesSpecificConcept(
					Enum.valueOf(TimeSeriesSpecificConcept.class, context.timeSeriesConcept().getText()));
		}
	}

	/**
	 * @return the conceptGroups
	 */
	public Map<AggregationConcept, ConceptGroup> getConceptGroups()
	{
		return this.conceptGroups;
	}
}
