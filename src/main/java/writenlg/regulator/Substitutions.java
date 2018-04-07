package writenlg.regulator;

import java.util.HashMap;
import java.util.Map;

/**
 * Maintains a placeholder/substitution map.
 */
public class Substitutions
{
	private final Map<String, String> substitutions = new HashMap<>();

	/**
	 * Adds a substitution to this Map.
	 * @param placeHolder
	 * @param substitute
	 */
	public void addSubstitution(final String placeHolder, final String substitute)
	{
		if (!placeHolder.startsWith("@"))
		{
			throw new IllegalArgumentException("The first character of the placeHolder must be @.");
		}

		this.substitutions.put(placeHolder, substitute);
	}

	/**
	 * Returns a copy of this Substitutions Map.
	 * @return
	 */
	public Map<String, String> getSubstitutions()
	{
		return new HashMap<>(this.substitutions);
	}
}
