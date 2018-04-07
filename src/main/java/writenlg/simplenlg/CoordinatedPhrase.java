package writenlg.simplenlg;

import java.util.ArrayList;
import java.util.List;

import simplenlg.framework.CoordinatedPhraseElement;
import simplenlg.framework.NLGElement;

/**
 * For use with SimpleNlg. Creates, processes and realises SimpleNlg
 * CoordinatedPhraseElement instances. A CoordinatedPhraseElement 'defines
 * coordination between two or more phrases'.
 */
public class CoordinatedPhrase extends Clause
{
	private final CoordinatedPhraseElement coordinatedPhraseElement;
	private final List<SimpleClause> clauses = new ArrayList<>();
	private String conjunction;

	/**
	 * Creates a CoordinatedPhrase instance.
	 */
	public CoordinatedPhrase()
	{
		this("");
	}

	/**
	 * Creates a CoordinatedPhrase instance, which uses the conjunction parameter.
	 * 
	 * @param conjunction
	 */
	public CoordinatedPhrase(final String conjunction)
	{
		this.coordinatedPhraseElement = SimpleNlg.getInstance().createCoordinatedPhraseElement();
		this.conjunction = conjunction;
	}

	/**
	 * Returns this CoordinatedPhraseElement
	 * @return the coordinatedPhraseElement
	 */
	public CoordinatedPhraseElement getCoordinatedPhraseElement()
	{
		return this.coordinatedPhraseElement;
	}

	/**
	 * Processes this CoordinatedPhrase. Calls process on child clauses.
	 */
	@Override
	public void process()
	{
		for (final SimpleClause eachClause : this.clauses)
		{
			eachClause.process();
			this.coordinatedPhraseElement.addCoordinate(eachClause.getSpecification());
		}

		if (!"".equals(this.conjunction))
		{
			this.coordinatedPhraseElement.setConjunction(this.conjunction);
		}
	}

	/**
	 * Realises this CoordinatedPhrase.
	 */
	@Override
	public String generate()
	{
		process();
		return SimpleNlg.getInstance().realise(this.coordinatedPhraseElement);
	}

	/**
	 * Add a clause to this CoordinatedPhrase.
	 * 
	 * @param clause
	 */
	public void addClause(final SimpleClause clause)
	{
		this.clauses.add(clause);
	}

	/**
	 * Returns a CoordinatedPhrase as an NLGElement.
	 * 
	 * @return NLGElement
	 */
	@Override
	public NLGElement getAsNLGElement()
	{
		return this.coordinatedPhraseElement;
	}

	/**
	 * Sets the conjunction for this CoordinatedPhrase.
	 * 
	 * @param conjunction
	 */
	public void setConjunction(final String conjunction)
	{
		this.conjunction = conjunction;
	}
}
