package writenlg.simplenlg;

/**
 * enum of Element types for use with SimpleNlg
 */
public enum ElementCategory
{
	DOCUMENT(0), SECTION(1), PARAGRAPH(2), SENTENCE(3), COORDINATED_PHRASE(4), SIMPLE_CLAUSE(5), LIST(1001), LIST_ITEM(
			1002);

	private int level;

	/**
	 * ElementCategory constructor
	 * @param level
	 */
	ElementCategory(final int level)
	{
		this.level = level;
	}

	/**
	 * Used during ANTLR parsing before submitting to SimpleNlg processing.
	 * @return the level of this ElementCategory
	 */
	public int getLevel()
	{
		return this.level;
	}
}
