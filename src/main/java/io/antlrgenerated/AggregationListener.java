// Generated from Aggregation.g4 by ANTLR 4.7
package io.antlrgenerated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AggregationParser}.
 */
public interface AggregationListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AggregationParser#aggregationRules}.
	 * @param ctx the parse tree
	 */
	void enterAggregationRules(AggregationParser.AggregationRulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link AggregationParser#aggregationRules}.
	 * @param ctx the parse tree
	 */
	void exitAggregationRules(AggregationParser.AggregationRulesContext ctx);
	/**
	 * Enter a parse tree produced by {@link AggregationParser#aggregationConceptGroup}.
	 * @param ctx the parse tree
	 */
	void enterAggregationConceptGroup(AggregationParser.AggregationConceptGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link AggregationParser#aggregationConceptGroup}.
	 * @param ctx the parse tree
	 */
	void exitAggregationConceptGroup(AggregationParser.AggregationConceptGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link AggregationParser#aggregationConceptGroupTitle}.
	 * @param ctx the parse tree
	 */
	void enterAggregationConceptGroupTitle(AggregationParser.AggregationConceptGroupTitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link AggregationParser#aggregationConceptGroupTitle}.
	 * @param ctx the parse tree
	 */
	void exitAggregationConceptGroupTitle(AggregationParser.AggregationConceptGroupTitleContext ctx);
	/**
	 * Enter a parse tree produced by {@link AggregationParser#concepts}.
	 * @param ctx the parse tree
	 */
	void enterConcepts(AggregationParser.ConceptsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AggregationParser#concepts}.
	 * @param ctx the parse tree
	 */
	void exitConcepts(AggregationParser.ConceptsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AggregationParser#concept}.
	 * @param ctx the parse tree
	 */
	void enterConcept(AggregationParser.ConceptContext ctx);
	/**
	 * Exit a parse tree produced by {@link AggregationParser#concept}.
	 * @param ctx the parse tree
	 */
	void exitConcept(AggregationParser.ConceptContext ctx);
	/**
	 * Enter a parse tree produced by {@link AggregationParser#globalConcept}.
	 * @param ctx the parse tree
	 */
	void enterGlobalConcept(AggregationParser.GlobalConceptContext ctx);
	/**
	 * Exit a parse tree produced by {@link AggregationParser#globalConcept}.
	 * @param ctx the parse tree
	 */
	void exitGlobalConcept(AggregationParser.GlobalConceptContext ctx);
	/**
	 * Enter a parse tree produced by {@link AggregationParser#timeSeriesConcept}.
	 * @param ctx the parse tree
	 */
	void enterTimeSeriesConcept(AggregationParser.TimeSeriesConceptContext ctx);
	/**
	 * Exit a parse tree produced by {@link AggregationParser#timeSeriesConcept}.
	 * @param ctx the parse tree
	 */
	void exitTimeSeriesConcept(AggregationParser.TimeSeriesConceptContext ctx);
}