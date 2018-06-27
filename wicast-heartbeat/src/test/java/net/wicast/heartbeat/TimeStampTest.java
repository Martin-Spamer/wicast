
package net.wicast.heartbeat;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

/**
 * TimeStampTest.
 */
public class TimeStampTest {

    private static final Logger LOG = LoggerFactory.getLogger(TimeStampTest.class);

    /**
     * test case for TimeStamp.
     */
    @Test
    public final void test() {
        final TimeStamp testTimeStamp1 = new TimeStamp();
        assertNotNull("Value cannot be null", testTimeStamp1);

        final TimeStamp testTimeStamp2 = new TimeStamp();
        assertNotNull("Value cannot be null", testTimeStamp2);
        assertNotSame("Not same", testTimeStamp1, testTimeStamp2);

        LOG.trace("{}", testTimeStamp1);
        LOG.trace("{}", testTimeStamp1.time);
        LOG.trace("{}", testTimeStamp1.toString());
        LOG.trace("{}", testTimeStamp2);
        LOG.trace("{}", testTimeStamp2.time);
        LOG.trace(testTimeStamp2.toString());
        LOG.trace(TimeStamp.TIMESTAMP_FORMAT);
    }
}
