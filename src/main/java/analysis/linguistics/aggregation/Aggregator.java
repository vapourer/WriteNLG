// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.linguistics.aggregation;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.CharStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import control.WriteNlgProperties;
import io.AntlrInputReader;
import io.LexerParser;
import io.expertinput.AggregationLexerParser;
import io.expertinput.listener.AggregationListener;
import writenlg.aggregation.ConceptGroup;

/**
 * Performs aggregation in conjunction with document planning, according to constraints
 */
public class Aggregator
{
	private static final Logger LOGGER = LogManager.getLogger("Aggregator.class");

	private final Map<AggregationConstraintType, ConceptGroup> conceptGroups;
	// private final Set<AbstractConcept> concepts;

	/**
	 * Creates an Aggregator instance.
	 */
	public Aggregator()
	{
		this.conceptGroups = new HashMap<>();
		// this.concepts = concepts;

		LOGGER.info("New Aggregator created");
		loadAggregationConcepts(WriteNlgProperties.getInstance().getProperty("AntlrInputAggregation"));
	}

	private void loadAggregationConcepts(final String path)
	{
		final CharStream charStream = new AntlrInputReader(path).getAntlrInputFromFile();
		final LexerParser lexerParser = new AggregationLexerParser(charStream);
		final AggregationListener listener = new AggregationListener();
		lexerParser.walkParseTree(listener);
	}

	/**
	 * @param constraintType
	 * @param group
	 */
	public void addConceptGroup(AggregationConstraintType constraintType, ConceptGroup group)
	{
		this.conceptGroups.put(constraintType, group);
	}
}
