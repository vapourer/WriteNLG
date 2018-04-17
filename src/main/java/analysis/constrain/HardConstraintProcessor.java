// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.constrain;

import java.math.BigDecimal;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HardConstraintProcessor extends ConstraintProcessor
{
	private static final Logger LOGGER = LogManager.getLogger("HardConstraintProcessor.class");

	@Override
	public <E> BigDecimal evaluate(final Set<? extends Constraint<E>> constraints)
	{
		LOGGER.info("Evaluating hard constraints");

		BigDecimal value = new BigDecimal("0");
		BigDecimal minValue = new BigDecimal("1");

		for (final Constraint<E> constraint : constraints)
		{
			if (constraint instanceof HardConstraint)
			{
				final HardConstraint<E> hardConstraint = (HardConstraint<E>) constraint;
				final BigDecimal newValue = hardConstraint.getSatisfactionLevel();

				if (newValue.compareTo(minValue) < 0)
				{
					minValue = newValue;
				}

				value = value.add(newValue);
			}
			else
			{
				LOGGER.error(String.format("Not a hard constraint: %s", constraint.getConstrainedElement()));
				throw new IllegalArgumentException("This processor is for  hard constraints only");
			}
		}

		BigDecimal returnValue = value.multiply(minValue);

		LOGGER.info(String.format("Hard constraint count: %s; total: %s; minimum value: %s; return value: %s",
				constraints.size(), value, minValue, returnValue));

		return returnValue;
	}
}
