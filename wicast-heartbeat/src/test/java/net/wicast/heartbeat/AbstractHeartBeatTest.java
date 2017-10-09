
package net.wicast.heartbeat;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * Abstract Heart Beat Test class.
 */
public class AbstractHeartBeatTest {

	/**
	 * MockHeartBeat class.
	 */
	public class MockHeartBeat extends AbstractHeartBeat {
		/* (non-Javadoc)
		 * @see net.wicast.heartbeat.HeartBeatInterface#beat(java.lang.String)
		 */
		@Override
		public void beat(final String message) throws HeartBeatException {
		}
	}

	/**
	 * Unit Test to mock heart beat.
	 */
	@Test
	public final void testMockHeartBeat() {
		final MockHeartBeat mockHeartBeat = new MockHeartBeat();
		assertNotNull("Value cannot be null",mockHeartBeat);
	}

}
