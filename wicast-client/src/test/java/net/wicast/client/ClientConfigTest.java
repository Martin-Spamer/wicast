
package net.wicast.client;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;

import static org.junit.Assume.assumeNotNull;

/**
 * Unit test class for ClientConfig.
 */
public class ClientConfigTest {

    /** provide logging. */
    private static final Logger LOG = LoggerFactory.getLogger(ClientConfigTest.class);

    /**
     * Unit Test for client configuration.
     */
    @Test
    public void testClientConfig() {
        final ClientConfig config = new ClientConfig();
        assumeNotNull(config);
        final String string = config.toString();
        assertNotNull(string);
        LOG.info(string);
    }

}
