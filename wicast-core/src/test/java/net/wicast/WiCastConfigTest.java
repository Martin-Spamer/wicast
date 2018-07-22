
package net.wicast;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;

public class WiCastConfigTest {

    /** provides logging */
    private static final Logger LOG = LoggerFactory.getLogger(WiCastConfigTest.class);

    @Test
    public void testWiCastConfig() {
        WiCastConfig wiCastConfig = new WiCastConfig();
        assertNotNull(wiCastConfig);
        LOG.info("{}", wiCastConfig);
    }

    @Test
    public void testGetGroup() {
        assertNotNull(new WiCastConfig().getGroup());
    }

    @Test
    public void testDefaultChannel() {
        assertNotNull(new WiCastConfig().defaultChannel());
    }

    @Test
    public void testInputChannel() {
        assertNotNull(new WiCastConfig().inputChannel());
    }

    @Test
    public void testOutputChannel() {
        assertNotNull(new WiCastConfig().outputChannel());
    }

    @Test
    public void testGetPortNo() {
        assertNotNull(new WiCastConfig().getPort());
    }

    @Test
    public void testGetPort() {
        assertNotNull(new WiCastConfig().getPort());
    }

}
