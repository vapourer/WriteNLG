// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.simplenlg;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import simplenlg.framework.DocumentElement;
import simplenlg.framework.NLGElement;
import simplenlg.phrasespec.SPhraseSpec;

/**
 * Creates a Sentence instance, and makes available Sentence processing and SimpleNlg realisation.
 */
public class Sentence implements DocumentGenerator
{
	private static final Logger LOGGER = LogManager.getLogger("Sentence.class");

	private DocumentElement sentence;
	private final List<Clause> clauses = new ArrayList<>();
	private String conjunction;
	private String completeSentence;

	/**
	 * Creates a new Sentence instance.
	 */
	public Sentence()
	{
		this.conjunction = "";
	}

	/**
	 * TODO: needs to be two classes.
	 * Processes this Sentence, and calls process on child Clause instances.
	 */
	@Override
	public void process()
	{
		if (this.completeSentence != null && !this.clauses.isEmpty())
		{
			LOGGER.error("Sentence must either be treated as a whole or built from clauses. Cannot be both.");
			throw new RuntimeException(
					"Sentence must either be treated as a whole or built from clauses. Cannot be both.");
		}

		if (!this.clauses.isEmpty())
		{
			for (final Clause eachClause : this.clauses)
			{
				eachClause.process();
			}

			if (this.clauses.size() > 1)
			{
				for (final Clause eachClause : this.clauses)
				{
					if (!"".equals(((SimpleClause) eachClause).getComplementiser()))
					{
						((SPhraseSpec) this.clauses.get(this.clauses.indexOf(eachClause) - 1).getAsNLGElement())
								.addComplement(eachClause.getAsNLGElement());
					}
				}
			}

			this.sentence = SimpleNlg.getInstance().createSentence(this.clauses.get(0).getAsNLGElement());
		}

		if (this.completeSentence != null)
		{
			this.sentence = SimpleNlg.getInstance().createSentence(this.completeSentence);
		}
	}

	/**
	 * Realises this Sentence.
	 */
	@Override
	public String generate()
	{
		process();
		return SimpleNlg.getInstance().realise(this.sentence);
	}

	/**
	 * Adds a clause to this Sentence.
	 * 
	 * @param clause
	 */
	public void addClause(final Clause clause)
	{
		this.clauses.add(clause);
	}

	/**
	 * Returns this Sentence as an NLGElement.
	 * 
	 * @return NLGElement
	 */
	public NLGElement getAsNLGElement()
	{
		return this.sentence;
	}

	/**
	 * Gets the String representing the conjunction associated with this Sentence.
	 * 
	 * @return String
	 */
	public String getConjunction()
	{
		return this.conjunction;
	}

	/**
	 * Sets the conjunction associated with this Sentence.
	 * 
	 * @param conjunction
	 */
	public void setConjunction(final String conjunction)
	{
		this.conjunction = conjunction;
	}

	/**
	 * @param completeSentence
	 *            the completeSentence to set
	 */
	public void setCompleteSentence(String completeSentence)
	{
		this.completeSentence = completeSentence;
	}
}
