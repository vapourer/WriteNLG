// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.linguistics.phrase;

import java.util.Map;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import writenlg.linguistics.phrase.partofspeech.NounPhrase;

/**
 * Represents the subject component of a sentence.
 */
public class Subject
{
	private static final Logger LOGGER = LogManager.getLogger("Subject.class");

	private NounPhrase nounPhrase;
	private NounPhrase additionalNounPhrase;

	/**
	 * Creates a new Subject instance.
	 */
	public Subject()
	{
		LOGGER.info("New Subject created");
	}

	/**
	 * Creates a new Subject instance.
	 * 
	 * @param nounPhrase
	 */
	public Subject(final NounPhrase nounPhrase)
	{
		this();
		this.nounPhrase = nounPhrase;
		LOGGER.info(String.format("New Subject created: %s", this.nounPhrase.getText()));
	}

	/**
	 * Creates a new Subject instance.
	 * 
	 * @param nounPhrase
	 * @param additionalNounPhrase
	 */
	public Subject(final NounPhrase nounPhrase, final NounPhrase additionalNounPhrase)
	{
		this(nounPhrase);
		this.additionalNounPhrase = additionalNounPhrase;
	}

	/**
	 * For multiple subjects, or for use in a subordinate clause.
	 * 
	 * @param nounPhrase
	 */
	public void addAdditionalNounPhrase(final NounPhrase nounPhrase)
	{
		this.additionalNounPhrase = nounPhrase;
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
	 * @return the additionalNounPhrases
	 */
	public NounPhrase getAdditionalNounPhrase()
	{
		return this.additionalNounPhrase;
	}

	/**
	 * Replaces placeholders with values drawn from statistical analysis.
	 * 
	 * @param substitutions
	 */
	public Subject substitutePlaceholders(Map<String, String> substitutions)
	{
		final NounPhrase replacementNounPhrase = substitutePlaceholdersInNounPhrase(this.nounPhrase, substitutions);

		if (this.additionalNounPhrase != null)
		{
			final NounPhrase replacementAdditionalNounPhrase = substitutePlaceholdersInNounPhrase(
					this.additionalNounPhrase, substitutions);

			return new Subject(replacementNounPhrase, replacementAdditionalNounPhrase);
		}

		return new Subject(replacementNounPhrase);
	}

	private NounPhrase substitutePlaceholdersInNounPhrase(NounPhrase nounPhrase, Map<String, String> substitutions)
	{
		NounPhrase replacement = new NounPhrase(nounPhrase.getText(), nounPhrase.getConstraintGroup());

		for (final String eachPlaceHolder : substitutions.keySet())
		{
			replacement = replacement.replaceAll(eachPlaceHolder, substitutions.get(eachPlaceHolder));
		}

		replacement.setPlural(this.nounPhrase.isPlural());

		return replacement;
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

		if (!(object instanceof Subject))
		{
			return false;
		}

		Subject otherSubject = (Subject) object;

		return this.nounPhrase.getText().equals(otherSubject.nounPhrase.getText())
				&& ((this.additionalNounPhrase == null && otherSubject.additionalNounPhrase == null)
						|| (this.additionalNounPhrase.getText().equals(otherSubject.additionalNounPhrase.getText())));
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.nounPhrase.getText(), this.additionalNounPhrase.getText());
	}
}
