// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package io.expertinput.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.linguistics.aggregation.AggregationConstraintType;
import analysis.linguistics.aggregation.Aggregator;
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

	private Aggregator aggregator;
	private ConceptGroup conceptGroup;

	public AggregationListener()
	{
		this.aggregator = new Aggregator();
		LOGGER.info("New AggregationListener created");
	}

	@Override
	public void enterConceptGroup(AggregationParser.ConceptGroupContext context)
	{
		HardConstraintGroup<AggregationConstraintType> constraintGroup = new HardConstraintGroup<>(
				new HardConstraintProcessor());
		this.conceptGroup = new ConceptGroup(constraintGroup);
		context.conceptGroupTitle().getText();
	}

	@Override
	public void exitConceptGroup(AggregationParser.ConceptGroupContext context)
	{
		// this.aggregator.addConceptGroup(this.conceptGroup);
		this.conceptGroup = null;
	}

	@Override
	public void enterConceptGroupTitle(AggregationParser.ConceptGroupTitleContext context)
	{

	}

	@Override
	public void exitConceptGroupTitle(AggregationParser.ConceptGroupTitleContext context)
	{

	}

	@Override
	public void enterConcepts(AggregationParser.ConceptsContext context)
	{
	}

	@Override
	public void exitConcepts(AggregationParser.ConceptsContext context)
	{
	}

	@Override
	public void enterConcept(AggregationParser.ConceptContext context)
	{
	}

	@Override
	public void exitConcept(AggregationParser.ConceptContext context)
	{
		context.globalConcept().getText();
		context.timeSeriesConcept().getText();
	}

	@Override
	public void enterGlobalConcept(AggregationParser.GlobalConceptContext context)
	{
	}

	@Override
	public void exitGlobalConcept(AggregationParser.GlobalConceptContext context)
	{

	}

	@Override
	public void enterTimeSeriesConcept(AggregationParser.TimeSeriesConceptContext context)
	{
	}

	@Override
	public void exitTimeSeriesConcept(AggregationParser.TimeSeriesConceptContext context)
	{
	}
}
