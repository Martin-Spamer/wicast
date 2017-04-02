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
package net.wicast.heartbeat;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A Class for testing the Config class
 *
 * @author
 * @version 0.1
 */
public class MoreConfigTest {

    private static final Logger log = LoggerFactory.getLogger(MoreConfigTest.class);

    /**
     * fail to load none existing configuration file. [code] [/code]
     */
    @Test
    public void test0() {
        try {
            MoreConfigTest.log.debug("--- test0 : named configuration file does not exist.");
            final Config config = new Config("missing.xml");
            MoreConfigTest.log.debug(config.toString());
        } catch (final java.lang.Exception exception) {
            MoreConfigTest.log.debug(exception.toString());
        }
    }

    /**
     * test load default configuration file. [code] Config config =
     * new Config() ;
     * log.debug( config.toString() ) ; [/code]
     */
    @Test
    public void test1() {
        try {
            MoreConfigTest.log.debug("--- test1 : load default configuration file.");
            final Config config = new Config();
            MoreConfigTest.log.debug(config.toString());
        } catch (final java.lang.Exception exception) {
            MoreConfigTest.log.debug(exception.toString());
        }
    }

    /**
     * test load a named configuration file. [code] Config config =
     * new Config( "Application.xml"
     * ) ; log.debug( config.toString() ) ; [/code]
     */
    @Test
    public void test2() {
        try {
            MoreConfigTest.log.debug("--- test2 : test load a named configuration file.");
            final Config config = new Config("Application.xml");
            MoreConfigTest.log.debug("config" + config.toString());
        } catch (final java.lang.Exception exception) {
            MoreConfigTest.log.debug(exception.toString());
        }
    }
}
