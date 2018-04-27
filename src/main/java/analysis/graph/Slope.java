// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.graph;

/**
 * Direction of a line graph segment.
 */
public enum Slope
{
	ASCENDING("ascending"), DESCENDING("descending"), FLAT("flat");

	final private String textualForm;

	private Slope(final String text)
	{
		this.textualForm = text;
	}

	/**
	 * @return the textualForm
	 */
	public String getTextualForm()
	{
		return textualForm;
	}
}
