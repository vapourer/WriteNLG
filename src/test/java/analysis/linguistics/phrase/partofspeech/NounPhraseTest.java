// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.phrase.partofspeech;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import analysis.TestConstants;
import analysis.constrain.BoundedSoftConstraint;
import analysis.constrain.ConstraintGroup;
import analysis.constrain.SatisfactionLevel;
import analysis.constrain.SoftConstraint;
import analysis.constrain.SoftConstraintGroup;
import analysis.constrain.WeightedAdditionConstraintProcessor;

public class NounPhraseTest
{
	private static Logger LOGGER;

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
		LOGGER = LogManager.getLogger("NounPhraseTest.class");
	}

	@Test
	public void testCalculateSatisfactionLevel()
	{
		LOGGER.info("Test: testCalculateSatisfactionLevel");

		// Arrange
		final BigDecimal satisfactionLevelExpected = new BigDecimal("1.5");

		final ConstraintGroup<String> constraintGroup = new SoftConstraintGroup<>(
				new WeightedAdditionConstraintProcessor());

		constraintGroup.addConstraint(new BoundedSoftConstraint<>("Radishes are nice",
				new SatisfactionLevel(new BigDecimal("0.7")), new BigDecimal("0"), new BigDecimal("1")));
		constraintGroup.addConstraint(new BoundedSoftConstraint<>("Radishes are red",
				new SatisfactionLevel(new BigDecimal("0.8")), new BigDecimal("0"), new BigDecimal("1")));

		final NounPhrase nounPhrase = new NounPhrase("radish", constraintGroup);

		// Act
		final BigDecimal satisfactionLevelActual = nounPhrase.calculateSatisfactionLevel();

		// Assert
		Assert.assertTrue(satisfactionLevelExpected.compareTo(satisfactionLevelActual) == 0);
	}

	@Test
	public void testReplaceAll()
	{
		LOGGER.info("Test: testReplaceAll");

		// Arrange
		final String textExpected = "5678";

		final ConstraintGroup<String> constraintGroup = new SoftConstraintGroup<>(
				new WeightedAdditionConstraintProcessor());

		constraintGroup.addConstraint(new SoftConstraint<>("Radishes are nice",
				new SatisfactionLevel(new BigDecimal("0.3"), new BigDecimal("3"))));
		constraintGroup.addConstraint(new SoftConstraint<>("Radishes are red",
				new SatisfactionLevel(new BigDecimal("0.4"), new BigDecimal("2"))));

		final NounPhrase nounPhrase = new NounPhrase("@@onion@@", constraintGroup);

		// Act
		String textActual = nounPhrase.replaceAll("@@onion@@", "5678");

		// Assert
		Assert.assertEquals(textExpected, textActual);
	}
}
