
package net.wicast.client;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * Unit test for client class.
 */
public class ClientTest {

	/**
	 * Unit Test to client class.
	 */
	@Test
	public void testClient() {
		final Client client = new Client();
		assertNotNull(client);
	}

}
