// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.constrain;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SoftConstraint<E> extends Constraint<E>
{
	private static final Logger LOGGER = LogManager.getLogger("SoftConstraint.class");

	private final BigDecimal satisfactionLevel;

	/**
	 * Creates a SoftConstraint instance.
	 *
	 * @param constrainedElement
	 * @param satisfactionLevel
	 */
	public SoftConstraint(final E constrainedElement, final BigDecimal satisfactionLevel)
	{
		super(constrainedElement);

		if (satisfactionLevel == null)
		{
			LOGGER.error(String.format("null satisfactionLevel"));
			throw new IllegalArgumentException("satisfactionLevel must not be null");
		}

		LOGGER.info(String.format("constrainedElement = %s\tsatisfactionLevel = %s", constrainedElement,
				satisfactionLevel));
		this.satisfactionLevel = satisfactionLevel;
	}

	/**
	 * @return the satisfactionLevel
	 */
	@Override
	public BigDecimal getSatisfactionLevel()
	{
		return this.satisfactionLevel;
	}
}
