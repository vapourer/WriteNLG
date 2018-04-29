// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.expertinput.listener;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.TimeSeriesSpecificConcept;
import analysis.constrain.ConstraintGroup;
import analysis.constrain.SoftConstraintGroup;
import analysis.constrain.WeightedAdditionConstraintProcessor;
import analysis.interfaces.ContentDeterminer;
import analysis.linguistics.contentdetermination.ContentDetermination;
import analysis.linguistics.phrase.PhraseSpecification;
import analysis.linguistics.phrase.Predicate;
import analysis.linguistics.phrase.SentencePart;
import analysis.linguistics.phrase.Subject;
import analysis.linguistics.phrase.partofspeech.Complement;
import analysis.linguistics.phrase.partofspeech.NounPhrase;
import analysis.linguistics.phrase.partofspeech.PartOfSpeech;
import analysis.linguistics.phrase.partofspeech.Verb;
import writenlg.antlrgenerated.PhraseCreatorBaseListener;
import writenlg.antlrgenerated.PhraseCreatorParser;
import writenlg.substitution.Substitutions;

/**
 * PhraseCreatorBaseListener overrides specific to PhraseCreator.
 */
public class PhraseCreatorListener extends PhraseCreatorBaseListener
{
	private static final Logger LOGGER = LogManager.getLogger("PhraseCreatorListener.class");

	private final ContentDeterminer contentDeterminer;

	private List<PhraseSpecification> phraseSpecifications;
	private TimeSeriesSpecificConcept timeSeriesSpecificConcept;
	private PhraseSpecification phraseSpecification;
	private SentencePart sentencePart;
	private Subject<String> subject;
	private Predicate<String> predicate;
	private String constraint;
	private BigDecimal weighting;

	/**
	 * Creates a PhraseCreator instance.
	 */
	public PhraseCreatorListener()
	{
		this(new Substitutions());
	}

	public PhraseCreatorListener(final Substitutions substitutions)
	{
		this.phraseSpecifications = new ArrayList<>();
		this.sentencePart = SentencePart.SUBJECT;
		this.contentDeterminer = new ContentDetermination();
		this.constraint = "";
		this.weighting = new BigDecimal("1");
	}

	@Override
	public void enterConcept(final PhraseCreatorParser.ConceptContext context)
	{

	}

	@Override
	public void exitConcept(final PhraseCreatorParser.ConceptContext context)
	{

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
		this.contentDeterminer.addTimeSeriesSpecificConcept(this.timeSeriesSpecificConcept, this.phraseSpecifications,
				this.weighting);
		this.weighting = new BigDecimal("1");
		phraseSpecifications = new ArrayList<>();
	}

	@Override
	public void enterWeighting(PhraseCreatorParser.WeightingContext context)
	{

	}

	@Override
	public void exitWeighting(PhraseCreatorParser.WeightingContext context)
	{

	}

	@Override
	public void enterConstraints(PhraseCreatorParser.ConstraintsContext context)
	{
	}

	@Override
	public void exitConstraints(PhraseCreatorParser.ConstraintsContext context)
	{
	}

	@Override
	public void enterConstraintWeighting(PhraseCreatorParser.ConstraintWeightingContext context)
	{
	}

	@Override
	public void exitConstraintWeighting(PhraseCreatorParser.ConstraintWeightingContext context)
	{
		this.constraint = context.constraint().getText();
		this.weighting = new BigDecimal(context.weighting().getText());
		LOGGER.info(String.format("Constraint = %s; weighting = %s", this.constraint, this.weighting));
	}

	@Override
	public void enterConstraint(PhraseCreatorParser.ConstraintContext context)
	{
	}

	@Override
	public void exitConstraint(PhraseCreatorParser.ConstraintContext context)
	{
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
		this.subject = new Subject<>();
		this.sentencePart = SentencePart.SUBJECT;
		LOGGER.info("New Subject created");
	}

	@Override
	public void exitSubject(final PhraseCreatorParser.SubjectContext context)
	{

	}

	@Override
	public void enterPredicate(final PhraseCreatorParser.PredicateContext context)
	{
		this.predicate = new Predicate<>();
		this.sentencePart = SentencePart.PREDICATE;
		LOGGER.info("New Predicate created");
	}

	@Override
	public void exitPredicate(final PhraseCreatorParser.PredicateContext context)
	{
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
				this.subject.setNounPhrase(new NounPhrase<>(expression, constraintGroup));
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
				this.predicate.setNounPhrase(new NounPhrase<>(expression, constraintGroup));
				LOGGER.info(String.format("New NounPhrase added to Predicate: %s", expression));
				break;
			case VERB:
				this.predicate.setVerb(new Verb<>(expression, constraintGroup));
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
				this.predicate.setComplement(new Complement<>(expression, constraintGroup));
				LOGGER.info(String.format("New Complement added to Predicate: %s", expression));
				break;
			default:
				break;
		}
	}

	/**
	 * @return the contentDeterminer
	 */
	public ContentDeterminer getContentDeterminer()
	{
		return contentDeterminer;
	}
}
