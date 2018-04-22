package analysis.constrain;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import analysis.TestConstants;

public class WeightedConstraintTest
{
	private static Logger LOGGER;

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
		LOGGER = LogManager.getLogger("WeightedConstraintTest.class");
	}

	@Test
	public void testGetWeighting()
	{
		LOGGER.info("Test: testGetWeighting");

		// Arrange
		BigDecimal weightingExpected = new BigDecimal("0.4");

		WeightedConstraint<String> constraint = new WeightedConstraint<String>("Yellowhammer",
				new SatisfactionLevel(new BigDecimal("3"), new BigDecimal("0.4")));

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

		Constraint<String> constraint = new WeightedConstraint<String>("Yellowhammer",
				new SatisfactionLevel(new BigDecimal("3"), new BigDecimal("0.4")));

		// Act
		BigDecimal weightedLevelActual = constraint.getSatisfactionLevelAsValue();

		// Assert
		Assert.assertTrue(weightedLevelExpected.compareTo(weightedLevelActual) == 0);
	}
}
