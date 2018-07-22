
package net.wicast;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;

public class ReceiverConfigTest {

    /** provides logging */
    private static final Logger LOG = LoggerFactory.getLogger(ReceiverConfigTest.class);

    @Test
    public void testReceiverConfig() {
        ReceiverConfig config = new ReceiverConfig();
        assertNotNull(config);
        LOG.info("{}", config);
    }

}
