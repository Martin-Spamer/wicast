package net.wicast.heartbeat;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.wicast.AbstractConfig;

public class MoreConfigTest {

	private static final Logger log = LoggerFactory.getLogger(MoreConfigTest.class);

	/**
	 * fail to load none existing configuration file. <code> </code>
	 */
	@Test
	public void test0() {
		try {
			log.debug("--- test0 : named configuration file does not exist.");
			final AbstractConfig config = new Config("missing.xml");
			log.debug(config.toString());
		} catch (final Exception exception) {
			log.error(exception.toString());
		}
	}

	/**
	 * test load default configuration file.
	 * <code>
	 * 	Config config = new Config();
	 *  log.debug(config.toString());
	 * </code>
	 */
	@Test
	public void test1() {
		try {
			log.debug("--- test1 : load default configuration file.");
			final Config config = new Config();
			log.debug(config.toString());
		} catch (final java.lang.Exception exception) {
			log.debug(exception.toString());
		}
	}

	/**
	 * test load a named configuration file.
	 * <code>
	 * 	Config config = new Config("Application.xml");
	 *  log.debug( config.toString() ) ;
	 *  </code>
	 */
	@Test
	public void test2() {
		try {
			log.debug("--- test2 : test load a named configuration file.");
			final Config config = new Config("Application.xml");
			log.debug("config" + config.toString());
		} catch (final java.lang.Exception exception) {
			log.debug(exception.toString());
		}
	}
}
