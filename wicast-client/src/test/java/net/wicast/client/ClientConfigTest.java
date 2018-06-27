
package net.wicast.client;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;

/**
 * Unit tests for ClientConfig class.
 */
public class ClientConfigTest {

    /** provide logging. */
    private static final Logger LOG  = LoggerFactory.getLogger(ClientConfigTest.class);

    /**
     * Unit Test for client configuration.
     */
    @Test
    public void testClientConfig() {
        final ClientConfig clientConfig = new ClientConfig();
        assertNotNull("Value cannot be null", clientConfig);
    }

}
