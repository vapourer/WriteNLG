package analysis.constrain;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import analysis.TestConstants;
import writenlg.constrain.BoundedWeightedConstraint;
import writenlg.constrain.Constraint;
import writenlg.constrain.SatisfactionLevel;

public class BoundedWeightedConstraintTest
{
	private static Logger LOGGER;

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
		LOGGER = LogManager.getLogger("BoundedWeightedConstraintTest.class");
	}

	@Test
	public void testGetWeighting()
	{
		LOGGER.info("Test: testGetWeighting");

		// Arrange
		BigDecimal weightingExpected = new BigDecimal("5");

		BoundedWeightedConstraint<String> constraint = new BoundedWeightedConstraint<String>("Yellowhammer",
				new SatisfactionLevel(new BigDecimal("0.2"), new BigDecimal("5")), new BigDecimal("0"),
				new BigDecimal("1"));

		// Act
		BigDecimal weightingActual = constraint.getWeighting();

		// Assert
		Assert.assertTrue(weightingExpected.compareTo(weightingActual) == 0);
	}

	@Test
	public void testGetSatisfactionLevelAsValue()
	{
		LOGGER.info("Test: testGetSatisfactionLevelAsValue");

		// Arrange
		BigDecimal weightedLevelExpected = new BigDecimal("1.2");

		Constraint<String> constraint = new BoundedWeightedConstraint<String>("Yellowhammer",
				new SatisfactionLevel(new BigDecimal("0.4"), new BigDecimal("3")), new BigDecimal("0"),
				new BigDecimal("1"));

		// Act
		BigDecimal weightedLevelActual = constraint.getSatisfactionLevelAsValue();

		// Assert
		Assert.assertTrue(weightedLevelExpected.compareTo(weightedLevelActual) == 0);
	}
}
