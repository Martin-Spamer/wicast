
package net.wicast;

public class SenderConfig extends WiCastConfig {

    public String getMessage() {
        return super.getProperty("message", "<WICAST VERSION=1/>");
    }

}
