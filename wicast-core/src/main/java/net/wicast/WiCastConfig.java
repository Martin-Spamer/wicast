
package net.wicast;

public class WiCastConfig extends AbstractConfig {

    // private String group = config.getProperty("group", "228.1.2.3");
    // private String port = config.getProperty("group", "1234");
    // private String template = config.getProperty("message", "<WICAST
    // count=%d/>");

    public String getGroup() {
        return super.getProperty("group", "228.1.2.3");
    }

    public int getPort() {
        final String property = super.getProperty("port", "1234");
        return Integer.parseInt(property);
    }

}
