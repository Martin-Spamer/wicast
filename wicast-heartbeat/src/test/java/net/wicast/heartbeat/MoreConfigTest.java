
package net.wicast.heartbeat;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;

/**
 * Unit test for the MoreConfig class.
 */
public class MoreConfigTest {

    private static final Logger LOG = LoggerFactory.getLogger(MoreConfigTest.class);

    /**
     * Safely recover from failure to load none existing configuration file.
     */
    @Test
    public void testMissingHeartBeatConfig() {
        LOG.debug("--- test0 : named configuration file does not exist.");
        HeartBeatConfig config = new HeartBeatConfig("missing.xml");
        assertNotNull("Value cannot be null", config);
        LOG.debug(config.toString());
    }

    /**
     * test load default configuration file.
     * <code>
     * 	Config config = new Config();
     *  LOG.debug(config.toString());
     * </code>
     */
    @Test
    public void testHeartBeatConfig() {
        LOG.debug("--- test1 : load default configuration file.");
        final HeartBeatConfig config = new HeartBeatConfig();
        assertNotNull("Value cannot be null", config);
        LOG.debug(config.toString());
    }

    /**
     * test load a named configuration file.
     * <code>
     * 	Config config = new Config("Application.xml");
     *  LOG.debug( config.toString() ) ;
     *  </code>
     */
    @Test
    public void testHeartBeatConfigString() {
        LOG.debug("--- test2 : test load a named configuration file.");
        final HeartBeatConfig config = new HeartBeatConfig("Application.xml");
        assertNotNull("Value cannot be null", config);
        LOG.debug("config = {}", config.toString());
    }
}
