
package net.wicast.client;

/**
 * A MultiCast Client Class.
 */
public final class Client {

    /** configuration. */
    private final ClientConfig config = new ClientConfig();

    /**
     * Instantiates a new client.
     */
    public Client() {
        super();
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

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("%s[config=%s]", this.getClass().getSimpleName(), config);
    }

}
