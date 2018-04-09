// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.write;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.junit.Assert;
import org.junit.Test;

import writenlg.expertinput.LexerParser;
import writenlg.expertinput.WriterLexerParser;
import writenlg.expertinput.listener.WriterListener;
import writenlg.simplenlg.DocumentGenerator;

public class DocumentTest
{
	@Test
	public void testDocumentOneSectionTwoParagraphs()
	{
		// Arrange
		final String outputExpected = "Document\nDrinks\nI drink coffee. You drink tea.\n\nHe boils the red kettle. She warms the tea pot.\n\n";

		final String inputText = "Document\nSection\tSectionTitle=Drinks\nParagraph\nSentence\nClause\nSubject:I\nVerb:drink\nObject:coffee\n"
				+ "Sentence\nClause\nSubject:you\nVerb:drink\nObject:tea\nParagraph\nSentence\nClause\nSubject:he\nVerb:boil\nObject:the red kettle\n"
				+ "Sentence\nClause\nSubject:she\nVerb:warm\nObject:the tea pot";
		final CodePointCharStream input = CharStreams.fromString(inputText);

		final LexerParser writerLexerParser = new WriterLexerParser(input);
		final WriterListener listener = new WriterListener();

		// Act
		writerLexerParser.walkParseTree(listener);
		final DocumentGenerator documentGenerator = listener.selectDocumentGenerator();
		final String outputActual = documentGenerator.generate();

		// Assert
		Assert.assertEquals(outputExpected, outputActual);
	}
}
