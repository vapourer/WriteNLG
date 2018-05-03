// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.phrase;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import analysis.TestConstants;
import analysis.constrain.ConstraintGroup;
import analysis.constrain.SatisfactionLevel;
import analysis.constrain.SoftConstraint;
import analysis.constrain.SoftConstraintGroup;
import analysis.constrain.WeightedAdditionConstraintProcessor;
import analysis.linguistics.phrase.partofspeech.Complement;
import analysis.linguistics.phrase.partofspeech.NounPhrase;

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

		final ConstraintGroup<String> predicateConstraintGroup = new SoftConstraintGroup<>(
				new WeightedAdditionConstraintProcessor());

		predicateConstraintGroup.addConstraint(new SoftConstraint<>("Beetroot is purple",
				new SatisfactionLevel(new BigDecimal("0.3"), new BigDecimal("3"))));
		predicateConstraintGroup.addConstraint(new SoftConstraint<>("Lettuce is green",
				new SatisfactionLevel(new BigDecimal("0.4"), new BigDecimal("2"))));

		final NounPhrase predicateNounPhrase = new NounPhrase("@@Lemon@@", predicateConstraintGroup);

		Predicate predicate = new Predicate();
		predicate.setNounPhrase(predicateNounPhrase);

		PhraseSpecification phraseSpecification = new PhraseSpecification();
		phraseSpecification.setSubject(subject);
		phraseSpecification.setPredicate(predicate);

		// Act
		phraseSpecification.substitutePlaceholders(substitutions);
		String subjectNounPhraseTextActual = phraseSpecification.getSubject().getNounPhrase().getText();
		String predicateNounPhraseTextActual = phraseSpecification.getPredicate().getNounPhrase().getText();

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

		final ConstraintGroup<String> predicateConstraintGroup = new SoftConstraintGroup<>(
				new WeightedAdditionConstraintProcessor());

		predicateConstraintGroup.addConstraint(new SoftConstraint<>("Beetroot is purple",
				new SatisfactionLevel(new BigDecimal("0.3"), new BigDecimal("3"))));
		predicateConstraintGroup.addConstraint(new SoftConstraint<>("Lettuce is green",
				new SatisfactionLevel(new BigDecimal("0.4"), new BigDecimal("2"))));

		final Complement predicateComplement = new Complement("@@Apple@@", predicateConstraintGroup);

		Predicate predicate = new Predicate();
		predicate.setComplement(predicateComplement);

		PhraseSpecification phraseSpecification = new PhraseSpecification();
		phraseSpecification.setSubject(subject);
		phraseSpecification.setPredicate(predicate);

		// Act
		phraseSpecification.substitutePlaceholders(substitutions);
		String subjectNounPhraseTextActual = phraseSpecification.getSubject().getNounPhrase().getText();
		String predicateComplementTextActual = phraseSpecification.getPredicate().getComplement().getText();

		// Assert
		Assert.assertEquals(subjectNounPhraseTextExpected, subjectNounPhraseTextActual);
		Assert.assertEquals(predicateComplementTextExpected, predicateComplementTextActual);
	}
}
