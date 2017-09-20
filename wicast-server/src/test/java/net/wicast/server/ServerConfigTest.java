
package net.wicast.server;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * A UnitTest for ServerConfiguration objects.
 */
public class ServerConfigTest {

	/**
	 * Test.
	 */
	@Test
	public void testServerConfig() {
		final WicastServerConfig serverConfig = new WicastServerConfig();
		assertNotNull(serverConfig);

	}

}
