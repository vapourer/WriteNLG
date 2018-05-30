// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.substitution;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.LineGraphWithDerivedInformation;
import analysis.TimeSeriesWithDerivedInformation;
import analysis.graph.Segment;
import analysis.graph.Slope;
import analysis.interfaces.Mapper;
import analysis.time.TimesAndWindows;
import analysis.utilities.GlobalConstants;
import writenlg.substitution.NumberTransformations;
import writenlg.substitution.Substitutions;

/**
 * Manages globalMappings for use during parsing.
 */
public class Substitutor implements Mapper
{
	private static final Logger LOGGER = LogManager.getLogger("Substitutor.class");

	private final LineGraphWithDerivedInformation lineGraphWithDerivedInformation;
	private final Substitutions globalMappings;
	private final List<TimeSeriesMapping> timeSeriesMappings;
	private final List<TimeSeriesMapping> timeSeriesMappingsForTrend;

	private int thenCount;

	/**
	 * Creates a Substitutor instance.
	 * 
	 * @param lineGraphWithDerivedInformation
	 * @param concepts
	 */
	public Substitutor(final LineGraphWithDerivedInformation lineGraphWithDerivedInformation)
	{
		this.lineGraphWithDerivedInformation = lineGraphWithDerivedInformation;
		this.globalMappings = new Substitutions();
		this.timeSeriesMappings = new ArrayList<>();
		this.timeSeriesMappingsForTrend = new ArrayList<>();

		loadMappings();
	}

	/**
	 * TODO: current implementation cannot handle more than two time series.
	 * TODO: some substitutions involve logic. Time limitations prevented incorporating these into the constraint
	 * framework, but some elements are in place to accommodate such a revision.
	 * 
	 * @return the globalMappings
	 */
	@Override
	public Substitutions getGlobalMappings()
	{
		if (this.lineGraphWithDerivedInformation.getTimeSeriesCount() == 2)
		{
			List<TimeSeriesWithDerivedInformation> timeSeriesWithDerivedInformation = lineGraphWithDerivedInformation
					.getTimeSeriesDerivedInformation();
			int crossingPointCount = this.lineGraphWithDerivedInformation.getCrossingPointCount(
					timeSeriesWithDerivedInformation.get(0), timeSeriesWithDerivedInformation.get(1));
			this.globalMappings.addSubstitution("@@CrossCount@@", String.valueOf(crossingPointCount));

			List<String> crossingPointWindows = this.lineGraphWithDerivedInformation.getCrossingPointWindows(
					timeSeriesWithDerivedInformation.get(0), timeSeriesWithDerivedInformation.get(1));

			if (crossingPointWindows.size() > 0)
			{
				this.globalMappings.addSubstitution("@@LinesCrossWindow@@", crossingPointWindows.get(0));
			}
		}
		else
		{
			LOGGER.error("No implementation for more than two time series");
			throw new RuntimeException("Provision for more than two time series not yet implemented");
		}

		this.globalMappings.addSubstitution("@@LineCount@@",
				String.valueOf(this.lineGraphWithDerivedInformation.getTimeSeriesCount()));

		this.globalMappings.addSubstitution("@@LineCountText@@", NumberTransformations.getInstance()
				.textForNumber(this.lineGraphWithDerivedInformation.getTimeSeriesCount()));

		this.globalMappings.addSubstitution("@@TimeSlice@@",
				this.lineGraphWithDerivedInformation.getTimeSlice().toString());

		this.globalMappings.addSubstitution("@@TimeSliceAsAdjective@@",
				this.lineGraphWithDerivedInformation.getTimeSlice().asAdjective());

		List<String> seriesLegends = this.lineGraphWithDerivedInformation.getTimesSeriesLegends();
		final String seriesLegendsAsPhrase = seriesLegends.get(0) + " and " + seriesLegends.get(1);

		this.globalMappings.addSubstitution("@@SeriesLegends@@", seriesLegendsAsPhrase);

		this.globalMappings.addSubstitution("@@SeriesGapAverage@@",
				this.lineGraphWithDerivedInformation.getAveragedDifferenceMean().toString());

		List<Segment> seriesGapTrends = this.lineGraphWithDerivedInformation.getSmoothedAveragedDifferenceSegments();

		int seriesGapTrendsSize = seriesGapTrends.size();

		LOGGER.info(String.format("List of averaged segments - size: %d", seriesGapTrendsSize));

		if (seriesGapTrendsSize > 2)
		{
			LOGGER.error(String.format("List of averaged segments must not be greater than 2, but was %d",
					seriesGapTrendsSize));
			throw new RuntimeException("List of averaged segments must not be greater than 2");
		}

		LOGGER.info(String.format("Slope 1: %s; Slope 2: %s", seriesGapTrends.get(0).getSlope(),
				seriesGapTrendsSize == 1 ? "None" : seriesGapTrends.get(1).getSlope()));

		String increaseOrDecrease = "";

		if ((seriesGapTrendsSize == 1 && seriesGapTrends.get(0).getSlope() == Slope.ASCENDING)
				|| (seriesGapTrendsSize == 2 && seriesGapTrends.get(0).getSlope() == Slope.ASCENDING
						&& seriesGapTrends.get(1).getSlope() == Slope.ASCENDING))
		{
			increaseOrDecrease = "widen";
		}

		if ((seriesGapTrendsSize == 1 && seriesGapTrends.get(0).getSlope() == Slope.DESCENDING)
				|| (seriesGapTrendsSize == 2 && seriesGapTrends.get(0).getSlope() == Slope.DESCENDING
						&& seriesGapTrends.get(1).getSlope() == Slope.DESCENDING))
		{
			increaseOrDecrease = "narrow";
		}

		if (seriesGapTrendsSize == 2 && seriesGapTrends.get(0).getSlope() == Slope.ASCENDING
				&& seriesGapTrends.get(1).getSlope() == Slope.DESCENDING)
		{
			increaseOrDecrease = "widen then narrow";
		}

		if (seriesGapTrendsSize == 2 && seriesGapTrends.get(0).getSlope() == Slope.DESCENDING
				&& seriesGapTrends.get(1).getSlope() == Slope.ASCENDING)
		{
			increaseOrDecrease = "narrow then widen";
		}

		this.globalMappings.addSubstitution("@@IncreaseOrDecrease@@", increaseOrDecrease);

		return this.globalMappings;
	}

	/**
	 * @return the timeSeriesMappings
	 */
	@Override
	public List<TimeSeriesMapping> getTimeSeriesMappings()
	{
		return new ArrayList<>(this.timeSeriesMappings);
	}

	/**
	 * @return the timeSeriesMappingsForTrend
	 */
	public List<TimeSeriesMapping> getTimeSeriesMappingsForTrend()
	{
		return new ArrayList<>(timeSeriesMappingsForTrend);
	}

	private void loadMappings()
	{
		List<TimeSeriesWithDerivedInformation> timeSeriesWithDerivedInformation = lineGraphWithDerivedInformation
				.getTimeSeriesDerivedInformation();

		for (TimeSeriesWithDerivedInformation eachTimeSeriesWithDerivedInformation : timeSeriesWithDerivedInformation)
		{
			Substitutions substitutions = new Substitutions();
			substitutions.addSubstitution("@@SeriesLegend@@", eachTimeSeriesWithDerivedInformation.getSeriesLegend());
			substitutions.addSubstitution("@@TimeSlice@@",
					eachTimeSeriesWithDerivedInformation.getTimeSlice().toString());
			substitutions.addSubstitution("@@Maximum@@",
					eachTimeSeriesWithDerivedInformation.getPointWithMaximumValue().getY().toString());
			substitutions.addSubstitution("@@Minimum@@",
					eachTimeSeriesWithDerivedInformation.getPointWithMinimumValue().getY().toString());
			substitutions.addSubstitution("@@Direction@@",
					eachTimeSeriesWithDerivedInformation.getDirectionOfLongestSegment().getTextualForm());

			final int smoothedSegmentCount = eachTimeSeriesWithDerivedInformation.getSmoothedSegments().size();
			final int outlineSegmentCount = eachTimeSeriesWithDerivedInformation.getOutlineSegments().size();

			LOGGER.info(String.format("smoothedSegmentCount: %d; outlineSegmentCount: %d", smoothedSegmentCount,
					outlineSegmentCount));

			final List<Segment> outlineSegments = outlineSegmentCount <= smoothedSegmentCount
					? eachTimeSeriesWithDerivedInformation.getOutlineSegments()
					: eachTimeSeriesWithDerivedInformation.getSmoothedSegments();

			final TimesAndWindows timesAndWindows = new TimesAndWindows(outlineSegments,
					eachTimeSeriesWithDerivedInformation.getTimeSlice());

			final List<String> startTimes = timesAndWindows.getWindowsForSegmentStartPoints();
			final List<String> endTimes = timesAndWindows.getWindowsForSegmentEndPoints();

			final int segmentCount = outlineSegments.size();
			LOGGER.info(String.format("segmentCount: %d", segmentCount));

			Segment currentSegment = outlineSegments.get(0);

			if (segmentCount >= 1)
			{
				substitutions.addSubstitution("@@AscendOrFall1@@", getVerbSubstitution(null, currentSegment));
				substitutions.addSubstitution("@@Trend1Start@@",
						currentSegment.getPoint1().getY().toString() + GlobalConstants.SPACE + startTimes.get(0));
				substitutions.addSubstitution("@@Trend1End@@",
						currentSegment.getPoint2().getY().toString() + GlobalConstants.SPACE + endTimes.get(0));
			}

			if (segmentCount >= 2)
			{
				Segment newSegment = outlineSegments.get(1);

				substitutions.addSubstitution("@@AscendOrFall2@@", getVerbSubstitution(currentSegment, newSegment));
				substitutions.addSubstitution("@@Trend2End@@",
						newSegment.getPoint2().getY().toString() + GlobalConstants.SPACE + endTimes.get(1));

				currentSegment = newSegment;
			}

			if (segmentCount >= 3)
			{
				Segment newSegment = outlineSegments.get(2);

				substitutions.addSubstitution("@@AscendOrFall3@@", getVerbSubstitution(currentSegment, newSegment));
				substitutions.addSubstitution("@@Trend3End@@",
						newSegment.getPoint2().getY().toString() + GlobalConstants.SPACE + endTimes.get(2));

				currentSegment = newSegment;
			}

			if (segmentCount >= 4)
			{
				Segment newSegment = outlineSegments.get(3);

				substitutions.addSubstitution("@@AscendOrFall4@@", getVerbSubstitution(currentSegment, newSegment));
				substitutions.addSubstitution("@@Trend4End@@",
						newSegment.getPoint2().getY().toString() + GlobalConstants.SPACE + endTimes.get(3));

				currentSegment = newSegment;
			}

			if (segmentCount >= 5)
			{
				Segment newSegment = outlineSegments.get(4);

				substitutions.addSubstitution("@@AscendOrFall5@@", getVerbSubstitution(currentSegment, newSegment));
				substitutions.addSubstitution("@@Trend5End@@",
						newSegment.getPoint2().getY().toString() + GlobalConstants.SPACE + endTimes.get(4));
			}

			this.timeSeriesMappings.add(new TimeSeriesMapping(eachTimeSeriesWithDerivedInformation, substitutions));
		}
	}

	private String getVerbSubstitution(final Segment oldSegment, final Segment newSegment)
	{
		String verbPhrase = newSegment.getSlope() == Slope.ASCENDING ? "rises" : "falls";

		if (oldSegment != null && oldSegment.getSlope() == newSegment.getSlope())
		{
			switch (newSegment.getSlope())
			{
				case ASCENDING:
					if (newSegment.getGradient().compareTo(oldSegment.getGradient()) > 0)
					{
						verbPhrase += " more sharply";
					}
					else
					{
						verbPhrase += " less sharply";
					}
					break;
				case DESCENDING:
					if (newSegment.getGradient().compareTo(oldSegment.getGradient()) < 0)
					{
						verbPhrase += " more sharply";
					}
					else
					{
						verbPhrase += " less sharply";
					}
					break;
				case FLAT:
				default:
					LOGGER.error(String.format("%s not implemented", newSegment.getSlope()));
					throw new RuntimeException("Enum value not implemented");
			}

			if (this.thenCount == 0)
			{
				verbPhrase = "then " + verbPhrase;
				this.thenCount++;
			}
		}

		return verbPhrase;
	}
}
