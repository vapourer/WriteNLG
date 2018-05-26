// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.statistics;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.TimeSeriesWithDerivedInformation;
import analysis.graph.Point;
import analysis.graph.Segment;
import analysis.graph.Slope;

/**
 * Identifies lower turning points below the 0.1 centile of a time series after smoothing.
 */
public class LowerTurningPointsTenPercentile
{
	private static final Logger LOGGER = LogManager.getLogger("LowerTurningPointsTenPercentile.class");

	private final TimeSeriesWithDerivedInformation timeSeries;

	/**
	 * Creates a LowerTurningPointsTenPercentile instance.
	 * 
	 * @param timeSeriesWithDerivedInformation
	 */
	public LowerTurningPointsTenPercentile(final TimeSeriesWithDerivedInformation timeSeriesWithDerivedInformation)
	{
		this.timeSeries = timeSeriesWithDerivedInformation;
	}

	/**
	 * @return a List of Point instances representing lower turning points below the 0.1 centile.
	 */
	public List<Point> identify()
	{
		TenPercentile tenPercentile = new TenPercentile(this.timeSeries);
		Point[] tenPercentileGroup = tenPercentile.identify();

		int tenPercentileSize = tenPercentileGroup.length;

		BigDecimal tenPercentileThreshold = null;

		for (int i = tenPercentileSize - 1; i >= 0; i--)
		{
			if (tenPercentileGroup[i] != null)
			{
				tenPercentileThreshold = tenPercentileGroup[i].getY();
				break;
			}
		}

		LOGGER.info(String.format("Ten percentile threshold: %s", tenPercentileThreshold));

		List<Point> tenPercentileSmoothed = new ArrayList<>();

		for (Point eachPoint : this.timeSeries.getSmoothedPoints())
		{
			LOGGER.info(String.format("Smoothed point: %s", eachPoint));

			if (eachPoint.getY().compareTo(tenPercentileThreshold) <= 0 && isTurningPoint(eachPoint))
			{
				tenPercentileSmoothed.add(eachPoint);
				LOGGER.info(String.format("Upper turning point identified in ninety percentile - %s", eachPoint));
			}
		}

		return tenPercentileSmoothed;
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
			turningPoint = beforeSegment.getSlope() == Slope.DESCENDING && afterSegment.getSlope() == Slope.ASCENDING;
		}

		return turningPoint;
	}
}
