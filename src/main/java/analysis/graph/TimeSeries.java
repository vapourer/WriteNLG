// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.graph;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Container for a single dataset, recorded against time.
 */
public class TimeSeries
{
	private final SortedMap<Long, BigDecimal> series = new TreeMap<>();
	private final String timeLegend;
	private final String seriesLegend;

	/**
	 * Creates a TimeSeries instance.
	 * 
	 * @param times
	 * @param values
	 */
	public TimeSeries(final String times, final String values)
	{
		final String[] timesAsStrings = times.split(",");
		this.timeLegend = timesAsStrings[0];

		final String[] valuesAsStrings = values.split(",");
		this.seriesLegend = valuesAsStrings[0];

		for (int i = 1; i < timesAsStrings.length; i++)
		{
			final String[] dateAsString = timesAsStrings[i].split("/");
			final Calendar calendar = Calendar.getInstance();
			calendar.set(Integer.parseInt(dateAsString[2]), Integer.parseInt(dateAsString[1]) - 1,
					Integer.parseInt(dateAsString[0]));
			final Long date = Long.valueOf(calendar.getTimeInMillis());
			this.series.put(date, new BigDecimal(valuesAsStrings[i]));
		}
	}

	/**
	 * @return the timeLegend
	 */
	public String getTimeLegend()
	{
		return this.timeLegend;
	}

	/**
	 * @return the seriesLegend
	 */
	public String getSeriesLegend()
	{
		return this.seriesLegend;
	}

	/**
	 * @return the series
	 */
	public SortedMap<Long, BigDecimal> getSeries()
	{
		return new TreeMap<>(this.series);
	}
}
