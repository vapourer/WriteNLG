// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.contentdetermination.concepts;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import analysis.constrain.Constraint;
import analysis.constrain.ConstraintGroup;
import analysis.constrain.ConstraintType;
import analysis.linguistics.phrase.PhraseSpecification;

/**
 * Abstract class, extensions of which represent time series analysis concepts, for use in NLG summaries of graphs
 * representing time series.
 * 
 * @param <E>
 */
public abstract class AbstractConcept
{
	private final List<PhraseSpecification> phraseSpecifications;
	private final ConstraintGroup<ConstraintType> constraintGroup;

	/**
	 * Creates an AbstractConcept instance.
	 * 
	 * @param constraintGroup
	 */
	public AbstractConcept(final List<PhraseSpecification> phraseSpecifications,
			final ConstraintGroup<ConstraintType> constraintGroup)
	{
		this.phraseSpecifications = phraseSpecifications;
		this.constraintGroup = constraintGroup;
	}

	/**
	 * Add a PhraseSpecification to this PhraseSpecification List.
	 * 
	 * @param specification
	 */
	public void addPhraseSpecification(final PhraseSpecification specification)
	{
		this.phraseSpecifications.add(specification);
	}

	/**
	 * Add a constraint for this concept.
	 *
	 * @param constraint
	 */
	public void addConstraint(final Constraint<ConstraintType> constraint)
	{
		this.constraintGroup.addConstraint(constraint);
	}

	/**
	 * Calculates the overall satisfaction level for this concept.
	 *
	 * @return BigDecimal
	 */
	public BigDecimal calculateSatisfactionLevel()
	{
		return this.constraintGroup.evaluate();
	}

	/**
	 * @return the constraintGroup
	 */
	protected ConstraintGroup<ConstraintType> getConstraintGroup()
	{
		return this.constraintGroup;
	}

	/**
	 * @return the phraseSpecifications
	 */
	public List<PhraseSpecification> getPhraseSpecifications()
	{
		return new ArrayList<>(phraseSpecifications);
	}
}
