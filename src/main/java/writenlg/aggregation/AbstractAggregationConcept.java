// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.aggregation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import analysis.linguistics.contentdetermination.ConstraintType;
import writenlg.AbstractConcept;
import writenlg.constrain.ConstraintGroup;
import writenlg.linguistics.phrase.PhraseSpecification;

/**
 * Abstract class, extensions of which represent time series analysis concepts, for use in an aggregation stage of
 * creating NLG summaries of graphs representing time series.
 */
public abstract class AbstractAggregationConcept extends AbstractConcept
{
	private final Set<ConceptGroup> conceptGroups;

	protected abstract void prepareAggregatedPhraseSpecification();

	protected abstract void assessConstraints();

	private String conjunction;

	public AbstractAggregationConcept(List<PhraseSpecification> phraseSpecifications,
			ConstraintGroup<ConstraintType> constraintGroup)
	{
		super(phraseSpecifications, constraintGroup);
		this.conceptGroups = new HashSet<>();
		this.conjunction = "";
	}

	/**
	 * @param group
	 */
	public void addConceptGroup(final ConceptGroup group)
	{
		this.conceptGroups.add(group);
	}

	public void prepareAggregatedPhraseSpecificationAndAssessConstraints()
	{
		prepareAggregatedPhraseSpecification();
		assessConstraints();
	}

	/**
	 * @return the conjunction
	 */
	public String getConjunction()
	{
		return conjunction;
	}

	/**
	 * @param conjunction
	 *            the conjunction to set
	 */
	public void setConjunction(final String conjunction)
	{
		this.conjunction = conjunction;
	}
}
