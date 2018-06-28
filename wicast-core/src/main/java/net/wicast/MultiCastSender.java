
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
    private static final Logger LOG  = LoggerFactory.getLogger(MultiCastSender.class);   
    private String group;
    private int port;

    public MultiCastSender() {
        super();
    }

    public MultiCastSender(final String group, final int port) {
        super();
        this.group = group;
        this.port = port;
    }
        
    public boolean sendByDatagram(final byte[] output) {
        return sendByDatagramSocket(this.group, this.port, output);
    }
    
    /**
     * Send Datagram to a Multicast Group.
     * You can send to a multicast socket using either a DatagramSocket
     * address that datagram group. You only need to use datagram.
     *
     * @param group multicast group address as String "X.X.X.X".
     * @param port sending port as int.
     * @param output payload as byte array.
     * @return status as boolean result.
     */
    public boolean sendByDatagramSocket(final String group, final int port, final byte[] output) {
        boolean status = false;
        try {
            DatagramSocket socket = new DatagramSocket();
            final InetAddress groupAddr = InetAddress.getByName(group);
            final DatagramPacket packet = new DatagramPacket(output, output.length, groupAddr, port);

            socket.send(packet);

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

    public boolean sendByMulticastSocket(final byte[] output) {
        return sendByMulticastSocket(this.group, this.port,output);
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

            // final byte timeToLive = 1;
            // socket.send(packet, timeToLive);

            int ttl = socket.getTimeToLive(); 
            socket.setTimeToLive(ttl);
            socket.send(packet);
            socket.setTimeToLive(ttl);

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
