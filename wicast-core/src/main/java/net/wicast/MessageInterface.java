
package net.wicast;

/**
 * Message Interface.
 */
public interface MessageInterface {

    /**
     * Send.
     *
     * @param channel the channel
     * @return the message interface
     */
    MessageInterface send(ChannelInterface channel);

}
