
package net.wicast.server;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Unit Test for WiCast Server.
 */
public class ServerTest {

    /**
     * Unit Test for wicast server.
     */
    @Test
    public void testServer() {
        final Server server = new Server();
        assertNotNull("Value cannot be null", server);
        assertNotNull("Value cannot be null", server.start());
    }

}
