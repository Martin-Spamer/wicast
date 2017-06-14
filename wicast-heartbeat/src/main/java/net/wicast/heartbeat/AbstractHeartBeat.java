/**
 * This file is part of Automated Testing Framework for Java (atf4j).
 *
 * Atf4j is free software: you can redistribute it and/or modify
 * GNU General Public License as published by
 * License, or
 * (at your option) any later version.
 *
 * hope that it will be useful,
 * implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * GNU General Public License
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

 */
public abstract class AbstractHeartBeat extends Thread implements IHeartBeat {

    private static final Logger log = LoggerFactory.getLogger(AbstractHeartBeat.class);
    protected final InetAddress groupAddress;
    protected final int portNo;
    protected MulticastSocket multicastSocket;

    /**
     * AbstractHeartBeat.
     *
 * group address
 * port no
 * heart beat exception
     */
    public AbstractHeartBeat(final InetAddress groupAddress, final int portNo) throws HeartBeatException {
        this.groupAddress = groupAddress;
        this.portNo = portNo;
        joinGroup(this.groupAddress, this.portNo);
    }

    /**
     * AbstractHeartBeat.
     *
 * group address string
 * port no
 * heart beat exception
     */
    public AbstractHeartBeat(final String groupAddressString, final int portNo) throws HeartBeatException {
        try {
            groupAddress = InetAddress.getByName(groupAddressString);
            this.portNo = portNo;
            joinGroup(groupAddress, this.portNo);
        } catch (final UnknownHostException unknownHostException) {
            AbstractHeartBeat.log.error("{}", unknownHostException);
            throw new HeartBeatException(unknownHostException);
        }
    }

    /**
     * Join group.
     *
 * group address in
 * port no in
 * heart beat exception
     */
    protected void joinGroup(final InetAddress groupAddressIn, final int portNoIn) throws HeartBeatException {
        try {
            multicastSocket = new MulticastSocket(portNoIn);

            try {
                multicastSocket.setTimeToLive(Thread.MIN_PRIORITY);
                multicastSocket.joinGroup(groupAddressIn);
            } catch (final SocketException socketException) {
                AbstractHeartBeat.log.error("{}", socketException.getLocalizedMessage());
                throw new HeartBeatException(socketException);
            }
        } catch (final IOException ioException) {
            AbstractHeartBeat.log.error("{}", ioException);
            throw new HeartBeatException(ioException);
        }
    }
}
