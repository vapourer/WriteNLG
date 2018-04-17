// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.constrain;

import java.math.BigDecimal;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SoftConstraintProcessor extends ConstraintProcessor
{
	private static final Logger LOGGER = LogManager.getLogger("SoftConstraintProcessor.class");

	@Override
	public <E> BigDecimal evaluate(final Set<? extends Constraint<E>> constraints)
	{
		LOGGER.info("Evaluating soft constraints");

		BigDecimal value = new BigDecimal("0");

		for (final Constraint<E> constraint : constraints)
		{
			if (constraint instanceof SoftConstraint)
			{
				value = value.add(constraint.getSatisfactionLevel());
			}
		}

		return value;
	}
}
