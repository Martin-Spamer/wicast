
package net.wicast;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An abstract class for a Channel.
 */
public abstract class AbstractChannel implements ChannelInterface {

    /** provide logging. */
    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    /** The configuration. */
    protected WiCastConfig config = new ChannelConfig();

    /** The group address. */
    protected InetAddress groupAddress;

    /** The port no. */
    protected int portNo;

    /**
     * Instantiates a new abstract channel.
     */
    public AbstractChannel() {
        super();
    }

    /**
     * Instantiates a new abstract channel.co
     *
     * @param config the config
     */
    public AbstractChannel(final WiCastConfig config) {
        super();
        initialise(config);
    }

    /**
     * Instantiates a new abstract channel.
     *
     * @param groupAddress the group address
     * @param portNo the port no
     */
    public AbstractChannel(final String groupAddress, final String portNo) {
        super();
        initialise(groupAddress, portNo);
    }

    /**
     * Instantiates a new abstract channel.
     *
     * @param groupAddress the group address
     * @param portNo the port no
     */
    public AbstractChannel(final InetAddress groupAddress, final int portNo) {
        super();
        initialise(groupAddress, portNo);
    }

    /**
     * Initialise the channel from configuraton.
     *
     * @param config the config
     */
    protected void initialise(final WiCastConfig config) {
        initialise(config.defaultChannel(), config.getPort());
    }

    /**
     * Initialise.
     *
     * @param group the group
     * @param port the port
     */
    protected void initialise(final String group, final String port) {
        try {
            initialise(InetAddress.getByName(group), Integer.parseInt(port));
        } catch (NumberFormatException | UnknownHostException e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }

    protected void initialise(final InetAddress groupAddress, final int portNo) {
        this.groupAddress = groupAddress;
        this.portNo = portNo;
    }

    /*
     * (non-Javadoc)
     * @see net.wicast.ChannelInterface#send(net.wicast.Message)
     */
    @Override
    public ChannelInterface send(final MessageInterface message) {
        log.info("send({})", message);
        return this;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("%s [groupAddress=%s, portNo=%s, config=%s]", this.getClass().getSimpleName(), groupAddress, portNo, config);
    }

}
