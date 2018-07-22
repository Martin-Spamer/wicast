
package net.wicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MultiCastSender, send datagrams to Multicast group.
 */
public final class MultiCastSender extends MulticastBase {

    /** provide logging. */
    static final Logger LOG = LoggerFactory.getLogger(MultiCastSender.class);

    /**
     * Default Constructor.
     */
    public MultiCastSender() {
        super();
    }

    /**
     * Constructor taking a configuration.
     *
     * @param config the config
     */
    public MultiCastSender(final WiCastConfig config) {
        super(config);
    }

    /**
     * Instantiates a new multi cast sender.
     *
     * @param group the group
     * @param port the port
     */
    public MultiCastSender(final String group, final String port) {
        super(group, port);
    }

    /**
     * Send by datagram.
     *
     * @param output the output
     * @return true, if send by datagram
     */
    public boolean sendByDatagram(final byte[] output) {
        return sendByDatagramSocket(groupAddress, portNo, output);
    }

    /**
     * Send by datagram socket.
     *
     * @param group the group
     * @param port the port
     * @param output the output
     * @return true, if successful
     */
    public boolean sendByDatagramSocket(final String group, final String port, final byte[] output) {
        try {
            final int portNo = Integer.parseInt(port);
            final InetAddress groupAddr = InetAddress.getByName(group);
            return sendByDatagramSocket(groupAddr, portNo, output);
        } catch (NumberFormatException | UnknownHostException e) {
            LOG.error(e.getLocalizedMessage(), e);
        }
        return false;
    }

    /**
     * Send by datagram socket.
     *
     * @param groupAddr the group addr
     * @param port the port
     * @param output the output
     * @return true, if successful
     */
    protected boolean sendByDatagramSocket(final InetAddress groupAddr, final int port, final byte[] output) {
        boolean status = false;
        try {
            final DatagramSocket socket = new DatagramSocket();
            final DatagramPacket packet = new DatagramPacket(output, output.length, groupAddr, port);

            try {
                socket.send(packet);
                socket.close();
                status = true;
            } catch (final IOException e) {
                LOG.error(e.getLocalizedMessage(), e);
            }
        } catch (final SocketException e) {
            LOG.error(e.getLocalizedMessage(), e);
        }
        return status;
    }

    /**
     * Send by multicast socket.
     *
     * @param output the output
     * @return true, if successful
     */
    public boolean sendByMulticastSocket(final byte[] output) {
        return sendByMulticastSocket(groupAddress, portNo, output);
    }

    /**
     * Send by multicast socket.
     *
     * @param group the group
     * @param port the port
     * @param output the output
     * @return true, if successful
     */
    public boolean sendByMulticastSocket(final String group, final String port, final byte[] output) {
        try {
            int portNo = Integer.parseInt(port);
            final InetAddress groupAddr = InetAddress.getByName(group);
            return sendByMulticastSocket(groupAddr, portNo, output);
        } catch (NumberFormatException | UnknownHostException e) {
            LOG.error(e.getLocalizedMessage(), e);
        }
        return false;
    }

    /**
     * Send by multicast socket.
     *
     * @param groupAddr the group addr
     * @param portNo the port
     * @param output the output
     * @return true, if successful
     */
    protected boolean sendByMulticastSocket(final InetAddress groupAddr, final int portNo, final byte[] output) {
        boolean status = false;
        try {
            final MulticastSocket socket = new MulticastSocket();
            final DatagramPacket packet = new DatagramPacket(output, output.length, groupAddr, portNo);

            final int ttl = socket.getTimeToLive();
            socket.setTimeToLive(ttl);
            socket.send(packet);
            socket.setTimeToLive(ttl);

            socket.close();
            status = true;
        } catch (final IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
        }
        return status;
    }

}
