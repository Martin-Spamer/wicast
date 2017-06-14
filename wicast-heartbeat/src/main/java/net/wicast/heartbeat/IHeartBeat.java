package net.wicast.heartbeat;

/**
 * IHeartBeat.
 *

 */
public interface IHeartBeat {

    /**
     * beat.
     *
 * message
 * heart beat exception
     */
    void beat(String message) throws HeartBeatException;

}
