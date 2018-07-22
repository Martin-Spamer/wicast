
package net.wicast;

import java.net.InetAddress;
import java.net.UnknownHostException;

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

    /** multicast group address . */
    protected InetAddress groupAddress;

    /** multicast port. */
    protected int portNo;

    /**
     * Instantiates a new multicast base.
     */
    public MulticastBase() {
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

    public MulticastBase(final InetAddress groupAddress, final int portNo) {
        this.groupAddress = groupAddress;
        this.portNo = portNo;
    }

    /**
     * Initialise.
     *
     * @param group the group
     * @param port the port
     */
    protected void initialise(final String group, final String port) {
        try {
            portNo = Integer.parseInt(port);
        } catch (NumberFormatException e) {
            log.error(e.getLocalizedMessage(), e);
        }
        try {
            groupAddress = InetAddress.getByName(group);
        } catch (UnknownHostException e) {
            log.error(e.getLocalizedMessage(), e);
        }
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
