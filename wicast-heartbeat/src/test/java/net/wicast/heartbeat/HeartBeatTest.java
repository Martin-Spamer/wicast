/**
 * This file is part of Automated Testing Framework for Java (atf4j).
 *
 * Atf4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Atf4j is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with atf4j.  If not, see http://www.gnu.org/licenses/.
 */
package net.wicast.heartbeat;

import static org.junit.Assert.fail;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HeartBeatTest.
 *
 * @author <author@wicast.net>
 */
public class HeartBeatTest {

    private static final Logger log = LoggerFactory.getLogger(HeartBeatTest.class);
    /** The Constant portNo. */
    private static final int portNo = 1;

    /** The Constant invalidGroupAddressString. */
    private static final String invalidGroupAddressString = "127.0.0.1";
    // 224.0.0.1 is local subnet only, closest multicast equivalent to 127.0.0.1
    /** The Constant validGroupAddressString. */
    private static final String validGroupAddressString = "224.0.0.1";

    /**
     * Test method for
     * {@link net.wicast.heartbeat.HeartBeat#HeartBeat(java.lang.String, int)}.
     */
    @Test
    public final void testHeartBeatNullGroupAddressString() {
        try {
            // HeartBeat testInstance = new HeartBeat();
            final String nullGroupAddressString = null;
            final HeartBeat testInstance = new HeartBeat(nullGroupAddressString, HeartBeatTest.portNo);
            org.junit.Assert.assertNull(testInstance);
            fail("implementation error");
        } catch (final HeartBeatException heartBeatException) {
            org.junit.Assert.assertTrue(heartBeatException.getLocalizedMessage().contains("Not a multicast address"));
            log.debug("Expected:" + heartBeatException.getLocalizedMessage());
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
            final HeartBeat testInstance = new HeartBeat("", HeartBeatTest.portNo);
            org.junit.Assert.assertNull(testInstance);
            fail("implementation error");
        } catch (final HeartBeatException heartBeatException) {
            org.junit.Assert.assertTrue(heartBeatException.getLocalizedMessage().contains("Not a multicast address"));
            log.debug("Expected:" + heartBeatException.getLocalizedMessage());
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
    public final void testHeartBeatBadAddress() {
        // HeartBeat testInstance = new HeartBeat();
        try {
            final HeartBeat testInstance = new HeartBeat("net.wicast", HeartBeatTest.portNo);
            org.junit.Assert.assertNull(testInstance);
            fail("implementation error");
        } catch (final HeartBeatException heartBeatException) {
            org.junit.Assert.assertTrue(heartBeatException.getCause() instanceof java.net.UnknownHostException);
            log.debug("Expected:" + heartBeatException.getLocalizedMessage());
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
            final HeartBeat testInstance = new HeartBeat("wicast.net", HeartBeatTest.portNo);
            org.junit.Assert.assertNull(testInstance);
            fail("implementation error");
        } catch (final HeartBeatException heartBeatException) {
            org.junit.Assert.assertTrue(heartBeatException.getLocalizedMessage().contains("Not a multicast address"));
            log.debug("Expected:" + heartBeatException.getLocalizedMessage());
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
            final HeartBeat testInstance = new HeartBeat("xx.xx.xx.xx", HeartBeatTest.portNo);
            org.junit.Assert.assertNotNull(testInstance);
            fail("implementation error");
        } catch (final HeartBeatException heartBeatException) {
            org.junit.Assert.assertTrue(heartBeatException.getCause() instanceof java.net.UnknownHostException);
            log.debug("Expected:" + heartBeatException.getLocalizedMessage());
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
    public final void testHeartBeatGoogGroupIP() {
        try {
            final InetAddress goodGroupAddress = InetAddress.getByName(HeartBeatTest.validGroupAddressString);
            final HeartBeat testInstance = new HeartBeat(goodGroupAddress, HeartBeatTest.portNo);
            org.junit.Assert.assertNotNull(testInstance);
            execute(testInstance);
        } catch (final HeartBeatException heartBeatException) {
            fail("unexpected error " + heartBeatException.getLocalizedMessage());
        } catch (final UnknownHostException unknownHostException) {
            fail("unexpected error " + unknownHostException.getLocalizedMessage());
        }
    }

    /**
     * Test method for
     * {@link net.wicast.heartbeat.HeartBeat#HeartBeat(java.lang.String, int)}.
     */
    @Test
    public final void testHeartBeatGoodGroupString() {
        try {
            final HeartBeat testInstance = new HeartBeat(HeartBeatTest.validGroupAddressString, HeartBeatTest.portNo);
            org.junit.Assert.assertNotNull(testInstance);
            execute(testInstance);
        } catch (final HeartBeatException heartBeatException) {
            fail("unexpected error " + heartBeatException.getLocalizedMessage());
        }
    }

    /**
     * Test method for
     * {@link net.wicast.heartbeat.AbstractHeartBeat#AbstractHeartBeat(java.net.InetAddress, int)}.
     */
    @Test
    public final void testHeartBeatNullGroupAddress() {
        try {
            final java.net.InetAddress nullGroupAddress = null;
            final HeartBeat testInstance = new HeartBeat(nullGroupAddress, HeartBeatTest.portNo);
            org.junit.Assert.assertNotNull(testInstance);
            execute(testInstance);
        } catch (final NullPointerException nullPointerException) {
            // expected error for test is HeartBeatException - ignore.
        } catch (final HeartBeatException heartBeatException) {
            fail("unexpected error " + heartBeatException.getLocalizedMessage());
        }
    }

    /**
     * Test method for
     * {@link net.wicast.heartbeat.HeartBeat#HeartBeat(java.net.InetAddress, int)}.
     */
    @Test
    public final void testHeartBeatBadGroupAddress() {
        try {
            final java.net.InetAddress badGroupAddress = InetAddress.getByName(HeartBeatTest.invalidGroupAddressString);
            final HeartBeat testInstance = new HeartBeat(badGroupAddress, HeartBeatTest.portNo);
            org.junit.Assert.assertNotNull(testInstance);
            execute(testInstance);
        } catch (final HeartBeatException heartBeatException) {
            org.junit.Assert.assertTrue(heartBeatException.getLocalizedMessage().contains("Not a multicast address"));
            log.debug("Expected:" + heartBeatException.getLocalizedMessage());
            // expected error for test is HeartBeatException - ignore.
        } catch (final Exception exception) {
            fail("implementation error unexpected exception" + exception.getLocalizedMessage());
        }
    }

    /**
     * Test method for
     * {@link net.wicast.heartbeat.HeartBeat#HeartBeat(java.net.InetAddress, int)}.
     */
    @Test
    public final void testHeartBeatInetAddressInt() {
        try {
            final InetAddress validGroupAddress = InetAddress.getByName(validGroupAddressString);
            final HeartBeat testInstance = new HeartBeat(validGroupAddress, HeartBeatTest.portNo);
            org.junit.Assert.assertNotNull(testInstance);
            execute(testInstance);
        } catch (final HeartBeatException heartBeatException) {
            org.junit.Assert.assertTrue(heartBeatException.getLocalizedMessage().contains("Not a multicast address"));
            log.debug("Expected:" + heartBeatException.getLocalizedMessage());
            // expected error for test is HeartBeatException - ignore.
        } catch (final Exception exception) {
            fail("implementation error unexpected exception" + exception.getLocalizedMessage());
        }
    }

    /**
     * Command Pattern [GOF] execute method.
     *
     * @param testInstance the test instance
     */
    @Test
    private final void execute(final HeartBeat testInstance) {
        final long endTime = System.currentTimeMillis() + 10000;
        final Thread heartBeatThread = new Thread(testInstance);
        heartBeatThread.setPriority(Thread.MAX_PRIORITY);
        heartBeatThread.start();
        while (heartBeatThread.isAlive() && System.currentTimeMillis() < endTime) {
            Thread.yield();
        }
        System.gc();
    }
}
