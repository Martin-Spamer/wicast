
package net.wicast;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;

public class SenderConfigTest {

    /** provides logging */
    private static final Logger LOG = LoggerFactory.getLogger(SenderConfigTest.class);

    @Test
    public void testSenderConfig() {
        SenderConfig config = new SenderConfig();
        assertNotNull(config);
        LOG.info("{}", config);
    }

    @Test
    public void testSenderConfigGetMessage() {
        SenderConfig config = new SenderConfig();
        assertNotNull(config);
        LOG.info("{}", config);

        String message = config.getMessage();
        assertNotNull(message);
        LOG.info("{}", message);
    }
}
