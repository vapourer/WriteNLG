// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package io.expertinput.listener;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.Concepts;
import analysis.GlobalConcept;
import analysis.LineGraphWithDerivedInformation;
import analysis.TimeSeriesSpecificConcept;
import analysis.interfaces.ConceptLoader;
import analysis.linguistics.aggregation.AggregationConcept;
import analysis.linguistics.aggregation.AggregationConcepts;
import analysis.substitution.Substitutor;
import io.antlrgenerated.PhraseCreatorBaseListener;
import io.antlrgenerated.PhraseCreatorParser;
import writenlg.constrain.ConstraintGroup;
import writenlg.constrain.SoftConstraintGroup;
import writenlg.constrain.WeightedAdditionConstraintProcessor;
import writenlg.linguistics.phrase.PhraseSpecification;
import writenlg.linguistics.phrase.Predicate;
import writenlg.linguistics.phrase.SentencePart;
import writenlg.linguistics.phrase.Subject;
import writenlg.linguistics.phrase.partofspeech.Complement;
import writenlg.linguistics.phrase.partofspeech.NounPhrase;
import writenlg.linguistics.phrase.partofspeech.PartOfSpeech;
import writenlg.linguistics.phrase.partofspeech.Verb;

/**
 * PhraseCreatorBaseListener overrides specific to PhraseCreator.
 */
public class PhraseCreatorListener extends PhraseCreatorBaseListener
{
	private static final Logger LOGGER = LogManager.getLogger("PhraseCreatorListener.class");

	private final String PLURAL = "plural";

	private final ConceptLoader concepts;
	private final AggregationConcepts aggregationConcepts;

	private GlobalConcept globalConcept;
	private TimeSeriesSpecificConcept timeSeriesSpecificConcept;
	private AggregationConcept aggregationConcept;
	private List<PhraseSpecification> phraseSpecifications;
	private PhraseSpecification phraseSpecification;
	private SentencePart sentencePart;
	private Subject subject;
	private Predicate predicate;
	private String complement;
	private ConstraintGroup<String> complementConstraintGroup;
	private boolean isSubjectPlural;
	private boolean isVerbPlural;
	private boolean isObjectPlural;
	private boolean isComplementPlural;

	/**
	 * Creates a PhraseCreator instance.
	 * 
	 * @param substitutor
	 */
	public PhraseCreatorListener(final LineGraphWithDerivedInformation lineGraph, final Substitutor substitutor)
	{
		this.phraseSpecifications = new ArrayList<>();
		this.sentencePart = SentencePart.SUBJECT;
		this.concepts = new Concepts(lineGraph, substitutor);
		this.aggregationConcepts = new AggregationConcepts(substitutor);
	}

	@Override
	public void enterGlobalConcept(PhraseCreatorParser.GlobalConceptContext context)
	{
		this.globalConcept = Enum.valueOf(GlobalConcept.class, context.globalConceptType().getText());
		LOGGER.info(String.format("GlobalConcept: %s", this.globalConcept));
	}

	@Override
	public void exitGlobalConcept(PhraseCreatorParser.GlobalConceptContext context)
	{
		this.concepts.addGlobalConcept(this.globalConcept, this.phraseSpecifications);
		this.phraseSpecifications = new ArrayList<>();
	}

	@Override
	public void enterTimeSeriesConcept(PhraseCreatorParser.TimeSeriesConceptContext context)
	{
		this.timeSeriesSpecificConcept = Enum.valueOf(TimeSeriesSpecificConcept.class,
				context.timeSeriesConceptType().getText());
		LOGGER.info(String.format("TimeSeriesSpecificConcept: %s", this.timeSeriesSpecificConcept));
	}

	@Override
	public void exitTimeSeriesConcept(PhraseCreatorParser.TimeSeriesConceptContext context)
	{
		this.concepts.addTimeSeriesSpecificConcept(this.timeSeriesSpecificConcept, this.phraseSpecifications);
		this.phraseSpecifications = new ArrayList<>();
	}

	@Override
	public void enterAggregationConcept(PhraseCreatorParser.AggregationConceptContext context)
	{
		this.aggregationConcept = Enum.valueOf(AggregationConcept.class, context.aggregationConceptType().getText());
		LOGGER.info(String.format("AggregationConcept: %s", this.aggregationConcept));
	}

	@Override
	public void exitAggregationConcept(PhraseCreatorParser.AggregationConceptContext context)
	{
		this.aggregationConcepts.addAggregationConcept(this.aggregationConcept, this.phraseSpecifications);
		this.phraseSpecifications = new ArrayList<>();
	}

	@Override
	public void enterPhraseSpecification(final PhraseCreatorParser.PhraseSpecificationContext context)
	{
		this.phraseSpecification = new PhraseSpecification();
		LOGGER.info("New PhraseSpecification created");
	}

	@Override
	public void exitPhraseSpecification(final PhraseCreatorParser.PhraseSpecificationContext context)
	{
		if (this.complement != null)
		{
			this.predicate.setComplement(new Complement(this.complement, this.complementConstraintGroup));
			this.predicate.getComplement().setPlural(this.isComplementPlural);
			LOGGER.info(String.format("New Complement added to Predicate: %s; plural: %s", this.complement,
					this.isComplementPlural));
		}

		this.phraseSpecification.setSubject(this.subject);
		this.phraseSpecification.setPredicate(this.predicate);
		this.phraseSpecifications.add(this.phraseSpecification);

		this.isSubjectPlural = false;
		this.isVerbPlural = false;
		this.isObjectPlural = false;
		this.isComplementPlural = false;

		this.complement = null;
		this.complementConstraintGroup = null;

		this.phraseSpecification = new PhraseSpecification();
	}

	@Override
	public void enterSubject(final PhraseCreatorParser.SubjectContext context)
	{
		this.subject = new Subject();
		this.sentencePart = SentencePart.SUBJECT;
		LOGGER.info("New Subject created");
	}

	@Override
	public void enterPredicate(final PhraseCreatorParser.PredicateContext context)
	{
		this.predicate = new Predicate();
		this.sentencePart = SentencePart.PREDICATE;
		LOGGER.info("New Predicate created");
	}

	@Override
	public void exitAssignment(final PhraseCreatorParser.AssignmentContext context)
	{
		final ConstraintGroup<String> constraintGroup = new SoftConstraintGroup<>(
				new WeightedAdditionConstraintProcessor());

		final String expression = context.expression().getText();
		final PartOfSpeech partOfSpeech = Enum.valueOf(PartOfSpeech.class, context.identifier().getText());

		switch (this.sentencePart)
		{
			case SUBJECT:
				setPartOfSpeechToSubject(partOfSpeech, expression, constraintGroup);
				break;
			case PREDICATE:
				setPartOfSpeechToPredicate(partOfSpeech, expression, constraintGroup);
				break;
		}
	}

	@Override
	public void enterSubjectNumber(PhraseCreatorParser.SubjectNumberContext context)
	{
		LOGGER.info(String.format("SubjectNumber: %s", context.numberValue().getText()));
		this.isSubjectPlural = PLURAL.equals(context.numberValue().getText()) ? true : false;
	}

	@Override
	public void enterVerbNumber(PhraseCreatorParser.VerbNumberContext context)
	{
		LOGGER.info(String.format("VerbNumber: %s", context.numberValue().getText()));
		this.isVerbPlural = PLURAL.equals(context.numberValue().getText()) ? true : false;
	}

	@Override
	public void enterObjectNumber(PhraseCreatorParser.ObjectNumberContext context)
	{
		LOGGER.info(String.format("ObjectNumber: %s", context.numberValue().getText()));
		this.isObjectPlural = PLURAL.equals(context.numberValue().getText()) ? true : false;
	}

	@Override
	public void enterComplementNumber(PhraseCreatorParser.ComplementNumberContext context)
	{
		LOGGER.info(String.format("ComplementNumber: %s", context.numberValue().getText()));
		this.isComplementPlural = PLURAL.equals(context.numberValue().getText()) ? true : false;
	}

	private void setPartOfSpeechToSubject(final PartOfSpeech partOfSpeech, final String expression,
			final ConstraintGroup<String> constraintGroup)
	{
		switch (partOfSpeech)
		{
			case NOUN:
				this.subject.setNounPhrase(new NounPhrase(expression, constraintGroup));
				this.subject.getNounPhrase().setPlural(this.isSubjectPlural);
				LOGGER.info(String.format("New NounPhrase added to Subject: %s; plural: %s", expression,
						this.isSubjectPlural));
				break;
			case ADDITIONAL_NOUN:
				this.subject.addAdditionalNounPhrase(new NounPhrase(expression, constraintGroup));
				LOGGER.info(String.format("New additional NounPhrase added to Subject: %s; plural: %s", expression,
						this.isSubjectPlural));
				break;
			case VERB:
				break;
			case ADJECTIVE:
				break;
			case ADVERB:
				break;
			case CONJUNCTION:
				break;
			case DETERMINER:
				break;
			case INTERJECTION:
				break;
			case PREPOSITION:
				break;
			case PRONOUN:
				break;
			case COMPLEMENT:
				break;
			case FRONT_MODIFIER:
				break;
			case PRE_MODIFIER:
				this.subject.getNounPhrase().setPreModifier(expression);
				LOGGER.info(String.format("New PreModifier added to Subject: %s", expression));
				break;
			case POST_MODIFIER:
				break;
			default:
				break;
		}
	}

	private void setPartOfSpeechToPredicate(final PartOfSpeech partOfSpeech, final String expression,
			final ConstraintGroup<String> constraintGroup)
	{
		switch (partOfSpeech)
		{
			case NOUN:
				this.predicate.setNounPhrase(new NounPhrase(expression, constraintGroup));
				this.predicate.getNounPhrase().setPlural(this.isObjectPlural);
				LOGGER.info(String.format("New NounPhrase added to Predicate: %s; plural: %s", expression,
						this.isObjectPlural));
				break;
			case VERB:
				this.predicate.setVerb(new Verb(expression, constraintGroup));
				this.predicate.getVerb().setPlural(this.isVerbPlural);
				LOGGER.info(
						String.format("New Verb added to Predicate: %s; plural: %s", expression, this.isVerbPlural));
				break;
			case ADJECTIVE:
				break;
			case ADVERB:
				break;
			case CONJUNCTION:
				break;
			case DETERMINER:
				break;
			case INTERJECTION:
				break;
			case PREPOSITION:
				break;
			case PRONOUN:
				break;
			case COMPLEMENT:
				this.complement = expression;
				this.complementConstraintGroup = constraintGroup;
				break;
			case COMPLEMENT2:
				this.complement += " " + expression;
				break;
			case COMPLEMENT3:
				this.complement += " " + expression;
				break;
			default:
				break;
		}
	}

	/**
	 * @return the concepts
	 */
	public ConceptLoader getConcepts()
	{
		return this.concepts;
	}

	/**
	 * @return the aggregationConcepts
	 */
	public AggregationConcepts getAggregationConcepts()
	{
		return this.aggregationConcepts;
	}
}
