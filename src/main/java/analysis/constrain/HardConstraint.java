package analysis.constrain;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HardConstraint<E> extends Constraint<E>
{
	private static final Logger LOGGER = LogManager.getLogger("HardConstraint.class");

	private final BigDecimal satisfactionLevel;

	/**
	 * Creates a HardConstraint instance.
	 *
	 * @param constrainedElement
	 * @param satisfactionLevel
	 */
	public HardConstraint(final E constrainedElement, final BigDecimal satisfactionLevel)
	{
		super(constrainedElement);

		if (satisfactionLevel == null || (satisfactionLevel.compareTo(new BigDecimal("0")) != 0
				&& satisfactionLevel.compareTo(new BigDecimal("1")) != 0))
		{
			LOGGER.error(String.format("satisfactionLevel was %s but must be 0 or 1", satisfactionLevel));
			throw new IllegalArgumentException("satisfactionLevel must be 0 or 1");
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
