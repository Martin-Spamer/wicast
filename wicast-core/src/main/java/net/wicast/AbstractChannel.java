
package net.wicast;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractChannel implements ChannelInterface {

    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    /**
     * Instantiates a new abstract channel.
     */
    public AbstractChannel() {
        super();
    }

    /*
     * (non-Javadoc)
     * @see net.wicast.ChannelInterface#send(net.wicast.Message)
     */
    @Override
    public ChannelInterface send(final Message message) {
        log.info("send({})", message);
        return this;
    }

}
