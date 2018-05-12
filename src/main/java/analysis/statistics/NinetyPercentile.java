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
 * Identifies smoothed points in the 0.9 centile.
 */
public class NinetyPercentile
{
	private static final Logger LOGGER = LogManager.getLogger("UpperTurningPointsSmoothed.class");

	private final TimeSeriesWithDerivedInformation timeSeries;

	/**
	 * Creates a new NinetyPercentile instance.
	 * 
	 * @param timeSeriesWithDerivedInformation
	 */
	public NinetyPercentile(final TimeSeriesWithDerivedInformation timeSeriesWithDerivedInformation)
	{
		this.timeSeries = timeSeriesWithDerivedInformation;
	}

	/**
	 * @return a Point array representing points in the 0.9 centile.
	 */
	public Point[] identify()
	{
		int ninetyPercentileSize = this.timeSeries.getSeries().size() / 10;
		LOGGER.info(String.format("Ninety percentile size: %d", ninetyPercentileSize));

		Point[] ninetyPercentileGroup = new Point[ninetyPercentileSize];

		final AbstractQueue<Point> queue = new PriorityQueue<>(new PointYValueInverseComparator());

		for (Point eachPoint : this.timeSeries.getPoints())
		{
			queue.add(eachPoint);
		}

		for (int i = 0; i < ninetyPercentileSize; i++)
		{
			ninetyPercentileGroup[i] = queue.poll();
			LOGGER.info(String.format("%s is in ninety percentile group", ninetyPercentileGroup[i]));
		}

		return ninetyPercentileGroup;
	}
}
