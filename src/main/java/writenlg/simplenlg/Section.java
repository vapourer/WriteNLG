// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.simplenlg;

import java.util.ArrayList;
import java.util.List;

import simplenlg.framework.DocumentElement;

/**
 * Creates a Section instance, and makes available Section processing and SimpleNlg realisation.
 */
public class Section implements DocumentGenerator
{
	private final DocumentElement section;
	private String title;
	private final List<Paragraph> paragraphs = new ArrayList<>();

	/**
	 * Creates a new Section instance.
	 */
	public Section()
	{
		this.title = "Section";
		this.section = SimpleNlg.getInstance().createSection(this.title);
	}

	/**
	 * Processes this Section, and calls process on child paragraphs.
	 */
	@Override
	public void process()
	{
		this.section.setTitle(this.title);

		for (final Paragraph eachParagraph : this.paragraphs)
		{
			eachParagraph.process();
			this.section.addComponent(eachParagraph.getAsDocumentElement());
		}
	}

	/**
	 * Realises this Section.
	 */
	@Override
	public String generate()
	{
		process();
		return SimpleNlg.getInstance().realise(this.section);
	}

	/**
	 * Adds a paragraph to this Section.
	 * 
	 * @param paragraph
	 */
	public void addParagraph(final Paragraph paragraph)
	{
		this.paragraphs.add(paragraph);
	}

	/**
	 * Returns this Section as a SimpleNlg DocumentElement.
	 * 
	 * @return Section
	 */
	public DocumentElement getAsDocumentElement()
	{
		return this.section;
	}

	/**
	 * Returns the title of this Section.
	 * 
	 * @return String
	 */
	public String getTitle()
	{
		return this.title;
	}

	/**
	 * Sets the title of this Section.
	 * 
	 * @param title
	 */
	public void setTitle(final String title)
	{
		this.title = title;
	}
}
