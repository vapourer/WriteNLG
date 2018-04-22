// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.phrase.partofspeech;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.constrain.Constraint;
import analysis.constrain.ConstraintGroup;

/**
 * Represents a noun phrase. Extends AbstractPartOfSpeech, which holds a constraintGroup of type E from which a value
 * can be
 * calculated for a given context.
 */
public class NounPhrase<E> extends AbstractPartOfSpeech<E>
{
	private static final Logger LOGGER = LogManager.getLogger("NounPhrase.class");

	/**
	 * Creates a NounPhrase instance.
	 *
	 * @param text
	 * @param constraintGroup
	 */
	public NounPhrase(final String text, final ConstraintGroup<E> constraintGroup)
	{
		super(text, constraintGroup);

		LOGGER.info("New NounPhrase created: " + getText());

		final Set<? extends Constraint<E>> constraints = getConstraintGroup().getConstraints();

		for (final Constraint<E> constraint : constraints)
		{
			LOGGER.info(String.format("Constraint for %s: %s, with satisfaction level: %s", getText(),
					constraint.getConstrainedElement(), constraint.getSatisfactionLevelAsValue()));
		}
	}
}
