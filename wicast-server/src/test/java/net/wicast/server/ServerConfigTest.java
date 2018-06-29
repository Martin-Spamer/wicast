
package net.wicast.server;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;

import static org.junit.Assume.assumeNotNull;

public class ServerConfigTest {

    /** provide logging. */
    private static final Logger LOG = LoggerFactory.getLogger(ServerConfigTest.class);

    /**
     * Unit Test for server configuration.
     */
    @Test
    public void testServerConfig() {
        final ServerConfig config = new ServerConfig();
        assumeNotNull(config);
        final String string = config.toString();
        assertNotNull(string);
        LOG.info(string);
    }
}
