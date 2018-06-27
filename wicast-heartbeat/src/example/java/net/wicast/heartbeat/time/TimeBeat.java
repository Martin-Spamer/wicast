package net.wicast.heartbeat.time;

import java.io.IOException;
import java.net.*;

import org.slf4j.*;

import net.wicast.heartbeat.*;

/**
 * HeartBeat.
 */
public class HeartBeat extends AbstractHeartBeat {

	private static final Logger LOG  = LoggerFactory.getLogger(HeartBeat.class);

	/**
	 * AbstractHeartBeat.
	 */
	public HeartBeat(final String groupAddress, final int portNo) throws HeartBeatException {
		super(groupAddress, portNo);
	}

	/**
	 * AbstractHeartBeatMonitor.
	 */
	public HeartBeat(final InetAddress groupAddress, final int portNo) throws HeartBeatException {
		super(groupAddress, portNo);
	}

	/**
	 * Beat.
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
			} catch (final SocketException socketException) {
				log.error("{}", socketException);
				throw new HeartBeatException(socketException);
			}
		} catch (final IOException ioException) {
			log.error("{}", ioException);
			throw new HeartBeatException(ioException);
		}
	}
}
