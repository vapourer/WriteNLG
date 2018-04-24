// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.statistics;

import java.math.BigDecimal;
import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import analysis.TestConstants;
import analysis.graph.Point;
import analysis.graph.TimeSeries;
import writenlg.control.WriteNlgProperties;

public class MaximumTest
{
	private static Logger LOGGER;

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
		LOGGER = LogManager.getLogger("MaximumTest.class");
		WriteNlgProperties.createInstance(TestConstants.WRITE_NLG_PROPERTIES_FILE_PATH);
	}

	@Test
	public void testCalculate()
	{
		LOGGER.info("Test: testCalculate");

		// Arrange
		final BigDecimal xExpected = new BigDecimal("1");
		final BigDecimal yExpected = new BigDecimal("13715");

		final Calendar calendar = Calendar.getInstance();
		calendar.set(Integer.parseInt("2017"), Integer.parseInt("01") - 1, Integer.parseInt("13"));
		Long dateExpected = calendar.getTimeInMillis();

		String times = "Week ended,06/01/2017,13/01/2017,20/01/2017,27/01/2017";
		String values = "Deaths 2017,11991,13715,13610,12877";

		TimeSeries timeSeries = new TimeSeries(times, values);
		Maximum maximum = new Maximum(timeSeries);

		// Act
		Point pointWithMaximumValueActual = maximum.calculate();

		// Assert
		Assert.assertTrue(xExpected.compareTo(pointWithMaximumValueActual.getX()) == 0);
		Assert.assertTrue(yExpected.compareTo(pointWithMaximumValueActual.getY()) == 0);
		Assert.assertEquals(dateExpected, pointWithMaximumValueActual.getDate());
	}
}
