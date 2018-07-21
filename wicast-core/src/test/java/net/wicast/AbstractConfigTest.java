
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
     * The Class TestConfig.
     */
    public class TestConfig extends AbstractConfig {
    }

    /**
     * The Class EmptyConfig.
     */
    public class EmptyConfig extends AbstractConfig {
    }

    /**
     * The Class MissingConfig.
     */
    public class MissingConfig extends AbstractConfig {
    }

    /**
     * Test method for {@link net.wicast.AbstractConfig}.
     */
    @Test
    public final void testConfig() {
        final ConfigInterface config = new TestConfig();
        assertNotNull("Value cannot be null", config);
    }

    /**
     * Unit test to missing config.
     */
    @Test
    public final void testMissingConfig() {
        final ConfigInterface config = new MissingConfig();
        assertNotNull("Value cannot be null", config);
    }

    /**
     * Unit test to empty config.
     */
    @Test
    public final void testEmptyConfig() {
        final EmptyConfig config = new EmptyConfig();
        assertNotNull("Value cannot be null", config);
        assertNull(config.getProperty("key"));
        assertEquals("default", config.getProperty("key", "default"));
    }

    /**
     * Unit test to config set get.
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

}
