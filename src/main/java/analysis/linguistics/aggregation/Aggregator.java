// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.aggregation;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.CharStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.linguistics.aggregation.concepts.AllIntroductoryInformationPresentConcept;
import analysis.linguistics.aggregation.concepts.BothSeriesHaveAllSegmentsAscendingConcept;
import analysis.linguistics.aggregation.concepts.BothSeriesHaveAllSegmentsDescendingConcept;
import analysis.linguistics.aggregation.concepts.BothSeriesHaveMostSegmentsAscendingConcept;
import analysis.linguistics.aggregation.concepts.BothSeriesHaveMostSegmentsDescendingConcept;
import analysis.linguistics.aggregation.concepts.IdenticalTimeSlicesConcept;
import control.WriteNlgProperties;
import io.AntlrInputReader;
import io.LexerParser;
import io.expertinput.AggregationLexerParser;
import io.expertinput.listener.AggregationListener;
import writenlg.aggregation.AbstractAggregationConcept;
import writenlg.aggregation.ConceptGroup;

/**
 * Performs aggregation in conjunction with document planning, according to constraints
 */
public class Aggregator
{
	private static final Logger LOGGER = LogManager.getLogger("Aggregator.class");

	private final Map<AggregationConcept, AbstractAggregationConcept> aggregationConcepts;

	/**
	 * Creates an Aggregator instance.
	 * 
	 * @param aggregationConcepts
	 */
	public Aggregator(final AggregationConcepts aggregationConcepts)
	{
		this.aggregationConcepts = aggregationConcepts.getAggregationConcepts();

		rationaliseAggregationConcepts(
				loadAggregationConcepts(WriteNlgProperties.getInstance().getProperty("AntlrInputAggregation")));

		LOGGER.info("New Aggregator created");
	}

	private void rationaliseAggregationConcepts(Map<AggregationConcept, ConceptGroup> conceptGroups)
	{
		for (AggregationConcept eachAggregationConcept : conceptGroups.keySet())
		{
			AbstractAggregationConcept concept = this.aggregationConcepts.get(eachAggregationConcept);

			if (concept == null)
			{
				this.aggregationConcepts.put(eachAggregationConcept,
						createAggregationConcept(eachAggregationConcept, conceptGroups.get(eachAggregationConcept)));
			}
			else
			{
				this.aggregationConcepts.get(eachAggregationConcept)
						.addConceptGroup(conceptGroups.get(eachAggregationConcept));
			}
		}
	}

	private AbstractAggregationConcept createAggregationConcept(final AggregationConcept aggregationConcept,
			ConceptGroup conceptGroup)
	{
		switch (aggregationConcept)
		{
			case ALL_INTRODUCTORY_INFORMATION_PRESENT:
				final AbstractAggregationConcept allIntroductoryInformationPresentConcept = new AllIntroductoryInformationPresentConcept();
				allIntroductoryInformationPresentConcept.addConceptGroup(conceptGroup);
				return allIntroductoryInformationPresentConcept;
			case BOTH_SERIES_HAVE_ALL_SEGMENTS_ASCENDING:
				final AbstractAggregationConcept bothSeriesHaveAllSegmentsAscendingConcept = new BothSeriesHaveAllSegmentsAscendingConcept();
				bothSeriesHaveAllSegmentsAscendingConcept.addConceptGroup(conceptGroup);
				return bothSeriesHaveAllSegmentsAscendingConcept;
			case BOTH_SERIES_HAVE_ALL_SEGMENTS_DESCENDING:
				final AbstractAggregationConcept bothSeriesHaveAllSegmentsDescendingConcept = new BothSeriesHaveAllSegmentsDescendingConcept();
				bothSeriesHaveAllSegmentsDescendingConcept.addConceptGroup(conceptGroup);
				return bothSeriesHaveAllSegmentsDescendingConcept;
			case BOTH_SERIES_HAVE_MOST_SEGMENTS_ASCENDING:
				final AbstractAggregationConcept bothSeriesHaveMostSegmentsAscendingConcept = new BothSeriesHaveMostSegmentsAscendingConcept();
				bothSeriesHaveMostSegmentsAscendingConcept.addConceptGroup(conceptGroup);
				return bothSeriesHaveMostSegmentsAscendingConcept;
			case BOTH_SERIES_HAVE_MOST_SEGMENTS_DESCENDING:
				final AbstractAggregationConcept bothSeriesHaveMostSegmentsDescendingConcept = new BothSeriesHaveMostSegmentsDescendingConcept();
				bothSeriesHaveMostSegmentsDescendingConcept.addConceptGroup(conceptGroup);
				return bothSeriesHaveMostSegmentsDescendingConcept;
			case IDENTICAL_TIME_SLICES:
				final AbstractAggregationConcept identicalTimeSlicesConcept = new IdenticalTimeSlicesConcept();
				identicalTimeSlicesConcept.addConceptGroup(conceptGroup);
				return identicalTimeSlicesConcept;
			default:
				LOGGER.error(String.format("%s not implemented", aggregationConcept));
				throw new RuntimeException("Enum value not implemented");
		}
	}

	private Map<AggregationConcept, ConceptGroup> loadAggregationConcepts(final String path)
	{
		final CharStream charStream = new AntlrInputReader(path).getAntlrInputFromFile();
		final LexerParser lexerParser = new AggregationLexerParser(charStream);
		final AggregationListener listener = new AggregationListener();
		lexerParser.walkParseTree(listener);
		return listener.getConceptGroups();
	}

	/**
	 * @return the aggregationConcepts
	 */
	public Map<AggregationConcept, AbstractAggregationConcept> getAggregationConcepts()
	{
		return new HashMap<>(this.aggregationConcepts);
	}
}
