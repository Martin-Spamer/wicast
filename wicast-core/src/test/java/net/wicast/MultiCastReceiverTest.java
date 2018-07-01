
package net.wicast;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assume.assumeNotNull;

/**
 * A UnitTest for MultiCastReceiver objects.
 */
public class MultiCastReceiverTest {

    /** provide logging. */
    private static final Logger LOG = LoggerFactory.getLogger(MultiCastSenderTest.class);

    /**
     * Unit Test for multicast receiver.
     */
    @Test
    public void testMultiCastReceiver() {
        final MultiCastReceiver multiCastReceiver = new MultiCastReceiver();
        assumeNotNull(multiCastReceiver);
        final String string = multiCastReceiver.toString();
        LOG.info(string);
    }

}
