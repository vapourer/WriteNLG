// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.aggregation.concepts;

import java.util.ArrayList;
import java.util.List;

import writenlg.aggregation.AbstractAggregationConcept;
import writenlg.constrain.HardConstraintGroup;
import writenlg.constrain.HardConstraintProcessor;
import writenlg.linguistics.phrase.PhraseSpecification;

/**
 * If all introductory information is present, relevant aggregation occurs. Currently, there should be no case where any
 * introductory information is missing.
 */
public class AllIntroductoryInformationPresentConcept extends AbstractAggregationConcept
{
	/**
	 * Creates an AllIntroductoryInformationPresentConcept instance.
	 */
	public AllIntroductoryInformationPresentConcept()
	{
		this(new ArrayList<>());
	}

	/**
	 * Creates an AllIntroductoryInformationPresentConcept instance.
	 * 
	 * @param phraseSpecifications
	 */
	public AllIntroductoryInformationPresentConcept(List<PhraseSpecification> phraseSpecifications)
	{
		super(phraseSpecifications, new HardConstraintGroup<>(new HardConstraintProcessor()));
	}
}
