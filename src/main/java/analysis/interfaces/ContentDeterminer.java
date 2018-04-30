// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.interfaces;

import java.util.List;

import analysis.GlobalConcept;
import analysis.TimeSeriesSpecificConcept;
import analysis.linguistics.contentdetermination.concepts.AbstractConcept;
import analysis.linguistics.phrase.PhraseSpecification;

/**
 * Determines NLG content derived from time series analysis.
 */
public interface ContentDeterminer
{
	void addGlobalConcept(GlobalConcept globalConcept, List<PhraseSpecification> phraseSpecifications);

	/**
	 * Creates a new AbstractConcept implementation according to concept, and adds it to an AbstractConcept List.
	 * 
	 * @param timeSeriesSpecificConcept
	 * @param phraseSpecifications
	 */
	void addTimeSeriesSpecificConcept(TimeSeriesSpecificConcept timeSeriesSpecificConcept,
			List<PhraseSpecification> phraseSpecifications);

	List<AbstractConcept> getSelectedConcepts();
}
