package analysis.constrain;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import analysis.TestConstants;

public class SoftConstraintTest
{
	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor_NullConstrainedProperty()
	{
		new SoftConstraint<String>(null, new BigDecimal("0.5"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor_NullSatisfactionLevel()
	{
		new SoftConstraint<>("Test: NullSatisfactionLevel", null);
	}

	@Test
	public void testConstructor_Success()
	{
		// Arrange
		final String constrainedPropertyExpected = "Test: Success";
		final BigDecimal satisfactionLevelExpected = new BigDecimal("0.5");

		final SoftConstraint<String> constraint = new SoftConstraint<>("Test: Success", new BigDecimal("0.5"));

		// Act
		final String constrainedPropertyActual = constraint.getConstrainedElement();
		final BigDecimal satisfactionLevelActual = constraint.getSatisfactionLevel();

		// Assert
		Assert.assertEquals(constrainedPropertyExpected, constrainedPropertyActual);
		Assert.assertTrue(satisfactionLevelExpected.compareTo(satisfactionLevelActual) == 0);
	}
}
