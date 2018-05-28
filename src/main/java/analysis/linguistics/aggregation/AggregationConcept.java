// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.aggregation;

/**
 * High level concepts representing groups of informational elements potentially available for aggregation.
 */
public enum AggregationConcept
{
	ALL_INTRODUCTORY_INFORMATION_PRESENT,
	BOTH_SERIES_HAVE_ALL_SEGMENTS_ASCENDING,
	BOTH_SERIES_HAVE_ALL_SEGMENTS_DESCENDING,
	BOTH_SERIES_HAVE_MOST_SEGMENTS_ASCENDING,
	BOTH_SERIES_HAVE_MOST_SEGMENTS_DESCENDING,
	IDENTICAL_TIME_SLICES,
	AGGREGATE_MAXIMA,
	AGGREGATE_MINIMA,
	AGGREGATE_MAXIMUM_AND_MINIMUM,
	AGGREGATE_TURNING_POINTS,
	AGGREGATE_STATIONARY,
}
