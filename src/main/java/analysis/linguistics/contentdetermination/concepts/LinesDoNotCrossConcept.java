// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.contentdetermination.concepts;

import java.util.List;

import analysis.constrain.ConstraintGroup;
import analysis.linguistics.phrase.PhraseSpecification;

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
			ConstraintGroup<String> constraintGroup)
	{
		super(phraseSpecifications, constraintGroup);
	}
}
