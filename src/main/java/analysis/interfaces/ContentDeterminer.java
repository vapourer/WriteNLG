// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.interfaces;

import java.math.BigDecimal;
import java.util.List;

import analysis.TimeSeriesSpecificConcept;
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
	 * @param timeSeriesSpecificConcept
	 * @param phraseSpecifications
	 */
	void addTimeSeriesSpecificConcept(TimeSeriesSpecificConcept timeSeriesSpecificConcept,
			List<PhraseSpecification> phraseSpecifications, final BigDecimal weighting);

	List<AbstractConcept> getSelectedConcepts();
}