
package net.wicast;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;

/**
 * MultiCast Relay Test class.
 */
public class MultiCastRelayTest {

    /** provide logging. */
    private static final Logger LOG = LoggerFactory.getLogger(MultiCastRelayTest.class);

    /**
     * Unit Test to multicast relay.
     */
    @Test
    public void testMultiCastRelay() {
        final MultiCastRelay multiCastRelay = new MultiCastRelay();
        assertNotNull("Value cannot be null", multiCastRelay);
        LOG.info("{}", multiCastRelay);
    }

}
