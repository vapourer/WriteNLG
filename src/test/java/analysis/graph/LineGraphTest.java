// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.graph;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import analysis.TestConstants;

public class LineGraphTest
{
	private static Logger LOGGER;

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
		LOGGER = LogManager.getLogger("LineGraphTest.class");
	}

	@Test
	public void testConstructor()
	{
		LOGGER.info("Test: testConstructor");

		// Arrange
		MathContext context = new MathContext(TestConstants.ROUNDING_PARAMETER_FOR_DATE_COMPARISON);

		final String timeLegendExpected = "Week ended";
		final String seriesLegend1Expected = "Deaths 2016";
		final String seriesLegend2Expected = "Deaths 2017";

		final SortedMap<Long, BigDecimal> timeSeries1Expected = new TreeMap<>();
		final SortedMap<Long, BigDecimal> timeSeries2Expected = new TreeMap<>();

		final Calendar calendar = Calendar.getInstance();

		calendar.set(Integer.parseInt("16"), Integer.parseInt("01") - 1, Integer.parseInt("08"));
		final Long date1 = calendar.getTimeInMillis();

		calendar.set(Integer.parseInt("16"), Integer.parseInt("01") - 1, Integer.parseInt("15"));
		final Long date2 = calendar.getTimeInMillis();

		calendar.set(Integer.parseInt("16"), Integer.parseInt("01") - 1, Integer.parseInt("22"));
		final Long date3 = calendar.getTimeInMillis();

		calendar.set(Integer.parseInt("16"), Integer.parseInt("01") - 1, Integer.parseInt("29"));
		final Long date4 = calendar.getTimeInMillis();

		calendar.set(Integer.parseInt("17"), Integer.parseInt("01") - 1, Integer.parseInt("06"));
		final Long date5 = calendar.getTimeInMillis();

		calendar.set(Integer.parseInt("17"), Integer.parseInt("01") - 1, Integer.parseInt("13"));
		final Long date6 = calendar.getTimeInMillis();

		calendar.set(Integer.parseInt("17"), Integer.parseInt("01") - 1, Integer.parseInt("20"));
		final Long date7 = calendar.getTimeInMillis();

		calendar.set(Integer.parseInt("17"), Integer.parseInt("01") - 1, Integer.parseInt("27"));
		final Long date8 = calendar.getTimeInMillis();

		timeSeries1Expected.put(date1, new BigDecimal("13045"));
		timeSeries1Expected.put(date2, new BigDecimal("11501"));
		timeSeries1Expected.put(date3, new BigDecimal("11473"));
		timeSeries1Expected.put(date4, new BigDecimal("11317"));

		timeSeries2Expected.put(date5, new BigDecimal("11991"));
		timeSeries2Expected.put(date6, new BigDecimal("13715"));
		timeSeries2Expected.put(date7, new BigDecimal("13610"));
		timeSeries2Expected.put(date8, new BigDecimal("12877"));

		Long[] times1Expected = timeSeries1Expected.keySet().toArray(new Long[0]);
		Long[] times2Expected = timeSeries2Expected.keySet().toArray(new Long[0]);

		final String times1 = "Week ended,08/01/16,15/01/16,22/01/16,29/01/16";
		final String values1 = "Deaths 2016,13045,11501,11473,11317";
		final String times2 = "Week ended,06/01/17,13/01/17,20/01/17,27/01/17";
		final String values2 = "Deaths 2017,11991,13715,13610,12877";

		final List<String> times = new ArrayList<>();
		times.add(times1);
		times.add(times2);

		final List<String> values = new ArrayList<>();
		values.add(values1);
		values.add(values2);

		final LineGraph lineGraph = new LineGraph(times, values);

		// Act
		final List<TimeSeries> timeSeriesGroup = lineGraph.getTimeSeriesGroup();

		final TimeSeries timeSeries1Actual = timeSeriesGroup.get(0);
		final TimeSeries timeSeries2Actual = timeSeriesGroup.get(1);

		Long[] times1Actual = timeSeries1Actual.getSeries().keySet().toArray(new Long[0]);
		Long[] times2Actual = timeSeries2Actual.getSeries().keySet().toArray(new Long[0]);

		// Assert
		Assert.assertEquals(timeLegendExpected, timeSeries1Actual.getTimeLegend());
		Assert.assertEquals(seriesLegend1Expected, timeSeries1Actual.getSeriesLegend());

		for (int i = 0; i < times1Actual.length; i++)
		{
			BigDecimal timeExpectedRounded = new BigDecimal(times1Expected[i].longValue()).round(context);
			BigDecimal timeActualRounded = new BigDecimal(times1Actual[i].longValue()).round(context);
			Assert.assertTrue(timeExpectedRounded.compareTo(timeActualRounded) == 0);
		}

		Assert.assertArrayEquals(timeSeries1Expected.values().toArray(new BigDecimal[0]),
				timeSeries1Actual.getSeries().values().toArray(new BigDecimal[0]));

		Assert.assertEquals(timeLegendExpected, timeSeries2Actual.getTimeLegend());
		Assert.assertEquals(seriesLegend2Expected, timeSeries2Actual.getSeriesLegend());

		for (int i = 0; i < times2Actual.length; i++)
		{
			BigDecimal timeExpectedRounded = new BigDecimal(times2Expected[i].longValue()).round(context);
			BigDecimal timeActualRounded = new BigDecimal(times2Actual[i].longValue()).round(context);
			Assert.assertTrue(timeExpectedRounded.compareTo(timeActualRounded) == 0);
		}

		Assert.assertArrayEquals(timeSeries2Expected.values().toArray(new BigDecimal[0]),
				timeSeries2Actual.getSeries().values().toArray(new BigDecimal[0]));
	}
}
