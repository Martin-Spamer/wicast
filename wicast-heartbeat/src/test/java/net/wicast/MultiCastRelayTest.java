package net.wicast;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * MultiCastRelayTest.
 * 20 Jun 2013
 */
public class MultiCastRelayTest {

	/**
	 * Test method for {@link net.wicast.relay.MultiCastRelay#MultiCastRelay()}.
	 */
	@Test
	public final void testMultiCastRelay() {
		final MultiCastRelay multiCastRelay = new MultiCastRelay();
		assertNotNull("Value cannot be null",multiCastRelay);
	}

}
