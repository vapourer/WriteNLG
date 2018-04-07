package analysis.statistics.engineeringstatisticshandbook;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Test;

import analysis.TestConstants;
import analysis.graph.TimeSeries;
import analysis.statistics.engineeringstatisticshandbook.CentredMovingAverage;

public class CentredMovingAverageTest
{
	@Test
	public void testSmoothGraph()
	{
		// Arrange
		SortedMap<Long, BigDecimal> smoothedGraphExpected = createSmoothedGraphExpected();
		Long[] timesExpected = smoothedGraphExpected.keySet().toArray(new Long[0]);

		TimeSeries timeSeries = new TimeSeries(TestConstants.TIMES_FOR_MOVING_AVERAGE_TEST,
				TestConstants.VALUES_FOR_MOVING_AVERAGE_TEST);

		CentredMovingAverage centredMovingAverage = new CentredMovingAverage(timeSeries.getTimeSeries(), 5);

		// Act
		SortedMap<Long, BigDecimal> smoothedGraphActual = centredMovingAverage.averageGraph();
		Long[] timesActual = smoothedGraphActual.keySet().toArray(new Long[0]);

		// Assert
		Assert.assertEquals(smoothedGraphExpected.size(), smoothedGraphActual.size());

		int smoothedGraphSize = smoothedGraphExpected.size();

		Calendar calendar = Calendar.getInstance();

		for (int i = 0; i < smoothedGraphSize; i++)
		{
			calendar.setTimeInMillis(timesExpected[i]);

			int yearExpected = calendar.get(Calendar.YEAR);
			int monthExpected = calendar.get(Calendar.MONTH);
			int dayExpected = calendar.get(Calendar.DAY_OF_MONTH);

			calendar.setTimeInMillis(timesActual[i]);

			int yearActual = calendar.get(Calendar.YEAR);
			int monthActual = calendar.get(Calendar.MONTH);
			int dayActual = calendar.get(Calendar.DAY_OF_MONTH);

			Assert.assertTrue(yearExpected == yearActual);
			Assert.assertTrue(monthExpected == monthActual);
			Assert.assertTrue(dayExpected == dayActual);
		}

		Assert.assertArrayEquals(smoothedGraphExpected.values().toArray(new BigDecimal[0]),
				smoothedGraphActual.values().toArray(new BigDecimal[0]));
	}

	private SortedMap<Long, BigDecimal> createSmoothedGraphExpected()
	{
		SortedMap<Long, BigDecimal> smoothedGraphExpected = new TreeMap<>();

		Calendar calendar = Calendar.getInstance();

		calendar.set(2017, Calendar.JANUARY, 20);
		Long date1 = Long.valueOf(calendar.getTimeInMillis());
		smoothedGraphExpected.put(date1, new BigDecimal("12935.6"));

		calendar.set(2017, Calendar.JANUARY, 27);
		Long date2 = Long.valueOf(calendar.getTimeInMillis());
		smoothedGraphExpected.put(date2, new BigDecimal("12991.2"));

		calendar.set(2017, Calendar.FEBRUARY, 3);
		Long date3 = Long.valueOf(calendar.getTimeInMillis());
		smoothedGraphExpected.put(date3, new BigDecimal("12577"));

		calendar.set(2017, Calendar.FEBRUARY, 10);
		Long date4 = Long.valueOf(calendar.getTimeInMillis());
		smoothedGraphExpected.put(date4, new BigDecimal("12213.8"));

		calendar.set(2017, Calendar.FEBRUARY, 17);
		Long date5 = Long.valueOf(calendar.getTimeInMillis());
		smoothedGraphExpected.put(date5, new BigDecimal("11888"));

		calendar.set(2017, Calendar.FEBRUARY, 24);
		Long date6 = Long.valueOf(calendar.getTimeInMillis());
		smoothedGraphExpected.put(date6, new BigDecimal("11606.4"));

		calendar.set(2017, Calendar.MARCH, 3);
		Long date7 = Long.valueOf(calendar.getTimeInMillis());
		smoothedGraphExpected.put(date7, new BigDecimal("11292"));

		calendar.set(2017, Calendar.MARCH, 10);
		Long date8 = Long.valueOf(calendar.getTimeInMillis());
		smoothedGraphExpected.put(date8, new BigDecimal("11028.2"));

		calendar.set(2017, Calendar.MARCH, 17);
		Long date9 = Long.valueOf(calendar.getTimeInMillis());
		smoothedGraphExpected.put(date9, new BigDecimal("10674.8"));

		calendar.set(2017, Calendar.MARCH, 24);
		Long date10 = Long.valueOf(calendar.getTimeInMillis());
		smoothedGraphExpected.put(date10, new BigDecimal("10413"));

		calendar.set(2017, Calendar.MARCH, 31);
		Long date11 = Long.valueOf(calendar.getTimeInMillis());
		smoothedGraphExpected.put(date11, new BigDecimal("9896.2"));

		calendar.set(2017, Calendar.APRIL, 7);
		Long date12 = Long.valueOf(calendar.getTimeInMillis());
		smoothedGraphExpected.put(date12, new BigDecimal("9685.6"));

		calendar.set(2017, Calendar.APRIL, 14);
		Long date13 = Long.valueOf(calendar.getTimeInMillis());
		smoothedGraphExpected.put(date13, new BigDecimal("9802.2"));

		calendar.set(2017, Calendar.APRIL, 21);
		Long date14 = Long.valueOf(calendar.getTimeInMillis());
		smoothedGraphExpected.put(date14, new BigDecimal("9609.6"));

		calendar.set(2017, Calendar.APRIL, 28);
		Long date15 = Long.valueOf(calendar.getTimeInMillis());
		smoothedGraphExpected.put(date15, new BigDecimal("9760.4"));

		calendar.set(2017, Calendar.MAY, 5);
		Long date16 = Long.valueOf(calendar.getTimeInMillis());
		smoothedGraphExpected.put(date16, new BigDecimal("10119.4"));

		calendar.set(2017, Calendar.MAY, 12);
		Long date17 = Long.valueOf(calendar.getTimeInMillis());
		smoothedGraphExpected.put(date17, new BigDecimal("10198.6"));

		calendar.set(2017, Calendar.MAY, 19);
		Long date18 = Long.valueOf(calendar.getTimeInMillis());
		smoothedGraphExpected.put(date18, new BigDecimal("9683.4"));

		calendar.set(2017, Calendar.MAY, 26);
		Long date19 = Long.valueOf(calendar.getTimeInMillis());
		smoothedGraphExpected.put(date19, new BigDecimal("9823.8"));

		calendar.set(2017, Calendar.JUNE, 2);
		Long date20 = Long.valueOf(calendar.getTimeInMillis());
		smoothedGraphExpected.put(date20, new BigDecimal("9558.6"));

		calendar.set(2017, Calendar.JUNE, 9);
		Long date21 = Long.valueOf(calendar.getTimeInMillis());
		smoothedGraphExpected.put(date21, new BigDecimal("9426.4"));

		calendar.set(2017, Calendar.JUNE, 16);
		Long date22 = Long.valueOf(calendar.getTimeInMillis());
		smoothedGraphExpected.put(date22, new BigDecimal("9285.2"));

		return smoothedGraphExpected;
	}
}
