
package net.wicast.heartbeat;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * Config Test class.
 */
public class ConfigTest {

	/**
	 * Test method for {@link net.wicast.HeartBeatConfig#Config()}.
	 */
	@Test
	public final void testConfig() {
		assertNotNull(new HeartBeatConfig());
	}

	/**
	 * Test method for {@link net.wicast.HeartBeatConfig#toString()}.
	 */
	@Test
	public final void testToString() {
		final HeartBeatConfig testInstance = new HeartBeatConfig();
		assertNotNull(testInstance);
		assertNotNull(testInstance.toString());
		testInstance.dumpToLog();
	}

}
