// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.phrase.partofspeech;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import analysis.constrain.BoundedSoftConstraint;
import analysis.constrain.ConstraintGroup;
import analysis.constrain.SatisfactionLevel;
import analysis.constrain.SoftConstraintGroup;
import analysis.constrain.SoftConstraintProcessor;

public class VerbTest
{
	@Test
	public void testCalculateSatisfactionLevel()
	{
		// Arrange
		final BigDecimal satisfactionLevelExpected = new BigDecimal("1.4");

		final ConstraintGroup<String> constraintGroup = new SoftConstraintGroup<>(new SoftConstraintProcessor());

		constraintGroup.addConstraint(new BoundedSoftConstraint<>("Too slow",
				new SatisfactionLevel(new BigDecimal("0.6")), new BigDecimal("0"), new BigDecimal("1")));
		constraintGroup.addConstraint(new BoundedSoftConstraint<>("Speed merchant",
				new SatisfactionLevel(new BigDecimal("0.8")), new BigDecimal("0"), new BigDecimal("1")));

		final Verb<String> verb = new Verb<>("hurtle", constraintGroup);

		// Act
		final BigDecimal satisfactionLevelActual = verb.calculateSatisfactionLevel();

		// Assert
		Assert.assertTrue(satisfactionLevelExpected.compareTo(satisfactionLevelActual) == 0);
	}
}
