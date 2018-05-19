// Generated from Writer.g4 by ANTLR 4.7
package io.antlrgenerated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link WriterParser}.
 */
public interface WriterListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link WriterParser#writeDocument}.
	 * @param ctx the parse tree
	 */
	void enterWriteDocument(WriterParser.WriteDocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link WriterParser#writeDocument}.
	 * @param ctx the parse tree
	 */
	void exitWriteDocument(WriterParser.WriteDocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link WriterParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(WriterParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link WriterParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(WriterParser.DocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link WriterParser#section}.
	 * @param ctx the parse tree
	 */
	void enterSection(WriterParser.SectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link WriterParser#section}.
	 * @param ctx the parse tree
	 */
	void exitSection(WriterParser.SectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link WriterParser#paragraph}.
	 * @param ctx the parse tree
	 */
	void enterParagraph(WriterParser.ParagraphContext ctx);
	/**
	 * Exit a parse tree produced by {@link WriterParser#paragraph}.
	 * @param ctx the parse tree
	 */
	void exitParagraph(WriterParser.ParagraphContext ctx);
	/**
	 * Enter a parse tree produced by {@link WriterParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterSentence(WriterParser.SentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link WriterParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitSentence(WriterParser.SentenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link WriterParser#clause}.
	 * @param ctx the parse tree
	 */
	void enterClause(WriterParser.ClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link WriterParser#clause}.
	 * @param ctx the parse tree
	 */
	void exitClause(WriterParser.ClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link WriterParser#subclause}.
	 * @param ctx the parse tree
	 */
	void enterSubclause(WriterParser.SubclauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link WriterParser#subclause}.
	 * @param ctx the parse tree
	 */
	void exitSubclause(WriterParser.SubclauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link WriterParser#configuration}.
	 * @param ctx the parse tree
	 */
	void enterConfiguration(WriterParser.ConfigurationContext ctx);
	/**
	 * Exit a parse tree produced by {@link WriterParser#configuration}.
	 * @param ctx the parse tree
	 */
	void exitConfiguration(WriterParser.ConfigurationContext ctx);
	/**
	 * Enter a parse tree produced by {@link WriterParser#documentTitle}.
	 * @param ctx the parse tree
	 */
	void enterDocumentTitle(WriterParser.DocumentTitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link WriterParser#documentTitle}.
	 * @param ctx the parse tree
	 */
	void exitDocumentTitle(WriterParser.DocumentTitleContext ctx);
	/**
	 * Enter a parse tree produced by {@link WriterParser#documentTitleValue}.
	 * @param ctx the parse tree
	 */
	void enterDocumentTitleValue(WriterParser.DocumentTitleValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link WriterParser#documentTitleValue}.
	 * @param ctx the parse tree
	 */
	void exitDocumentTitleValue(WriterParser.DocumentTitleValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link WriterParser#sectionTitle}.
	 * @param ctx the parse tree
	 */
	void enterSectionTitle(WriterParser.SectionTitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link WriterParser#sectionTitle}.
	 * @param ctx the parse tree
	 */
	void exitSectionTitle(WriterParser.SectionTitleContext ctx);
	/**
	 * Enter a parse tree produced by {@link WriterParser#sectionTitleValue}.
	 * @param ctx the parse tree
	 */
	void enterSectionTitleValue(WriterParser.SectionTitleValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link WriterParser#sectionTitleValue}.
	 * @param ctx the parse tree
	 */
	void exitSectionTitleValue(WriterParser.SectionTitleValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link WriterParser#features}.
	 * @param ctx the parse tree
	 */
	void enterFeatures(WriterParser.FeaturesContext ctx);
	/**
	 * Exit a parse tree produced by {@link WriterParser#features}.
	 * @param ctx the parse tree
	 */
	void exitFeatures(WriterParser.FeaturesContext ctx);
	/**
	 * Enter a parse tree produced by {@link WriterParser#feature}.
	 * @param ctx the parse tree
	 */
	void enterFeature(WriterParser.FeatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link WriterParser#feature}.
	 * @param ctx the parse tree
	 */
	void exitFeature(WriterParser.FeatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link WriterParser#tense}.
	 * @param ctx the parse tree
	 */
	void enterTense(WriterParser.TenseContext ctx);
	/**
	 * Exit a parse tree produced by {@link WriterParser#tense}.
	 * @param ctx the parse tree
	 */
	void exitTense(WriterParser.TenseContext ctx);
	/**
	 * Enter a parse tree produced by {@link WriterParser#tenseValue}.
	 * @param ctx the parse tree
	 */
	void enterTenseValue(WriterParser.TenseValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link WriterParser#tenseValue}.
	 * @param ctx the parse tree
	 */
	void exitTenseValue(WriterParser.TenseValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link WriterParser#complementiser}.
	 * @param ctx the parse tree
	 */
	void enterComplementiser(WriterParser.ComplementiserContext ctx);
	/**
	 * Exit a parse tree produced by {@link WriterParser#complementiser}.
	 * @param ctx the parse tree
	 */
	void exitComplementiser(WriterParser.ComplementiserContext ctx);
	/**
	 * Enter a parse tree produced by {@link WriterParser#complementiserValue}.
	 * @param ctx the parse tree
	 */
	void enterComplementiserValue(WriterParser.ComplementiserValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link WriterParser#complementiserValue}.
	 * @param ctx the parse tree
	 */
	void exitComplementiserValue(WriterParser.ComplementiserValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link WriterParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void enterConjunction(WriterParser.ConjunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link WriterParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void exitConjunction(WriterParser.ConjunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link WriterParser#conjunctionValue}.
	 * @param ctx the parse tree
	 */
	void enterConjunctionValue(WriterParser.ConjunctionValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link WriterParser#conjunctionValue}.
	 * @param ctx the parse tree
	 */
	void exitConjunctionValue(WriterParser.ConjunctionValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link WriterParser#assignments}.
	 * @param ctx the parse tree
	 */
	void enterAssignments(WriterParser.AssignmentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link WriterParser#assignments}.
	 * @param ctx the parse tree
	 */
	void exitAssignments(WriterParser.AssignmentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link WriterParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(WriterParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link WriterParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(WriterParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link WriterParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(WriterParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link WriterParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(WriterParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link WriterParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(WriterParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link WriterParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(WriterParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link WriterParser#option}.
	 * @param ctx the parse tree
	 */
	void enterOption(WriterParser.OptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link WriterParser#option}.
	 * @param ctx the parse tree
	 */
	void exitOption(WriterParser.OptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link WriterParser#decimalPlaces}.
	 * @param ctx the parse tree
	 */
	void enterDecimalPlaces(WriterParser.DecimalPlacesContext ctx);
	/**
	 * Exit a parse tree produced by {@link WriterParser#decimalPlaces}.
	 * @param ctx the parse tree
	 */
	void exitDecimalPlaces(WriterParser.DecimalPlacesContext ctx);
	/**
	 * Enter a parse tree produced by {@link WriterParser#decimalPlacesValue}.
	 * @param ctx the parse tree
	 */
	void enterDecimalPlacesValue(WriterParser.DecimalPlacesValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link WriterParser#decimalPlacesValue}.
	 * @param ctx the parse tree
	 */
	void exitDecimalPlacesValue(WriterParser.DecimalPlacesValueContext ctx);
}