// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.simplenlg;

import java.util.List;

import simplenlg.framework.CoordinatedPhraseElement;
import simplenlg.framework.DocumentElement;
import simplenlg.framework.NLGElement;
import simplenlg.framework.NLGFactory;
import simplenlg.lexicon.Lexicon;
import simplenlg.phrasespec.NPPhraseSpec;
import simplenlg.phrasespec.SPhraseSpec;
import simplenlg.realiser.english.Realiser;

/**
 * Wrapper for SimpleNLG
 *
 * @see <a href=
 *      "https://github.com/simplenlg/simplenlg">https://github.com/simplenlg/simplenlg</a>
 */
public class SimpleNlg
{
	private static volatile SimpleNlg INSTANCE = null;

	private final NLGFactory nlgFactory;
	private final Realiser realiser;

	/**
	 * Provides a singleton instance of SimpleNLG
	 *
	 * @return SimpleNLG
	 */
	public static SimpleNlg getInstance()
	{
		if (INSTANCE == null)
		{
			synchronized (SimpleNlg.class)
			{
				if (INSTANCE == null)
				{
					INSTANCE = new SimpleNlg();
				}
			}
		}

		return INSTANCE;
	}

	/**
	 * Creates a SimpleNlg instance
	 */
	private SimpleNlg()
	{
		final Lexicon lexicon = Lexicon.getDefaultLexicon();
		this.nlgFactory = new NLGFactory(lexicon);
		this.realiser = new Realiser(lexicon);
	}

	/**
	 * Creates a new NPPhraseSpec according to text
	 * 
	 * @param text
	 * @return NPPhraseSpec
	 */
	public NPPhraseSpec createNounPhraseSpecification(String text)
	{
		return this.nlgFactory.createNounPhrase(text);
	}

	/**
	 * Creates a new SPhraseSpec
	 *
	 * @return SPhraseSpec
	 */
	public SPhraseSpec createClause()
	{
		return this.nlgFactory.createClause();
	}

	/**
	 * Returns a new CoordinatedPhraseElement.
	 * 
	 * @return CoordinatedPhraseElement
	 */
	public CoordinatedPhraseElement createCoordinatedPhraseElement()
	{
		return this.nlgFactory.createCoordinatedPhrase();
	}

	/**
	 * Returns a new CoordinatedPhraseElement, according to coordinate1 and coordinate2.
	 * 
	 * @param coordinate1
	 * @param coordinate2
	 * @return
	 */
	public CoordinatedPhraseElement createCoordinatedPhraseElement(Object coordinate1, Object coordinate2)
	{
		return this.nlgFactory.createCoordinatedPhrase(coordinate1, coordinate2);
	}

	/**
	 * Returns a DocumentElement representing a SimpleNlg sentence.
	 * 
	 * @return DocumentElement
	 */
	public DocumentElement createSentence()
	{
		return this.nlgFactory.createSentence();
	}

	/**
	 * Returns a DocumentElement representing a SimpleNlg sentence based on the input clause parameter.
	 * 
	 * @param clause
	 * @return DocumentElement
	 */
	public DocumentElement createSentence(final NLGElement clause)
	{
		return this.nlgFactory.createSentence(clause);
	}

	/**
	 * Returns a DocumentElement representing a SimpleNlg sentence based on the cannedSentence parameter.
	 * 
	 * @param cannedSentence
	 * @return DocumentElement
	 */
	public DocumentElement createSentence(final String cannedSentence)
	{
		return this.nlgFactory.createSentence(cannedSentence);
	}

	/**
	 * Returns a paragraph as a new DocumentElement.
	 * 
	 * @return DocumentElement
	 */
	public DocumentElement createParagraph()
	{
		return this.nlgFactory.createParagraph();
	}

	/**
	 * Returns a paragraph as a new DocumentElement based on the element parameter.
	 * 
	 * @return DocumentElement
	 */
	public DocumentElement createParagraph(final NLGElement element)
	{
		return this.nlgFactory.createParagraph(element);
	}

	/**
	 * Returns a paragraph as a new DocumentElement based on the sentences parameter.
	 * 
	 * @return DocumentElement
	 */
	public DocumentElement createParagraph(final List<DocumentElement> sentences)
	{
		return this.nlgFactory.createParagraph(sentences);
	}

	/**
	 * Returns a section as a new DocumentElement based on the title parameter.
	 * 
	 * @param title
	 * @return DocumentElement
	 */
	public DocumentElement createSection(final String title)
	{
		return this.nlgFactory.createSection(title);
	}

	/**
	 * Returns a document as a new DocumentElement based on the title parameter.
	 * 
	 * @param title
	 * @return DocumentElement
	 */
	public DocumentElement createDocument(final String title)
	{
		return this.nlgFactory.createDocument(title);
	}

	/**
	 * Realises the input NLGElement.
	 * 
	 * @param element
	 * @return String
	 */
	public String realise(final NLGElement element)
	{
		if (element instanceof SPhraseSpec || element instanceof CoordinatedPhraseElement)
		{
			return this.realiser.realiseSentence(element);
		}
		else
		{
			return this.realiser.realise(element).getRealisation();
		}
	}
}
