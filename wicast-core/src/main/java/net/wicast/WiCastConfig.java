
package net.wicast;

/**
 * WiCast configuration class.
 */
public class WiCastConfig extends AbstractConfig {

    /** PORT constant. */
    private static final String PORT = "1234";

    /** CHANNEL constant. */
    private static final String CHANNEL = "228.1.1.1";

    /** CHANNEL_IN constant. */
    private static final String CHANNEL_IN = "228.2.2.2";

    /** CHANNEL_OUT constant. */
    private static final String CHANNEL_OUT = "228.3.3.3";

    /**
     * Gets the group.
     *
     * @return the group
     */
    public String getGroup() {
        String group = System.getProperty("wicast-group");
        if (group == null) {
            return getProperty("group", CHANNEL);
        }
        return group;
    }

    /**
     * Gets the port.
     *
     * @return the port
     */
    public int getPort() {
        String port = System.getProperty("wicast-port");
        if (port == null) {
            port = getProperty("port", "1234");
        }
        return Integer.parseInt(port);
    }

}
