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

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract Base Class providing responsibly for loading the applications'
 * configuration. It uses the fully qualified class name + ".xml" to locate the
 * configuration file.
 * <author@wicast.net>
 */
abstract public class MainApp {

    private static final Logger log = LoggerFactory.getLogger(MainApp.class);
    protected AbstractConfig config = null;

    /**
     * Default Constructor initialises the application from the configuration.
     */
    public MainApp() {
        MainApp.log.info("MainApp");

        // use the fully qualified name of the application class
        // for XML config file.
        final String filename = this.getClass().getSimpleName() + ".xml";
        log.info("filename = {}", filename);

        // open the [ApplicationName].xml file
        final File file = new File(filename);

        // load the configuration from the [ApplicationName].xml file.
        this.config.load(file);
    }

}
