
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
        LOG.info("{}", string);
    }

    /**
     * Unit test to multicast receiver channel port.
     */
    @Test
    public void testMultiCastReceiverChannelPort() {
        WiCastConfig config = new WiCastConfig();
        final MultiCastReceiver multiCastReceiver = new MultiCastReceiver(config.defaultChannel(), config.getPort());
        assumeNotNull(multiCastReceiver);
        LOG.info("{}", multiCastReceiver);
    }

    /**
     * Unit test to multicast receiver configuration.
     */
    @Test
    public void testMultiCastReceiverConfig() {
        WiCastConfig config = new WiCastConfig();
        final MultiCastReceiver multiCastReceiver = new MultiCastReceiver(config);
        assumeNotNull(multiCastReceiver);
        LOG.info("{}", multiCastReceiver);
    }

}
