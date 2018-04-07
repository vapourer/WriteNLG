package analysis.constrain;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Set;

public class MeanBasedSoftConstraintProcessor extends ConstraintProcessor
{
	private final MathContext context;

	public MeanBasedSoftConstraintProcessor(final String mathContext)
	{
		this.context = new MathContext(mathContext);
	}

	@Override
	public <E> BigDecimal evaluate(final Set<? extends Constraint<E>> constraints)
	{
		final BigDecimal elementCount = new BigDecimal(constraints.size());
		BigDecimal value = new BigDecimal("0");

		for (final Constraint<E> constraint : constraints)
		{
			if (constraint instanceof SoftConstraint)
			{
				value = value.add(constraint.getSatisfactionLevel());
			}
		}

		return value.divide(elementCount, this.context);
	}
}
