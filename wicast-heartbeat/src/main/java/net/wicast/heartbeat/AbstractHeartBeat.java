package net.wicast.heartbeat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AbstractHeartBeat.
 */
public abstract class AbstractHeartBeat extends Thread implements IHeartBeat {
	private static final Logger log = LoggerFactory.getLogger(AbstractHeartBeat.class);
	protected InetAddress groupAddress;
	protected int portNo;
	protected MulticastSocket multicastSocket;

	/**
	 * AbstractHeartBeat.
	 */
	public AbstractHeartBeat() {
		super();
		this.portNo = 0;
		try {
			this.groupAddress = InetAddress.getByName("");
		} catch (final UnknownHostException e) {
			e.printStackTrace();
		}
	}

	/**
	 * AbstractHeartBeat.
	 */
	public AbstractHeartBeat(final InetAddress groupAddress, final int portNo) throws HeartBeatException {
		this.groupAddress = groupAddress;
		this.portNo = portNo;
		joinGroup(this.groupAddress, this.portNo);
	}

	/**
	 * AbstractHeartBeat.
	 */
	public AbstractHeartBeat(final String groupAddressString, final int portNo) throws HeartBeatException {
		try {
			this.groupAddress = InetAddress.getByName(groupAddressString);
			this.portNo = portNo;
			joinGroup(this.groupAddress, this.portNo);
		} catch (final UnknownHostException unknownHostException) {
			log.error("{}", unknownHostException);
			throw new HeartBeatException(unknownHostException);
		}
	}

	/**
	 * Join group.
	 *
	* group address in
	* port no in
	* heart beat exception
	 */
	protected void joinGroup(final InetAddress groupAddressIn, final int portNoIn) throws HeartBeatException {
		try {
			this.multicastSocket = new MulticastSocket(portNoIn);

			try {
				this.multicastSocket.setTimeToLive(Thread.MIN_PRIORITY);
				this.multicastSocket.joinGroup(groupAddressIn);
			} catch (final SocketException socketException) {
				log.error("{}", socketException.getLocalizedMessage());
				throw new HeartBeatException(socketException);
			}
		} catch (final IOException ioException) {
			log.error("{}", ioException);
			throw new HeartBeatException(ioException);
		}
	}
}
