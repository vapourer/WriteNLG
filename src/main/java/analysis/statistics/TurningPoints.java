// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.statistics;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.graph.Point;
import analysis.graph.Segment;
import analysis.graph.Slope;

/**
 * Identifies turning points, upper and lower, for a time series.
 */
public class TurningPoints
{
	private static final Logger LOGGER = LogManager.getLogger("TurningPoints.class");

	private static TurningPoints INSTANCE;

	private final List<Point> smoothedPoints;
	private final List<Segment> smoothedSegments;
	private final List<Point> upperTurningPoints;
	private final List<Point> lowerTurningPoints;

	/**
	 * @param smoothedPoints
	 * @param smoothedSegments
	 * @return a TurningPoints instance
	 */
	public static TurningPoints getInstance(final List<Point> smoothedPoints, final List<Segment> smoothedSegments)
	{
		if (INSTANCE == null)
		{
			INSTANCE = new TurningPoints(smoothedPoints, smoothedSegments);
		}

		return INSTANCE;
	}

	private TurningPoints(final List<Point> smoothedPoints, final List<Segment> smoothedSegments)
	{
		this.smoothedPoints = smoothedPoints;
		this.smoothedSegments = smoothedSegments;
		this.upperTurningPoints = new ArrayList<>();
		this.lowerTurningPoints = new ArrayList<>();
		identifyTurningPoints();
	}

	private void identifyTurningPoints()
	{
		for (Point eachPoint : this.smoothedPoints)
		{
			checkForTurningPoint(eachPoint);
		}
	}

	private void checkForTurningPoint(final Point point)
	{
		Segment beforeSegment = null;
		Segment afterSegment = null;

		for (Segment eachSmoothedSegment : this.smoothedSegments)
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
			checkAndLoadTurningPoint(beforeSegment, afterSegment, point);
		}
	}

	private void checkAndLoadTurningPoint(final Segment beforeSegment, final Segment afterSegment, final Point point)
	{
		LOGGER.info(String.format("beforeSegment: %s; afterSegment: %s", beforeSegment.getSlope(),
				afterSegment.getSlope()));

		if (beforeSegment.getSlope() == Slope.ASCENDING && afterSegment.getSlope() == Slope.DESCENDING)
		{
			this.upperTurningPoints.add(point);
		}
		else if (beforeSegment.getSlope() == Slope.DESCENDING && afterSegment.getSlope() == Slope.ASCENDING)
		{
			this.lowerTurningPoints.add(point);
		}
	}

	/**
	 * @return the upperTurningPoints
	 */
	public List<Point> getUpperTurningPoints()
	{
		return upperTurningPoints;
	}

	/**
	 * @return the lowerTurningPoints
	 */
	public List<Point> getLowerTurningPoints()
	{
		return lowerTurningPoints;
	}
}
