// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.substitution;

import java.util.HashMap;
import java.util.Map;

/**
 * Alternative number representations.
 */
public final class NumberTransformations
{
	private final Map<Integer, String> numbersToStrings;

	public NumberTransformations()
	{
		this.numbersToStrings = new HashMap<>();
		populateNumbersToStrings();
	}

	private void populateNumbersToStrings()
	{
		this.numbersToStrings.put(new Integer(1), "one");
		this.numbersToStrings.put(new Integer(2), "two");
		this.numbersToStrings.put(new Integer(3), "three");
		this.numbersToStrings.put(new Integer(4), "four");
		this.numbersToStrings.put(new Integer(5), "five");
		this.numbersToStrings.put(new Integer(6), "six");
		this.numbersToStrings.put(new Integer(7), "seven");
		this.numbersToStrings.put(new Integer(8), "eight");
		this.numbersToStrings.put(new Integer(9), "nine");
		this.numbersToStrings.put(new Integer(10), "ten");
		this.numbersToStrings.put(new Integer(11), "eleven");
		this.numbersToStrings.put(new Integer(12), "twelve");
		this.numbersToStrings.put(new Integer(13), "thirteen");
		this.numbersToStrings.put(new Integer(14), "fourteen");
		this.numbersToStrings.put(new Integer(15), "fifteen");
		this.numbersToStrings.put(new Integer(16), "sixteen");
		this.numbersToStrings.put(new Integer(17), "seventeen");
		this.numbersToStrings.put(new Integer(18), "eighteen");
		this.numbersToStrings.put(new Integer(19), "nineteen");
		this.numbersToStrings.put(new Integer(20), "twenty");
	}

	/**
	 * @param number
	 * @return a text version of number
	 */
	public String textForNumber(Integer number)
	{
		return this.numbersToStrings.get(number);
	}
}
