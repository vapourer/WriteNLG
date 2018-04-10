// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.constrain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SoftConstraintGroup<E> implements ConstraintGroup<E>
{
	private static final Logger LOGGER = LogManager.getLogger("SoftConstraintGroup.class");

	private final Set<SoftConstraint<E>> constraints;
	private final ConstraintProcessor processor;
	private BigDecimal value;

	public SoftConstraintGroup(final ConstraintProcessor processor)
	{
		this.constraints = new HashSet<>();
		this.processor = processor;
		this.value = new BigDecimal("0");

		LOGGER.info("SoftConstraintGroup created, using " + processor.getClass());
	}

	@Override
	public Set<? extends Constraint<E>> getConstraints()
	{
		return new HashSet<>(this.constraints);
	}

	/**
	 * Adds a constraint to the set of soft constraints.
	 *
	 * @param constraint
	 */
	@Override
	public void addConstraint(final Constraint<E> constraint)
	{
		if (constraint instanceof SoftConstraint)
		{
			this.constraints.add((SoftConstraint<E>) constraint);
			this.value = this.processor.evaluate(this.constraints);

			LOGGER.info(String.format("Constraint added: constrainedElement = %s, satisfactionLevel = %s.",
					constraint.getConstrainedElement().toString(), constraint.getSatisfactionLevel().toString()));
		}
		else
		{
			LOGGER.error(String.format("SoftConstraint expected, %s received. Constraint not added.",
					constraint.getClass()));

			throw new IllegalArgumentException("SoftConstraint expected");
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
