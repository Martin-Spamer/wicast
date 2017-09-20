
package net.wicast;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.*;

/**
 * MultiCast Sender Test class.
 */
public class MultiCastSenderTest {

	private static final Logger LOG = LoggerFactory.getLogger(MultiCastSenderTest.class);

	/**
	 * Unit Test to multicast sender.
	 */
	@Test
	public void testSendByDatagramSocket() {
		final MultiCastSender multiCastSender = new MultiCastSender();
		assertNotNull(multiCastSender);
		final boolean sendByDatagramSocket = multiCastSender.sendByDatagramSocket("228.1.2.3", 1234,
		        "<WICAST type=1/>".getBytes());
		assertTrue(sendByDatagramSocket);
		LOG.debug("{}", sendByDatagramSocket);
	}

	/**
	 * Unit Test to multi cast sender.
	 */
	@Test
	public void testSendByMulticastSocket() {
		final MultiCastSender multiCastSender = new MultiCastSender();
		assertNotNull(multiCastSender);
		final boolean sendByMulticastSocket = multiCastSender.sendByMulticastSocket("228.1.2.3", 1234,
		        "<WICAST type=2/>".getBytes());
		assertTrue(sendByMulticastSocket);
		LOG.debug("{}", sendByMulticastSocket);
	}
}
