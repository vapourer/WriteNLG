// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.constrain;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Base class for a constraint processor.
 */
public abstract class ConstraintProcessor
{
	/**
	 * Calculates the total constraint value.
	 *
	 * @param constraints
	 * @return BigDecimal
	 */
	public abstract <E> BigDecimal evaluate(final Set<? extends Constraint<E>> constraints);
}
