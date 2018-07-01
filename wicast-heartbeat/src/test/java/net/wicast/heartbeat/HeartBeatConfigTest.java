
package net.wicast.heartbeat;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;

import static org.junit.Assume.assumeNotNull;

/**
 * Unit tests for heartbeat configuration class.
 */
public class HeartBeatConfigTest {

    private static final Logger LOG = LoggerFactory.getLogger(HeartBeatConfigTest.class);

    @Test
    public final void testHeartBeatConfig() {
        final HeartBeatConfig config = new HeartBeatConfig();
        assumeNotNull(config);
        final String string = config.toString();
        assertNotNull(string);
        LOG.info(string);
    }

}
