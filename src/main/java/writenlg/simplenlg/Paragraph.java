package writenlg.simplenlg;

import java.util.ArrayList;
import java.util.List;

import simplenlg.framework.DocumentElement;

/**
 * Creates a Paragraph instance, and makes available Paragraph processing and SimpleNlg realisation.
 */
public class Paragraph implements DocumentGenerator
{
	private DocumentElement paragraph;
	private final List<Sentence> sentences = new ArrayList<>();

	/**
	 * Adds a sentence to this paragraph.
	 * @param sentence
	 */
	public void addSentence(final Sentence sentence)
	{
		this.sentences.add(sentence);
	}

	/**
	 * Processes this Paragraph, and calls process on child sentences.
	 */
	@Override
	public void process()
	{
		this.paragraph = SimpleNlg.getInstance().createParagraph();

		for (final Sentence eachSentence : this.sentences)
		{
			eachSentence.process();
			this.paragraph.addComponent(eachSentence.getAsNLGElement());
		}
	}

	/**
	 * Realises this Paragraph.
	 */
	@Override
	public String generate()
	{
		process();
		return SimpleNlg.getInstance().realise(this.paragraph);
	}

	/**
	 * Returns this Paragraph as a SimpleNlg DocumentElement.
	 * @return Paragraph
	 */
	public DocumentElement getAsDocumentElement()
	{
		return this.paragraph;
	}
}
