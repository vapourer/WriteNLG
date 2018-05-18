// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.aggregation;

/**
 * Constraints used during aggregation.
 */
public enum AggregationConstraintType
{
	ALL_INTRODUCTORY_INFORMATION_PRESENT("AllIntroductoryInformationPresent"),
	BOTH_SERIES_HAVE_ALL_SEGMENTS_ASCENDING("BothSeriesHaveAllSegmentsAscending"),
	BOTH_SERIES_HAVE_ALL_SEGMENTS_DESCENDING("BothSeriesHaveAllSegmentsDescending"),
	BOTH_SERIESHAVEMOSTSEGMENTSASCENDING("BothSeriesHaveMostSegmentsAscending"),
	BOTHSERIESHAVEMOSTSEGMENTSDESCENDING("BothSeriesHaveMostSegmentsDescending");

	final private String textualForm;

	private AggregationConstraintType(final String text)
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
