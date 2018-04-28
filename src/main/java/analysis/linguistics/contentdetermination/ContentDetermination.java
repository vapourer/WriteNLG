// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.contentdetermination;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import analysis.GlobalConcept;
import analysis.TimeSeriesSpecificConcept;
import analysis.constrain.BooleanConstraintProcessor;
import analysis.constrain.BoundedWeightedConstraint;
import analysis.constrain.Constraint;
import analysis.constrain.ConstraintGroup;
import analysis.constrain.HardConstraint;
import analysis.constrain.HardConstraintGroup;
import analysis.constrain.SatisfactionLevel;
import analysis.constrain.SoftConstraintGroup;
import analysis.constrain.WeightedAverageConstraintProcessor;
import analysis.interfaces.ContentDeterminer;
import analysis.linguistics.contentdetermination.concepts.AbstractConcept;
import analysis.linguistics.contentdetermination.concepts.MaximumConcept;
import analysis.linguistics.contentdetermination.concepts.SeriesLegendConcept;
import analysis.linguistics.phrase.PhraseSpecification;
import writenlg.control.WriteNlgProperties;

/**
 * Determines NLG content derived from time series analysis.
 */
public class ContentDetermination implements ContentDeterminer
{
	private final List<AbstractConcept> globalConcepts;
	private final List<AbstractConcept> timeSeriesSpecificConcepts;
	private int targetConceptCount;
	private BigDecimal constraintThreshold;

	public ContentDetermination()
	{
		this.globalConcepts = new ArrayList<>();
		this.timeSeriesSpecificConcepts = new ArrayList<>();
		this.targetConceptCount = Integer.parseInt(WriteNlgProperties.getInstance().getProperty("TargetConceptCount"));
		this.constraintThreshold = new BigDecimal(
				WriteNlgProperties.getInstance().getProperty("ConceptConstraintThreshold"));
		// this.constraintGuillotine = new BigDecimal("0");
	}

	/**
	 * Creates a new AbstractConcept implementation according to globalConcept, and adds it to this
	 * global concept List.
	 * 
	 * @param globalConcept
	 * @param phraseSpecifications
	 */
	public void addGlobalConcept(GlobalConcept globalConcept, List<PhraseSpecification> phraseSpecifications)
	{
		switch (globalConcept)
		{
			case CONSISTENT_DISTANCE_APART:
				break;
			case LINES_CROSS:
				break;
			case LINES_MEET:
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
			final List<PhraseSpecification> phraseSpecifications, final BigDecimal weighting)
	{
		switch (timeSeriesSpecificConcept)
		{
			case SERIES_LEGEND:
				ConstraintGroup<String> seriesLegendConstraints = new HardConstraintGroup<>(
						new BooleanConstraintProcessor());
				Constraint<String> requiredSeriesLevelConstraint = new HardConstraint<String>("Required",
						new SatisfactionLevel(new BigDecimal("1")));
				seriesLegendConstraints.addConstraint(requiredSeriesLevelConstraint);
				SeriesLegendConcept seriesLegendConcept = new SeriesLegendConcept(phraseSpecifications,
						seriesLegendConstraints);
				timeSeriesSpecificConcepts.add(seriesLegendConcept);
				break;
			case DESCENDING_TREND:
				break;
			case LONGEST_TREND:
				break;
			case MAXIMUM:
				ConstraintGroup<String> maximumConstraints = new SoftConstraintGroup<>(
						new WeightedAverageConstraintProcessor());
				Constraint<String> testMaximumConstraint1 = new BoundedWeightedConstraint<>("Maximum test constraint 1",
						new SatisfactionLevel(new BigDecimal("0.6"), weighting), new BigDecimal("0"),
						new BigDecimal("1"));
				maximumConstraints.addConstraint(testMaximumConstraint1);
				Constraint<String> testMaximumConstraint2 = new BoundedWeightedConstraint<>("Maximum test constraint 2",
						new SatisfactionLevel(new BigDecimal("0.7"), new BigDecimal("4")), new BigDecimal("0"),
						new BigDecimal("1"));
				maximumConstraints.addConstraint(testMaximumConstraint2);
				MaximumConcept maximumConcept = new MaximumConcept(phraseSpecifications, maximumConstraints);
				timeSeriesSpecificConcepts.add(maximumConcept);
				break;
			case MINIMUM:
				break;
			case MULTIPLE_TRENDS:
				break;
			case RISING_TREND:
				break;
			case SPIKES:
				break;
			case TIME_SLICE:
				break;
			case TURNING_POINTS:
				break;
			default:
				break;
		}
	}

	/**
	 * @return the selected timeSeriesSpecificConcepts
	 */
	@Override
	public List<AbstractConcept> getSelectedConcepts()
	{
		return rationaliseConcepts();
	}

	private List<AbstractConcept> rationaliseConcepts()
	{
		List<AbstractConcept> rationalisedConcepts = new ArrayList<>();

		List<AbstractConcept> conceptsCopy = this.timeSeriesSpecificConcepts;
		Collections.sort(conceptsCopy, Collections.reverseOrder(new ConceptSatisfactionLevelComparator()));

		for (AbstractConcept eachConcept : conceptsCopy)
		{
			if (rationalisedConcepts.size() <= this.targetConceptCount
					&& eachConcept.calculateSatisfactionLevel().compareTo(constraintThreshold) >= 0)
			{
				rationalisedConcepts.add(eachConcept);
			}
		}

		return rationalisedConcepts;
	}
}
