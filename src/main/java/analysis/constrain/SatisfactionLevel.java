// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.constrain;

import java.math.BigDecimal;

/**
 * Represents the SatisfactionLevel element of a constraint. Weighting defaults to 1, but can be set for use in a
 * weighted constraint.
 */
public class SatisfactionLevel
{
	private final BigDecimal level;
	private final BigDecimal weighting;

	/**
	 * Creates a SatisfactionLevel instance with default weighting (1).
	 * 
	 * @param level
	 */
	public SatisfactionLevel(BigDecimal level)
	{
		this(level, new BigDecimal("1"));
	}

	/**
	 * Creates a SatisfactionLevel instance for use in a weighted constraint.
	 * 
	 * @param level
	 * @param weighting
	 */
	public SatisfactionLevel(BigDecimal level, BigDecimal weighting)
	{
		this.level = level;
		this.weighting = weighting;
	}

	/**
	 * @return the level
	 */
	public BigDecimal getLevel()
	{
		return level;
	}

	/**
	 * @return the weighting
	 */
	public BigDecimal getWeighting()
	{
		return weighting;
	}

	/**
	 * @param object
	 * @return string represents level and weighting
	 */
	@Override
	public String toString()
	{
		return String.format("level: %s * weighting: %s = %s", this.level, this.weighting,
				this.level.multiply(this.weighting));
	}
}
