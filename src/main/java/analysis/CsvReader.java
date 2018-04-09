// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis;

/**
 * Reads a set of comma separated values into an array.
 */
public class CsvReader
{
	private final String numbersAsCsv;

	/**
	 * Creates a new CsvReader according to numbersAsCsv.
	 * 
	 * @param numbersAsCsv
	 */
	public CsvReader(final String numbersAsCsv)
	{
		this.numbersAsCsv = numbersAsCsv;
	}

	/**
	 * Processes a String which represents a set of comma separated values.
	 * 
	 * @return an int array
	 */
	public int[] processCsv()
	{
		final String[] numbersAsStrings = this.numbersAsCsv.split(",");
		final int[] numbers = new int[numbersAsStrings.length];

		for (int i = 0; i < numbersAsStrings.length; i++)
		{
			numbers[i] = Integer.parseInt(numbersAsStrings[i]);
		}

		return numbers;
	}
}
