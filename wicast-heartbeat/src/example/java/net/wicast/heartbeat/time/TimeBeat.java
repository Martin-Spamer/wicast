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
package net.wicast.heartbeat.time;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.SocketException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.wicast.heartbeat.AbstractHeartBeat;
import net.wicast.heartbeat.HeartBeatException;

/**
 * TimeBeat.
 *
 * @author <author@wicast.net>
 */
public class TimeBeat extends AbstractHeartBeat {

    private static final Logger log = LoggerFactory.getLogger(TimeBeat.class);

    /**
     * AbstractHeartBeat.
     *
     * @param groupAddress the group address
     * @param portNo the port no
     * @throws HeartBeatException the heart beat exception
     */
    public TimeBeat(final String groupAddress, final int portNo) throws HeartBeatException {
        super(groupAddress, portNo);
    }

    /**
     * AbstractHeartBeatMonitor.
     *
     * @param groupAddress the group address
     * @param portNo the port no
     * @throws HeartBeatException the heart beat exception
     */
    public TimeBeat(final InetAddress groupAddress, final int portNo) throws HeartBeatException {
        super(groupAddress, portNo);
    }

    /**
     * Beat.
     *
     * @param message the message
     * @throws HeartBeatException the heart beat exception
     * @see net.wicast.heartbeat.IHeartBeat#beat(java.lang.String)
     */
    @Override
    public void beat(final String message) throws HeartBeatException {
        try {
            try {
                this.multicastSocket.joinGroup(this.groupAddress);

                final DatagramPacket outBoundDatagramPacket = new DatagramPacket(message.getBytes(),
                        message.length(),
                        this.groupAddress,
                        this.portNo);

                this.multicastSocket.send(outBoundDatagramPacket);
            } catch (final SocketException socketException) {
                log.error("{}", socketException);
                throw new HeartBeatException(socketException);
            }
        } catch (final IOException ioException) {
            log.error("{}", ioException);
            throw new HeartBeatException(ioException);
        }
    }
}
