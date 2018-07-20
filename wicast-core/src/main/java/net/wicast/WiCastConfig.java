
package net.wicast;

public class WiCastConfig extends AbstractConfig {

    private static final String PORT = "1234";
    private static final String CHANNEL = "228.1.1.1";
    private static final String CHANNEL_IN = "228.2.2.2";
    private static final String CHANNEL_OUT = "228.3.3.3";

    public String getGroup() {
        String group = System.getProperty("wicast-group");
        if (group == null) {
            return getProperty("group", CHANNEL);
        }
        return group;
    }

    public int getPort() {
        String port = System.getProperty("wicast-port");
        if (port == null) {
            port = getProperty("port", "1234");
        }
        return Integer.parseInt(port);
    }

}
