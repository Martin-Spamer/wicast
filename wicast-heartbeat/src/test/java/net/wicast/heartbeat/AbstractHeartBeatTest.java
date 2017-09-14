package net.wicast.heartbeat;

import org.junit.Test;

public class AbstractHeartBeatTest {

	public class MockHeartBeat extends AbstractHeartBeat {
		@Override
		public void beat(final String message) throws HeartBeatException {
		}
	}

	@Test
	public final void testMockHeartBeat() {
		new MockHeartBeat();
	}

}
