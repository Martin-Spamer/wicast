
package net.wicast.heartbeat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * HeartBeat.
 */
public class HeartBeat extends AbstractHeartBeat {

    /** ADDRESS 			constant. */
    private static final String ADDRESS = "224.0.0.1";
    
    /** PORT 			constant. */
    private static final int PORT = 1;

    /**
     * Instantiates a new heart beat.
     *
     * @throws HeartBeatException on failure.
     */
    public HeartBeat() throws HeartBeatException {
        super(ADDRESS, PORT);
    }

    /**
     * HeartBeat.
     *
     * @param groupAddress the group address
     * @param portNo the port no
     * @throws HeartBeatException the heart beat exception
     */
    public HeartBeat(final InetAddress groupAddress, final int portNo) throws HeartBeatException {
        super(groupAddress, portNo);
    }

    /**
     * HeartBeat.
     *
     * @param groupAddress the group address
     * @param portNo the port no
     * @throws HeartBeatException the heart beat exception
     */
    public HeartBeat(final String groupAddress, final int portNo) throws HeartBeatException {
        super(groupAddress, portNo);
    }

    /**
     * Beat.
     *
     * @throws HeartBeatException on failure.
     */
    public void beat() throws HeartBeatException {
        beat(new TimeStamp().toString());
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

                final DatagramPacket outBoundDatagramPacket = new DatagramPacket(message.getBytes(), message.length(),
                        groupAddress, portNo);

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
     * Run.
     *
     * @see java.lang.Runnable#run()
     */
    @SuppressWarnings("deprecation")
    @Override
    public void run() {
        final TimeStamp timeStamp = new TimeStamp();
        try {
            final String message = String.format("%s - %s", timeStamp, this.getClass().getSimpleName());
            beat(message);
        } catch (final HeartBeatException e) {
            log.error(e.getLocalizedMessage(), e);
            exit();
        }
    }

    /**
     * Exit.
     */
    private void exit() {
        exit = true;
    }
}
