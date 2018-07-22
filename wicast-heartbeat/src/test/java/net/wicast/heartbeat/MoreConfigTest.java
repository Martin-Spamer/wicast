
package net.wicast.heartbeat;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Unit test for the MoreConfig class.
 */
public class MoreConfigTest {

    /**
     * test load default configuration file.
     * <code>
     * 	Config config = new Config();
     *  LOG.debug(config.toString());
     * </code>
     */
    @Test
    public void testHeartBeatConfig() {
        final HeartBeatConfig config = new HeartBeatConfig();
        assertNotNull("Value cannot be null", config);
    }

}
