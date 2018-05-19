// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.expertinput.listener;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.Concepts;
import analysis.GlobalConcept;
import analysis.LineGraphWithDerivedInformation;
import analysis.TimeSeriesSpecificConcept;
import analysis.interfaces.ConceptLoader;
import analysis.linguistics.phrase.PhraseSpecification;
import analysis.linguistics.phrase.Predicate;
import analysis.linguistics.phrase.SentencePart;
import analysis.linguistics.phrase.Subject;
import analysis.linguistics.phrase.partofspeech.Complement;
import analysis.linguistics.phrase.partofspeech.NounPhrase;
import analysis.linguistics.phrase.partofspeech.PartOfSpeech;
import analysis.linguistics.phrase.partofspeech.Verb;
import io.antlrgenerated.PhraseCreatorBaseListener;
import io.antlrgenerated.PhraseCreatorParser;
import writenlg.constrain.ConstraintGroup;
import writenlg.constrain.SoftConstraintGroup;
import writenlg.constrain.WeightedAdditionConstraintProcessor;
import writenlg.substitution.Substitutor;

/**
 * PhraseCreatorBaseListener overrides specific to PhraseCreator.
 */
public class PhraseCreatorListener extends PhraseCreatorBaseListener
{
	private static final Logger LOGGER = LogManager.getLogger("PhraseCreatorListener.class");

	private final ConceptLoader concepts;

	private GlobalConcept globalConcept;
	private TimeSeriesSpecificConcept timeSeriesSpecificConcept;
	private List<PhraseSpecification> phraseSpecifications;
	private PhraseSpecification phraseSpecification;
	private SentencePart sentencePart;
	private Subject subject;
	private Predicate predicate;

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
	public void enterPhraseSpecification(final PhraseCreatorParser.PhraseSpecificationContext context)
	{
		this.phraseSpecification = new PhraseSpecification();
		LOGGER.info("New PhraseSpecification created");
	}

	@Override
	public void exitPhraseSpecification(final PhraseCreatorParser.PhraseSpecificationContext context)
	{
		this.phraseSpecification.setSubject(this.subject);
		this.phraseSpecification.setPredicate(this.predicate);
		this.phraseSpecifications.add(this.phraseSpecification);
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

	private void setPartOfSpeechToSubject(final PartOfSpeech partOfSpeech, final String expression,
			final ConstraintGroup<String> constraintGroup)
	{
		switch (partOfSpeech)
		{
			case NOUN:
				this.subject.setNounPhrase(new NounPhrase(expression, constraintGroup));
				LOGGER.info(String.format("New NounPhrase added to Subject: %s", expression));
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
				LOGGER.info(String.format("New NounPhrase added to Predicate: %s", expression));
				break;
			case VERB:
				this.predicate.setVerb(new Verb(expression, constraintGroup));
				LOGGER.info(String.format("New Verb added to Predicate: %s", expression));
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
				this.predicate.setComplement(new Complement(expression, constraintGroup));
				LOGGER.info(String.format("New Complement added to Predicate: %s", expression));
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
}
