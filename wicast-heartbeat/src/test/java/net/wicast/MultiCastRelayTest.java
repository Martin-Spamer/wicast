
package net.wicast;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * MultiCastRelayTest.
 * 20 Jun 2013
 */
public class MultiCastRelayTest {

    /**
     * Test method for {@link net.wicast.MultiCastRelay}.
     */
    @Test
    public final void testMultiCastRelay() {
        final MultiCastRelay multiCastRelay = new MultiCastRelay();
        assertNotNull("Value cannot be null", multiCastRelay);
    }

}
