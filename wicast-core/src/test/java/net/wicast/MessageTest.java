
package net.wicast;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MessageTest {

    @Test
    public void testMessage() {
        final Message message = new Message();
        assertNotNull(message);
        assertEquals(message, message.send(new Channel()));
    }

}
