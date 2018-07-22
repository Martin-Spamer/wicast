
package net.wicast;

import java.net.InetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The MultiCastBase class.
 */
public abstract class MulticastBase {

    /** provides logging. */
    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    /** constant configuration. */
    protected WiCastConfig config = new WiCastConfig();

    /** The channel. */
    protected Channel channel;

    /** multicast group address . */
    protected InetAddress groupAddress;

    /** multicast port. */
    protected int portNo;

    /**
     * Instantiates a new multicast base.
     */
    public MulticastBase() {
        channel = new Channel(config);
        initialise(config.defaultChannel(), config.getPort());
    }

    /**
     * Instantiates a new multicast base.
     *
     * @param channel the channel
     */
    public MulticastBase(final Channel channel) {
        this.channel = channel;
        initialise(config.defaultChannel(), config.getPort());
    }

    /**
     * Instantiates a new multicast base.
     *
     * @param config the config
     */
    public MulticastBase(final WiCastConfig config) {
        this.config = config;
        initialise(config.defaultChannel(), config.getPort());
    }

    /**
     * Instantiates a new multicast base.
     *
     * @param group the group
     * @param port the port
     */
    public MulticastBase(final String group, final String port) {
        initialise(group, port);
    }

    /**
     * Instantiates a new multicast base.
     *
     * @param groupAddress the group address
     * @param portNo the port no
     */
    public MulticastBase(final InetAddress groupAddress, final int portNo) {
        this.groupAddress = groupAddress;
        this.portNo = portNo;
    }

    /**
     * Initialise.
     *
     * @param channel the channel
     */
    protected void initialise(final Channel channel) {
        this.channel = channel;
    }

    /**
     * Initialise.
     *
     * @param group the group
     * @param port the port
     */
    protected void initialise(final String group, final String port) {
        channel = new Channel(group, port);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String
            .format("%s [group=%s, port=%s, config=%s]",
                    this.getClass().getSimpleName(),
                    groupAddress,
                    portNo,
                    config);
    }

}
