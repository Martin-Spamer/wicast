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

import java.io.File;

import net.wicast.AbstractConfig;

/**
 * The Config Class.
 */
public class Config extends AbstractConfig {

    public Config() {
    }

    public Config(final String xmlString) {
    }

    public Config(final File file) {
    }

    public Config subConfig(final String string) {
        return null;
    }

    /* (non-Javadoc)
     * @see net.wicast.ConfigInterface#loadProperties()
     */
    @Override
    public boolean loadProperties() {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see net.wicast.ConfigInterface#loadXml()
     */
    @Override
    public boolean loadXml() {
        // TODO Auto-generated method stub
        return false;
    }

}
