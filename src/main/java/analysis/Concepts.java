// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.constrain.ConstraintGroup;
import analysis.constrain.ConstraintType;
import analysis.interfaces.ConceptLoader;
import analysis.linguistics.contentdetermination.concepts.AbstractConcept;
import analysis.linguistics.contentdetermination.concepts.LinesCrossAssessor;
import analysis.linguistics.contentdetermination.concepts.LinesCrossConcept;
import analysis.linguistics.contentdetermination.concepts.LinesCrossMultipleTimesAssessor;
import analysis.linguistics.contentdetermination.concepts.LinesCrossMultipleTimesConcept;
import analysis.linguistics.contentdetermination.concepts.LinesDoNotCrossAssessor;
import analysis.linguistics.contentdetermination.concepts.LinesDoNotCrossConcept;
import analysis.linguistics.contentdetermination.concepts.SeriesLegendAssessor;
import analysis.linguistics.contentdetermination.concepts.SeriesLegendConcept;
import analysis.linguistics.phrase.PhraseSpecification;
import writenlg.substitution.Substitutor;
import writenlg.substitution.TimeSeriesMapping;

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
				final LinesCrossAssessor linesCrossAssessor = new LinesCrossAssessor(this.lineGraph);
				linesCrossAssessor.assessConstraints();
				final ConstraintGroup<ConstraintType> linesCrossConstraints = linesCrossAssessor
						.getLinesCrossConstraints();

				final List<PhraseSpecification> linesCrossPhraseSpecifications = new ArrayList<>();

				for (PhraseSpecification specification : phraseSpecifications)
				{
					linesCrossPhraseSpecifications.add(specification
							.substitutePlaceholders(this.substitutor.getGlobalMappings().getSubstitutions()));
				}

				final LinesCrossConcept linesCrossConcept = new LinesCrossConcept(linesCrossPhraseSpecifications,
						linesCrossConstraints);

				this.globalConcepts.add(linesCrossConcept);
				break;
			case LINES_DO_NOT_CROSS:
				final LinesDoNotCrossAssessor linesDoNotCrossAssessor = new LinesDoNotCrossAssessor(this.lineGraph);
				linesDoNotCrossAssessor.assessConstraints();
				final ConstraintGroup<ConstraintType> linesDoNotCrossConstraints = linesDoNotCrossAssessor
						.getLinesDoNotCrossConstraints();

				final List<PhraseSpecification> linesDoNotCrossPhraseSpecifications = new ArrayList<>();

				for (PhraseSpecification specification : phraseSpecifications)
				{
					linesDoNotCrossPhraseSpecifications.add(specification
							.substitutePlaceholders(this.substitutor.getGlobalMappings().getSubstitutions()));
				}

				final LinesDoNotCrossConcept linesDoNotCrossConcept = new LinesDoNotCrossConcept(
						linesDoNotCrossPhraseSpecifications, linesDoNotCrossConstraints);

				this.globalConcepts.add(linesDoNotCrossConcept);
				break;
			case LINES_CROSS_MULTIPLE_TIMES:
				final LinesCrossMultipleTimesAssessor linesCrossMultipleTimesAssessor = new LinesCrossMultipleTimesAssessor(
						this.lineGraph);
				linesCrossMultipleTimesAssessor.assessConstraints();
				final ConstraintGroup<ConstraintType> linesCrossMultipleTimesConstraints = linesCrossMultipleTimesAssessor
						.getLinesCrossMultipleTimesConstraints();

				final List<PhraseSpecification> linesCrossMultipleTimesPhraseSpecifications = new ArrayList<>();

				for (PhraseSpecification specification : phraseSpecifications)
				{
					linesCrossMultipleTimesPhraseSpecifications.add(specification
							.substitutePlaceholders(this.substitutor.getGlobalMappings().getSubstitutions()));
				}

				final LinesCrossMultipleTimesConcept linesCrossMultipleTimesConcept = new LinesCrossMultipleTimesConcept(
						linesCrossMultipleTimesPhraseSpecifications, linesCrossMultipleTimesConstraints);

				this.globalConcepts.add(linesCrossMultipleTimesConcept);
				break;
			default:
				break;
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

					final SeriesLegendAssessor seriesLegendAssessor = new SeriesLegendAssessor();
					seriesLegendAssessor.assessConstraints();
					final ConstraintGroup<ConstraintType> seriesLegendConstraints = seriesLegendAssessor
							.getSeriesLegendConstraints();

					final List<PhraseSpecification> conceptPhraseSpecifications = new ArrayList<>();

					for (PhraseSpecification specification : phraseSpecifications)
					{
						conceptPhraseSpecifications
								.add(specification.substitutePlaceholders(mapping.getSubstitutions()));
					}

					final SeriesLegendConcept seriesLegendConcept = new SeriesLegendConcept(conceptPhraseSpecifications,
							seriesLegendConstraints);

					this.timeSeriesSpecificConcepts.add(seriesLegendConcept);
				}

				break;
			case DESCENDING_TREND:
				break;
			case MAXIMUM:
				for (TimeSeriesMapping mapping : substitutor.getTimeSeriesMappings())
				{
					LOGGER.info(String.format("Mapping for %s",
							mapping.getTimeSeriesWithDerivedInformation().getSeriesLegend()));

					// final List<PhraseSpecification> conceptPhraseSpecifications = new ArrayList<>();
					//
					// ConstraintGroup<String> maximumConstraints = new SoftConstraintGroup<>(
					// new WeightedAverageConstraintProcessor());
					// Constraint<String> testMaximumConstraint1 = new BoundedWeightedConstraint<>(
					// "Maximum test constraint 1",
					// new SatisfactionLevel(new BigDecimal("0.6"), new BigDecimal("3")), new BigDecimal("0"),
					// new BigDecimal("1"));
					// maximumConstraints.addConstraint(testMaximumConstraint1);
					// Constraint<String> testMaximumConstraint2 = new BoundedWeightedConstraint<>(
					// "Maximum test constraint 2",
					// new SatisfactionLevel(new BigDecimal("0.7"), new BigDecimal("4")), new BigDecimal("0"),
					// new BigDecimal("1"));
					// maximumConstraints.addConstraint(testMaximumConstraint2);
					//
					// for (PhraseSpecification specification : phraseSpecifications)
					// {
					// conceptPhraseSpecifications
					// .add(specification.substitutePlaceholders(mapping.getSubstitutions()));
					// }
					//
					// MaximumConcept maximumConcept = new MaximumConcept(conceptPhraseSpecifications,
					// maximumConstraints);
					//
					// this.timeSeriesSpecificConcepts.add(maximumConcept);
				}

				break;
			case MINIMUM:
				break;
			case RISING_TREND:
				break;
			case TIME_SLICE:
				break;
			default:
				break;
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
