// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.phrase;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PhraseSpecification
{
	private static final Logger LOGGER = LogManager.getLogger("PhraseSpecification.class");

	private Subject subject;
	private Predicate predicate;

	public PhraseSpecification()
	{
		LOGGER.info("New PhraseSpecification created");
	}

	/**
	 * @return the subject
	 */
	public Subject getSubject()
	{
		return this.subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(final Subject subject)
	{
		this.subject = subject;
	}

	/**
	 * @return the predicate
	 */
	public Predicate getPredicate()
	{
		return this.predicate;
	}

	/**
	 * @param predicate
	 *            the predicate to set
	 */
	public void setPredicate(final Predicate predicate)
	{
		this.predicate = predicate;
	}

	/**
	 * Replaces placeholders with values drawn from statistical analysis.
	 * 
	 * @param substitutions
	 */
	public void substitutePlaceholders(Map<String, String> substitutions)
	{
		this.subject.substitutePlaceholders(substitutions);
		this.predicate.substitutePlaceholders(substitutions);
	}
}
