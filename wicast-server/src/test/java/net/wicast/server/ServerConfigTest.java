
package net.wicast.server;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;

/**
 * Server Configuration Unit Tests.
 */
public class ServerConfigTest {

    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(ServerConfigTest.class);

    /**
     * Unit Test for server configuration.
     */
    @Test
    public void testServerConfig() {
        final ServerConfig serverConfig = new ServerConfig();
        assertNotNull("Value cannot be null", serverConfig);
    }

}
