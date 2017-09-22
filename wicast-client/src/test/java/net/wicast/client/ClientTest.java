
package net.wicast.client;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

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
		assertNotNull(client);
		assertNotNull(client.start());
	}

}
