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
import writenlg.constrain.SatisfactionLevel;
import writenlg.constrain.SoftConstraint;

public class SoftConstraintTest
{
	private static Logger LOGGER;

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
		LOGGER = LogManager.getLogger("SoftConstraintTest.class");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor_NullConstrainedProperty()
	{
		LOGGER.info("Test: testConstructor_NullConstrainedProperty");

		new SoftConstraint<String>(null, new SatisfactionLevel(new BigDecimal("0.5")));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor_NullSatisfactionLevel()
	{
		LOGGER.info("Test: testConstructor_NullSatisfactionLevel");

		new SoftConstraint<>("Test: NullSatisfactionLevel", null);
	}

	@Test
	public void testConstructor_Success()
	{
		LOGGER.info("Test: testConstructor_Success");

		// Arrange
		final String constrainedPropertyExpected = "Test: Success";
		final BigDecimal satisfactionLevelExpected = new BigDecimal("0.5");

		final SoftConstraint<String> constraint = new SoftConstraint<>("Test: Success",
				new SatisfactionLevel(new BigDecimal("0.5")));

		// Act
		final String constrainedPropertyActual = constraint.getConstrainedElement();
		final BigDecimal satisfactionLevelActual = constraint.getSatisfactionLevelAsValue();

		// Assert
		Assert.assertEquals(constrainedPropertyExpected, constrainedPropertyActual);
		Assert.assertTrue(satisfactionLevelExpected.compareTo(satisfactionLevelActual) == 0);
	}
}
