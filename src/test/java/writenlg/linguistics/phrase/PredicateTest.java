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

public class PredicateTest
{
	private static Logger LOGGER;

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
		LOGGER = LogManager.getLogger("PredicateTest.class");
	}

	@Test
	public void testSubstitutePlaceholders_NounPhrase()
	{
		LOGGER.info("Test: testSubstitutePlaceholders_NounPhrase");

		// Arrange
		String nounPhraseTextExpected = "1234";

		final ConstraintGroup<String> verbConstraintGroup = new SoftConstraintGroup<>(
				new WeightedAdditionConstraintProcessor());

		final ConstraintGroup<String> nounConstraintGroup = new SoftConstraintGroup<>(
				new WeightedAdditionConstraintProcessor());

		Map<String, String> substitutions = new HashMap<>();
		substitutions.put("@@Pansy@@", "1234");

		nounConstraintGroup.addConstraint(new SoftConstraint<>("Radishes are nice",
				new SatisfactionLevel(new BigDecimal("0.3"), new BigDecimal("3"))));
		nounConstraintGroup.addConstraint(new SoftConstraint<>("Radishes are red",
				new SatisfactionLevel(new BigDecimal("0.4"), new BigDecimal("2"))));

		final NounPhrase nounPhrase = new NounPhrase("@@Pansy@@", nounConstraintGroup);

		Predicate predicate = new Predicate();
		predicate.setVerb(new Verb("be", verbConstraintGroup));
		predicate.setNounPhrase(nounPhrase);

		// Act
		Predicate updatedPredicate = predicate.substitutePlaceholders(substitutions);
		String nounPhraseTextActual = updatedPredicate.getNounPhrase().getText();

		// Assert
		Assert.assertEquals(nounPhraseTextExpected, nounPhraseTextActual);
	}

	@Test
	public void testSubstitutePlaceholders_Complement()
	{
		LOGGER.info("Test: testSubstitutePlaceholders_Complement");

		// Arrange
		String complementTextExpected = "5678";

		final ConstraintGroup<String> verbConstraintGroup = new SoftConstraintGroup<>(
				new WeightedAdditionConstraintProcessor());

		final ConstraintGroup<String> complementConstraintGroup = new SoftConstraintGroup<>(
				new WeightedAdditionConstraintProcessor());

		Map<String, String> substitutions = new HashMap<>();
		substitutions.put("@@Buttercup@@", "5678");

		complementConstraintGroup.addConstraint(new SoftConstraint<>("Radishes are nice",
				new SatisfactionLevel(new BigDecimal("0.3"), new BigDecimal("3"))));
		complementConstraintGroup.addConstraint(new SoftConstraint<>("Radishes are red",
				new SatisfactionLevel(new BigDecimal("0.4"), new BigDecimal("2"))));

		final Complement complement = new Complement("@@Buttercup@@", complementConstraintGroup);

		Predicate predicate = new Predicate();
		predicate.setVerb(new Verb("be", verbConstraintGroup));
		predicate.setComplement(complement);

		// Act
		Predicate updatedPredicate = predicate.substitutePlaceholders(substitutions);
		String complementTextActual = updatedPredicate.getComplement().getText();

		// Assert
		Assert.assertEquals(complementTextExpected, complementTextActual);
	}
}
