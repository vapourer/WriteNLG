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

public class ParagraphTest
{
	private static Logger LOGGER;

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
		LOGGER = LogManager.getLogger("ParagraphTest.class");
	}

	@Test
	public void testParagraphWithSentencesWithCoordinatedPhrases()
	{
		LOGGER.info("Test: testParagraphWithSentencesWithCoordinatedPhrases");

		// Arrange
		final String outputExpected = "Day is light and night is dark. I like coffee and you like tea.\n\n";

		final String inputText = "Paragraph\nSentence\nClause\nSubclause\nSubject:day\nVerb:be\nComplement:light\nSubclause\nSubject:night\nVerb:be\n"
				+ "Complement:dark\nSentence\nClause\nSubclause\nSubject:I\nVerb:like\nObject:coffee\nSubclause\nSubject:you\nVerb:like\nObject:tea";
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
