
package net.wicast.heartbeat;

/**
 * Heart Beat Interface.
 */
public interface HeartBeatInterface {

    /**
     * Beat.
     *
     * @param message the message
     * @throws HeartBeatException the heart beat exception
     */
    void beat(final String message) throws HeartBeatException;

}
