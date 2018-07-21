
package net.wicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MultiCastSender, send datagrams to Multicast group.
 */
public final class MultiCastSender {

    /** provide logging. */
    private static final Logger LOG = LoggerFactory.getLogger(MultiCastSender.class);

    /** constant configuration. */
    private WiCastConfig config = new ReceiverConfig();

    /** multicast group address . */
    private final String group;
    private InetAddress groupAddress;

    /** multicast port. */
    private final int port;

    /**
     * Default Constructor.
     */
    public MultiCastSender() {
        super();
        group = config.getGroup();
        port = config.getPort();
    }

    /**
     * Constructor taking a configuration.
     *
     * @param config the config
     */
    public MultiCastSender(final WiCastConfig config) {
        super();
        this.config = config;
        group = config.getGroup();
        port = config.getPort();
    }

    /**
     * Constructor.
     *
     * @param group the group
     * @param port the port
     */
    public MultiCastSender(final String group, final int port) {
        super();
        this.group = group;
        this.port = port;
    }

    /**
     * Send by datagram.
     *
     * @param output the output
     * @return true, if send by datagram
     */
    public boolean sendByDatagram(final byte[] output) {
        return sendByDatagramSocket(group, port, output);
    }

    /**
     * Sends a message to a <code>Multicast</code> Group.
     *
     * Sends using a <code>Datagram</code> to a <code>Multicast</code> Group.
     *
     * @param group multicast group address as String "X.X.X.X".
     * @param port sending port as int.
     * @param output payload as byte array.
     * @return status as boolean result.
     */
    public boolean sendByDatagramSocket(final String group, final int port, final byte[] output) {
        boolean status = false;
        try {
            final DatagramSocket socket = new DatagramSocket();
            final InetAddress groupAddr = InetAddress.getByName(group);
            final DatagramPacket packet = new DatagramPacket(output, output.length, groupAddr, port);

            socket.send(packet);

            socket.close();
            status = true;
        } catch (final SocketException e) {
            LOG.error(e.getLocalizedMessage(), e);
        } catch (final IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
        } catch (final Exception e) {
            LOG.error(e.getLocalizedMessage(), e);
        }
        return status;
    }

    public boolean sendByDatagramSocket(final InetAddress groupAddr, final int port, final byte[] output) {
        boolean status = false;
        try {
            final DatagramSocket socket = new DatagramSocket();
            final DatagramPacket packet = new DatagramPacket(output, output.length, groupAddr, port);

            socket.send(packet);

            socket.close();
            status = true;
        } catch (final SocketException e) {
            LOG.error(e.getLocalizedMessage(), e);
        } catch (final IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
        } catch (final Exception e) {
            LOG.error(e.getLocalizedMessage(), e);
        }
        return status;
    }

    /**
     * Send Datagram to Multicast Group by Socket.
     *
     * @param group the group
     * @param port the port
     * @param output the output
     * @return boolean
     */
    public boolean sendByMulticastSocket(final String group, final int port, final byte[] output) {
        boolean status = false;
        try {
            final MulticastSocket socket = new MulticastSocket();
            final DatagramPacket packet = new DatagramPacket(output, output.length, InetAddress.getByName(group), port);

            final int ttl = socket.getTimeToLive();
            socket.setTimeToLive(ttl);
            socket.send(packet);
            socket.setTimeToLive(ttl);

            socket.close();
            status = true;
        } catch (final SocketException e) {
            LOG.error(e.getLocalizedMessage(), e);
        } catch (final IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
        } catch (final Exception e) {
            LOG.error(e.getLocalizedMessage(), e);
        }
        return status;
    }

    public boolean sendByMulticastSocket(final byte[] output) {
        return sendByMulticastSocket(groupAddress, port, output);
    }

    public boolean sendByMulticastSocket(final InetAddress groupAddr, final int port, final byte[] output) {
        boolean status = false;
        try {
            final MulticastSocket socket = new MulticastSocket();
            InetAddress byName = InetAddress.getByName(group);
            final DatagramPacket packet = new DatagramPacket(output, output.length, groupAddr, port);

            final int ttl = socket.getTimeToLive();
            socket.setTimeToLive(ttl);
            socket.send(packet);
            socket.setTimeToLive(ttl);

            socket.close();
            status = true;
        } catch (final SocketException e) {
            LOG.error(e.getLocalizedMessage(), e);
        } catch (final IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
        } catch (final Exception e) {
            LOG.error(e.getLocalizedMessage(), e);
        }
        return status;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String
            .format("%s [group=%s, port=%s, config=%s]",
                    this.getClass().getSimpleName(),
                    group,
                    port,
                    config);
    }

}
