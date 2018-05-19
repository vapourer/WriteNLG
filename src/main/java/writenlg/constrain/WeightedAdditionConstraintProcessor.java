// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.constrain;

import java.math.BigDecimal;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Evaluates a Set of soft constraints using weighted addition.
 */
public class WeightedAdditionConstraintProcessor extends ConstraintProcessor
{
	private static final Logger LOGGER = LogManager.getLogger("WeightedAdditionConstraintProcessor.class");

	/**
	 * @return SUM(satisfaction level * weighting) for constraints
	 */
	@Override
	public <E> BigDecimal evaluate(final Set<? extends Constraint<E>> constraints)
	{
		LOGGER.info("Evaluating soft constraints using weighted addition");

		BigDecimal value = new BigDecimal("0");

		for (final Constraint<E> constraint : constraints)
		{
			if (constraint instanceof SoftConstraint)
			{
				value = value.add(constraint.getSatisfactionLevelAsValue());
			}
			else
			{
				LOGGER.error(String.format("Not a soft constraint: %s", constraint.getConstrainedElement()));
				throw new IllegalArgumentException("This processor is for soft constraints only");
			}
		}

		LOGGER.info(
				String.format("Soft constraint count: %s; weighted values totalled: %s", constraints.size(), value));

		return value;
	}
}
