package writenlg.simplenlg;

/**
 * Enables final processing prior to SimpleNLG realisation, and access to the SimpleNLG wrapper.
 */
public interface DocumentGenerator
{
	/**
	 * Processes this DocumentGenerator. Includes calling Process on child DocumentGenerator instances.
	 */
	void process();

	/**
	 * Realises this DocumentGenerator.
	 */
	String generate();
}
