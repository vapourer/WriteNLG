// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.constrain;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A BoundedWeightedConstraint for use with applicable constraint processors.
 * 
 * @param <E>
 */
public class BoundedWeightedConstraint<E> extends BoundedSoftConstraint<E>
{
	private static final Logger LOGGER = LogManager.getLogger("BoundedWeightedConstraint.class");

	/**
	 * Creates a BoundedWeightedConstraint instance.
	 * 
	 * @param constrainedElement
	 * @param satisfactionLevel
	 */
	public BoundedWeightedConstraint(final E constrainedElement, final SatisfactionLevel satisfactionLevel,
			final BigDecimal lowerBound, final BigDecimal upperBound)
	{
		super(constrainedElement, satisfactionLevel, lowerBound, upperBound);

		LOGGER.info(String.format("BoundedWeightedConstraint created (%s)", toString()));
	}

	/**
	 * @return the weighting for this constraint.
	 */
	public BigDecimal getWeighting()
	{
		return super.getSatisfactionLevel().getWeighting();
	}
}
