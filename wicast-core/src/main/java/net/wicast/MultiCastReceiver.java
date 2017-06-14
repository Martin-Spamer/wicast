
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

	private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

	/**
	 * Instantiates a new multi cast receiver.
	 */
	public MultiCastReceiver() {
		super();
	}

	/**
	 * Creates a new instance of MultiCastReceiver.
	 */
	public MultiCastReceiver(final String[] args) {
		this();
		this.log.trace(System.getProperties().toString());
		this.log.debug("args[]={}", Arrays.toString(args));
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

	/**
	 * main entry point for this class.
	 *
	* command line arguments
	 */
	public static void main(final String[] args) {
		final MultiCastReceiver multiCastReceiver = new MultiCastReceiver(args);
	}
}
