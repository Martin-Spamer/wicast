
package net.wicast;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;

public class RelayConfigTest {

    /** provides logging */
    private static final Logger LOG = LoggerFactory.getLogger(RelayConfigTest.class);

    @Test
    public void testRelayConfig() {
        RelayConfig config = new RelayConfig();
        assertNotNull(config);
        LOG.info("{}", config);
    }

}
