// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.phrase.partofspeech;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import analysis.constrain.BoundedSoftConstraint;
import analysis.constrain.ConstraintGroup;
import analysis.constrain.SoftConstraintGroup;
import analysis.constrain.SoftConstraintProcessor;

public class NounPhraseTest
{
	@Test
	public void testCalculateSatisfactionLevel()
	{
		// Arrange
		final BigDecimal satisfactionLevelExpected = new BigDecimal("1.5");

		final ConstraintGroup<String> constraintGroup = new SoftConstraintGroup<>(new SoftConstraintProcessor());

		constraintGroup.addConstraint(new BoundedSoftConstraint<>("Radishes are nice", new BigDecimal("0.7"),
				new BigDecimal("0"), new BigDecimal("1")));
		constraintGroup.addConstraint(new BoundedSoftConstraint<>("Radishes are red", new BigDecimal("0.8"),
				new BigDecimal("0"), new BigDecimal("1")));

		final NounPhrase<String> nounPhrase = new NounPhrase<>("radish", constraintGroup);

		// Act
		final BigDecimal satisfactionLevelActual = nounPhrase.calculateSatisfactionLevel();

		// Assert
		Assert.assertTrue(satisfactionLevelExpected.compareTo(satisfactionLevelActual) == 0);
	}
}
