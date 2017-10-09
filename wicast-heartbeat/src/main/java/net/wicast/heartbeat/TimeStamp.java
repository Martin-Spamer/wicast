
package net.wicast.heartbeat;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * TimeStamp.
 */
public class TimeStamp {
	/**
	 * default output is ISO format time stamp.
	 */
	public static final String FORMAT = "yyyy-MM-dd HH:mm:ss:SSSZ";
	/**
	 * point time in time when TimeStamp was created.
	 */
	public final Date time = Calendar.getInstance().getTime();

	/**
	 * To string.
	 *
	 * @return the string
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new SimpleDateFormat(TimeStamp.FORMAT,Locale.getDefault()).format(this.time);
	}

}
