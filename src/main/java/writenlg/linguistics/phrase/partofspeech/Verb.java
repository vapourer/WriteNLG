// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.linguistics.phrase.partofspeech;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import writenlg.constrain.Constraint;
import writenlg.constrain.ConstraintGroup;

/**
 * Represents a verb. Extends AbstractPartOfSpeech, which holds a constraintGroup of type E from which a value can be
 * calculated for a given context.
 */
public class Verb extends AbstractPartOfSpeech
{
	private static final Logger LOGGER = LogManager.getLogger("Verb.class");

	/**
	 * Creates a Verb instance.
	 * 
	 * @param text
	 * @param constraintGroup
	 */
	public Verb(final String text, final ConstraintGroup<String> constraintGroup)
	{
		super(text, constraintGroup);

		LOGGER.info("New Verb created: " + getText());

		final Set<? extends Constraint<String>> constraints = getConstraintGroup().getConstraints();

		for (final Constraint<String> constraint : constraints)
		{
			LOGGER.info(String.format("Constraint for %s: %s, with satisfaction level: %s", getText(),
					constraint.getConstrainedElement(), constraint.getSatisfactionLevelAsValue()));
		}
	}
}
