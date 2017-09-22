
package net.wicast.server;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.*;

/**
 * Server Configuration Unit Tests.
 */
public class ServerConfigTest {

	private static final Logger LOG = LoggerFactory.getLogger(ServerConfigTest.class);

	/**
	 * Unit Test for server configuration.
	 */
	@Test
	public void testServerConfig() {
		final ServerConfig serverConfig = new ServerConfig();
		assertNotNull(serverConfig);
	}

}
