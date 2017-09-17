package net.wicast;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * MultiCastSenderTest.
 * 20 Jun 2013
 */
public class MultiCastSenderTest {

	/**
	 * Test method for
	 * {@link net.wicast.MultiCastSenderThread.MultiCastSender#MultiCastSender()}.
	 */
	@Test
	public final void testMultiCastSender() {
		final MultiCastSender multiCastSender = new MultiCastSender();
		assertNotNull(multiCastSender);
	}

}
