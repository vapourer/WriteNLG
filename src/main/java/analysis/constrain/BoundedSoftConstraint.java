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
	private static final Logger LOGGER = LogManager.getLogger("SoftConstraint.class");

	/**
	 * Creates a SoftConstraint instance.
	 *
	 * @param constrainedElement
	 * @param satisfactionLevel
	 */
	public BoundedSoftConstraint(final E constrainedElement, final BigDecimal satisfactionLevel,
			final BigDecimal lowerBound, final BigDecimal upperBound)
	{
		super(constrainedElement, satisfactionLevel);

		if (satisfactionLevel.compareTo(lowerBound) < 0 || satisfactionLevel.compareTo(upperBound) > 0)
		{
			LOGGER.error(String.format("satisfactionLevel outside zero to one bounds"));
			throw new IllegalArgumentException("satisfactionLevel must be a value between " + lowerBound.toString()
					+ " and " + upperBound + " inclusive");
		}
	}
}
