// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.aggregation;

import java.util.HashSet;
import java.util.Set;

import analysis.GlobalConcept;
import analysis.TimeSeriesSpecificConcept;

/**
 * A conceptGroup of Concept instances, to be evaluated as part of the aggregation process.
 */
public class ConceptGroup
{
	private final Set<GlobalConcept> globalConcepts;
	private final Set<TimeSeriesSpecificConcept> timeSeriesSpecificConcepts;

	/**
	 * Creates a new ConceptGroup instance.
	 */
	public ConceptGroup()
	{
		this.globalConcepts = new HashSet<>();
		this.timeSeriesSpecificConcepts = new HashSet<>();
	}

	/**
	 * @param globalConcept
	 */
	public void addGlobalConcept(final GlobalConcept globalConcept)
	{
		this.globalConcepts.add(globalConcept);
	}

	/**
	 * @param timeSeriesSpecificConcept
	 */
	public void addTimeSeriesSpecificConcept(final TimeSeriesSpecificConcept timeSeriesSpecificConcept)
	{
		this.timeSeriesSpecificConcepts.add(timeSeriesSpecificConcept);
	}

	/**
	 * @return the globalConcepts
	 */
	public Set<GlobalConcept> getGlobalConcepts()
	{
		return new HashSet<>(this.globalConcepts);
	}

	/**
	 * @return the timeSeriesSpecificConcepts
	 */
	public Set<TimeSeriesSpecificConcept> getTimeSeriesSpecificConcepts()
	{
		return new HashSet<>(this.timeSeriesSpecificConcepts);
	}
}
