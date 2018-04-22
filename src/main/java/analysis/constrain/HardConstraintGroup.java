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

	/**
	 * Creates a HardConstraintGroup instance.
	 *
	 * @param processor
	 */
	public HardConstraintGroup(final ConstraintProcessor processor)
	{
		this.constraints = new HashSet<>();
		this.processor = processor;

		LOGGER.info("HardConstraintGroup created, using " + processor.getClass());
	}

	/**
	 * @return a copy of this Set of HardConstraint instances.
	 */
	@Override
	public Set<? extends Constraint<E>> getConstraints()
	{
		return new HashSet<>(this.constraints);
	}

	/**
	 * Adds a constraint to this set of hard constraints.
	 *
	 * @param constraint
	 */
	@Override
	public void addConstraint(final Constraint<E> constraint)
	{
		if (constraint instanceof HardConstraint)
		{
			this.constraints.add((HardConstraint<E>) constraint);

			LOGGER.info(String.format("Hard constraint added (%s).", constraint));
		}
		else
		{
			LOGGER.error(String.format("HardConstraint expected, %s received. Constraint not added.",
					constraint.getClass()));

			throw new IllegalArgumentException("HardConstraint expected");
		}
	}

	/**
	 * @return the value of this HardConstraintGroup.
	 */
	@Override
	public BigDecimal evaluate()
	{
		return this.processor.evaluate(this.constraints);
	}
}
