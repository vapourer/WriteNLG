// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.documentplanning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.GlobalConcept;
import analysis.LineGraphWithDerivedInformation;
import analysis.TimeSeriesSpecificConcept;
import analysis.linguistics.contentdetermination.concepts.DescendingTrendConcept;
import analysis.linguistics.contentdetermination.concepts.LineCountConcept;
import analysis.linguistics.contentdetermination.concepts.LinesCrossConcept;
import analysis.linguistics.contentdetermination.concepts.LinesCrossMultipleTimesConcept;
import analysis.linguistics.contentdetermination.concepts.LinesDoNotCrossConcept;
import analysis.linguistics.contentdetermination.concepts.MaximumConcept;
import analysis.linguistics.contentdetermination.concepts.MinimumConcept;
import analysis.linguistics.contentdetermination.concepts.RisingTrendConcept;
import analysis.linguistics.contentdetermination.concepts.SeriesLegendConcept;
import analysis.linguistics.contentdetermination.concepts.TimeSliceConcept;
import writenlg.AbstractConcept;
import writenlg.linguistics.phrase.PhraseSpecification;
import writenlg.linguistics.phrase.partofspeech.Complement;
import writenlg.linguistics.phrase.partofspeech.NounPhrase;
import writenlg.simplenlg.Clause;
import writenlg.simplenlg.Document;
import writenlg.simplenlg.Paragraph;
import writenlg.simplenlg.PartOfSpeech;
import writenlg.simplenlg.Section;
import writenlg.simplenlg.Sentence;
import writenlg.simplenlg.SimpleClause;

/**
 * Flexible document planning is not part of the current project. This initial implementation is to establish a standard
 * order for concepts for eventual output, whilst offering opportunities for greater future flexibility.
 */
public class DocumentPlanner
{
	private static final Logger LOGGER = LogManager.getLogger("DocumentPlanner.class");

	private final LineGraphWithDerivedInformation lineGraph;
	private final List<AbstractConcept> concepts;
	private final Map<GlobalConcept, AbstractConcept> globalConcepts;
	private final Map<TimeSeriesSpecificConcept, List<AbstractConcept>> timeSeriesSpecificConcepts;

	public DocumentPlanner(final LineGraphWithDerivedInformation lineGraphWithDerivedInformation,
			List<AbstractConcept> concepts)
	{
		this.lineGraph = lineGraphWithDerivedInformation;
		this.concepts = concepts;
		this.globalConcepts = new HashMap<>();
		this.timeSeriesSpecificConcepts = new HashMap<>();

		prepareMapsAndLoadConcepts();

		LOGGER.info("New DocumentPlanner created");
	}

	private Clause createSimpleClause(PhraseSpecification specification)
	{
		final SimpleClause clause = new SimpleClause();

		clause.addAssignment(PartOfSpeech.SUBJECT, specification.getSubject().getNounPhrase().getText());

		clause.addAssignment(PartOfSpeech.VERB, specification.getPredicate().getVerb().getText());

		Complement complement = specification.getPredicate().getComplement();

		if (complement != null)
		{
			clause.addAssignment(PartOfSpeech.COMPLEMENT, complement.getText());
		}

		NounPhrase noun = specification.getPredicate().getNounPhrase();

		if (noun != null)
		{
			clause.addAssignment(PartOfSpeech.OBJECT, noun.getText());
		}

		return clause;
	}

	public String createDocument()
	{
		Document document = new Document();
		document.setTitle(this.lineGraph.getTitle());
		Section section = new Section();
		section.setTitle("");
		Paragraph paragraph1 = new Paragraph();
		Paragraph paragraph2 = new Paragraph();

		LineCountConcept lineCountConcept = (LineCountConcept) this.globalConcepts.get(GlobalConcept.LINE_COUNT);

		if (lineCountConcept != null)
		{
			Sentence sentence = new Sentence();
			sentence.addClause(createSimpleClause(lineCountConcept.getPhraseSpecifications().get(0)));
			paragraph1.addSentence(sentence);
		}

		List<AbstractConcept> seriesLegendConcepts = this.timeSeriesSpecificConcepts
				.get(TimeSeriesSpecificConcept.SERIES_LEGEND);

		if (!seriesLegendConcepts.isEmpty())
		{
			for (AbstractConcept eachConcept : seriesLegendConcepts)
			{
				Sentence sentence = new Sentence();
				sentence.addClause(createSimpleClause(eachConcept.getPhraseSpecifications().get(0)));
				paragraph1.addSentence(sentence);
			}
		}

		List<AbstractConcept> timeSliceConcepts = this.timeSeriesSpecificConcepts
				.get(TimeSeriesSpecificConcept.TIME_SLICE);

		if (!timeSliceConcepts.isEmpty())
		{
			for (AbstractConcept eachConcept : timeSliceConcepts)
			{
				Sentence sentence = new Sentence();
				sentence.addClause(createSimpleClause(eachConcept.getPhraseSpecifications().get(0)));
				paragraph1.addSentence(sentence);
			}
		}

		List<AbstractConcept> risingTrendConcepts = this.timeSeriesSpecificConcepts
				.get(TimeSeriesSpecificConcept.RISING_TREND);

		if (!risingTrendConcepts.isEmpty())
		{
			for (AbstractConcept eachConcept : risingTrendConcepts)
			{
				Sentence sentence = new Sentence();
				sentence.addClause(createSimpleClause(eachConcept.getPhraseSpecifications().get(0)));
				paragraph2.addSentence(sentence);
			}
		}

		List<AbstractConcept> descendingTrendConcepts = this.timeSeriesSpecificConcepts
				.get(TimeSeriesSpecificConcept.DESCENDING_TREND);

		if (!descendingTrendConcepts.isEmpty())
		{
			for (AbstractConcept eachConcept : descendingTrendConcepts)
			{
				Sentence sentence = new Sentence();
				sentence.addClause(createSimpleClause(eachConcept.getPhraseSpecifications().get(0)));
				paragraph2.addSentence(sentence);
			}
		}

		List<AbstractConcept> maximumConcepts = this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.MAXIMUM);

		if (!maximumConcepts.isEmpty())
		{
			for (AbstractConcept eachConcept : maximumConcepts)
			{
				Sentence sentence = new Sentence();
				sentence.addClause(createSimpleClause(eachConcept.getPhraseSpecifications().get(0)));
				paragraph2.addSentence(sentence);
			}
		}

		List<AbstractConcept> minimumConcepts = this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.MINIMUM);

		if (!minimumConcepts.isEmpty())
		{
			for (AbstractConcept eachConcept : minimumConcepts)
			{
				Sentence sentence = new Sentence();
				sentence.addClause(createSimpleClause(eachConcept.getPhraseSpecifications().get(0)));
				paragraph2.addSentence(sentence);
			}
		}

		LinesCrossConcept linesCrossConcept = (LinesCrossConcept) this.globalConcepts.get(GlobalConcept.LINES_CROSS);

		if (linesCrossConcept != null)
		{
			Sentence sentence = new Sentence();
			sentence.addClause(createSimpleClause(linesCrossConcept.getPhraseSpecifications().get(0)));
			paragraph2.addSentence(sentence);
		}

		LinesDoNotCrossConcept linesDoNotCrossConcept = (LinesDoNotCrossConcept) this.globalConcepts
				.get(GlobalConcept.LINES_DO_NOT_CROSS);

		if (linesDoNotCrossConcept != null)
		{
			Sentence sentence = new Sentence();
			sentence.addClause(createSimpleClause(linesDoNotCrossConcept.getPhraseSpecifications().get(0)));
			paragraph2.addSentence(sentence);
		}

		LinesCrossMultipleTimesConcept linesCrossMultipleTimesConcept = (LinesCrossMultipleTimesConcept) this.globalConcepts
				.get(GlobalConcept.LINES_CROSS_MULTIPLE_TIMES);

		if (linesCrossMultipleTimesConcept != null)
		{
			Sentence sentence = new Sentence();
			sentence.addClause(createSimpleClause(linesCrossMultipleTimesConcept.getPhraseSpecifications().get(0)));
			paragraph2.addSentence(sentence);
		}

		section.addParagraph(paragraph1);
		section.addParagraph(paragraph2);
		document.addSection(section);

		return document.generate();
	}

	private void prepareMapsAndLoadConcepts()
	{
		loadTimeSeriesSpecificMaps();
		loadConcepts();
	}

	private void loadTimeSeriesSpecificMaps()
	{
		this.timeSeriesSpecificConcepts.put(TimeSeriesSpecificConcept.DESCENDING_TREND, new ArrayList<>());
		this.timeSeriesSpecificConcepts.put(TimeSeriesSpecificConcept.MAXIMUM, new ArrayList<>());
		this.timeSeriesSpecificConcepts.put(TimeSeriesSpecificConcept.MINIMUM, new ArrayList<>());
		this.timeSeriesSpecificConcepts.put(TimeSeriesSpecificConcept.RISING_TREND, new ArrayList<>());
		this.timeSeriesSpecificConcepts.put(TimeSeriesSpecificConcept.SERIES_LEGEND, new ArrayList<>());
		this.timeSeriesSpecificConcepts.put(TimeSeriesSpecificConcept.TIME_SLICE, new ArrayList<>());
	}

	private void loadConcepts()
	{
		for (AbstractConcept eachConcept : this.concepts)
		{
			if (eachConcept instanceof LineCountConcept)
			{
				this.globalConcepts.put(GlobalConcept.LINE_COUNT, eachConcept);
				LOGGER.info(String.format("GlobalConcept added: %s", GlobalConcept.LINE_COUNT));
			}

			if (eachConcept instanceof LinesCrossConcept)
			{
				this.globalConcepts.put(GlobalConcept.LINES_CROSS, eachConcept);
				LOGGER.info(String.format("GlobalConcept added: %s", GlobalConcept.LINES_CROSS));
			}

			if (eachConcept instanceof LinesCrossMultipleTimesConcept)
			{
				this.globalConcepts.put(GlobalConcept.LINES_CROSS_MULTIPLE_TIMES, eachConcept);
				LOGGER.info(String.format("GlobalConcept added: %s", GlobalConcept.LINES_CROSS_MULTIPLE_TIMES));
			}

			if (eachConcept instanceof LinesDoNotCrossConcept)
			{
				this.globalConcepts.put(GlobalConcept.LINES_DO_NOT_CROSS, eachConcept);
				LOGGER.info(String.format("GlobalConcept added: %s", GlobalConcept.LINES_DO_NOT_CROSS));
			}

			if (eachConcept instanceof SeriesLegendConcept)
			{
				this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.SERIES_LEGEND).add(eachConcept);
				LOGGER.info(
						String.format("TimeSeriesSpecificConcept added: %s", TimeSeriesSpecificConcept.SERIES_LEGEND));
			}

			if (eachConcept instanceof DescendingTrendConcept)
			{
				this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.DESCENDING_TREND).add(eachConcept);
				LOGGER.info(String.format("TimeSeriesSpecificConcept added: %s",
						TimeSeriesSpecificConcept.DESCENDING_TREND));
			}

			if (eachConcept instanceof MaximumConcept)
			{
				this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.MAXIMUM).add(eachConcept);
				LOGGER.info(String.format("TimeSeriesSpecificConcept added: %s", TimeSeriesSpecificConcept.MAXIMUM));
			}

			if (eachConcept instanceof MinimumConcept)
			{
				this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.MINIMUM).add(eachConcept);
				LOGGER.info(String.format("TimeSeriesSpecificConcept added: %s", TimeSeriesSpecificConcept.MINIMUM));
			}

			if (eachConcept instanceof RisingTrendConcept)
			{
				this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.RISING_TREND).add(eachConcept);
				LOGGER.info(
						String.format("TimeSeriesSpecificConcept added: %s", TimeSeriesSpecificConcept.RISING_TREND));
			}

			if (eachConcept instanceof TimeSliceConcept)
			{
				this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.TIME_SLICE).add(eachConcept);
				LOGGER.info(String.format("TimeSeriesSpecificConcept added: %s", TimeSeriesSpecificConcept.TIME_SLICE));
			}
		}
	}
}
