// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.statistics;

import java.math.BigDecimal;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.TimeSeriesWithDerivedInformation;
import analysis.graph.Point;
import analysis.graph.Segment;
import analysis.graph.Slope;

/**
 * Identifies upper turning points above the 0.9 centile of a time series after smoothing.
 */
public class UpperTurningPointsSmoothed
{
	private static final Logger LOGGER = LogManager.getLogger("UpperTurningPointsSmoothed.class");

	private final TimeSeriesWithDerivedInformation timeSeries;

	/**
	 * Creates an UpperTurningPointsSmoothed instance.
	 * 
	 * @param timeSeriesWithDerivedInformation
	 */
	public UpperTurningPointsSmoothed(final TimeSeriesWithDerivedInformation timeSeriesWithDerivedInformation)
	{
		this.timeSeries = timeSeriesWithDerivedInformation;
	}

	public List<Point> identify()
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

		BigDecimal ninetyPercentileThreshold = null;

		for (int i = ninetyPercentileSize - 1; i >= 0; i--)
		{
			if (ninetyPercentileGroup[i] != null)
			{
				ninetyPercentileThreshold = ninetyPercentileGroup[i].getY();
				break;
			}
		}

		LOGGER.info(String.format("Ninety percentile threshold: %s", ninetyPercentileThreshold));

		List<Point> ninetyPercentileSmoothed = new ArrayList<>();

		for (Point eachPoint : this.timeSeries.getSmoothedPoints())
		{
			LOGGER.info(String.format("Smoothed point: %s", eachPoint));

			if (eachPoint.getY().compareTo(ninetyPercentileThreshold) >= 0 && isTurningPoint(eachPoint))
			{
				ninetyPercentileSmoothed.add(eachPoint);
				LOGGER.info(String.format("Upper turning point identified in ninety percentile - %s", eachPoint));
			}
		}

		return ninetyPercentileSmoothed;
	}

	private boolean isTurningPoint(final Point point)
	{
		boolean turningPoint = false;

		Segment beforeSegment = null;
		Segment afterSegment = null;

		final List<Segment> smoothedSegments = this.timeSeries.getSmoothedSegments();

		for (Segment eachSmoothedSegment : smoothedSegments)
		{
			if (point.getX().compareTo(eachSmoothedSegment.getPoint2().getX()) == 0)
			{
				beforeSegment = eachSmoothedSegment;
				LOGGER.info(String.format("beforePoint found: %s", beforeSegment));
			}

			if (point.getX().compareTo(eachSmoothedSegment.getPoint1().getX()) == 0)
			{
				afterSegment = eachSmoothedSegment;
				LOGGER.info(String.format("afterPoint found: %s", afterSegment));
			}
		}

		if (beforeSegment != null && afterSegment != null)
		{
			LOGGER.info(String.format("beforeSegment: %s; afterSegment: %s", beforeSegment.getSlope(),
					afterSegment.getSlope()));
			turningPoint = beforeSegment.getSlope() == Slope.ASCENDING && afterSegment.getSlope() == Slope.DESCENDING;
		}

		return turningPoint;
	}
}
