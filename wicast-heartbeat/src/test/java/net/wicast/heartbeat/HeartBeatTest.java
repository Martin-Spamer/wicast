
package net.wicast.heartbeat;

import static org.junit.Assert.*;

import java.net.*;

import org.junit.Test;
import org.slf4j.*;

/**
 * HeartBeatTest.
 */
public class HeartBeatTest {

	private static final Logger log = LoggerFactory.getLogger(HeartBeatTest.class);
	private static final String invalidGroupAddressString = "127.0.0.1";
	// 224.0.0.1 is local subnet only, closest multicast equivalent to 127.0.0.1
	private static final String validGroupAddressString = "224.0.0.1";
	private static final int portNo = 1;

	/**
	 * Command Pattern [GOF] execute method.
	 * 
	 * test instance
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

	/**
	 * Test method for
	 * {@link net.wicast.heartbeat.HeartBeat#HeartBeat(java.lang.String, int)}.
	 */
	@Test
	public final void testHeartBeatBadAddress() {
		// HeartBeat testInstance = new HeartBeat();
		try {
			final HeartBeat testInstance = new HeartBeat("net.wicast", HeartBeatTest.portNo);
			assertNull(testInstance);
		} catch (final HeartBeatException heartBeatException) {
			assertTrue(heartBeatException.getCause() instanceof java.net.UnknownHostException);
			log.debug("Expected:" + heartBeatException.getLocalizedMessage());
			// expected error for test is HeartBeatException - ignore.
		} catch (final Exception exception) {
			fail("implementation error unexpected exception" + exception.getLocalizedMessage());
		}
	}

	/**
	 * Test method for
	 * {@link net.wicast.heartbeat.HeartBeat#HeartBeat(InetAddress, int)}.
	 */
	@Test
	public final void testHeartBeatBadGroupAddress() {
		try {
			final InetAddress badGroupAddress = InetAddress.getByName(HeartBeatTest.invalidGroupAddressString);
			final HeartBeat testInstance = new HeartBeat(badGroupAddress, HeartBeatTest.portNo);
			assertNotNull(testInstance);
			execute(testInstance);
		} catch (final HeartBeatException heartBeatException) {
			assertTrue(heartBeatException.getLocalizedMessage().contains("Not a multicast address"));
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
			assertNotNull(testInstance);
			fail("implementation error");
		} catch (final HeartBeatException heartBeatException) {
			assertTrue(heartBeatException.getCause() instanceof java.net.UnknownHostException);
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
			assertNull(testInstance);
			fail("implementation error");
		} catch (final HeartBeatException heartBeatException) {
			assertTrue(heartBeatException.getLocalizedMessage().contains("Not a multicast address"));
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
			assertNull(testInstance);
			fail("implementation error");
		} catch (final HeartBeatException heartBeatException) {
			assertTrue(heartBeatException.getLocalizedMessage().contains("Not a multicast address"));
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
	public final void testHeartBeatGoodGroupString() {
		try {
			final HeartBeat testInstance = new HeartBeat(HeartBeatTest.validGroupAddressString, HeartBeatTest.portNo);
			assertNotNull(testInstance);
			execute(testInstance);
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
			final InetAddress goodGroupAddress = InetAddress.getByName(HeartBeatTest.validGroupAddressString);
			final HeartBeat testInstance = new HeartBeat(goodGroupAddress, HeartBeatTest.portNo);
			assertNotNull(testInstance);
			execute(testInstance);
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
			final InetAddress validGroupAddress = InetAddress.getByName(HeartBeatTest.validGroupAddressString);
			final HeartBeat testInstance = new HeartBeat(validGroupAddress, HeartBeatTest.portNo);
			assertNotNull(testInstance);
			execute(testInstance);
		} catch (final HeartBeatException heartBeatException) {
			assertTrue(heartBeatException.getLocalizedMessage().contains("Not a multicast address"));
			log.debug("Expected:" + heartBeatException.getLocalizedMessage());
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
			final HeartBeat testInstance = new HeartBeat(nullGroupAddress, HeartBeatTest.portNo);
			assertNotNull(testInstance);
			execute(testInstance);
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
			final HeartBeat testInstance = new HeartBeat(nullGroupAddressString, HeartBeatTest.portNo);
			assertNull(testInstance);
			fail("implementation error");
		} catch (final HeartBeatException heartBeatException) {
			assertTrue(heartBeatException.getLocalizedMessage().contains("Not a multicast address"));
			log.debug("Expected:" + heartBeatException.getLocalizedMessage());
			// expected error for test is HeartBeatException - ignore.
		} catch (final Exception exception) {
			fail("implementation error unexpected exception" + exception.getLocalizedMessage());
		}
	}
}
