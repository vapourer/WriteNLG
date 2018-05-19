// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.constrain;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import analysis.TestConstants;
import writenlg.constrain.ConstraintGroup;
import writenlg.constrain.HardConstraint;
import writenlg.constrain.HardConstraintGroup;
import writenlg.constrain.HardConstraintProcessor;
import writenlg.constrain.SatisfactionLevel;
import writenlg.constrain.SoftConstraint;

public class HardConstraintGroupTest
{
	private static Logger LOGGER;

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
		LOGGER = LogManager.getLogger("HardConstraintGroupTest.class");
	}

	@Test
	public void testGetValue_Positive()
	{
		LOGGER.info("Test: testGetValue_Positive");

		// Arrange
		final BigDecimal valueExpected = new BigDecimal("6");

		final ConstraintGroup<String> constraints = new HardConstraintGroup<>(new HardConstraintProcessor());
		constraints.addConstraint(new HardConstraint<>("Radish", new SatisfactionLevel(new BigDecimal("1"))));
		constraints.addConstraint(new HardConstraint<>("Turnip", new SatisfactionLevel(new BigDecimal("1"))));
		constraints.addConstraint(new HardConstraint<>("Cabbage", new SatisfactionLevel(new BigDecimal("1"))));
		constraints.addConstraint(new HardConstraint<>("Courgette", new SatisfactionLevel(new BigDecimal("1"))));
		constraints.addConstraint(new HardConstraint<>("Potato", new SatisfactionLevel(new BigDecimal("1"))));
		constraints.addConstraint(new HardConstraint<>("Carrot", new SatisfactionLevel(new BigDecimal("1"))));

		// Act
		final BigDecimal valueActual = constraints.evaluate();

		// Assert
		Assert.assertEquals(valueExpected, valueActual);
	}

	@Test
	public void testGetValue_Zero()
	{
		LOGGER.info("Test: testGetValue_Zero");

		// Arrange
		final BigDecimal valueExpected = new BigDecimal("0");

		final ConstraintGroup<String> constraints = new HardConstraintGroup<>(new HardConstraintProcessor());
		constraints.addConstraint(new HardConstraint<>("Radish", new SatisfactionLevel(new BigDecimal("1"))));
		constraints.addConstraint(new HardConstraint<>("Turnip", new SatisfactionLevel(new BigDecimal("1"))));
		constraints.addConstraint(new HardConstraint<>("Cabbage", new SatisfactionLevel(new BigDecimal("1"))));
		constraints.addConstraint(new HardConstraint<>("Courgette", new SatisfactionLevel(new BigDecimal("1"))));
		constraints.addConstraint(new HardConstraint<>("Potato", new SatisfactionLevel(new BigDecimal("0"))));
		constraints.addConstraint(new HardConstraint<>("Carrot", new SatisfactionLevel(new BigDecimal("1"))));

		// Act
		final BigDecimal valueActual = constraints.evaluate();

		// Assert
		Assert.assertEquals(valueExpected, valueActual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddConstraint_SoftConstraint()
	{
		LOGGER.info("Test: testAddConstraint_SoftConstraint");

		final ConstraintGroup<String> constraints = new HardConstraintGroup<>(new HardConstraintProcessor());
		constraints.addConstraint(new SoftConstraint<>("Radish", new SatisfactionLevel(new BigDecimal("1.2"))));
	}
}
