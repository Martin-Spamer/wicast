package net.wicast;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.*;

/**
 * ConfigTest.
 */
public class ConfigTest {
	private static final Logger log = LoggerFactory.getLogger(ConfigTest.class);

	/**
	 * Mock Configuration Class.
	 */
	private class MockConfig extends AbstractConfig {
	}

	/**
	 * Test method for {@link net.wicast.Config#Config()}.
	 *
	* exception
	 */
	@Test
	public void testConfig() throws Exception {
		final AbstractConfig config = new MockConfig();
		assertNotNull(config);
		log.info(config.toString());
		log.info(config.xmlFoo());
		assertTrue(config.saveAsProperties());
		assertTrue(config.saveAsXml());
		config.dumpToLog();
	}

	/**
	 * Test method for {@link net.wicast.Config#toString()}.
	 */
	@Test
	public void testToString() {
		final AbstractConfig config = new MockConfig();
		assertNotNull(config);
		log.info(config.toString());
	}
}
