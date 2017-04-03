package net.wicast;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * A UnitTest for AbstractConfig objects.
 */
public class AbstractConfigTest {

    /**
     * The MockConfig Class.
     */
    public class MockConfig extends AbstractConfig {
    }

    /**
     * Unit Test for test abstract config.
     */
    @Test
    public void testAbstractConfig() {
        final MockConfig mockConfig = new MockConfig();
        assertNotNull(mockConfig);
        mockConfig.dumpToLog();
    }

}
