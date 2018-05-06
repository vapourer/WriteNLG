// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.constrain.BooleanConstraintProcessor;
import analysis.constrain.BoundedWeightedConstraint;
import analysis.constrain.Constraint;
import analysis.constrain.ConstraintGroup;
import analysis.constrain.HardConstraint;
import analysis.constrain.HardConstraintGroup;
import analysis.constrain.SatisfactionLevel;
import analysis.constrain.SoftConstraintGroup;
import analysis.constrain.WeightedAverageConstraintProcessor;
import analysis.interfaces.ConceptLoader;
import analysis.linguistics.contentdetermination.concepts.AbstractConcept;
import analysis.linguistics.contentdetermination.concepts.LinesCrossConcept;
import analysis.linguistics.contentdetermination.concepts.LinesDoNotCrossConcept;
import analysis.linguistics.contentdetermination.concepts.MaximumConcept;
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

	private final Substitutor substitutor;

	private final List<AbstractConcept> globalConcepts;
	private final List<AbstractConcept> timeSeriesSpecificConcepts;

	/**
	 * Creates a new Concepts instance.
	 */
	public Concepts(final Substitutor substitutor)
	{
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
				// ConstraintGroup<String> linesCrossConstraints = new SoftConstraintGroup<>(
				// new WeightedAverageConstraintProcessor());
				ConstraintGroup<String> linesCrossConstraints = new HardConstraintGroup<>(
						new BooleanConstraintProcessor());
				Constraint<String> hardConstraint1 = new HardConstraint<String>("Required",
						new SatisfactionLevel(new BigDecimal("1")));
				linesCrossConstraints.addConstraint(hardConstraint1);
				LinesCrossConcept linesCrossConcept = new LinesCrossConcept(phraseSpecifications,
						linesCrossConstraints);
				this.globalConcepts.add(linesCrossConcept);
				break;
			case LINES_DO_NOT_CROSS:
				// ConstraintGroup<String> linesDoNotCrossConstraints = new SoftConstraintGroup<>(
				// new WeightedAverageConstraintProcessor());
				ConstraintGroup<String> linesDoNotCrossConstraints = new HardConstraintGroup<>(
						new BooleanConstraintProcessor());
				Constraint<String> hardConstraint2 = new HardConstraint<String>("Required",
						new SatisfactionLevel(new BigDecimal("1")));
				linesDoNotCrossConstraints.addConstraint(hardConstraint2);
				LinesDoNotCrossConcept linesDoNotCrossConcept = new LinesDoNotCrossConcept(phraseSpecifications,
						linesDoNotCrossConstraints);
				this.globalConcepts.add(linesDoNotCrossConcept);
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

					final List<PhraseSpecification> conceptPhraseSpecifications = new ArrayList<>();

					ConstraintGroup<String> seriesLegendConstraints = new HardConstraintGroup<>(
							new BooleanConstraintProcessor());
					Constraint<String> requiredSeriesLevelConstraint = new HardConstraint<String>("Required",
							new SatisfactionLevel(new BigDecimal("1")));
					seriesLegendConstraints.addConstraint(requiredSeriesLevelConstraint);

					for (PhraseSpecification specification : phraseSpecifications)
					{
						conceptPhraseSpecifications
								.add(specification.substitutePlaceholders(mapping.getSubstitutions()));
					}

					SeriesLegendConcept seriesLegendConcept = new SeriesLegendConcept(conceptPhraseSpecifications,
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

					final List<PhraseSpecification> conceptPhraseSpecifications = new ArrayList<>();

					ConstraintGroup<String> maximumConstraints = new SoftConstraintGroup<>(
							new WeightedAverageConstraintProcessor());
					Constraint<String> testMaximumConstraint1 = new BoundedWeightedConstraint<>(
							"Maximum test constraint 1",
							new SatisfactionLevel(new BigDecimal("0.6"), new BigDecimal("3")), new BigDecimal("0"),
							new BigDecimal("1"));
					maximumConstraints.addConstraint(testMaximumConstraint1);
					Constraint<String> testMaximumConstraint2 = new BoundedWeightedConstraint<>(
							"Maximum test constraint 2",
							new SatisfactionLevel(new BigDecimal("0.7"), new BigDecimal("4")), new BigDecimal("0"),
							new BigDecimal("1"));
					maximumConstraints.addConstraint(testMaximumConstraint2);

					for (PhraseSpecification specification : phraseSpecifications)
					{
						conceptPhraseSpecifications
								.add(specification.substitutePlaceholders(mapping.getSubstitutions()));
					}

					MaximumConcept maximumConcept = new MaximumConcept(conceptPhraseSpecifications, maximumConstraints);

					this.timeSeriesSpecificConcepts.add(maximumConcept);
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
