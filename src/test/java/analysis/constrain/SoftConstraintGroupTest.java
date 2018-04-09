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
		final BigDecimal valueExpected = new BigDecimal("0.44");

		final ConstraintGroup<String> constraints = new SoftConstraintGroup<>(
				new MeanBasedSoftConstraintProcessor(TestConstants.MATH_CONTEXT));
		constraints.addConstraint(new SoftConstraint<>("Buttercup", new BigDecimal("0.3")));
		constraints.addConstraint(new SoftConstraint<>("Pansy", new BigDecimal("0.7")));
		constraints.addConstraint(new SoftConstraint<>("Daffodil", new BigDecimal("0.2")));
		constraints.addConstraint(new SoftConstraint<>("Dandelion", new BigDecimal("0.4")));
		constraints.addConstraint(new SoftConstraint<>("Daisy", new BigDecimal("0.6")));

		// Act
		final BigDecimal valueActual = constraints.getValue();

		// Assert
		Assert.assertTrue(valueExpected.compareTo(valueActual) == 0);
	}
}
