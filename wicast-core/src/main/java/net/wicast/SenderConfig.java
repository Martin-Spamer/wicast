
package net.wicast;

/**
 * WiCast sender configuration.
 */
public final class SenderConfig extends WiCastConfig {

    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
        return super.getProperty("message", "<WICAST VERSION=1/>");
    }

}
