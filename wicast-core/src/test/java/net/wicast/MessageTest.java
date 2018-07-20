
package net.wicast;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MessageTest {

    private static final Logger LOG = LoggerFactory.getLogger(MessageTest.class);

    @Test
    public void testTypicalUsage() {
        final Message message = new Message();
        assertNotNull(message);
        assertEquals(message, message.send(new Channel()));
        LOG.debug(message.toString());
    }

}
