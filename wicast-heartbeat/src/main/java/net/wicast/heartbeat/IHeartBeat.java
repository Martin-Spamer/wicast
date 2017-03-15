package net.wicast.heartbeat;

/**
 * IHeartBeat.
 *

 */
public interface IHeartBeat {

    /**
     * beat.
     *
     * @param message the message
     * @throws HeartBeatException the heart beat exception
     */
    void beat(String message) throws HeartBeatException;

}
