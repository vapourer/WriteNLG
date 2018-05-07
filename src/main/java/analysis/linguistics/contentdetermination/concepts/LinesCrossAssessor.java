// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.contentdetermination.concepts;

import java.util.Map;

import analysis.GlobalConcept;
import analysis.constrain.BooleanConstraintProcessor;
import analysis.constrain.ConstraintConfiguration;
import analysis.constrain.ConstraintGroup;
import analysis.constrain.Constraints;
import analysis.constrain.HardConstraintGroup;
import analysis.interfaces.Assessor;

/**
 * Establishes constraint values for lines crossing, based on initial values and weightings input from ANTLR Constraints
 * text file, and analysis of time series data.
 */
public class LinesCrossAssessor implements Assessor
{
	private final Map<String, ConstraintConfiguration> constraints;
	private final ConstraintGroup<String> linesCrossConstraints;

	public LinesCrossAssessor()
	{
		this.constraints = Constraints.getInstance()
				.getConstraintConfigurationsForGlobalConcept(GlobalConcept.LINES_CROSS);

		this.linesCrossConstraints = new HardConstraintGroup<>(new BooleanConstraintProcessor());
	}

	@Override
	public void assessConstraints()
	{
		// TODO Auto-generated method stub

	}
}
