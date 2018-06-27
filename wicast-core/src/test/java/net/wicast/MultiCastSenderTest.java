
package net.wicast;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * MultiCast Sender Test class.
 */
public class MultiCastSenderTest {

    /** provide logging. */
    private static final Logger LOG = LoggerFactory.getLogger(MultiCastSenderTest.class);

    /**
     * Unit Test to multicast sender.
     */
    @Test
    public void testSendByDatagramSocket() {
        final MultiCastSender multiCastSender = new MultiCastSender();
        assertNotNull("Value cannot be null", multiCastSender);
        final boolean sendByDatagramSocket = multiCastSender.sendByDatagramSocket("228.1.2.3",
                1234,
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
        assertNotNull("Value cannot be null", multiCastSender);
        final boolean sendByMulticastSocket = multiCastSender.sendByMulticastSocket("228.1.2.3",
                1234,
                "<WICAST type=2/>".getBytes());
        assertTrue(sendByMulticastSocket);
        LOG.debug("{}", sendByMulticastSocket);
    }
}
