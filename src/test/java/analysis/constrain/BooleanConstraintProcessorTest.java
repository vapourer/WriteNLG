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
import writenlg.constrain.BooleanConstraintProcessor;
import writenlg.constrain.BoundedSoftConstraint;
import writenlg.constrain.Constraint;
import writenlg.constrain.ConstraintProcessor;
import writenlg.constrain.HardConstraint;
import writenlg.constrain.SatisfactionLevel;

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

		final BigDecimal valueExpected = new BigDecimal("1");

		final Set<HardConstraint<String>> constraints = new HashSet<>();
		constraints.add(new HardConstraint<>("Onion", new SatisfactionLevel(new BigDecimal("1"))));
		constraints.add(new HardConstraint<>("Parsnip", new SatisfactionLevel(new BigDecimal("1"))));
		constraints.add(new HardConstraint<>("Lettuce", new SatisfactionLevel(new BigDecimal("1"))));
		constraints.add(new HardConstraint<>("Tomato", new SatisfactionLevel(new BigDecimal("1"))));

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
		final BigDecimal valueExpected = new BigDecimal("0");

		final Set<HardConstraint<String>> constraints = new HashSet<>();
		constraints.add(new HardConstraint<>("Onion", new SatisfactionLevel(new BigDecimal("1"))));
		constraints.add(new HardConstraint<>("Parsnip", new SatisfactionLevel(new BigDecimal("0"))));
		constraints.add(new HardConstraint<>("Lettuce", new SatisfactionLevel(new BigDecimal("1"))));
		constraints.add(new HardConstraint<>("Tomato", new SatisfactionLevel(new BigDecimal("1"))));

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
		constraints.add(new HardConstraint<>("Onion", new SatisfactionLevel(new BigDecimal("1"))));
		constraints.add(new HardConstraint<>("Parsnip", new SatisfactionLevel(new BigDecimal("1"))));
		constraints.add(new BoundedSoftConstraint<String>("Lettuce", new SatisfactionLevel(new BigDecimal("0.5")),
				TestConstants.LOWER_BOUND_FOR_CONSTRAINTS_TESTS, TestConstants.UPPER_BOUND_FOR_CONSTRAINTS_TESTS));
		constraints.add(new HardConstraint<>("Tomato", new SatisfactionLevel(new BigDecimal("1"))));

		final ConstraintProcessor processor = new BooleanConstraintProcessor();

		// Act
		processor.evaluate(constraints);
	}
}
