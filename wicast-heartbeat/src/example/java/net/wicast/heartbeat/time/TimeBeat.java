package net.wicast.heartbeat.time;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.SocketException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.wicast.heartbeat.AbstractHeartBeat;
import net.wicast.heartbeat.HeartBeatException;

/**
 * TimeBeat.
 */
public class TimeBeat extends AbstractHeartBeat {

	private static final Logger log = LoggerFactory.getLogger(TimeBeat.class);

	/**
	 * AbstractHeartBeat.
	 *
	* group address
	* port no
	* heart beat exception
	 */
	public TimeBeat(final String groupAddress, final int portNo) throws HeartBeatException {
		super(groupAddress, portNo);
	}

	/**
	 * AbstractHeartBeatMonitor.
	 *
	* group address
	* port no
	* heart beat exception
	 */
	public TimeBeat(final InetAddress groupAddress, final int portNo) throws HeartBeatException {
		super(groupAddress, portNo);
	}

	/**
	 * Beat.
	 *
	* message
	* heart beat exception
	 * @see net.wicast.heartbeat.IHeartBeat#beat(java.lang.String)
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
