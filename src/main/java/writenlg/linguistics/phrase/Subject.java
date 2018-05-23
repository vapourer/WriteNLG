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
		this.nounPhrase = nounPhrase;
		LOGGER.info(String.format("New Subject created: %s", this.nounPhrase.getText()));
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
	 * Replaces placeholders with values drawn from statistical analysis.
	 * 
	 * @param substitutions
	 */
	public Subject substitutePlaceholders(Map<String, String> substitutions)
	{
		NounPhrase replacement = new NounPhrase(this.nounPhrase.getText(), this.nounPhrase.getConstraintGroup());

		for (final String eachPlaceHolder : substitutions.keySet())
		{
			replacement = replacement.replaceAll(eachPlaceHolder, substitutions.get(eachPlaceHolder));
		}

		replacement.setPlural(this.nounPhrase.isPlural());

		return new Subject(replacement);
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

		return this.nounPhrase.getText().equals(otherSubject.nounPhrase.getText());
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.nounPhrase.getText());
	}
}
