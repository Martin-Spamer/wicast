
package net.wicast;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * WiCast configuration class.
 */
public class WiCastConfig extends AbstractConfig {

    /** PORT constant. */
    private static final String DEFAULT_PORT = "1234";

    /** CHANNEL constant. */
    private static final String DEFAULT_CHANNEL = "228.1.1.1";

    /** CHANNEL_IN constant. */
    private static final String DEFAULT_CHANNEL_IN = "228.2.2.2";

    /** CHANNEL_OUT constant. */
    private static final String DEFAULT_CHANNEL_OUT = "228.3.3.3";

    /**
     * Gets the group.
     *
     * @return the group
     */
    public InetAddress getGroup() {
        try {
            String group = System.getProperty("wicast-group");
            if (group == null) {
                group = getProperty("group", DEFAULT_CHANNEL);
            }
            return InetAddress.getByName(group);
        } catch (UnknownHostException e) {
            log.error(e.getLocalizedMessage(), e);
        }
        return null;
    }

    /**
     * Default channel.
     *
     * @return the string
     */
    public String defaultChannel() {
        String group = System.getProperty("wicast-default-channel");
        if (group == null) {
            return getProperty("default-channel", DEFAULT_CHANNEL);
        }
        return group;
    }

    /**
     * Input channel.
     *
     * @return the string
     */
    public String inputChannel() {
        String group = System.getProperty("wicast-default-channel");
        if (group == null) {
            return getProperty("default-channel", DEFAULT_CHANNEL_IN);
        }
        return group;
    }

    /**
     * Output channel.
     *
     * @return the string
     */
    public String outputChannel() {
        String group = System.getProperty("wicast-default-channel");
        if (group == null) {
            return getProperty("default-channel", DEFAULT_CHANNEL_OUT);
        }
        return group;
    }

    /**
     * Gets the port no.
     *
     * @return the port no
     */
    public int getPortNo() {
        return Integer.parseInt(getPort());
    }

    /**
     * Gets the port.
     *
     * @return the port
     */
    public String getPort() {
        String port = System.getProperty("wicast-port");
        if (port == null) {
            return getProperty("port", DEFAULT_PORT);
        }
        return port;
    }

}
