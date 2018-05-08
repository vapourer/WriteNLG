// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.contentdetermination.concepts;

import java.math.BigDecimal;
import java.util.Map;

import analysis.TimeSeriesSpecificConcept;
import analysis.constrain.BoundedWeightedConstraint;
import analysis.constrain.Constraint;
import analysis.constrain.ConstraintConfiguration;
import analysis.constrain.ConstraintGroup;
import analysis.constrain.ConstraintType;
import analysis.constrain.Constraints;
import analysis.constrain.SatisfactionLevel;
import analysis.constrain.SoftConstraintGroup;
import analysis.constrain.WeightedAverageConstraintProcessor;
import analysis.interfaces.Assessor;
import writenlg.control.WriteNlgProperties;

/**
 * Establishes constraint values for series legends, based on initial values and weightings input from ANTLR Constraints
 * text file, and analysis of time series data.
 */
public class SeriesLegendAssessor implements Assessor
{
	private final Map<String, ConstraintConfiguration> constraints;
	private final ConstraintGroup<ConstraintType> constraintTypes;

	/**
	 * Creates a new SeriesLegendAssessor instance.
	 */
	public SeriesLegendAssessor()
	{
		this.constraints = Constraints.getInstance()
				.getConfigurationsForTimeSeriesSpecificConcept(TimeSeriesSpecificConcept.SERIES_LEGEND);

		this.constraintTypes = new SoftConstraintGroup<>(new WeightedAverageConstraintProcessor());
	}

	@Override
	public void assessConstraints()
	{
		final ConstraintConfiguration seriesLegendConstraintConfiguration = this.constraints
				.get(ConstraintType.SERIES_LEGEND.getTextualForm());

		final Constraint<ConstraintType> requiredSeriesLegendConstraint = new BoundedWeightedConstraint<ConstraintType>(
				ConstraintType.SERIES_LEGEND,
				new SatisfactionLevel(seriesLegendConstraintConfiguration.getValue(),
						seriesLegendConstraintConfiguration.getWeighting()),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintLowerBound")),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintUpperBound")));

		this.constraintTypes.addConstraint(requiredSeriesLegendConstraint);
	}

	/**
	 * @return the constraintTypes
	 */
	public ConstraintGroup<ConstraintType> getSeriesLegendConstraints()
	{
		return this.constraintTypes;
	}
}
