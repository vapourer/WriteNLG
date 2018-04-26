// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.time;

import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import analysis.TestConstants;

public class TimeSliceTest
{
	private static Logger LOGGER;

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
		LOGGER = LogManager.getLogger("TimeSliceTest.class");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor_Time1GreaterThanTime2()
	{
		LOGGER.info("Test: testConstructor_Time1GreaterThanTime2");

		// Arrange
		final Calendar calendar = Calendar.getInstance();
		calendar.set(2017, 3, 14);
		final Long time1 = Long.valueOf(calendar.getTimeInMillis());

		calendar.set(2017, 3, 7);
		final Long time2 = Long.valueOf(calendar.getTimeInMillis());

		// Act
		new TimeSlice(time1, time2);
	}

	@Test
	public void testGetInterval()
	{
		LOGGER.info("Test: testGetInterval");

		// Arrange
		final Long intervalExpected = Long.valueOf(604_800_000L);

		final Calendar calendar = Calendar.getInstance();
		calendar.set(2017, 3, 7);
		final Long time1 = Long.valueOf(calendar.getTimeInMillis());

		calendar.set(2017, 3, 14);
		final Long time2 = Long.valueOf(calendar.getTimeInMillis());

		final TimeSlice timeSlice = new TimeSlice(time1, time2);

		// Act
		final Long intervalActual = timeSlice.getInterval();

		// Assert
		Assert.assertTrue(intervalExpected.compareTo(intervalActual) == 0);
	}

	@Test
	public void testToString_YearBasedOnFirstOfMonth()
	{
		LOGGER.info("Test: testToString_YearBasedOnFirstOfMonth");

		// Arrange
		final String intervalExpected = "year";

		final Calendar calendar = Calendar.getInstance();
		calendar.set(2017, 0, 1);
		final Long time1 = Long.valueOf(calendar.getTimeInMillis());

		calendar.set(2018, 0, 1);
		final Long time2 = Long.valueOf(calendar.getTimeInMillis());

		final TimeSlice timeSlice = new TimeSlice(time1, time2);

		// Act
		final String intervalActual = timeSlice.toString();

		// Assert
		Assert.assertEquals(intervalExpected, intervalActual);
	}

	@Test
	public void testToString_YearBasedOnCalendarYear()
	{
		LOGGER.info("Test: testToString_YearBasedOnCalendarYear");

		// Arrange
		final String intervalExpected = "year";

		final Calendar calendar = Calendar.getInstance();
		calendar.set(2017, 3, 10);
		final Long time1 = Long.valueOf(calendar.getTimeInMillis());

		calendar.set(2018, 3, 9);
		final Long time2 = Long.valueOf(calendar.getTimeInMillis());

		final TimeSlice timeSlice = new TimeSlice(time1, time2);

		// Act
		final String intervalActual = timeSlice.toString();

		// Assert
		Assert.assertEquals(intervalExpected, intervalActual);
	}

	@Test
	public void testToString_4YearsBasedOnFirstOfMonth()
	{
		LOGGER.info("Test: testToString_4YearsBasedOnFirstOfMonth");

		// Arrange
		final String intervalExpected = "4 years";

		final Calendar calendar = Calendar.getInstance();
		calendar.set(2014, 0, 1);
		final Long time1 = Long.valueOf(calendar.getTimeInMillis());

		calendar.set(2018, 0, 1);
		final Long time2 = Long.valueOf(calendar.getTimeInMillis());

		final TimeSlice timeSlice = new TimeSlice(time1, time2);

		// Act
		final String intervalActual = timeSlice.toString();

		// Assert
		Assert.assertEquals(intervalExpected, intervalActual);
	}

	@Test
	public void testToString_3YearsBasedOnCalendarYear()
	{
		LOGGER.info("Test: testToString_3YearsBasedOnCalendarYear");

		// Arrange
		final String intervalExpected = "3 years";

		final Calendar calendar = Calendar.getInstance();
		calendar.set(2015, 3, 6);
		final Long time1 = Long.valueOf(calendar.getTimeInMillis());

		calendar.set(2018, 3, 9);
		final Long time2 = Long.valueOf(calendar.getTimeInMillis());

		final TimeSlice timeSlice = new TimeSlice(time1, time2);

		// Act
		final String intervalActual = timeSlice.toString();

		// Assert
		Assert.assertEquals(intervalExpected, intervalActual);
	}

	@Test
	public void testToString_Month()
	{
		LOGGER.info("Test: testToString_Month");

		// Arrange
		final String intervalExpected = "month";

		final Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 2, 9);
		final Long time1 = Long.valueOf(calendar.getTimeInMillis());

		calendar.set(2018, 3, 9);
		final Long time2 = Long.valueOf(calendar.getTimeInMillis());

		final TimeSlice timeSlice = new TimeSlice(time1, time2);

		// Act
		final String intervalActual = timeSlice.toString();

		// Assert
		Assert.assertEquals(intervalExpected, intervalActual);
	}

	@Test
	public void testToString_5Months()
	{
		LOGGER.info("Test: testToString_Month");

		// Arrange
		final String intervalExpected = "5 months";

		final Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 2, 9);
		final Long time1 = Long.valueOf(calendar.getTimeInMillis());

		calendar.set(2018, 7, 9);
		final Long time2 = Long.valueOf(calendar.getTimeInMillis());

		final TimeSlice timeSlice = new TimeSlice(time1, time2);

		// Act
		final String intervalActual = timeSlice.toString();

		// Assert
		Assert.assertEquals(intervalExpected, intervalActual);
	}

	@Test
	public void testToString_Week()
	{
		LOGGER.info("Test: testToString_Week");

		// Arrange
		final String intervalExpected = "week";

		final Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 3, 2);
		final Long time1 = Long.valueOf(calendar.getTimeInMillis());

		calendar.set(2018, 3, 9);
		final Long time2 = Long.valueOf(calendar.getTimeInMillis());

		final TimeSlice timeSlice = new TimeSlice(time1, time2);

		// Act
		final String intervalActual = timeSlice.toString();

		// Assert
		Assert.assertEquals(intervalExpected, intervalActual);
	}

	@Test
	public void testToString_2Weeks()
	{
		LOGGER.info("Test: testToString_2Weeks");

		// Arrange
		final String intervalExpected = "2 weeks";

		final Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 3, 2);
		final Long time1 = Long.valueOf(calendar.getTimeInMillis());

		calendar.set(2018, 3, 16);
		final Long time2 = Long.valueOf(calendar.getTimeInMillis());

		final TimeSlice timeSlice = new TimeSlice(time1, time2);

		// Act
		final String intervalActual = timeSlice.toString();

		// Assert
		Assert.assertEquals(intervalExpected, intervalActual);
	}

	@Test
	public void testToString_Day()
	{
		LOGGER.info("Test: testToString_Day");

		// Arrange
		final String intervalExpected = "day";

		final Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 3, 8);
		final Long time1 = Long.valueOf(calendar.getTimeInMillis());

		calendar.set(2018, 3, 9);
		final Long time2 = Long.valueOf(calendar.getTimeInMillis());

		final TimeSlice timeSlice = new TimeSlice(time1, time2);

		// Act
		final String intervalActual = timeSlice.toString();

		// Assert
		Assert.assertEquals(intervalExpected, intervalActual);
	}

	@Test
	public void testToString_3Days()
	{
		LOGGER.info("Test: testToString_3Days");

		// Arrange
		final String intervalExpected = "3 days";

		final Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 3, 13);
		final Long time1 = Long.valueOf(calendar.getTimeInMillis());

		calendar.set(2018, 3, 16);
		final Long time2 = Long.valueOf(calendar.getTimeInMillis());

		final TimeSlice timeSlice = new TimeSlice(time1, time2);

		// Act
		final String intervalActual = timeSlice.toString();

		// Assert
		Assert.assertEquals(intervalExpected, intervalActual);
	}

	@Test
	public void testToString_40Days()
	{
		LOGGER.info("Test: testToString_40Days");

		// Arrange
		final String intervalExpected = "40 days";

		final Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 3, 13);
		final Long time1 = Long.valueOf(calendar.getTimeInMillis());

		calendar.set(2018, 4, 23);
		final Long time2 = Long.valueOf(calendar.getTimeInMillis());

		final TimeSlice timeSlice = new TimeSlice(time1, time2);

		// Act
		final String intervalActual = timeSlice.toString();

		// Assert
		Assert.assertEquals(intervalExpected, intervalActual);
	}
}
