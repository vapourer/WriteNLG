// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.constrain;

import java.math.BigDecimal;
import java.util.Set;

/**
 * An implementing class serves as a container for a set of constraints.
 *
 * @param <E>
 */
public interface ConstraintGroup<E>
{
	/**
	 * @return this set of constraints.
	 */
	Set<? extends Constraint<E>> getConstraints();

	/**
	 * Add constraint to this ConstraintGroup.
	 * 
	 * @param constraint
	 */
	void addConstraint(Constraint<E> constraint);

	/**
	 * @return the value of this ConstraintGroup.
	 */
	BigDecimal evaluate();
}
