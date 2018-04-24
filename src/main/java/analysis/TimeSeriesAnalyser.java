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
 * Analyses input data and maps processed information to placeholder tokens.
 * Placeholders and algorithms used for analysis are domain specific.
 */
public class TimeSeriesAnalyser implements TimeSeriesAnalysis
{
	private static final Logger LOGGER = LogManager.getLogger("TimeSeriesAnalyser.class");

	private final TimeSeries timeSeries;

	// Regulatory regulator;
	// private final BigDecimal[] series;
	List<Segment> segments;

	// public TimeSeriesAnalyser(final Regulatory regulator, final TimeSeries timeSeries)
	public TimeSeriesAnalyser(final TimeSeries timeSeries)
	{
		// this.regulator = regulator;
		// this.series = timeSeries.getSeries().values().toArray(new BigDecimal[0]);

		this.timeSeries = timeSeries;

		final Segmentation segmenter = new Segmenter(timeSeries.getSeries());
		this.segments = segmenter.createSegments();

		LOGGER.info("TimeSeriesAnalyser created");
	}

	/**
	 * Maps information derived from processed raw data to placeholders and stores
	 * in the regulator.
	 */
	@Override
	public TimeSeriesDerivedInformation analyse()
	{
		LOGGER.info("Building statistical analysis");
		// this.regulator.mapPlaceHolder("@Maximum", Double.toString(Arrays.stream(this.rawData).max().getAsDouble()));
		// this.regulator.mapPlaceHolder("@Minimum", Double.toString(Arrays.stream(this.rawData).min().getAsDouble()));
		// this.regulator.mapPlaceHolder("@Average",
		// Double.toString(Arrays.stream(this.rawData).average().getAsDouble()));

		final TimeSeriesDerivedInformationBuilder builder = new TimeSeriesDerivedInformationBuilder();
		builder.setPointWithMaximumValue(new Maximum(this.timeSeries).calculate());
		builder.setPointWithMinimumValue(new Minimum(this.timeSeries).calculate());
		builder.setSegments(this.segments);
		return builder.createTimeSeriesDerivedInformation();
	}
}
