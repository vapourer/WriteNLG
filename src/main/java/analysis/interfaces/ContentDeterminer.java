// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.interfaces;

import java.util.List;

import writenlg.contentdetermination.AbstractConcept;

/**
 * Determines NLG content derived from time series analysis.
 */
public interface ContentDeterminer
{
	/**
	 * @return a List of Concept instances selected during initial constraint evaluation.
	 */
	List<AbstractConcept> getSelectedConcepts();
}
