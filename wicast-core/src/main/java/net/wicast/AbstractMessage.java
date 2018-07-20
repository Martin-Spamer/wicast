
package net.wicast;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An abstract Message class.
 */
public class AbstractMessage implements MessageInterface {

    /** The log. */
    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    /**
     * Instantiates a new abstract message.
     */
    public AbstractMessage() {
        super();
        log.info("{}", this.getClass().getSimpleName());
    }

    /*
     * (non-Javadoc)
     * @see net.wicast.MessageInterface#send(net.wicast.ChannelInterface)
     */
    @Override
    public MessageInterface send(final ChannelInterface channel) {
        log.info("send({})", channel);
        return this;
    }

}
