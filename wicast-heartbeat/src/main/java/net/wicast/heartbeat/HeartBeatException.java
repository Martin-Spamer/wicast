package net.wicast.heartbeat;

/**
 * HeartBeatException.
 */
public class HeartBeatException extends Exception {
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
	* message
	 */
	public HeartBeatException(final String message) {
		super(message);
	}

	/**
	 * HeartBeatException.
	 *
	* message
	* cause
	 */
	public HeartBeatException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * HeartBeatException.
	 *
	* cause
	 */
	public HeartBeatException(final Throwable cause) {
		super(cause);
	}

}
