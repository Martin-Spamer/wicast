package net.wicast.heartbeat.time;

import java.io.IOException;
import java.net.*;

import org.slf4j.*;

import net.wicast.heartbeat.*;

/**
 * HeartBeat.
 */
public final class HeartBeat extends AbstractHeartBeat {

	private static final Logger LOG  = LoggerFactory.getLogger(HeartBeat.class);

	public HeartBeat(final String groupAddress, final int portNo) throws HeartBeatException {
		super(groupAddress, portNo);
	}

	public HeartBeat(final InetAddress groupAddress, final int portNo) throws HeartBeatException {
		super(groupAddress, portNo);
	}

	/**
	 * Beat.
	 * @see net.wicast.heartbeat.HeartBeatInterface#beat(java.lang.String)
	 */
	@Override
	public void beat(final String message) throws HeartBeatException {
		LOG.trace(message);
		try {
			try {
				this.multicastSocket.joinGroup(this.groupAddress);

				final DatagramPacket outBoundDatagramPacket = new DatagramPacket(message.getBytes(), message.length(),
				        this.groupAddress, this.portNo);

				this.multicastSocket.send(outBoundDatagramPacket);
			} catch (final SocketException e) {
				log.error(e.getLocalizedMessage(),e);
				throw new HeartBeatException(e);
			}
		} catch (final IOException e) {
            log.error(e.getLocalizedMessage(),e);
			throw new HeartBeatException(e);
		}
	}
}
