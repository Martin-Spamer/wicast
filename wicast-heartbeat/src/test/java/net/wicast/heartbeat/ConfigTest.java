package net.wicast.heartbeat;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ConfigTest {

	/**
	 * Test method for {@link net.wicast.Config#Config()}.
	 */
	@Test
	public final void testConfig() {
		assertNotNull(new Config());
	}

	/**
	 * Test method for {@link net.wicast.Config#toString()}.
	 */
	@Test
	public final void testToString() {
		final Config testInstance = new Config();
		assertNotNull(testInstance);
		assertNotNull(testInstance.toString());
		testInstance.dumpToLog();
	}

}
