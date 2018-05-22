// Generated from Constraints.g4 by ANTLR 4.7
package io.antlrgenerated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ConstraintsParser}.
 */
public interface ConstraintsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ConstraintsParser#constraintConfiguration}.
	 * @param ctx the parse tree
	 */
	void enterConstraintConfiguration(ConstraintsParser.ConstraintConfigurationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintsParser#constraintConfiguration}.
	 * @param ctx the parse tree
	 */
	void exitConstraintConfiguration(ConstraintsParser.ConstraintConfigurationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConstraintsParser#concept}.
	 * @param ctx the parse tree
	 */
	void enterConcept(ConstraintsParser.ConceptContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintsParser#concept}.
	 * @param ctx the parse tree
	 */
	void exitConcept(ConstraintsParser.ConceptContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConstraintsParser#globalConcept}.
	 * @param ctx the parse tree
	 */
	void enterGlobalConcept(ConstraintsParser.GlobalConceptContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintsParser#globalConcept}.
	 * @param ctx the parse tree
	 */
	void exitGlobalConcept(ConstraintsParser.GlobalConceptContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConstraintsParser#globalConceptType}.
	 * @param ctx the parse tree
	 */
	void enterGlobalConceptType(ConstraintsParser.GlobalConceptTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintsParser#globalConceptType}.
	 * @param ctx the parse tree
	 */
	void exitGlobalConceptType(ConstraintsParser.GlobalConceptTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConstraintsParser#timeSeriesConcept}.
	 * @param ctx the parse tree
	 */
	void enterTimeSeriesConcept(ConstraintsParser.TimeSeriesConceptContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintsParser#timeSeriesConcept}.
	 * @param ctx the parse tree
	 */
	void exitTimeSeriesConcept(ConstraintsParser.TimeSeriesConceptContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConstraintsParser#timeSeriesConceptType}.
	 * @param ctx the parse tree
	 */
	void enterTimeSeriesConceptType(ConstraintsParser.TimeSeriesConceptTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintsParser#timeSeriesConceptType}.
	 * @param ctx the parse tree
	 */
	void exitTimeSeriesConceptType(ConstraintsParser.TimeSeriesConceptTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConstraintsParser#aggregationConcept}.
	 * @param ctx the parse tree
	 */
	void enterAggregationConcept(ConstraintsParser.AggregationConceptContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintsParser#aggregationConcept}.
	 * @param ctx the parse tree
	 */
	void exitAggregationConcept(ConstraintsParser.AggregationConceptContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConstraintsParser#aggregationConceptType}.
	 * @param ctx the parse tree
	 */
	void enterAggregationConceptType(ConstraintsParser.AggregationConceptTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintsParser#aggregationConceptType}.
	 * @param ctx the parse tree
	 */
	void exitAggregationConceptType(ConstraintsParser.AggregationConceptTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConstraintsParser#constraints}.
	 * @param ctx the parse tree
	 */
	void enterConstraints(ConstraintsParser.ConstraintsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintsParser#constraints}.
	 * @param ctx the parse tree
	 */
	void exitConstraints(ConstraintsParser.ConstraintsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConstraintsParser#constraint}.
	 * @param ctx the parse tree
	 */
	void enterConstraint(ConstraintsParser.ConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintsParser#constraint}.
	 * @param ctx the parse tree
	 */
	void exitConstraint(ConstraintsParser.ConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConstraintsParser#constraintName}.
	 * @param ctx the parse tree
	 */
	void enterConstraintName(ConstraintsParser.ConstraintNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintsParser#constraintName}.
	 * @param ctx the parse tree
	 */
	void exitConstraintName(ConstraintsParser.ConstraintNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConstraintsParser#initialValue}.
	 * @param ctx the parse tree
	 */
	void enterInitialValue(ConstraintsParser.InitialValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintsParser#initialValue}.
	 * @param ctx the parse tree
	 */
	void exitInitialValue(ConstraintsParser.InitialValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConstraintsParser#weighting}.
	 * @param ctx the parse tree
	 */
	void enterWeighting(ConstraintsParser.WeightingContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintsParser#weighting}.
	 * @param ctx the parse tree
	 */
	void exitWeighting(ConstraintsParser.WeightingContext ctx);
}