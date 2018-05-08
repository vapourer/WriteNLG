// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.contentdetermination.concepts;

import java.math.BigDecimal;
import java.util.Map;

import analysis.TimeSeriesSpecificConcept;
import analysis.TimeSeriesWithDerivedInformation;
import analysis.constrain.BoundedWeightedConstraint;
import analysis.constrain.Constraint;
import analysis.constrain.ConstraintConfiguration;
import analysis.constrain.ConstraintGroup;
import analysis.constrain.ConstraintType;
import analysis.constrain.Constraints;
import analysis.constrain.SatisfactionLevel;
import analysis.constrain.SoftConstraintGroup;
import analysis.constrain.WeightedAverageConstraintProcessor;
import analysis.graph.Point;
import analysis.graph.Segment;
import analysis.interfaces.Assessor;
import writenlg.control.WriteNlgProperties;

/**
 * Establishes constraint values for time series maximum values, based on initial values and weightings input from ANTLR
 * Constraints text file, and analysis of time series data.
 */
public class MaximumAssessor implements Assessor
{
	private final TimeSeriesWithDerivedInformation timeSeries;
	private final Map<String, ConstraintConfiguration> constraints;
	private final ConstraintGroup<ConstraintType> constraintTypes;

	/**
	 * Creates a MaximumAssessor instance.
	 * 
	 * @param timeSeriesWithDerivedInformation
	 */
	public MaximumAssessor(final TimeSeriesWithDerivedInformation timeSeriesWithDerivedInformation)
	{
		this.timeSeries = timeSeriesWithDerivedInformation;

		this.constraints = Constraints.getInstance()
				.getConfigurationsForTimeSeriesSpecificConcept(TimeSeriesSpecificConcept.MAXIMUM);

		this.constraintTypes = new SoftConstraintGroup<>(new WeightedAverageConstraintProcessor());
	}

	@Override
	public void assessConstraints()
	{
		assessSingleObviousMaximumConstraint();
	}

	private void assessSingleObviousMaximumConstraint()
	{
		final ConstraintConfiguration singleObviousMaximumConstraintConfiguration = this.constraints
				.get(ConstraintType.SINGLE_OBVIOUS_MAXIMUM.getTextualForm());

		Point maximum = this.timeSeries.getPointWithMaximumValue();

		Segment[] smoothedSegments = this.timeSeries.getSmoothedSegments().toArray(new Segment[0]);

		Segment beforeMaximumSegment = null;
		Segment afterMaximumSegment = null;

		for (Segment segment : this.timeSeries.getSmoothedSegments())
		{
			// if ()
		}

		final Constraint<ConstraintType> singleObviousMaximumConstraint = new BoundedWeightedConstraint<ConstraintType>(
				ConstraintType.SINGLE_OBVIOUS_MAXIMUM,
				new SatisfactionLevel(singleObviousMaximumConstraintConfiguration.getValue(),
						singleObviousMaximumConstraintConfiguration.getWeighting()),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintLowerBound")),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintUpperBound")));

		this.constraintTypes.addConstraint(singleObviousMaximumConstraint);
	}

	/**
	 * @return the constraintTypes
	 */
	public ConstraintGroup<ConstraintType> getMaximumConstraints()
	{
		return this.constraintTypes;
	}
}
