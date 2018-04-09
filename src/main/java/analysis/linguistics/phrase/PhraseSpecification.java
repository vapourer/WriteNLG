// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.phrase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PhraseSpecification
{
	private static final Logger LOGGER = LogManager.getLogger("PhraseSpecification.class");

	private Subject<String> subject;
	private Predicate<String> predicate;

	public PhraseSpecification()
	{
		LOGGER.info("New PhraseSpecification created");
	}

	/**
	 * @return the subject
	 */
	public Subject<String> getSubject()
	{
		return this.subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(final Subject<String> subject)
	{
		this.subject = subject;
	}

	/**
	 * @return the predicate
	 */
	public Predicate<String> getPredicate()
	{
		return this.predicate;
	}

	/**
	 * @param predicate
	 *            the predicate to set
	 */
	public void setPredicate(final Predicate<String> predicate)
	{
		this.predicate = predicate;
	}
}
