// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis;

import java.math.BigDecimal;

public class TestConstants
{
	public static final String WRITE_NLG_PROPERTIES_FILE_PATH = "WriteNLG.properties";
	public static final String LOG4J2_CONFIGURATION_FILE_PATH = "log4j2Configuration.xml";

	public static final String TIMES_FOR_MOVING_AVERAGE_TEST = "Week ended,06/1/2017,13/1/2017,20/1/2017,27/1/2017,03/2/2017,10/2/2017,17/2/2017,24/2/2017,03/3/2017,10/3/2017,17/3/2017,24/3/2017,31/3/2017,07/4/2017,14/4/2017,21/4/2017,28/4/2017,05/5/2017,12/5/2017,19/5/2017,26/5/2017,02/6/2017,09/6/2017,16/6/2017,23/6/2017,30/6/2017";
	public static final String VALUES_FOR_MOVING_AVERAGE_TEST = "Deaths 2017,11991,13715,13610,12877,12485,12269,11644,11794,11248,11077,10697,10325,10027,9939,8493,9644,10908,9064,10693,10288,10040,8332,9766,9367,9627,9334";

	public static final int ROUNDING_PARAMETER_FOR_DATE_COMPARISON = 7;
	public static final String MATH_CONTEXT = "precision=4 roundingMode=HALF_UP";
	public static final BigDecimal LOWER_BOUND_FOR_CONSTRAINTS_TESTS = new BigDecimal("0");
	public static final BigDecimal UPPER_BOUND_FOR_CONSTRAINTS_TESTS = new BigDecimal("1");
}
