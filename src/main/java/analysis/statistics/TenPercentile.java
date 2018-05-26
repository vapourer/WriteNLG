// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.statistics;

import java.util.AbstractQueue;
import java.util.PriorityQueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.TimeSeriesWithDerivedInformation;
import analysis.graph.Point;

/**
 * Identifies smoothed points in the 0.1 centile.
 */
public class TenPercentile
{
	private static final Logger LOGGER = LogManager.getLogger("UpperTurningPointsNinetyPercentile.class");

	private final TimeSeriesWithDerivedInformation timeSeries;

	/**
	 * Creates a TenPercentile instance.
	 * 
	 * @param timeSeriesWithDerivedInformation
	 */
	public TenPercentile(final TimeSeriesWithDerivedInformation timeSeriesWithDerivedInformation)
	{
		this.timeSeries = timeSeriesWithDerivedInformation;
	}

	/**
	 * @return a Point array representing points in the 0.9 centile.
	 */
	public Point[] identify()
	{
		int tenPercentileSize = this.timeSeries.getSeries().size() / 10;
		LOGGER.info(String.format("Ten percentile size: %d", tenPercentileSize));

		Point[] tenPercentileGroup = new Point[tenPercentileSize];

		final AbstractQueue<Point> queue = new PriorityQueue<>(new PointYValueComparator());

		for (Point eachPoint : this.timeSeries.getPoints())
		{
			queue.add(eachPoint);
		}

		for (int i = 0; i < tenPercentileSize; i++)
		{
			tenPercentileGroup[i] = queue.poll();
			LOGGER.info(String.format("%s is in ten percentile group", tenPercentileGroup[i]));
		}

		return tenPercentileGroup;
	}
}
