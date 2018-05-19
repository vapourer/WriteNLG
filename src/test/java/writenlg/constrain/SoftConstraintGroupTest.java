// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.constrain;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import analysis.TestConstants;
import writenlg.constrain.ConstraintGroup;
import writenlg.constrain.HardConstraint;
import writenlg.constrain.SatisfactionLevel;
import writenlg.constrain.SoftConstraint;
import writenlg.constrain.SoftConstraintGroup;
import writenlg.constrain.WeightedAdditionConstraintProcessor;

public class SoftConstraintGroupTest
{
	private static Logger LOGGER;

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
		LOGGER = LogManager.getLogger("SoftConstraintGroupTest.class");
	}

	@Test
	public void testGetValue_DefaultWeightings()
	{
		LOGGER.info("Test: testGetValue_DefaultWeightings");

		// Arrange
		final BigDecimal valueExpected = new BigDecimal("2.2");

		final ConstraintGroup<String> constraints = new SoftConstraintGroup<>(
				new WeightedAdditionConstraintProcessor());
		constraints.addConstraint(new SoftConstraint<>("Buttercup", new SatisfactionLevel(new BigDecimal("0.3"))));
		constraints.addConstraint(new SoftConstraint<>("Pansy", new SatisfactionLevel(new BigDecimal("0.7"))));
		constraints.addConstraint(new SoftConstraint<>("Daffodil", new SatisfactionLevel(new BigDecimal("0.2"))));
		constraints.addConstraint(new SoftConstraint<>("Dandelion", new SatisfactionLevel(new BigDecimal("0.4"))));
		constraints.addConstraint(new SoftConstraint<>("Daisy", new SatisfactionLevel(new BigDecimal("0.6"))));

		// Act
		final BigDecimal valueActual = constraints.evaluate();

		// Assert
		Assert.assertTrue(valueExpected.compareTo(valueActual) == 0);
	}

	@Test
	public void testGetValue_VariedWeightings()
	{
		LOGGER.info("Test: testGetValue_VariedWeightings");

		// Arrange
		final BigDecimal valueExpected = new BigDecimal("8.4");

		final ConstraintGroup<String> constraints = new SoftConstraintGroup<>(
				new WeightedAdditionConstraintProcessor());
		constraints.addConstraint(
				new SoftConstraint<>("Buttercup", new SatisfactionLevel(new BigDecimal("0.3"), new BigDecimal("5"))));
		constraints.addConstraint(
				new SoftConstraint<>("Pansy", new SatisfactionLevel(new BigDecimal("0.7"), new BigDecimal("3"))));
		constraints.addConstraint(
				new SoftConstraint<>("Daffodil", new SatisfactionLevel(new BigDecimal("0.2"), new BigDecimal("1"))));
		constraints.addConstraint(
				new SoftConstraint<>("Dandelion", new SatisfactionLevel(new BigDecimal("0.4"), new BigDecimal("7"))));
		constraints.addConstraint(
				new SoftConstraint<>("Daisy", new SatisfactionLevel(new BigDecimal("0.6"), new BigDecimal("3"))));

		// Act
		final BigDecimal valueActual = constraints.evaluate();

		// Assert
		Assert.assertTrue(valueExpected.compareTo(valueActual) == 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddConstraint_HardConstraint()
	{
		LOGGER.info("Test: testAddConstraint_HardConstraint");

		final ConstraintGroup<String> constraints = new SoftConstraintGroup<>(
				new WeightedAdditionConstraintProcessor());
		constraints.addConstraint(new HardConstraint<>("Radish", new SatisfactionLevel(new BigDecimal("1"))));
	}
}
