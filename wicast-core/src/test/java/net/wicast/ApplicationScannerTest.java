package net.wicast;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ApplicationScannerTest {

	/**
	 * Test method for
	 * {@link net.wicast.ApplicationScanner#ApplicationScanner(org.w3c.dom.Document)}.
	 */
	@Test
	public void testApplicationScanner() {
		final ApplicationScanner applicationScanner = new ApplicationScanner();
		assertNotNull(applicationScanner);
	}

}
