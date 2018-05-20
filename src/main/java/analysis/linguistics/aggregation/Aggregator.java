// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.aggregation;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import writenlg.aggregation.AbstractAggregationConcept;

/**
 * Performs aggregation in conjunction with document planning, according to constraints
 */
public class Aggregator
{
	private static final Logger LOGGER = LogManager.getLogger("Aggregator.class");

	private final Set<AbstractAggregationConcept> aggregationConcepts;

	public Aggregator()
	{
		this.aggregationConcepts = new HashSet<>();

		LOGGER.info("New Aggregator created");
	}

	/**
	 * @param concept
	 */
	public void addAggregationConcept(AbstractAggregationConcept concept)
	{
		this.aggregationConcepts.add(concept);
	}
}
