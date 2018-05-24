// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.contentdetermination;

/**
 * Constraint types for LinesCrossConcept
 */
public enum ConstraintType
{
	LINES_CROSS("LinesCross"),
	LINES_CROSS_MULTIPLE_TIMES("LinesCrossMultipleTimes"),
	LINES_DO_NOT_CROSS("LinesDoNotCross"),
	LINES_CROSS_ONCE("LinesCrossOnce"),
	SERIES_LEGEND("SeriesLegendRequired"),
	LINE_COUNT("LineCountRequired"),
	SINGLE_OBVIOUS_MAXIMUM("SingleObviousMaximum"),
	MULTIPLE_HIGH_TURNING_POINTS("MultipleHighTurningPoints"),
	MAXIMUM_AT_START("MaximumAtStart"),
	MAXIMUM_AT_END("MaximumAtEnd"),
	SINGLE_OBVIOUS_MINIMUM("SingleObviousMinimum"),
	MULTIPLE_LOW_TURNING_POINTS("MultipleLowTurningPoints"),
	MINIMUM_AT_START("MinimumAtStart"),
	MINIMUM_AT_END("MinimumAtEnd"),
	ALL_SEGMENTS_ASCENDING("AllSegmentsAscending"),
	MOST_SEGMENTS_ASCENDING("MostSegmentsAscending"),
	ALL_SEGMENTS_DESCENDING("AllSegmentsDescending"),
	MOST_SEGMENTS_DESCENDING("MostSegmentsDescending"),
	TIME_SLICE_REQUIRED("TimeSliceRequired"),
	ALL_INTRODUCTORY_INFORMATION_PRESENT("AllIntroductoryInformationPresent"),
	BOTH_SERIES_HAVE_ALL_SEGMENTS_ASCENDING("BothSeriesHaveAllSegmentsAscending"),
	BOTH_SERIES_HAVE_ALL_SEGMENTS_DESCENDING("BothSeriesHaveAllSegmentsDescending"),
	BOTH_SERIES_HAVE_MOST_SEGMENTS_ASCENDING("BothSeriesHaveMostSegmentsAscending"),
	BOTH_SERIES_HAVE_MOST_SEGMENTS_DESCENDING("BothSeriesHaveMostSegmentsDescending"),
	IDENTICAL_TIME_SLICES("IdenticalTimeSlices"),
	MAXIMUM_REQUIRED("MaximumRequired"),
	MINIMUM_REQUIRED("MinimumRequired"),
	MAXIMA_ALL_PRESENT("MaximaAllPresent"),
	MINIMA_ALL_PRESENT("MinimaAllPresent"),
	MAXIMA_AND_MINIMA_ALL_PRESENT("MaximaAndMinimaAllPresent");

	final private String textualForm;

	private ConstraintType(final String text)
	{
		this.textualForm = text;
	}

	/**
	 * @return the textualForm
	 */
	public String getTextualForm()
	{
		return textualForm;
	}
}