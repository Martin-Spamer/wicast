package net.wicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MultiCastReceiver, subscribe to Multicast group and receive datagrams.
 * <author@wicast.net>
 *
 * @version 0.3
 * @date 01-10-2009
 */
public class MultiCastReceiver {

    private static final Logger log = LoggerFactory.getLogger(MultiCastReceiver.class);

    /**
     * main entry point for this class.
     *
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        MultiCastReceiver.log.trace(System.getProperties().toString());
        MultiCastReceiver.log.debug("args[]={}", Arrays.toString(args));

        final MultiCastReceiver multiCastReceiver = new MultiCastReceiver();
        MultiCastReceiver.log.debug("{}", multiCastReceiver.receiveByMulticastSocket("228.1.2.3", 1234));
        MultiCastReceiver.log.debug("{}", multiCastReceiver.receiveByMulticastSocket("228.1.2.3", 1234));
    }

    /**
     * Creates a new instance of MultiCastReceiver.
     */
    public MultiCastReceiver() {
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
            // Create the socket and bind it to port 'port'.
            final MulticastSocket socket = new MulticastSocket(port);

            // join the multicast group
            socket.joinGroup(InetAddress.getByName(group));

            // Now the socket is set up and we are ready to receive packets
            // Create a DatagramPacket and do a receive
            final byte input[] = new byte[1024];
            final DatagramPacket packet = new DatagramPacket(input, input.length);
            socket.receive(packet);

            MultiCastReceiver.log.info("Multicast Received");
            MultiCastReceiver.log.info("from: " + packet.getAddress().toString());
            MultiCastReceiver.log.info("port: " + packet.getPort());
            final int length = packet.getLength();
            MultiCastReceiver.log.info("length: " + length);
            final byte[] data = packet.getData();
            System.out.write(data, 0, length);

            // And when we have finished receiving data leave the multicast
            // group and
            // close the socket
            socket.leaveGroup(InetAddress.getByName(group));
            socket.close();
            status = true;
        } catch (final SocketException socketException) {
            MultiCastReceiver.log.error("{}", socketException);
        } catch (final IOException ioException) {
            MultiCastReceiver.log.error("{}", ioException);
        } catch (final Exception exception) {
            MultiCastReceiver.log.error("{}", exception);
        }
        return status;
    }
}
