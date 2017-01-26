package net.wicast.heartbeat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

/**
 * AbstractHeartBeatMonitor.
 * 
 * @author <author@wicast.net>
 * 
 */
public class AbstractHeartBeatMonitor extends AbstractHeartBeat
{
    
    /**
     * AbstractHeartBeat.
     *
     * @param groupAddress the group address
     * @param portNo the port no
     * @throws HeartBeatException the heart beat exception
     */
    public AbstractHeartBeatMonitor(String groupAddress, int portNo) throws HeartBeatException
    {
        super(groupAddress, portNo);
    }

    /**
     * AbstractHeartBeatMonitor.
     *
     * @param groupAddress the group address
     * @param portNo the port no
     * @throws HeartBeatException the heart beat exception
     */
    public AbstractHeartBeatMonitor(InetAddress groupAddress, int portNo) throws HeartBeatException
    {
        super(groupAddress, portNo);
    }

    /**
     * Monitor.
     *
     * @throws HeartBeatException the heart beat exception
     */
    protected void monitor() throws HeartBeatException
    {
        try
        {
            this.multicastSocket = new MulticastSocket(this.portNo);
            byte[] buffer = new byte[1000];
            DatagramPacket inboundDatagramPacket = new DatagramPacket(buffer, buffer.length);
            this.multicastSocket.receive(inboundDatagramPacket);
            this.multicastSocket.leaveGroup(this.groupAddress);
        }
        catch (IOException ioException)
        {
            
            ioException.printStackTrace(System.err);
            throw new HeartBeatException(ioException);
        }

    }

    /**
     * Beat.
     *
     * @param message the message
     * @throws HeartBeatException the heart beat exception
     * @see net.wicast.heartbeat.IHeartBeat#beat(java.lang.String)
     */
    public void beat(String message) throws HeartBeatException
    {
        try
        {
            try
            {
                this.multicastSocket.joinGroup(this.groupAddress);

                DatagramPacket outBoundDatagramPacket = new DatagramPacket(message.getBytes(),
                        message.length(),
                        this.groupAddress,
                        this.portNo);

                multicastSocket.send(outBoundDatagramPacket);
            }
            catch (SocketException socketException)
            {
                socketException.printStackTrace(System.err);
                throw new HeartBeatException(socketException);
            }
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace(System.err);
            throw new HeartBeatException(ioException);
        }

    }

}
