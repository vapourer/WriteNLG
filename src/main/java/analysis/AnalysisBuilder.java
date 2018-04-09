// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis;

import java.util.List;

import analysis.graph.Segment;

/**
 * Builder for the Analysis class.
 */
public class AnalysisBuilder
{
	private double maximum;
	private double minimum;
	private double mean;
	private List<Segment> segments;

	/**
	 * Creates a new Analysis instance.
	 *
	 * @return Analysis
	 */
	public Analysis createAnalysis()
	{
		return new Analysis(this.maximum, this.minimum, this.mean, this.segments);
	}

	/**
	 * @return the maximum
	 */
	public double getMaximum()
	{
		return this.maximum;
	}

	/**
	 * @param maximum
	 *            the maximum to set
	 */
	public void setMaximum(final double maximum)
	{
		this.maximum = maximum;
	}

	/**
	 * @return the minimum
	 */
	public double getMinimum()
	{
		return this.minimum;
	}

	/**
	 * @param minimum
	 *            the minimum to set
	 */
	public void setMinimum(final double minimum)
	{
		this.minimum = minimum;
	}

	/**
	 * @return the mean
	 */
	public double getMean()
	{
		return this.mean;
	}

	/**
	 * @param mean
	 *            the mean to set
	 */
	public void setMean(final double mean)
	{
		this.mean = mean;
	}

	/**
	 * @return the segments
	 */
	public List<Segment> getSegments()
	{
		return this.segments;
	}

	/**
	 * @param segments
	 *            the segments to set
	 */
	public void setSegments(final List<Segment> segments)
	{
		this.segments = segments;
	}
}
