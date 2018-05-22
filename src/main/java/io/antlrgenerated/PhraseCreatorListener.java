// Generated from PhraseCreator.g4 by ANTLR 4.7
package io.antlrgenerated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PhraseCreatorParser}.
 */
public interface PhraseCreatorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PhraseCreatorParser#writeDocument}.
	 * @param ctx the parse tree
	 */
	void enterWriteDocument(PhraseCreatorParser.WriteDocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PhraseCreatorParser#writeDocument}.
	 * @param ctx the parse tree
	 */
	void exitWriteDocument(PhraseCreatorParser.WriteDocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PhraseCreatorParser#concept}.
	 * @param ctx the parse tree
	 */
	void enterConcept(PhraseCreatorParser.ConceptContext ctx);
	/**
	 * Exit a parse tree produced by {@link PhraseCreatorParser#concept}.
	 * @param ctx the parse tree
	 */
	void exitConcept(PhraseCreatorParser.ConceptContext ctx);
	/**
	 * Enter a parse tree produced by {@link PhraseCreatorParser#globalConcept}.
	 * @param ctx the parse tree
	 */
	void enterGlobalConcept(PhraseCreatorParser.GlobalConceptContext ctx);
	/**
	 * Exit a parse tree produced by {@link PhraseCreatorParser#globalConcept}.
	 * @param ctx the parse tree
	 */
	void exitGlobalConcept(PhraseCreatorParser.GlobalConceptContext ctx);
	/**
	 * Enter a parse tree produced by {@link PhraseCreatorParser#globalConceptType}.
	 * @param ctx the parse tree
	 */
	void enterGlobalConceptType(PhraseCreatorParser.GlobalConceptTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PhraseCreatorParser#globalConceptType}.
	 * @param ctx the parse tree
	 */
	void exitGlobalConceptType(PhraseCreatorParser.GlobalConceptTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PhraseCreatorParser#timeSeriesConcept}.
	 * @param ctx the parse tree
	 */
	void enterTimeSeriesConcept(PhraseCreatorParser.TimeSeriesConceptContext ctx);
	/**
	 * Exit a parse tree produced by {@link PhraseCreatorParser#timeSeriesConcept}.
	 * @param ctx the parse tree
	 */
	void exitTimeSeriesConcept(PhraseCreatorParser.TimeSeriesConceptContext ctx);
	/**
	 * Enter a parse tree produced by {@link PhraseCreatorParser#timeSeriesConceptType}.
	 * @param ctx the parse tree
	 */
	void enterTimeSeriesConceptType(PhraseCreatorParser.TimeSeriesConceptTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PhraseCreatorParser#timeSeriesConceptType}.
	 * @param ctx the parse tree
	 */
	void exitTimeSeriesConceptType(PhraseCreatorParser.TimeSeriesConceptTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PhraseCreatorParser#aggregationConcept}.
	 * @param ctx the parse tree
	 */
	void enterAggregationConcept(PhraseCreatorParser.AggregationConceptContext ctx);
	/**
	 * Exit a parse tree produced by {@link PhraseCreatorParser#aggregationConcept}.
	 * @param ctx the parse tree
	 */
	void exitAggregationConcept(PhraseCreatorParser.AggregationConceptContext ctx);
	/**
	 * Enter a parse tree produced by {@link PhraseCreatorParser#aggregationConceptType}.
	 * @param ctx the parse tree
	 */
	void enterAggregationConceptType(PhraseCreatorParser.AggregationConceptTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PhraseCreatorParser#aggregationConceptType}.
	 * @param ctx the parse tree
	 */
	void exitAggregationConceptType(PhraseCreatorParser.AggregationConceptTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PhraseCreatorParser#phraseSpecifications}.
	 * @param ctx the parse tree
	 */
	void enterPhraseSpecifications(PhraseCreatorParser.PhraseSpecificationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PhraseCreatorParser#phraseSpecifications}.
	 * @param ctx the parse tree
	 */
	void exitPhraseSpecifications(PhraseCreatorParser.PhraseSpecificationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PhraseCreatorParser#phraseSpecification}.
	 * @param ctx the parse tree
	 */
	void enterPhraseSpecification(PhraseCreatorParser.PhraseSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PhraseCreatorParser#phraseSpecification}.
	 * @param ctx the parse tree
	 */
	void exitPhraseSpecification(PhraseCreatorParser.PhraseSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PhraseCreatorParser#features}.
	 * @param ctx the parse tree
	 */
	void enterFeatures(PhraseCreatorParser.FeaturesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PhraseCreatorParser#features}.
	 * @param ctx the parse tree
	 */
	void exitFeatures(PhraseCreatorParser.FeaturesContext ctx);
	/**
	 * Enter a parse tree produced by {@link PhraseCreatorParser#feature}.
	 * @param ctx the parse tree
	 */
	void enterFeature(PhraseCreatorParser.FeatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link PhraseCreatorParser#feature}.
	 * @param ctx the parse tree
	 */
	void exitFeature(PhraseCreatorParser.FeatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link PhraseCreatorParser#tense}.
	 * @param ctx the parse tree
	 */
	void enterTense(PhraseCreatorParser.TenseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PhraseCreatorParser#tense}.
	 * @param ctx the parse tree
	 */
	void exitTense(PhraseCreatorParser.TenseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PhraseCreatorParser#tenseValue}.
	 * @param ctx the parse tree
	 */
	void enterTenseValue(PhraseCreatorParser.TenseValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PhraseCreatorParser#tenseValue}.
	 * @param ctx the parse tree
	 */
	void exitTenseValue(PhraseCreatorParser.TenseValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link PhraseCreatorParser#complementiser}.
	 * @param ctx the parse tree
	 */
	void enterComplementiser(PhraseCreatorParser.ComplementiserContext ctx);
	/**
	 * Exit a parse tree produced by {@link PhraseCreatorParser#complementiser}.
	 * @param ctx the parse tree
	 */
	void exitComplementiser(PhraseCreatorParser.ComplementiserContext ctx);
	/**
	 * Enter a parse tree produced by {@link PhraseCreatorParser#complementiserValue}.
	 * @param ctx the parse tree
	 */
	void enterComplementiserValue(PhraseCreatorParser.ComplementiserValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PhraseCreatorParser#complementiserValue}.
	 * @param ctx the parse tree
	 */
	void exitComplementiserValue(PhraseCreatorParser.ComplementiserValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link PhraseCreatorParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void enterConjunction(PhraseCreatorParser.ConjunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PhraseCreatorParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void exitConjunction(PhraseCreatorParser.ConjunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PhraseCreatorParser#conjunctionValue}.
	 * @param ctx the parse tree
	 */
	void enterConjunctionValue(PhraseCreatorParser.ConjunctionValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PhraseCreatorParser#conjunctionValue}.
	 * @param ctx the parse tree
	 */
	void exitConjunctionValue(PhraseCreatorParser.ConjunctionValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link PhraseCreatorParser#subject}.
	 * @param ctx the parse tree
	 */
	void enterSubject(PhraseCreatorParser.SubjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link PhraseCreatorParser#subject}.
	 * @param ctx the parse tree
	 */
	void exitSubject(PhraseCreatorParser.SubjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link PhraseCreatorParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(PhraseCreatorParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link PhraseCreatorParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(PhraseCreatorParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link PhraseCreatorParser#assignments}.
	 * @param ctx the parse tree
	 */
	void enterAssignments(PhraseCreatorParser.AssignmentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PhraseCreatorParser#assignments}.
	 * @param ctx the parse tree
	 */
	void exitAssignments(PhraseCreatorParser.AssignmentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PhraseCreatorParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(PhraseCreatorParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PhraseCreatorParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(PhraseCreatorParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PhraseCreatorParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(PhraseCreatorParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PhraseCreatorParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(PhraseCreatorParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PhraseCreatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PhraseCreatorParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PhraseCreatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PhraseCreatorParser.ExpressionContext ctx);
}