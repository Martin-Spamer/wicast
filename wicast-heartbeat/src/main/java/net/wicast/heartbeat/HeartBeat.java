
package net.wicast.heartbeat;

import java.io.IOException;
import java.net.DatagramPacket;

/**
 * HeartBeat.
 */
public class HeartBeat extends AbstractHeartBeat {

    public HeartBeat() {
        super(new HeartBeatConfig());
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
            multicastSocket.joinGroup(groupAddress);
            final DatagramPacket outBoundDatagramPacket = new DatagramPacket(
                    message.getBytes(),
                    message.length(),
                    groupAddress, port);

            multicastSocket.send(outBoundDatagramPacket);
        } catch (IOException e) {
            log.error(e.getLocalizedMessage(), e);
            throw new HeartBeatException(e);
        }
    }
}
