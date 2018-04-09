// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.constrain;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import analysis.TestConstants;

public class HardConstraintGroupTest
{
	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
	}

	@Test
	public void testGetValue_Positive()
	{
		// Arrange
		final BigDecimal valueExpected = new BigDecimal("6");

		final ConstraintGroup<String> constraints = new HardConstraintGroup<>(new HardConstraintProcessor());
		constraints.addConstraint(new HardConstraint<>("Radish", new BigDecimal("1")));
		constraints.addConstraint(new HardConstraint<>("Turnip", new BigDecimal("1")));
		constraints.addConstraint(new HardConstraint<>("Cabbage", new BigDecimal("1")));
		constraints.addConstraint(new HardConstraint<>("Courgette", new BigDecimal("1")));
		constraints.addConstraint(new HardConstraint<>("Potato", new BigDecimal("1")));
		constraints.addConstraint(new HardConstraint<>("Carrot", new BigDecimal("1")));

		// Act
		final BigDecimal valueActual = constraints.getValue();

		// Assert
		Assert.assertEquals(valueExpected, valueActual);
	}

	@Test
	public void testGetValue_Zero()
	{
		// Arrange
		final BigDecimal valueExpected = new BigDecimal("0");

		final ConstraintGroup<String> constraints = new HardConstraintGroup<>(new HardConstraintProcessor());
		constraints.addConstraint(new HardConstraint<>("Radish", new BigDecimal("1")));
		constraints.addConstraint(new HardConstraint<>("Turnip", new BigDecimal("1")));
		constraints.addConstraint(new HardConstraint<>("Cabbage", new BigDecimal("1")));
		constraints.addConstraint(new HardConstraint<>("Courgette", new BigDecimal("1")));
		constraints.addConstraint(new HardConstraint<>("Potato", new BigDecimal("0")));
		constraints.addConstraint(new HardConstraint<>("Carrot", new BigDecimal("1")));

		// Act
		final BigDecimal valueActual = constraints.getValue();

		// Assert
		Assert.assertEquals(valueExpected, valueActual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddConstraint_SoftConstraint()
	{
		final ConstraintGroup<String> constraints = new HardConstraintGroup<>(new HardConstraintProcessor());
		constraints.addConstraint(new SoftConstraint<>("Radish", new BigDecimal("1.2")));
	}
}
