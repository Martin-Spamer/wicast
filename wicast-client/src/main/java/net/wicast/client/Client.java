
package net.wicast.client;

/**
 * MultiCast Client Class.
 */
public final class Client {

    /** Configuration for Multicast client class. */
    protected ClientConfig config;

    /**
     * Instantiates a new client.
     */
    public Client() {
        config = new ClientConfig();
    }

    /**
     * Start.
     *
     * @return the client
     */
    public Client start() {
        return this;
    }

    /**
     * Stop.
     *
     * @return the client
     */
    public Client stop() {
        return this;
    }
}
