
package net.wicast.heartbeat;

/**
 * HeartBeatException.
 */
public class HeartBeatException extends Exception {
    
    /** serialVersionUID 			constant. */
    private static final long serialVersionUID = 1L;

    /**
     * HeartBeatException.
     */
    public HeartBeatException() {
        super();
    }

    /**
     * HeartBeatException.
     *
     * @param message the message
     */
    public HeartBeatException(final String message) {
        super(message);
    }

    /**
     * HeartBeatException.
     *
     * @param message the message
     * @param cause the cause
     */
    public HeartBeatException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * HeartBeatException.
     *
     * @param cause the cause
     */
    public HeartBeatException(final Throwable cause) {
        super(cause);
    }

}
