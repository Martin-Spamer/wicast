
package net.wicast.client;

/**
 * MultiCast Client Class.
 */
public final class Client {

	protected ClientConfig config;

	/**
	 * Instantiates a new client.
	 */
	public Client() {
		this.config = new ClientConfig();
	}

	public Client start() {
		return this;
	}

}
