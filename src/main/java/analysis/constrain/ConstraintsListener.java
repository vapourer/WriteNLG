// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.constrain;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import analysis.GlobalConcept;
import analysis.TimeSeriesSpecificConcept;
import io.antlrgenerated.ConstraintsBaseListener;
import io.antlrgenerated.ConstraintsParser;
import io.antlrgenerated.ConstraintsParser.GlobalConceptContext;
import io.antlrgenerated.ConstraintsParser.TimeSeriesConceptContext;

/**
 * ConstraintsBaseListener overrides specific to Constraints.
 */
public class ConstraintsListener extends ConstraintsBaseListener
{
	private static final Logger LOGGER = LogManager.getLogger("ConstraintsListener.class");

	private boolean isGlobal;
	private GlobalConcept globalConcept;
	private TimeSeriesSpecificConcept timeSeriesSpecificConcept;

	/**
	 * Creates a new ConstraintsListener instance.
	 */
	public ConstraintsListener()
	{
		LOGGER.info("New ConstraintsListener created");
	}

	@Override
	public void exitConstraint(ConstraintsParser.ConstraintContext context)
	{
		final String constraintName = context.constraintName().getText();
		final BigDecimal initialValue = new BigDecimal(context.initialValue().getText());
		final BigDecimal weighting = context.weighting() == null ? new BigDecimal("1")
				: new BigDecimal(context.weighting().getText());

		if (this.isGlobal)
		{
			Constraints.getInstance().addConstraintConfigurationForGlobalConcept(this.globalConcept, constraintName,
					initialValue, weighting);
			LOGGER.info("Constraint configuration for global concept loaded");
		}
		else
		{
			Constraints.getInstance().addConstraintConfigurationForTimeSeriesSpecificConcept(timeSeriesSpecificConcept,
					constraintName, initialValue, weighting);
			LOGGER.info("Constraint configuration for time series specific concept loaded");
		}
	}

	@Override
	public void enterGlobalConcept(GlobalConceptContext context)
	{
		this.timeSeriesSpecificConcept = null;
		this.globalConcept = Enum.valueOf(GlobalConcept.class, context.globalConceptType().getText());
		this.isGlobal = true;

		LOGGER.info(String.format("Global concept is %s", context.globalConceptType().getText()));
	}

	@Override
	public void enterTimeSeriesConcept(TimeSeriesConceptContext context)
	{
		this.globalConcept = null;
		this.timeSeriesSpecificConcept = Enum.valueOf(TimeSeriesSpecificConcept.class,
				context.timeSeriesConceptType().getText());
		this.isGlobal = false;

		LOGGER.info(String.format("Time series specific concept is %s", context.timeSeriesConceptType().getText()));
	}
}
