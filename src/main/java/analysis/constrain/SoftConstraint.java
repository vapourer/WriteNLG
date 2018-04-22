// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.constrain;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Representation of a soft constraint.
 * 
 * @param <E>
 */
public class SoftConstraint<E> extends Constraint<E>
{
	private static final Logger LOGGER = LogManager.getLogger("SoftConstraint.class");

	private final SatisfactionLevel satisfactionLevel;

	/**
	 * Creates a SoftConstraint instance.
	 *
	 * @param constrainedElement
	 * @param satisfactionLevel
	 */
	public SoftConstraint(final E constrainedElement, final SatisfactionLevel satisfactionLevel)
	{
		super(constrainedElement);

		if (satisfactionLevel == null)
		{
			LOGGER.error(String.format("null satisfactionLevel"));
			throw new IllegalArgumentException("satisfactionLevel must not be null");
		}

		this.satisfactionLevel = satisfactionLevel;
		LOGGER.info(toString());
	}

	/**
	 * @return the weighted satisfaction level
	 */
	@Override
	public BigDecimal getSatisfactionLevelAsValue()
	{
		return this.satisfactionLevel.getWeightedLevel();
	}

	@Override
	public String toString()
	{
		return String.format("%s, satisfactionLevel = %s", super.toString(), this.satisfactionLevel);
	}

	/**
	 * @return the satisfactionLevel
	 */
	protected SatisfactionLevel getSatisfactionLevel()
	{
		return this.satisfactionLevel;
	}
}
