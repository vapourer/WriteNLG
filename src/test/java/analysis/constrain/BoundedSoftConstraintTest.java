// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.constrain;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import analysis.TestConstants;

public class BoundedSoftConstraintTest
{
	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor_NullConstrainedProperty()
	{
		new BoundedSoftConstraint<String>(null, new SatisfactionLevel(new BigDecimal("0.5")),
				TestConstants.LOWER_BOUND_FOR_CONSTRAINTS_TESTS, TestConstants.UPPER_BOUND_FOR_CONSTRAINTS_TESTS);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor_NullSatisfactionLevel()
	{
		new BoundedSoftConstraint<>("Test: NullSatisfactionLevel", null,
				TestConstants.LOWER_BOUND_FOR_CONSTRAINTS_TESTS, TestConstants.UPPER_BOUND_FOR_CONSTRAINTS_TESTS);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor_SatisfactionLevelJustBelowLowerBound()
	{
		new BoundedSoftConstraint<>("Test: SatisfactionLevelJustBelowLowerBound",
				new SatisfactionLevel(new BigDecimal("-0.999")), TestConstants.LOWER_BOUND_FOR_CONSTRAINTS_TESTS,
				TestConstants.UPPER_BOUND_FOR_CONSTRAINTS_TESTS);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor_SatisfactionLevelJustAboveUpperBound()
	{
		new BoundedSoftConstraint<>("Test: SatisfactionLevelJustAboveUpperBound",
				new SatisfactionLevel(new BigDecimal("1.001")), TestConstants.LOWER_BOUND_FOR_CONSTRAINTS_TESTS,
				TestConstants.UPPER_BOUND_FOR_CONSTRAINTS_TESTS);
	}

	@Test
	public void testConstructor_Success_SatisfactionLevelMidwayBetweenBounds()
	{
		// Arrange
		final String constrainedPropertyExpected = "Test: SatisfactionLevelMidwayBetweenBounds";
		final BigDecimal satisfactionLevelExpected = new BigDecimal("0.5");

		final BoundedSoftConstraint<String> constraint = new BoundedSoftConstraint<>(
				"Test: SatisfactionLevelMidwayBetweenBounds", new SatisfactionLevel(new BigDecimal("0.5")),
				TestConstants.LOWER_BOUND_FOR_CONSTRAINTS_TESTS, TestConstants.UPPER_BOUND_FOR_CONSTRAINTS_TESTS);

		// Act
		final String constrainedPropertyActual = constraint.getConstrainedElement();
		final BigDecimal satisfactionLevelActual = constraint.getSatisfactionLevel().getLevel();

		// Assert
		Assert.assertEquals(constrainedPropertyExpected, constrainedPropertyActual);
		Assert.assertTrue(satisfactionLevelExpected.compareTo(satisfactionLevelActual) == 0);
	}

	@Test
	public void testConstructor_Success_SatisfactionLevelJustAboveLowerBound()
	{
		// Arrange
		final String constrainedPropertyExpected = "Test: SatisfactionLevelJustAboveLowerBound";
		final BigDecimal satisfactionLevelExpected = new BigDecimal("0.001");

		final BoundedSoftConstraint<String> constraint = new BoundedSoftConstraint<>(
				"Test: SatisfactionLevelJustAboveLowerBound", new SatisfactionLevel(new BigDecimal("0.001")),
				TestConstants.LOWER_BOUND_FOR_CONSTRAINTS_TESTS, TestConstants.UPPER_BOUND_FOR_CONSTRAINTS_TESTS);

		// Act
		final String constrainedPropertyActual = constraint.getConstrainedElement();
		final BigDecimal satisfactionLevelActual = constraint.getSatisfactionLevel().getLevel();

		// Assert
		Assert.assertEquals(constrainedPropertyExpected, constrainedPropertyActual);
		Assert.assertTrue(satisfactionLevelExpected.compareTo(satisfactionLevelActual) == 0);
	}

	@Test
	public void testConstructor_Success_SatisfactionLevelJustBelowUpperBound()
	{
		// Arrange
		final String constrainedPropertyExpected = "Test: SatisfactionLevelJustBelowUpperBound";
		final BigDecimal satisfactionLevelExpected = new BigDecimal("0.999");

		final BoundedSoftConstraint<String> constraint = new BoundedSoftConstraint<>(
				"Test: SatisfactionLevelJustBelowUpperBound", new SatisfactionLevel(new BigDecimal("0.999")),
				TestConstants.LOWER_BOUND_FOR_CONSTRAINTS_TESTS, TestConstants.UPPER_BOUND_FOR_CONSTRAINTS_TESTS);

		// Act
		final String constrainedPropertyActual = constraint.getConstrainedElement();
		final BigDecimal satisfactionLevelActual = constraint.getSatisfactionLevel().getLevel();

		// Assert
		Assert.assertEquals(constrainedPropertyExpected, constrainedPropertyActual);
		Assert.assertTrue(satisfactionLevelExpected.compareTo(satisfactionLevelActual) == 0);
	}
}
