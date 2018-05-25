// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.statistics;

import java.math.BigDecimal;
import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import analysis.TestConstants;
import analysis.graph.Point;
import analysis.utilities.GlobalConstants;

public class PointYValueComparatorTest
{
	private static Logger LOGGER;

	private Calendar calendar;
	private Point point1;
	private Long date2;

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
		LOGGER = LogManager.getLogger("PointYValueComparatorTest.class");
	}

	@Before
	public void setupTest()
	{
		this.calendar = Calendar.getInstance();

		this.calendar.set(2018, 4, 1);
		final Long date1 = Long.valueOf(this.calendar.getTimeInMillis());
		this.point1 = new Point(GlobalConstants.ONE, new BigDecimal("7"), date1);

		this.calendar.set(2018, 4, 2);
		this.date2 = Long.valueOf(this.calendar.getTimeInMillis());
	}

	@Test
	public void testCompare_Equals()
	{
		LOGGER.info("Test: testCompare_Equals");

		// Arrange
		final Point point2 = new Point(new BigDecimal("2"), new BigDecimal("7"), this.date2);

		// Assert
		Assert.assertTrue(new PointYValueComparator().compare(this.point1, point2) == 0);
	}

	@Test
	public void testCompare_NotEquals()
	{
		LOGGER.info("Test: testCompare_NotEquals");

		// Arrange
		final Point point2 = new Point(new BigDecimal("2"), new BigDecimal("6"), this.date2);

		// Assert
		Assert.assertFalse(new PointYValueComparator().compare(this.point1, point2) == 0);
	}

	@Test
	public void testCompare_Point1LessThanPoint2()
	{
		LOGGER.info("Test: testCompare_Point1LessThanPoint2");

		// Arrange
		final Point point2 = new Point(new BigDecimal("2"), new BigDecimal("9"), this.date2);

		// Assert
		Assert.assertTrue(new PointYValueComparator().compare(this.point1, point2) < 0);
	}

	@Test
	public void testCompare_Point1GreaterThanPoint2()
	{
		LOGGER.info("Test: testCompare_Point1GreaterThanPoint2");

		// Arrange
		final Point point2 = new Point(new BigDecimal("2"), new BigDecimal("5"), this.date2);

		// Assert
		Assert.assertTrue(new PointYValueComparator().compare(this.point1, point2) > 0);
	}
}
