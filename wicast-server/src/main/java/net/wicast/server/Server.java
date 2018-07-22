
package net.wicast.server;

/**
 * MultiCast Server class.
 */
public class Server {

    /** configuration. */
    protected final ServerConfig config = new ServerConfig();

    /**
     * Instantiates a new server.
     */
    public Server() {
        super();
    }

    /**
     * Start.
     *
     * @return this for a fluent interface.
     */
    public Server start() {
        return this;
    }

    /**
     * Stop.
     *
     * @return this for a fluent interface.
     */
    public Server exit() {
        return this;
    }
}
