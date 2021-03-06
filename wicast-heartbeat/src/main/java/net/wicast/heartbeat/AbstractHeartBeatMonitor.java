
package net.wicast.heartbeat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

/**
 * AbstractHeartBeatMonitor.
 */
public abstract class AbstractHeartBeatMonitor extends AbstractHeartBeat {

    /**
     * AbstractHeartBeatMonitor.
     *
     * @param groupAddress the group address
     * @param portNo the port no
     * @throws HeartBeatException the heart beat exception
     */
    public AbstractHeartBeatMonitor(final InetAddress groupAddress, final int portNo) throws HeartBeatException {
        super(groupAddress, portNo);
    }

    /**
     * AbstractHeartBeat.
     *
     * @param groupAddress the group address
     * @param portNo the port no
     * @throws HeartBeatException the heart beat exception
     */
    public AbstractHeartBeatMonitor(final String groupAddress, final int portNo) throws HeartBeatException {
        super(groupAddress, portNo);
    }

    /**
     * Beat.
     *
     * @param message the message
     * @throws HeartBeatException the heart beat exception
     * @see net.wicast.heartbeat.HeartBeatInterface#beat(java.lang.String)
     */
    @Override
    public void beat(final String message) throws HeartBeatException {
        try {
            try {
                multicastSocket.joinGroup(groupAddress);

                final DatagramPacket outBoundDatagramPacket = new DatagramPacket(
                        message.getBytes(),
                        message.length(),
                        groupAddress,
                        port);

                multicastSocket.send(outBoundDatagramPacket);
            } catch (final SocketException e) {
                log.error(e.getLocalizedMessage(), e);
                throw new HeartBeatException(e);
            }
        } catch (final IOException e) {
            log.error(e.getLocalizedMessage(), e);
            throw new HeartBeatException(e);
        }
    }

    /**
     * Monitor.
     *
     * @throws HeartBeatException the heart beat exception
     */
    protected void monitor() throws HeartBeatException {
        try {
            multicastSocket = new MulticastSocket(port);
            final byte[] buffer = new byte[1000];
            final DatagramPacket inboundDatagramPacket = new DatagramPacket(buffer, buffer.length);
            multicastSocket.receive(inboundDatagramPacket);
            multicastSocket.leaveGroup(groupAddress);
        } catch (final IOException e) {
            log.error(e.getLocalizedMessage(), e);
            throw new HeartBeatException(e);
        }
    }
}
