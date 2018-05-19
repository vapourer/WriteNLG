// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.interfaces;

import java.util.List;

import analysis.GlobalConcept;
import analysis.TimeSeriesSpecificConcept;
import writenlg.contentdetermination.AbstractConcept;
import writenlg.linguistics.phrase.PhraseSpecification;

/**
 * Concept collections populated from ANTLR PhraseCreator input.
 */
public interface ConceptLoader
{
	/**
	 * Adds globalConcept with its attendant List of PhraseSpecification instances.
	 * 
	 * @param globalConcept
	 * @param phraseSpecifications
	 */
	void addGlobalConcept(GlobalConcept globalConcept, List<PhraseSpecification> phraseSpecifications);

	/**
	 * Adds timeSeriesSpecificConcept with its attendant List of PhraseSpecification instances.
	 * 
	 * @param timeSeriesSpecificConcept
	 * @param phraseSpecifications
	 */
	void addTimeSeriesSpecificConcept(TimeSeriesSpecificConcept timeSeriesSpecificConcept,
			List<PhraseSpecification> phraseSpecifications);

	/**
	 * @return a List of global concepts.
	 */
	List<AbstractConcept> getGlobalConcepts();

	/**
	 * @return a List of time series specific concepts.
	 */
	List<AbstractConcept> getTimeSeriesSpecificConcepts();
}
