// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.linguistics.phrase.partofspeech;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import writenlg.constrain.Constraint;
import writenlg.constrain.ConstraintGroup;

/**
 * Represents a noun phrase. Extends AbstractPartOfSpeech, which holds a constraintGroup of type E from which a value
 * can be calculated for a given context.
 */
public class NounPhrase extends AbstractPartOfSpeech
{
	private static final Logger LOGGER = LogManager.getLogger("NounPhrase.class");

	/**
	 * Creates a NounPhrase instance.
	 *
	 * @param text
	 * @param constraintGroup
	 */
	public NounPhrase(final String text, final ConstraintGroup<String> constraintGroup)
	{
		super(text, constraintGroup);

		LOGGER.info("New NounPhrase created: " + getText());

		final Set<? extends Constraint<String>> constraints = getConstraintGroup().getConstraints();

		for (final Constraint<String> constraint : constraints)
		{
			LOGGER.info(String.format("Constraint for %s: %s, with satisfaction level: %s", getText(),
					constraint.getConstrainedElement(), constraint.getSatisfactionLevelAsValue()));
		}
	}

	/**
	 * Returns this text with placeholders replaced by analysis derived information.
	 * 
	 * @param regex
	 * @param substitution
	 * @return
	 */
	public NounPhrase replaceAll(String regex, String substitution)
	{
		return new NounPhrase(getText().replaceAll(regex, substitution), this.getConstraintGroup());
	}
}
