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
import control.WriteNlgProperties;
import writenlg.constrain.BoundedWeightedConstraint;
import writenlg.constrain.Constraint;
import writenlg.constrain.ConstraintProcessor;
import writenlg.constrain.HardConstraint;
import writenlg.constrain.SatisfactionLevel;
import writenlg.constrain.WeightedAverageConstraintProcessor;

public class WeightedAverageConstraintProcessorTest
{
	private static Logger LOGGER;

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
		LOGGER = LogManager.getLogger("WeightedAverageConstraintProcessorTest.class");
		WriteNlgProperties.createInstance(TestConstants.WRITE_NLG_PROPERTIES_FILE_PATH);
	}

	@Test
	public void testEvaluate_DefaultWeightings()
	{
		LOGGER.info("Test: testEvaluate_DefaultWeightings");

		// Arrange
		final BigDecimal valueExpected = new BigDecimal("0.7");

		final Set<BoundedWeightedConstraint<String>> constraints = new HashSet<>();
		constraints.add(new BoundedWeightedConstraint<>("Buttercup", new SatisfactionLevel(new BigDecimal("0.6")),
				new BigDecimal("0"), new BigDecimal("1")));
		constraints.add(new BoundedWeightedConstraint<>("Pansy", new SatisfactionLevel(new BigDecimal("0.7")),
				new BigDecimal("0"), new BigDecimal("1")));
		constraints.add(new BoundedWeightedConstraint<>("Dahlia", new SatisfactionLevel(new BigDecimal("0.8")),
				new BigDecimal("0"), new BigDecimal("1")));

		final ConstraintProcessor processor = new WeightedAverageConstraintProcessor();

		// Act
		final BigDecimal valueActual = processor.evaluate(constraints);

		// Assert
		Assert.assertEquals(valueExpected, valueActual);
	}

	@Test
	public void testEvaluate_VariedWeightings()
	{
		LOGGER.info("Test: testEvaluate_VariedWeightings");

		// Arrange
		final BigDecimal valueExpected = new BigDecimal("0.7");

		final Set<BoundedWeightedConstraint<String>> constraints = new HashSet<>();
		constraints.add(new BoundedWeightedConstraint<>("Buttercup",
				new SatisfactionLevel(new BigDecimal("0.5"), new BigDecimal("3")), new BigDecimal("0"),
				new BigDecimal("1")));
		constraints.add(new BoundedWeightedConstraint<>("Pansy",
				new SatisfactionLevel(new BigDecimal("0.8"), new BigDecimal("2")), new BigDecimal("0"),
				new BigDecimal("1")));
		constraints.add(new BoundedWeightedConstraint<>("Dahlia",
				new SatisfactionLevel(new BigDecimal("0.8"), new BigDecimal("4")), new BigDecimal("0"),
				new BigDecimal("1")));

		final ConstraintProcessor processor = new WeightedAverageConstraintProcessor();

		// Act
		final BigDecimal valueActual = processor.evaluate(constraints);

		// Assert
		Assert.assertEquals(valueExpected, valueActual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEvaluate_IncludesHardConstraint()
	{
		LOGGER.info("Test: testEvaluate_IncludesHardConstraint");

		// Arrange
		final Set<Constraint<String>> constraints = new HashSet<>();
		constraints.add(new BoundedWeightedConstraint<>("Buttercup",
				new SatisfactionLevel(new BigDecimal("0.5"), new BigDecimal("3")), new BigDecimal("0"),
				new BigDecimal("1")));
		constraints.add(new BoundedWeightedConstraint<>("Pansy",
				new SatisfactionLevel(new BigDecimal("0.7"), new BigDecimal("2")), new BigDecimal("0"),
				new BigDecimal("1")));
		constraints.add(new HardConstraint<>("Courgette", new SatisfactionLevel(new BigDecimal("1"))));
		constraints.add(new BoundedWeightedConstraint<>("Dahlia",
				new SatisfactionLevel(new BigDecimal("0.8"), new BigDecimal("4")), new BigDecimal("0"),
				new BigDecimal("1")));

		final ConstraintProcessor processor = new WeightedAverageConstraintProcessor();

		// Act
		processor.evaluate(constraints);
	}
}
