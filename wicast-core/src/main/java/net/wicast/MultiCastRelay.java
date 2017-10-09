
package net.wicast;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;

import org.slf4j.*;

/**
 * MultiCast Relay.
 */
public class MultiCastRelay {

	private static final Logger log = LoggerFactory.getLogger(MultiCastRelay.class);

	/**
	 * MultiCastReceiverThread class.
	 */
	public class MultiCastReceiverThread extends java.lang.Thread {
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
				// * socket and bind it to port 'port'.
				final MulticastSocket socket = new MulticastSocket(port);

				// * multicast group
				socket.joinGroup(InetAddress.getByName(group));

				// * socket is set up and we are ready to receive packets
				// Create a DatagramPacket and do a receive
				final byte input[] = new byte[1024];
				final DatagramPacket packet = new DatagramPacket(input, input.length);
				socket.receive(packet);

				MultiCastRelay.log.info("Multicast Received");
				MultiCastRelay.log.info("from: " + packet.getAddress().toString());
				MultiCastRelay.log.info("port: " + packet.getPort());
				MultiCastRelay.log.info("length: " + packet.getLength());

				System.out.write(packet.getData(), 0, packet.getLength());

				socket.leaveGroup(InetAddress.getByName(group));
				socket.close();
				status = true;
			} catch (final SocketException socketException) {
				MultiCastRelay.log.error("{}", socketException);
			} catch (final IOException ioException) {
				MultiCastRelay.log.error("{}", ioException);
			} catch (final Exception exception) {
				MultiCastRelay.log.error("{}", exception);
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
				MultiCastRelay.log.error("{}", exception);
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
				MultiCastRelay.log.error("{}", socketException);
			} catch (final IOException ioException) {
				MultiCastRelay.log.error("{}", ioException);
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
				MultiCastRelay.log.error("{}", socketException);
			} catch (final IOException ioException) {
				MultiCastRelay.log.error("{}", ioException);
			} catch (final Exception exception) {
				MultiCastRelay.log.error("{}", exception);
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
		MultiCastRelay.log.trace(System.getProperties().toString());
		MultiCastRelay.log.debug("args[]={}", Arrays.toString(args));

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
