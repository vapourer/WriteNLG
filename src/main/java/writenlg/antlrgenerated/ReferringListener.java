// Generated from Referring.g4 by ANTLR 4.7
package writenlg.antlrgenerated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ReferringParser}.
 */
public interface ReferringListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ReferringParser#referringExpression}.
	 * @param ctx the parse tree
	 */
	void enterReferringExpression(ReferringParser.ReferringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReferringParser#referringExpression}.
	 * @param ctx the parse tree
	 */
	void exitReferringExpression(ReferringParser.ReferringExpressionContext ctx);
}