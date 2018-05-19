// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.contentdetermination.concepts;

import java.util.List;

import analysis.linguistics.contentdetermination.ConstraintType;
import writenlg.constrain.ConstraintGroup;
import writenlg.contentdetermination.AbstractConcept;
import writenlg.linguistics.phrase.PhraseSpecification;

/**
 * Establishes constraint values for lines crossing multiple times, based on initial values and weightings input from
 * ANTLR Constraints
 * text file, and analysis of time series data.
 */
public class LinesCrossMultipleTimesConcept extends AbstractConcept
{
	/**
	 * Creates a new LinesCrossMultipleTimesConcept instance.
	 * 
	 * @param phraseSpecifications
	 * @param constraintGroup
	 */
	public LinesCrossMultipleTimesConcept(List<PhraseSpecification> phraseSpecifications,
			ConstraintGroup<ConstraintType> constraintGroup)
	{
		super(phraseSpecifications, constraintGroup);
	}
}
