package analysis.linguistics.phrase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.linguistics.phrase.partofspeech.NounPhrase;

public class Subject<E>
{
	private static final Logger LOGGER = LogManager.getLogger("Subject.class");

	private NounPhrase<E> nounPhrase;

	public Subject()
	{
		LOGGER.info("New Subject created");
	}

	/**
	 * @return the nounPhrase
	 */
	public NounPhrase<E> getNounPhrase()
	{
		return this.nounPhrase;
	}

	/**
	 * @param nounPhrase
	 *            the nounPhrase to set
	 */
	public void setNounPhrase(final NounPhrase<E> nounPhrase)
	{
		this.nounPhrase = nounPhrase;
		LOGGER.info(String.format("New NounPhrase added: %s", this.nounPhrase.getText()));
	}
}
