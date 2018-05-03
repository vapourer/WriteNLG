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

		final ConstraintGroup<String> constraintGroup = new SoftConstraintGroup<>(
				new WeightedAdditionConstraintProcessor());

		Map<String, String> substitutions = new HashMap<>();
		substitutions.put("@@Pansy@@", "1234");

		constraintGroup.addConstraint(new SoftConstraint<>("Radishes are nice",
				new SatisfactionLevel(new BigDecimal("0.3"), new BigDecimal("3"))));
		constraintGroup.addConstraint(new SoftConstraint<>("Radishes are red",
				new SatisfactionLevel(new BigDecimal("0.4"), new BigDecimal("2"))));

		final NounPhrase nounPhrase = new NounPhrase("@@Pansy@@", constraintGroup);

		Predicate predicate = new Predicate();
		predicate.setNounPhrase(nounPhrase);

		// Act
		predicate.substitutePlaceholders(substitutions);
		String nounPhraseTextActual = predicate.getNounPhrase().getText();

		// Assert
		Assert.assertEquals(nounPhraseTextExpected, nounPhraseTextActual);
	}

	@Test
	public void testSubstitutePlaceholders_Complement()
	{
		LOGGER.info("Test: testSubstitutePlaceholders_Complement");

		// Arrange
		String complementTextExpected = "5678";

		final ConstraintGroup<String> constraintGroup = new SoftConstraintGroup<>(
				new WeightedAdditionConstraintProcessor());

		Map<String, String> substitutions = new HashMap<>();
		substitutions.put("@@Buttercup@@", "5678");

		constraintGroup.addConstraint(new SoftConstraint<>("Radishes are nice",
				new SatisfactionLevel(new BigDecimal("0.3"), new BigDecimal("3"))));
		constraintGroup.addConstraint(new SoftConstraint<>("Radishes are red",
				new SatisfactionLevel(new BigDecimal("0.4"), new BigDecimal("2"))));

		final Complement complement = new Complement("@@Buttercup@@", constraintGroup);

		Predicate predicate = new Predicate();
		predicate.setComplement(complement);

		// Act
		predicate.substitutePlaceholders(substitutions);
		String complementTextActual = predicate.getComplement().getText();

		// Assert
		Assert.assertEquals(complementTextExpected, complementTextActual);
	}
}
