// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.interfaces;

import java.util.List;

import analysis.Concept;
import analysis.linguistics.contentdetermination.concepts.AbstractConcept;
import analysis.linguistics.phrase.PhraseSpecification;

/**
 * Determines NLG content derived from time series analysis.
 */
public interface ContentDeterminer
{
	/**
	 * Creates a new AbstractConcept implementation according to concept, and adds it to an AbstractConcept List.
	 * 
	 * @param concept
	 * @param phraseSpecifications
	 */
	void addConcept(Concept concept, List<PhraseSpecification> phraseSpecifications);

	List<AbstractConcept> getSelectedConcepts();
}
