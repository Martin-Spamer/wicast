package net.wicast.heartbeat;

/**
 * IHeartBeat.
 * 
 * @author <author@wicast.net>
 * 
 */
public interface IHeartBeat
{

    /**
     * beat.
     *
     * @param message the message
     * @throws HeartBeatException the heart beat exception
     */
    void beat(String message) throws HeartBeatException;

}
