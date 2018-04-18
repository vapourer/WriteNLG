// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.constrain;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A bounded soft constraint, with definable inclusive limits.
 * 
 * @param <E>
 */
public class BoundedSoftConstraint<E> extends SoftConstraint<E>
{
	private static final Logger LOGGER = LogManager.getLogger("BoundedSoftConstraint.class");

	/**
	 * Creates a BoundedSoftConstraint instance.
	 *
	 * @param constrainedElement
	 * @param satisfactionLevel
	 */
	public BoundedSoftConstraint(final E constrainedElement, final SatisfactionLevel satisfactionLevel,
			final BigDecimal lowerBound, final BigDecimal upperBound)
	{
		super(constrainedElement, satisfactionLevel);

		if (satisfactionLevel.getLevel().compareTo(lowerBound) < 0
				|| satisfactionLevel.getLevel().compareTo(upperBound) > 0)
		{
			LOGGER.error(String.format("Satisfaction level outside zero to one bounds"));
			throw new IllegalArgumentException("Satisfaction level must be a value between " + lowerBound.toString()
					+ " and " + upperBound + " inclusive");
		}
	}
}
