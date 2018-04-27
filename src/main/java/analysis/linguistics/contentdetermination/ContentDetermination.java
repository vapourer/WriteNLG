// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.contentdetermination;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import analysis.Concept;
import analysis.constrain.BooleanConstraintProcessor;
import analysis.constrain.Constraint;
import analysis.constrain.ConstraintGroup;
import analysis.constrain.HardConstraint;
import analysis.constrain.HardConstraintGroup;
import analysis.constrain.SatisfactionLevel;
import analysis.interfaces.ContentDeterminer;
import analysis.linguistics.contentdetermination.concepts.AbstractConcept;
import analysis.linguistics.contentdetermination.concepts.SeriesLegend;
import analysis.linguistics.phrase.PhraseSpecification;
import writenlg.control.WriteNlgProperties;

/**
 * Determines NLG content derived from time series analysis.
 */
public class ContentDetermination implements ContentDeterminer
{
	private final List<AbstractConcept> concepts;
	private int targetConceptCount;
	private BigDecimal constraintGuillotine;

	public ContentDetermination()
	{
		this.concepts = new ArrayList<>();
		this.targetConceptCount = Integer.parseInt(WriteNlgProperties.getInstance().getProperty("TargetConceptCount"));
		this.constraintGuillotine = new BigDecimal(
				WriteNlgProperties.getInstance().getProperty("ConceptConstraintGuillotine"));
	}

	/**
	 * Creates a new AbstractConcept implementation according to concept, and adds it to this AbstractConcept List.
	 * 
	 * @param concept
	 * @param phraseSpecifications
	 */
	@Override
	public void addConcept(Concept concept, List<PhraseSpecification> phraseSpecifications)
	{
		switch (concept)
		{
			case SERIES_LEGEND:
				ConstraintGroup<String> constraints = new HardConstraintGroup<>(new BooleanConstraintProcessor());
				Constraint<String> requiredConstraint = new HardConstraint<String>("Required",
						new SatisfactionLevel(new BigDecimal("1")));
				constraints.addConstraint(requiredConstraint);
				SeriesLegend seriesLegend = new SeriesLegend(phraseSpecifications, constraints);
				concepts.add(seriesLegend);
				break;
			case DESCENDING_TREND:
				break;
			case LINES_CROSS:
				break;
			case LONGEST_TREND:
				break;
			case MAXIMUM:
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
	 * @return the selected concepts
	 */
	@Override
	public List<AbstractConcept> getSelectedConcepts()
	{
		return rationaliseConcepts();
	}

	private List<AbstractConcept> rationaliseConcepts()
	{
		List<AbstractConcept> rationalisedConcepts = new ArrayList<>();

		List<AbstractConcept> conceptsCopy = this.concepts;
		Collections.sort(conceptsCopy, Collections.reverseOrder(new ConceptSatisfactionLevelComparator()));

		for (AbstractConcept eachConcept : conceptsCopy)
		{
			if (rationalisedConcepts.size() <= this.targetConceptCount
					&& eachConcept.calculateSatisfactionLevel().compareTo(constraintGuillotine) >= 0)
			{
				rationalisedConcepts.add(eachConcept);
			}
		}

		return rationalisedConcepts;
	}
}
