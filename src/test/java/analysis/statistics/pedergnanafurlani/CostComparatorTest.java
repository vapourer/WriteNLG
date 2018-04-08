package analysis.statistics.pedergnanafurlani;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import analysis.graph.Point;
import analysis.graph.Segment;

public class CostComparatorTest
{
	private final static Point POINT_1 = new Point(new BigDecimal("1"), new BigDecimal("1"));
	private final static Point POINT_2 = new Point(new BigDecimal("4"), new BigDecimal("5"));
	private final static Point POINT_3 = new Point(new BigDecimal("2"), new BigDecimal("2"));
	private final static Point POINT_4 = new Point(new BigDecimal("5"), new BigDecimal("6"));

	private Calendar calendar;
	private SegmentPair pair1;

	@Before
	public void setupTest()
	{
		this.calendar = Calendar.getInstance();

		this.calendar.set(2018, 4, 1);
		final Long date1a = Long.valueOf(this.calendar.getTimeInMillis());

		this.calendar.set(2018, 4, 2);
		final Long date2a = Long.valueOf(this.calendar.getTimeInMillis());

		this.calendar.set(2018, 4, 8);
		final Long date1b = Long.valueOf(this.calendar.getTimeInMillis());

		this.calendar.set(2018, 4, 9);
		final Long date2b = Long.valueOf(this.calendar.getTimeInMillis());

		final Segment segment1 = new Segment(POINT_1, POINT_2, date1a, date1b);
		final Segment segment2 = new Segment(POINT_3, POINT_4, date2a, date2b);
		this.pair1 = new SegmentPair(segment1, segment2);
	}

	@Test
	public void testCompare_Equals()
	{
		final Point point5 = new Point(new BigDecimal("2"), new BigDecimal("2"));
		final Point point6 = new Point(new BigDecimal("5"), new BigDecimal("6"));
		final Point point7 = new Point(new BigDecimal("3"), new BigDecimal("3"));
		final Point point8 = new Point(new BigDecimal("6"), new BigDecimal("7"));

		this.calendar.set(2018, 4, 3);
		final Long date3a = Long.valueOf(this.calendar.getTimeInMillis());

		this.calendar.set(2018, 4, 4);
		final Long date4a = Long.valueOf(this.calendar.getTimeInMillis());

		this.calendar.set(2018, 4, 10);
		final Long date3b = Long.valueOf(this.calendar.getTimeInMillis());

		this.calendar.set(2018, 4, 11);
		final Long date4b = Long.valueOf(this.calendar.getTimeInMillis());

		final Segment segment3 = new Segment(point5, point6, date3a, date3b);
		final Segment segment4 = new Segment(point7, point8, date4a, date4b);

		final SegmentPair pair2 = new SegmentPair(segment3, segment4);

		// Assert
		Assert.assertTrue(new CostComparator().compare(this.pair1, pair2) == 0);
	}

	@Test
	public void testCompare_DoesNotEqual_Segment1Point1()
	{
		final Point point5 = new Point(new BigDecimal("2"), new BigDecimal("3"));
		final Point point6 = new Point(new BigDecimal("5"), new BigDecimal("6"));
		final Point point7 = new Point(new BigDecimal("3"), new BigDecimal("3"));
		final Point point8 = new Point(new BigDecimal("6"), new BigDecimal("7"));

		this.calendar.set(2018, 4, 3);
		final Long date3a = Long.valueOf(this.calendar.getTimeInMillis());

		this.calendar.set(2018, 4, 4);
		final Long date4a = Long.valueOf(this.calendar.getTimeInMillis());

		this.calendar.set(2018, 4, 10);
		final Long date3b = Long.valueOf(this.calendar.getTimeInMillis());

		this.calendar.set(2018, 4, 11);
		final Long date4b = Long.valueOf(this.calendar.getTimeInMillis());

		final Segment segment3 = new Segment(point5, point6, date3a, date3b);
		final Segment segment4 = new Segment(point7, point8, date4a, date4b);

		final SegmentPair pair2 = new SegmentPair(segment3, segment4);

		// Assert
		Assert.assertFalse(new CostComparator().compare(this.pair1, pair2) == 0);
	}

	@Test
	public void testCompare_DoesNotEqual_Segment2Point2()
	{
		final Point point5 = new Point(new BigDecimal("2"), new BigDecimal("2"));
		final Point point6 = new Point(new BigDecimal("5"), new BigDecimal("6"));
		final Point point7 = new Point(new BigDecimal("3"), new BigDecimal("3"));
		final Point point8 = new Point(new BigDecimal("6"), new BigDecimal("8"));

		this.calendar.set(2018, 4, 3);
		final Long date3a = Long.valueOf(this.calendar.getTimeInMillis());

		this.calendar.set(2018, 4, 4);
		final Long date4a = Long.valueOf(this.calendar.getTimeInMillis());

		this.calendar.set(2018, 4, 10);
		final Long date3b = Long.valueOf(this.calendar.getTimeInMillis());

		this.calendar.set(2018, 4, 11);
		final Long date4b = Long.valueOf(this.calendar.getTimeInMillis());

		final Segment segment3 = new Segment(point5, point6, date3a, date3b);
		final Segment segment4 = new Segment(point7, point8, date4a, date4b);

		final SegmentPair pair2 = new SegmentPair(segment3, segment4);

		// Assert
		Assert.assertFalse(new CostComparator().compare(this.pair1, pair2) == 0);
	}

	@Test
	public void testCompare_LessThan()
	{
		final Point point5 = new Point(new BigDecimal("2"), new BigDecimal("2"));
		final Point point6 = new Point(new BigDecimal("5"), new BigDecimal("6"));
		final Point point7 = new Point(new BigDecimal("3"), new BigDecimal("3"));
		final Point point8 = new Point(new BigDecimal("5"), new BigDecimal("6"));

		this.calendar.set(2018, 4, 3);
		final Long date3a = Long.valueOf(this.calendar.getTimeInMillis());

		this.calendar.set(2018, 4, 4);
		final Long date4a = Long.valueOf(this.calendar.getTimeInMillis());

		this.calendar.set(2018, 4, 10);
		final Long date3b = Long.valueOf(this.calendar.getTimeInMillis());

		this.calendar.set(2018, 4, 11);
		final Long date4b = Long.valueOf(this.calendar.getTimeInMillis());

		final Segment segment3 = new Segment(point5, point6, date3a, date3b);
		final Segment segment4 = new Segment(point7, point8, date4a, date4b);

		final SegmentPair pair2 = new SegmentPair(segment3, segment4);

		// Assert
		Assert.assertTrue(new CostComparator().compare(this.pair1, pair2) < 0);
	}

	@Test
	public void testCompare_GreaterThan()
	{
		final Point point5 = new Point(new BigDecimal("2"), new BigDecimal("2"));
		final Point point6 = new Point(new BigDecimal("5"), new BigDecimal("6"));
		final Point point7 = new Point(new BigDecimal("3"), new BigDecimal("3"));
		final Point point8 = new Point(new BigDecimal("9"), new BigDecimal("10"));

		this.calendar.set(2018, 4, 3);
		final Long date3a = Long.valueOf(this.calendar.getTimeInMillis());

		this.calendar.set(2018, 4, 4);
		final Long date4a = Long.valueOf(this.calendar.getTimeInMillis());

		this.calendar.set(2018, 4, 10);
		final Long date3b = Long.valueOf(this.calendar.getTimeInMillis());

		this.calendar.set(2018, 4, 11);
		final Long date4b = Long.valueOf(this.calendar.getTimeInMillis());

		final Segment segment3 = new Segment(point5, point6, date3a, date3b);
		final Segment segment4 = new Segment(point7, point8, date4a, date4b);

		final SegmentPair pair2 = new SegmentPair(segment3, segment4);

		// Assert
		Assert.assertTrue(new CostComparator().compare(this.pair1, pair2) > 0);
	}
}
