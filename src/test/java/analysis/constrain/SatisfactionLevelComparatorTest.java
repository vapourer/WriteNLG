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

public class SatisfactionLevelComparatorTest
{
	private static Logger LOGGER;

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
		LOGGER = LogManager.getLogger("SatisfactionLevelComparatorTest.class");
	}

	@Test
	public void testCompare_Equals()
	{
		LOGGER.info("Test: testCompare_Equals");

		// Arrange
		SatisfactionLevel level1 = new SatisfactionLevel(new BigDecimal("0.4"), new BigDecimal("3"));
		SatisfactionLevel level2 = new SatisfactionLevel(new BigDecimal("0.6"), new BigDecimal("2"));

		// Assert
		Assert.assertTrue(new SatisfactionLevelComparator().compare(level1, level2) == 0);
	}

	@Test
	public void testCompare_DoesNotEqual()
	{
		LOGGER.info("Test: testCompare_Equals");

		// Arrange
		SatisfactionLevel level1 = new SatisfactionLevel(new BigDecimal("0.4"), new BigDecimal("3"));
		SatisfactionLevel level2 = new SatisfactionLevel(new BigDecimal("0.5"), new BigDecimal("4"));

		// Assert
		Assert.assertTrue(new SatisfactionLevelComparator().compare(level1, level2) != 0);
	}

	@Test
	public void testCompare_LessThan()
	{
		LOGGER.info("Test: testCompare_Equals");

		// Arrange
		SatisfactionLevel level1 = new SatisfactionLevel(new BigDecimal("0.4"), new BigDecimal("3"));
		SatisfactionLevel level2 = new SatisfactionLevel(new BigDecimal("0.5"), new BigDecimal("4"));

		// Assert
		Assert.assertTrue(new SatisfactionLevelComparator().compare(level1, level2) < 0);
	}

	@Test
	public void testCompare_GreaterThan()
	{
		LOGGER.info("Test: testCompare_Equals");

		// Arrange
		SatisfactionLevel level1 = new SatisfactionLevel(new BigDecimal("0.7"), new BigDecimal("3"));
		SatisfactionLevel level2 = new SatisfactionLevel(new BigDecimal("0.5"), new BigDecimal("4"));

		// Assert
		Assert.assertTrue(new SatisfactionLevelComparator().compare(level1, level2) > 0);
	}
}
