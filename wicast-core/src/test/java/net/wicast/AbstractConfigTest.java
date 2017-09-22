
package net.wicast;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.*;

/**
 * A UnitTest for AbstractConfiguration objects.
 */
public class AbstractConfigTest {

	private static final Logger LOG = LoggerFactory.getLogger(AbstractConfigTest.class);

	/**
	 * Mock Configuration.
	 */
	public class MockConfig extends AbstractXmlConfig {
	}

	/**
	 * Missing Configuration.
	 */
	public class MissingConfig extends AbstractXmlConfig {
	}

	/**
	 * Invalid Configuration.
	 */
	public class InvalidConfig extends AbstractXmlConfig {
	}

	/**
	 * Unit Test for test abstract Configuration.
	 */
	@Test
	public void testAbstractConfig() {
		AbstractConfigTest.LOG.info("testAbstractConfig");
		final AbstractXmlConfig invalidConfig = new MockConfig();
		assertNotNull(invalidConfig);
		invalidConfig.dumpToLog();
	}

	@Test
	public void testMockConfig() {
		AbstractConfigTest.LOG.info("testAbstractConfig");
		final AbstractXmlConfig invalidConfig = new MockConfig();
		assertNotNull(invalidConfig);
		invalidConfig.getProperty("key");
		invalidConfig.getProperty("key", "defaultValue");
	}

	@Test
	public void testMissingConfig() {
		AbstractConfigTest.LOG.info("testMissingConfig");
		final AbstractXmlConfig missingConfig = new MissingConfig();
		assertNotNull(missingConfig);
		missingConfig.dumpToLog();
	}

	@Test
	public void testInvalidConfig() {
		AbstractConfigTest.LOG.info("testInvalidConfig");
		final AbstractXmlConfig invalidConfig = new InvalidConfig();
		assertNotNull(invalidConfig);
		invalidConfig.dumpToLog();
	}
}
