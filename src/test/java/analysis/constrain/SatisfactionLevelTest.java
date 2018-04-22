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

public class SatisfactionLevelTest
{
	private static Logger LOGGER;

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
		LOGGER = LogManager.getLogger("SatisfactionLevelTest.class");
	}

	@Test
	public void testGetWeightedLevel_DefaultWeighting()
	{
		LOGGER.info("Test: testGetWeightedLevel_DefaultWeighting");

		// Arrange
		BigDecimal weightedLevelExpected = new BigDecimal("0.8");

		SatisfactionLevel satisfactionLevel = new SatisfactionLevel(new BigDecimal("0.8"));

		// Act
		BigDecimal weightedLevelActual = satisfactionLevel.getWeightedLevel();

		// Assert
		Assert.assertTrue(weightedLevelExpected.compareTo(weightedLevelActual) == 0);
	}

	@Test
	public void testGetWeightedLevel_WeightingAdjusted()
	{
		LOGGER.info("Test: testGetWeightedLevel_WeightingAdjusted");

		// Arrange
		BigDecimal weightedLevelExpected = new BigDecimal("0.6");

		SatisfactionLevel satisfactionLevel = new SatisfactionLevel(new BigDecimal("2"), new BigDecimal("0.3"));

		// Act
		BigDecimal weightedLevelActual = satisfactionLevel.getWeightedLevel();

		// Assert
		Assert.assertTrue(weightedLevelExpected.compareTo(weightedLevelActual) == 0);
	}
}
