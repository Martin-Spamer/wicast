package net.wicast;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.*;

/**
 * A UnitTest for MultiCastReceiver objects.
 */
public class MultiCastReceiverTest {

	private static final Logger LOG = LoggerFactory.getLogger(MultiCastSenderTest.class);

	/**
	 * Unit Test for test multicast receiver.
	 */
	@Test
	public void testMultiCastReceiver() {
		final MultiCastReceiver multiCastReceiver = new MultiCastReceiver();
		assertNotNull(multiCastReceiver);
		MultiCastReceiverTest.LOG.info("{}", multiCastReceiver);
	}

}
