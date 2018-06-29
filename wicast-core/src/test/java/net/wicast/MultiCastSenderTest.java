
package net.wicast;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;

import static org.junit.Assume.assumeNotNull;

/**
 * MultiCast Sender Test class.
 */
public class MultiCastSenderTest {

    /** provide logging. */
    private static final Logger LOG = LoggerFactory.getLogger(MultiCastSenderTest.class);

    /**
     * Unit test to multi cast receiver.
     */
    @Test
    public void testMultiCastReceiver() {
        final MultiCastSender multiCastSender = new MultiCastSender();
        assumeNotNull(multiCastSender);
        final String string = multiCastSender.toString();
        LOG.info(string);
    }

    /**
     * Unit Test to multicast sender.
     */
    @Test
    public void testSendByDatagramSocket() {
        final MultiCastSender multiCastSender = new MultiCastSender();
        assumeNotNull(multiCastSender);
        final boolean sendByDatagramSocket = multiCastSender.sendByDatagramSocket("228.1.2.3",
                1234,
                "<WICAST type=1/>".getBytes());
        assertTrue(sendByDatagramSocket);
        LOG.info("multiCastSender = {}", multiCastSender);
        LOG.info("sendByDatagramSocket = {}", sendByDatagramSocket);
    }

    /**
     * Unit Test to multi cast sender.
     */
    @Test
    public void testSendByMulticastSocket() {
        final MultiCastSender multiCastSender = new MultiCastSender();
        assumeNotNull(multiCastSender);
        final boolean sendByMulticastSocket = multiCastSender.sendByMulticastSocket("228.1.2.3",
                1234,
                "<WICAST type=2/>".getBytes());
        assertTrue(sendByMulticastSocket);
        LOG.debug("multiCastSender = {}", multiCastSender);
        LOG.debug("sendByMulticastSocket = {}", sendByMulticastSocket);
    }

}
