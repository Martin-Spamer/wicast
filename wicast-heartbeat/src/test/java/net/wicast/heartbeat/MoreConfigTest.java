package net.wicast.heartbeat;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Config class
 *
 * @author
 * @version 0.1
 */
public class MoreConfigTest {

    private static final Logger log = LoggerFactory.getLogger(MoreConfigTest.class);

    /**
     * fail to load none existing configuration file. [code] [/code]
     */
    @Test
    public void test0() {
        try {
            MoreConfigTest.log.debug("--- test0 : named configuration file does not exist.");
            final Config config = new Config("missing.xml");
            MoreConfigTest.log.debug(config.toString());
        } catch (final java.lang.Exception exception) {
            MoreConfigTest.log.debug(exception.toString());
        }
    }

    /**
     * test load default configuration file. [code] Config config =
     * new Config() ;
     * log.debug( config.toString() ) ; [/code]
     */
    @Test
    public void test1() {
        try {
            MoreConfigTest.log.debug("--- test1 : load default configuration file.");
            final Config config = new Config();
            MoreConfigTest.log.debug(config.toString());
        } catch (final java.lang.Exception exception) {
            MoreConfigTest.log.debug(exception.toString());
        }
    }

    /**
     * test load a named configuration file. [code] Config config =
     * new Config( "Application.xml"
     * ) ; log.debug( config.toString() ) ; [/code]
     */
    @Test
    public void test2() {
        try {
            MoreConfigTest.log.debug("--- test2 : test load a named configuration file.");
            final Config config = new Config("Application.xml");
            MoreConfigTest.log.debug("config" + config.toString());
        } catch (final java.lang.Exception exception) {
            MoreConfigTest.log.debug(exception.toString());
        }
    }
}
