// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.phrase;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.linguistics.phrase.partofspeech.NounPhrase;

public class Subject
{
	private static final Logger LOGGER = LogManager.getLogger("Subject.class");

	private NounPhrase nounPhrase;

	public Subject()
	{
		LOGGER.info("New Subject created");
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

	public void substitutePlaceholders(Map<String, String> substitutions)
	{
		String nounPhaseText = this.nounPhrase.getText();

		for (final String eachPlaceHolder : substitutions.keySet())
		{
			nounPhaseText = nounPhaseText.replaceAll(eachPlaceHolder, substitutions.get(eachPlaceHolder));
		}

		this.nounPhrase = new NounPhrase(nounPhaseText, this.nounPhrase.getConstraintGroup());
	}
}
