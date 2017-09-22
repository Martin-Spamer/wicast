package net.wicast.client;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.*;

public class ClientConfigTest {

	private static final Logger LOG = LoggerFactory.getLogger(ClientConfigTest.class);

	/**
	 * Unit Test for client configuration.
	 */
	@Test
	public void testClientConfig() {
		final ClientConfig clientConfig = new ClientConfig();
		assertNotNull(clientConfig);
	}

}
