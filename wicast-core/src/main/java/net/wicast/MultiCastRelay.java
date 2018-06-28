
package net.wicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MultiCast Relay.
 */
public final class MultiCastRelay {

    /** provide logging. */
    private static final Logger LOG  = LoggerFactory.getLogger(MultiCastRelay.class);

    /**
     * MultiCastReceiverThread class.
     */
    public class MultiCastReceiverThread extends Thread {
        /**
         * A persistent threat to receive datagrams by joining a multicast socket.
         *
         * @param group multicast group address as String "X.X.X.X".
         * @param port receiver port as int.
         * @return status as boolean result.
         */
        public boolean receiveByMulticastSocket(final String group, final int port) {
            boolean status = false;

            try {
                // * socket and bind it to port 'port'.
                final MulticastSocket socket = new MulticastSocket(port);

                // * multicast group
                socket.joinGroup(InetAddress.getByName(group));

                // * socket is set up and we are ready to receive packets
                // Create a DatagramPacket and do a receive
                final byte input[] = new byte[1024];
                final DatagramPacket packet = new DatagramPacket(input, input.length);
                socket.receive(packet);

                LOG.debug("Multicast Received");
                LOG.debug("from: {}", packet.getAddress().toString());
                LOG.debug("port: {}", packet.getPort());
                LOG.debug("length: {}", packet.getLength());

                // TODO something with this
                System.out.write(packet.getData(), 0, packet.getLength());

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

        /*
         * (non-Javadoc)
         *
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
                LOG.error(exception.getLocalizedMessage());
            }
        }
    }

    /**
     * class MultiCastSenderThread.
     */
    public class MultiCastSenderThread extends java.lang.Thread {
        /*
         * (non-Javadoc)
         *
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
                LOG.error(exception.getLocalizedMessage());
            } catch (final Exception exception) {
                LOG.error(exception.toString());
            }
        }

        /**
         * Sending to a Multicast Group.
         *
         * You can send to a multicast socket using either a DatagramSocket
         * or a MulticastSocket. The address must be a multicast group. You
         * only need to use MulticastSocket if you want to datagram.
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
            } catch (final SocketException socketException) {
                LOG.error(socketException.getLocalizedMessage());
            } catch (final IOException ioException) {
                LOG.error(ioException.getLocalizedMessage());
            } catch (final Exception exception) {
                LOG.error(exception.toString());
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
                final DatagramPacket packet = new DatagramPacket(
                        output, 
                        output.length, 
                        InetAddress.getByName(group),
                        port);

                // final int timeToLive = 1;
                // socket.send(packet, (byte) timeToLive);

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

    /**
     * main entry point for this class.
     *
     * command line arguments
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        LOG.trace(System.getProperties().toString());
        LOG.debug("args[] = {}", Arrays.toString(args));

        new MultiCastRelay().start();
    }

    /**
     * Start.
     */
    public void start() {
        final MultiCastReceiverThread multiCastReceiver = new MultiCastReceiverThread();
        multiCastReceiver.start();

        final MultiCastSenderThread multiCastSender = new MultiCastSenderThread();
        multiCastSender.start();
    }

}
