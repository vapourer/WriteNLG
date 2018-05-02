// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.phrase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.linguistics.phrase.partofspeech.Complement;
import analysis.linguistics.phrase.partofspeech.NounPhrase;
import analysis.linguistics.phrase.partofspeech.Verb;

public class Predicate
{
	private static final Logger LOGGER = LogManager.getLogger("Predicate.class");

	private Verb verb;
	private NounPhrase nounPhrase;
	private Complement complement;

	public Predicate()
	{
		LOGGER.info("New Predicate created");
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
}
