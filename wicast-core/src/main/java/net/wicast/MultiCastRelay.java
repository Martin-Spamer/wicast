
package net.wicast;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MultiCast Relay.
 */
public final class MultiCastRelay {

    /** provide logging. */
    private static final Logger LOG = LoggerFactory.getLogger(MultiCastRelay.class);

    /**
     * MultiCastReceiverThread class.
     */
    public class MultiCastReceiverThread extends Thread {
        private boolean exit = false;
        private final WiCastConfig config = new WiCastConfig();
        private final MultiCastReceiver receiver = new MultiCastReceiver();

        @Override
        public void run() {
            final String group = config.getProperty("group", "228.1.2.3");
            final String port = config.getProperty("group", "1234");
            final int portNo = Integer.parseInt(port);
            final String loop = config.getProperty("loop", "12");
            final int max = Integer.parseInt(loop);
            int count = 0;

            while (!this.exit) {
                this.receiver.receiveByMulticastSocket(group, portNo);
                try {
                    Thread.sleep(1000);
                } catch (final InterruptedException exception) {
                    this.exit = true;
                    Thread.interrupted();
                    LOG.error(exception.getLocalizedMessage());
                }
                count++;
                if (count >= max) {
                    this.exit = true;
                }
            }
        }

        public void end() {
            this.exit = true;
        }
    }

    private MultiCastReceiverThread multiCastReceiver;

    /**
     * class MultiCastSenderThread.
     */
    public class MultiCastSenderThread extends Thread {
        private boolean exit = false;
        private final WiCastConfig config = new WiCastConfig();
        private final MultiCastSender sender = new MultiCastSender();

        @Override
        public void run() {
            final String group = this.config.getProperty("group", "228.1.2.3");
            final String port = this.config.getProperty("group", "1234");
            final String template = this.config.getProperty("message", "<WICAST count=%d/>");
            final int portNo = Integer.parseInt(port);
            final String loop = this.config.getProperty("loop", "12");
            final int max = Integer.parseInt(loop);
            int count = 0;
            while (!this.exit) {
                final String message = String.format(template, count);
                this.sender.sendByDatagramSocket(group, portNo, message.getBytes());
                try {
                    Thread.sleep(1000);
                } catch (final InterruptedException exception) {
                    this.exit = true;
                    Thread.interrupted();
                    LOG.error(exception.getLocalizedMessage());
                }
                count++;
                if (count >= max) {
                    this.exit = true;
                }
            }
        }

        public void end() {
            this.exit = true;
        }
    }

    private MultiCastSenderThread multiCastSender;

    /**
     * Start.
     */
    public void start() {
        this.multiCastReceiver = new MultiCastReceiverThread();
        Runtime.getRuntime().addShutdownHook(this.multiCastReceiver);
        this.multiCastReceiver.start();

        this.multiCastSender = new MultiCastSenderThread();
        Runtime.getRuntime().addShutdownHook(this.multiCastSender);
        this.multiCastSender.start();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(200);
                    System.out.println("Shutdown ...");
                    end();
                } catch (final InterruptedException e) {
                    Thread.interrupted();
                }
            }
        });
    }

    public void end() {
        this.multiCastReceiver.end();
        this.multiCastSender.end();
    }

    /**
     * main entry point for this class.
     *
     * command line arguments
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        LOG.info("args[] = {}", Arrays.toString(args));
        LOG.info(System.getProperties().toString());
        new MultiCastRelay().start();
    }

}
