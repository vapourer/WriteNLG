package analysis.interfaces;

import analysis.Analysis;

/**
 * Analyses input data which represents a time series, and stores results in an Analysis object.
 */
public interface Analyser
{
	/**
	 * Analyses input time series, storing results in an Analysis object.
	 * 
	 * @return Analysis
	 */
	Analysis analyse();
}
