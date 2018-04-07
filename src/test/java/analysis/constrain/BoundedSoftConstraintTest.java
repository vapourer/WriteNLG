package analysis.constrain;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import analysis.TestConstants;

public class BoundedSoftConstraintTest
{
	private static final BigDecimal LOWER_BOUND = new BigDecimal("0");
	private static final BigDecimal UPPER_BOUND = new BigDecimal("1");

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor_NullConstrainedProperty()
	{
		new BoundedSoftConstraint<String>(null, new BigDecimal("0.5"), LOWER_BOUND, UPPER_BOUND);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor_NullSatisfactionLevel()
	{
		new BoundedSoftConstraint<>("Test: NullSatisfactionLevel", null, LOWER_BOUND, UPPER_BOUND);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor_SatisfactionLevelJustBelowLowerBound()
	{
		new BoundedSoftConstraint<>("Test: SatisfactionLevelJustBelowLowerBound", new BigDecimal("-0.999"), LOWER_BOUND,
				UPPER_BOUND);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor_SatisfactionLevelJustAboveUpperBound()
	{
		new BoundedSoftConstraint<>("Test: SatisfactionLevelJustAboveUpperBound", new BigDecimal("1.001"), LOWER_BOUND,
				UPPER_BOUND);
	}

	@Test
	public void testConstructor_Success_SatisfactionLevelMidwayBetweenBounds()
	{
		// Arrange
		final String constrainedPropertyExpected = "Test: SatisfactionLevelMidwayBetweenBounds";
		final BigDecimal satisfactionLevelExpected = new BigDecimal("0.5");

		final BoundedSoftConstraint<String> constraint = new BoundedSoftConstraint<>(
				"Test: SatisfactionLevelMidwayBetweenBounds", new BigDecimal("0.5"), LOWER_BOUND, UPPER_BOUND);

		// Act
		final String constrainedPropertyActual = constraint.getConstrainedElement();
		final BigDecimal satisfactionLevelActual = constraint.getSatisfactionLevel();

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
				"Test: SatisfactionLevelJustAboveLowerBound", new BigDecimal("0.001"), LOWER_BOUND, UPPER_BOUND);

		// Act
		final String constrainedPropertyActual = constraint.getConstrainedElement();
		final BigDecimal satisfactionLevelActual = constraint.getSatisfactionLevel();

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
				"Test: SatisfactionLevelJustBelowUpperBound", new BigDecimal("0.999"), LOWER_BOUND, UPPER_BOUND);

		// Act
		final String constrainedPropertyActual = constraint.getConstrainedElement();
		final BigDecimal satisfactionLevelActual = constraint.getSatisfactionLevel();

		// Assert
		Assert.assertEquals(constrainedPropertyExpected, constrainedPropertyActual);
		Assert.assertTrue(satisfactionLevelExpected.compareTo(satisfactionLevelActual) == 0);
	}
}
