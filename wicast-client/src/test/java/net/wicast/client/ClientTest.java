
package net.wicast.client;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Unit Test for WiCast Client.
 */
public class ClientTest {

    /**
     * Unit Test to wicast client.
     */
    @Test
    public void testClient() {
        final Client client = new Client();
        assertNotNull("Value cannot be null", client);
        assertNotNull("Value cannot be null", client.start());
        assertNotNull("Value cannot be null", client.stop());
    }

}
