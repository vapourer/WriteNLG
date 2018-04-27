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

	private final BigDecimal lowerBound;
	private final BigDecimal upperBound;

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

		this.lowerBound = lowerBound;
		this.upperBound = upperBound;

		if (satisfactionLevel.getLevel().compareTo(this.lowerBound) < 0
				|| satisfactionLevel.getLevel().compareTo(this.upperBound) > 0)
		{
			LOGGER.error(String.format("Satisfaction level not within bounds"));

			throw new IllegalArgumentException(
					String.format("Satisfaction level must be a value between %s and %s inclusive", this.lowerBound,
							this.upperBound));
		}

		LOGGER.info(toString());
	}

	@Override
	public String toString()
	{
		return String.format("%s, lower bound: %s, upper bound %s", super.toString(), this.lowerBound, this.upperBound);
	}
}
