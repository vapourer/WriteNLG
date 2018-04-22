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

public class BoundedSoftConstraintTest
{
	private static Logger LOGGER;

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
		LOGGER = LogManager.getLogger("BoundedSoftConstraintTest.class");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor_NullConstrainedProperty()
	{
		LOGGER.info("Test: testConstructor_NullConstrainedProperty");

		new BoundedSoftConstraint<String>(null, new SatisfactionLevel(new BigDecimal("0.5")),
				TestConstants.LOWER_BOUND_FOR_CONSTRAINTS_TESTS, TestConstants.UPPER_BOUND_FOR_CONSTRAINTS_TESTS);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor_NullSatisfactionLevel()
	{
		LOGGER.info("Test: testConstructor_NullSatisfactionLevel");

		new BoundedSoftConstraint<>("NullSatisfactionLevel", null, TestConstants.LOWER_BOUND_FOR_CONSTRAINTS_TESTS,
				TestConstants.UPPER_BOUND_FOR_CONSTRAINTS_TESTS);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor_SatisfactionLevelJustBelowLowerBound()
	{
		LOGGER.info("Test: testConstructor_SatisfactionLevelJustBelowLowerBound");
		new BoundedSoftConstraint<>("SatisfactionLevelJustBelowLowerBound",
				new SatisfactionLevel(new BigDecimal("-0.999")), TestConstants.LOWER_BOUND_FOR_CONSTRAINTS_TESTS,
				TestConstants.UPPER_BOUND_FOR_CONSTRAINTS_TESTS);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor_SatisfactionLevelJustAboveUpperBound()
	{
		LOGGER.info("Test: testConstructor_SatisfactionLevelJustAboveUpperBound");

		new BoundedSoftConstraint<>("SatisfactionLevelJustAboveUpperBound",
				new SatisfactionLevel(new BigDecimal("1.001")), TestConstants.LOWER_BOUND_FOR_CONSTRAINTS_TESTS,
				TestConstants.UPPER_BOUND_FOR_CONSTRAINTS_TESTS);
	}

	@Test
	public void testConstructor_Success_SatisfactionLevelMidwayBetweenBounds()
	{
		LOGGER.info("Test: testConstructor_Success_SatisfactionLevelMidwayBetweenBounds");

		// Arrange
		final String constrainedPropertyExpected = "SatisfactionLevelMidwayBetweenBounds";
		final BigDecimal satisfactionLevelExpected = new BigDecimal("0.5");

		final BoundedSoftConstraint<String> constraint = new BoundedSoftConstraint<>(
				"SatisfactionLevelMidwayBetweenBounds", new SatisfactionLevel(new BigDecimal("0.5")),
				TestConstants.LOWER_BOUND_FOR_CONSTRAINTS_TESTS, TestConstants.UPPER_BOUND_FOR_CONSTRAINTS_TESTS);

		// Act
		final String constrainedPropertyActual = constraint.getConstrainedElement();
		final BigDecimal satisfactionLevelActual = constraint.getSatisfactionLevelAsValue();

		// Assert
		Assert.assertEquals(constrainedPropertyExpected, constrainedPropertyActual);
		Assert.assertTrue(satisfactionLevelExpected.compareTo(satisfactionLevelActual) == 0);
	}

	@Test
	public void testConstructor_Success_SatisfactionLevelJustAboveLowerBound()
	{
		LOGGER.info("Test: testConstructor_Success_SatisfactionLevelJustAboveLowerBound");

		// Arrange
		final String constrainedPropertyExpected = "SatisfactionLevelJustAboveLowerBound";
		final BigDecimal satisfactionLevelExpected = new BigDecimal("0.001");

		final BoundedSoftConstraint<String> constraint = new BoundedSoftConstraint<>(
				"SatisfactionLevelJustAboveLowerBound", new SatisfactionLevel(new BigDecimal("0.001")),
				TestConstants.LOWER_BOUND_FOR_CONSTRAINTS_TESTS, TestConstants.UPPER_BOUND_FOR_CONSTRAINTS_TESTS);

		// Act
		final String constrainedPropertyActual = constraint.getConstrainedElement();
		final BigDecimal satisfactionLevelActual = constraint.getSatisfactionLevelAsValue();

		// Assert
		Assert.assertEquals(constrainedPropertyExpected, constrainedPropertyActual);
		Assert.assertTrue(satisfactionLevelExpected.compareTo(satisfactionLevelActual) == 0);
	}

	@Test
	public void testConstructor_Success_SatisfactionLevelJustBelowUpperBound()
	{
		LOGGER.info("Test: testConstructor_Success_SatisfactionLevelJustBelowUpperBound");

		// Arrange
		final String constrainedPropertyExpected = "SatisfactionLevelJustBelowUpperBound";
		final BigDecimal satisfactionLevelExpected = new BigDecimal("0.999");

		final BoundedSoftConstraint<String> constraint = new BoundedSoftConstraint<>(
				"SatisfactionLevelJustBelowUpperBound", new SatisfactionLevel(new BigDecimal("0.999")),
				TestConstants.LOWER_BOUND_FOR_CONSTRAINTS_TESTS, TestConstants.UPPER_BOUND_FOR_CONSTRAINTS_TESTS);

		// Act
		final String constrainedPropertyActual = constraint.getConstrainedElement();
		final BigDecimal satisfactionLevelActual = constraint.getSatisfactionLevelAsValue();

		// Assert
		Assert.assertEquals(constrainedPropertyExpected, constrainedPropertyActual);
		Assert.assertTrue(satisfactionLevelExpected.compareTo(satisfactionLevelActual) == 0);
	}
}
