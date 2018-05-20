// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.aggregation.concepts;

import java.util.List;

import analysis.linguistics.contentdetermination.ConstraintType;
import writenlg.aggregation.AbstractAggregationConcept;
import writenlg.constrain.ConstraintGroup;
import writenlg.linguistics.phrase.PhraseSpecification;

/**
 * @author David
 */
public class AllIntroductoryInformationPresentConcept extends AbstractAggregationConcept
{
	/**
	 * Creates an AllIntroductoryInformationPresentConcept instance.
	 * 
	 * @param phraseSpecifications
	 * @param constraintGroup
	 */
	public AllIntroductoryInformationPresentConcept(List<PhraseSpecification> phraseSpecifications,
			ConstraintGroup<ConstraintType> constraintGroup)
	{
		super(phraseSpecifications, constraintGroup);
	}
}
