
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
    private static final WiCastConfig config = new WiCastConfig();
    private boolean exit = false;

    /**
     * MultiCastReceiverThread class.
     */
    public class MultiCastReceiverThread extends Thread {
        private static final String PORT = "1234";
        private static final String CHANNEL_IN = "228.1.2.3";
        private static final String CHANNEL_OUT = "228.4.5.6";
        private final MultiCastReceiver receiver = new MultiCastReceiver();

        @Override
        public void run() {
            final String group = config.getGroup();
            final int portNo = config.getPort();
            int count = 0;

            while (!exit) {
                receiver.receiveByMulticastSocket(group, portNo);
                try {
                    Thread.sleep(1000);
                } catch (final InterruptedException e) {
                    LOG.error(e.getLocalizedMessage(), e);
                    Thread.interrupted();
                    exit = true;
                }
                if (++count >= 12) {
                    exit = true;
                }
            }
        }

        public void end() {
            exit = true;
        }
    }

    private MultiCastReceiverThread multiCastReceiver;

    /**
     * class MultiCastSenderThread.
     */
    public class MultiCastSenderThread extends Thread {
        private final MultiCastSender sender = new MultiCastSender();

        @Override
        public void run() {
            final String group = config.getGroup();
            final int portNo = config.getPort();
            final String template = "<WICAST count=%d/>";

            int count = 0;
            while (!exit) {
                final String message = String.format(template, count);
                sender.sendByDatagramSocket(group, portNo, message.getBytes());
                try {
                    Thread.sleep(1000);
                } catch (final InterruptedException e) {
                    exit = true;
                    Thread.interrupted();
                    LOG.error(e.getLocalizedMessage(), e);
                }
                if (++count >= 12) {
                    exit = true;
                }
            }
        }

        public void end() {
            exit = true;
        }
    }

    private MultiCastSenderThread multiCastSender;

    /**
     * Start.
     */
    public void start() {
        multiCastReceiver = new MultiCastReceiverThread();
        Runtime.getRuntime().addShutdownHook(multiCastReceiver);
        multiCastReceiver.start();

        multiCastSender = new MultiCastSenderThread();
        Runtime.getRuntime().addShutdownHook(multiCastSender);
        multiCastSender.start();

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
        multiCastReceiver.end();
        multiCastSender.end();
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
