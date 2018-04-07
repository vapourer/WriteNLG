package analysis.constrain;

import java.math.BigDecimal;
import java.util.Set;

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
