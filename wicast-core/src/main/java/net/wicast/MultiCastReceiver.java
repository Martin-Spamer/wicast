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
 * <author@wicast.net>
 *
 * @version 0.3
 * @date 01-10-2009
 */
public class MultiCastReceiver {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

	/**
	 * Instantiates a new multi cast receiver.
	 */
	public MultiCastReceiver() {
		super();
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

			log.info("Multicast Received");
			log.info("from: " + packet.getAddress().toString());
			log.info("port: " + packet.getPort());
			final int length = packet.getLength();
			log.info("length: " + length);
			final byte[] data = packet.getData();
			System.out.write(data, 0, length);

			socket.leaveGroup(InetAddress.getByName(group));
			socket.close();
			status = true;
		} catch (final SocketException socketException) {
			log.error("{}", socketException);
		} catch (final IOException ioException) {
			log.error("{}", ioException);
		} catch (final Exception exception) {
			log.error("{}", exception);
		}
		return status;
	}

}
