/**
 *
 */
package analysis.graph;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.SortedSet;

import analysis.interfaces.Segmentation;

/**
 * Derives evenly-spaced segments from a series of values mapped against time.
 */
public class Segmenter implements Segmentation
{
	private final SortedMap<Long, BigDecimal> timeSeries;

	public Segmenter(final SortedMap<Long, BigDecimal> timeSeries)
	{
		this.timeSeries = timeSeries;
	}

	/**
	 * Returns a List of segments derived from a time series.
	 */
	@Override
	public List<Segment> createSegments()
	{
		final List<Segment> segments = new ArrayList<>();
		final Long[] times = ((SortedSet<Long>) this.timeSeries.keySet()).toArray(new Long[0]);
		final int segmentCount = times.length - 1;

		for (int i = 0; i < segmentCount; i++)
		{
			final Point point1 = new Point(new BigDecimal(i), this.timeSeries.get(times[i]));
			final Point point2 = new Point(new BigDecimal(i + 1), this.timeSeries.get(times[i + 1]));
			segments.add(new Segment(point1, point2, times[i], times[i + 1]));
		}

		return segments;
	}
}
