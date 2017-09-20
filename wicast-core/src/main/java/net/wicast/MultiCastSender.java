
package net.wicast;

import java.io.IOException;
import java.net.*;

import org.slf4j.*;

/**
 * MultiCastSender, send datagrams to Multicast group.
 */
public class MultiCastSender {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

	/**
	 * Sending to a Multicast Group.
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
			final DatagramSocket socket = new DatagramSocket();
			final InetAddress groupAddr = InetAddress.getByName(group);
			final DatagramPacket packet = new DatagramPacket(output, output.length, groupAddr, port);
			socket.send(packet);
			socket.close();
			status = true;
		} catch (final SocketException socketException) {
			this.log.error("{}", socketException);
		} catch (final IOException ioException) {
			this.log.error("{}", ioException);
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
			final int timeToLive = 1;
			final MulticastSocket socket = new MulticastSocket();
			final DatagramPacket packet = new DatagramPacket(output, output.length, InetAddress.getByName(group), port);
			socket.send(packet, (byte) timeToLive);
			socket.close();
			status = true;
		} catch (final SocketException socketException) {
			this.log.error("{}", socketException);
		} catch (final IOException ioException) {
			this.log.error("{}", ioException);
		} catch (final Exception exception) {
			this.log.error("{}", exception);
		}
		return status;
	}
}
