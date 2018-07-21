
package net.wicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MultiCastReceiver, subscribe to Multicast group and receive datagrams.
 */
public final class MultiCastReceiver {

    /** provide logging. */
    private static final Logger LOG = LoggerFactory.getLogger(MultiCastReceiver.class);

    /** constant configuration. */
    private WiCastConfig config = new ReceiverConfig();

    /** multicast group address . */
    private final String group;
    private InetAddress groupAddress;

    /** multicast port. */
    private final int port;

    /**
     * Instantiates a new multi cast receiver.
     */
    public MultiCastReceiver() {
        super();
        group = config.getGroup();
        port = config.getPort();
    }

    /**
     * Instantiates a new multi cast receiver.
     *
     * @param config the config
     */
    public MultiCastReceiver(final WiCastConfig config) {
        super();
        this.config = config;
        group = this.config.getGroup();
        port = this.config.getPort();
    }

    /**
     * Instantiates a new multi cast receiver.
     *
     * @param group the group
     * @param port the port
     */
    public MultiCastReceiver(final String group, final int port) {
        super();
        this.group = group;
        this.port = port;
    }

    /**
     * Receive by multicast socket.
     *
     * @return true, if successful
     */
    public boolean receiveByMulticastSocket() {
        return receiveByMulticastSocket(group, port);
    }

    public boolean receiveByMulticastSocket(final String group, final String port) {
        return receiveByMulticastSocket(group, Integer.parseInt(port));
    }

    /**
     * receive datagrams by joining a multicast socket.
     *
     * @param group multicast group address as String "X.X.X.X".
     * @param port receiver port as int.
     * @return status as boolean result.
     */
    public boolean receiveByMulticastSocket(final String group, final int port) {
        boolean status = false;

        try {
            final MulticastSocket socket = new MulticastSocket(port);
            socket.joinGroup(InetAddress.getByName(group));

            // Create a DatagramPacket and do a receive
            final byte input[] = new byte[1024];
            final DatagramPacket packet = new DatagramPacket(input, input.length);
            socket.receive(packet);

            LOG.debug("Multicast Received");
            LOG.debug("from: {}", packet.getAddress());
            LOG.debug("port: {}", packet.getPort());
            final int length = packet.getLength();
            LOG.debug("length: {}", length);
            final byte[] data = packet.getData();
            LOG.trace("data = {}", data);

            socket.leaveGroup(InetAddress.getByName(group));
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

    public boolean receiveByMulticastSocket(final InetAddress groupAddress, final int port) {
        boolean status = false;

        try {
            final MulticastSocket socket = new MulticastSocket(port);
            socket.joinGroup(groupAddress);

            // Create a DatagramPacket and do a receive
            final byte input[] = new byte[1024];
            final DatagramPacket packet = new DatagramPacket(input, input.length);
            socket.receive(packet);

            LOG.debug("Multicast Received");
            LOG.debug("from: {}", packet.getAddress());
            LOG.debug("port: {}", packet.getPort());
            final int length = packet.getLength();
            LOG.debug("length: {}", length);
            final byte[] data = packet.getData();
            LOG.trace("data = {}", data);

            socket.leaveGroup(groupAddress);
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
