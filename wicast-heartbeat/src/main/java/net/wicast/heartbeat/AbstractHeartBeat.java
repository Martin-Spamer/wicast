
package net.wicast.heartbeat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.wicast.MulticastBase;
import net.wicast.WiCastConfig;

/**
 * An abstract HeartBeat class.
 */
public abstract class AbstractHeartBeat extends MulticastBase {

    private static final String HEARTBEAT_WICAST_NET = "heartbeat.wicast.net";

    /** provides logging. */
    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    /** The group address. */
    protected InetAddress groupAddress;

    /** The port no. */
    protected int port;

    /** The multicast socket. */
    protected MulticastSocket multicastSocket;

    /** The exit. */
    protected boolean exit;

    /**
     * AbstractHeartBeat.
     *
     * @throws HeartBeatException the heart beat exception
     */
    public AbstractHeartBeat() {
        super();
    }

    public AbstractHeartBeat(final WiCastConfig config) {
        super(config);
    }

    /**
     * AbstractHeartBeat.
     *
     * @param groupAddress the group address
     * @param portNo the port no
     * @throws HeartBeatException the heart beat exception
     */
    public AbstractHeartBeat(final InetAddress groupAddress, final int portNo) throws HeartBeatException {
        super(groupAddress, portNo);
    }

    /**
     * AbstractHeartBeat.
     *
     * @param group the group address string
     * @param portNo the port no
     * @throws HeartBeatException the heart beat exception
     */
    public AbstractHeartBeat(final String group, final int portNo) throws HeartBeatException {
        super();
        try {
            port = portNo;
            groupAddress = InetAddress.getByName(group);
            initialise(groupAddress, portNo);
        } catch (final UnknownHostException e) {
            log.error(e.getLocalizedMessage(), e);
            throw new HeartBeatException(e);
        }
    }

    private void initialise(final InetAddress groupAddress, final int portNo) throws HeartBeatException {
        this.groupAddress = groupAddress;
        port = portNo;
        joinGroup(this.groupAddress, port);
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
            multicastSocket.setTimeToLive(Thread.MIN_PRIORITY);
            multicastSocket.joinGroup(groupAddressIn);
        } catch (IOException e) {
            log.error(e.getLocalizedMessage(), e);
            throw new HeartBeatException(e);
        }
    }

    public abstract void beat(final String message) throws HeartBeatException;
}
