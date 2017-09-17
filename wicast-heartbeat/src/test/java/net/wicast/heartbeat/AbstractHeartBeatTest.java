package net.wicast.heartbeat;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class AbstractHeartBeatTest {

	public class MockHeartBeat extends AbstractHeartBeat {
		@Override
		public void beat(final String message) throws HeartBeatException {
		}
	}

	@Test
	public final void testMockHeartBeat() {
		final MockHeartBeat mockHeartBeat = new MockHeartBeat();
		assertNotNull(mockHeartBeat);
	}

}
