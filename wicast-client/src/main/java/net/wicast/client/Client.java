
package net.wicast.client;

/**
 * MultiCast Client Class.
 */
public final class Client {

    /** The config. */
    protected ClientConfig config;

    /**
     * Instantiates a new client.
     */
    public Client() {
        this.config = new ClientConfig();
    }

    /**
     * Start.
     *
     * @return the client
     */
    public Client start() {
        return this;
    }

}
