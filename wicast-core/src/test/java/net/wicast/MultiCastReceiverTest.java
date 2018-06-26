
package net.wicast;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;

/**
 * A UnitTest for MultiCastReceiver objects.
 */
public class MultiCastReceiverTest {

    private static final Logger LOG = LoggerFactory.getLogger(MultiCastSenderTest.class);

    /**
     * Unit Test for test multicast receiver.
     */
    @Test
    public void testMultiCastReceiver() {
        final MultiCastReceiver multiCastReceiver = new MultiCastReceiver();
        assertNotNull("Value cannot be null", multiCastReceiver);
        MultiCastReceiverTest.LOG.info("{}", multiCastReceiver);
    }

}
