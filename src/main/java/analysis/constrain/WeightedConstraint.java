// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.constrain;

/**
 * A WeightedConstraint for use with applicable constraint processors.
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
	public SatisfactionLevel getSatisfactionLevel()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
