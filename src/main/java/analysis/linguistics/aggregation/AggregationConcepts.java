// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.aggregation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.linguistics.aggregation.concepts.AggregateMaximaConcept;
import analysis.linguistics.aggregation.concepts.AggregateMaximumAndMinimumConcept;
import analysis.linguistics.aggregation.concepts.AggregateMinimaConcept;
import analysis.linguistics.aggregation.concepts.AggregateStationaryConcept;
import analysis.linguistics.aggregation.concepts.AggregateTurningPointsConcept;
import analysis.linguistics.aggregation.concepts.AllIntroductoryInformationPresentConcept;
import analysis.linguistics.aggregation.concepts.BothSeriesHaveAllSegmentsAscendingConcept;
import analysis.linguistics.aggregation.concepts.BothSeriesHaveAllSegmentsDescendingConcept;
import analysis.linguistics.aggregation.concepts.BothSeriesHaveMostSegmentsAscendingConcept;
import analysis.linguistics.aggregation.concepts.BothSeriesHaveMostSegmentsDescendingConcept;
import analysis.linguistics.aggregation.concepts.IdenticalTimeSlicesConcept;
import analysis.substitution.Substitutor;
import writenlg.aggregation.AbstractAggregationConcept;
import writenlg.linguistics.phrase.PhraseSpecification;

/**
 * Aggregation concept collections populated from ANTLR PhraseCreator input.
 */
public class AggregationConcepts
{
	private static final Logger LOGGER = LogManager.getLogger("AggregationConcepts.class");

	private final Substitutor substitutor;

	private final Map<AggregationConcept, AbstractAggregationConcept> aggregationConcepts;

	/**
	 * Creates a new AggregationConcepts instance.
	 */
	public AggregationConcepts(final Substitutor substitutor)
	{
		this.substitutor = substitutor;
		this.aggregationConcepts = new HashMap<>();
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
				final List<PhraseSpecification> allIntroductoryInformationPresentPhraseSpecifications = new ArrayList<>();

				for (PhraseSpecification specification : phraseSpecifications)
				{
					allIntroductoryInformationPresentPhraseSpecifications.add(specification
							.substitutePlaceholders(this.substitutor.getGlobalMappings().getSubstitutions()));
				}

				this.aggregationConcepts.put(aggregationConcept, new AllIntroductoryInformationPresentConcept(
						allIntroductoryInformationPresentPhraseSpecifications));
				break;
			case BOTH_SERIES_HAVE_ALL_SEGMENTS_ASCENDING:
				this.aggregationConcepts.put(aggregationConcept,
						new BothSeriesHaveAllSegmentsAscendingConcept(phraseSpecifications));
				break;
			case BOTH_SERIES_HAVE_ALL_SEGMENTS_DESCENDING:
				this.aggregationConcepts.put(aggregationConcept,
						new BothSeriesHaveAllSegmentsDescendingConcept(phraseSpecifications));
				break;
			case BOTH_SERIES_HAVE_MOST_SEGMENTS_ASCENDING:
				this.aggregationConcepts.put(aggregationConcept,
						new BothSeriesHaveMostSegmentsAscendingConcept(phraseSpecifications));
				break;
			case BOTH_SERIES_HAVE_MOST_SEGMENTS_DESCENDING:
				this.aggregationConcepts.put(aggregationConcept,
						new BothSeriesHaveMostSegmentsDescendingConcept(phraseSpecifications));
				break;
			case IDENTICAL_TIME_SLICES:
				this.aggregationConcepts.put(aggregationConcept, new IdenticalTimeSlicesConcept(phraseSpecifications));
				break;
			case AGGREGATE_MAXIMA:
				this.aggregationConcepts.put(aggregationConcept, new AggregateMaximaConcept(phraseSpecifications));
				break;
			case AGGREGATE_MINIMA:
				this.aggregationConcepts.put(aggregationConcept, new AggregateMinimaConcept(phraseSpecifications));
				break;
			case AGGREGATE_MAXIMUM_AND_MINIMUM:
				this.aggregationConcepts.put(aggregationConcept,
						new AggregateMaximumAndMinimumConcept(phraseSpecifications));
				break;
			case AGGREGATE_TURNING_POINTS:
				this.aggregationConcepts.put(aggregationConcept,
						new AggregateTurningPointsConcept(phraseSpecifications));
				break;
			case AGGREGATE_STATIONARY:
				this.aggregationConcepts.put(aggregationConcept, new AggregateStationaryConcept(phraseSpecifications));
				break;
			default:
				LOGGER.error(String.format("%s not implemented", aggregationConcept));
				throw new RuntimeException("Enum value not implemented");
		}

		LOGGER.info(String.format("%s concept added", aggregationConcept));
	}

	/**
	 * @return the aggregationConcepts
	 */
	public Map<AggregationConcept, AbstractAggregationConcept> getAggregationConcepts()
	{
		return new HashMap<>(this.aggregationConcepts);
	}
}
