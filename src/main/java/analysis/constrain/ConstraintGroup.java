// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.constrain;

import java.math.BigDecimal;
import java.util.Set;

/**
 * An implementing class serves as a container for a set of constraints.
 *
 * @param <E>
 */
public interface ConstraintGroup<E>
{
	Set<? extends Constraint<E>> getConstraints();

	void addConstraint(Constraint<E> constraint);

	BigDecimal getValue();
}
