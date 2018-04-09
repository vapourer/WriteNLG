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

public class ClauseTest
{
	@Test
	public void testSimpleClause()
	{
		// Arrange
		final String outputExpected = "Dixxy likes food.";

		final String inputText = "Subject:Dixxy\nVerb:like\r\nObject:food";
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

	@Test
	public void testCoordinatedPhrase_SubclausesWithObjects()
	{
		// Arrange
		final String outputExpected = "I like coffee and you like tea.";

		final String inputText = "Clause\nSubclause\nSubject:I\nVerb:like\nObject:coffee\nSubclause\nSubject:you\nVerb:like\nObject:tea";
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

	@Test
	public void testCoordinatedPhrase_SubclausesWithComplements()
	{
		// Arrange
		final String outputExpected = "Day is light and night is dark.";

		final String inputText = "Clause\nSubclause\nSubject:day\nVerb:be\nComplement:light\nSubclause\nSubject:night\nVerb:be\nComplement:dark";
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
