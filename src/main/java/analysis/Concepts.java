// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.interfaces.ConceptLoader;
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
import analysis.linguistics.contentdetermination.concepts.TrendConcept;
import analysis.substitution.Substitutor;
import analysis.substitution.TimeSeriesMapping;
import writenlg.AbstractConcept;
import writenlg.linguistics.phrase.PhraseSpecification;

/**
 * Concept collections populated from ANTLR PhraseCreator input.
 */
public class Concepts implements ConceptLoader
{
	private static final Logger LOGGER = LogManager.getLogger("Concepts.class");

	private final LineGraphWithDerivedInformation lineGraph;
	private final Substitutor substitutor;

	private final List<AbstractConcept> globalConcepts;
	private final List<AbstractConcept> timeSeriesSpecificConcepts;

	/**
	 * Creates a new Concepts instance.
	 */
	public Concepts(final LineGraphWithDerivedInformation lineGraph, final Substitutor substitutor)
	{
		this.lineGraph = lineGraph;
		this.substitutor = substitutor;

		this.globalConcepts = new ArrayList<>();
		this.timeSeriesSpecificConcepts = new ArrayList<>();

		LOGGER.info("New Concepts instance created");
		LOGGER.info(String.format("timeSeriesMappings size: %d", substitutor.getTimeSeriesMappings().size()));
	}

	/**
	 * Creates a new AbstractConcept implementation according to globalConcept, and adds it to this
	 * global concept List.
	 * 
	 * @param globalConcept
	 * @param phraseSpecifications
	 */
	@Override
	public void addGlobalConcept(GlobalConcept globalConcept, List<PhraseSpecification> phraseSpecifications)
	{
		switch (globalConcept)
		{
			case LINES_CROSS:
				final List<PhraseSpecification> linesCrossPhraseSpecifications = new ArrayList<>();

				for (PhraseSpecification specification : phraseSpecifications)
				{
					linesCrossPhraseSpecifications.add(specification
							.substitutePlaceholders(this.substitutor.getGlobalMappings().getSubstitutions()));
				}

				final LinesCrossConcept linesCrossConcept = new LinesCrossConcept(linesCrossPhraseSpecifications,
						this.lineGraph);

				this.globalConcepts.add(linesCrossConcept);
				break;
			case LINES_DO_NOT_CROSS:
				final List<PhraseSpecification> linesDoNotCrossPhraseSpecifications = new ArrayList<>();

				for (PhraseSpecification specification : phraseSpecifications)
				{
					linesDoNotCrossPhraseSpecifications.add(specification
							.substitutePlaceholders(this.substitutor.getGlobalMappings().getSubstitutions()));
				}

				final LinesDoNotCrossConcept linesDoNotCrossConcept = new LinesDoNotCrossConcept(
						linesDoNotCrossPhraseSpecifications, this.lineGraph);

				this.globalConcepts.add(linesDoNotCrossConcept);
				break;
			case LINES_CROSS_MULTIPLE_TIMES:
				final List<PhraseSpecification> linesCrossMultipleTimesPhraseSpecifications = new ArrayList<>();

				for (PhraseSpecification specification : phraseSpecifications)
				{
					linesCrossMultipleTimesPhraseSpecifications.add(specification
							.substitutePlaceholders(this.substitutor.getGlobalMappings().getSubstitutions()));
				}

				final LinesCrossMultipleTimesConcept linesCrossMultipleTimesConcept = new LinesCrossMultipleTimesConcept(
						linesCrossMultipleTimesPhraseSpecifications, this.lineGraph);

				this.globalConcepts.add(linesCrossMultipleTimesConcept);
				break;
			case LINE_COUNT:
				final List<PhraseSpecification> lineCountPhraseSpecifications = new ArrayList<>();

				for (PhraseSpecification specification : phraseSpecifications)
				{
					lineCountPhraseSpecifications.add(specification
							.substitutePlaceholders(this.substitutor.getGlobalMappings().getSubstitutions()));
				}

				final LineCountConcept lineCountConcept = new LineCountConcept(lineCountPhraseSpecifications);
				this.globalConcepts.add(lineCountConcept);
				break;
			default:
				LOGGER.error(String.format("%s not implemented", globalConcept));
				throw new RuntimeException("Enum value not implemented");
		}
	}

	/**
	 * Creates a new AbstractConcept implementation according to timeSeriesSpecificConcept, and adds it to this
	 * time series specific List.
	 * 
	 * @param timeSeriesSpecificConcept
	 * @param phraseSpecifications
	 */
	@Override
	public void addTimeSeriesSpecificConcept(final TimeSeriesSpecificConcept timeSeriesSpecificConcept,
			final List<PhraseSpecification> phraseSpecifications)
	{
		switch (timeSeriesSpecificConcept)
		{
			case SERIES_LEGEND:
				for (TimeSeriesMapping mapping : substitutor.getTimeSeriesMappings())
				{
					LOGGER.info(String.format("Mapping for %s",
							mapping.getTimeSeriesWithDerivedInformation().getSeriesLegend()));

					final List<PhraseSpecification> conceptPhraseSpecifications = new ArrayList<>();

					for (PhraseSpecification specification : phraseSpecifications)
					{
						conceptPhraseSpecifications
								.add(specification.substitutePlaceholders(mapping.getSubstitutions()));
					}

					final SeriesLegendConcept seriesLegendConcept = new SeriesLegendConcept(
							conceptPhraseSpecifications);

					this.timeSeriesSpecificConcepts.add(seriesLegendConcept);
				}

				break;
			case MAXIMUM:
				for (TimeSeriesMapping mapping : substitutor.getTimeSeriesMappings())
				{
					LOGGER.info(String.format("Mapping for %s",
							mapping.getTimeSeriesWithDerivedInformation().getSeriesLegend()));

					final List<PhraseSpecification> conceptPhraseSpecifications = new ArrayList<>();

					for (PhraseSpecification specification : phraseSpecifications)
					{
						conceptPhraseSpecifications
								.add(specification.substitutePlaceholders(mapping.getSubstitutions()));
					}

					MaximumConcept maximumConcept = new MaximumConcept(conceptPhraseSpecifications,
							mapping.getTimeSeriesWithDerivedInformation());

					this.timeSeriesSpecificConcepts.add(maximumConcept);
				}

				break;
			case MINIMUM:
				for (TimeSeriesMapping mapping : substitutor.getTimeSeriesMappings())
				{
					LOGGER.info(String.format("Mapping for %s",
							mapping.getTimeSeriesWithDerivedInformation().getSeriesLegend()));

					final List<PhraseSpecification> conceptPhraseSpecifications = new ArrayList<>();

					for (PhraseSpecification specification : phraseSpecifications)
					{
						conceptPhraseSpecifications
								.add(specification.substitutePlaceholders(mapping.getSubstitutions()));
					}

					MinimumConcept minimumConcept = new MinimumConcept(conceptPhraseSpecifications,
							mapping.getTimeSeriesWithDerivedInformation());

					this.timeSeriesSpecificConcepts.add(minimumConcept);
				}

				break;
			case RISING_TREND:
				for (TimeSeriesMapping mapping : substitutor.getTimeSeriesMappings())
				{
					LOGGER.info(String.format("Mapping for %s",
							mapping.getTimeSeriesWithDerivedInformation().getSeriesLegend()));

					final List<PhraseSpecification> conceptPhraseSpecifications = new ArrayList<>();

					for (PhraseSpecification specification : phraseSpecifications)
					{
						conceptPhraseSpecifications
								.add(specification.substitutePlaceholders(mapping.getSubstitutions()));
					}

					final RisingTrendConcept risingTrendConcept = new RisingTrendConcept(conceptPhraseSpecifications,
							mapping.getTimeSeriesWithDerivedInformation());

					this.timeSeriesSpecificConcepts.add(risingTrendConcept);
				}
				break;
			case DESCENDING_TREND:
				for (TimeSeriesMapping mapping : substitutor.getTimeSeriesMappings())
				{
					LOGGER.info(String.format("Mapping for %s",
							mapping.getTimeSeriesWithDerivedInformation().getSeriesLegend()));

					final List<PhraseSpecification> conceptPhraseSpecifications = new ArrayList<>();

					for (PhraseSpecification specification : phraseSpecifications)
					{
						conceptPhraseSpecifications
								.add(specification.substitutePlaceholders(mapping.getSubstitutions()));
					}

					final DescendingTrendConcept descendingTrendConcept = new DescendingTrendConcept(
							conceptPhraseSpecifications, mapping.getTimeSeriesWithDerivedInformation());

					this.timeSeriesSpecificConcepts.add(descendingTrendConcept);
				}
				break;
			case TIME_SLICE:
				for (TimeSeriesMapping mapping : substitutor.getTimeSeriesMappings())
				{
					LOGGER.info(String.format("Mapping for %s",
							mapping.getTimeSeriesWithDerivedInformation().getSeriesLegend()));

					final List<PhraseSpecification> conceptPhraseSpecifications = new ArrayList<>();

					for (PhraseSpecification specification : phraseSpecifications)
					{
						conceptPhraseSpecifications
								.add(specification.substitutePlaceholders(mapping.getSubstitutions()));
					}

					final TimeSliceConcept timeSliceConcept = new TimeSliceConcept(conceptPhraseSpecifications);

					this.timeSeriesSpecificConcepts.add(timeSliceConcept);
				}
				break;
			case TREND:
				for (TimeSeriesMapping mapping : substitutor.getTimeSeriesMappings())
				{
					LOGGER.info(String.format("Mapping for %s",
							mapping.getTimeSeriesWithDerivedInformation().getSeriesLegend()));

					final int smoothedSegmentCount = mapping.getTimeSeriesWithDerivedInformation().getSmoothedSegments()
							.size();
					final int outlineSegmentCount = mapping.getTimeSeriesWithDerivedInformation().getOutlineSegments()
							.size();

					LOGGER.info(String.format("smoothedSegmentCount: %d; outlineSegmentCount: %d", smoothedSegmentCount,
							outlineSegmentCount));

					final int segmentCount = outlineSegmentCount < smoothedSegmentCount ? outlineSegmentCount
							: smoothedSegmentCount;

					for (int i = phraseSpecifications.size(); i > segmentCount; i--)
					{
						phraseSpecifications.remove(i - 1);
					}

					final List<PhraseSpecification> conceptPhraseSpecifications = new ArrayList<>();

					for (PhraseSpecification specification : phraseSpecifications)
					{
						conceptPhraseSpecifications
								.add(specification.substitutePlaceholders(mapping.getSubstitutions()));
					}

					final TrendConcept trendConcept = new TrendConcept(conceptPhraseSpecifications,
							mapping.getTimeSeriesWithDerivedInformation());

					this.timeSeriesSpecificConcepts.add(trendConcept);
				}
				break;
			case TURNING_POINTS:
				// for (TimeSeriesMapping mapping : substitutor.getTimeSeriesMappings())
				// {
				// LOGGER.info(String.format("Mapping for %s",
				// mapping.getTimeSeriesWithDerivedInformation().getSeriesLegend()));
				//
				// final List<PhraseSpecification> conceptPhraseSpecifications = new ArrayList<>();
				//
				// for (PhraseSpecification specification : phraseSpecifications)
				// {
				// conceptPhraseSpecifications
				// .add(specification.substitutePlaceholders(mapping.getSubstitutions()));
				// }
				//
				// final TurningPointsConcept turningPointsConcept = new TurningPointsConcept(
				// conceptPhraseSpecifications);
				//
				// this.timeSeriesSpecificConcepts.add(turningPointsConcept);
				// }
				break;
			default:
				LOGGER.error(String.format("%s not implemented", timeSeriesSpecificConcept));
				throw new RuntimeException("Enum value not implemented");
		}
	}

	/**
	 * @return the globalConcepts
	 */
	@Override
	public List<AbstractConcept> getGlobalConcepts()
	{
		return new ArrayList<>(globalConcepts);
	}

	/**
	 * @return the timeSeriesSpecificConcepts
	 */
	@Override
	public List<AbstractConcept> getTimeSeriesSpecificConcepts()
	{
		return new ArrayList<>(timeSeriesSpecificConcepts);
	}
}
