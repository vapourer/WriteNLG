// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.constrain;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import writenlg.antlrgenerated.ConstraintsBaseListener;
import writenlg.antlrgenerated.ConstraintsParser;

/**
 * ConstraintsBaseListener overrides specific to Constraints.
 */
public class ConstraintsListener extends ConstraintsBaseListener
{
	private static final Logger LOGGER = LogManager.getLogger("ConstraintsListener.class");

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
		LOGGER.info("exitConstraint");
		final String constraintName = context.constraintName().getText();
		final BigDecimal value = new BigDecimal(context.value().getText());
		// final BigDecimal weighting = context.weighting() == null ? new BigDecimal("1")
		// : new BigDecimal(context.weighting().getText());

		final BigDecimal weighting = new BigDecimal("1");

		Constraints.getInstance().addConstraint(constraintName, value, weighting);
		LOGGER.info(String.format("Constraint configuration loaded for %s: %s", constraintName,
				Constraints.getInstance().getConfiguration(constraintName)));
	}

	@Override
	public void enterConcept(ConstraintsParser.ConceptContext ctx)
	{
		LOGGER.info("enterConcept");
	}

	@Override
	public void exitConcept(ConstraintsParser.ConceptContext context)
	{
		LOGGER.info("exitConcept");
	}
}
