/**
 * This file is part of Automated Testing Framework for Java (atf4j).
 *
 * Atf4j is free software: you can redistribute it and/or modify
 * GNU General Public License as published by
 * License, or
 * (at your option) any later version.
 *
 * hope that it will be useful,
 * implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * GNU General Public License
 * along with atf4j.  If not, see http://www.gnu.org/licenses/.
 */
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
