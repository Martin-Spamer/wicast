
package net.wicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/**
 * MultiCastReceiver, subscribe to Multicast group and receive datagrams.
 */
public final class MultiCastReceiver extends MulticastBase {

    /**
     * @param groupAddress
     * @param portNo
     */
    private MultiCastReceiver(final InetAddress groupAddress, final int portNo) {
        super(groupAddress, portNo);
    }

    /** constant configuration. */
    private final WiCastConfig config = new ReceiverConfig();

    /**
     * Instantiates a new multicast receiver.
     */
    public MultiCastReceiver() {
        super();
    }

    /**
     * Instantiates a new multicast receiver.
     *
     * @param config the configuration.
     */
    public MultiCastReceiver(final WiCastConfig config) {
        super(config);
    }

    /**
     * Instantiates a new multicast receiver.
     *
     * @param group the group
     * @param port the port
     */
    public MultiCastReceiver(final String group, final String port) {
        super(group, port);
    }

    /**
     * Receive by multicast socket.
     *
     * @return true, if successful
     */
    public boolean receiveByMulticastSocket() {
        return receiveByMulticastSocket(groupAddress, portNo);
    }

    /**
     * receive datagrams by joining a multicast socket.
     *
     * @param group multicast group address as String "X.X.X.X".
     * @param port receiver port as int.
     * @return status as boolean result.
     */
    public boolean receiveByMulticastSocket(final String group, final String port) {
        try {
            int portNo = Integer.parseInt(port);
            final InetAddress groupAddr = InetAddress.getByName(group);
            return receiveByMulticastSocket(groupAddr, portNo);
        } catch (NumberFormatException | UnknownHostException e) {
            log.error(e.getLocalizedMessage(), e);
        }
        return false;
    }

    /**
     * Receive by multicast socket.
     *
     * @param groupAddress the group address
     * @param port the port
     * @return true, if successful
     */
    public boolean receiveByMulticastSocket(final InetAddress groupAddress, final int port) {
        boolean status = false;

        try {
            final MulticastSocket socket = new MulticastSocket(port);
            socket.joinGroup(groupAddress);

            // Create a DatagramPacket and do a receive
            final byte input[] = new byte[1024];
            final DatagramPacket packet = new DatagramPacket(input, input.length);
            socket.receive(packet);

            log.debug("Multicast Received");
            log.debug("from: {}", packet.getAddress());
            log.debug("port: {}", packet.getPort());
            final int length = packet.getLength();
            log.debug("length: {}", length);
            final byte[] data = packet.getData();
            log.trace("data = {}", data);

            socket.leaveGroup(groupAddress);
            socket.close();
            status = true;
        } catch (IOException e) {
            log.error(e.getLocalizedMessage(), e);
        }
        return status;
    }

}
