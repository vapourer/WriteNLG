// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.contentdetermination.concepts;

import java.util.List;

import analysis.linguistics.contentdetermination.ConstraintType;
import analysis.linguistics.phrase.PhraseSpecification;
import writenlg.constrain.ConstraintGroup;

/**
 * Representation of a line count concept.
 */
public class LineCountConcept extends AbstractConcept
{
	/**
	 * Creates a new LineCountConcept instance.
	 * 
	 * @param phraseSpecifications
	 * @param constraintGroup
	 */
	public LineCountConcept(List<PhraseSpecification> phraseSpecifications,
			ConstraintGroup<ConstraintType> constraintGroup)
	{
		super(phraseSpecifications, constraintGroup);
	}
}
