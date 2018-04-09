// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.simplenlg;

import java.util.HashMap;
import java.util.Map;

import simplenlg.features.Feature;
import simplenlg.features.Tense;
import simplenlg.framework.NLGElement;
import simplenlg.phrasespec.SPhraseSpec;

/**
 * Represents a simple clause, for use with SimpleNlg.
 */
public class SimpleClause extends Clause
{
	private final Map<PartOfSpeech, String> assignments = new HashMap<>();
	private final SimpleNlg simpleNlg;
	private final SPhraseSpec specification;
	private String complementiser;
	private Tense tense;

	/**
	 * Creates a SimpleClause instance.
	 */
	public SimpleClause()
	{
		this.simpleNlg = SimpleNlg.getInstance();
		this.specification = this.simpleNlg.createClause();
		this.complementiser = "";
		this.tense = Tense.PRESENT;
	}

	/**
	 * Processes this SimpleClause according to its constituent parts of speech.
	 */
	@Override
	public void process()
	{
		for (final PartOfSpeech eachPartOfSpeech : this.assignments.keySet())
		{
			switch (eachPartOfSpeech)
			{
				case SUBJECT:
					this.specification.setSubject(this.assignments.get(eachPartOfSpeech));
					break;
				case VERB:
					this.specification.setVerb(this.assignments.get(eachPartOfSpeech));
					break;
				case OBJECT:
					this.specification.setObject(this.assignments.get(eachPartOfSpeech));
					break;
				case INDIRECT_OBJECT:
					this.specification.setIndirectObject(this.assignments.get(eachPartOfSpeech));
					break;
				case COMPLEMENT:
					this.specification.addComplement(this.assignments.get(eachPartOfSpeech));
					break;
				case MODIFIER:
					this.specification.addModifier(this.assignments.get(eachPartOfSpeech));
					break;
				case ARTICLE:
					this.specification.setDeterminer(this.assignments.get(eachPartOfSpeech));
					break;
				default:
					throw new RuntimeException("Supplied enumeration value has not been implemented");
			}
		}

		if (!this.complementiser.equals(""))
		{
			this.specification.setFeature(Feature.COMPLEMENTISER, this.complementiser);
		}

		this.specification.setFeature(Feature.TENSE, this.tense);
	}

	/**
	 * Realises this SimpleClause.
	 */
	@Override
	public String generate()
	{
		process();
		return this.simpleNlg.realise(this.specification);
	}

	/**
	 * Adds an assignment.
	 * 
	 * @param identifier
	 * @param expression
	 */
	public void addAssignment(final String identifier, final String expression)
	{
		this.assignments.put(identifyPartOfSpeech(identifier), expression);
	}

	/**
	 * Gets the SPhraseSpec for this SimpleClause.
	 * 
	 * @return SPhraseSpec
	 */
	public SPhraseSpec getSpecification()
	{
		return this.specification;
	}

	/**
	 * @return the complementiser for this SimpleClause.
	 */
	public String getComplementiser()
	{
		return this.complementiser;
	}

	/**
	 * @param complementiserValue
	 *            the complementiserValue to set
	 */
	public void setComplementiser(final String complementiserValue)
	{
		this.complementiser = complementiserValue;
	}

	/**
	 * @param tense
	 *            the tense to set
	 */
	public void setTense(final Tense tense)
	{
		this.tense = tense;
	}

	/**
	 * Returns this Specification as an NLGElement
	 */
	@Override
	public NLGElement getAsNLGElement()
	{
		return this.specification;
	}

	private PartOfSpeech identifyPartOfSpeech(final String identifier)
	{
		if ("Subject".equalsIgnoreCase(identifier))
		{
			return PartOfSpeech.SUBJECT;
		}
		else if ("Verb".equalsIgnoreCase(identifier))
		{
			return PartOfSpeech.VERB;
		}
		else if ("Object".equalsIgnoreCase(identifier))
		{
			return PartOfSpeech.OBJECT;
		}
		else if ("IndirectObject".equalsIgnoreCase(identifier))
		{
			return PartOfSpeech.INDIRECT_OBJECT;
		}
		else if ("Complement".equalsIgnoreCase(identifier))
		{
			return PartOfSpeech.COMPLEMENT;
		}
		else if ("Modifier".equalsIgnoreCase(identifier))
		{
			return PartOfSpeech.MODIFIER;
		}
		else if ("Article".equalsIgnoreCase(identifier))
		{
			return PartOfSpeech.ARTICLE;
		}

		throw new IllegalArgumentException(identifier + " is not a recognised identifier.");
	}
}
