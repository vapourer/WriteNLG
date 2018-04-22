// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.constrain;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Container for a property to be used as a constraint, together with its satisfaction level.
 */
public abstract class Constraint<E>
{
	private static final Logger LOGGER = LogManager.getLogger("Constraint.class");

	private final E constrainedElement;

	/**
	 * Returns the level * weighting of the SatisfactionLevel.
	 * 
	 * @return the weighted satisfaction level
	 */
	public abstract BigDecimal getSatisfactionLevelAsValue();

	public Constraint(final E constrainedElement)
	{
		LOGGER.info("Creating constraint");

		if (constrainedElement == null)
		{
			LOGGER.error(String.format("null constrainedElement"));
			throw new IllegalArgumentException("constrainedElement must not be null");
		}

		this.constrainedElement = constrainedElement;
	}

	/**
	 * @return the constrainedElement
	 */
	public E getConstrainedElement()
	{
		return this.constrainedElement;
	}

	@Override
	public String toString()
	{
		return "Constrained element = " + this.constrainedElement.toString();
	}
}
