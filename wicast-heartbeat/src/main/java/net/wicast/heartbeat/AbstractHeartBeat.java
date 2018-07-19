
package net.wicast.heartbeat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AbstractHeartBeat class.
 */
public abstract class AbstractHeartBeat extends Thread implements HeartBeatInterface {
    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
    protected InetAddress groupAddress;
    protected int portNo;
    protected MulticastSocket multicastSocket;
    protected boolean exit;

    /**
     * AbstractHeartBeat.
     */
    public AbstractHeartBeat() {
        super();
        portNo = 1;
        try {
            groupAddress = InetAddress.getByName("wicast.net");
        } catch (final UnknownHostException e) {
            log.error(e.toString());
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
        super();
        this.groupAddress = groupAddress;
        this.portNo = portNo;
        joinGroup(this.groupAddress, this.portNo);
    }

    /**
     * AbstractHeartBeat.
     *
     * @param groupAddressString the group address string
     * @param portNo the port no
     * @throws HeartBeatException the heart beat exception
     */
    public AbstractHeartBeat(final String groupAddressString, final int portNo) throws HeartBeatException {
        super();
        try {
            groupAddress = InetAddress.getByName(groupAddressString);
            this.portNo = portNo;
            joinGroup(groupAddress, this.portNo);
        } catch (final UnknownHostException e) {
            log.error(e.getLocalizedMessage());
            throw new HeartBeatException(e);
        }
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
            multicastSocket = new MulticastSocket(portNoIn);

            try {
                multicastSocket.setTimeToLive(Thread.MIN_PRIORITY);
                multicastSocket.joinGroup(groupAddressIn);
            } catch (final SocketException exception) {
                log.error(exception.getLocalizedMessage());
                throw new HeartBeatException(exception);
            }
        } catch (final IOException e) {
            log.error(e.getLocalizedMessage());
            throw new HeartBeatException(e);
        }
    }

    @Override
    public abstract void beat(final String message) throws HeartBeatException;
}
