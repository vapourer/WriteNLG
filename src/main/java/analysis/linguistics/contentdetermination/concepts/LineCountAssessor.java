// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.contentdetermination.concepts;

import java.util.Map;

import analysis.GlobalConcept;
import analysis.constrain.Constraints;
import analysis.interfaces.Assessor;
import analysis.linguistics.contentdetermination.ConstraintType;
import writenlg.constrain.BooleanConstraintProcessor;
import writenlg.constrain.Constraint;
import writenlg.constrain.ConstraintConfiguration;
import writenlg.constrain.ConstraintGroup;
import writenlg.constrain.HardConstraint;
import writenlg.constrain.HardConstraintGroup;
import writenlg.constrain.SatisfactionLevel;

/**
 * Establishes constraint values for line count, based on initial values and weightings input from ANTLR Constraints
 * text file, and analysis of time series data.
 */
public class LineCountAssessor implements Assessor
{
	private final Map<String, ConstraintConfiguration> constraints;
	private final ConstraintGroup<ConstraintType> constraintTypes;

	/**
	 * Creates a new LineCountAssessor instance.
	 */
	public LineCountAssessor()
	{
		this.constraints = Constraints.getInstance()
				.getConstraintConfigurationsForGlobalConcept(GlobalConcept.LINE_COUNT);

		this.constraintTypes = new HardConstraintGroup<>(new BooleanConstraintProcessor());
	}

	@Override
	public void assessConstraints()
	{
		final ConstraintConfiguration lineCountConstraintConfiguration = this.constraints
				.get(ConstraintType.LINE_COUNT.getTextualForm());

		final Constraint<ConstraintType> hardConstraint = new HardConstraint<ConstraintType>(ConstraintType.LINE_COUNT,
				new SatisfactionLevel(lineCountConstraintConfiguration.getValue()));

		this.constraintTypes.addConstraint(hardConstraint);
	}

	/**
	 * @return the constraintTypes
	 */
	public ConstraintGroup<ConstraintType> getLineCountConstraints()
	{
		return constraintTypes;
	}
}
