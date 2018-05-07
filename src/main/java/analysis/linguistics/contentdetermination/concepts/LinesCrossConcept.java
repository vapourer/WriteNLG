// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.contentdetermination.concepts;

import java.util.List;

import analysis.constrain.ConstraintGroup;
import analysis.constrain.ConstraintType;
import analysis.linguistics.phrase.PhraseSpecification;

/**
 * Representation of a lines crossing concept.
 */
public class LinesCrossConcept extends AbstractConcept
{
	/**
	 * Creates a new LinesCrossConcept instance.
	 * 
	 * @param phraseSpecifications
	 * @param constraintGroup
	 */
	public LinesCrossConcept(List<PhraseSpecification> phraseSpecifications,
			ConstraintGroup<ConstraintType> constraintGroup)
	{
		super(phraseSpecifications, constraintGroup);
	}
}
