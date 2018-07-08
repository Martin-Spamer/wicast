
package net.wicast;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * MultiCastReceiverTest.
 * 20 Jun 2013
 */
public class MultiCastReceiverTest {

    /**
     * Test method for
     * {@link net.wicast.MultiCastReceiver()}.
     */
    @Test
    public final void testMultiCastReceiver() {
        final MultiCastReceiver multiCastReceiver = new MultiCastReceiver();
        assertNotNull("Value cannot be null", multiCastReceiver);
    }

}
