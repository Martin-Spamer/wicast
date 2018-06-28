
package net.wicast.heartbeat;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * HeartBeatTest.
 */
@Ignore
public class HeartBeatTest {

    private static final Logger LOG = LoggerFactory.getLogger(HeartBeatTest.class);
    private static final String LOOPBACK = "127.0.0.1";
    // 224.0.0.1 is local subnet only, closest multicast equivalent to 127.0.0.1
    private static final String VALID_ADDRESS = "224.0.0.1";
    private static final int PORT = 1;

    /**
     * Test method for
     * {@link net.wicast.heartbeat.HeartBeat#HeartBeat(java.lang.String, int)}.
     */
    @Ignore
    @Test
    public final void testHeartBeatBadAddress() {
        // HeartBeat testInstance = new HeartBeat();
        try {
            final HeartBeat heartBeat = new HeartBeat();
            assertNotNull("Value cannot be null", heartBeat);
            heartBeat.beat();
        } catch (final HeartBeatException heartBeatException) {
            assertTrue(heartBeatException.getCause() instanceof java.net.UnknownHostException);
            LOG.debug("Expected: {}", heartBeatException.getLocalizedMessage());
            // expected error for test is HeartBeatException - ignore.
        } catch (final Exception exception) {
            fail("implementation error unexpected exception " + exception.getLocalizedMessage());
        }
    }

    /**
     * Test method for
     * {@link net.wicast.heartbeat.HeartBeat#HeartBeat(InetAddress, int)}.
     */
    @Test
    public final void testHeartBeatBadGroupAddress() {
        try {
            final InetAddress badGroupAddress = InetAddress.getByName(HeartBeatTest.LOOPBACK);
            final HeartBeat heartBeat = new HeartBeat(badGroupAddress, HeartBeatTest.PORT);
            assertNotNull("Value cannot be null", heartBeat);
            heartBeat.beat();
        } catch (final HeartBeatException heartBeatException) {
            assertTrue(heartBeatException.getLocalizedMessage().contains("Not a multicast address"));
            LOG.debug("Expected: {}", heartBeatException.getLocalizedMessage());
            // expected error for test is HeartBeatException - ignore.
        } catch (final Exception exception) {
            fail("implementation error unexpected exception" + exception.getLocalizedMessage());
        }
    }

    /**
     * Test method for
     * {@link net.wicast.heartbeat.HeartBeat#HeartBeat(java.lang.String, int)}.
     */
    @Test
    public final void testHeartBeatBadIP() {
        // HeartBeat testInstance = new HeartBeat();
        try {
            final AbstractHeartBeat testInstance = new HeartBeat("xx.xx.xx.xx", HeartBeatTest.PORT);
            assertNotNull("Value cannot be null", testInstance);
        } catch (final HeartBeatException heartBeatException) {
            assertTrue(heartBeatException.getCause() instanceof java.net.UnknownHostException);
            LOG.debug("Expected: {}", heartBeatException.getLocalizedMessage());
            // expected error for test is HeartBeatException - ignore.
        } catch (final Exception exception) {
            fail("implementation error unexpected exception" + exception.getLocalizedMessage());
        }
    }

    /**
     * Test method for
     * {@link net.wicast.heartbeat.HeartBeat#HeartBeat(java.lang.String, int)}.
     */
    @Test
    public final void testHeartBeatEmptyGroupAddressString() {
        try {
            // HeartBeat testInstance = new HeartBeat();
            final AbstractHeartBeat testInstance = new HeartBeat("", HeartBeatTest.PORT);
            assertNull(testInstance);
        } catch (final HeartBeatException heartBeatException) {
            assertTrue(heartBeatException.getLocalizedMessage().contains("Not a multicast address"));
            LOG.debug("Expected: {}", heartBeatException.getLocalizedMessage());
            // expected error for test is HeartBeatException - ignore.
        } catch (final Exception exception) {
            fail("implementation error unexpected exception" + exception.getLocalizedMessage());
        }
    }

    /**
     * Test method for
     * {@link net.wicast.heartbeat.HeartBeat#HeartBeat(java.lang.String, int)}.
     */
    @Test
    public final void testHeartBeatGoodAddress() {
        // HeartBeat testInstance = new HeartBeat();
        try {
            final AbstractHeartBeat testInstance = new HeartBeat("224.0.0.1", HeartBeatTest.PORT);
            assertNotNull(testInstance);
        } catch (final HeartBeatException heartBeatException) {
            assertTrue(heartBeatException.getLocalizedMessage().contains("Not a multicast address"));
            LOG.debug("Expected: {}", heartBeatException.getLocalizedMessage());
            // expected error for test is HeartBeatException - ignore.
        } catch (final Exception exception) {
            fail("implementation error unexpected exception" + exception.getLocalizedMessage());
        }
    }

    /**
     * Test method for
     * {@link net.wicast.heartbeat.HeartBeat#HeartBeat(java.lang.String, int)}.
     */
    @Test
    public final void testHeartBeatGoodGroupString() {
        try {
            final AbstractHeartBeat testInstance = new HeartBeat(HeartBeatTest.VALID_ADDRESS, HeartBeatTest.PORT);
            assertNotNull("Value cannot be null", testInstance);
        } catch (final HeartBeatException heartBeatException) {
            fail("unexpected error " + heartBeatException.getLocalizedMessage());
        }
    }

    /**
     * Test method for
     * {@link net.wicast.heartbeat.HeartBeat#HeartBeat(java.lang.String, int)}.
     */
    @Test
    public final void testHeartBeatGoogGroupIP() {
        try {
            final InetAddress goodGroupAddress = InetAddress.getByName(HeartBeatTest.VALID_ADDRESS);
            final AbstractHeartBeat testInstance = new HeartBeat(goodGroupAddress, HeartBeatTest.PORT);
            assertNotNull("Value cannot be null", testInstance);
        } catch (final HeartBeatException heartBeatException) {
            fail("unexpected error " + heartBeatException.getLocalizedMessage());
        } catch (final UnknownHostException unknownHostException) {
            fail("unexpected error " + unknownHostException.getLocalizedMessage());
        }
    }

    /**
     * Test method for
     * {@link net.wicast.heartbeat.HeartBeat#HeartBeat(InetAddress, int)}.
     */
    @Test
    public final void testHeartBeatInetAddressInt() {
        try {
            final InetAddress validGroupAddress = InetAddress.getByName(HeartBeatTest.VALID_ADDRESS);
            final AbstractHeartBeat testInstance = new HeartBeat(validGroupAddress, HeartBeatTest.PORT);
            assertNotNull("Value cannot be null", testInstance);
        } catch (final HeartBeatException heartBeatException) {
            assertTrue(heartBeatException.getLocalizedMessage().contains("Not a multicast address"));
            LOG.debug("Expected: {}", heartBeatException.getLocalizedMessage());
            // expected error for test is HeartBeatException - ignore.
        } catch (final Exception exception) {
            fail("implementation error unexpected exception" + exception.getLocalizedMessage());
        }
    }

    /**
     * Test method for
     * {@link net.wicast.heartbeat.AbstractHeartBeat#AbstractHeartBeat(InetAddress, int)}.
     */
    @Test
    public final void testHeartBeatNullGroupAddress() {
        try {
            final InetAddress nullGroupAddress = null;
            final AbstractHeartBeat testInstance = new HeartBeat(nullGroupAddress, HeartBeatTest.PORT);
            assertNotNull("Value cannot be null", testInstance);
        } catch (final NullPointerException nullPointerException) {
            // expected error for test is HeartBeatException - ignore.
        } catch (final HeartBeatException heartBeatException) {
            fail("unexpected error " + heartBeatException.getLocalizedMessage());
        }
    }

    /**
     * Test method for
     * {@link net.wicast.heartbeat.HeartBeat#HeartBeat(java.lang.String, int)}.
     */
    @Test
    public final void testHeartBeatNullGroupAddressString() {
        try {
            // HeartBeat testInstance = new HeartBeat();
            final String nullGroupAddressString = null;
            final AbstractHeartBeat testInstance = new HeartBeat(nullGroupAddressString, HeartBeatTest.PORT);
            assertNull(testInstance);
        } catch (final HeartBeatException heartBeatException) {
            assertTrue(heartBeatException.getLocalizedMessage().contains("Not a multicast address"));
            LOG.debug("Expected: {}", heartBeatException.getLocalizedMessage());
            // expected error for test is HeartBeatException - ignore.
        } catch (final Exception exception) {
            fail("implementation error unexpected exception" + exception.getLocalizedMessage());
        }
    }
}
