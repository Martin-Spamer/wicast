
package net.wicast.client;

/**
 * MultiCast Client Class.
 */
public final class Client {

    protected final ClientConfig config;

    /**
     * Instantiates a new client.
     */
    public Client() {
        super();
        this.config = new ClientConfig();
    }

    /**
     * Start.
     *
     * @return this for a fluent interface.
     */
    public Client start() {
        return this;
    }

    /**
     * Stop.
     *
     * @return this for a fluent interface.
     */
    public Client exit() {
        return this;
    }

}
