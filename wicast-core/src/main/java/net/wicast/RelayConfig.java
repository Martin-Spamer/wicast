
package net.wicast;

/**
 * The Class RelayConfig.
 */
public class RelayConfig extends AbstractConfig {

    // private String group = config.getProperty("group", "228.1.2.3");
    // private String port = config.getProperty("group", "1234");
    // private String template = config.getProperty("message", "<WICAST
    // count=%d/>");

    /**
     * Gets the group.
     *
     * @return the group
     */
    public String getGroup() {
        return super.getProperty("group", "228.1.2.3");
    }

    /**
     * Gets the port.
     *
     * @return the port
     */
    public int getPort() {
        final String property = super.getProperty("port", "1234");
        return Integer.parseInt(property);
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
        return super.getProperty("message", "<WICAST VERSION=1/>");
    }

}
