package net.wicast;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * A UnitTest for AbstractConfiguration objects.
 */
public class AbstractConfigTest {

	/**
	* Mock Configuration Class.
	 */
	public class MockConfig extends AbstractConfig {
	}

	/**
	 * Unit Test for test abstract Configuration.
	 */
	@Test
	public void testAbstractConfig() {
		final MockConfig mockConfig = new MockConfig();
		assertNotNull(mockConfig);
		mockConfig.dumpToLog();
	}

}
