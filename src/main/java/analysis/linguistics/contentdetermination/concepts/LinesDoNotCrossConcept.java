// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.contentdetermination.concepts;

import java.util.List;

import analysis.linguistics.contentdetermination.ConstraintType;
import writenlg.constrain.ConstraintGroup;
import writenlg.contentdetermination.AbstractConcept;
import writenlg.linguistics.phrase.PhraseSpecification;

/**
 * Representation of a lines not crossing concept.
 */
public class LinesDoNotCrossConcept extends AbstractConcept
{
	/**
	 * Creates a new LinesDoNotCrossConcept instance.
	 * 
	 * @param phraseSpecifications
	 * @param constraintGroup
	 */
	public LinesDoNotCrossConcept(List<PhraseSpecification> phraseSpecifications,
			ConstraintGroup<ConstraintType> constraintGroup)
	{
		super(phraseSpecifications, constraintGroup);
	}
}
