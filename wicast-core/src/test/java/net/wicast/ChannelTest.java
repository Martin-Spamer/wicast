
package net.wicast;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ChannelTest {

    private static final Logger LOG = LoggerFactory.getLogger(ChannelTest.class);

    @Test
    public void testTypicalUsage() {
        final ChannelInterface channel = new Channel();
        assertNotNull(channel);
        assertEquals(channel, channel.send(new Message()));
        LOG.debug("{}", channel);
    }

}
