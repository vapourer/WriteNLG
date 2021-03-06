// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.linguistics.phrase.partofspeech;

import java.math.BigDecimal;

import writenlg.constrain.Constraint;
import writenlg.constrain.ConstraintGroup;

/**
 * Base class for parts of speech. Has a String representation of the specific part of speech, and holds a
 * constraintGroup of type E from which a value can be calculated for a given context.
 *
 * @param <E>
 */
public abstract class AbstractPartOfSpeech
{
	private final String text;
	private final ConstraintGroup<String> constraintGroup;

	/**
	 * Creates an AbstractPartOfSpeech instance.
	 *
	 * @param text
	 * @param constraintGroup
	 */
	public AbstractPartOfSpeech(final String text, final ConstraintGroup<String> constraintGroup)
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

	@Override
	public String toString()
	{
		return this.text;
	}

	/**
	 * Add a constraint for this part of speech.
	 *
	 * @param constraint
	 */
	public void addConstraint(final Constraint<String> constraint)
	{
		this.constraintGroup.addConstraint(constraint);
	}

	/**
	 * Calculates the overall satisfaction level for this part of speech.
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
	public ConstraintGroup<String> getConstraintGroup()
	{
		return this.constraintGroup;
	}
}
