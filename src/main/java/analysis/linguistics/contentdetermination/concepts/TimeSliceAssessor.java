// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.contentdetermination.concepts;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.TimeSeriesSpecificConcept;
import analysis.interfaces.Assessor;
import analysis.linguistics.contentdetermination.ConstraintType;
import control.WriteNlgProperties;
import writenlg.constrain.BoundedWeightedConstraint;
import writenlg.constrain.Constraint;
import writenlg.constrain.ConstraintConfiguration;
import writenlg.constrain.ConstraintGroup;
import writenlg.constrain.Constraints;
import writenlg.constrain.SatisfactionLevel;
import writenlg.constrain.SoftConstraintGroup;
import writenlg.constrain.WeightedAverageConstraintProcessor;

/**
 * Establishes constraint values for time slices, based on initial values and weightings input from ANTLR Constraints
 * text file, and analysis of time series data.
 */
public class TimeSliceAssessor implements Assessor
{
	private static final Logger LOGGER = LogManager.getLogger("TimeSliceAssessor.class");

	private final Map<String, ConstraintConfiguration> constraints;
	private final ConstraintGroup<ConstraintType> constraintTypes;

	/**
	 * Creates a TimeSliceAssessor instance.
	 */
	public TimeSliceAssessor()
	{
		this.constraints = Constraints.getInstance()
				.getConfigurationsForTimeSeriesSpecificConcept(TimeSeriesSpecificConcept.TIME_SLICE);

		this.constraintTypes = new SoftConstraintGroup<>(new WeightedAverageConstraintProcessor());

		LOGGER.info("TimeSliceAssessor created");
	}

	@Override
	public void assessConstraints()
	{
		final ConstraintConfiguration timeSliceConstraintConfiguration = this.constraints
				.get(ConstraintType.TIME_SLICE_REQUIRED.getTextualForm());

		final Constraint<ConstraintType> timeSliceLegendConstraint = new BoundedWeightedConstraint<ConstraintType>(
				ConstraintType.TIME_SLICE_REQUIRED,
				new SatisfactionLevel(timeSliceConstraintConfiguration.getValue(),
						timeSliceConstraintConfiguration.getWeighting()),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintLowerBound")),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintUpperBound")));

		this.constraintTypes.addConstraint(timeSliceLegendConstraint);
	}

	/**
	 * @return the constraintTypes
	 */
	public ConstraintGroup<ConstraintType> getTimeSliceConstraints()
	{
		return this.constraintTypes;
	}
}
