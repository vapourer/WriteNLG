// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.substitution;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.LineGraphWithDerivedInformation;
import analysis.TimeSeriesWithDerivedInformation;
import analysis.interfaces.Mapper;
import writenlg.substitution.Substitutions;

/**
 * Manages globalMappings for use during parsing.
 */
public class Substitutor implements Mapper
{
	private static final Logger LOGGER = LogManager.getLogger("Substitutor.class");

	private final LineGraphWithDerivedInformation lineGraphWithDerivedInformation;
	private final Substitutions globalMappings;
	private final List<TimeSeriesMapping> timeSeriesMappings;

	/**
	 * Creates a Substitutor instance.
	 * 
	 * @param lineGraphWithDerivedInformation
	 * @param concepts
	 */
	public Substitutor(final LineGraphWithDerivedInformation lineGraphWithDerivedInformation)
	{
		this.lineGraphWithDerivedInformation = lineGraphWithDerivedInformation;
		this.globalMappings = new Substitutions();
		this.timeSeriesMappings = new ArrayList<>();
		loadMappings();
	}

	/**
	 * TODO: current implementation cannot handle more than two time series.
	 * 
	 * @return the globalMappings
	 */
	@Override
	public Substitutions getGlobalMappings()
	{
		if (this.lineGraphWithDerivedInformation.getTimeSeriesCount() == 2)
		{
			List<TimeSeriesWithDerivedInformation> timeSeriesWithDerivedInformation = lineGraphWithDerivedInformation
					.getTimeSeriesDerivedInformation();
			int crossingPointCount = this.lineGraphWithDerivedInformation.getCrossingPointCount(
					timeSeriesWithDerivedInformation.get(0), timeSeriesWithDerivedInformation.get(1));
			this.globalMappings.addSubstitution("@@CrossCount@@", String.valueOf(crossingPointCount));
		}
		else
		{
			LOGGER.error("No implementation for more than two time series");
			throw new RuntimeException("Provision for more than two time series not yet implemented");
		}

		this.globalMappings.addSubstitution("@@LineCount@@",
				String.valueOf(this.lineGraphWithDerivedInformation.getTimeSeriesCount()));

		return this.globalMappings;
	}

	/**
	 * @return the timeSeriesMappings
	 */
	@Override
	public List<TimeSeriesMapping> getTimeSeriesMappings()
	{
		return new ArrayList<>(this.timeSeriesMappings);
	}

	private void loadMappings()
	{
		List<TimeSeriesWithDerivedInformation> timeSeriesWithDerivedInformation = lineGraphWithDerivedInformation
				.getTimeSeriesDerivedInformation();

		for (TimeSeriesWithDerivedInformation eachTimeSeriesWithDerivedInformation : timeSeriesWithDerivedInformation)
		{
			Substitutions substitutions = new Substitutions();
			substitutions.addSubstitution("@@SeriesLegend@@", eachTimeSeriesWithDerivedInformation.getSeriesLegend());
			substitutions.addSubstitution("@@TimeSlice@@",
					eachTimeSeriesWithDerivedInformation.getTimeSlice().toString());
			substitutions.addSubstitution("@@Maximum@@",
					eachTimeSeriesWithDerivedInformation.getPointWithMaximumValue().getY().toString());
			substitutions.addSubstitution("@@Minimum@@",
					eachTimeSeriesWithDerivedInformation.getPointWithMinimumValue().getY().toString());
			substitutions.addSubstitution("@@Direction@@",
					eachTimeSeriesWithDerivedInformation.getDirectionOfLongestSegment().getTextualForm());
			this.timeSeriesMappings.add(new TimeSeriesMapping(eachTimeSeriesWithDerivedInformation, substitutions));
		}
	}
}
