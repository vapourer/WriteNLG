// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.contentdetermination.concepts;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.TimeSeriesSpecificConcept;
import analysis.TimeSeriesWithDerivedInformation;
import analysis.constrain.Constraints;
import analysis.graph.Segment;
import analysis.graph.Slope;
import analysis.linguistics.contentdetermination.ConstraintType;
import analysis.utilities.GlobalConstants;
import control.WriteNlgProperties;
import writenlg.AbstractConcept;
import writenlg.constrain.BoundedWeightedConstraint;
import writenlg.constrain.Constraint;
import writenlg.constrain.ConstraintConfiguration;
import writenlg.constrain.SatisfactionLevel;
import writenlg.constrain.SoftConstraintGroup;
import writenlg.constrain.WeightedAverageConstraintProcessor;
import writenlg.linguistics.phrase.PhraseSpecification;
import writenlg.linguistics.phrase.Predicate;
import writenlg.linguistics.phrase.Subject;

/**
 * TODO: Perhaps a flaw in the overall structure. The intended eventual sentence does not really fit the current
 * PhraseSpecification/SimpleNLG model. Needs a discrete approach.
 * Initial trend for presentation of overall trend outline.
 */
public class TrendConcept extends AbstractConcept
{
	private static final Logger LOGGER = LogManager.getLogger("TrendConcept.class");

	private final TimeSeriesWithDerivedInformation timeSeries;
	private final Map<String, ConstraintConfiguration> constraints;

	private String completeText;

	/**
	 * Creates a new TrendConcept instance.
	 * 
	 * @param phraseSpecifications
	 * @param timeSeriesWithDerivedInformation
	 */
	public TrendConcept(List<PhraseSpecification> phraseSpecifications,
			final TimeSeriesWithDerivedInformation timeSeriesWithDerivedInformation)
	{
		super(phraseSpecifications, new SoftConstraintGroup<>(new WeightedAverageConstraintProcessor()));

		this.timeSeries = timeSeriesWithDerivedInformation;
		this.constraints = Constraints.getInstance()
				.getConfigurationsForTimeSeriesSpecificConcept(TimeSeriesSpecificConcept.TREND);

		assessConstraints();
	}

	private void assessConstraints()
	{
		assessMultipleTrendsConstraint();
		assessAscendingAndDescendingConstraint();
	}

	private void assessMultipleTrendsConstraint()
	{
		final ConstraintConfiguration multipleTrendsConstraintConfiguration = this.constraints
				.get(ConstraintType.MULTIPLE_TRENDS.getTextualForm());

		final int smoothedSegmentCount = this.timeSeries.getSmoothedSegments().size();
		final int outlineSegmentCount = this.timeSeries.getOutlineSegments().size();

		LOGGER.info(String.format("smoothedSegmentCount: %d; outlineSegmentCount: %d", smoothedSegmentCount,
				outlineSegmentCount));

		final int segmentCount = outlineSegmentCount < smoothedSegmentCount ? outlineSegmentCount
				: smoothedSegmentCount;

		if (segmentCount != getPhraseSpecifications().size())
		{
			LOGGER.error(String.format(
					"Inconsistent values for reported trend size - segmentCount: %d; PhraseSpecification count: %d. PhraseSpecification list should have been adjusted to match smallest smoothed segment collection",
					segmentCount, getPhraseSpecifications().size()));

			throw new RuntimeException(
					"Inconsistent values for reported trend size. PhraseSpecification list should have been adjusted to match smallest smoothed segment collection");
		}

		final BigDecimal multipleTrendsConstraintValue = segmentCount > 1 ? GlobalConstants.ONE : GlobalConstants.ZERO;

		LOGGER.info(String.format("Multiple trends constraint value: %s", multipleTrendsConstraintValue));

		final Constraint<ConstraintType> multipleTrendsConstraint = new BoundedWeightedConstraint<ConstraintType>(
				ConstraintType.MOST_SEGMENTS_ASCENDING,
				new SatisfactionLevel(
						multipleTrendsConstraintValue.multiply(multipleTrendsConstraintConfiguration.getValue()),
						multipleTrendsConstraintConfiguration.getWeighting()),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintLowerBound")),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintUpperBound")));

		addConstraint(multipleTrendsConstraint);
	}

	private void assessAscendingAndDescendingConstraint()
	{
		final ConstraintConfiguration ascendingAndDescendingConstraintConfiguration = this.constraints
				.get(ConstraintType.ASCENDING_AND_DESCENDING.getTextualForm());

		final List<Segment> smoothedSegments = this.timeSeries.getSegments();

		int ascendingSegmentCount = 0;
		int descendingSegmentCount = 0;

		for (Segment eachSegment : smoothedSegments)
		{
			if (eachSegment.getSlope() == Slope.ASCENDING)
			{
				ascendingSegmentCount++;
			}

			if (eachSegment.getSlope() == Slope.DESCENDING)
			{
				descendingSegmentCount++;
			}
		}

		final BigDecimal ascendingAndDescendingConstraintValue = ascendingSegmentCount == 0
				|| descendingSegmentCount == 0 ? GlobalConstants.ZERO : GlobalConstants.ONE;

		LOGGER.info(
				String.format("Ascending and descending constraint value: %s", ascendingAndDescendingConstraintValue));

		final Constraint<ConstraintType> ascendingAndDescendingConstraint = new BoundedWeightedConstraint<ConstraintType>(
				ConstraintType.MOST_SEGMENTS_ASCENDING,
				new SatisfactionLevel(
						ascendingAndDescendingConstraintValue
								.multiply(ascendingAndDescendingConstraintConfiguration.getValue()),
						ascendingAndDescendingConstraintConfiguration.getWeighting()),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintLowerBound")),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintUpperBound")));

		addConstraint(ascendingAndDescendingConstraint);
	}

	// TODO: the intended sentence, here, does not sit well with the current PhraseSpecification implementation or the
	// apparent SimpleNLG offer. Clearly, there are a range of opportunities for improvement/further development.
	@Override
	public String toString()
	{
		if (this.completeText == null)
		{
			int phraseSpecificationCount = getPhraseSpecifications().size();

			StringBuilder builder = new StringBuilder();

			Subject subject = getPhraseSpecifications().get(0).getSubject();
			builder.append(subject.getNounPhrase().getPreModifier());
			builder.append(GlobalConstants.SPACE);
			builder.append(subject.getNounPhrase().getText());
			builder.append(GlobalConstants.SPACE);

			Predicate firstPredicate = getPhraseSpecifications().get(0).getPredicate();
			builder.append(firstPredicate.getVerb().getText());
			builder.append(GlobalConstants.SPACE);
			builder.append(firstPredicate.getComplement().getText());
			builder.append(GlobalConstants.SPACE);

			int counter;

			for (counter = 1; counter < phraseSpecificationCount - 1; counter++)
			{
				builder.append(GlobalConstants.COMMA);
				builder.append(GlobalConstants.SPACE);

				Predicate additionalPredicate = getPhraseSpecifications().get(counter).getPredicate();
				builder.append(additionalPredicate.getVerb().getText());
				builder.append(GlobalConstants.SPACE);
				builder.append(additionalPredicate.getComplement().getText());
				builder.append(GlobalConstants.SPACE);
			}

			builder.append("and ");

			Predicate lastPredicate = getPhraseSpecifications().get(counter).getPredicate();
			builder.append(lastPredicate.getVerb().getText());
			builder.append(GlobalConstants.SPACE);
			builder.append(lastPredicate.getComplement().getText());

			this.completeText = builder.toString();
		}

		return this.completeText;
	}
}
