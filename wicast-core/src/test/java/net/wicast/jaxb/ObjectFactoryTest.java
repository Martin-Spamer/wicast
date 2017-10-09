package net.wicast.jaxb;

import static org.junit.Assert.*;

import javax.xml.bind.JAXBElement;

import org.junit.Test;
import org.slf4j.*;

import net.wicast.config.*;

/**
 * Test for JAXB ObjectFactory.
 */
public class ObjectFactoryTest {

	private static final Logger log = LoggerFactory.getLogger(ObjectFactoryTest.class);

	/**
	 * Test of createApplication method, of class ObjectFactory.
	 */
	@Test
	public void testCreateApplication() {
		ObjectFactoryTest.log.info("createApplication");
		final ObjectFactory instance = new ObjectFactory();
		assertNotNull("Value cannot be null", instance);
		assertTrue(instance instanceof ObjectFactory);
		final Application result = instance.createApplication();
		assertNotNull("Value cannot be null", result);
		ObjectFactoryTest.log.info(result.toString());
	}

	/**
	 * Test of createChannel method, of class ObjectFactory.
	 */
	@Test
	public void testCreateChannel() {
		ObjectFactoryTest.log.info("createChannel");
		final ObjectFactory instance = new ObjectFactory();
		assertNotNull("Value cannot be null", instance);
		assertTrue(instance instanceof ObjectFactory);

		final Channel channel = instance.createChannel();
		assertNotNull("Value cannot be null", channel);
		ObjectFactoryTest.log.info(channel.toString());
	}

	/**
	 * Test of createClient method, of class ObjectFactory.
	 */
	@Test
	public void testCreateClient() {
		ObjectFactoryTest.log.info("createClient");
		final ObjectFactory instance = new ObjectFactory();
		assertNotNull("Value cannot be null", instance);
		assertTrue(instance instanceof ObjectFactory);
		final Client result = instance.createClient();
		assertNotNull("Value cannot be null", result);
		ObjectFactoryTest.log.info(result.toString());
	}

	/**
	 * Test of createCore method, of class ObjectFactory.
	 */
	@Test
	public void testCreateCore() {
		ObjectFactoryTest.log.info("createCore");
		final String value = "Core";
		final ObjectFactory instance = new ObjectFactory();
		assertNotNull("Value cannot be null", instance);
		assertTrue(instance instanceof ObjectFactory);
		final JAXBElement<String> result = instance.createCore(value);
		assertNotNull("Value cannot be null", result);
		ObjectFactoryTest.log.info(result.toString());
	}

	/**
	 * Test of createDescription method, of class ObjectFactory.
	 */
	@Test
	public void testCreateDescription() {
		ObjectFactoryTest.log.info("createDescription");
		final String value = "Description";
		final ObjectFactory instance = new ObjectFactory();
		assertNotNull("Value cannot be null", instance);
		assertTrue(instance instanceof ObjectFactory);
		final JAXBElement<String> result = instance.createDescription(value);
		assertNotNull("Value cannot be null", result);
		ObjectFactoryTest.log.info(result.toString());
	}

	/**
	 * Test of createLicence method, of class ObjectFactory.
	 */
	@Test
	public void testCreateLicence() {
		ObjectFactoryTest.log.info("createLicence");
		final ObjectFactory instance = new ObjectFactory();
		assertNotNull("Value cannot be null", instance);
		assertTrue(instance instanceof ObjectFactory);
		final Licence result = instance.createLicence();
		assertNotNull("Value cannot be null", result);
		ObjectFactoryTest.log.info(result.toString());
	}

	/**
	 * Test of createLicenses method, of class ObjectFactory.
	 */
	@Test
	public void testCreateLicenses() {
		ObjectFactoryTest.log.info("createLicenses");
		final ObjectFactory instance = new ObjectFactory();
		assertNotNull("Value cannot be null", instance);
		assertTrue(instance instanceof ObjectFactory);
		final Licenses result = instance.createLicenses();
		assertNotNull("Value cannot be null", result);
		ObjectFactoryTest.log.info(result.toString());
	}

	/**
	 * Test of createMessage method, of class ObjectFactory.
	 */
	@Test
	public void testCreateMessage() {
		ObjectFactoryTest.log.info("createMessage");
		final ObjectFactory instance = new ObjectFactory();
		assertNotNull("Value cannot be null", instance);
		assertTrue(instance instanceof ObjectFactory);
		final Message result = instance.createMessage();
		assertNotNull("Value cannot be null", result);
		ObjectFactoryTest.log.info(result.toString());
	}

	/**
	 * Test of createName method, of class ObjectFactory.
	 */
	@Test
	public void testCreateName() {
		ObjectFactoryTest.log.info("createName");
		final String value = "Name";
		final ObjectFactory instance = new ObjectFactory();
		assertNotNull("Value cannot be null", instance);
		assertTrue(instance instanceof ObjectFactory);
		final JAXBElement<String> result = instance.createName(value);
		assertNotNull("Value cannot be null", result);
		ObjectFactoryTest.log.info(result.toString());
	}

	/**
	 * Test of createOrganization method, of class ObjectFactory.
	 */
	@Test
	public void testCreateOrganization() {
		ObjectFactoryTest.log.info("createOrganization");
		final String value = "Organisation";
		final ObjectFactory instance = new ObjectFactory();
		assertNotNull("Value cannot be null", instance);
		assertTrue(instance instanceof ObjectFactory);
		final JAXBElement<String> result = instance.createOrganization(value);
		assertNotNull("Value cannot be null", result);
		ObjectFactoryTest.log.info(result.toString());
	}

	/**
	 * Test of createPort method, of class ObjectFactory.
	 */
	@Test
	public void testCreatePort() {
		ObjectFactoryTest.log.info("createPort");
		final Integer value = 65555;
		final ObjectFactory instance = new ObjectFactory();
		assertNotNull("Value cannot be null", instance);
		assertTrue(instance instanceof ObjectFactory);
		final JAXBElement<Integer> result = instance.createPort(value);
		assertNotNull("Value cannot be null", result);
		ObjectFactoryTest.log.info(result.toString());
	}

	// /**
	// * Test of createProperties method, of class ObjectFactory.
	// */
	// @Test
	// public void testCreateProperties() {
	// log.info("createProperties");
	// final ObjectFactory instance = new ObjectFactory();
	// assertNotNull("Value cannot be null",instance);
	// assertTrue(instance instanceof ObjectFactory);
	// final Properties result = instance.createProperties();
	// assertNotNull("Value cannot be null",result);
	// log.info(result.toString());
	// }

	// /**
	// * Test of createScheduler method, of class ObjectFactory.
	// */
	// @Test
	// public void testCreateScheduler() {
	// log.info("createScheduler");
	// final ObjectFactory instance = new ObjectFactory();
	// assertNotNull("Value cannot be null",instance);
	// assertTrue(instance instanceof ObjectFactory);
	// final Scheduler result = instance.createScheduler();
	// assertNotNull("Value cannot be null",result);
	// log.info(result.toString());
	// }

	/**
	 * Test of createServer method, of class ObjectFactory.
	 */
	@Test
	public void testCreateServer() {
		ObjectFactoryTest.log.info("createServer");
		final ObjectFactory instance = new ObjectFactory();
		assertNotNull("Value cannot be null", instance);
		assertTrue(instance instanceof ObjectFactory);
		final Server result = instance.createServer();
		assertNotNull("Value cannot be null", result);
		ObjectFactoryTest.log.info(result.toString());
	}

	/**
	 * Test of createTask method, of class ObjectFactory.
	 */
	@Test
	public void testCreateTask() {
		ObjectFactoryTest.log.info("createTask");
		final ObjectFactory instance = new ObjectFactory();
		assertNotNull("Value cannot be null", instance);
		assertTrue(instance instanceof ObjectFactory);
		final Task result = instance.createTask();
		assertNotNull("Value cannot be null", result);
		ObjectFactoryTest.log.info(result.toString());
	}

	/**
	 * Test of createTool method, of class ObjectFactory.
	 */
	@Test
	public void testCreateTool() {
		ObjectFactoryTest.log.info("createTool");
		final ObjectFactory instance = new ObjectFactory();
		assertNotNull("Value cannot be null", instance);
		assertTrue(instance instanceof ObjectFactory);
		final Tool result = instance.createTool();
		assertNotNull("Value cannot be null", result);
		ObjectFactoryTest.log.info(result.toString());
	}

	/**
	 * Test of createTools method, of class ObjectFactory.
	 */
	@Test
	public void testCreateTools() {
		ObjectFactoryTest.log.info("createTools");
		final ObjectFactory instance = new ObjectFactory();
		assertNotNull("Value cannot be null", instance);
		assertTrue(instance instanceof ObjectFactory);
		final Tools result = instance.createTools();
		assertNotNull("Value cannot be null", result);
		ObjectFactoryTest.log.info(result.toString());
	}

	/**
	 * Test of createUrl method, of class ObjectFactory.
	 */
	@Test
	public void testCreateUrl() {
		ObjectFactoryTest.log.info("createUrl");
		final String value = "Uri";
		final ObjectFactory instance = new ObjectFactory();
		assertNotNull("Value cannot be null", instance);
		assertTrue(instance instanceof ObjectFactory);
		final JAXBElement<String> result = instance.createUrl(value);
		assertNotNull("Value cannot be null", result);
		ObjectFactoryTest.log.info(result.toString());
	}

	/**
	 * Test of createVersion method, of class ObjectFactory.
	 */
	@Test
	public void testCreateVersion() {
		ObjectFactoryTest.log.info("createVersion");
		final String value = "Version";
		final ObjectFactory instance = new ObjectFactory();
		assertNotNull("Value cannot be null", instance);
		assertTrue(instance instanceof ObjectFactory);
		final JAXBElement<String> result = instance.createVersion(value);
		assertNotNull("Value cannot be null", result);
		ObjectFactoryTest.log.info(result.toString());
	}

	/**
	 * Test of createWebAdmin method, of class ObjectFactory.
	 */
	@Test
	public void testCreateWebAdmin() {
		ObjectFactoryTest.log.info("createWebAdmin");
		final ObjectFactory instance = new ObjectFactory();
		assertNotNull("Value cannot be null", instance);
		assertTrue(instance instanceof ObjectFactory);
		final WebAdmin result = instance.createWebAdmin();
		assertNotNull("Value cannot be null", result);
		ObjectFactoryTest.log.info(result.toString());
	}

}
