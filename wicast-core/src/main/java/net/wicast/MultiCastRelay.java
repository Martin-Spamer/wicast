
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
    private boolean exit = false;
    private final WiCastConfig config = new WiCastConfig();

    /**
     * MultiCastReceiverThread class.
     */
    public class MultiCastReceiverThread extends Thread {
        private static final String GROUP_KEY = "group";
        private static final String DEFAULT_PORT = "1234";
        private static final String DEFAULT_CHANNEL = "228.1.2.3";
        private final MultiCastReceiver receiver = new MultiCastReceiver();

        @Override
        public void run() {
            final String group = config.getProperty(GROUP_KEY, DEFAULT_CHANNEL);
            final String port = config.getProperty(GROUP_KEY, DEFAULT_PORT);
            final int portNo = Integer.parseInt(port);
            final String loop = config.getProperty("loop", "12");
            final int max = Integer.parseInt(loop);
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
                count++;
                if (count >= max) {
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
            final String group = config.getProperty("group", "228.1.2.3");
            final String port = config.getProperty("group", "1234");
            final String template = config.getProperty("message", "<WICAST count=%d/>");
            final int portNo = Integer.parseInt(port);
            final String loop = config.getProperty("loop", "12");
            final int max = Integer.parseInt(loop);
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
                count++;
                if (count >= max) {
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
