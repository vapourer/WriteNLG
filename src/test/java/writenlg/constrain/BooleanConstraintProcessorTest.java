// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.constrain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import analysis.TestConstants;
import analysis.utilities.GlobalConstants;

public class BooleanConstraintProcessorTest
{
	private static Logger LOGGER;

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
		LOGGER = LogManager.getLogger("BooleanConstraintProcessorTest.class");
	}

	@Test
	public void testEvaluate_AllConstraintsPositive()
	{
		LOGGER.info("Test: testEvaluate_AllConstraintsPositive");

		final BigDecimal valueExpected = GlobalConstants.ONE;

		final Set<HardConstraint<String>> constraints = new HashSet<>();
		constraints.add(new HardConstraint<>("Onion", new SatisfactionLevel(GlobalConstants.ONE)));
		constraints.add(new HardConstraint<>("Parsnip", new SatisfactionLevel(GlobalConstants.ONE)));
		constraints.add(new HardConstraint<>("Lettuce", new SatisfactionLevel(GlobalConstants.ONE)));
		constraints.add(new HardConstraint<>("Tomato", new SatisfactionLevel(GlobalConstants.ONE)));

		final ConstraintProcessor processor = new BooleanConstraintProcessor();

		// Act
		final BigDecimal valueActual = processor.evaluate(constraints);

		// Assert
		Assert.assertEquals(valueExpected, valueActual);
	}

	@Test
	public void testEvaluate_OneNegativeConstraint()
	{
		LOGGER.info("Test: testEvaluate_OneNegativeConstraint");

		// Arrange
		final BigDecimal valueExpected = GlobalConstants.ZERO;

		final Set<HardConstraint<String>> constraints = new HashSet<>();
		constraints.add(new HardConstraint<>("Onion", new SatisfactionLevel(GlobalConstants.ONE)));
		constraints.add(new HardConstraint<>("Parsnip", new SatisfactionLevel(GlobalConstants.ZERO)));
		constraints.add(new HardConstraint<>("Lettuce", new SatisfactionLevel(GlobalConstants.ONE)));
		constraints.add(new HardConstraint<>("Tomato", new SatisfactionLevel(GlobalConstants.ONE)));

		final ConstraintProcessor processor = new BooleanConstraintProcessor();

		// Act
		final BigDecimal valueActual = processor.evaluate(constraints);

		// Assert
		Assert.assertEquals(valueExpected, valueActual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEvaluate_IncludesSoftConstraint()
	{
		LOGGER.info("Test: testEvaluate_IncludesSoftConstraint");

		// Arrange
		final Set<Constraint<String>> constraints = new HashSet<>();
		constraints.add(new HardConstraint<>("Onion", new SatisfactionLevel(GlobalConstants.ONE)));
		constraints.add(new HardConstraint<>("Parsnip", new SatisfactionLevel(GlobalConstants.ONE)));
		constraints.add(new BoundedSoftConstraint<String>("Lettuce", new SatisfactionLevel(new BigDecimal("0.5")),
				TestConstants.LOWER_BOUND_FOR_CONSTRAINTS_TESTS, TestConstants.UPPER_BOUND_FOR_CONSTRAINTS_TESTS));
		constraints.add(new HardConstraint<>("Tomato", new SatisfactionLevel(GlobalConstants.ONE)));

		final ConstraintProcessor processor = new BooleanConstraintProcessor();

		// Act
		processor.evaluate(constraints);
	}
}
