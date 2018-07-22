
package net.wicast;

import java.net.InetAddress;

/**
 * Channel class.
 */
public final class Channel extends AbstractChannel {

    /**
     * Instantiates a new channel.
     */
    public Channel() {
        super();
    }

    /**
     * Instantiates a new channel.
     *
     * @param config the config
     */
    public Channel(final WiCastConfig config) {
        super(config);
    }

    /**
     * Instantiates a new channel.
     *
     * @param groupAddress the group address
     * @param portNo the port no
     */
    public Channel(final InetAddress groupAddress, final int portNo) {
        super(groupAddress, portNo);
    }

    /**
     * Instantiates a new channel.
     *
     * @param groupAddress the group address
     * @param portNo the port no
     */
    public Channel(final String groupAddress, final String portNo) {
        super(groupAddress, portNo);
    }

}
