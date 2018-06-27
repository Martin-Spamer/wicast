
package net.wicast;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * ConfigTest.
 */
public class ConfigTest {
    
    /** The Constant log. */
    private static final Logger log = LoggerFactory.getLogger(ConfigTest.class);

    /**
     * Mock Configuration Class.
     */
    private class MockConfig extends AbstractXmlConfig {
    }

    /**
     * Test method for {@link net.wicast.Config#Config()}.
     * 
     * exception
     *
     * @throws Exception the exception
     */
    @Test
    public void testConfig() throws Exception {
        final AbstractXmlConfig config = new MockConfig();
        assertNotNull("Value cannot be null", config);
        ConfigTest.log.info(config.toString());
        ConfigTest.log.info(config.toXml());
        assertTrue(config.saveAsProperties());
        assertTrue(config.saveAsXml());
        config.dumpToLog();
    }

    /**
     * Test method for {@link net.wicast.Config#toString()}.
     */
    @Test
    public void testToString() {
        final AbstractXmlConfig config = new MockConfig();
        assertNotNull("Value cannot be null", config);
        ConfigTest.log.info(config.toString());
    }
}
