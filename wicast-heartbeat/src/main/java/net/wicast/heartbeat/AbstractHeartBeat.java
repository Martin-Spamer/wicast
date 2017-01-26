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

import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AbstractHeartBeat.
 *
 * @author <author@wicast.net>
 */
public abstract class AbstractHeartBeat extends Thread implements IHeartBeat {

    private static final Logger log = LoggerFactory.getLogger(AbstractHeartBeat.class);
    protected final java.net.InetAddress groupAddress;
    protected final int portNo;
    protected MulticastSocket multicastSocket;

    /**
     * AbstractHeartBeat.
     *
     * @param groupAddressString the group address string
     * @param portNo the port no
     * @throws HeartBeatException the heart beat exception
     */
    public AbstractHeartBeat(final String groupAddressString, final int portNo) throws HeartBeatException {
        try {
            this.groupAddress = InetAddress.getByName(groupAddressString);
            this.portNo = portNo;
            joinGroup(this.groupAddress, this.portNo);
        } catch (final UnknownHostException unknownHostException) {
            log.error("{}", unknownHostException);
            throw new HeartBeatException(unknownHostException);
        }
    }

    /**
     * AbstractHeartBeat.
     *
     * @param groupAddress the group address
     * @param portNo the port no
     * @throws HeartBeatException the heart beat exception
     */
    public AbstractHeartBeat(final InetAddress groupAddress, final int portNo) throws HeartBeatException {
        this.groupAddress = groupAddress;
        this.portNo = portNo;
        joinGroup(this.groupAddress, this.portNo);
    }

    /**
     * Join group.
     *
     * @param groupAddressIn the group address in
     * @param portNoIn the port no in
     * @throws HeartBeatException the heart beat exception
     */
    protected void joinGroup(final InetAddress groupAddressIn, final int portNoIn) throws HeartBeatException {
        try {
            this.multicastSocket = new MulticastSocket(portNoIn);

            try {
                this.multicastSocket.setTimeToLive(MIN_PRIORITY);
                this.multicastSocket.joinGroup(groupAddressIn);
            } catch (final SocketException socketException) {
                log.error("{}", socketException.getLocalizedMessage());
                throw new HeartBeatException(socketException);
            }
        } catch (final IOException ioException) {
            log.error("{}", ioException);
            throw new HeartBeatException(ioException);
        }
    }
}
