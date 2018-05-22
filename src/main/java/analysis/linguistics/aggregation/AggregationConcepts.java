// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.aggregation;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import writenlg.aggregation.AbstractAggregationConcept;
import writenlg.linguistics.phrase.PhraseSpecification;

/**
 * Aggregation concept collections populated from ANTLR PhraseCreator input.
 */
public class AggregationConcepts
{
	private static final Logger LOGGER = LogManager.getLogger("AggregationConcepts.class");

	private final List<AbstractAggregationConcept> aggregationConcepts;

	/**
	 * Creates a new AggregationConcepts instance.
	 */
	public AggregationConcepts()
	{
		this.aggregationConcepts = new ArrayList<>();
	}

	/**
	 * @param aggregationConcept
	 * @param phraseSpecifications
	 */
	public void addAggregationConcept(final AggregationConcept aggregationConcept,
			final List<PhraseSpecification> phraseSpecifications)
	{
		switch (aggregationConcept)
		{
			case ALL_INTRODUCTORY_INFORMATION_PRESENT:

				break;
			case BOTH_SERIES_HAVE_ALL_SEGMENTS_ASCENDING:
				break;
			case BOTH_SERIES_HAVE_ALL_SEGMENTS_DESCENDING:
				break;
			case BOTH_SERIES_HAVE_MOST_SEGMENTS_ASCENDING:
				break;
			case BOTH_SERIES_HAVE_MOST_SEGMENTS_DESCENDING:
				break;
			case IDENTICAL_TIME_SLICES:
				break;
			default:
				LOGGER.error(String.format("%s not implemented", aggregationConcept));
				throw new RuntimeException("Not implemented");
		}

		LOGGER.info(String.format("%s concept added", aggregationConcept));
	}
}
