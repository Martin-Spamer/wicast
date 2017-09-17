package net.wicast;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class MultiCastRelayTest {

	@Test
	public void testMultiCastRelay() {
		final MultiCastRelay multiCastRelay = new MultiCastRelay();
		assertNotNull(multiCastRelay);
	}

}
