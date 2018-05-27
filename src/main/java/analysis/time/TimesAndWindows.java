// Copyright 2018 David Jakes.
// This program is distributed under the terms of the GNU General Public License.

package analysis.time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import analysis.graph.Segment;
import analysis.utilities.GlobalConstants;
import control.WriteNlgProperties;

/**
 * Creates String representations of time intervals during which a graph feature occurs.
 */
public class TimesAndWindows
{
	private final List<Segment> segments;
	private final TimeSlice timeSlice;

	private final List<String> windowsForSegmentStartPoints;
	private final List<String> windowsForSegmentEndPoints;

	/**
	 * Creates a TimesAndWindows instance.
	 * 
	 * @param segments
	 * @param timeSlice
	 */
	public TimesAndWindows(final List<Segment> segments, final TimeSlice timeSlice)
	{
		this.segments = segments;
		this.timeSlice = timeSlice;

		this.windowsForSegmentStartPoints = populateWindows(true);
		this.windowsForSegmentEndPoints = populateWindows(false);
	}

	/**
	 * @return the windowsForSegmentStartPoints
	 */
	public List<String> getWindowsForSegmentStartPoints()
	{
		return new ArrayList<>(this.windowsForSegmentStartPoints);
	}

	/**
	 * @return the windowsForSegmentEndPoints
	 */
	public List<String> getWindowsForSegmentEndPoints()
	{
		return new ArrayList<>(this.windowsForSegmentEndPoints);
	}

	private List<String> populateWindows(final boolean startPoints)
	{
		if (timeSlice.toString().equals("week"))
		{
			return getWindowsByWeek(startPoints);
		}
		else
		{
			return getWindowsByTime(startPoints);
		}
	}

	private List<String> getWindowsByWeek(final boolean startPoints)
	{
		List<String> windows = new ArrayList<>();

		for (Segment eachSegment : this.segments)
		{
			windows.add("in week " + (startPoints ? eachSegment.getPoint1().getX().add(GlobalConstants.ONE).intValue()
					: eachSegment.getPoint2().getX().add(GlobalConstants.ONE).intValue()));
		}

		return windows;
	}

	private List<String> getWindowsByTime(final boolean startPoints)
	{
		List<String> windows = new ArrayList<>();

		for (Segment eachSegment : segments)
		{
			windows.add(getWindow(eachSegment.getStartTime(), eachSegment.getEndTime(), startPoints));
		}

		return windows;
	}

	private String getWindow(Long time1, Long time2, final boolean startPoints)
	{
		final Calendar calendar = Calendar.getInstance();

		if (timeSlice.toString().equals("year"))
		{
			calendar.setTimeInMillis(startPoints ? time1.longValue() : time2.longValue());

			return "in " + calendar.get(Calendar.YEAR);
		}
		else
		{
			DateFormat dateFormatter = new SimpleDateFormat(WriteNlgProperties.getInstance().getProperty("DateFormat"));
			return "on "
					+ (startPoints ? dateFormatter.format(new Date(time1)) : dateFormatter.format(new Date(time2)));
		}
	}
}
