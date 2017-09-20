
package net.wicast;

import java.io.IOException;
import java.net.*;

import org.slf4j.*;

/**
 * MultiCastReceiver, subscribe to Multicast group and receive datagrams.
 */
public class MultiCastReceiver {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

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

			this.log.info("Multicast Received");
			this.log.info("from: " + packet.getAddress().toString());
			this.log.info("port: " + packet.getPort());
			final int length = packet.getLength();
			this.log.info("length: " + length);
			final byte[] data = packet.getData();
			System.out.write(data, 0, length);

			socket.leaveGroup(InetAddress.getByName(group));
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
