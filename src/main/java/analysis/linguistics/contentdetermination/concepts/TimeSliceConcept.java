// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.contentdetermination.concepts;

import java.util.List;

import analysis.constrain.ConstraintGroup;
import analysis.linguistics.phrase.PhraseSpecification;

/**
 * Representation of a time series time slice.
 */
public class TimeSliceConcept extends AbstractConcept
{

	/**
	 * Creates a new TimeSliceConcept instance.
	 * 
	 * @param phraseSpecifications
	 * @param constraintGroup
	 */
	public TimeSliceConcept(List<PhraseSpecification> phraseSpecifications, ConstraintGroup<String> constraintGroup)
	{
		super(phraseSpecifications, constraintGroup);
	}
}
