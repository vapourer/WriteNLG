package writenlg.write;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.junit.Assert;
import org.junit.Test;

import writenlg.expertinput.LexerParser;
import writenlg.expertinput.WriterLexerParser;
import writenlg.expertinput.listener.WriterListener;
import writenlg.simplenlg.DocumentGenerator;

public class SentenceTest
{
	@Test
	public void testSentenceTwoClauses()
	{
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
