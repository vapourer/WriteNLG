// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.constrain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import analysis.TestConstants;

public class HardConstraintProcessorTest
{
	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
	}

	@Test
	public void testEvaluate_AllConstraintsPositive()
	{
		// Arrange
		final BigDecimal valueExpected = new BigDecimal("4");

		final Set<HardConstraint<String>> constraints = new HashSet<>();
		constraints.add(new HardConstraint<>("Radish", new BigDecimal("1")));
		constraints.add(new HardConstraint<>("Turnip", new BigDecimal("1")));
		constraints.add(new HardConstraint<>("Cabbage", new BigDecimal("1")));
		constraints.add(new HardConstraint<>("Courgette", new BigDecimal("1")));

		final ConstraintProcessor processor = new HardConstraintProcessor();

		// Act
		final BigDecimal valueActual = processor.evaluate(constraints);

		// Assert
		Assert.assertEquals(valueExpected, valueActual);
	}

	@Test
	public void testEvaluate_OneNegativeConstraint()
	{
		// Arrange
		final BigDecimal valueExpected = new BigDecimal("0");

		final Set<HardConstraint<String>> constraints = new HashSet<>();
		constraints.add(new HardConstraint<>("Radish", new BigDecimal("1")));
		constraints.add(new HardConstraint<>("Turnip", new BigDecimal("1")));
		constraints.add(new HardConstraint<>("Cabbage", new BigDecimal("0")));
		constraints.add(new HardConstraint<>("Courgette", new BigDecimal("1")));

		final ConstraintProcessor processor = new HardConstraintProcessor();

		// Act
		final BigDecimal valueActual = processor.evaluate(constraints);

		// Assert
		Assert.assertEquals(valueExpected, valueActual);
	}
}
