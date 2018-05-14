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
import analysis.TimeSeriesSpecificConcept;
import analysis.linguistics.contentdetermination.concepts.AbstractConcept;
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
import writenlg.simplenlg.Document;
import writenlg.simplenlg.Paragraph;
import writenlg.simplenlg.PartOfSpeech;
import writenlg.simplenlg.Section;
import writenlg.simplenlg.Sentence;
import writenlg.simplenlg.SimpleClause;
import writenlg.simplenlg.SimpleNlg;

/**
 * Flexible document planning is not part of the current project. This initial implementation is to establish a standard
 * order for concepts for eventual output, whilst offering opportunities for greater future flexibility.
 */
public class DocumentPlanner
{
	private static final Logger LOGGER = LogManager.getLogger("DocumentPlanner.class");

	private final List<AbstractConcept> concepts;
	private final Map<GlobalConcept, AbstractConcept> globalConcepts;
	private final Map<TimeSeriesSpecificConcept, List<AbstractConcept>> timeSeriesSpecificConcepts;

	public DocumentPlanner(List<AbstractConcept> concepts)
	{
		this.concepts = concepts;
		this.globalConcepts = new HashMap<>();
		this.timeSeriesSpecificConcepts = new HashMap<>();

		prepareMapsAndLoadConcepts();

		LOGGER.info("New DocumentPlanner created");
	}

	public String createDocument()
	{
		final SimpleNlg simpleNlg = SimpleNlg.getInstance();

		Document document = new Document();
		Section section = new Section();
		Paragraph paragraph1 = new Paragraph();
		Sentence sentence1 = new Sentence();

		// String summary = "";
		// final StringBuilder builder = new StringBuilder();

		final SimpleClause introductoryClause = new SimpleClause();

		LineCountConcept lineCountConcept = (LineCountConcept) this.globalConcepts.get(GlobalConcept.LINE_COUNT);

		if (lineCountConcept != null)
		{
			introductoryClause.addAssignment(PartOfSpeech.SUBJECT,
					lineCountConcept.getPhraseSpecifications().get(0).getSubject().getNounPhrase().getText());

			introductoryClause.addAssignment(PartOfSpeech.VERB,
					lineCountConcept.getPhraseSpecifications().get(0).getPredicate().getVerb().getText());

			introductoryClause.addAssignment(PartOfSpeech.COMPLEMENT,
					lineCountConcept.getPhraseSpecifications().get(0).getPredicate().getComplement().getText());

			sentence1.addClause(introductoryClause);
		}

		paragraph1.addSentence(sentence1);
		section.addParagraph(paragraph1);
		document.addSection(section);

		List<AbstractConcept> seriesLegendConcepts = this.timeSeriesSpecificConcepts
				.get(TimeSeriesSpecificConcept.SERIES_LEGEND);

		if (seriesLegendConcepts != null)
		{

		}

		List<AbstractConcept> timeSliceConcepts = this.timeSeriesSpecificConcepts
				.get(TimeSeriesSpecificConcept.TIME_SLICE);

		if (timeSliceConcepts != null)
		{

		}

		List<AbstractConcept> risingTrendConcepts = this.timeSeriesSpecificConcepts
				.get(TimeSeriesSpecificConcept.RISING_TREND);

		if (risingTrendConcepts != null)
		{

		}

		List<AbstractConcept> descendingTrendConcepts = this.timeSeriesSpecificConcepts
				.get(TimeSeriesSpecificConcept.DESCENDING_TREND);

		if (descendingTrendConcepts != null)
		{

		}

		List<AbstractConcept> maximumConcepts = this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.MAXIMUM);

		if (maximumConcepts != null)
		{

		}

		List<AbstractConcept> minimumConcepts = this.timeSeriesSpecificConcepts.get(TimeSeriesSpecificConcept.MINIMUM);

		if (minimumConcepts != null)
		{

		}

		LinesCrossConcept linesCrossConcept = (LinesCrossConcept) this.globalConcepts.get(GlobalConcept.LINES_CROSS);

		if (linesCrossConcept != null)
		{

		}

		LinesDoNotCrossConcept linesDoNotCrossConcept = (LinesDoNotCrossConcept) this.globalConcepts
				.get(GlobalConcept.LINES_DO_NOT_CROSS);

		if (linesDoNotCrossConcept != null)
		{

		}

		LinesCrossMultipleTimesConcept linesCrossMultipleTimesConcept = (LinesCrossMultipleTimesConcept) this.globalConcepts
				.get(GlobalConcept.LINES_CROSS_MULTIPLE_TIMES);

		if (linesCrossMultipleTimesConcept != null)
		{

		}

		// for (AbstractConcept eachConcept : contentDeterminer.getSelectedConcepts())
		// {
		// for (final PhraseSpecification phraseSpecification : eachConcept.getPhraseSpecifications())
		// {
		// final SPhraseSpec clause = simpleNlg.createClause();
		// clause.setSubject(phraseSpecification.getSubject().getNounPhrase().getText());
		// clause.setVerb(phraseSpecification.getPredicate().getVerb().getText());
		//
		// if (phraseSpecification.getPredicate().getNounPhrase() != null)
		// {
		// clause.setObject(phraseSpecification.getPredicate().getNounPhrase().getText());
		// }
		//
		// if (phraseSpecification.getPredicate().getComplement() != null)
		// {
		// clause.setComplement(phraseSpecification.getPredicate().getComplement().getText());
		// }
		//
		// builder.append(simpleNlg.realise(clause));
		// builder.append(System.lineSeparator());
		// }
		// }

		// summary += builder.toString();

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
