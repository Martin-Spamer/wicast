package net.wicast;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * A UnitTest for MultiCastReceiver objects.
 */
public class MultiCastReceiverTest {

    /**
     * Unit Test for test multi cast receiver.
     */
    @Test
    public void testMultiCastReceiver() {
        final MultiCastReceiver multiCastReceiver = new MultiCastReceiver();
        assertNotNull(multiCastReceiver);
    }

}
