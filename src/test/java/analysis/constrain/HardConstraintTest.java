// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.constrain;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import analysis.TestConstants;

public class HardConstraintTest
{
	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor_NullConstrainedProperty()
	{
		new HardConstraint<String>(null, new BigDecimal("0"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor_NullSatisfactionLevel()
	{
		new HardConstraint<>("Test: NullSatisfactionLevel", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor_InadmissibleSatisfactionLevel()
	{
		new HardConstraint<>("Test: InadmissibleSatisfactionLevel", new BigDecimal("0.5"));
	}

	@Test
	public void testConstructor_Success()
	{
		// Arrange
		final String constrainedPropertyExpected = "Test: Success";
		final BigDecimal satisfactionLevelExpected = new BigDecimal("1");

		final HardConstraint<String> constraint = new HardConstraint<>("Test: Success", new BigDecimal("1"));

		// Act
		final String constrainedPropertyActual = constraint.getConstrainedElement();
		final BigDecimal satisfactionLevelActual = constraint.getSatisfactionLevel();

		// Assert
		Assert.assertEquals(constrainedPropertyExpected, constrainedPropertyActual);
		Assert.assertTrue(satisfactionLevelExpected.compareTo(satisfactionLevelActual) == 0);
	}
}
