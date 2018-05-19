// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.expertinput.listener;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Map;

import io.antlrgenerated.WriterBaseListener;
import io.antlrgenerated.WriterParser;
import simplenlg.features.Tense;
import writenlg.simplenlg.CoordinatedPhrase;
import writenlg.simplenlg.Document;
import writenlg.simplenlg.DocumentGenerator;
import writenlg.simplenlg.ElementCategory;
import writenlg.simplenlg.Paragraph;
import writenlg.simplenlg.Section;
import writenlg.simplenlg.Sentence;
import writenlg.simplenlg.SimpleClause;
import writenlg.substitution.Substitutions;

/**
 * WriterBaseListener overrides specific to Writer.
 */
public class WriterListener extends WriterBaseListener
{
	private Document document;
	private Section section;
	private Paragraph paragraph;
	private Sentence sentence;
	private CoordinatedPhrase coordinatedPhrase;
	private SimpleClause simpleClause;
	private String conjunction;
	private int decimalPlaces;
	private int highestDocumentElementLevel;
	private final Map<String, String> substitutions;

	/**
	 * Creates an WriterListener instance.
	 */
	public WriterListener()
	{
		this(new Substitutions());
	}

	/**
	 * Creates an WriterListener instance and registers substitutions for use during parsing.
	 */
	public WriterListener(final Substitutions substitutions)
	{
		this.substitutions = substitutions.getSubstitutions();
		this.simpleClause = new SimpleClause();
		this.conjunction = "";
		this.highestDocumentElementLevel = ElementCategory.SIMPLE_CLAUSE.getLevel();
	}

	@Override
	public void exitDocumentTitleValue(final WriterParser.DocumentTitleValueContext context)
	{
		this.document.setTitle(context.getText());
	}

	@Override
	public void exitSectionTitleValue(final WriterParser.SectionTitleValueContext context)
	{
		this.section.setTitle(context.getText());
	}

	@Override
	public void exitConjunctionValue(final WriterParser.ConjunctionValueContext context)
	{
		this.conjunction = context.getText();
	}

	@Override
	public void exitComplementiserValue(final WriterParser.ComplementiserValueContext context)
	{
		this.simpleClause.setComplementiser(context.getText());
	}

	@Override
	public void exitTenseValue(final WriterParser.TenseValueContext context)
	{
		if ("present".equals(context.getText()))
		{
			this.simpleClause.setTense(Tense.PRESENT);
		}
		else if ("past".equals(context.getText()))
		{
			this.simpleClause.setTense(Tense.PAST);
		}
		else if ("future".equals(context.getText()))
		{
			this.simpleClause.setTense(Tense.FUTURE);
		}
	}

	@Override
	public void enterDocument(final WriterParser.DocumentContext context)
	{
		this.document = new Document();
		this.highestDocumentElementLevel = ElementCategory.DOCUMENT.getLevel();
	}

	@Override
	public void enterSection(final WriterParser.SectionContext context)
	{
		this.section = new Section();

		if (ElementCategory.SECTION.getLevel() < this.highestDocumentElementLevel)
		{
			this.highestDocumentElementLevel = ElementCategory.SECTION.getLevel();
		}
	}

	@Override
	public void exitSection(final WriterParser.SectionContext context)
	{
		if (this.document != null)
		{
			this.document.addSection(this.section);
			this.section = null;
		}
	}

	@Override
	public void enterParagraph(final WriterParser.ParagraphContext context)
	{
		this.paragraph = new Paragraph();

		if (ElementCategory.PARAGRAPH.getLevel() < this.highestDocumentElementLevel)
		{
			this.highestDocumentElementLevel = ElementCategory.PARAGRAPH.getLevel();
		}
	}

	@Override
	public void exitParagraph(final WriterParser.ParagraphContext context)
	{
		if (this.section != null)
		{
			this.section.addParagraph(this.paragraph);
			this.paragraph = null;
		}
	}

	@Override
	public void enterSentence(final WriterParser.SentenceContext context)
	{
		this.sentence = new Sentence();

		if (ElementCategory.SENTENCE.getLevel() < this.highestDocumentElementLevel)
		{
			this.highestDocumentElementLevel = ElementCategory.SENTENCE.getLevel();
		}
	}

	@Override
	public void exitSentence(final WriterParser.SentenceContext context)
	{
		if (this.paragraph != null)
		{
			this.paragraph.addSentence(this.sentence);
			this.sentence = null;
		}
	}

	@Override
	public void enterClause(final WriterParser.ClauseContext context)
	{
		this.simpleClause = new SimpleClause();
	}

	@Override
	public void exitClause(final WriterParser.ClauseContext context)
	{
		if (this.sentence != null)
		{
			if (this.coordinatedPhrase != null)
			{
				this.sentence.addClause(this.coordinatedPhrase);
				this.coordinatedPhrase = null;
			}
			else
			{
				this.sentence.addClause(this.simpleClause);
				this.simpleClause = null;
			}
		}
	}

	@Override
	public void enterSubclause(final WriterParser.SubclauseContext context)
	{
		if (this.coordinatedPhrase == null)
		{
			this.coordinatedPhrase = new CoordinatedPhrase(this.conjunction);

			if (ElementCategory.COORDINATED_PHRASE.getLevel() < this.highestDocumentElementLevel)
			{
				this.highestDocumentElementLevel = ElementCategory.COORDINATED_PHRASE.getLevel();
			}
		}

		this.simpleClause = new SimpleClause();
	}

	@Override
	public void exitSubclause(final WriterParser.SubclauseContext context)
	{
		if (this.coordinatedPhrase != null)
		{
			this.coordinatedPhrase.addClause(this.simpleClause);
			this.simpleClause = null;
		}
	}

	@Override
	public void exitDecimalPlaces(final WriterParser.DecimalPlacesContext context)
	{
		final String decimalPlacesAsString = context.decimalPlacesValue().getText();
		this.decimalPlaces = Integer.parseInt(decimalPlacesAsString);
	}

	@Override
	public void exitAssignment(final WriterParser.AssignmentContext context)
	{
		final String identifier = context.identifier().getText();
		String expression = context.expression().getText();

		for (final String eachPlaceHolder : this.substitutions.keySet())
		{
			String substitution = this.substitutions.get(eachPlaceHolder);

			if (substitution.matches("^[-+]?[0-9]*.?[0-9]+$"))
			{
				BigDecimal value = new BigDecimal(substitution);
				int precision = Integer.valueOf(value.intValue()).toString().length();
				precision += this.decimalPlaces;
				final MathContext mathContext = new MathContext(precision, RoundingMode.HALF_UP);
				value = value.round(mathContext);
				substitution = value.toString();
			}

			expression = expression.replaceAll(eachPlaceHolder, substitution);
		}

		this.simpleClause.addAssignment(identifier, expression);
	}

	/**
	 * Establishes the highest level of DocumentGenerator utilised, and returns appropriately.
	 *
	 * @return DocumentGenerator
	 */
	public DocumentGenerator selectDocumentGenerator()
	{
		switch (this.highestDocumentElementLevel)
		{
			case 0:
				return this.document;
			case 1:
				return this.section;
			case 2:
				return this.paragraph;
			case 3:
				return this.sentence;
			case 4:
				return this.coordinatedPhrase;
			case 5:
				return this.simpleClause;
			default:
				throw new RuntimeException(
						"Invalid value for highestDocumentElementLevel: " + this.highestDocumentElementLevel);
		}
	}
}
