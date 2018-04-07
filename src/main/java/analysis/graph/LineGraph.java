package analysis.graph;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SortedMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Stores the data for a line graph capable of representing multiple time
 * series. Times are used as keys in the underlying TreeMap, .
 */
public class LineGraph
{
	private static final Logger LOGGER = LogManager.getLogger("LineGraph.class");

	private final List<TimeSeries> timeSeriesGroup;

	/**
	 * Creates a LineGraph instance.
	 *
	 * @param times
	 *            A String containing comma separated values representing the X
	 *            axis legend followed by a sequence of times.
	 * @param values
	 *            A list of Strings each containing the Y axis legend followed
	 *            by an associated sequence of Y values.
	 */
	public LineGraph(final List<String> times, final List<String> values)
	{
		LOGGER.info("Creating LineGraph");

		this.timeSeriesGroup = new ArrayList<>();

		for (int i = 0; i < times.size(); i++)
		{
			final TimeSeries series = new TimeSeries(times.get(i), values.get(i));
			this.timeSeriesGroup.add(series);
		}

		logTimeSeriesLoading();
	}

	/**
	 * @return the timeSeriesGroup
	 */
	public List<TimeSeries> getTimeSeriesGroup()
	{
		return new ArrayList<>(this.timeSeriesGroup);
	}

	private void logTimeSeriesLoading()
	{
		LOGGER.info("Time series generated");

		for (final TimeSeries eachTimeSeries : this.timeSeriesGroup)
		{
			LOGGER.info(String.format("Time series %s", this.timeSeriesGroup.indexOf(eachTimeSeries) + 1));
			LOGGER.info(String.format("%s\t%s", eachTimeSeries.getSeriesLegend(), eachTimeSeries.getTimeLegend()));
			log(eachTimeSeries.getTimeSeries());
			LOGGER.info(
					String.format("Time series %s output complete", this.timeSeriesGroup.indexOf(eachTimeSeries) + 1));
		}
	}

	private void log(final SortedMap<Long, BigDecimal> timeSeries)
	{
		final DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

		for (final Long eachTime : timeSeries.keySet())
		{
			final String formattedDate = dateFormatter.format(new Date(eachTime));
			LOGGER.info(String.format("%s\t%s", formattedDate, timeSeries.get(eachTime)));
		}
	}
}
