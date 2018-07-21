
package net.wicast.server;

/**
 * MultiCast Server class.
 */
public class Server {

    /** The config. */
    protected final ServerConfig config;

    /**
     * Instantiates a new server.
     */
    public Server() {
        super();
        config = new ServerConfig();
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
