
package net.wicast;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;

/**
 * A UnitTest for AbstractConfiguration objects.
 */
public class AbstractConfigTest {

    /** provide logging. */
    private static final Logger LOG = LoggerFactory.getLogger(AbstractConfigTest.class);

    /**
     * Mock Configuration.
     */
    public class MockConfig extends AbstractXmlConfig {
    }

    /**
     * Missing Configuration.
     */
    public class MissingConfig extends AbstractXmlConfig {
    }

    /**
     * Invalid Configuration.
     */
    public class InvalidConfig extends AbstractXmlConfig {
    }

    /**
     * Unit Test for test abstract Configuration.
     */
    @Test
    public void testAbstractConfig() {
        LOG.info("testAbstractConfig");
        final AbstractXmlConfig invalidConfig = new MockConfig();
        assertNotNull("Value cannot be null", invalidConfig);
        invalidConfig.dumpToLog();
    }

    /**
     * Unit test to mock config.
     */
    @Test
    public void testMockConfig() {
        LOG.info("testAbstractConfig");
        final AbstractXmlConfig invalidConfig = new MockConfig();
        assertNotNull("Value cannot be null", invalidConfig);
        invalidConfig.getProperty("key");
        invalidConfig.getProperty("key", "defaultValue");
    }

    /**
     * Unit test to missing config.
     */
    @Test
    public void testMissingConfig() {
        LOG.info("testMissingConfig");
        final AbstractXmlConfig missingConfig = new MissingConfig();
        assertNotNull("Value cannot be null", missingConfig);
        missingConfig.dumpToLog();
    }

    /**
     * Unit test to invalid config.
     */
    @Test
    public void testInvalidConfig() {
        LOG.info("testInvalidConfig");
        final AbstractXmlConfig invalidConfig = new InvalidConfig();
        assertNotNull("Value cannot be null", invalidConfig);
        invalidConfig.dumpToLog();
    }
}
