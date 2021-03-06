// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.constrain;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.utilities.GlobalConstants;
import control.WriteNlgProperties;

/**
 * Calculates the weighted average of a Set of constraints.
 */
public class WeightedAverageConstraintProcessor extends ConstraintProcessor
{
	private static final Logger LOGGER = LogManager.getLogger("WeightedAverageConstraintProcessor.class");

	/**
	 * @return SUM(satisfaction level * weighting) / SUM(weighting) for constraints
	 */
	@Override
	public <E> BigDecimal evaluate(Set<? extends Constraint<E>> constraints)
	{
		LOGGER.info("Evaluating weighted constraints by calculating a weighted mean average");

		BigDecimal totalledValues = GlobalConstants.ZERO;
		BigDecimal totalledWeightings = GlobalConstants.ZERO;

		for (final Constraint<E> constraint : constraints)
		{
			if (constraint instanceof BoundedWeightedConstraint)
			{
				totalledValues = totalledValues.add(constraint.getSatisfactionLevelAsValue());
				totalledWeightings = totalledWeightings.add(((BoundedWeightedConstraint<E>) constraint).getWeighting());
			}
			else
			{
				LOGGER.error(String.format("Not a BoundedWeightedConstraint: %s", constraint.getConstrainedElement()));
				throw new IllegalArgumentException("This processor is for weighted constraints only");
			}
		}

		MathContext mathContext = new MathContext(WriteNlgProperties.getInstance().getProperty("MathContext"));
		BigDecimal weightedAverage = totalledValues.divide(totalledWeightings, mathContext);

		LOGGER.info(String.format(
				"Weighted constraint count: %s; weighted values totalled: %s; weightings totalled: %s; weighted average: %s",
				constraints.size(), totalledValues, totalledWeightings, weightedAverage));

		return weightedAverage;
	}
}
