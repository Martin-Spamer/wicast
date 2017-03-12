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
 * TimeStampTest.
 *
 * @author <author@wicast.net>
 */
public class TimeStampTest {

    private static final Logger log = LoggerFactory.getLogger(TimeStampTest.class);

    /**
     * test case for TimeStamp.
     */
    @Test
    public final void test() {
        final TimeStamp testTimeStamp1 = new TimeStamp();
        org.junit.Assert.assertNotNull(testTimeStamp1);

        final TimeStamp testTimeStamp2 = new TimeStamp();
        org.junit.Assert.assertNotNull("not null", testTimeStamp2);
        org.junit.Assert.assertNotSame("Not same", testTimeStamp1, testTimeStamp2);

        TimeStampTest.log.info("{}", testTimeStamp1);
        TimeStampTest.log.info("{}", testTimeStamp1.time);
        TimeStampTest.log.info("{}", testTimeStamp1.toString());
        TimeStampTest.log.info("{}", testTimeStamp2);
        TimeStampTest.log.info("{}", testTimeStamp2.time);
        TimeStampTest.log.info(testTimeStamp2.toString());
        TimeStampTest.log.info(TimeStamp.FORMAT);
    }
}
