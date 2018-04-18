// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.constrain;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import analysis.TestConstants;

public class SoftConstraintGroupTest
{
	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
	}

	@Test
	public void testGetValue()
	{
		// Arrange
		final BigDecimal valueExpected = new BigDecimal("2.2");

		final ConstraintGroup<String> constraints = new SoftConstraintGroup<>(new SoftConstraintProcessor());
		constraints.addConstraint(new SoftConstraint<>("Buttercup", new SatisfactionLevel(new BigDecimal("0.3"))));
		constraints.addConstraint(new SoftConstraint<>("Pansy", new SatisfactionLevel(new BigDecimal("0.7"))));
		constraints.addConstraint(new SoftConstraint<>("Daffodil", new SatisfactionLevel(new BigDecimal("0.2"))));
		constraints.addConstraint(new SoftConstraint<>("Dandelion", new SatisfactionLevel(new BigDecimal("0.4"))));
		constraints.addConstraint(new SoftConstraint<>("Daisy", new SatisfactionLevel(new BigDecimal("0.6"))));

		// Act
		final BigDecimal valueActual = constraints.getValue();

		// Assert
		Assert.assertTrue(valueExpected.compareTo(valueActual) == 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddConstraint_HardConstraint()
	{
		final ConstraintGroup<String> constraints = new SoftConstraintGroup<>(new SoftConstraintProcessor());
		constraints.addConstraint(new HardConstraint<>("Radish", new SatisfactionLevel(new BigDecimal("1"))));
	}
}
