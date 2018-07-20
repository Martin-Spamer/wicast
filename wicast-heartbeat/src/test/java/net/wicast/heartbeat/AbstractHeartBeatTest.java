
package net.wicast.heartbeat;

import java.net.InetAddress;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Abstract Heart Beat Test class.
 */
@Ignore("work-in-progress")
public class AbstractHeartBeatTest {

    private static final String LOCALHOST = "127.0.0.1";

    /**
     * MockHeartBeat class.
     */
    public class MockHeartBeat extends AbstractHeartBeat {

        /**
         * Instantiates a new mock heart beat.
         *
         * @throws HeartBeatException the heart beat exception
         */
        public MockHeartBeat() throws HeartBeatException {
            super();
        }

        /**
         * Instantiates a new mock heart beat.
         *
         * @param groupAddress the group address
         * @param portNo the port no
         * @throws HeartBeatException the heart beat exception
         */
        private MockHeartBeat(final InetAddress groupAddress, final int portNo) throws HeartBeatException {
            super(groupAddress, portNo);
        }

        /**
         * Instantiates a new mock heart beat.
         *
         * @param groupAddressString the group address string
         * @param portNo the port no
         * @throws HeartBeatException the heart beat exception
         */
        private MockHeartBeat(final String groupAddressString, final int portNo) throws HeartBeatException {
            super(groupAddressString, portNo);
        }

        /*
         * (non-Javadoc)
         * @see net.wicast.heartbeat.HeartBeatInterface#beat(java.lang.String)
         */
        @Override
        public void beat(final String message) throws HeartBeatException {
            throw new HeartBeatException("MockHeartBeat");
        }
    }

    /**
     * Unit Test to mock heart beat.
     *
     * @throws HeartBeatException
     */
    @Test
    public final void testMockHeartBeat() throws HeartBeatException {
        final MockHeartBeat mockHeartBeat = new MockHeartBeat();
        assertNotNull("Value cannot be null", mockHeartBeat);
    }

    /**
     * Unit Test to mock heart beat.
     *
     * @throws Exception
     */
    @Test
    public final void testMockHeartBeatString() throws Exception {
        final MockHeartBeat mockHeartBeat = new MockHeartBeat("heartbeat.wicast.net", 1234);
        assertNotNull("Value cannot be null", mockHeartBeat);
    }

    /**
     * Unit Test to mock heart beat.
     *
     * @throws Exception
     */
    @Test
    public final void testMockHeartBeatGroupAddress() throws Exception {
        InetAddress groupAddress = InetAddress.getByName("heartbeat.wicast.net");
        final MockHeartBeat mockHeartBeat = new MockHeartBeat(groupAddress, 1234);
        assertNotNull("Value cannot be null", mockHeartBeat);
    }

    /**
     * Unit Test to mock heart beat.
     *
     * @throws HeartBeatException
     */
    @Test
    public final void testMockHeartBeatLocalHost() throws HeartBeatException {
        final MockHeartBeat mockHeartBeat = new MockHeartBeat(LOCALHOST, 1234);
        assertNotNull("Value cannot be null", mockHeartBeat);
    }

    /**
     * Unit Test to mock heart beat.
     *
     * @throws Exception
     */
    @Test
    public final void testMockHeartBeatLocalHostGroupAddress() throws Exception {
        InetAddress groupAddress = InetAddress.getByName(LOCALHOST);
        final MockHeartBeat mockHeartBeat = new MockHeartBeat(groupAddress, 1234);
        assertNotNull("Value cannot be null", mockHeartBeat);
    }

}
