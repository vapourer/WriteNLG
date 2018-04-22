// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.constrain;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A WeightedConstraint for use with applicable constraint processors.
 * 
 * @param <E>
 */
public class WeightedConstraint<E> extends SoftConstraint<E>
{
	private static final Logger LOGGER = LogManager.getLogger("WeightedConstraint.class");

	/**
	 * Creates a WeightedConstraint instance.
	 * 
	 * @param constrainedElement
	 * @param satisfactionLevel
	 */
	public WeightedConstraint(final E constrainedElement, final SatisfactionLevel satisfactionLevel)
	{
		super(constrainedElement, satisfactionLevel);

		LOGGER.info(String.format("WeightedConstraint created (%s)", toString()));
	}

	/**
	 * @return the weighting for this constraint.
	 */
	public BigDecimal getWeighting()
	{
		return super.getSatisfactionLevel().getWeighting();
	}
}
