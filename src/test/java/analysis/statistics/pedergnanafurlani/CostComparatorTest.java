// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.statistics.pedergnanafurlani;

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
import analysis.graph.Segment;
import analysis.utilities.GlobalConstants;

public class CostComparatorTest
{
	private static Logger LOGGER;

	private Calendar calendar;
	private SegmentPair pair1;

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
		LOGGER = LogManager.getLogger("CostComparatorTest.class");
	}

	@Before
	public void setupTest()
	{
		this.calendar = Calendar.getInstance();

		this.calendar.set(2018, 4, 1);
		final Long date1a = Long.valueOf(this.calendar.getTimeInMillis());
		final Point point1 = new Point(GlobalConstants.ONE, GlobalConstants.ONE, date1a);

		this.calendar.set(2018, 4, 2);
		final Long date2a = Long.valueOf(this.calendar.getTimeInMillis());
		final Point point2 = new Point(new BigDecimal("4"), new BigDecimal("5"), date2a);

		this.calendar.set(2018, 4, 8);
		final Long date1b = Long.valueOf(this.calendar.getTimeInMillis());
		final Point point3 = new Point(new BigDecimal("2"), new BigDecimal("2"), date1b);

		this.calendar.set(2018, 4, 9);
		final Long date2b = Long.valueOf(this.calendar.getTimeInMillis());
		final Point point4 = new Point(new BigDecimal("5"), new BigDecimal("6"), date2b);

		final Segment segment1 = new Segment(point1, point2);
		final Segment segment2 = new Segment(point3, point4);
		this.pair1 = new SegmentPair(segment1, segment2);
	}

	@Test
	public void testCompare_Equals()
	{
		LOGGER.info("Test: testCompare_Equals");

		this.calendar.set(2018, 4, 3);
		final Long date3a = Long.valueOf(this.calendar.getTimeInMillis());
		final Point point5 = new Point(new BigDecimal("2"), new BigDecimal("2"), date3a);

		this.calendar.set(2018, 4, 4);
		final Long date4a = Long.valueOf(this.calendar.getTimeInMillis());
		Point point6 = new Point(new BigDecimal("5"), new BigDecimal("6"), date4a);

		this.calendar.set(2018, 4, 10);
		final Long date3b = Long.valueOf(this.calendar.getTimeInMillis());
		final Point point7 = new Point(new BigDecimal("3"), new BigDecimal("3"), date3b);

		this.calendar.set(2018, 4, 11);
		final Long date4b = Long.valueOf(this.calendar.getTimeInMillis());
		final Point point8 = new Point(new BigDecimal("6"), new BigDecimal("7"), date4b);

		final Segment segment3 = new Segment(point5, point6);
		final Segment segment4 = new Segment(point7, point8);

		final SegmentPair pair2 = new SegmentPair(segment3, segment4);

		// Assert
		Assert.assertTrue(new CostComparator().compare(this.pair1, pair2) == 0);
	}

	@Test
	public void testCompare_DoesNotEqual_Segment1Point1()
	{
		LOGGER.info("Test: testCompare_DoesNotEqual_Segment1Point1");

		this.calendar.set(2018, 4, 3);
		final Long date3a = Long.valueOf(this.calendar.getTimeInMillis());
		final Point point5 = new Point(new BigDecimal("2"), new BigDecimal("3"), date3a);

		this.calendar.set(2018, 4, 4);
		final Long date4a = Long.valueOf(this.calendar.getTimeInMillis());
		Point point6 = new Point(new BigDecimal("5"), new BigDecimal("6"), date4a);

		this.calendar.set(2018, 4, 10);
		final Long date3b = Long.valueOf(this.calendar.getTimeInMillis());
		final Point point7 = new Point(new BigDecimal("3"), new BigDecimal("3"), date3b);

		this.calendar.set(2018, 4, 11);
		final Long date4b = Long.valueOf(this.calendar.getTimeInMillis());
		final Point point8 = new Point(new BigDecimal("6"), new BigDecimal("7"), date4b);

		final Segment segment3 = new Segment(point5, point6);
		final Segment segment4 = new Segment(point7, point8);

		final SegmentPair pair2 = new SegmentPair(segment3, segment4);

		// Assert
		Assert.assertFalse(new CostComparator().compare(this.pair1, pair2) == 0);
	}

	@Test
	public void testCompare_DoesNotEqual_Segment2Point2()
	{
		LOGGER.info("Test: testCompare_DoesNotEqual_Segment2Point2");

		this.calendar.set(2018, 4, 3);
		final Long date3a = Long.valueOf(this.calendar.getTimeInMillis());
		final Point point5 = new Point(new BigDecimal("2"), new BigDecimal("2"), date3a);

		this.calendar.set(2018, 4, 4);
		final Long date4a = Long.valueOf(this.calendar.getTimeInMillis());
		Point point6 = new Point(new BigDecimal("5"), new BigDecimal("6"), date4a);

		this.calendar.set(2018, 4, 10);
		final Long date3b = Long.valueOf(this.calendar.getTimeInMillis());
		final Point point7 = new Point(new BigDecimal("3"), new BigDecimal("3"), date3b);

		this.calendar.set(2018, 4, 11);
		final Long date4b = Long.valueOf(this.calendar.getTimeInMillis());
		final Point point8 = new Point(new BigDecimal("6"), new BigDecimal("8"), date4b);

		final Segment segment3 = new Segment(point5, point6);
		final Segment segment4 = new Segment(point7, point8);

		final SegmentPair pair2 = new SegmentPair(segment3, segment4);

		// Assert
		Assert.assertFalse(new CostComparator().compare(this.pair1, pair2) == 0);
	}

	@Test
	public void testCompare_LessThan()
	{
		LOGGER.info("Test: testCompare_LessThan");

		this.calendar.set(2018, 4, 3);
		final Long date3a = Long.valueOf(this.calendar.getTimeInMillis());
		final Point point5 = new Point(new BigDecimal("2"), new BigDecimal("2"), date3a);

		this.calendar.set(2018, 4, 4);
		final Long date4a = Long.valueOf(this.calendar.getTimeInMillis());
		Point point6 = new Point(new BigDecimal("5"), new BigDecimal("6"), date4a);

		this.calendar.set(2018, 4, 10);
		final Long date3b = Long.valueOf(this.calendar.getTimeInMillis());
		final Point point7 = new Point(new BigDecimal("3"), new BigDecimal("3"), date3b);

		this.calendar.set(2018, 4, 11);
		final Long date4b = Long.valueOf(this.calendar.getTimeInMillis());
		final Point point8 = new Point(new BigDecimal("5"), new BigDecimal("6"), date4b);

		final Segment segment3 = new Segment(point5, point6);
		final Segment segment4 = new Segment(point7, point8);

		final SegmentPair pair2 = new SegmentPair(segment3, segment4);

		// Assert
		Assert.assertTrue(new CostComparator().compare(this.pair1, pair2) < 0);
	}

	@Test
	public void testCompare_GreaterThan()
	{
		LOGGER.info("Test: testCompare_GreaterThan");

		this.calendar.set(2018, 4, 3);
		final Long date3a = Long.valueOf(this.calendar.getTimeInMillis());
		final Point point5 = new Point(new BigDecimal("2"), new BigDecimal("2"), date3a);

		this.calendar.set(2018, 4, 4);
		final Long date4a = Long.valueOf(this.calendar.getTimeInMillis());
		Point point6 = new Point(new BigDecimal("5"), new BigDecimal("6"), date4a);

		this.calendar.set(2018, 4, 10);
		final Long date3b = Long.valueOf(this.calendar.getTimeInMillis());
		final Point point7 = new Point(new BigDecimal("3"), new BigDecimal("3"), date3b);

		this.calendar.set(2018, 4, 11);
		final Long date4b = Long.valueOf(this.calendar.getTimeInMillis());
		final Point point8 = new Point(new BigDecimal("9"), new BigDecimal("10"), date4b);

		final Segment segment3 = new Segment(point5, point6);
		final Segment segment4 = new Segment(point7, point8);

		final SegmentPair pair2 = new SegmentPair(segment3, segment4);

		// Assert
		Assert.assertTrue(new CostComparator().compare(this.pair1, pair2) > 0);
	}
}
