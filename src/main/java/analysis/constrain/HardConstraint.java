// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.constrain;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Container for a hard constraint.
 * 
 * @param <E>
 */
public class HardConstraint<E> extends Constraint<E>
{
	private static final Logger LOGGER = LogManager.getLogger("HardConstraint.class");

	private final SatisfactionLevel satisfactionLevel;

	/**
	 * Creates a HardConstraint instance.
	 *
	 * @param constrainedElement
	 * @param satisfactionLevel
	 */
	public HardConstraint(final E constrainedElement, final SatisfactionLevel satisfactionLevel)
	{
		super(constrainedElement);

		if (satisfactionLevel == null || (satisfactionLevel.getWeightedLevel().compareTo(new BigDecimal("0")) != 0
				&& satisfactionLevel.getWeightedLevel().compareTo(new BigDecimal("1")) != 0))
		{
			LOGGER.error(String.format("Weighted satisfaction level was %s but must be 0 or 1", satisfactionLevel));
			throw new IllegalArgumentException("Weighted satisfaction level must be 0 or 1");
		}

		LOGGER.info(String.format("constrainedElement = %s, satisfactionLevel = %s", constrainedElement,
				satisfactionLevel));
		this.satisfactionLevel = satisfactionLevel;
	}

	/**
	 * @return the satisfactionLevel
	 */
	@Override
	public SatisfactionLevel getSatisfactionLevel()
	{
		return this.satisfactionLevel;
	}
}
