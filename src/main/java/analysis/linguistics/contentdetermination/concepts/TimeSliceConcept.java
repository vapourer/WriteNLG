// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.contentdetermination.concepts;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.TimeSeriesSpecificConcept;
import analysis.constrain.Constraints;
import analysis.linguistics.contentdetermination.ConstraintType;
import control.WriteNlgProperties;
import writenlg.AbstractConcept;
import writenlg.constrain.BoundedWeightedConstraint;
import writenlg.constrain.Constraint;
import writenlg.constrain.ConstraintConfiguration;
import writenlg.constrain.SatisfactionLevel;
import writenlg.constrain.SoftConstraintGroup;
import writenlg.constrain.WeightedAverageConstraintProcessor;
import writenlg.linguistics.phrase.PhraseSpecification;

/**
 * Representation of a time series time slice.
 * Establishes constraint values for time slices, based on initial values and weightings input from ANTLR Constraints
 * text file, and analysis of time series data.
 */
public class TimeSliceConcept extends AbstractConcept
{
	private static final Logger LOGGER = LogManager.getLogger("TimeSliceConcept.class");

	private final Map<String, ConstraintConfiguration> constraints;

	/**
	 * Creates a new TimeSliceConcept instance.
	 * 
	 * @param phraseSpecifications
	 * @param constraintGroup
	 */
	public TimeSliceConcept(List<PhraseSpecification> phraseSpecifications)
	{
		super(phraseSpecifications, new SoftConstraintGroup<>(new WeightedAverageConstraintProcessor()));

		this.constraints = Constraints.getInstance()
				.getConfigurationsForTimeSeriesSpecificConcept(TimeSeriesSpecificConcept.TIME_SLICE);

		assessConstraints();

		LOGGER.info("TimeSliceConcept created");
	}

	private void assessConstraints()
	{
		final ConstraintConfiguration timeSliceConstraintConfiguration = this.constraints
				.get(ConstraintType.TIME_SLICE_REQUIRED.getTextualForm());

		final Constraint<ConstraintType> timeSliceLegendConstraint = new BoundedWeightedConstraint<ConstraintType>(
				ConstraintType.TIME_SLICE_REQUIRED,
				new SatisfactionLevel(timeSliceConstraintConfiguration.getValue(),
						timeSliceConstraintConfiguration.getWeighting()),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintLowerBound")),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintUpperBound")));

		addConstraint(timeSliceLegendConstraint);
	}
}
