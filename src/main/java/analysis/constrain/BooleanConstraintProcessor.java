// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.constrain;

import java.math.BigDecimal;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Returns 1 if all constraints have satisfactionLevel = 1; otherwise returns 0
 */
public class BooleanConstraintProcessor extends ConstraintProcessor
{
	private static final Logger LOGGER = LogManager.getLogger("BooleanConstraintProcessor.class");

	/**
	 * Evaluates submitted hard constraints as booleans.
	 */
	@Override
	public <E> BigDecimal evaluate(Set<? extends Constraint<E>> constraints)
	{
		LOGGER.info("Evaluating hard constraints as booleans");

		BigDecimal value = new BigDecimal("1");

		for (final Constraint<E> constraint : constraints)
		{
			if (constraint instanceof HardConstraint)
			{
				value = value.multiply(constraint.getSatisfactionLevel().getLevel());
			}
			else
			{
				LOGGER.error(String.format("Not a hard constraint: %s", constraint.getConstrainedElement()));
				throw new IllegalArgumentException("This processor is for hard constraints only");
			}
		}

		LOGGER.info(String.format("Boolean constraints evaluate to %s", value));

		return value;
	}
}
