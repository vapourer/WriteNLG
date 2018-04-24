// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.graph;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import analysis.TestConstants;

public class GraphUtilitiesTest
{
	private static Logger LOGGER;

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
		LOGGER = LogManager.getLogger("GraphUtilitiesTest.class");
	}

	@Test
	public void testCalculateEuclideanDistance_IntegerResult()
	{
		LOGGER.info("Test: testCalculateEuclideanDistance_IntegerResult");

		// Arrange
		BigDecimal resultExpected = new BigDecimal("5");

		Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 3, 1);
		Point point1 = new Point(new BigDecimal("0"), new BigDecimal("0"), Long.valueOf(calendar.getTimeInMillis()));
		calendar.set(2018, 3, 2);
		Point point2 = new Point(new BigDecimal("3"), new BigDecimal("4"), Long.valueOf(calendar.getTimeInMillis()));

		// Act
		BigDecimal resultActual = GraphUtilities.calculateEuclideanDistance(point1, point2);

		// Assert
		Assert.assertTrue(resultExpected.compareTo(resultActual) == 0);
	}

	@Test
	public void testCalculateEuclideanDistance_FloatingPointResult()
	{
		LOGGER.info("Test: testCalculateEuclideanDistance_FloatingPointResult");

		// Arrange
		BigDecimal resultExpected = new BigDecimal("6.40312");

		Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 3, 1);
		Point point1 = new Point(new BigDecimal("0"), new BigDecimal("0"), Long.valueOf(calendar.getTimeInMillis()));
		calendar.set(2018, 3, 2);
		Point point2 = new Point(new BigDecimal("4"), new BigDecimal("5"), Long.valueOf(calendar.getTimeInMillis()));

		// Act
		BigDecimal resultActual = GraphUtilities.calculateEuclideanDistance(point1, point2);
		MathContext context = new MathContext(6);
		BigDecimal resultActualRounded = resultActual.round(context);

		// Assert
		Assert.assertTrue(resultExpected.compareTo(resultActualRounded) == 0);
	}
}
