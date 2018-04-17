// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.constrain;

import java.math.BigDecimal;

/**
 * A WeightedConstraint for use with applicable constraint processorsh.
 * 
 * @param <E>
 */
public class WeightedConstraint<E> extends Constraint<E>
{
	/**
	 * Creates a WeightedConstraint instance.
	 * 
	 * @param constrainedElement
	 */
	public WeightedConstraint(E constrainedElement)
	{
		super(constrainedElement);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BigDecimal getSatisfactionLevel()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
