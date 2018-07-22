
package net.wicast;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Unit tests for the abstract configuration class.
 */
public class AbstractConfigTest {

    /** provides logging. */
    private static final Logger LOG = LoggerFactory.getLogger(AbstractConfigTest.class);

    /**
     * TestConfig class.
     */
    public class TestConfig extends AbstractConfig {
        private TestConfig() {
            super();
        }

        private TestConfig(final String configFilename) {
            super(configFilename);
        }
    }

    /**
     * EmptyConfig class.
     */
    public class EmptyConfig extends AbstractConfig {
    }

    /**
     * MissingConfig class.
     */
    public class MissingConfig extends AbstractConfig {
    }

    /**
     * Unit test a configuration.
     */
    @Test
    public final void testConfig() {
        final ConfigInterface config = new TestConfig();
        assertNotNull("Value cannot be null", config);
    }

    /**
     * Unit test to configuration with filename as String.
     */
    @Test
    public final void testConfigString() {
        final ConfigInterface config = new TestConfig("Configuration");
        assertNotNull("Value cannot be null", config);
    }

    /**
     * Unit test to configuration with filename as String.
     */
    @Test
    public final void testConfigMissing() {
        final ConfigInterface config = new TestConfig("Missing");
        assertNotNull("Value cannot be null", config);
    }

    /**
     * Unit test configuration set get.
     */
    @Test
    public final void testConfigSetGet() {
        final ConfigInterface config = new TestConfig();
        assertNotNull("Value cannot be null", config);
        assertEquals("value", config.getProperty("key"));
        assertEquals("default", config.getProperty("missing-key", "default"));
        assertNotNull("Value cannot be null", config.toString());
        LOG.debug("config = {}", config);
    }

    /**
     * Unit test missing configuration.
     */
    @Test
    public final void testMissingConfig() {
        final ConfigInterface config = new MissingConfig();
        assertNotNull("Value cannot be null", config);
    }

    /**
     * Unit test empty configuration.
     */
    @Test
    public final void testEmptyConfig() {
        final EmptyConfig config = new EmptyConfig();
        assertNotNull("Value cannot be null", config);
        assertNull(config.getProperty("key"));
        assertEquals("default", config.getProperty("key", "default"));
    }

}
