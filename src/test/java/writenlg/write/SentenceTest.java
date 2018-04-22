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

public class SentenceTest
{
	private static Logger LOGGER;

	@BeforeClass
	public static void setupClass()
	{
		System.setProperty("log4j.configurationFile", TestConstants.LOG4J2_CONFIGURATION_FILE_PATH);
		LOGGER = LogManager.getLogger("SentenceTest.class");
	}

	@Test
	public void testSentenceTwoClauses()
	{
		LOGGER.info("Test: testSentenceTwoClauses");

		// Arrange
		final String outputExpected = "I drink coffee and you drink tea.";

		final String inputText = "Sentence\nClause\nSubclause\nSubject:I\nVerb:drink\nObject:coffee\nSubclause\nSubject:you\nVerb:drink\nObject:tea";
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
	public void testSentenceThreeClauses()
	{
		LOGGER.info("Test: testSentenceThreeClauses");

		// Arrange
		final String outputExpected = "I drink coffee, you drink tea and she drinks orange juice.";

		final String inputText = "Sentence\nClause\nSubclause\nSubject:I\nVerb:drink\nObject:coffee\nSubclause\nSubject:you\nVerb:drink\nObject:tea\nSubclause\nSubject:she\nVerb:drink\nObject:orange juice";
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
	public void testSentenceThreeClausesSetConjunction()
	{
		LOGGER.info("Test: testSentenceThreeClausesSetConjunction");

		// Arrange
		final String outputExpected = "I drink coffee, you drink tea but she drinks orange juice.";

		final String inputText = "Sentence\nClause\nFeatures\nconjunction=but\nSubclause\nSubject:I\nVerb:drink\nObject:coffee\nSubclause\nSubject:you\n"
				+ "Verb:drink\nObject:tea\nSubclause\nSubject:she\nVerb:drink\nObject:orange juice";
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
	public void testSentenceMainAndSubordinateClauses()
	{
		LOGGER.info("Test: testSentenceMainAndSubordinateClauses");

		// Arrange
		final String outputExpected = "I drink coffee because I like it.";

		final String inputText = "Sentence\nClause\nSubject:I\nVerb:drink\nObject:coffee\nClause\nFeatures\ncomplementiser=because\n"
				+ "Subject:I\nVerb:like\nObject:it";
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
