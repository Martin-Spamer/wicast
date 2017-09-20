
package net.wicast.heartbeat;

import java.io.IOException;
import java.net.*;

/**
 * AbstractHeartBeatMonitor.
 */
public class AbstractHeartBeatMonitor extends AbstractHeartBeat {

	/**
	 * AbstractHeartBeatMonitor.
	 *
	 * @param groupAddress the group address
	 * @param portNo the port no
	 * @throws HeartBeatException the heart beat exception
	 */
	public AbstractHeartBeatMonitor(final InetAddress groupAddress, final int portNo) throws HeartBeatException {
		super(groupAddress, portNo);
	}

	/**
	 * AbstractHeartBeat.
	 *
	 * @param groupAddress the group address
	 * @param portNo the port no
	 * @throws HeartBeatException the heart beat exception
	 */
	public AbstractHeartBeatMonitor(final String groupAddress, final int portNo) throws HeartBeatException {
		super(groupAddress, portNo);
	}

	/**
	 * Beat.
	 *
	 * @param message the message
	 * @throws HeartBeatException the heart beat exception
	 * @see net.wicast.heartbeat.HeartBeatInterface#beat(java.lang.String)
	 */
	@Override
	public void beat(final String message) throws HeartBeatException {
		try {
			try {
				this.multicastSocket.joinGroup(this.groupAddress);

				final DatagramPacket outBoundDatagramPacket = new DatagramPacket(message.getBytes(), message.length(),
				        this.groupAddress, this.portNo);

				this.multicastSocket.send(outBoundDatagramPacket);
			} catch (final SocketException exception) {
				log.error("{}", exception);
				throw new HeartBeatException(exception);
			}
		} catch (final IOException exception) {
			log.error("{}", exception);
			throw new HeartBeatException(exception);
		}
	}

	/**
	 * Monitor.
	 * @throws HeartBeatException the heart beat exception
	 */
	protected void monitor() throws HeartBeatException {
		try {
			this.multicastSocket = new MulticastSocket(this.portNo);
			final byte[] buffer = new byte[1000];
			final DatagramPacket inboundDatagramPacket = new DatagramPacket(buffer, buffer.length);
			this.multicastSocket.receive(inboundDatagramPacket);
			this.multicastSocket.leaveGroup(this.groupAddress);
		} catch (final IOException exception) {
			log.error("{}", exception);
			throw new HeartBeatException(exception);
		}
	}
}
