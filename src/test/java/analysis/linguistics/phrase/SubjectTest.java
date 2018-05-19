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
import analysis.linguistics.phrase.partofspeech.NounPhrase;
import writenlg.constrain.ConstraintGroup;
import writenlg.constrain.SatisfactionLevel;
import writenlg.constrain.SoftConstraint;
import writenlg.constrain.SoftConstraintGroup;
import writenlg.constrain.WeightedAdditionConstraintProcessor;

public class SubjectTest
{
	private static Logger LOGGER;

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
		LOGGER = LogManager.getLogger("SubjectTest.class");
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
		substitutions.put("@@Lemon@@", "1234");

		constraintGroup.addConstraint(new SoftConstraint<>("Radishes are nice",
				new SatisfactionLevel(new BigDecimal("0.3"), new BigDecimal("3"))));
		constraintGroup.addConstraint(new SoftConstraint<>("Radishes are red",
				new SatisfactionLevel(new BigDecimal("0.4"), new BigDecimal("2"))));

		final NounPhrase nounPhrase = new NounPhrase("@@Lemon@@", constraintGroup);

		Subject subject = new Subject();
		subject.setNounPhrase(nounPhrase);

		// Act
		Subject updatedSubject = subject.substitutePlaceholders(substitutions);
		String nounPhraseTextActual = updatedSubject.getNounPhrase().getText();

		// Assert
		Assert.assertEquals(nounPhraseTextExpected, nounPhraseTextActual);
	}
}
