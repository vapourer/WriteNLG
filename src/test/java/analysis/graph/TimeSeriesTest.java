// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.graph;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Calendar;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import analysis.TestConstants;

public class TimeSeriesTest
{
	private static Logger LOGGER;

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
		LOGGER = LogManager.getLogger("TimeSeriesTest.class");
	}

	@Test
	public void testConstructor()
	{
		LOGGER.info("Test: testConstructor");

		// Arrange
		MathContext context = new MathContext(TestConstants.ROUNDING_PARAMETER_FOR_DATE_COMPARISON);

		String timeLegendExpected = "Week ended";
		String seriesLegendExpected = "Deaths 2017";

		SortedMap<Long, BigDecimal> timeSeriesExpected = new TreeMap<>();
		final Calendar calendar = Calendar.getInstance();

		calendar.set(Integer.parseInt("17"), Integer.parseInt("01") - 1, Integer.parseInt("06"));
		Long date1 = Long.valueOf(calendar.getTimeInMillis());

		calendar.set(Integer.parseInt("17"), Integer.parseInt("01") - 1, Integer.parseInt("13"));
		Long date2 = Long.valueOf(calendar.getTimeInMillis());

		calendar.set(Integer.parseInt("17"), Integer.parseInt("01") - 1, Integer.parseInt("20"));
		Long date3 = Long.valueOf(calendar.getTimeInMillis());

		calendar.set(Integer.parseInt("17"), Integer.parseInt("01") - 1, Integer.parseInt("27"));
		Long date4 = Long.valueOf(calendar.getTimeInMillis());

		timeSeriesExpected.put(date1, new BigDecimal("11991"));
		timeSeriesExpected.put(date2, new BigDecimal("13715"));
		timeSeriesExpected.put(date3, new BigDecimal("13610"));
		timeSeriesExpected.put(date4, new BigDecimal("12877"));

		Long[] timesExpected = timeSeriesExpected.keySet().toArray(new Long[0]);

		String times = "Week ended,06/01/17,13/01/17,20/01/17,27/01/17";
		String values = "Deaths 2017,11991,13715,13610,12877";

		// Act
		TimeSeries timeSeries = new TimeSeries(times, values);
		SortedMap<Long, BigDecimal> timeSeriesActual = timeSeries.getSeries();
		Long[] timesActual = timeSeriesActual.keySet().toArray(new Long[0]);

		// Assert
		Assert.assertEquals(timeLegendExpected, timeSeries.getTimeLegend());
		Assert.assertEquals(seriesLegendExpected, timeSeries.getSeriesLegend());

		for (int i = 0; i < timesActual.length; i++)
		{
			BigDecimal timeExpectedRounded = new BigDecimal(timesExpected[i].longValue()).round(context);
			BigDecimal timeActualRounded = new BigDecimal(timesActual[i].longValue()).round(context);
			Assert.assertTrue(timeExpectedRounded.compareTo(timeActualRounded) == 0);
		}

		Assert.assertArrayEquals(timeSeriesExpected.values().toArray(new BigDecimal[0]),
				timeSeriesActual.values().toArray(new BigDecimal[0]));
	}
}
