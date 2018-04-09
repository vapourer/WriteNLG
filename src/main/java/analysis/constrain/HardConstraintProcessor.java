// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.constrain;

import java.math.BigDecimal;
import java.util.Set;

public class HardConstraintProcessor extends ConstraintProcessor
{
	@Override
	public <E> BigDecimal evaluate(final Set<? extends Constraint<E>> constraints)
	{
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
		}

		return value.multiply(minValue);
	}
}
