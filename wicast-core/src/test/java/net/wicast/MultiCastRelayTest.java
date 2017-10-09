package net.wicast;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.*;

/**
 * MultiCast Relay Test class.
 */
public class MultiCastRelayTest {

	private static final Logger LOG = LoggerFactory.getLogger(MultiCastRelayTest.class);

	/**
	 * Unit Test to multicast relay.
	 */
	@Test
	public void testMultiCastRelay() {
		final MultiCastRelay multiCastRelay = new MultiCastRelay();
		assertNotNull("Value cannot be null", multiCastRelay);
		MultiCastRelayTest.LOG.info("{}", multiCastRelay);
	}

}
