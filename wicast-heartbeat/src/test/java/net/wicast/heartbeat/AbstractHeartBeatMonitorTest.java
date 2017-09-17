package net.wicast.heartbeat;

import static org.junit.Assert.assertNotNull;

import java.net.*;

import org.junit.Test;

public class AbstractHeartBeatMonitorTest {
	private static final String invalidGroupAddressString = "127.0.0.1";
	// 224.0.0.1 is local subnet only, closest multicast equivalent to 127.0.0.1
	private static final String validGroupAddressString = "224.0.0.1";
	private static final int portNo = 1;

	public class HeartBeatMonitor extends AbstractHeartBeatMonitor {
		public HeartBeatMonitor() throws HeartBeatException {
			super("224.0.0.1", 1);
		}

		public HeartBeatMonitor(final String groupAddress, final int portNo) throws HeartBeatException {
			super(groupAddress, portNo);
		}

		public HeartBeatMonitor(final InetAddress groupAddress, final int portNo) throws HeartBeatException {
			super(groupAddress, portNo);
		}

	}

	@Test
	public void testAbstractHeartBeatMonitor() throws HeartBeatException {
		final HeartBeatMonitor heartBeatMonitor = new HeartBeatMonitor();
		assertNotNull(heartBeatMonitor);
	}

	@Test
	public void testAbstractHeartBeatMonitorStringInt() throws HeartBeatException {
		final HeartBeatMonitor heartBeatMonitor = new HeartBeatMonitor("224.0.0.1", 1);
		assertNotNull(heartBeatMonitor);
	}

	@Test
	public void testAbstractHeartBeatMonitorInetAddressInt() throws HeartBeatException, UnknownHostException {
		final InetAddress inetAddress = InetAddress.getByName("224.0.0.1");
		final HeartBeatMonitor heartBeatMonitor = new HeartBeatMonitor(inetAddress, 1);
		assertNotNull(heartBeatMonitor);
	}

	@Test
	public void testBeat() throws HeartBeatException {
		final HeartBeatMonitor heartBeatMonitor = new HeartBeatMonitor();
		assertNotNull(heartBeatMonitor);
		heartBeatMonitor.beat("testBeat");
	}

}
