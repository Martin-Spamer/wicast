
package net.wicast.heartbeat;

import java.io.IOException;
import java.net.*;

/**
 * HeartBeat.
 */
public class HeartBeat extends AbstractHeartBeat {

	/**
	 * HeartBeat.
	 *
	 * @param groupAddress the group address
	 * @param portNo the port no
	 * @throws HeartBeatException the heart beat exception
	 */
	public HeartBeat(final InetAddress groupAddress, final int portNo) throws HeartBeatException {
		super(groupAddress, portNo);
	}

	/**
	 * HeartBeat.
	 *
	 * @param groupAddress the group address
	 * @param portNo the port no
	 * @throws HeartBeatException the heart beat exception
	 */
	public HeartBeat(final String groupAddress, final int portNo) throws HeartBeatException {
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
	 * Run.
	 *
	 * @see java.lang.Runnable#run()
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		final TimeStamp timeStamp = new TimeStamp();
		try {
			beat(timeStamp.toString() + "-" + this.getClass().toString());
		} catch (final HeartBeatException exception) {
			log.error("{}", exception);
			this.stop();
		}
	}
}
