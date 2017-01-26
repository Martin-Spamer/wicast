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
// All rights reserved. Duplication or distribution prohibited

package net.wicast.heartbeat;

import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.junit.Test;

/**
 * ConfigTest.
 *
 * @author <author@wicast.net> 20 Jun 2013
 */
public class ConfigTest {

    /**
     * Test method for {@link net.wicast.Config#Config()}.
     */
    @Test
    public final void testConfig() {
        assertNotNull(new Config());
    }

    /**
     * Test method for {@link net.wicast.Config#Config(java.io.File)}.
     */
    @Test
    public final void testConfigFile() {
        assertNotNull(new Config(new File("test.xml")));
    }

    /**
     * Test method for {@link net.wicast.Config#Config(java.lang.String)}.
     */
    @Test
    public final void testConfigString() {
        final String xmlString = "";
        assertNotNull(new Config(xmlString));
    }

    /**
     * Test method for {@link net.wicast.Config#Config(org.w3c.dom.Element)}.
     */
    @Test
    public final void testConfigElement() {
        final Config testInstance = new Config();
        assertNotNull(testInstance);
    }

    /**
     * Test method for {@link net.wicast.Config#load(java.lang.String)}.
     */
    @Test
    public final void testLoadString() {
        final Config testInstance = new Config();
        assertNotNull(testInstance);
    }

    /**
     * Test method for {@link net.wicast.Config#load(java.io.File)}.
     */
    @Test
    public final void testLoadFile() {
        final Config testInstance = new Config();
        assertNotNull(testInstance);
    }

    /**
     * Test method for {@link net.wicast.Config#subConfig(java.lang.String)}.
     */
    @Test
    public final void testSubConfig() {
        final Config testInstance = new Config();
        assertNotNull(testInstance);
    }

    /**
     * Test method for {@link net.wicast.Config#toString()}.
     */
    @Test
    public final void testToString() {
        final Config testInstance = new Config();
        assertNotNull(testInstance);
    }

}
