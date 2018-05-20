// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.aggregation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import analysis.linguistics.aggregation.AggregationConstraintType;
import writenlg.AbstractConcept;
import writenlg.constrain.ConstraintGroup;

/**
 * A conceptGroup of Concept instances, to be evaluated as part of the aggregation process.
 */
public class ConceptGroup
{
	private final List<AbstractConcept> group;
	private final ConstraintGroup<AggregationConstraintType> constraintGroup;

	/**
	 * Creates a new ConceptGroup instance.
	 */
	public ConceptGroup(final ConstraintGroup<AggregationConstraintType> constraintGroup)
	{
		this.constraintGroup = constraintGroup;
		this.group = new ArrayList<>();
	}

	/**
	 * @return the group
	 */
	public List<AbstractConcept> getGroup()
	{
		return this.group;
	}

	/**
	 * @return the constraintGroup
	 */
	public ConstraintGroup<AggregationConstraintType> getConstraintGroup()
	{
		return constraintGroup;
	}

	/**
	 * Calculates the overall satisfaction level for this ConceptGroup.
	 *
	 * @return BigDecimal
	 */
	public BigDecimal calculateSatisfactionLevel()
	{
		return this.constraintGroup.evaluate();
	}
}
