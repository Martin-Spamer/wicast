package net.wicast;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * MultiCastReceiverTest.
 * 20 Jun 2013
 */
public class MultiCastReceiverTest {

	/**
	 * Test method for
	 * {@link net.wicast.MultiCastReceiverThread.MultiCastReceiver#MultiCastReceiver()}.
	 */
	@Test
	public final void testMultiCastReceiver() {
		final MultiCastReceiver multiCastReceiver = new MultiCastReceiver();
		assertNotNull(multiCastReceiver);
	}

}
