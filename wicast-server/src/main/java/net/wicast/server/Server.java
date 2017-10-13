
package net.wicast.server;

/**
 * MultiCast Server class.
 */
public class Server {

	protected ServerConfig config;

	/**
	 * Instantiates a new server.
	 */
	public Server() {
		this.config = new ServerConfig();
	}

	/**
	 * Start.
	 *
	 * @return the server
	 */
	public Server start() {
		return this;
	}

}
