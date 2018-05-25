// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.linguistics.phrase.partofspeech;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import analysis.TestConstants;
import analysis.utilities.GlobalConstants;
import writenlg.constrain.BoundedSoftConstraint;
import writenlg.constrain.ConstraintGroup;
import writenlg.constrain.SatisfactionLevel;
import writenlg.constrain.SoftConstraintGroup;
import writenlg.constrain.WeightedAdditionConstraintProcessor;

public class VerbTest
{
	private static Logger LOGGER;

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
		LOGGER = LogManager.getLogger("VerbTest.class");
	}

	@Test
	public void testCalculateSatisfactionLevel()
	{
		LOGGER.info("Test: testCalculateSatisfactionLevel");

		// Arrange
		final BigDecimal satisfactionLevelExpected = new BigDecimal("1.4");

		final ConstraintGroup<String> constraintGroup = new SoftConstraintGroup<>(
				new WeightedAdditionConstraintProcessor());

		constraintGroup.addConstraint(new BoundedSoftConstraint<>("Too slow",
				new SatisfactionLevel(new BigDecimal("0.6")), GlobalConstants.ZERO, GlobalConstants.ONE));
		constraintGroup.addConstraint(new BoundedSoftConstraint<>("Speed merchant",
				new SatisfactionLevel(new BigDecimal("0.8")), GlobalConstants.ZERO, GlobalConstants.ONE));

		final Verb verb = new Verb("hurtle", constraintGroup);

		// Act
		final BigDecimal satisfactionLevelActual = verb.calculateSatisfactionLevel();

		// Assert
		Assert.assertTrue(satisfactionLevelExpected.compareTo(satisfactionLevelActual) == 0);
	}
}
