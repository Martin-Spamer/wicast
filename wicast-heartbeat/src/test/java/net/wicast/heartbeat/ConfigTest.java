
package net.wicast.heartbeat;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Config Test class.
 */
public class ConfigTest {

    /**
     * Test method for {@link net.wicast.HeartBeatConfig#Config()}.
     */
    @Test
    public final void testConfig() {
        assertNotNull("Value cannot be null", new HeartBeatConfig());
    }

    /**
     * Test method for {@link net.wicast.HeartBeatConfig#toString()}.
     */
    @Test
    public final void testToString() {
        final HeartBeatConfig testInstance = new HeartBeatConfig();
        assertNotNull("Value cannot be null", testInstance);
        assertNotNull("Value cannot be null", testInstance.toString());
        testInstance.dumpToLog();
    }

}
