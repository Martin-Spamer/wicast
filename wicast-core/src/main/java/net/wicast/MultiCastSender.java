/**
 * This file is part of Automated Testing Framework for Java (atf4j).
 *
 * Atf4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Atf4j is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with atf4j.  If not, see http://www.gnu.org/licenses/.
 */
package net.wicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MultiCastSender, send datagrams to Multicast group.
 * <author@wicast.net>
 *
 * @version 0.3
 * @date 01-10-2009
 */
public class MultiCastSender {

    private static final Logger log = LoggerFactory.getLogger(MultiCastSender.class);

    /**
     * main entry point for this class.
     *
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        MultiCastSender.log.trace(System.getProperties().toString());
        MultiCastSender.log.debug("args[]={}", Arrays.toString(args));

        final MultiCastSender multiCastSender = new MultiCastSender();
        while (true) {
            MultiCastSender.log.debug("{}",
                    multiCastSender.sendByDatagramSocket("228.1.2.3", 1234, "<WICAST type=1/>".getBytes()));
            MultiCastSender.log.debug("{}",
                    multiCastSender.sendByMulticastSocket("228.1.2.3", 1234, "<WICAST type=2/>".getBytes()));
        }
    }

    /**
     * Creates a new instance of MultiCasterSender.
     */
    public MultiCastSender() {
    }

    /**
     * Sending to a Multicast Group.
     * You can send to a multicast socket using either a DatagramSocket
     * or a MulticastSocket. What makes it multicast is the address that
     * is in the datagram. If the address is a multicast address, the datagram
     * will reach the multicast members in the group. You only need to use
     * MulticastSocket if you want to control the time-to-live of the datagram.
     *
     * @param group multicast group address as String "X.X.X.X".
     * @param port sending port as int.
     * @param output payload as byte array.
     * @return status as boolean result.
     */
    public boolean sendByDatagramSocket(final String group, final int port, final byte[] output) {
        boolean status = false;
        try {
            final DatagramSocket socket = new DatagramSocket();
            final InetAddress groupAddr = InetAddress.getByName(group);
            final DatagramPacket packet = new DatagramPacket(output, output.length, groupAddr, port);
            socket.send(packet);
            socket.close();
            status = true;
        } catch (final SocketException socketException) {
            MultiCastSender.log.error("{}", socketException);
        } catch (final IOException ioException) {
            MultiCastSender.log.error("{}", ioException);
        }
        return status;
    }

    /**
     * Send Datagram to Multicast Group by Socket.
     *
     * @param group the group
     * @param port the port
     * @param output the output
     * @return boolean
     */
    public boolean sendByMulticastSocket(final String group, final int port, final byte[] output) {
        boolean status = false;
        try {
            //
            final int timeToLive = 1;
            final MulticastSocket socket = new MulticastSocket();
            final DatagramPacket packet = new DatagramPacket(output, output.length, InetAddress.getByName(group), port);
            socket.send(packet, (byte) timeToLive);
            socket.close();
            status = true;
        } catch (final SocketException socketException) {
            MultiCastSender.log.error("{}", socketException);
        } catch (final IOException ioException) {
            MultiCastSender.log.error("{}", ioException);
        } catch (final Exception exception) {
            MultiCastSender.log.error("{}", exception);
        }
        return status;
    }

}
