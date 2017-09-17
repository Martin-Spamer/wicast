
package net.wicast.server;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * A UnitTest for Server objects.
 */
public class ServerTest {

	/**
	 * Unit Test for test server.
	 */
	@Test
	public void testServer() {
		final Server server = new Server();
		assertNotNull(server);

	}

}
