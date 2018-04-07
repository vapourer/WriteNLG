package analysis.constrain;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Container for a set of constraints.
 *
 * @param <E>
 */
public interface ConstraintGroup<E>
{
	Set<? extends Constraint<E>> getConstraints();

	void addConstraint(Constraint<E> constraint);

	BigDecimal getValue();
}
