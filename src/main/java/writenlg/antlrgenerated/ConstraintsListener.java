// Generated from Constraints.g4 by ANTLR 4.7
package writenlg.antlrgenerated;
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
	 * Enter a parse tree produced by {@link ConstraintsParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(ConstraintsParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintsParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(ConstraintsParser.ValueContext ctx);
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