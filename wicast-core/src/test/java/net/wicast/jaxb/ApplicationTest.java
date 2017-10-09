package net.wicast.jaxb;

import static org.junit.Assert.*;

import java.io.*;

import javax.xml.bind.*;

import org.junit.Test;
import org.slf4j.*;

import net.wicast.config.*;

/**
 * Test for JAXB generate root element Application.
 */
public class ApplicationTest {

	private static final Logger log = LoggerFactory.getLogger(ApplicationTest.class);

	/**
	 * Unit Test for createNewInstance method, root element Application class.
	 */
	@Test
	public void testCreateNewInstance() {
		ApplicationTest.log.info("testCreateNewInstance");
		final Application instance = new Application();
		assertNotNull("Value cannot be null", instance);
		final Application result = (Application) instance.createNewInstance();
		assertNotNull("Value cannot be null", result);
		assertTrue(result instanceof Application);
		verify(result.toString());
	}

	/**
	 * Test to Marshall Java Objects into an Application.xml file.
	 *
	 * JAXB exception
	 * file not found exception
	 */
	@Test
	public void testMarshallApplication() throws JAXBException, FileNotFoundException {
		ApplicationTest.log.info("testMarshallApplication");
		final ObjectFactory instance = new ObjectFactory();
		assertNotNull("Value cannot be null", instance);
		final Application application = instance.createApplication();
		assertNotNull("Value cannot be null", application);
		application.setName("Application-Name");
		application.setDescription("Application-Description");
		application.setOrganization("Application-Organisation");
		application.setUrl("Application-Url");
		application.setVersion("Application-Version");
		ApplicationTest.log.info(application.toString());

		final JAXBContext jc = JAXBContext.newInstance("net.wicast.config");

		final Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(application, System.out);
	}

	/**
	 * Test of getDescription method, of class Application.
	 */
	@Test
	public void testSetGetDescription() {
		ApplicationTest.log.info("setDescription");
		final Application instance = new Application();
		assertNotNull("Value cannot be null", instance);
		final String value = "Description";
		instance.setDescription(value);

		ApplicationTest.log.info("getDescription");
		final String expResult = value;
		final String result = instance.getDescription();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getName method, of class Application.
	 */
	@Test
	public void testSetGetName() {
		ApplicationTest.log.info("setName");
		final Application instance = new Application();
		assertNotNull("Value cannot be null", instance);
		final String value = "setName";
		instance.setName(value);

		ApplicationTest.log.info("getName");
		final String expResult = value;
		final String result = instance.getName();
		assertEquals(expResult, result);

	}

	/**
	 * Test of getOrganization method, of class Application.
	 */
	@Test
	public void testSetGetOrganization() {
		ApplicationTest.log.info("setOrganization");
		final Application instance = new Application();
		assertNotNull("Value cannot be null", instance);
		final String value = "Organization";
		instance.setOrganization(value);

		ApplicationTest.log.info("getOrganization");
		final String expResult = value;
		final String result = instance.getOrganization();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getUrl method, of class Application.
	 */
	@Test
	public void testSetGetUrl() {
		ApplicationTest.log.info("setUrl");
		final Application instance = new Application();
		assertNotNull("Value cannot be null", instance);
		final String value = "Url";
		instance.setUrl(value);

		ApplicationTest.log.info("getUrl");
		final String expResult = value;
		final String result = instance.getUrl();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getVersion method, of class Application.
	 */
	@Test
	public void testSetGetVersion() {
		ApplicationTest.log.info("setVersion");
		final Application instance = new Application();
		assertNotNull("Value cannot be null", instance);
		final String value = "1.1.1";
		instance.setVersion(value);

		ApplicationTest.log.info("getVersion");
		final String expResult = value;
		final String result = instance.getVersion();
		assertEquals(expResult, result);
	}

	/**
	 * Test to UnMarshall Application.xml file into Java Objects.
	 *
	 * JAXB exception
	 * file not found exception
	 */
	@Test
	public void testUnMarshallApplication() throws JAXBException, FileNotFoundException {
		ApplicationTest.log.info("testUnMarshallApplication");
		final JAXBContext jc = JAXBContext.newInstance("net.wicast.config");
		final Unmarshaller u = jc.createUnmarshaller();
		// u.setValidating(true);
		final Class<? extends ApplicationTest> thisClass = this.getClass();
		final ClassLoader thisClassLoader = thisClass.getClassLoader();
		final String configFilename = "WiCastApplicationXml/Application.xml";
		final InputStream resourceAsStream = thisClassLoader.getResourceAsStream(configFilename);
		final Application application = (Application) u.unmarshal(resourceAsStream);
		assertNotNull("Value cannot be null", application);
		verify(application.getName());
		verify(application.getDescription());
		verify(application.getOrganization());
		verify(application.getUrl());
		verify(application.getVersion());
		ApplicationTest.log.info(application.toString());
	}

	/**
	 * Verify.
	 */
	private void verify(final String name) {
		assertNotNull("Value cannot be null", name);
		ApplicationTest.log.info(name + " success");
	}

}
