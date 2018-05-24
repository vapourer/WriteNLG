// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.time;

import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The regular interval used for the linegraph.
 */
public class TimeSlice
{
	private static final Logger LOGGER = LogManager.getLogger("TimeSlice.class");

	private final int MILLISECONDS_TO_DAYS = 1000 * 60 * 60 * 24;

	private final long time1;
	private final long time2;
	private Long interval;
	private String intervalAsString;
	private String intervalAsAdjective;

	/**
	 * Creates a new TimeSlice instance.
	 * 
	 * @param time1
	 * @param time2
	 */
	public TimeSlice(Long time1, Long time2)
	{
		if (time2.compareTo(time1) <= 0)
		{
			LOGGER.error(String.format("time2(%d) <= time1(%d)", time2.longValue(), time1.longValue()));
			throw new IllegalArgumentException("time2 must be greater than time1");
		}

		this.time1 = time1.longValue();
		this.time2 = time2.longValue();

		LOGGER.info(String.format("TimeSlice created - time1: %d, time2: %d", time1.longValue(), time2.longValue()));
	}

	/**
	 * @return the interval
	 */
	public Long getInterval()
	{
		if (this.interval == null)
		{
			this.interval = Long.valueOf(this.time2 - this.time1);

			LOGGER.info(String.format("Interval is %d", this.interval));
		}

		return this.interval;
	}

	@Override
	public String toString()
	{
		if (this.intervalAsString == null)
		{
			this.intervalAsString = calculateTimeSlice();

			LOGGER.info(String.format("String representation is %s", this.intervalAsString));
		}

		return this.intervalAsString;
	}

	public String asAdjective()
	{
		if (this.intervalAsAdjective == null)
		{
			this.intervalAsAdjective = calculateTimeSliceAsAdjective();

			LOGGER.info(String.format("Adjective representation is %s", this.intervalAsAdjective));
		}

		return this.intervalAsAdjective;
	}

	/**
	 * TODO: identify 1 week based on dates that cross from one month to the next. Not an immediate priority for current
	 * experimentation.
	 */
	private String calculateTimeSlice()
	{
		Calendar calendar = Calendar.getInstance();

		calendar.setTimeInMillis(this.time1);
		int year1 = calendar.get(Calendar.YEAR);
		int month1 = calendar.get(Calendar.MONTH);
		int day1 = calendar.get(Calendar.DAY_OF_MONTH);
		int weekOfYear1 = calendar.get(Calendar.WEEK_OF_YEAR);

		calendar.setTimeInMillis(this.time2);
		int year2 = calendar.get(Calendar.YEAR);
		int month2 = calendar.get(Calendar.MONTH);
		int day2 = calendar.get(Calendar.DAY_OF_MONTH);
		int weekOfYear2 = calendar.get(Calendar.WEEK_OF_YEAR);

		int yearDifference = year2 - year1;
		int monthDifference = month2 - month1;
		int dayDifference = day2 - day1;

		if (monthDifference == 0 && (dayDifference == 0 || weekOfYear2 == weekOfYear1))
		{
			return yearDifference == 1 ? "year" : yearDifference + " years";
		}
		else if (yearDifference == 0 && dayDifference == 0)
		{
			return monthDifference == 1 ? "month" : monthDifference + " months";
		}
		else if (yearDifference == 0 && monthDifference == 0 && dayDifference % 7 == 0)
		{
			return dayDifference == 7 ? "week" : (dayDifference / 7) + " weeks";
		}
		else if (yearDifference == 0 && monthDifference == 0 && dayDifference % 7 > 0)
		{
			return dayDifference == 1 ? "day" : dayDifference + " days";
		}
		else
		{
			return ((this.time2 - this.time1) / MILLISECONDS_TO_DAYS) + " days";
		}
	}

	private String calculateTimeSliceAsAdjective()
	{
		Calendar calendar = Calendar.getInstance();

		calendar.setTimeInMillis(this.time1);
		int year1 = calendar.get(Calendar.YEAR);
		int month1 = calendar.get(Calendar.MONTH);
		int day1 = calendar.get(Calendar.DAY_OF_MONTH);
		int weekOfYear1 = calendar.get(Calendar.WEEK_OF_YEAR);

		calendar.setTimeInMillis(this.time2);
		int year2 = calendar.get(Calendar.YEAR);
		int month2 = calendar.get(Calendar.MONTH);
		int day2 = calendar.get(Calendar.DAY_OF_MONTH);
		int weekOfYear2 = calendar.get(Calendar.WEEK_OF_YEAR);

		int yearDifference = year2 - year1;
		int monthDifference = month2 - month1;
		int dayDifference = day2 - day1;

		if (monthDifference == 0 && (dayDifference == 0 || weekOfYear2 == weekOfYear1))
		{
			return yearDifference + " year";
		}
		else if (yearDifference == 0 && dayDifference == 0)
		{
			return monthDifference + " month";
		}
		else if (yearDifference == 0 && monthDifference == 0 && dayDifference % 7 == 0)
		{
			return (dayDifference / 7) + " week";
		}
		else if (yearDifference == 0 && monthDifference == 0 && dayDifference % 7 > 0)
		{
			return dayDifference + " day";
		}
		else
		{
			return ((this.time2 - this.time1) / MILLISECONDS_TO_DAYS) + " day";
		}
	}
}
