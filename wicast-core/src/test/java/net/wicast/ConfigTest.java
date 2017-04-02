/**
 * This file is part of Automated Testing Framework for Java (atf4j).
 *
 * Atf4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Atf4j is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with atf4j.  If not, see http://www.gnu.org/licenses/.
 */
package net.wicast;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.wicast.AbstractConfig;
import net.wicast.ConfigInterface;

/**
 * ConfigTest.
 */
public class ConfigTest {
    private static final Logger log = LoggerFactory.getLogger(ConfigTest.class);

    /**
     * MockConfig Class.
     */
    private class MockConfig extends AbstractConfig {
        public MockConfig() {
            super();
        }
    }

    /**
     * Test method for {@link net.wicast.Config#Config()}.
     *
     * @throws Exception the exception
     */
    @Test
    public void testConfig() throws Exception {
        final AbstractConfig config = new MockConfig();
        assertNotNull(config);

        ConfigTest.log.info(config.toString());
        ConfigTest.log.info(config.xmlFoo());
        assertTrue(config.saveAsProperties());
        assertTrue(config.saveAsXml());
        config.dumpToLog();

    }

    /**
     * Test method for {@link net.wicast.Config#toString()}.
     */
    @Test
    public void testToString() {
        final ConfigInterface config = new MockConfig();
        assertNotNull(config);
        log.info(config.toString());
    }
}
