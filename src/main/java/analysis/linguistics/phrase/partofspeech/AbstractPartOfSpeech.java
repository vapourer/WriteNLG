// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.phrase.partofspeech;

import java.math.BigDecimal;

import analysis.constrain.Constraint;
import analysis.constrain.ConstraintGroup;

/**
 * Base class for parts of speech. Has a String representation of the specific part of speech, and holds a
 * constraintGroup of type E from which a value can be calculated for a given context.
 *
 * @param <E>
 */
public abstract class AbstractPartOfSpeech<E>
{
	private final String text;
	private final ConstraintGroup<E> constraintGroup;

	/**
	 * Creates an AbstractPartOfSpeech instance.
	 *
	 * @param text
	 * @param constraintGroup
	 */
	public AbstractPartOfSpeech(final String text, final ConstraintGroup<E> constraintGroup)
	{
		this.text = text;
		this.constraintGroup = constraintGroup;
	}

	/**
	 * @return the text
	 */
	public String getText()
	{
		return this.text;
	}

	/**
	 * Add a constraint for this NounPhrase.
	 *
	 * @param constraint
	 */
	public void addConstraint(final Constraint<E> constraint)
	{
		this.constraintGroup.addConstraint(constraint);
	}

	/**
	 * Calculates the overall satisfaction level for this NounPhrase.
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
	protected ConstraintGroup<E> getConstraintGroup()
	{
		return this.constraintGroup;
	}
}
