// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.contentdetermination.concepts;

import java.math.BigDecimal;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
import analysis.graph.Slope;
import analysis.interfaces.Assessor;
import analysis.statistics.PointYValueInverseComparator;
import writenlg.control.WriteNlgProperties;

/**
 * Establishes constraint values for time series maximum values, based on initial values and weightings input from ANTLR
 * Constraints text file, and analysis of time series data.
 */
public class MaximumAssessor implements Assessor
{
	private static final Logger LOGGER = LogManager.getLogger("MaximumAssessor.class");

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

		LOGGER.info("MaximumAssessor created");
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
		LOGGER.info(String.format("Maximum: %s", maximum));

		int ninetyPercentileSize = this.timeSeries.getSeries().size() / 10;
		LOGGER.info(String.format("Ninety percentile size: %d", ninetyPercentileSize));

		Point[] ninetyPercentile = new Point[ninetyPercentileSize];

		final AbstractQueue<Point> queue = new PriorityQueue<>(new PointYValueInverseComparator());

		for (Point eachPoint : this.timeSeries.getPoints())
		{
			queue.add(eachPoint);
		}

		for (int i = 0; i < ninetyPercentileSize; i++)
		{
			ninetyPercentile[i] = queue.poll();
			LOGGER.info(String.format("%s is in ninety percentile", ninetyPercentile[i]));
		}

		BigDecimal ninetyPercentileThreshold = null;

		for (int i = ninetyPercentileSize - 1; i >= 0; i--)
		{
			if (ninetyPercentile[i] != null)
			{
				ninetyPercentileThreshold = ninetyPercentile[i].getY();
				break;
			}
		}

		LOGGER.info(String.format("Ninety percentile threshold: %s", ninetyPercentileThreshold));

		List<Point> ninetyPercentileSmoothed = new ArrayList<>();

		for (Point eachPoint : this.timeSeries.getSmoothedPoints())
		{
			LOGGER.info(String.format("Smoothed point: %s", eachPoint));

			if (eachPoint.getY().compareTo(ninetyPercentileThreshold) > 0
					&& (isTurningPoint(eachPoint) || this.timeSeries.getSmoothedPoints().indexOf(eachPoint) == 0
							|| this.timeSeries.getSmoothedPoints()
									.indexOf(eachPoint) == (this.timeSeries.getSmoothedPoints().size() - 1)))
			{
				ninetyPercentileSmoothed.add(eachPoint);
				LOGGER.info(String.format("Upper turning point identified in ninety percentile - %s", eachPoint));
			}
		}

		int upperTurningPointCount = ninetyPercentileSmoothed.size();
		LOGGER.info(String.format("Count of upper turning points: %d", upperTurningPointCount));

		final Constraint<ConstraintType> singleObviousMaximumConstraint = new BoundedWeightedConstraint<ConstraintType>(
				ConstraintType.SINGLE_OBVIOUS_MAXIMUM,
				new SatisfactionLevel(singleObviousMaximumConstraintConfiguration.getValue(),
						singleObviousMaximumConstraintConfiguration.getWeighting()),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintLowerBound")),
				new BigDecimal(WriteNlgProperties.getInstance().getProperty("WeightedConstraintUpperBound")));

		this.constraintTypes.addConstraint(singleObviousMaximumConstraint);
	}

	private boolean isTurningPoint(final Point point)
	{
		boolean turningPoint = false;

		Segment beforeSegment = null;
		Segment afterSegment = null;

		final List<Segment> smoothedSegments = this.timeSeries.getSmoothedSegments();

		for (Segment eachSmoothedSegment : smoothedSegments)
		{
			if (point.getX().compareTo(eachSmoothedSegment.getPoint2().getX()) == 0)
			{
				beforeSegment = eachSmoothedSegment;
				LOGGER.info("beforePoint found");
			}
			else
			{
				beforeSegment = identifyNearestEarlierSegment(point, smoothedSegments);
			}

			if (point.getX().compareTo(eachSmoothedSegment.getPoint1().getX()) == 0)
			{
				afterSegment = eachSmoothedSegment;
				LOGGER.info("afterPoint found");
			}
			else
			{
				afterSegment = identifyNearestLaterSegment(point, smoothedSegments);
			}
		}

		if (beforeSegment != null && afterSegment != null)
		{
			return beforeSegment.getSlope() == Slope.ASCENDING && afterSegment.getSlope() == Slope.DESCENDING;
		}

		return turningPoint;
	}

	private Segment identifyNearestEarlierSegment(final Point point, final List<Segment> smoothedSegments)
	{
		Segment nearestEarlierSegment = null;

		for (Segment eachSmoothedSegment : smoothedSegments)
		{
			if (eachSmoothedSegment.getPoint2().getX().compareTo(point.getX()) < 0)
			{
				nearestEarlierSegment = eachSmoothedSegment;
			}

			if (eachSmoothedSegment.getPoint2().getX().compareTo(point.getX()) > 0)
			{
				break;
			}
		}

		return nearestEarlierSegment;
	}

	private Segment identifyNearestLaterSegment(final Point point, final List<Segment> smoothedSegments)
	{
		Segment nearestLaterSegment = null;

		for (Segment eachSmoothedSegment : smoothedSegments)
		{
			if (eachSmoothedSegment.getPoint1().getX().compareTo(point.getX()) > 0)
			{
				nearestLaterSegment = eachSmoothedSegment;
				break;
			}
		}

		return nearestLaterSegment;
	}

	/**
	 * @return the constraintTypes
	 */
	public ConstraintGroup<ConstraintType> getMaximumConstraints()
	{
		return this.constraintTypes;
	}
}
