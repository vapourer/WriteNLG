// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.constrain;

import java.math.BigDecimal;

/**
 * Container for a value and weighting, input data for an associated constraint.
 */
public class ConstraintConfiguration
{
	private final BigDecimal value;
	private final BigDecimal weighting;

	/**
	 * Creates a new ConstraintConfiguration instance.
	 * 
	 * @param value
	 * @param weighting
	 */
	public ConstraintConfiguration(final BigDecimal value, final BigDecimal weighting)
	{
		this.value = value;
		this.weighting = weighting;
	}

	/**
	 * @return the value
	 */
	public BigDecimal getValue()
	{
		return value;
	}

	/**
	 * @return the weighting
	 */
	public BigDecimal getWeighting()
	{
		return weighting;
	}

	@Override
	public String toString()
	{
		return String.format("%s (%s)", this.value, this.weighting);
	}
}
