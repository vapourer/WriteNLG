// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.graph.Segment;
import analysis.graph.Segmenter;
import analysis.graph.TimeSeries;
import analysis.interfaces.Segmentation;
import analysis.interfaces.TimeSeriesAnalysis;
import analysis.statistics.Maximum;
import analysis.statistics.Minimum;

/**
 * Analyses a TimeSeries instance, from which derived information is stored in a TimeSeriesWithDerivedInformation
 * instance.
 */
public class TimeSeriesAnalyser implements TimeSeriesAnalysis
{
	private static final Logger LOGGER = LogManager.getLogger("TimeSeriesAnalyser.class");

	private final TimeSeries timeSeries;
	List<Segment> segments;

	/**
	 * Creates a new TimeSeriesAnalyser instance.
	 * 
	 * @param timeSeries
	 */
	public TimeSeriesAnalyser(final TimeSeries timeSeries)
	{
		this.timeSeries = timeSeries;

		final Segmentation segmenter = new Segmenter(timeSeries);
		this.segments = segmenter.createSegments();

		LOGGER.info("TimeSeriesAnalyser created");
	}

	/**
	 * Analyses this TimeSeries, and stores derived information in a TimeSeriesWithDerivedInformation instance, via a
	 * builder.
	 */
	@Override
	public TimeSeriesWithDerivedInformation analyse()
	{
		LOGGER.info(String.format("Building statistical analysis for %s", this.timeSeries.getSeriesLegend()));

		final TimeSeriesWithDerivedInformationBuilder builder = new TimeSeriesWithDerivedInformationBuilder();

		builder.setTimeSeries(this.timeSeries);
		builder.setPointWithMaximumValue(new Maximum(this.timeSeries).calculate());
		builder.setPointWithMinimumValue(new Minimum(this.timeSeries).calculate());
		builder.setSegments(this.segments);

		return builder.createTimeSeriesDerivedInformation();
	}
}
