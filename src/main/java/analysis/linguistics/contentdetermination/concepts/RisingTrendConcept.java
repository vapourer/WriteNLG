// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.contentdetermination.concepts;

import java.util.List;

import analysis.constrain.ConstraintGroup;
import analysis.linguistics.phrase.PhraseSpecification;

/**
 * Representation of a time series rising trend.
 */
public class RisingTrendConcept extends AbstractConcept
{
	/**
	 * Creates a new RisingTrendConcept instance.
	 * 
	 * @param phraseSpecifications
	 * @param constraintGroup
	 */
	public RisingTrendConcept(List<PhraseSpecification> phraseSpecifications, ConstraintGroup<String> constraintGroup)
	{
		super(phraseSpecifications, constraintGroup);
	}
}
