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
import analysis.graph.Point;

public class UpperTurningPointsSmoothedTest
{
	private static Logger LOGGER;

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
		LOGGER = LogManager.getLogger("UpperTurningPointsSmoothedTest.class");
	}

	@Test
	public void testIdentify()
	{
		LOGGER.info("Test: testIdentifyUpperTurningPoints");

		// Arrange
		BigDecimal xValueExpected = new BigDecimal("13");
		BigDecimal yValueExpected = new BigDecimal("11599");

		final String inputTimes = "Week ended,08/01/2016,15/01/2016,22/01/2016,29/01/2016,05/02/2016,12/02/2016,19/02/2016,26/02/2016,04/03/2016,11/03/2016,18/03/2016,25/03/2016,01/04/2016,08/04/2016,15/04/2016,22/04/2016,29/04/2016,06/05/2016,13/05/2016,20/05/2016,27/05/2016,03/06/2016,10/06/2016,17/06/2016,24/06/2016,01/07/2016,08/07/2016,15/07/2016,22/07/2016,29/07/2016,05/08/2016,12/08/2016,19/08/2016,26/08/2016,02/09/2016,09/09/2016,16/09/2016,23/09/2016,30/09/2016,07/10/2016,14/10/2016,21/10/2016,28/10/2016,04/11/2016,11/11/2016,18/11/2016,25/11/2016,02/12/2016,09/12/2016,16/12/2016,23/12/2016,30/12/2016";
		final String inputValues = "Deaths 2016,13045,11501,11473,11317,11052,11170,10590,11056,11285,11010,11022,9635,10286,11599,11417,10925,10413,9137,10637,9953,9739,7909,9873,9386,9365,9228,9138,9388,9350,9335,9182,9172,9070,9319,7923,9399,9124,8945,8994,9291,9719,9768,9724,10152,10470,10694,10603,10439,11223,10533,11493,8003";
		final String inputTimes2 = "Week ended,06/01/2017,13/01/2017,20/01/2017,27/01/2017,03/02/2017,10/02/2017,17/02/2017,24/02/2017,03/03/2017,10/03/2017,17/03/2017,24/03/2017,31/03/2017,07/04/2017,14/04/2017,21/04/2017,28/04/2017,05/05/2017,12/05/2017,19/05/2017,26/05/2017,02/06/2017,09/06/2017,16/06/2017,23/06/2017,30/06/2017,07/07/2017,14/07/2017,21/07/2017,28/07/2017,04/08/2017,11/08/2017,18/08/2017,25/08/2017,01/09/2017,08/09/2017,15/09/2017,22/09/2017,29/09/2017,06/10/2017,13/10/2017,20/10/2017,27/10/2017,03/11/2017,10/11/2017,17/11/2017,24/11/2017,01/12/2017,08/12/2017,15/12/2017,22/12/2017,29/12/2017";
		final String inputValues2 = "Deaths 2017,11991,13715,13610,12877,12485,12269,11644,11794,11248,11077,10697,10325,10027,9939,8493,9644,10908,9064,10693,10288,10040,8332,9766,9367,9627,9334,9263,9376,9113,8882,8941,9038,9299,9382,8149,9497,9454,9534,9689,9778,9940,10031,9739,9984,10346,10275,10621,10538,10781,11217,12517,8487";

		final List<String> times = new ArrayList<>();
		times.add(inputTimes);
		times.add(inputTimes2);

		final List<String> values = new ArrayList<>();
		values.add(inputValues);
		values.add(inputValues2);

		final LineGraph lineGraph = new LineGraph("Test graph", times, values);
		final LineGraphAnalyser analyser = new LineGraphAnalyser(lineGraph);
		final LineGraphWithDerivedInformation lineGraphWithDerivedInformation = analyser.analyse();

		final List<TimeSeriesWithDerivedInformation> series = lineGraphWithDerivedInformation
				.getTimeSeriesDerivedInformation();

		final UpperTurningPointsNinetyPercentile turningPoints = new UpperTurningPointsNinetyPercentile(series.get(0));
		List<Point> upperTurningPoints = turningPoints.identify();

		// Assert
		Assert.assertTrue(upperTurningPoints.size() == 1);
		Assert.assertTrue(xValueExpected.compareTo(upperTurningPoints.get(0).getX()) == 0);
		Assert.assertTrue(yValueExpected.compareTo(upperTurningPoints.get(0).getY()) == 0);
	}
}
