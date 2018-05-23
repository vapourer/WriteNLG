// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.aggregation.concepts;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.GlobalConcept;
import analysis.TimeSeriesSpecificConcept;
import analysis.constrain.Constraints;
import analysis.linguistics.aggregation.AggregationConcept;
import analysis.linguistics.contentdetermination.ConstraintType;
import control.WriteNlgProperties;
import writenlg.AbstractConcept;
import writenlg.aggregation.AbstractAggregationConcept;
import writenlg.constrain.Constraint;
import writenlg.constrain.ConstraintConfiguration;
import writenlg.constrain.HardConstraint;
import writenlg.constrain.HardConstraintGroup;
import writenlg.constrain.HardConstraintProcessor;
import writenlg.constrain.SatisfactionLevel;
import writenlg.linguistics.phrase.PhraseSpecification;

/**
 * If all introductory information is present, relevant aggregation occurs. Currently, there should be no case where any
 * introductory information is missing.
 */
public class AllIntroductoryInformationPresentConcept extends AbstractAggregationConcept
{
	private static final Logger LOGGER = LogManager.getLogger("AllIntroductoryInformationPresentConcept.class");

	private final Map<String, ConstraintConfiguration> constraints;

	private Map<GlobalConcept, AbstractConcept> globalConcepts;
	private Map<TimeSeriesSpecificConcept, List<AbstractConcept>> timeSeriesSpecificConcepts;

	private int introductoryInformationElementCount;

	/**
	 * Creates an AllIntroductoryInformationPresentConcept instance.
	 */
	public AllIntroductoryInformationPresentConcept()
	{
		this(new ArrayList<>());
	}

	/**
	 * Creates an AllIntroductoryInformationPresentConcept instance.
	 * 
	 * @param phraseSpecifications
	 */
	public AllIntroductoryInformationPresentConcept(List<PhraseSpecification> phraseSpecifications)
	{
		super(phraseSpecifications, new HardConstraintGroup<>(new HardConstraintProcessor()));

		this.constraints = Constraints.getInstance()
				.getConfigurationsForAggregationConcept(AggregationConcept.ALL_INTRODUCTORY_INFORMATION_PRESENT);

		this.introductoryInformationElementCount = 0;
	}

	/**
	 * @param globalConcepts
	 *            the globalConcepts to set
	 */
	public void setGlobalConcepts(Map<GlobalConcept, AbstractConcept> globalConcepts)
	{
		this.globalConcepts = globalConcepts;
	}

	/**
	 * @param timeSeriesSpecificConcepts
	 *            the timeSeriesSpecificConcepts to set
	 */
	public void setTimeSeriesSpecificConcepts(
			Map<TimeSeriesSpecificConcept, List<AbstractConcept>> timeSeriesSpecificConcepts)
	{
		this.timeSeriesSpecificConcepts = timeSeriesSpecificConcepts;
	}

	@Override
	protected void prepareAggregatedPhraseSpecification()
	{
		if (this.getPhraseSpecifications().size() == 0)
		{
			LOGGER.info(
					"List of phrase specifications was empty, but current implementation expects a prepared phrase specification from ANTLR input");
			throw new RuntimeException(
					"Current implementation expects a prepared phrase specification from ANTLR input");
		}
	}

	@Override
	protected void assessConstraints()
	{
		assessLineCountRequiredConstraint();
		assessSeriesLegendRequiredConstraint();
		assessTimeSliceRequiredConstraint();
		assessAllIntroductoryInformationPresentConstraint();
	}

	private void assessLineCountRequiredConstraint()
	{
		BigDecimal lineCountPresent = this.constraints.get(ConstraintType.LINE_COUNT.getTextualForm()).getValue();

		if (this.globalConcepts.get(GlobalConcept.LINE_COUNT) != null)
		{
			lineCountPresent = lineCountPresent.multiply(new BigDecimal("1"));
			this.introductoryInformationElementCount++;
		}
		else
		{
			lineCountPresent = lineCountPresent.multiply(new BigDecimal("0"));
		}

		final Constraint<ConstraintType> lineCountRequiredConstraint = new HardConstraint<ConstraintType>(
				ConstraintType.LINE_COUNT, new SatisfactionLevel(lineCountPresent));

		addConstraint(lineCountRequiredConstraint);
	}

	private void assessSeriesLegendRequiredConstraint()
	{
		BigDecimal seriesLegendsPresent = this.constraints.get(ConstraintType.SERIES_LEGEND.getTextualForm())
				.getValue();

		final int seriesLegendCount = this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.SERIES_LEGEND)
				.size();

		this.introductoryInformationElementCount += seriesLegendCount;

		for (int i = 0; i < seriesLegendCount; i++)
		{
			final Constraint<ConstraintType> timeSliceRequiredConstraint = new HardConstraint<ConstraintType>(
					ConstraintType.SERIES_LEGEND,
					new SatisfactionLevel(seriesLegendsPresent.multiply(new BigDecimal("1"))));

			addConstraint(timeSliceRequiredConstraint);
		}

	}

	private void assessTimeSliceRequiredConstraint()
	{
		BigDecimal timeSlicePresent = this.constraints.get(ConstraintType.TIME_SLICE_REQUIRED.getTextualForm())
				.getValue();

		if (!this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.TIME_SLICE).isEmpty())
		{
			timeSlicePresent = timeSlicePresent.multiply(new BigDecimal("1"));
			this.introductoryInformationElementCount++;
		}
		else
		{
			timeSlicePresent = timeSlicePresent.multiply(new BigDecimal("0"));
		}

		final Constraint<ConstraintType> timeSliceRequiredConstraint = new HardConstraint<ConstraintType>(
				ConstraintType.TIME_SLICE_REQUIRED, new SatisfactionLevel(timeSlicePresent));

		addConstraint(timeSliceRequiredConstraint);
	}

	private void assessAllIntroductoryInformationPresentConstraint()
	{
		BigDecimal allIntroductoryInformationPresent = this.constraints
				.get(ConstraintType.ALL_INTRODUCTORY_INFORMATION_PRESENT.getTextualForm()).getValue();

		int introductoryInformationElementSizeRequired = Integer
				.parseInt(WriteNlgProperties.getInstance().getProperty("IntroductoryInformationElementSize"));

		if (this.introductoryInformationElementCount == introductoryInformationElementSizeRequired)
		{
			allIntroductoryInformationPresent = allIntroductoryInformationPresent.multiply(new BigDecimal("1"));
		}
		else
		{
			allIntroductoryInformationPresent = allIntroductoryInformationPresent.multiply(new BigDecimal("0"));
		}

		final Constraint<ConstraintType> allIntroductoryInformationPresentConstraint = new HardConstraint<ConstraintType>(
				ConstraintType.ALL_INTRODUCTORY_INFORMATION_PRESENT,
				new SatisfactionLevel(allIntroductoryInformationPresent));

		addConstraint(allIntroductoryInformationPresentConstraint);
	}
}
