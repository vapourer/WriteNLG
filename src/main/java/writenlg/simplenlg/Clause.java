// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.simplenlg;

import simplenlg.framework.NLGElement;

/**
 * Abstract base class for clause implementations.
 */
public abstract class Clause implements DocumentGenerator
{
	/**
	 * Returns a clause as an NLGElement.
	 * 
	 * @return NLGElement
	 */
	public abstract NLGElement getAsNLGElement();
}
