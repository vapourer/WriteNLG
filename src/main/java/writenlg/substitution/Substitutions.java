// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package writenlg.substitution;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Maintains a placeholder/substitution map.
 */
public class Substitutions
{
	private static final Logger LOGGER = LogManager.getLogger("Substitutions.class");

	private final Map<String, String> substitutions = new HashMap<>();

	/**
	 * Adds a substitution to this Map.
	 * 
	 * @param placeHolder
	 * @param substitute
	 */
	public void addSubstitution(final String placeHolder, final String substitute)
	{
		if (!placeHolder.startsWith("@@") || !placeHolder.endsWith("@@"))
		{
			LOGGER.error("Place holder not of form @@.+?@@");
			throw new IllegalArgumentException("Substitutions must be of the form @@.+?@@.");
		}

		this.substitutions.put(placeHolder, substitute);

		LOGGER.info(String.format("%s substituted for %s", substitute, placeHolder));
	}

	/**
	 * Returns a copy of this Substitutions Map.
	 * 
	 * @return
	 */
	public Map<String, String> getSubstitutions()
	{
		return new HashMap<>(this.substitutions);
	}
}
