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

import org.junit.Test;

/**
 * ConfigTest.
 * 20 Jun 2013
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
     * Test method for {@link net.wicast.Config#toString()}.
     */
    @Test
    public final void testToString() {
        final Config testInstance = new Config();
        assertNotNull(testInstance);
        assertNotNull(testInstance.toString());
        testInstance.dumpToLog();
    }

}
