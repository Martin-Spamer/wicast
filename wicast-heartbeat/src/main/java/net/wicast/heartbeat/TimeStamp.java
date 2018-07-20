
package net.wicast.heartbeat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * TimeStamp class.
 */
public class TimeStamp {

    /**
     * default output is ISO format time stamp.
     */
    public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss:SSSZ";

    /**
     * point time in time when TimeStamp was created.
     */
    public final Date time = Calendar.getInstance().getTime();

    public static String now() {
        return new TimeStamp().toString();
    }

    /**
     * Returns the timestamp as a string.
     *
     * @return the string
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return new SimpleDateFormat(TimeStamp.TIMESTAMP_FORMAT, Locale.getDefault()).format(time);
    }
}
