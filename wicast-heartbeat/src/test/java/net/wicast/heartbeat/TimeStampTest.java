package net.wicast.heartbeat;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TimeStampTest.
 */
public class TimeStampTest {

	private static final Logger log = LoggerFactory.getLogger(TimeStampTest.class);

	/**
	 * test case for TimeStamp.
	 */
	@Test
	public final void test() {
		final TimeStamp testTimeStamp1 = new TimeStamp();
		assertNotNull(testTimeStamp1);

		final TimeStamp testTimeStamp2 = new TimeStamp();
		assertNotNull("not null", testTimeStamp2);
		assertNotSame("Not same", testTimeStamp1, testTimeStamp2);

		log.info("{}", testTimeStamp1);
		log.info("{}", testTimeStamp1.time);
		log.info("{}", testTimeStamp1.toString());
		log.info("{}", testTimeStamp2);
		log.info("{}", testTimeStamp2.time);
		log.info(testTimeStamp2.toString());
		log.info(TimeStamp.FORMAT);
	}
}
