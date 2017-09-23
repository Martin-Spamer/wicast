
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
	public void beat(String message) throws HeartBeatException;

}
