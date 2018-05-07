// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.statistics;

import java.util.ArrayList;
import java.util.List;

import analysis.TimeSeriesWithDerivedInformation;
import analysis.graph.Point;
import analysis.graph.Segment;

/**
 * Compares two time series and produces a List of Segment instances in which they cross.
 */
public class TimeSeriesCross
{
	private final Segment[] series1Segments;
	private final Segment[] series2Segments;

	/**
	 * Creates a new TimeSeriesCross instance.
	 * 
	 * @param series1
	 * @param series2
	 */
	public TimeSeriesCross(final TimeSeriesWithDerivedInformation series1,
			final TimeSeriesWithDerivedInformation series2)
	{
		this.series1Segments = series1.getSegments().toArray(new Segment[0]);
		this.series2Segments = series2.getSegments().toArray(new Segment[0]);
	}

	/**
	 * @return a List of CrossingSegments instances
	 */
	public List<CrossingSegments> identifySegmentsWithCrossingPoints()
	{
		List<CrossingSegments> segmentsWithCrossingPoints = new ArrayList<>();

		for (int i = 0; i < this.series1Segments.length; i++)
		{
			if (segmentsIncludeCrossingPoint(this.series1Segments[i], this.series2Segments[i]))
			{
				CrossingSegments crossingSegments = new CrossingSegments(this.series1Segments[i],
						this.series2Segments[i], false);
				segmentsWithCrossingPoints.add(crossingSegments);
			}

			if (i > 0 && areFirstPointsEqual(this.series1Segments[i], this.series2Segments[i])
					&& crossingPointExactlyOnSampledTime(this.series1Segments[i - 1], this.series1Segments[i],
							this.series2Segments[i - 1], this.series2Segments[i]))
			{
				CrossingSegments crossingSegments = new CrossingSegments(this.series1Segments[i],
						this.series2Segments[i], true);
				segmentsWithCrossingPoints.add(crossingSegments);
			}
		}

		return segmentsWithCrossingPoints;
	}

	private boolean crossingPointExactlyOnSampledTime(final Segment series1Segment1, final Segment series1Segment2,
			final Segment series2Segment1, final Segment series2Segment2)
	{
		return (isFirstPointHigher(series1Segment1, series2Segment1)
				&& !isSecondPointHigher(series1Segment2, series2Segment2))
				|| (!isFirstPointHigher(series1Segment1, series2Segment1)
						&& isSecondPointHigher(series1Segment2, series2Segment2));
	}

	private boolean segmentsIncludeCrossingPoint(final Segment segment1, final Segment segment2)
	{
		return (isFirstPointHigherSecondPointLower(segment1, segment2)
				|| isFirstPointLowerSecondPointHigher(segment1, segment2)) && !areFirstPointsEqual(segment1, segment2)
				&& !areSecondPointsEqual(segment1, segment2);
	}

	private boolean isFirstPointHigherSecondPointLower(final Segment segment1, final Segment segment2)
	{
		return isFirstPointHigher(segment1, segment2) && !isSecondPointHigher(segment1, segment2);
	}

	private boolean isFirstPointLowerSecondPointHigher(final Segment segment1, final Segment segment2)
	{
		return !isFirstPointHigher(segment1, segment2) && isSecondPointHigher(segment1, segment2);
	}

	private boolean isFirstPointHigher(final Segment segment1, final Segment segment2)
	{
		Point firstSegmentPoint1 = segment1.getPoint1();
		Point secondSegmentPoint1 = segment2.getPoint1();
		return firstSegmentPoint1.getY().compareTo(secondSegmentPoint1.getY()) > 0;
	}

	private boolean isSecondPointHigher(final Segment segment1, final Segment segment2)
	{
		Point firstSegmentPoint2 = segment1.getPoint2();
		Point secondSegmentPoint2 = segment2.getPoint2();
		return firstSegmentPoint2.getY().compareTo(secondSegmentPoint2.getY()) > 0;
	}

	private boolean areFirstPointsEqual(final Segment segment1, final Segment segment2)
	{
		Point firstSegmentPoint1 = segment1.getPoint1();
		Point secondSegmentPoint1 = segment2.getPoint1();
		return firstSegmentPoint1.getY().compareTo(secondSegmentPoint1.getY()) == 0;
	}

	private boolean areSecondPointsEqual(final Segment segment1, final Segment segment2)
	{
		Point firstSegmentPoint2 = segment1.getPoint2();
		Point secondSegmentPoint2 = segment2.getPoint2();
		return firstSegmentPoint2.getY().compareTo(secondSegmentPoint2.getY()) == 0;
	}
}
