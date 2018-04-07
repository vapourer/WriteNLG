package analysis.linguistics.phrase.partofspeech;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import analysis.TestConstants;
import analysis.constrain.BoundedSoftConstraint;
import analysis.constrain.ConstraintGroup;
import analysis.constrain.MeanBasedSoftConstraintProcessor;
import analysis.constrain.SoftConstraintGroup;
import analysis.linguistics.phrase.partofspeech.Verb;

public class VerbTest
{
	@Test
	public void testCalculateSatisfactionLevel()
	{
		// Arrange
		final BigDecimal satisfactionLevelExpected = new BigDecimal("0.7");

		final ConstraintGroup<String> constraintGroup = new SoftConstraintGroup<>(
				new MeanBasedSoftConstraintProcessor(TestConstants.MATH_CONTEXT));

		constraintGroup.addConstraint(new BoundedSoftConstraint<>("Too slow", new BigDecimal("0.6"),
				new BigDecimal("0"), new BigDecimal("1")));
		constraintGroup.addConstraint(new BoundedSoftConstraint<>("Speed merchant", new BigDecimal("0.8"),
				new BigDecimal("0"), new BigDecimal("1")));

		final Verb<String> verb = new Verb<>("hurtle", constraintGroup);

		// Act
		final BigDecimal satisfactionLevelActual = verb.calculateSatisfactionLevel();

		// Assert
		Assert.assertTrue(satisfactionLevelExpected.compareTo(satisfactionLevelActual) == 0);
	}
}
