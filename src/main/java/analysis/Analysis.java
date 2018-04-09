// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis;

import java.math.BigDecimal;
import java.util.List;

import analysis.graph.Segment;

public class Analysis
{
	private final double maximum;
	private final double minimum;
	private final double mean;
	private BigDecimal maximumAsBigDecimal;
	private BigDecimal minimumAsBigDecimal;
	private BigDecimal meanAsBigDecimal;
	private final List<Segment> segments;

	public Analysis(final double maximum, final double minimum, final double mean, final List<Segment> segments)
	{
		this.maximum = maximum;
		this.minimum = minimum;
		this.mean = mean;
		this.segments = segments;
	}

	/**
	 * @return the maximum
	 */
	public double getMaximum()
	{
		return this.maximum;
	}

	/**
	 * @return the maximumAsBigDecimal
	 */
	public BigDecimal getMaximumAsBigDecimal()
	{
		if (this.maximumAsBigDecimal == null)
		{
			this.maximumAsBigDecimal = new BigDecimal(this.maximum);
		}

		return this.maximumAsBigDecimal;
	}

	/**
	 * @return the minimum
	 */
	public double getMinimum()
	{
		return this.minimum;
	}

	/**
	 * @return the minimumAsBigDecimal
	 */
	public BigDecimal getMinimumAsBigDecimal()
	{
		if (this.minimumAsBigDecimal == null)
		{
			this.minimumAsBigDecimal = new BigDecimal(this.minimum);
		}

		return this.minimumAsBigDecimal;
	}

	/**
	 * @return the mean
	 */
	public double getMean()
	{
		return this.mean;
	}

	/**
	 * @return the meanAsBigDecimal
	 */
	public BigDecimal getMeanAsBigDecimal()
	{
		if (this.meanAsBigDecimal == null)
		{
			this.meanAsBigDecimal = new BigDecimal(this.mean);
		}

		return this.meanAsBigDecimal;
	}

	/**
	 * @return the segments
	 */
	public List<Segment> getSegments()
	{
		return segments;
	}
}
