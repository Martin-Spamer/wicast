
package net.wicast.server;

/**
 * MultiCast Server class.
 */
public class Server {

    protected final ServerConfig config;

    /**
     * Instantiates a new server.
     */
    public Server() {
        super();
        this.config = new ServerConfig();
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
