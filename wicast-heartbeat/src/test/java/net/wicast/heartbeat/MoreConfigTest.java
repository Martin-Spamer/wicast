
package net.wicast.heartbeat;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;

import net.wicast.AbstractConfig;

/**
 * class MoreConfigTest.
 */
public class MoreConfigTest {

    private static final Logger LOG = LoggerFactory.getLogger(MoreConfigTest.class);

    /**
     * fail to load none existing configuration file. <code> </code>
     */
    @Test
    public void test0() {
        try {
            LOG.debug("--- test0 : named configuration file does not exist.");
            final AbstractConfig config = new HeartBeatConfig("missing.xml");
            assertNotNull("Value cannot be null", config);
            LOG.debug(config.toString());
        } catch (final Exception e) {
            LOG.error(e.getLocalizedMessage(), e);
        }
    }

    /**
     * test load default configuration file.
     * <code>
     * 	Config config = new Config();
     *  LOG.debug(config.toString());
     * </code>
     */
    @Test
    public void test1() {
        try {
            LOG.debug("--- test1 : load default configuration file.");
            final HeartBeatConfig config = new HeartBeatConfig();
            assertNotNull("Value cannot be null", config);
            LOG.debug(config.toString());
        } catch (final Exception exception) {
            LOG.debug(exception.toString());
        }
    }

    /**
     * test load a named configuration file.
     * <code>
     * 	Config config = new Config("Application.xml");
     *  LOG.debug( config.toString() ) ;
     *  </code>
     */
    @Test
    public void test2() {
        try {
            LOG.debug("--- test2 : test load a named configuration file.");
            final HeartBeatConfig config = new HeartBeatConfig("Application.xml");
            assertNotNull("Value cannot be null", config);
            LOG.debug("config = {}", config.toString());
        } catch (final Exception exception) {
            LOG.debug(exception.toString());
        }
    }
}
