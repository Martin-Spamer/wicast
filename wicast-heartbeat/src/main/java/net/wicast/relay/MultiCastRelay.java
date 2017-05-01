package net.wicast.relay;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MultiCastRelay.
 *
 * @author spamerm
 * @version 0.3
 * @since 0.2
 */
public class MultiCastRelay {

	/**
	 * MultiCastReceiver, subscribe to Multicast group and receive datagrams.
	 *
	 * @author
	 * @date 01-10-2009
	 * @version 0.3
	 * @since 0.1
	 */
	public class MultiCastReceiver extends java.lang.Thread {
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

				MultiCastRelay.log.info("Multicast Received");
				MultiCastRelay.log.info("from: " + packet.getAddress().toString());
				MultiCastRelay.log.info("port: " + packet.getPort());
				MultiCastRelay.log.info("length: " + packet.getLength());
				System.out.write(packet.getData(), 0, packet.getLength());

				// And when we have finished receiving data leave the multicast
				// group and
				// close the socket
				socket.leaveGroup(InetAddress.getByName(group));
				socket.close();
				status = true;
			} catch (final SocketException socketException) {
				socketException.printStackTrace(System.err);
			} catch (final IOException ioException) {
				ioException.printStackTrace(System.err);
			} catch (final Exception exception) {
				exception.printStackTrace(System.err);
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
			}
		}
	}

	/**
	 * MultiCastSender, send datagrams to Multicast group.
	 *
	 * @author
	 * @date 01-10-2009
	 * @version 0.3
	 * @since 0.1
	 */
	public class MultiCastSender extends java.lang.Thread {

		/**
		 * Creates a new instance of MultiCasterSender.
		 */
		public MultiCastSender() {
		}

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
			}
		}

		/**
		 * Sending to a Multicast Group. You can send to a multicast socket
		 * using either a DatagramSocket or a MulticastSocket. What makes it
		 * multicast is the address that is in the datagram. If the address is a
		 * multicast address, the datagram will reach the multicast members in
		 * the group. You only need to use MulticastSocket if you want to
		 * control the time-to-live of the datagram.
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
				socketException.printStackTrace(System.err);
			} catch (final IOException ioException) {
				ioException.printStackTrace(System.err);
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
				//
				final int timeToLive = 1;
				final MulticastSocket socket = new MulticastSocket();
				final DatagramPacket packet = new DatagramPacket(output, output.length, InetAddress.getByName(group),
				        port);
				socket.send(packet, (byte) timeToLive);
				socket.close();
				status = true;
			} catch (final SocketException socketException) {
				socketException.printStackTrace(System.err);
			} catch (final IOException ioException) {
				ioException.printStackTrace(System.err);
			} catch (final Exception exception) {
				exception.printStackTrace(System.err);
			}
			return status;
		}
	}

	private static final Logger log = LoggerFactory.getLogger(MultiCastRelay.class);

	/**
	 * main entry point for this class.
	 *
	 * @param args the command line arguments
	 */
	public static void main(final String[] args) {
		MultiCastRelay.log.trace(System.getProperties().toString());

		new MultiCastRelay();
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
