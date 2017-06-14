package net.wicast.heartbeat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * HeartBeatTest.
 *

 */
public class HeartBeat extends AbstractHeartBeat {

    /**
     * HeartBeatTest.
     *
 * group address
 * port no
 * heart beat exception
     */
    public HeartBeat(InetAddress groupAddress, int portNo) throws HeartBeatException {
        super(groupAddress, portNo);
    }

    /**
     * HeartBeatTest.
     *
 * group address
 * port no
 * heart beat exception
     */
    public HeartBeat(String groupAddress, int portNo) throws HeartBeatException {
        super(groupAddress, portNo);
    }

    /**
     * Beat.
     *
 * message
 * heart beat exception
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
     * Run.
     *
     * @see java.lang.Runnable#run()
     */
    @SuppressWarnings("deprecation")
    @Override
    public void run() {
        final TimeStamp timeStamp = new TimeStamp();
        try {
            beat(timeStamp.toString() + "-" + this.getClass().toString());
        } catch (final HeartBeatException heartBeatException) {
            heartBeatException.printStackTrace(System.err);
            this.stop();
        }
    }
}
