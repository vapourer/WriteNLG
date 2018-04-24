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
import writenlg.control.WriteNlgProperties;

public class SegmentTest
{
	private static Logger LOGGER;

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
		LOGGER = LogManager.getLogger("SegmentTest.class");
		WriteNlgProperties.createInstance(TestConstants.WRITE_NLG_PROPERTIES_FILE_PATH);
	}

	@Test
	public void testGetEuclideanDistance_IntegerResult()
	{
		LOGGER.info("Test: testGetEuclideanDistance_IntegerResult");

		// Arrange
		final BigDecimal euclideanDistanceExpected = new BigDecimal("5");

		final Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 4, 1);
		final Long date1 = Long.valueOf(calendar.getTimeInMillis());
		calendar.set(2018, 4, 8);
		final Long date2 = Long.valueOf(calendar.getTimeInMillis());

		final Point point1 = new Point(new BigDecimal("1"), new BigDecimal("1"), date1);
		final Point point2 = new Point(new BigDecimal("4"), new BigDecimal("5"), date2);

		final Segment segment = new Segment(point1, point2);

		// Act
		final BigDecimal euclideanDistanceActual = segment.getEuclideanDistance();

		// Assert
		Assert.assertTrue(euclideanDistanceExpected.compareTo(euclideanDistanceActual) == 0);
	}

	@Test
	public void testGetEuclideanDistance_FloatingPointResult()
	{
		LOGGER.info("Test: testGetEuclideanDistance_FloatingPointResult");

		// Arrange
		final BigDecimal euclideanDistanceExpected = new BigDecimal("7.2111");

		final Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 4, 1);
		final Long date1 = Long.valueOf(calendar.getTimeInMillis());
		calendar.set(2018, 4, 8);
		final Long date2 = Long.valueOf(calendar.getTimeInMillis());

		final Point point1 = new Point(new BigDecimal("1"), new BigDecimal("1"), date1);
		final Point point2 = new Point(new BigDecimal("5"), new BigDecimal("7"), date2);

		final Segment segment = new Segment(point1, point2);

		// Act
		final BigDecimal euclideanDistanceActual = segment.getEuclideanDistance();
		final MathContext context = new MathContext(6);
		final BigDecimal euclideanDistanceActualRounded = euclideanDistanceActual.round(context);

		// Assert
		Assert.assertTrue(euclideanDistanceExpected.compareTo(euclideanDistanceActualRounded) == 0);
	}

	@Test
	public void testGetGradient_Positive()
	{
		LOGGER.info("Test: testGetGradient_Positive");

		// Arrange
		BigDecimal gradientExpected = new BigDecimal("1.5");

		final Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 4, 1);
		final Long date1 = Long.valueOf(calendar.getTimeInMillis());
		calendar.set(2018, 4, 8);
		final Long date2 = Long.valueOf(calendar.getTimeInMillis());

		final Point point1 = new Point(new BigDecimal("1"), new BigDecimal("1"), date1);
		final Point point2 = new Point(new BigDecimal("5"), new BigDecimal("7"), date2);

		final Segment segment = new Segment(point1, point2);

		// Act
		BigDecimal gradientActual = segment.getGradient();

		// Assert
		Assert.assertTrue(gradientExpected.compareTo(gradientActual) == 0);
	}

	@Test
	public void testGetGradient_Negative()
	{
		LOGGER.info("Test: testGetGradient_Negative");

		// Arrange
		BigDecimal gradientExpected = new BigDecimal("-2.5");

		final Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 4, 1);
		final Long date1 = Long.valueOf(calendar.getTimeInMillis());
		calendar.set(2018, 4, 8);
		final Long date2 = Long.valueOf(calendar.getTimeInMillis());

		final Point point1 = new Point(new BigDecimal("1"), new BigDecimal("14"), date1);
		final Point point2 = new Point(new BigDecimal("5"), new BigDecimal("4"), date2);

		final Segment segment = new Segment(point1, point2);

		// Act
		BigDecimal gradientActual = segment.getGradient();

		// Assert
		Assert.assertTrue(gradientExpected.compareTo(gradientActual) == 0);
	}

	@Test
	public void testGetGradient_Flat()
	{
		LOGGER.info("Test: testGetGradient_Flat");

		// Arrange
		BigDecimal gradientExpected = new BigDecimal("0");

		final Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 4, 1);
		final Long date1 = Long.valueOf(calendar.getTimeInMillis());
		calendar.set(2018, 4, 8);
		final Long date2 = Long.valueOf(calendar.getTimeInMillis());

		final Point point1 = new Point(new BigDecimal("1"), new BigDecimal("23"), date1);
		final Point point2 = new Point(new BigDecimal("5"), new BigDecimal("23"), date2);

		final Segment segment = new Segment(point1, point2);

		// Act
		BigDecimal gradientActual = segment.getGradient();

		// Assert
		Assert.assertTrue(gradientExpected.compareTo(gradientActual) == 0);
	}

	@Test
	public void testGetSlope_Positive()
	{
		LOGGER.info("Test: testGetSlope_Positive");

		// Arrange
		Slope slopeExpected = Slope.ASCENDING;

		final Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 4, 1);
		final Long date1 = Long.valueOf(calendar.getTimeInMillis());
		calendar.set(2018, 4, 8);
		final Long date2 = Long.valueOf(calendar.getTimeInMillis());

		final Point point1 = new Point(new BigDecimal("1"), new BigDecimal("1"), date1);
		final Point point2 = new Point(new BigDecimal("5"), new BigDecimal("7"), date2);

		final Segment segment = new Segment(point1, point2);

		// Act
		Slope slopeActual = segment.getSlope();

		// Assert
		Assert.assertTrue(slopeExpected == slopeActual);
	}

	@Test
	public void testGetSlope_Negative()
	{
		LOGGER.info("Test: testGetSlope_Negative");

		// Arrange
		Slope slopeExpected = Slope.DESCENDING;

		final Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 4, 1);
		final Long date1 = Long.valueOf(calendar.getTimeInMillis());
		calendar.set(2018, 4, 8);
		final Long date2 = Long.valueOf(calendar.getTimeInMillis());

		final Point point1 = new Point(new BigDecimal("1"), new BigDecimal("14"), date1);
		final Point point2 = new Point(new BigDecimal("5"), new BigDecimal("4"), date2);

		final Segment segment = new Segment(point1, point2);

		// Act
		Slope slopeActual = segment.getSlope();

		// Assert
		Assert.assertTrue(slopeExpected == slopeActual);
	}

	@Test
	public void testGetSlope_Flat()
	{
		LOGGER.info("Test: testGetSlope_Flat");

		// Arrange
		Slope slopeExpected = Slope.FLAT;

		final Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 4, 1);
		final Long date1 = Long.valueOf(calendar.getTimeInMillis());
		calendar.set(2018, 4, 8);
		final Long date2 = Long.valueOf(calendar.getTimeInMillis());

		final Point point1 = new Point(new BigDecimal("1"), new BigDecimal("23"), date1);
		final Point point2 = new Point(new BigDecimal("5"), new BigDecimal("23"), date2);

		final Segment segment = new Segment(point1, point2);

		// Act
		Slope slopeActual = segment.getSlope();

		// Assert
		Assert.assertTrue(slopeExpected == slopeActual);
	}
}
