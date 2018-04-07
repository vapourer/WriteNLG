package analysis;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import analysis.graph.Segment;
import analysis.graph.Segmenter;
import analysis.graph.TimeSeries;
import analysis.interfaces.Analyser;
import analysis.interfaces.Segmentation;
import writenlg.regulator.Regulatory;

/**
 * Analyses input data and maps processed information to placeholder tokens.
 * Placeholders and algorithms used for analysis are domain specific.
 */
public class TimeSeriesAnalyser implements Analyser
{
	Regulatory regulator;
	private final BigDecimal[] series;
	private final double[] rawData;
	List<Segment> segments;

	public TimeSeriesAnalyser(final Regulatory regulator, final TimeSeries timeSeries)
	{
		this.regulator = regulator;
		this.series = timeSeries.getTimeSeries().values().toArray(new BigDecimal[0]);
		this.rawData = new double[this.series.length];

		for (int i = 0; i < this.series.length; i++)
		{
			this.rawData[i] = this.series[i].doubleValue();
		}

		final Segmentation segmenter = new Segmenter(timeSeries.getTimeSeries());
		this.segments = segmenter.createSegments();

		// final CsvReader csvReader = new CsvReader(numbersAsString);
		// this.rawData = csvReader.processCsv();
	}

	// TODO: Move to a new TimeSeriesAnalyser class.
	// public Analyser(final Regulatory regulator, final LineGraph lineGraph)
	// {
	// this.regulator = regulator;
	// }

	/**
	 * Maps information derived from processed raw data to placeholders and stores
	 * in the regulator.
	 */
	@Override
	public Analysis analyse()
	{
		// this.regulator.mapPlaceHolder("@Maximum", Double.toString(Arrays.stream(this.rawData).max().getAsDouble()));
		// this.regulator.mapPlaceHolder("@Minimum", Double.toString(Arrays.stream(this.rawData).min().getAsDouble()));
		// this.regulator.mapPlaceHolder("@Average",
		// Double.toString(Arrays.stream(this.rawData).average().getAsDouble()));

		final AnalysisBuilder builder = new AnalysisBuilder();
		builder.setMaximum(Arrays.stream(this.rawData).max().getAsDouble());
		builder.setMinimum(Arrays.stream(this.rawData).min().getAsDouble());
		builder.setMean(Arrays.stream(this.rawData).average().getAsDouble());
		return builder.createAnalysis();
	}
}
