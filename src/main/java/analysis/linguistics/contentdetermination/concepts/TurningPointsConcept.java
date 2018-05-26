// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.contentdetermination.concepts;

import java.util.List;

import writenlg.AbstractConcept;
import writenlg.constrain.SoftConstraintGroup;
import writenlg.constrain.WeightedAverageConstraintProcessor;
import writenlg.linguistics.phrase.PhraseSpecification;

/**
 * Determines whether a comment about a time series' fluctuation should be included.
 */
public class TurningPointsConcept extends AbstractConcept
{

	public TurningPointsConcept(List<PhraseSpecification> phraseSpecifications)
	{
		super(phraseSpecifications, new SoftConstraintGroup<>(new WeightedAverageConstraintProcessor()));
		// TODO Auto-generated constructor stub
	}

}
