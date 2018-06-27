
package net.wicast.relay;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;

/**
 * MultiCastRelay.
 *
 * @author spamerm
 * @date 01-10-2009
 * @version 0.3
 * @since 0.1
 */
public class MultiCastRelay {

    private static final Logger LOG  = LoggerFactory.getLogger(MultiCastRelay.class);

    /**
     * MultiCastReceiver, subscribe to Multicast group and receive datagrams.
     */
    public class MultiCastReceiver extends Thread {
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
                // socket and bind it to port 'port'.
                final MulticastSocket socket = new MulticastSocket(port);

                // multicast group
                socket.joinGroup(InetAddress.getByName(group));

                // socket is set up and we are ready to receive packets
                // Create a DatagramPacket and do a receive
                final byte input[] = new byte[1024];
                final DatagramPacket packet = new DatagramPacket(input, input.length);
                socket.receive(packet);

                LOG.debug("Multicast Received");
                LOG.debug("from: " + packet.getAddress().toString());
                LOG.debug("port: " + packet.getPort());
                LOG.debug("length: " + packet.getLength());

                // TODO Something about this
                System.out.write(packet.getData(), 0, packet.getLength());

                /* multicast group and socket */
                socket.leaveGroup(InetAddress.getByName(group));
                socket.close();
                status = true;
            } catch (final SocketException exception) {
                LOG.error("{}", exception);
            } catch (final IOException exception) {
                LOG.info("{}", exception);
            } catch (final Exception exception) {
                LOG.info("{}", exception);
            }
            return status;
        }

        /**
         * @see java.lang.Thread#run()
         */
        @Override
        public void run() {
            super.run();

            try {
                while (true) {
                    receiveByMulticastSocket("228.1.2.3", 1234);
                    sleep(1000);
                }
            } catch (final InterruptedException exception) {
                LOG.error("{}", exception);
            }
        }
    }

    /**
     * MultiCastSender, send datagrams to Multicast group.
     */
    public class MultiCastSender extends Thread {
        /**
         * @see java.lang.Thread#run()
         */
        @Override
        public void run() {
            int count = 1;
            super.run();

            try {
                while (true) {
                    final String message = String.format("<WICAST type=%d/>", count);
                    sendByDatagramSocket("228.1.2.3", 1234, message.getBytes());
                    sleep(1000);
                    count++;
                }
            } catch (final InterruptedException exception) {
                LOG.error("{}", exception);
            }
        }

        /**
         * Sending to a Multicast Group. You can send to a multicast socket
         * using either a DatagramSocket or a MulticastSocket. What makes it
         * address is a multicast members in group. You only need to use
         * MulticastSocket if you want to datagram.
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
            } catch (final SocketException exception) {
                LOG.error("{}", exception);
            } catch (final IOException exception) {
                LOG.error("{}", exception);
            }
            return status;
        }

        /**
         * Send Datagram to Multicast Group by Socket.
         * 
         * @return boolean
         */
        public boolean sendByMulticastSocket(final String group, final int port, final byte[] output) {
            boolean status = false;
            try {
                //
                final int timeToLive = 1;
                final MulticastSocket socket = new MulticastSocket();
                final InetAddress byName = InetAddress.getByName(group);
                final DatagramPacket packet = new DatagramPacket(output, output.length, byName, port);
                socket.send(packet, (byte) timeToLive);
                socket.close();
                status = true;
            } catch (final SocketException exception) {
                LOG.error("{}", exception);
            } catch (final IOException exception) {
                LOG.info("{}", exception);
            } catch (final Exception exception) {
                LOG.info("{}", exception);
            }
            return status;
        }
    }

    /**
     * main entry point for this class.
     *
     * command line arguments
     */
    public static void main(final String[] args) {
        LOG.trace(System.getProperties().toString());
        final MultiCastRelay multiCastRelay = new MultiCastRelay();
        assertNotNull("Value cannot be null", multiCastRelay);
    }

    /**
     * Creates a new instance of MultiCastReceiver.
     */
    public MultiCastRelay() {
        final MultiCastReceiver multiCastReceiver = new MultiCastReceiver();
        multiCastReceiver.start();

        final MultiCastSender multiCastSender = new MultiCastSender();
        multiCastSender.start();
    }

}
