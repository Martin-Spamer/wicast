package net.wicast.heartbeat;

import java.io.IOException;
import java.net.*;

/**
 * HeartBeatTest.
 */
public class HeartBeat extends AbstractHeartBeat {

	/**
	 * HeartBeatTest.
	 */
	public HeartBeat(final InetAddress groupAddress, final int portNo) throws HeartBeatException {
		super(groupAddress, portNo);
	}

	/**
	 * HeartBeatTest.
	 */
	public HeartBeat(final String groupAddress, final int portNo) throws HeartBeatException {
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
				socketException.printStackTrace(System.err);
				throw new HeartBeatException(socketException);
			}
		} catch (final IOException ioException) {
			ioException.printStackTrace(System.err);
			throw new HeartBeatException(ioException);
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
		} catch (final HeartBeatException heartBeatException) {
			heartBeatException.printStackTrace(System.err);
			this.stop();
		}
	}
}
