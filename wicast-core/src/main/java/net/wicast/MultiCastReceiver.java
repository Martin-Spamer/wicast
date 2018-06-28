
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
    private static final Logger LOG  = LoggerFactory.getLogger(MultiCastReceiver.class);
    private String group;
    private int port;

    public MultiCastReceiver() {
        super();
    }

    public MultiCastReceiver(String group, int port) {
        super();
        this.group = group;
        this.port = port;
    }

    public boolean receiveByMulticastSocket() {
        return receiveByMulticastSocket(this.group, this.port);
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
            LOG.debug("from: {}", packet.getAddress().toString());
            LOG.debug("port: {}", packet.getPort());
            final int length = packet.getLength();
            LOG.debug("length: {}", length);
            final byte[] data = packet.getData();
            LOG.trace("data = {}", new String(data));

            socket.leaveGroup(InetAddress.getByName(group));
            socket.close();
            status = true;
        } catch (final SocketException socketException) {
            LOG.error(socketException.getLocalizedMessage());
        } catch (final IOException ioException) {
            LOG.error(ioException.getLocalizedMessage());
        } catch (final Exception exception) {
            LOG.error(exception.toString());
        }
        return status;
    }

}
