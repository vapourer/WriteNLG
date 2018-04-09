// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.simplenlg;

import java.util.ArrayList;
import java.util.List;

import simplenlg.framework.DocumentElement;

/**
 * Creates, processes and realises SimpleNlg DocumentElement instances. A
 * DocumentElement is the highest level DocumentElement used in SimpleNlg.
 */
public class Document implements DocumentGenerator
{
	private final DocumentElement document;
	private String title;
	private final List<Section> sections = new ArrayList<>();

	/**
	 * Creates a new Document instance.
	 */
	public Document()
	{
		this.title = "Document";
		this.document = SimpleNlg.getInstance().createDocument(this.title);
	}

	/**
	 * Processes this Document. Calls process on child DocumentElement instances.
	 */
	@Override
	public void process()
	{
		this.document.setTitle(this.title);

		for (final Section eachSection : this.sections)
		{
			eachSection.process();
			this.document.addComponent(eachSection.getAsDocumentElement());
		}
	}

	/**
	 * Realises this Document.
	 */
	@Override
	public String generate()
	{
		process();
		return SimpleNlg.getInstance().realise(this.document);
	}

	/**
	 * Adds a section to this Document.
	 * 
	 * @param section
	 */
	public void addSection(final Section section)
	{
		this.sections.add(section);
	}

	/**
	 * Returns this Document as a DocumentElement.
	 * 
	 * @return DocumentElement
	 */
	public DocumentElement getAsDocumentElement()
	{
		return this.document;
	}

	/**
	 * Returns the title of this Document.
	 * 
	 * @return String
	 */
	public String getTitle()
	{
		return this.title;
	}

	/**
	 * Sets the title of this Document.
	 * 
	 * @param title
	 */
	public void setTitle(final String title)
	{
		this.title = title;
	}
}
