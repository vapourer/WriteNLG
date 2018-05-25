// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.constrain;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.utilities.GlobalConstants;

/**
 * Represents the SatisfactionLevel element of a constraint. Weighting defaults to 1, but can be set for use in a
 * weighted constraint.
 */
public class SatisfactionLevel
{
	private static final Logger LOGGER = LogManager.getLogger("SatisfactionLevel.class");

	private final BigDecimal level;
	private final BigDecimal weighting;
	private final BigDecimal weightedLevel;

	/**
	 * Creates a SatisfactionLevel instance with default weighting (1).
	 * 
	 * @param level
	 */
	public SatisfactionLevel(BigDecimal level)
	{
		this(level, GlobalConstants.ONE);
		LOGGER.info("Default weighting");
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
		this.weightedLevel = this.level.multiply(this.weighting);

		LOGGER.info("New satisfaction level (" + toString() + ")");
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
	 * @return the weightedLevel
	 */
	public BigDecimal getWeightedLevel()
	{
		return weightedLevel;
	}

	/**
	 * @param object
	 * @return string represents level and weighting
	 */
	@Override
	public String toString()
	{
		return String.format("level: %s, weighting: %s, weightedLevel: %s", this.level, this.weighting,
				this.weightedLevel);
	}
}
