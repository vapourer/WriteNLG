package analysis.constrain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Container for a group of related hard constraints.
 *
 * @param <E>
 */
public class HardConstraintGroup<E> implements ConstraintGroup<E>
{
	private final Set<HardConstraint<E>> constraints;
	private final ConstraintProcessor processor;
	private BigDecimal value;

	/**
	 * Creates a HardConstraintGroup instance.
	 *
	 * @param processor
	 */
	public HardConstraintGroup(final ConstraintProcessor processor)
	{
		this.constraints = new HashSet<>();
		this.processor = processor;
		this.value = new BigDecimal("0");
	}

	/**
	 * @return a copy of the Set of HardConstraint instances.
	 */
	@Override
	public Set<? extends Constraint<E>> getConstraints()
	{
		return new HashSet<>(this.constraints);
	}

	/**
	 * Adds a constraint to the set of hard constraints.
	 *
	 * @param constraint
	 */
	@Override
	public void addConstraint(final Constraint<E> constraint)
	{
		if (constraint instanceof HardConstraint)
		{
			this.constraints.add((HardConstraint<E>) constraint);
			this.value = this.processor.evaluate(this.constraints);
		}
	}

	/**
	 * @return the value
	 */
	@Override
	public BigDecimal getValue()
	{
		return this.value;
	}
}
