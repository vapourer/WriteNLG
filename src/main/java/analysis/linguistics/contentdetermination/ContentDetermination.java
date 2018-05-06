// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.contentdetermination;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.interfaces.ConceptLoader;
import analysis.interfaces.ContentDeterminer;
import analysis.linguistics.contentdetermination.concepts.AbstractConcept;
import writenlg.control.WriteNlgProperties;

/**
 * Determines NLG content derived from time series analysis.
 */
public class ContentDetermination implements ContentDeterminer
{
	private static final Logger LOGGER = LogManager.getLogger("ContentDetermination.class");

	private final List<AbstractConcept> globalConcepts;
	private final List<AbstractConcept> timeSeriesSpecificConcepts;
	private int targetConceptCount;
	private BigDecimal constraintThreshold;

	public ContentDetermination(ConceptLoader concepts)
	{
		this.globalConcepts = concepts.getGlobalConcepts();
		this.timeSeriesSpecificConcepts = concepts.getTimeSeriesSpecificConcepts();
		this.targetConceptCount = Integer.parseInt(WriteNlgProperties.getInstance().getProperty("TargetConceptCount"));
		this.constraintThreshold = new BigDecimal(
				WriteNlgProperties.getInstance().getProperty("ConceptConstraintThreshold"));

		LOGGER.info("ContentDetermination instance created");
	}

	/**
	 * @return a List of Concept instances selected during initial constraint evaluation.
	 */
	@Override
	public List<AbstractConcept> getSelectedConcepts()
	{
		return rationaliseConcepts();
	}

	private List<AbstractConcept> rationaliseConcepts()
	{
		List<AbstractConcept> rationalisedConcepts = new ArrayList<>();

		List<AbstractConcept> conceptsCopy = this.globalConcepts;
		conceptsCopy.addAll(timeSeriesSpecificConcepts);

		Collections.sort(conceptsCopy, Collections.reverseOrder(new ConceptSatisfactionLevelComparator()));

		for (AbstractConcept eachConcept : conceptsCopy)
		{
			if (rationalisedConcepts.size() <= this.targetConceptCount
					&& eachConcept.calculateSatisfactionLevel().compareTo(constraintThreshold) >= 0)
			{
				rationalisedConcepts.add(eachConcept);
			}
		}

		LOGGER.info(String.format("%d concepts selected", rationalisedConcepts.size()));

		for (AbstractConcept concept : rationalisedConcepts)
		{
			LOGGER.info(String.format("Selected concept: %s", concept.getClass()));
		}

		return rationalisedConcepts;
	}
}
