
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
    
    /** provides logging. */
    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
    
    /** The group address. */
    protected InetAddress groupAddress;
    
    /** The port no. */
    protected int portNo;
    
    /** The multicast socket. */
    protected MulticastSocket multicastSocket;
    
    /** The exit. */
    protected boolean exit;

    /**
     * AbstractHeartBeat.
     *
     * @throws HeartBeatException the heart beat exception
     */
    public AbstractHeartBeat() throws HeartBeatException {
        super();
        portNo = 1;
        try {
            groupAddress = InetAddress.getByName("heartbeat.wicast.net");
        } catch (final UnknownHostException e) {
            log.error(e.getLocalizedMessage(), e);
            throw new HeartBeatException(e);
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
            log.error(e.getLocalizedMessage(), e);
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
            } catch (final SocketException e) {
                log.error(e.getLocalizedMessage(), e);
                throw new HeartBeatException(e);
            }
        } catch (final IOException e) {
            log.error(e.getLocalizedMessage(), e);
            throw new HeartBeatException(e);
        }
    }

    /* (non-Javadoc)
     * @see net.wicast.heartbeat.HeartBeatInterface#beat(java.lang.String)
     */
    @Override
    public abstract void beat(final String message) throws HeartBeatException;
}
