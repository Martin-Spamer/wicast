
package net.wicast;

import java.net.InetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An abstract class for a Channel.
 */
public abstract class AbstractChannel implements ChannelInterface {

    /** provide logging. */
    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    /** The group address. */
    protected InetAddress groupAddress;

    /**
     * Instantiates a new abstract channel.
     */
    public AbstractChannel() {
        super();
        log.info("{}", this.getClass().getSimpleName());
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

}
