
package net.wicast;

import java.net.InetAddress;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A relay for multicast messages.
 */
public final class MultiCastRelay {

    /** provide logging. */
    private static final Logger LOG = LoggerFactory.getLogger(MultiCastRelay.class);

    /** constant configuration. */
    private static final WiCastConfig CONFIG = new WiCastConfig();

    /** The exit. */
    private boolean exit = false;

    /**
     * MultiCastReceiverThread class.
     */
    public class MultiCastReceiverThread extends Thread {

        /** The receiver. */
        private final MultiCastReceiver receiver = new MultiCastReceiver();

        /*
         * (non-Javadoc)
         * @see java.lang.Thread#run()
         */
        @Override
        public void run() {
            final InetAddress group = CONFIG.getGroup();
            final int portNo = CONFIG.getPortNo();
            int count = 0;

            while (!exit) {
                receiver.receiveByMulticastSocket(group, portNo);
                try {
                    Thread.sleep(1000);
                } catch (final InterruptedException e) {
                    Thread.interrupted();
                    LOG.error(e.getLocalizedMessage(), e);
                    exit = true;
                }
                if (++count >= 12) {
                    exit = true;
                }
            }
        }

        /**
         * End.
         */
        public void end() {
            exit = true;
        }
    }

    /** The multicast receiver. */
    private MultiCastReceiverThread multicastReceiver;

    /**
     * MultiCastSenderThread class.
     */
    public class MultiCastSenderThread extends Thread {

        /** The sender. */
        private final MultiCastSender sender = new MultiCastSender();

        /*
         * (non-Javadoc)
         * @see java.lang.Thread#run()
         */
        @Override
        public void run() {
            final InetAddress group = CONFIG.getGroup();
            final int portNo = CONFIG.getPortNo();
            final String template = "<WICAST count=%d/>";

            int count = 0;
            while (!exit) {
                if (++count >= 12) {
                    exit = true;
                }
                final String message = String.format(template, count);
                sender.sendByDatagramSocket(group, portNo, message.getBytes());
                try {
                    Thread.sleep(1000);
                } catch (final InterruptedException e) {
                    Thread.interrupted();
                    LOG.error(e.getLocalizedMessage(), e);
                    exit = true;
                }
            }
        }

        /**
         * End.
         */
        public void end() {
            exit = true;
        }
    }

    /** The multicast sender. */
    private MultiCastSenderThread multicastSender;

    /**
     * Start.
     */
    public void start() {
        multicastReceiver = new MultiCastReceiverThread();
        Runtime.getRuntime().addShutdownHook(multicastReceiver);
        multicastReceiver.start();

        multicastSender = new MultiCastSenderThread();
        Runtime.getRuntime().addShutdownHook(multicastSender);
        multicastSender.start();

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

    /**
     * End.
     */
    public void end() {
        multicastReceiver.end();
        multicastSender.end();
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
        LOG.info("System properties {}", System.getProperties());
        new MultiCastRelay().start();
    }

}
