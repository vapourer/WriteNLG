package analysis.linguistics.phrase.partofspeech;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import writenlg.constrain.Constraint;
import writenlg.constrain.ConstraintGroup;

/**
 * Represents a complement element of a predicate. Extends AbstractPartOfSpeech, which holds a constraintGroup of type E
 * from which a value
 * can be calculated for a given context.
 */
public class Complement extends AbstractPartOfSpeech
{
	private static final Logger LOGGER = LogManager.getLogger("Complement.class");

	/**
	 * Creates a Complement instance.
	 * 
	 * @param text
	 * @param constraintGroup
	 */
	public Complement(String text, ConstraintGroup<String> constraintGroup)
	{
		super(text, constraintGroup);

		LOGGER.info("New Complement created: " + getText());

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
	public Complement replaceAll(String regex, String substitution)
	{
		return new Complement(getText().replaceAll(regex, substitution), this.getConstraintGroup());
	}
}
