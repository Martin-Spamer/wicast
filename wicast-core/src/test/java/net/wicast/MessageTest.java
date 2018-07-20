
package net.wicast;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit test class for Message.
 */
public class MessageTest {

    /** LOG 			constant. */
    private static final Logger LOG = LoggerFactory.getLogger(MessageTest.class);

    /**
     * Unit test to typical usage.
     */
    @Test
    public void testTypicalUsage() {
        final MessageInterface message = new Message();
        assertNotNull(message);
        assertEquals(message, message.send(new Channel()));
        LOG.debug(message.toString());
    }

}
