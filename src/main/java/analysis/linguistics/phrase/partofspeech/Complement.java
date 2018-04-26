package analysis.linguistics.phrase.partofspeech;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.constrain.Constraint;
import analysis.constrain.ConstraintGroup;

/**
 * Represents a complement element of a predicate. Extends AbstractPartOfSpeech, which holds a constraintGroup of type E
 * from which a value
 * can be calculated for a given context.
 */
public class Complement<E> extends AbstractPartOfSpeech<E>
{
	private static final Logger LOGGER = LogManager.getLogger("Complement.class");

	/**
	 * Creates a Complement instance.
	 * 
	 * @param text
	 * @param constraintGroup
	 */
	public Complement(String text, ConstraintGroup<E> constraintGroup)
	{
		super(text, constraintGroup);

		LOGGER.info("New Verb created: " + getText());

		final Set<? extends Constraint<E>> constraints = getConstraintGroup().getConstraints();

		for (final Constraint<E> constraint : constraints)
		{
			LOGGER.info(String.format("Constraint for %s: %s, with satisfaction level: %s", getText(),
					constraint.getConstrainedElement(), constraint.getSatisfactionLevelAsValue()));
		}
	}
}
