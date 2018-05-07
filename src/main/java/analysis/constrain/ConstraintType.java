// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.constrain;

/**
 * Constraint types for LinesCrossConcept
 */
public enum ConstraintType
{
	LINES_CROSS("LinesCross"), LINES_CROSS_MULTIPLE_TIMES("LinesCrossMultipleTimes"), LINES_DO_NOT_CROSS(
			"LinesDoNotCross");

	final private String textualForm;

	private ConstraintType(final String text)
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
