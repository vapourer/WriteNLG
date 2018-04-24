// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.statistics;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.graph.Point;
import analysis.graph.TimeSeries;

/**
 * Determines the Point where the maximum value of a TimeSeries occurs.
 */
public class Maximum
{
	private static final Logger LOGGER = LogManager.getLogger("Maximum.class");

	private final Long[] times;
	private final BigDecimal[] values;
	private final String title;

	/**
	 * Creates a Maximum instance.
	 * 
	 * @param timeSeries
	 */
	public Maximum(final TimeSeries timeSeries)
	{
		this.times = timeSeries.getSeries().keySet().toArray(new Long[0]);
		this.values = timeSeries.getSeries().values().toArray(new BigDecimal[0]);
		this.title = timeSeries.getSeriesLegend();
	}

	/**
	 * Determines the maximum value of a time series and returns the Point at which it occurs.
	 * 
	 * @return Point of maximum value
	 */
	public Point calculate()
	{
		LOGGER.info("Calculating maximum for " + this.title);

		Point pointWithMaximumValue = new Point(new BigDecimal(0), this.values[0], this.times[0]);

		for (int i = 1; i < this.times.length; i++)
		{
			if (this.values[i].compareTo(pointWithMaximumValue.getY()) > 0)
			{
				pointWithMaximumValue = new Point(new BigDecimal(i), this.values[i], this.times[i]);
			}
		}

		LOGGER.info(String.format("Maximum for %s calculated (%s)", this.title, pointWithMaximumValue));

		return pointWithMaximumValue;
	}
}
