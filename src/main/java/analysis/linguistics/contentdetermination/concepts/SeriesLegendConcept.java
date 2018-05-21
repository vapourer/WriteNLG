// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.contentdetermination.concepts;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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
 * Representation of a time series legend.
 * Establishes constraint values for series legends, based on initial values and weightings input from ANTLR Constraints
 * text file, and analysis of time series data.
 */
public class SeriesLegendConcept extends AbstractConcept
{
	private final Map<String, ConstraintConfiguration> constraints;

	/**
	 * Creates a new SeriesLegendConcept instance.
	 * 
	 * @param phraseSpecifications
	 */
	public SeriesLegendConcept(final List<PhraseSpecification> phraseSpecifications)
	{
		super(phraseSpecifications, new SoftConstraintGroup<>(new WeightedAverageConstraintProcessor()));

		this.constraints = Constraints.getInstance()
				.getConfigurationsForTimeSeriesSpecificConcept(TimeSeriesSpecificConcept.SERIES_LEGEND);

		assessConstraints();
	}

	private void assessConstraints()
	{
		final ConstraintConfiguration seriesLegendConstraintConfiguration = this.constraints
				.get(ConstraintType.SERIES_LEGEND.getTextualForm());

		final Constraint<ConstraintType> requiredSeriesLegendConstraint = new BoundedWeightedConstraint<ConstraintType>(
				ConstraintType.SERIES_LEGEND,
				new SatisfactionLevel(seriesLegendConstraintConfiguration.getValue(),
						seriesLegendConstraintConfiguration.getWeighting()),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintLowerBound")),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintUpperBound")));

		addConstraint(requiredSeriesLegendConstraint);
	}
}
