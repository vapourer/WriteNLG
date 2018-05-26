// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.linguistics.phrase;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import analysis.TestConstants;
import writenlg.constrain.ConstraintGroup;
import writenlg.constrain.SatisfactionLevel;
import writenlg.constrain.SoftConstraint;
import writenlg.constrain.SoftConstraintGroup;
import writenlg.constrain.WeightedAdditionConstraintProcessor;
import writenlg.linguistics.phrase.partofspeech.Complement;
import writenlg.linguistics.phrase.partofspeech.NounPhrase;
import writenlg.linguistics.phrase.partofspeech.Verb;

public class PhraseSpecificationTest
{
	private static Logger LOGGER;

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
		LOGGER = LogManager.getLogger("PhraseSpecificationTest.class");
	}

	@Test
	public void testSubstitutePlaceholders_PredicateHasNounPhrase()
	{
		LOGGER.info("Test: testSubstitutePlaceholders_PredicateHasNounPhrase");

		// Arrange
		String subjectNounPhraseTextExpected = "1234";
		String predicateNounPhraseTextExpected = "5678";

		final ConstraintGroup<String> subjectConstraintGroup = new SoftConstraintGroup<>(
				new WeightedAdditionConstraintProcessor());

		Map<String, String> substitutions = new HashMap<>();
		substitutions.put("@@Orange@@", "1234");
		substitutions.put("@@Lemon@@", "5678");

		subjectConstraintGroup.addConstraint(new SoftConstraint<>("Radishes are nice",
				new SatisfactionLevel(new BigDecimal("0.3"), new BigDecimal("3"))));
		subjectConstraintGroup.addConstraint(new SoftConstraint<>("Radishes are red",
				new SatisfactionLevel(new BigDecimal("0.4"), new BigDecimal("2"))));

		final NounPhrase subjectNounPhrase = new NounPhrase("@@Orange@@", subjectConstraintGroup);

		Subject subject = new Subject();
		subject.setNounPhrase(subjectNounPhrase);

		final ConstraintGroup<String> verbConstraintGroup = new SoftConstraintGroup<>(
				new WeightedAdditionConstraintProcessor());

		final ConstraintGroup<String> nounConstraintGroup = new SoftConstraintGroup<>(
				new WeightedAdditionConstraintProcessor());

		nounConstraintGroup.addConstraint(new SoftConstraint<>("Beetroot is purple",
				new SatisfactionLevel(new BigDecimal("0.3"), new BigDecimal("3"))));
		nounConstraintGroup.addConstraint(new SoftConstraint<>("Lettuce is green",
				new SatisfactionLevel(new BigDecimal("0.4"), new BigDecimal("2"))));

		final NounPhrase predicateNounPhrase = new NounPhrase("@@Lemon@@", nounConstraintGroup);

		Predicate predicate = new Predicate();
		predicate.setVerb(new Verb("be", verbConstraintGroup));
		predicate.setNounPhrase(predicateNounPhrase);

		PhraseSpecification phraseSpecification = new PhraseSpecification();
		phraseSpecification.setSubject(subject);
		phraseSpecification.setPredicate(predicate);

		// Act
		PhraseSpecification updatedPhraseSpecification = phraseSpecification.substitutePlaceholders(substitutions);
		String subjectNounPhraseTextActual = updatedPhraseSpecification.getSubject().getNounPhrase().getText();
		String predicateNounPhraseTextActual = updatedPhraseSpecification.getPredicate().getNounPhrase().getText();

		// Assert
		Assert.assertEquals(subjectNounPhraseTextExpected, subjectNounPhraseTextActual);
		Assert.assertEquals(predicateNounPhraseTextExpected, predicateNounPhraseTextActual);
	}

	@Test
	public void testSubstitutePlaceholders_PredicateHasComplement()
	{
		LOGGER.info("Test: testSubstitutePlaceholders_PredicateHasNounPhrase");

		// Arrange
		String subjectNounPhraseTextExpected = "1234";
		String predicateComplementTextExpected = "5678";

		final ConstraintGroup<String> subjectConstraintGroup = new SoftConstraintGroup<>(
				new WeightedAdditionConstraintProcessor());

		Map<String, String> substitutions = new HashMap<>();
		substitutions.put("@@Orange@@", "1234");
		substitutions.put("@@Apple@@", "5678");

		subjectConstraintGroup.addConstraint(new SoftConstraint<>("Radishes are nice",
				new SatisfactionLevel(new BigDecimal("0.3"), new BigDecimal("3"))));
		subjectConstraintGroup.addConstraint(new SoftConstraint<>("Radishes are red",
				new SatisfactionLevel(new BigDecimal("0.4"), new BigDecimal("2"))));

		final NounPhrase subjectNounPhrase = new NounPhrase("@@Orange@@", subjectConstraintGroup);

		Subject subject = new Subject();
		subject.setNounPhrase(subjectNounPhrase);

		final ConstraintGroup<String> verbConstraintGroup = new SoftConstraintGroup<>(
				new WeightedAdditionConstraintProcessor());

		final ConstraintGroup<String> complementConstraintGroup = new SoftConstraintGroup<>(
				new WeightedAdditionConstraintProcessor());

		complementConstraintGroup.addConstraint(new SoftConstraint<>("Beetroot is purple",
				new SatisfactionLevel(new BigDecimal("0.3"), new BigDecimal("3"))));
		complementConstraintGroup.addConstraint(new SoftConstraint<>("Lettuce is green",
				new SatisfactionLevel(new BigDecimal("0.4"), new BigDecimal("2"))));

		final Complement predicateComplement = new Complement("@@Apple@@", complementConstraintGroup);

		Predicate predicate = new Predicate();
		predicate.setVerb(new Verb("be", verbConstraintGroup));
		predicate.setComplement(predicateComplement);

		PhraseSpecification phraseSpecification = new PhraseSpecification();
		phraseSpecification.setSubject(subject);
		phraseSpecification.setPredicate(predicate);

		// Act
		PhraseSpecification updatedPhraseSpecification = phraseSpecification.substitutePlaceholders(substitutions);
		String subjectNounPhraseTextActual = updatedPhraseSpecification.getSubject().getNounPhrase().getText();
		String predicateComplementTextActual = updatedPhraseSpecification.getPredicate().getComplement().getText();

		// Assert
		Assert.assertEquals(subjectNounPhraseTextExpected, subjectNounPhraseTextActual);
		Assert.assertEquals(predicateComplementTextExpected, predicateComplementTextActual);
	}
}
