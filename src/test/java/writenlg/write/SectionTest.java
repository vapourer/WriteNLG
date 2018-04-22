// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.write;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import analysis.TestConstants;
import writenlg.expertinput.LexerParser;
import writenlg.expertinput.WriterLexerParser;
import writenlg.expertinput.listener.WriterListener;
import writenlg.simplenlg.DocumentGenerator;

public class SectionTest
{
	private static Logger LOGGER;

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
		LOGGER = LogManager.getLogger("SectionTest.class");
	}

	@Test
	public void testSectionOneParagraphPresentOneParagraphPast()
	{
		LOGGER.info("Test: testSectionOneParagraphPresentOneParagraphPast");

		// Arrange
		final String outputExpected = "Drinks\nI drink coffee. You drink tea.\n\nHe boiled the red kettle. She warmed the tea pot.\n\n";

		final String inputText = "Section\tSectionTitle=Drinks\nParagraph\nSentence\nClause\nSubject:I\nVerb:drink\nObject:coffee\nSentence\n"
				+ "Clause\nSubject:you\nVerb:drink\nObject:tea\nParagraph\nSentence\nClause\nFeatures\ntense=past\nSubject:he\nVerb:boil\n"
				+ "Object:the red kettle\nSentence\nClause\nFeatures\ntense=past\nSubject:she\nVerb:warm\nObject:the tea pot";
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
