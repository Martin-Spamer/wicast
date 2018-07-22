
package net.wicast;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit test class for Channel.
 */
public class ChannelTest {

    /** provides logging. */
    private static final Logger LOG = LoggerFactory.getLogger(ChannelTest.class);

    /**
     * Unit test to typical usage.
     */
    @Test
    public void testTypicalUsage() {
        final ChannelInterface channel = new Channel();
        assertNotNull(channel);
        assertEquals(channel, channel.send(new Message()));
        LOG.debug("{}", channel);
    }

    @Test
    public void testChannel() {
        final ChannelInterface channel = new Channel();
        assertNotNull(channel);
        Message message = new Message();
        assertNotNull(message);
        assertEquals(channel, channel.send(message));
        LOG.debug("{}", channel);
    }

    @Test
    public void testChannelConfig() {
        ChannelConfig config = new ChannelConfig();
        assertNotNull(config);
        final ChannelInterface channel = new Channel(config);
        assertNotNull(channel);
        Message message = new Message();
        assertNotNull(message);
        assertEquals(channel, channel.send(message));
        LOG.debug("{}", channel);
    }
}
