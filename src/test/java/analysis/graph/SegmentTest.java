package analysis.graph;

import java.math.BigDecimal;
import java.math.MathContext;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.icu.util.Calendar;

public class SegmentTest
{
	@Test
	public void testGetEuclideanDistance_IntegerResult()
	{
		// Arrange
		final BigDecimal euclideanDistanceExpected = new BigDecimal("5");
		final Point point1 = new Point(new BigDecimal("1"), new BigDecimal("1"));
		final Point point2 = new Point(new BigDecimal("4"), new BigDecimal("5"));

		final Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 4, 1);
		final Long date1 = Long.valueOf(calendar.getTimeInMillis());
		calendar.set(2018, 4, 8);
		final Long date2 = Long.valueOf(calendar.getTimeInMillis());

		final Segment segment = new Segment(point1, point2, date1, date2);

		// Act
		final BigDecimal euclideanDistanceActual = segment.getEuclideanDistance();

		// Assert
		Assert.assertTrue(euclideanDistanceExpected.compareTo(euclideanDistanceActual) == 0);
	}

	@Test
	public void testGetEuclideanDistance_FloatingPointResult()
	{
		// Arrange
		final BigDecimal euclideanDistanceExpected = new BigDecimal("7.2111");
		final Point point1 = new Point(new BigDecimal("1"), new BigDecimal("1"));
		final Point point2 = new Point(new BigDecimal("5"), new BigDecimal("7"));

		final Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 4, 1);
		final Long date1 = Long.valueOf(calendar.getTimeInMillis());
		calendar.set(2018, 4, 8);
		final Long date2 = Long.valueOf(calendar.getTimeInMillis());

		final Segment segment = new Segment(point1, point2, date1, date2);

		// Act
		final BigDecimal euclideanDistanceActual = segment.getEuclideanDistance();
		final MathContext context = new MathContext(6);
		final BigDecimal euclideanDistanceActualRounded = euclideanDistanceActual.round(context);

		// Assert
		Assert.assertTrue(euclideanDistanceExpected.compareTo(euclideanDistanceActualRounded) == 0);
	}
}
