// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.statistics;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import analysis.LineGraphAnalyser;
import analysis.LineGraphWithDerivedInformation;
import analysis.TestConstants;
import analysis.TimeSeriesWithDerivedInformation;
import analysis.graph.LineGraph;
import control.WriteNlgProperties;

public class TimeSeriesCrossTest
{
	private static Logger LOGGER;

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
		LOGGER = LogManager.getLogger("TimeSeriesCrossTest.class");
		WriteNlgProperties.createInstance(TestConstants.WRITE_NLG_PROPERTIES_FILE_PATH);
	}

	@Test
	public void testIdentifySegmentsWithCrossingPoints_NoCrossingPoints()
	{
		LOGGER.info("Test: testIdentifySegmentsWithCrossingPoints_NoCrossingPoints");

		// Arrange
		final String times1 = "Week ended,08/01/2016,15/01/2016,22/01/2016,29/01/2016,05/02/2016,12/02/2016,19/02/2016,26/02/2016";
		final String values1 = "Deaths 2016,13045,11501,11473,11317,11052,11170,10590,11056";
		final String times2 = "Week ended,06/01/2017,13/01/2017,20/01/2017,27/01/2017,03/02/2017,10/02/2017,17/02/2017,24/02/2017";
		final String values2 = "Deaths 2017,13629,13715,13610,12877,12485,12269,11644,11794";

		final List<String> times = new ArrayList<>();
		times.add(times1);
		times.add(times2);

		final List<String> values = new ArrayList<>();
		values.add(values1);
		values.add(values2);

		final LineGraph lineGraph = new LineGraph("Test graph", times, values);
		final LineGraphAnalyser analyser = new LineGraphAnalyser(lineGraph);
		final LineGraphWithDerivedInformation lineGraphWithDerivedInformation = analyser.analyse();

		List<TimeSeriesWithDerivedInformation> series = lineGraphWithDerivedInformation
				.getTimeSeriesDerivedInformation();

		TimeSeriesCross timeSeriesCross = new TimeSeriesCross(series.get(0), series.get(1));

		// Act
		List<CrossingSegments> crossingSegments = timeSeriesCross.identifySegmentsWithCrossingPoints();

		// Assert
		Assert.assertTrue(crossingSegments.isEmpty());
	}

	@Test
	public void testIdentifySegmentsWithCrossingPoints_OneCrossingPointInMiddle()
	{
		LOGGER.info("Test: testIdentifySegmentsWithCrossingPoints_OneCrossingPointInMiddle");

		// Arrange
		BigDecimal indexExpected = new BigDecimal("2");

		final String times1 = "Week ended,08/01/2016,15/01/2016,22/01/2016,29/01/2016,05/02/2016,12/02/2016,19/02/2016,26/02/2016";
		final String values1 = "Deaths 2016,13045,11501,11473,12877,12485,12269,11644,11794";
		final String times2 = "Week ended,06/01/2017,13/01/2017,20/01/2017,27/01/2017,03/02/2017,10/02/2017,17/02/2017,24/02/2017";
		final String values2 = "Deaths 2017,13629,13715,13610,11317,11052,11170,10590,11056";

		final List<String> times = new ArrayList<>();
		times.add(times1);
		times.add(times2);

		final List<String> values = new ArrayList<>();
		values.add(values1);
		values.add(values2);

		final LineGraph lineGraph = new LineGraph("Test graph", times, values);
		final LineGraphAnalyser analyser = new LineGraphAnalyser(lineGraph);
		final LineGraphWithDerivedInformation lineGraphWithDerivedInformation = analyser.analyse();

		List<TimeSeriesWithDerivedInformation> series = lineGraphWithDerivedInformation
				.getTimeSeriesDerivedInformation();

		TimeSeriesCross timeSeriesCross = new TimeSeriesCross(series.get(0), series.get(1));

		// Act
		List<CrossingSegments> crossingSegments = timeSeriesCross.identifySegmentsWithCrossingPoints();
		BigDecimal indexActual = crossingSegments.get(0).getSegment1().getPoint1().getX();

		// Assert
		Assert.assertTrue(crossingSegments.size() == 1);
		Assert.assertTrue(indexExpected.compareTo(indexActual) == 0);
		Assert.assertFalse(crossingSegments.get(0).firstPointsAreEqual());
	}

	@Test
	public void testIdentifySegmentsWithCrossingPoints_OneCrossingPointAtStart()
	{
		LOGGER.info("Test: testIdentifySegmentsWithCrossingPoints_OneCrossingPointAtStart");

		// Arrange
		BigDecimal indexExpected = new BigDecimal("0");

		final String times1 = "Week ended,08/01/2016,15/01/2016,22/01/2016,29/01/2016,05/02/2016,12/02/2016,19/02/2016,26/02/2016";
		final String values1 = "Deaths 2016,13045,11501,11473,11317,11052,11170,10590,11056";
		final String times2 = "Week ended,06/01/2017,13/01/2017,20/01/2017,27/01/2017,03/02/2017,10/02/2017,17/02/2017,24/02/2017";
		final String values2 = "Deaths 2017,11991,13715,13610,12877,12485,12269,11644,11794";

		final List<String> times = new ArrayList<>();
		times.add(times1);
		times.add(times2);

		final List<String> values = new ArrayList<>();
		values.add(values1);
		values.add(values2);

		final LineGraph lineGraph = new LineGraph("Test graph", times, values);
		final LineGraphAnalyser analyser = new LineGraphAnalyser(lineGraph);
		final LineGraphWithDerivedInformation lineGraphWithDerivedInformation = analyser.analyse();

		List<TimeSeriesWithDerivedInformation> series = lineGraphWithDerivedInformation
				.getTimeSeriesDerivedInformation();

		TimeSeriesCross timeSeriesCross = new TimeSeriesCross(series.get(0), series.get(1));

		// Act
		List<CrossingSegments> crossingSegments = timeSeriesCross.identifySegmentsWithCrossingPoints();
		BigDecimal indexActual = crossingSegments.get(0).getSegment1().getPoint1().getX();

		// Assert
		Assert.assertTrue(crossingSegments.size() == 1);
		Assert.assertTrue(indexExpected.compareTo(indexActual) == 0);
		Assert.assertFalse(crossingSegments.get(0).firstPointsAreEqual());
	}

	@Test
	public void testIdentifySegmentsWithCrossingPoints_OneCrossingPointAtEnd()
	{
		LOGGER.info("Test: testIdentifySegmentsWithCrossingPoints_OneCrossingPointAtEnd");

		// Arrange
		BigDecimal indexExpected = new BigDecimal("6");

		final String times1 = "Week ended,08/01/2016,15/01/2016,22/01/2016,29/01/2016,05/02/2016,12/02/2016,19/02/2016,26/02/2016";
		final String values1 = "Deaths 2016,13045,11501,11473,11317,11052,11170,10590,11856";
		final String times2 = "Week ended,06/01/2017,13/01/2017,20/01/2017,27/01/2017,03/02/2017,10/02/2017,17/02/2017,24/02/2017";
		final String values2 = "Deaths 2017,13629,13715,13610,12877,12485,12269,11644,11794";

		final List<String> times = new ArrayList<>();
		times.add(times1);
		times.add(times2);

		final List<String> values = new ArrayList<>();
		values.add(values1);
		values.add(values2);

		final LineGraph lineGraph = new LineGraph("Test graph", times, values);
		final LineGraphAnalyser analyser = new LineGraphAnalyser(lineGraph);
		final LineGraphWithDerivedInformation lineGraphWithDerivedInformation = analyser.analyse();

		List<TimeSeriesWithDerivedInformation> series = lineGraphWithDerivedInformation
				.getTimeSeriesDerivedInformation();

		TimeSeriesCross timeSeriesCross = new TimeSeriesCross(series.get(0), series.get(1));

		// Act
		List<CrossingSegments> crossingSegments = timeSeriesCross.identifySegmentsWithCrossingPoints();
		BigDecimal indexActual = crossingSegments.get(0).getSegment1().getPoint1().getX();

		// Assert
		Assert.assertTrue(crossingSegments.size() == 1);
		Assert.assertTrue(indexExpected.compareTo(indexActual) == 0);
		Assert.assertFalse(crossingSegments.get(0).firstPointsAreEqual());
	}

	@Test
	public void testIdentifySegmentsWithCrossingPoints_TwoCrossingPoints()
	{
		LOGGER.info("Test: testIdentifySegmentsWithCrossingPoints_TwoCrossingPoints");

		// Arrange
		BigDecimal index1Expected = new BigDecimal("2");
		BigDecimal index2Expected = new BigDecimal("5");

		final String times1 = "Week ended,08/01/2016,15/01/2016,22/01/2016,29/01/2016,05/02/2016,12/02/2016,19/02/2016,26/02/2016";
		final String values1 = "Deaths 2016,13045,11501,11473,12877,12485,12269,10590,11056";
		final String times2 = "Week ended,06/01/2017,13/01/2017,20/01/2017,27/01/2017,03/02/2017,10/02/2017,17/02/2017,24/02/2017";
		final String values2 = "Deaths 2017,13629,13715,13610,11317,11052,11170,11644,11794";

		final List<String> times = new ArrayList<>();
		times.add(times1);
		times.add(times2);

		final List<String> values = new ArrayList<>();
		values.add(values1);
		values.add(values2);

		final LineGraph lineGraph = new LineGraph("Test graph", times, values);
		final LineGraphAnalyser analyser = new LineGraphAnalyser(lineGraph);
		final LineGraphWithDerivedInformation lineGraphWithDerivedInformation = analyser.analyse();

		List<TimeSeriesWithDerivedInformation> series = lineGraphWithDerivedInformation
				.getTimeSeriesDerivedInformation();

		TimeSeriesCross timeSeriesCross = new TimeSeriesCross(series.get(0), series.get(1));

		// Act
		List<CrossingSegments> crossingSegments = timeSeriesCross.identifySegmentsWithCrossingPoints();
		BigDecimal index1Actual = crossingSegments.get(0).getSegment1().getPoint1().getX();
		BigDecimal index2Actual = crossingSegments.get(1).getSegment1().getPoint1().getX();

		// Assert
		Assert.assertTrue(crossingSegments.size() == 2);
		Assert.assertTrue(index1Expected.compareTo(index1Actual) == 0);
		Assert.assertTrue(index2Expected.compareTo(index2Actual) == 0);
		Assert.assertFalse(crossingSegments.get(0).firstPointsAreEqual());
		Assert.assertFalse(crossingSegments.get(1).firstPointsAreEqual());
	}

	@Test
	public void testIdentifySegmentsWithCrossingPoints_OneCrossingPointOnSampleTime_Series1Descending()
	{
		LOGGER.info("Test: testIdentifySegmentsWithCrossingPoints_OneCrossingPointOnSampleTime_Series1Descending");

		// Arrange
		BigDecimal indexExpected = new BigDecimal("4");

		final String times1 = "Week ended,08/01/2016,15/01/2016,22/01/2016,29/01/2016,05/02/2016,12/02/2016,19/02/2016,26/02/2016";
		final String values1 = "Deaths 2017,13629,13715,13610,12877,12485,11170,10590,11056";
		final String times2 = "Week ended,06/01/2017,13/01/2017,20/01/2017,27/01/2017,03/02/2017,10/02/2017,17/02/2017,24/02/2017";
		final String values2 = "Deaths 2016,13045,11501,11473,11317,12485,12269,11644,11794";

		final List<String> times = new ArrayList<>();
		times.add(times1);
		times.add(times2);

		final List<String> values = new ArrayList<>();
		values.add(values1);
		values.add(values2);

		final LineGraph lineGraph = new LineGraph("Test graph", times, values);
		final LineGraphAnalyser analyser = new LineGraphAnalyser(lineGraph);
		final LineGraphWithDerivedInformation lineGraphWithDerivedInformation = analyser.analyse();

		List<TimeSeriesWithDerivedInformation> series = lineGraphWithDerivedInformation
				.getTimeSeriesDerivedInformation();

		TimeSeriesCross timeSeriesCross = new TimeSeriesCross(series.get(0), series.get(1));

		// Act
		List<CrossingSegments> crossingSegments = timeSeriesCross.identifySegmentsWithCrossingPoints();
		BigDecimal indexActual = crossingSegments.get(0).getSegment1().getPoint1().getX();

		// Assert
		Assert.assertTrue(crossingSegments.size() == 1);
		Assert.assertTrue(indexExpected.compareTo(indexActual) == 0);
		Assert.assertTrue(crossingSegments.get(0).firstPointsAreEqual());
	}

	@Test
	public void testIdentifySegmentsWithCrossingPoints_OneCrossingPointOnSampleTime_Series1Ascending()
	{
		LOGGER.info("Test: testIdentifySegmentsWithCrossingPoints_OneCrossingPointOnSampleTime_Series1Ascending");

		// Arrange
		BigDecimal indexExpected = new BigDecimal("3");

		final String times1 = "Week ended,08/01/2016,15/01/2016,22/01/2016,29/01/2016,05/02/2016,12/02/2016,19/02/2016,26/02/2016";
		final String values1 = "Deaths 2016,13045,11501,11473,12877,12485,12269,11644,11794";
		final String times2 = "Week ended,06/01/2017,13/01/2017,20/01/2017,27/01/2017,03/02/2017,10/02/2017,17/02/2017,24/02/2017";
		final String values2 = "Deaths 2017,13629,13715,13610,12877,11052,11170,10590,11056";

		final List<String> times = new ArrayList<>();
		times.add(times1);
		times.add(times2);

		final List<String> values = new ArrayList<>();
		values.add(values1);
		values.add(values2);

		final LineGraph lineGraph = new LineGraph("Test graph", times, values);
		final LineGraphAnalyser analyser = new LineGraphAnalyser(lineGraph);
		final LineGraphWithDerivedInformation lineGraphWithDerivedInformation = analyser.analyse();

		List<TimeSeriesWithDerivedInformation> series = lineGraphWithDerivedInformation
				.getTimeSeriesDerivedInformation();

		TimeSeriesCross timeSeriesCross = new TimeSeriesCross(series.get(0), series.get(1));

		// Act
		List<CrossingSegments> crossingSegments = timeSeriesCross.identifySegmentsWithCrossingPoints();
		BigDecimal indexActual = crossingSegments.get(0).getSegment1().getPoint1().getX();

		// Assert
		Assert.assertTrue(crossingSegments.size() == 1);
		Assert.assertTrue(indexExpected.compareTo(indexActual) == 0);
		Assert.assertTrue(crossingSegments.get(0).firstPointsAreEqual());
	}
}
