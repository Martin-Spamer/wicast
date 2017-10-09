package net.wicast;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.*;

public class ApplicationScannerTest {

	private static final Logger LOG = LoggerFactory.getLogger(ApplicationScannerTest.class);

	/**
	 * Test method for
	 * {@link net.wicast.ApplicationScanner#ApplicationScanner(org.w3c.dom.Document)}.
	 */
	@Test
	public void testApplicationScanner() {
		final ApplicationScanner applicationScanner = new ApplicationScanner();
		assertNotNull("Value cannot be null", applicationScanner);
		ApplicationScannerTest.LOG.info("{}", applicationScanner.toString());
	}

}
