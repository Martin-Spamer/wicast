
package net.wicast.server;

/**
 * MultiCast Server class.
 */
public class Server {

    /** The config. */
    protected ServerConfig config;

    /**
     * Instantiates a new server.
     */
    public Server() {
        config = new ServerConfig();
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
