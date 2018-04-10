// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.constrain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Container for a group of related hard constraints.
 *
 * @param <E>
 */
public class HardConstraintGroup<E> implements ConstraintGroup<E>
{
	private static final Logger LOGGER = LogManager.getLogger("HardConstraintGroup.class");

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

		LOGGER.info("HardConstraintGroup created, using " + processor.getClass());
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

			LOGGER.info(String.format("Constraint added: constrainedElement = %s, satisfactionLevel = %s.",
					constraint.getConstrainedElement().toString(), constraint.getSatisfactionLevel().toString()));
		}
		else
		{
			LOGGER.error(String.format("HardConstraint expected, %s received. Constraint not added.",
					constraint.getClass()));

			throw new IllegalArgumentException("HardConstraint expected");
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
