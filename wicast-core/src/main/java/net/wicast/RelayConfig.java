package net.wicast;

public class RelayConfig extends AbstractConfig {

//    private String group = config.getProperty("group", "228.1.2.3");
//    private String port = config.getProperty("group", "1234");
//    private String template = config.getProperty("message", "<WICAST count=%d/>");

    public String getGroup() {
        return super.getProperty("group", "228.1.2.3");
    }

    public int getPort() {
        String property = super.getProperty("port", "1234");
        return Integer.parseInt(property);
    }

    public String getMessage() {
        return super.getProperty("message", "<WICAST VERSION=1/>");
    }

}
