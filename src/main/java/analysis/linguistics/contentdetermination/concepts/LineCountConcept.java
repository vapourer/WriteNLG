// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.contentdetermination.concepts;

import java.util.List;
import java.util.Map;

import analysis.GlobalConcept;
import analysis.constrain.Constraints;
import analysis.linguistics.contentdetermination.ConstraintType;
import writenlg.AbstractConcept;
import writenlg.constrain.BooleanConstraintProcessor;
import writenlg.constrain.Constraint;
import writenlg.constrain.ConstraintConfiguration;
import writenlg.constrain.HardConstraint;
import writenlg.constrain.HardConstraintGroup;
import writenlg.constrain.SatisfactionLevel;
import writenlg.linguistics.phrase.PhraseSpecification;

/**
 * Representation of a line count concept.
 * Establishes constraint values for line count, based on initial values and weightings input from ANTLR Constraints
 * text file, and analysis of time series data.
 */
public class LineCountConcept extends AbstractConcept
{
	private final Map<String, ConstraintConfiguration> constraints;

	/**
	 * Creates a new LineCountConcept instance.
	 * 
	 * @param phraseSpecifications
	 */
	public LineCountConcept(final List<PhraseSpecification> phraseSpecifications)
	{
		super(phraseSpecifications, new HardConstraintGroup<>(new BooleanConstraintProcessor()));

		this.constraints = Constraints.getInstance()
				.getConstraintConfigurationsForGlobalConcept(GlobalConcept.LINE_COUNT);

		assessConstraints();
	}

	private void assessConstraints()
	{
		final ConstraintConfiguration lineCountConstraintConfiguration = this.constraints
				.get(ConstraintType.LINE_COUNT.getTextualForm());

		final Constraint<ConstraintType> hardConstraint = new HardConstraint<ConstraintType>(ConstraintType.LINE_COUNT,
				new SatisfactionLevel(lineCountConstraintConfiguration.getValue()));

		addConstraint(hardConstraint);
	}
}
