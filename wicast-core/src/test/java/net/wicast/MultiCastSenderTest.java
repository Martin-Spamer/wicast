
package net.wicast;

import org.junit.Test;
import org.slf4j.*;

/**
 * MultiCast Sender Test class.
 */
public class MultiCastSenderTest {

	private static final Logger LOG = LoggerFactory.getLogger(MultiCastSenderTest.class);

	/**
	 * Unit Test to multi cast sender.
	 */
	@Test
	public void testMultiCastSender() {
		final MultiCastSender multiCastSender = new MultiCastSender();
		LOG.debug("{}", multiCastSender.sendByDatagramSocket("228.1.2.3", 1234, "<WICAST type=1/>".getBytes()));
		LOG.debug("{}", multiCastSender.sendByMulticastSocket("228.1.2.3", 1234, "<WICAST type=2/>".getBytes()));
	}

}
