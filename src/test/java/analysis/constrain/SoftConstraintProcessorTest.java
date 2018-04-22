// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.constrain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import analysis.TestConstants;

public class SoftConstraintProcessorTest
{
	private static Logger LOGGER;

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
		LOGGER = LogManager.getLogger("SoftConstraintProcessorTest.class");
	}

	@Test
	public void testEvaluate()
	{
		LOGGER.info("Test: testEvaluate");

		// Arrange
		final BigDecimal valueExpected = new BigDecimal("2.0");

		final Set<SoftConstraint<String>> constraints = new HashSet<>();
		constraints.add(new SoftConstraint<>("Buttercup", new SatisfactionLevel(new BigDecimal("0.5"))));
		constraints.add(new SoftConstraint<>("Pansy", new SatisfactionLevel(new BigDecimal("0.7"))));
		constraints.add(new SoftConstraint<>("Dahlia", new SatisfactionLevel(new BigDecimal("0.8"))));

		final ConstraintProcessor processor = new SoftConstraintProcessor();

		// Act
		final BigDecimal valueActual = processor.evaluate(constraints);

		// Assert
		Assert.assertEquals(valueExpected, valueActual);
	}
}
