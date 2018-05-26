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

			final int segmentCount = outlineSegments.size();

			if (segmentCount >= 1)
			{
				substitutions.addSubstitution("@@AscendOrFall1@@",
						outlineSegments.get(0).getSlope() == Slope.ASCENDING ? "rises" : "falls");
				substitutions.addSubstitution("@@Trend1Start@@", outlineSegments.get(0).getPoint1().getY().toString());
				substitutions.addSubstitution("@@Trend1End@@", outlineSegments.get(0).getPoint2().getY().toString());
			}

			if (segmentCount >= 2)
			{
				substitutions.addSubstitution("@@AscendOrFall2@@",
						outlineSegments.get(1).getSlope() == Slope.ASCENDING ? "rises" : "falls");
				substitutions.addSubstitution("@@Trend2End@@", outlineSegments.get(1).getPoint2().getY().toString());
			}

			if (segmentCount >= 3)
			{
				substitutions.addSubstitution("@@AscendOrFall3@@",
						outlineSegments.get(2).getSlope() == Slope.ASCENDING ? "rises" : "falls");
				substitutions.addSubstitution("@@Trend3End@@", outlineSegments.get(2).getPoint2().getY().toString());
			}

			if (segmentCount >= 4)
			{
				substitutions.addSubstitution("@@AscendOrFall4@@",
						outlineSegments.get(3).getSlope() == Slope.ASCENDING ? "rises" : "falls");
				substitutions.addSubstitution("@@Trend4End@@", outlineSegments.get(3).getPoint2().getY().toString());
			}

			if (segmentCount >= 5)
			{
				substitutions.addSubstitution("@@AscendOrFall5@@",
						outlineSegments.get(4).getSlope() == Slope.ASCENDING ? "rises" : "falls");
				substitutions.addSubstitution("@@Trend5End@@", outlineSegments.get(4).getPoint2().getY().toString());
			}

			this.timeSeriesMappings.add(new TimeSeriesMapping(eachTimeSeriesWithDerivedInformation, substitutions));
		}
	}
}
