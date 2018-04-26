// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.substitution;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import analysis.TestConstants;

public class SubstitutionsTest
{
	private static Logger LOGGER;

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
		LOGGER = LogManager.getLogger("SubstitutionsTest.class");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddSubstitution_PlaceholderWithMissingPrefix()
	{
		LOGGER.info("Test: testAddSubstitution_PlaceholderWithMissingPrefix");

		// Arrange
		final Substitutions substitutions = new Substitutions();

		// Act
		substitutions.addSubstitution("NoPrefix@@", "Tulip");

		// Assert

	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddSubstitution_PlaceholderWithMissingSuffix()
	{
		LOGGER.info("Test: testAddSubstitution_PlaceholderWithMissingSuffix");

		// Arrange
		Substitutions substitutions = new Substitutions();

		// Act
		substitutions.addSubstitution("@@NoSuffix", "Daffodil");
	}

	@Test
	public void testAddSubstitution()
	{
		LOGGER.info("Test: testAddSubstitution");

		// Arrange
		final String substitutionExpected = "Crocus";

		String placeHolder = "@@GoodPlaceholder@@";

		Substitutions substitutions = new Substitutions();

		// Act
		substitutions.addSubstitution(placeHolder, "Crocus");
		String substitutionActual = substitutions.getSubstitutions().get(placeHolder);

		// Assert
		Assert.assertEquals(substitutionExpected, substitutionActual);

	}
}
