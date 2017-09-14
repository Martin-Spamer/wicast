package net.wicast.heartbeat;

import org.junit.Test;

public class AbstractHeartBeatMonitorTest {

	public class HeartBeatMonitor extends AbstractHeartBeatMonitor {
	}

	@Test
	public void testAbstractHeartBeatMonitor() {
		new HeartBeatMonitor();
	}

	@Test
	public void testAbstractHeartBeatMonitorInetAddressInt() {
		new HeartBeatMonitor();
	}

	@Test
	public void testAbstractHeartBeatMonitorStringInt() {
		new HeartBeatMonitor();
	}

	@Test
	public void testBeat() {
		new HeartBeatMonitor();
	}

	@Test
	public void testMonitor() {
		new HeartBeatMonitor();
	}

}
