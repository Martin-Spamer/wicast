package net.wicast.heartbeat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

/**
 * AbstractHeartBeatMonitor.
 *
 * @author <author@wicast.net>
 */
public class AbstractHeartBeatMonitor extends AbstractHeartBeat {

    /**
     * AbstractHeartBeatMonitor.
     *
     * @param groupAddress the group address
     * @param portNo the port no
     * @throws HeartBeatException the heart beat exception
     */
    public AbstractHeartBeatMonitor(InetAddress groupAddress, int portNo) throws HeartBeatException {
        super(groupAddress, portNo);
    }

    /**
     * AbstractHeartBeat.
     *
     * @param groupAddress the group address
     * @param portNo the port no
     * @throws HeartBeatException the heart beat exception
     */
    public AbstractHeartBeatMonitor(String groupAddress, int portNo) throws HeartBeatException {
        super(groupAddress, portNo);
    }

    /**
     * Beat.
     *
     * @param message the message
     * @throws HeartBeatException the heart beat exception
     * @see net.wicast.heartbeat.IHeartBeat#beat(java.lang.String)
     */
    @Override
    public void beat(String message) throws HeartBeatException {
        try {
            try {
                multicastSocket.joinGroup(groupAddress);

                final DatagramPacket outBoundDatagramPacket = new DatagramPacket(message.getBytes(),
                        message.length(),
                        groupAddress,
                        portNo);

                multicastSocket.send(outBoundDatagramPacket);
            } catch (final SocketException socketException) {
                socketException.printStackTrace(System.err);
                throw new HeartBeatException(socketException);
            }
        } catch (final IOException ioException) {
            ioException.printStackTrace(System.err);
            throw new HeartBeatException(ioException);
        }

    }

    /**
     * Monitor.
     *
     * @throws HeartBeatException the heart beat exception
     */
    protected void monitor() throws HeartBeatException {
        try {
            multicastSocket = new MulticastSocket(portNo);
            final byte[] buffer = new byte[1000];
            final DatagramPacket inboundDatagramPacket = new DatagramPacket(buffer, buffer.length);
            multicastSocket.receive(inboundDatagramPacket);
            multicastSocket.leaveGroup(groupAddress);
        } catch (final IOException ioException) {

            ioException.printStackTrace(System.err);
            throw new HeartBeatException(ioException);
        }

    }

}
