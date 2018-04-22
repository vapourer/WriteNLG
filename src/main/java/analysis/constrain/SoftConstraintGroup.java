// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.constrain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Container for a group of related soft constraints.
 * 
 * @param <E>
 */
public class SoftConstraintGroup<E> implements ConstraintGroup<E>
{
	private static final Logger LOGGER = LogManager.getLogger("SoftConstraintGroup.class");

	private final Set<SoftConstraint<E>> constraints;
	private final ConstraintProcessor processor;

	/**
	 * Creates a SoftConstraintGroup instance.
	 * 
	 * @param processor
	 */
	public SoftConstraintGroup(final ConstraintProcessor processor)
	{
		this.constraints = new HashSet<>();
		this.processor = processor;

		LOGGER.info("SoftConstraintGroup created, using " + processor.getClass());
	}

	/**
	 * @return a copy of this Set of SoftConstraint instances.
	 */
	@Override
	public Set<? extends Constraint<E>> getConstraints()
	{
		return new HashSet<>(this.constraints);
	}

	/**
	 * Adds a constraint to this set of soft constraints.
	 *
	 * @param constraint
	 */
	@Override
	public void addConstraint(final Constraint<E> constraint)
	{
		if (constraint instanceof SoftConstraint)
		{
			this.constraints.add((SoftConstraint<E>) constraint);

			LOGGER.info(String.format("Soft constraint added (%s).", constraint));
		}
		else
		{
			LOGGER.error(String.format("SoftConstraint expected, %s received. Constraint not added.",
					constraint.getClass()));

			throw new IllegalArgumentException("SoftConstraint expected");
		}
	}

	/**
	 * @return the value of this SoftConstraintGroup.
	 */
	@Override
	public BigDecimal evaluate()
	{
		return this.processor.evaluate(this.constraints);
	}
}
