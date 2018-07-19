
package net.wicast.client;

/**
 * MultiCast Client Class.
 */
public final class Client {

    private final ClientConfig config;

    /**
     * Instantiates a new client.
     */
    public Client() {
        super();
        config = new ClientConfig();
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

    @Override
    public String toString() {
        return String.format("%s[config=%s]", this.getClass().getSimpleName(), config);
    }

}
