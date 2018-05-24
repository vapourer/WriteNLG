// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.simplenlg;

import java.util.HashMap;
import java.util.Map;

import simplenlg.features.Feature;
import simplenlg.features.NumberAgreement;
import simplenlg.features.Tense;
import simplenlg.framework.CoordinatedPhraseElement;
import simplenlg.framework.NLGElement;
import simplenlg.phrasespec.NPPhraseSpec;
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
	private boolean subjectPlural;
	private boolean verbPlural;
	private boolean objectPlural;
	private boolean complementPlural;

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
		String subject = "";
		String additionalSubject = null;

		for (final PartOfSpeech eachPartOfSpeech : this.assignments.keySet())
		{
			switch (eachPartOfSpeech)
			{
				case SUBJECT:
					subject = this.assignments.get(eachPartOfSpeech);
					break;
				case ADDITIONAL_SUBJECT:
					additionalSubject = this.assignments.get(eachPartOfSpeech);
					break;
				case VERB:
					this.specification.setVerb(this.assignments.get(eachPartOfSpeech));

					if (this.verbPlural)
					{
						this.specification.getVerb().setFeature(Feature.NUMBER, NumberAgreement.PLURAL);
					}

					break;
				case OBJECT:
					this.specification.setObject(this.assignments.get(eachPartOfSpeech));

					if (this.objectPlural)
					{
						this.specification.getObject().setFeature(Feature.NUMBER, NumberAgreement.PLURAL);
					}

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

		if (additionalSubject != null)
		{
			NPPhraseSpec subject1 = simpleNlg.createNounPhraseSpecification(subject);
			NPPhraseSpec subject2 = simpleNlg.createNounPhraseSpecification(additionalSubject);
			CoordinatedPhraseElement coordinatedPhraseElement = simpleNlg.createCoordinatedPhraseElement(subject1,
					subject2);
			this.specification.setSubject(coordinatedPhraseElement);
		}
		else
		{
			this.specification.setSubject(subject);
		}

		if (this.subjectPlural)
		{
			this.specification.getSubject().setFeature(Feature.NUMBER, NumberAgreement.PLURAL);
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
	 * @param partOfSpeech
	 * @param expression
	 */
	public void addAssignment(final PartOfSpeech partOfSpeech, final String expression)
	{
		this.assignments.put(partOfSpeech, expression);
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

	/**
	 * @return the subjectPlural
	 */
	public boolean isSubjectPlural()
	{
		return subjectPlural;
	}

	/**
	 * @param subjectPlural
	 *            the subjectPlural to set
	 */
	public void setSubjectPlural(boolean subjectPlural)
	{
		this.subjectPlural = subjectPlural;
	}

	/**
	 * @return the verbPlural
	 */
	public boolean isVerbPlural()
	{
		return verbPlural;
	}

	/**
	 * @param verbPlural
	 *            the verbPlural to set
	 */
	public void setVerbPlural(boolean verbPlural)
	{
		this.verbPlural = verbPlural;
	}

	/**
	 * @return the objectPlural
	 */
	public boolean isObjectPlural()
	{
		return objectPlural;
	}

	/**
	 * @param objectPlural
	 *            the objectPlural to set
	 */
	public void setObjectPlural(boolean objectPlural)
	{
		this.objectPlural = objectPlural;
	}

	/**
	 * @return the complementPlural
	 */
	public boolean isComplementPlural()
	{
		return complementPlural;
	}

	/**
	 * @param complementPlural
	 *            the complementPlural to set
	 */
	public void setComplementPlural(boolean complementPlural)
	{
		this.complementPlural = complementPlural;
	}
}
