
package net.wicast;

/**
 * Channel Interface.
 */
public interface ChannelInterface {

    /**
     * Send message to this channel.
     *
     * @param message the message
     * @return the channel
     */
    ChannelInterface send(Message message);

}
