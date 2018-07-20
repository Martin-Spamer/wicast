
package net.wicast;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class AbstractChannel.
 */
public abstract class AbstractChannel implements ChannelInterface {

    /** The log. */
    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

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
