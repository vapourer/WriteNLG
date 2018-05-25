// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.aggregation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.CharStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.GlobalConcept;
import analysis.TimeSeriesSpecificConcept;
import analysis.linguistics.aggregation.concepts.AggregateMaximaConcept;
import analysis.linguistics.aggregation.concepts.AggregateMaximumAndMinimumConcept;
import analysis.linguistics.aggregation.concepts.AggregateMinimaConcept;
import analysis.linguistics.aggregation.concepts.AllIntroductoryInformationPresentConcept;
import analysis.linguistics.aggregation.concepts.BothSeriesHaveAllSegmentsAscendingConcept;
import analysis.linguistics.aggregation.concepts.BothSeriesHaveAllSegmentsDescendingConcept;
import analysis.linguistics.aggregation.concepts.BothSeriesHaveMostSegmentsAscendingConcept;
import analysis.linguistics.aggregation.concepts.BothSeriesHaveMostSegmentsDescendingConcept;
import analysis.linguistics.aggregation.concepts.IdenticalTimeSlicesConcept;
import analysis.linguistics.contentdetermination.concepts.DescendingTrendConcept;
import analysis.linguistics.contentdetermination.concepts.LineCountConcept;
import analysis.linguistics.contentdetermination.concepts.LinesCrossConcept;
import analysis.linguistics.contentdetermination.concepts.LinesCrossMultipleTimesConcept;
import analysis.linguistics.contentdetermination.concepts.LinesDoNotCrossConcept;
import analysis.linguistics.contentdetermination.concepts.MaximumConcept;
import analysis.linguistics.contentdetermination.concepts.MinimumConcept;
import analysis.linguistics.contentdetermination.concepts.RisingTrendConcept;
import analysis.linguistics.contentdetermination.concepts.SeriesLegendConcept;
import analysis.linguistics.contentdetermination.concepts.TimeSliceConcept;
import analysis.utilities.GlobalConstants;
import control.WriteNlgProperties;
import io.AntlrInputReader;
import io.LexerParser;
import io.expertinput.AggregationLexerParser;
import io.expertinput.listener.AggregationListener;
import writenlg.AbstractConcept;
import writenlg.aggregation.AbstractAggregationConcept;
import writenlg.aggregation.ConceptGroup;

/**
 * Performs aggregation in conjunction with document planning, according to constraints
 */
public class Aggregator
{
	private static final Logger LOGGER = LogManager.getLogger("Aggregator.class");

	private final List<AbstractConcept> concepts;
	private final Map<AggregationConcept, AbstractAggregationConcept> aggregationConcepts;
	private final Map<GlobalConcept, AbstractConcept> globalConcepts;
	private final Map<TimeSeriesSpecificConcept, List<AbstractConcept>> timeSeriesSpecificConcepts;

	/**
	 * Creates an Aggregator instance.
	 * 
	 * @param aggregationConcepts
	 */
	public Aggregator(final List<AbstractConcept> concepts, final AggregationConcepts aggregationConcepts)
	{
		this.concepts = concepts;
		this.aggregationConcepts = aggregationConcepts.getAggregationConcepts();

		this.globalConcepts = new HashMap<>();
		this.timeSeriesSpecificConcepts = new HashMap<>();

		prepareMapsAndLoadConcepts();

		rationaliseAggregationConcepts(
				loadAggregationConcepts(WriteNlgProperties.getInstance().getProperty("AntlrInputAggregation")));

		processAggregation();

		LOGGER.info("New Aggregator created");

		for (AbstractConcept eachConcept : this.concepts)
		{
			LOGGER.info(String.format("Concept is instance of %s", eachConcept.getClass()));
		}

		for (AggregationConcept eachAggregationConcept : this.aggregationConcepts.keySet())
		{
			LOGGER.info(String.format("Aggregation concept is instance of %s", eachAggregationConcept));
		}
	}

	private void processAggregation()
	{
		processAllIntroductoryInformationPresentConcept();
		processMaximaMinimaAggregationConcepts();
		processIdenticalTimeSlicesConcept();
		processBothSeriesHaveAllSegmentsAscendingConcept();
	}

	private void processAllIntroductoryInformationPresentConcept()
	{
		AllIntroductoryInformationPresentConcept allIntroductoryInformationPresentConcept = (AllIntroductoryInformationPresentConcept) this.aggregationConcepts
				.get(AggregationConcept.ALL_INTRODUCTORY_INFORMATION_PRESENT);

		if (allIntroductoryInformationPresentConcept != null)
		{
			allIntroductoryInformationPresentConcept.setGlobalConcepts(this.globalConcepts);
			allIntroductoryInformationPresentConcept.setTimeSeriesSpecificConcepts(this.timeSeriesSpecificConcepts);

			allIntroductoryInformationPresentConcept.prepareAggregatedPhraseSpecificationAndAssessConstraints();
		}

		int introductoryInformationElementCount = 0;

		if (this.globalConcepts.get(GlobalConcept.LINE_COUNT) != null)
		{
			introductoryInformationElementCount++;
		}

		introductoryInformationElementCount += this.timeSeriesSpecificConcepts
				.get(TimeSeriesSpecificConcept.SERIES_LEGEND).size();

		if (!this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.TIME_SLICE).isEmpty())
		{
			introductoryInformationElementCount++;
		}

		if (allIntroductoryInformationPresentConcept != null && allIntroductoryInformationPresentConcept
				.calculateSatisfactionLevel().compareTo(new BigDecimal(introductoryInformationElementCount)) > 0)
		{
			this.aggregationConcepts.put(AggregationConcept.ALL_INTRODUCTORY_INFORMATION_PRESENT,
					allIntroductoryInformationPresentConcept);
			this.globalConcepts.remove(GlobalConcept.LINE_COUNT);
			this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.SERIES_LEGEND).clear();
			this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.TIME_SLICE).clear();
		}
		else
		{
			this.aggregationConcepts.remove(AggregationConcept.ALL_INTRODUCTORY_INFORMATION_PRESENT);
		}
	}

	private void processIdenticalTimeSlicesConcept()
	{
		IdenticalTimeSlicesConcept identicalTimeSlicesConcept = (IdenticalTimeSlicesConcept) this.aggregationConcepts
				.get(AggregationConcept.IDENTICAL_TIME_SLICES);

		if (identicalTimeSlicesConcept != null)
		{
			identicalTimeSlicesConcept
					.setTimeSliceConcepts(this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.TIME_SLICE));

			identicalTimeSlicesConcept.prepareAggregatedPhraseSpecificationAndAssessConstraints();
		}

		if (identicalTimeSlicesConcept != null
				&& identicalTimeSlicesConcept.calculateSatisfactionLevel().compareTo(GlobalConstants.ONE) == 0)
		{
			this.aggregationConcepts.put(AggregationConcept.IDENTICAL_TIME_SLICES, identicalTimeSlicesConcept);
			this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.TIME_SLICE).clear();
		}
		else
		{
			this.aggregationConcepts.remove(AggregationConcept.IDENTICAL_TIME_SLICES);
		}
	}

	private void processMaximaMinimaAggregationConcepts()
	{
		final AggregateMaximaConcept aggregateMaximaConcept = processAggregateMaximaConcept();
		final AggregateMinimaConcept aggregateMinimaConcept = processAggregateMinimaConcept();
		final AggregateMaximumAndMinimumConcept aggregateMaximumAndMinimumConcept = processAggregateMaximumAndMinimumConcept();

		final BigDecimal aggregateMaximaConceptSatisfactionLevel = calculateSatisfactionLevel(aggregateMaximaConcept);
		final BigDecimal aggregateMinimaConceptSatisfactionLevel = calculateSatisfactionLevel(aggregateMinimaConcept);
		final BigDecimal aggregateMaximumAndMinimumConceptSatisfactionLevel = calculateSatisfactionLevel(
				aggregateMaximumAndMinimumConcept);

		if (aggregateMaximumAndMinimumConceptSatisfactionLevel.compareTo(aggregateMaximaConceptSatisfactionLevel) > 0
				&& aggregateMaximumAndMinimumConceptSatisfactionLevel
						.compareTo(aggregateMinimaConceptSatisfactionLevel) > 0)
		{
			LOGGER.info("Including AggregateMaximumAndMinimumConcept");
			includeAggregateMaximumAndMinimumConcept(aggregateMaximumAndMinimumConcept);
		}
		else
		{
			checkAggregateMaximaAndAggregateMinimaConcepts(aggregateMaximaConcept, aggregateMinimaConcept);
			LOGGER.info("Removing AggregateMaximumAndMinimumConcept");
			this.aggregationConcepts.remove(AggregationConcept.AGGREGATE_MAXIMUM_AND_MINIMUM);
		}
	}

	private void checkAggregateMaximaAndAggregateMinimaConcepts(final AggregateMaximaConcept aggregateMaximaConcept,
			final AggregateMinimaConcept aggregateMinimaConcept)
	{
		if (aggregateMaximaConcept.calculateSatisfactionLevel().compareTo(GlobalConstants.ZERO) > 0)
		{
			includeAggregateMaximaConcept(aggregateMaximaConcept);
		}
		else
		{
			this.aggregationConcepts.remove(AggregationConcept.AGGREGATE_MAXIMA);
		}

		if (aggregateMinimaConcept.calculateSatisfactionLevel().compareTo(GlobalConstants.ZERO) > 0)
		{
			includeAggregateMinimaConcept(aggregateMinimaConcept);
		}
		else
		{
			this.aggregationConcepts.remove(AggregationConcept.AGGREGATE_MINIMA);
		}
	}

	private void includeAggregateMaximaConcept(final AggregateMaximaConcept aggregateMaximaConcept)
	{
		LOGGER.info("Including AggregateMaximaConcept");
		this.aggregationConcepts.put(AggregationConcept.AGGREGATE_MAXIMA, aggregateMaximaConcept);

		this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.MAXIMUM).clear();

		LOGGER.info(String.format("MaximumConcept count: %d",
				this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.MAXIMUM).size()));
	}

	private void includeAggregateMinimaConcept(final AggregateMinimaConcept aggregateMinimaConcept)
	{
		LOGGER.info("Including AggregateMinimaConcept");
		this.aggregationConcepts.put(AggregationConcept.AGGREGATE_MINIMA, aggregateMinimaConcept);

		this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.MINIMUM).clear();
		LOGGER.info(String.format("MinimumConcept count: %d",
				this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.MINIMUM).size()));
	}

	private void includeAggregateMaximumAndMinimumConcept(
			final AggregateMaximumAndMinimumConcept aggregateMaximumAndMinimumConcept)
	{
		this.aggregationConcepts.put(AggregationConcept.AGGREGATE_MAXIMUM_AND_MINIMUM,
				aggregateMaximumAndMinimumConcept);
		this.aggregationConcepts.remove(AggregationConcept.AGGREGATE_MAXIMA);
		this.aggregationConcepts.remove(AggregationConcept.AGGREGATE_MINIMA);
		this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.MAXIMUM).clear();
		this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.MINIMUM).clear();
	}

	private BigDecimal calculateSatisfactionLevel(AbstractAggregationConcept concept)
	{
		if (concept != null)
		{
			return concept.calculateSatisfactionLevel();
		}

		return GlobalConstants.ZERO;
	}

	private AggregateMaximaConcept processAggregateMaximaConcept()
	{
		AggregateMaximaConcept aggregateMaximaConcept = (AggregateMaximaConcept) this.aggregationConcepts
				.get(AggregationConcept.AGGREGATE_MAXIMA);

		if (aggregateMaximaConcept != null)
		{
			aggregateMaximaConcept.setTimeSeriesSpecificConcepts(this.timeSeriesSpecificConcepts);
			aggregateMaximaConcept.prepareAggregatedPhraseSpecificationAndAssessConstraints();
		}

		return aggregateMaximaConcept;
	}

	private AggregateMinimaConcept processAggregateMinimaConcept()
	{
		AggregateMinimaConcept aggregateMinimaConcept = (AggregateMinimaConcept) this.aggregationConcepts
				.get(AggregationConcept.AGGREGATE_MINIMA);

		if (aggregateMinimaConcept != null)
		{
			aggregateMinimaConcept.setTimeSeriesSpecificConcepts(this.timeSeriesSpecificConcepts);
			aggregateMinimaConcept.prepareAggregatedPhraseSpecificationAndAssessConstraints();
		}

		return aggregateMinimaConcept;
	}

	private AggregateMaximumAndMinimumConcept processAggregateMaximumAndMinimumConcept()
	{
		AggregateMaximumAndMinimumConcept aggregateMaximumAndMinimumConcept = (AggregateMaximumAndMinimumConcept) this.aggregationConcepts
				.get(AggregationConcept.AGGREGATE_MAXIMUM_AND_MINIMUM);

		if (aggregateMaximumAndMinimumConcept != null)
		{
			aggregateMaximumAndMinimumConcept.setTimeSeriesSpecificConcepts(this.timeSeriesSpecificConcepts);
			aggregateMaximumAndMinimumConcept.prepareAggregatedPhraseSpecificationAndAssessConstraints();
		}

		return aggregateMaximumAndMinimumConcept;
	}

	private void processBothSeriesHaveAllSegmentsAscendingConcept()
	{
		BothSeriesHaveAllSegmentsAscendingConcept bothSeriesHaveAllSegmentsAscendingConcept = (BothSeriesHaveAllSegmentsAscendingConcept) this.aggregationConcepts
				.get(AggregationConcept.BOTH_SERIES_HAVE_ALL_SEGMENTS_ASCENDING);

		if (bothSeriesHaveAllSegmentsAscendingConcept != null)
		{
			bothSeriesHaveAllSegmentsAscendingConcept.setTimeSeriesSpecificConcepts(this.timeSeriesSpecificConcepts);
			bothSeriesHaveAllSegmentsAscendingConcept.prepareAggregatedPhraseSpecificationAndAssessConstraints();
		}

		final int allSegmentsAscendingCount = this.timeSeriesSpecificConcepts
				.get(TimeSeriesSpecificConcept.RISING_TREND).size();

		if (bothSeriesHaveAllSegmentsAscendingConcept != null && bothSeriesHaveAllSegmentsAscendingConcept
				.calculateSatisfactionLevel().compareTo(new BigDecimal(allSegmentsAscendingCount)) > 0)
		{
			this.aggregationConcepts.put(AggregationConcept.BOTH_SERIES_HAVE_ALL_SEGMENTS_ASCENDING,
					bothSeriesHaveAllSegmentsAscendingConcept);
			this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.RISING_TREND).clear();
			this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.MAXIMUM).clear();
			this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.MINIMUM).clear();
			this.aggregationConcepts.remove(AggregationConcept.AGGREGATE_MAXIMA);
			this.aggregationConcepts.remove(AggregationConcept.AGGREGATE_MINIMA);
			this.aggregationConcepts.remove(AggregationConcept.AGGREGATE_MAXIMUM_AND_MINIMUM);
		}
		else
		{
			this.aggregationConcepts.remove(AggregationConcept.BOTH_SERIES_HAVE_ALL_SEGMENTS_ASCENDING);
		}
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
				final IdenticalTimeSlicesConcept identicalTimeSlicesConcept = new IdenticalTimeSlicesConcept();
				identicalTimeSlicesConcept.addConceptGroup(conceptGroup);
				return identicalTimeSlicesConcept;
			case AGGREGATE_MAXIMA:
				final AggregateMaximaConcept aggregateMaximaConcept = new AggregateMaximaConcept();
				aggregateMaximaConcept.addConceptGroup(conceptGroup);
				return aggregateMaximaConcept;
			case AGGREGATE_MINIMA:
				final AggregateMinimaConcept aggregateMinimaConcept = new AggregateMinimaConcept();
				aggregateMinimaConcept.addConceptGroup(conceptGroup);
				return aggregateMinimaConcept;
			case AGGREGATE_MAXIMUM_AND_MINIMUM:
				final AggregateMaximumAndMinimumConcept aggregateMaximumAndMinimumConcept = new AggregateMaximumAndMinimumConcept();
				aggregateMaximumAndMinimumConcept.addConceptGroup(conceptGroup);
				return aggregateMaximumAndMinimumConcept;
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

	private void prepareMapsAndLoadConcepts()
	{
		loadTimeSeriesSpecificMaps();
		loadConcepts();
	}

	private void loadTimeSeriesSpecificMaps()
	{
		this.timeSeriesSpecificConcepts.put(TimeSeriesSpecificConcept.DESCENDING_TREND, new ArrayList<>());
		this.timeSeriesSpecificConcepts.put(TimeSeriesSpecificConcept.MAXIMUM, new ArrayList<>());
		this.timeSeriesSpecificConcepts.put(TimeSeriesSpecificConcept.MINIMUM, new ArrayList<>());
		this.timeSeriesSpecificConcepts.put(TimeSeriesSpecificConcept.RISING_TREND, new ArrayList<>());
		this.timeSeriesSpecificConcepts.put(TimeSeriesSpecificConcept.SERIES_LEGEND, new ArrayList<>());
		this.timeSeriesSpecificConcepts.put(TimeSeriesSpecificConcept.TIME_SLICE, new ArrayList<>());
	}

	private void loadConcepts()
	{
		for (AbstractConcept eachConcept : this.concepts)
		{
			if (eachConcept instanceof LineCountConcept)
			{
				this.globalConcepts.put(GlobalConcept.LINE_COUNT, eachConcept);
				LOGGER.info(String.format("GlobalConcept added: %s", GlobalConcept.LINE_COUNT));
			}

			if (eachConcept instanceof LinesCrossConcept)
			{
				this.globalConcepts.put(GlobalConcept.LINES_CROSS, eachConcept);
				LOGGER.info(String.format("GlobalConcept added: %s", GlobalConcept.LINES_CROSS));
			}

			if (eachConcept instanceof LinesCrossMultipleTimesConcept)
			{
				this.globalConcepts.put(GlobalConcept.LINES_CROSS_MULTIPLE_TIMES, eachConcept);
				LOGGER.info(String.format("GlobalConcept added: %s", GlobalConcept.LINES_CROSS_MULTIPLE_TIMES));
			}

			if (eachConcept instanceof LinesDoNotCrossConcept)
			{
				this.globalConcepts.put(GlobalConcept.LINES_DO_NOT_CROSS, eachConcept);
				LOGGER.info(String.format("GlobalConcept added: %s", GlobalConcept.LINES_DO_NOT_CROSS));
			}

			if (eachConcept instanceof SeriesLegendConcept)
			{
				this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.SERIES_LEGEND).add(eachConcept);
				LOGGER.info(
						String.format("TimeSeriesSpecificConcept added: %s", TimeSeriesSpecificConcept.SERIES_LEGEND));
			}

			if (eachConcept instanceof DescendingTrendConcept)
			{
				this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.DESCENDING_TREND).add(eachConcept);
				LOGGER.info(String.format("TimeSeriesSpecificConcept added: %s",
						TimeSeriesSpecificConcept.DESCENDING_TREND));
			}

			if (eachConcept instanceof MaximumConcept)
			{
				this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.MAXIMUM).add(eachConcept);
				LOGGER.info(String.format("TimeSeriesSpecificConcept added: %s", TimeSeriesSpecificConcept.MAXIMUM));
			}

			if (eachConcept instanceof MinimumConcept)
			{
				this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.MINIMUM).add(eachConcept);
				LOGGER.info(String.format("TimeSeriesSpecificConcept added: %s", TimeSeriesSpecificConcept.MINIMUM));
			}

			if (eachConcept instanceof RisingTrendConcept)
			{
				this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.RISING_TREND).add(eachConcept);
				LOGGER.info(
						String.format("TimeSeriesSpecificConcept added: %s", TimeSeriesSpecificConcept.RISING_TREND));
			}

			if (eachConcept instanceof TimeSliceConcept)
			{
				this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.TIME_SLICE).add(eachConcept);
				LOGGER.info(String.format("TimeSeriesSpecificConcept added: %s", TimeSeriesSpecificConcept.TIME_SLICE));
			}
		}
	}

	/**
	 * @return the aggregationConcepts
	 */
	public Map<AggregationConcept, AbstractAggregationConcept> getAggregationConcepts()
	{
		return new HashMap<>(this.aggregationConcepts);
	}

	/**
	 * @return the globalConcepts
	 */
	public Map<GlobalConcept, AbstractConcept> getGlobalConcepts()
	{
		return new HashMap<>(this.globalConcepts);
	}

	/**
	 * @return the timeSeriesSpecificConcepts
	 */
	public Map<TimeSeriesSpecificConcept, List<AbstractConcept>> getTimeSeriesSpecificConcepts()
	{
		return new HashMap<>(this.timeSeriesSpecificConcepts);
	}
}
