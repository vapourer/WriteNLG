// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.statistics.pedergnanafurlani;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import analysis.TestConstants;
import analysis.graph.Point;
import analysis.graph.Segment;

public class SegmentStartTimeComparatorTest
{
	private static Logger LOGGER;

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
		LOGGER = LogManager.getLogger("SegmentStartTimeComparatorTest.class");
	}

	@Test
	public void testCompare()
	{
		LOGGER.info("Test: testCompare");

		// Arrange
		final BigDecimal firstPoint1Expected = new BigDecimal("7");
		final BigDecimal secondPoint1Expected = new BigDecimal("11");
		final BigDecimal thirdPoint1Expected = new BigDecimal("14");

		final Calendar calendar = Calendar.getInstance();

		calendar.set(2018, 4, 12);
		final Long date1 = Long.valueOf(calendar.getTimeInMillis());
		final Point point1 = new Point(new BigDecimal("14"), new BigDecimal("1"), date1);

		calendar.set(2018, 4, 16);
		final Long date2 = Long.valueOf(calendar.getTimeInMillis());
		final Point point2 = new Point(new BigDecimal("18"), new BigDecimal("5"), date2);

		final Segment segment1 = new Segment(point1, point2);

		calendar.set(2018, 4, 5);
		final Long date3 = Long.valueOf(calendar.getTimeInMillis());
		final Point point3 = new Point(new BigDecimal("7"), new BigDecimal("5"), date3);

		calendar.set(2018, 4, 7);
		final Long date4 = Long.valueOf(calendar.getTimeInMillis());
		final Point point4 = new Point(new BigDecimal("9"), new BigDecimal("12"), date4);

		final Segment segment2 = new Segment(point3, point4);

		calendar.set(2018, 4, 9);
		final Long date5 = Long.valueOf(calendar.getTimeInMillis());
		final Point point5 = new Point(new BigDecimal("11"), new BigDecimal("5"), date5);

		calendar.set(2018, 4, 11);
		final Long date6 = Long.valueOf(calendar.getTimeInMillis());
		final Point point6 = new Point(new BigDecimal("13"), new BigDecimal("12"), date6);

		final Segment segment3 = new Segment(point5, point6);

		// Act
		SortedSet<Segment> segments = new TreeSet<>(new SegmentStartTimeComparator());
		segments.add(segment1);
		segments.add(segment2);
		segments.add(segment3);

		Segment[] segmentArray = segments.toArray(new Segment[0]);

		// Assert
		Assert.assertTrue(firstPoint1Expected.compareTo(segmentArray[0].getPoint1().getX()) == 0);
		Assert.assertTrue(secondPoint1Expected.compareTo(segmentArray[1].getPoint1().getX()) == 0);
		Assert.assertTrue(thirdPoint1Expected.compareTo(segmentArray[2].getPoint1().getX()) == 0);
	}
}
