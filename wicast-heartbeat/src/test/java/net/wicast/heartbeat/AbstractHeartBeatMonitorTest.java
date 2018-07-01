
package net.wicast.heartbeat;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * AbstractHeartBeatMonitorTest class.
 */
@Ignore
public class AbstractHeartBeatMonitorTest {

    /**
     * HeartBeatMonitor class.
     */
    public class HeartBeatMonitor extends AbstractHeartBeatMonitor {

        /**
         * Instantiates a new heart beat monitor.
         *
         * @throws HeartBeatException the heart beat exception
         */
        public HeartBeatMonitor() throws HeartBeatException {
            super("224.0.0.1", 1);
        }

        /**
         * Instantiates a new heart beat monitor.
         *
         * @param groupAddress the group address
         * @param portNo the port no
         * @throws HeartBeatException the heart beat exception
         */
        public HeartBeatMonitor(final String groupAddress, final int portNo) throws HeartBeatException {
            super(groupAddress, portNo);
        }

        /**
         * Instantiates a new heart beat monitor.
         *
         * @param groupAddress the group address
         * @param portNo the port no
         * @throws HeartBeatException the heart beat exception
         */
        public HeartBeatMonitor(final InetAddress groupAddress, final int portNo) throws HeartBeatException {
            super(groupAddress, portNo);
        }

    }

    /**
     * Unit Test to abstract heart beat monitor.
     *
     * @throws HeartBeatException the heart beat exception
     */
    @Test
    public void testAbstractHeartBeatMonitor() throws HeartBeatException {
        final HeartBeatMonitor heartBeatMonitor = new HeartBeatMonitor();
        assertNotNull("Value cannot be null", heartBeatMonitor);
    }

    /**
     * Unit Test to abstract heart beat monitor string int.
     *
     * @throws HeartBeatException the heart beat exception
     */
    @Test
    public void testAbstractHeartBeatMonitorStringInt() throws HeartBeatException {
        final HeartBeatMonitor heartBeatMonitor = new HeartBeatMonitor("224.0.0.1", 1);
        assertNotNull("Value cannot be null", heartBeatMonitor);
    }

    /**
     * Unit Test to abstract heart beat monitor inet address int.
     *
     * @throws HeartBeatException the heart beat exception
     * @throws UnknownHostException the unknown host exception
     */
    @Test
    public void testAbstractHeartBeatMonitorInetAddressInt() throws HeartBeatException, UnknownHostException {
        final InetAddress inetAddress = InetAddress.getByName("224.0.0.1");
        final HeartBeatMonitor heartBeatMonitor = new HeartBeatMonitor(inetAddress, 1);
        assertNotNull("Value cannot be null", heartBeatMonitor);
    }

    /**
     * Unit Test to beat.
     *
     * @throws HeartBeatException the heart beat exception
     */
    @Ignore
    @Test
    public void testBeat() throws HeartBeatException {
        final HeartBeatMonitor heartBeatMonitor = new HeartBeatMonitor();
        assertNotNull("Value cannot be null", heartBeatMonitor);
        heartBeatMonitor.monitor();
    }
}
