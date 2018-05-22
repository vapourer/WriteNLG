// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.linguistics.phrase;

import java.util.Map;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import writenlg.linguistics.phrase.partofspeech.Complement;
import writenlg.linguistics.phrase.partofspeech.NounPhrase;
import writenlg.linguistics.phrase.partofspeech.Verb;

/**
 * Represents the predicate component of a sentence.
 */
public class Predicate
{
	private static final Logger LOGGER = LogManager.getLogger("Predicate.class");

	private Verb verb;
	private NounPhrase nounPhrase;
	private Complement complement;

	/**
	 * Creates a new Predicate instance.
	 */
	public Predicate()
	{
		LOGGER.info("New Predicate created");
	}

	/**
	 * Creates a new Predicate instance.
	 * 
	 * @param verb
	 * @param nounPhrase
	 * @param complement
	 */
	public Predicate(final Verb verb, final NounPhrase nounPhrase, final Complement complement)
	{
		this.verb = verb;
		this.nounPhrase = nounPhrase;
		this.complement = complement;

		LOGGER.info(String.format("New Predicate created: verb = %s; nounPhrase = %s; complement = %s", this.verb,
				this.nounPhrase, this.complement));
	}

	/**
	 * @return the verb
	 */
	public Verb getVerb()
	{
		return this.verb;
	}

	/**
	 * @param verb
	 *            the verb to set
	 */
	public void setVerb(final Verb verb)
	{
		this.verb = verb;
		LOGGER.info(String.format("New Verb added: %s", this.verb.getText()));
	}

	/**
	 * @return the nounPhrase
	 */
	public NounPhrase getNounPhrase()
	{
		return this.nounPhrase;
	}

	/**
	 * @param nounPhrase
	 *            the nounPhrase to set
	 */
	public void setNounPhrase(final NounPhrase nounPhrase)
	{
		this.nounPhrase = nounPhrase;
		LOGGER.info(String.format("New NounPhrase added: %s", this.nounPhrase.getText()));
	}

	/**
	 * @return the complement
	 */
	public Complement getComplement()
	{
		return complement;
	}

	/**
	 * @param complement
	 *            the complement to set
	 */
	public void setComplement(Complement complement)
	{
		this.complement = complement;
		LOGGER.info(String.format("New Complement added: %s", this.complement.getText()));
	}

	/**
	 * Replaces placeholders with values drawn from statistical analysis.
	 * 
	 * @param substitutions
	 */
	public Predicate substitutePlaceholders(Map<String, String> substitutions)
	{
		NounPhrase replacementNounPhrase = null;
		Complement replacementComplement = null;

		if (this.nounPhrase != null)
		{
			replacementNounPhrase = new NounPhrase(this.nounPhrase.getText(), this.nounPhrase.getConstraintGroup());

			for (final String eachPlaceHolder : substitutions.keySet())
			{
				replacementNounPhrase = replacementNounPhrase.replaceAll(eachPlaceHolder,
						substitutions.get(eachPlaceHolder));
			}
		}

		if (this.complement != null)
		{
			replacementComplement = new Complement(this.complement.getText(), this.complement.getConstraintGroup());

			for (final String eachPlaceHolder : substitutions.keySet())
			{
				replacementComplement = replacementComplement.replaceAll(eachPlaceHolder,
						substitutions.get(eachPlaceHolder));
			}
		}

		return new Predicate(this.verb, replacementNounPhrase, replacementComplement);
	}

	@Override
	public boolean equals(Object object)
	{
		if (this == object)
		{
			return true;
		}

		if (object == null)
		{
			return false;
		}

		if (!(object instanceof Predicate))
		{
			return false;
		}

		Predicate otherPredicate = (Predicate) object;

		return this.verb.getText().equals(otherPredicate.verb.getText()) && this.nounPhrase == null
				? otherPredicate.nounPhrase == null
				: this.nounPhrase.getText().equals(otherPredicate.nounPhrase.getText()) && this.complement == null
						? otherPredicate.complement == null
						: this.complement.getText().equals(otherPredicate.complement.getText());
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.verb.getText(), this.nounPhrase.getText(), this.complement.getText());
	}
}
