
package net.wicast;

import java.io.*;
import java.util.Properties;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.*;
import org.w3c.dom.*;

/**
 * Configuration from XML.
 */
public abstract class AbstractXmlConfig implements ConfigInterface {

	private static final String XML_TO_PROPERTIES = "fromXml.properties";
	private static final String PROPERTIES_TO_PROPERTIES = "fromProperties.properties";
	private static final Logger log = LoggerFactory.getLogger(AbstractXmlConfig.class);

	static {
		final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		try {
			final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		} catch (final ParserConfigurationException parserConfigurationException) {
			AbstractXmlConfig.log.error(parserConfigurationException.toString());
		}
	}

	private final Properties properties = new Properties();
	private final Properties propertiesFromXml = new Properties();
	private final Document configDocument = null;
	private final Element configElement = null;
	private NodeList context = null;
	private int index = 0;

	/**
	 * default configuration from jar with
	 * from same filename as classname + ".xml".
	 */
	public AbstractXmlConfig() {
		// use this variation for packaged configuration.
		// loadFromXmlFile(this.getClass().getResourceAsStream(toXmlFilename(this.toName())));
		loadFromXmlFile(this.getClass().getClassLoader().getResourceAsStream(toXmlFilename(toName())));

		// use this variation for packaged configuration.
		// loadFromPropertyFile(this.getClass().getResourceAsStream(toPropertyFilename(this.toName())));
		loadFromPropertyFile(this.getClass().getClassLoader().getResourceAsStream(toPropertyFilename(toName())));
	}

	/**
	 * Instantiates a new abstract configuration.
	 *
	 * @param filename the filename
	 */
	public AbstractXmlConfig(final String filename) {
		// use this variation for packaged configuration.
		// loadFromXmlFile(this.getClass().getResourceAsStream(toXmlFilename(this.toName())));
		loadFromXmlFile(this.getClass().getClassLoader().getResourceAsStream(toXmlFilename(filename)));

		// use this variation for packaged configuration.
		// loadFromPropertyFile(this.getClass().getResourceAsStream(toPropertyFilename(this.toName())));
		loadFromPropertyFile(this.getClass().getClassLoader().getResourceAsStream(toPropertyFilename(filename)));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.wicast.ConfigInterface#getProperty(java.lang.String)
	 */
	@Override
	public String getProperty(final String key) {
		return key;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.wicast.ConfigInterface#getProperty(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public String getProperty(final String key, final String defaultValue) {
		return defaultValue;
	}

	/**
	 * return first Element with Tag Name.
	 *
	 * @param elementName the element name
	 * @return Element
	 */
	protected Element firstElementByTagName(final String elementName) {
		context = configElement.getElementsByTagName(elementName);
		return (Element) context.item(index = 0);
	}

	/**
	 * get attribute from current element.
	 *
	 * @param attributeName the attribute name
	 * @return attribute value as String.
	 */
	protected String getAttribute(final String attributeName) {
		return configElement.getAttribute(attributeName);
	}

	/**
	 * return a NodeList of nested Elements.
	 *
	 * @param elementName the element name
	 * @return NodeList
	 */
	protected NodeList getElementsByTagName(final String elementName) {
		return configElement.getElementsByTagName(elementName);
	}

	/**
	 * get Tag Name of element.
	 *
	 * @return element name as String
	 */
	protected String getTagName() {
		return configElement.getTagName();
	}

	/**
	 * Load from property file.
	 *
	 * @param inputStream the input stream
	 */
	protected void loadFromPropertyFile(final InputStream inputStream) {
		try {
			properties.load(inputStream);
		} catch (final Exception e) {
			AbstractXmlConfig.log.error("{}", e);
		}
	}

	/**
	 * Load from xml file.
	 *
	 * @param inputStream the input stream
	 */
	protected void loadFromXmlFile(final InputStream inputStream) {
		try {
			properties.load(inputStream);
		} catch (final Exception e) {
			AbstractXmlConfig.log.error("{}", e);
		}
	}

	/**
	 * return next Element.
	 *
	 * @return Element
	 */
	protected Element nextElementByTagName() {
		return (Element) context.item(++index);
	}

	/**
	 * Save as properties.
	 *
	 * @return true is successful otherwise false
	 */
	protected boolean saveAsProperties() {
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream(AbstractXmlConfig.PROPERTIES_TO_PROPERTIES);

			try {
				properties.store(fileOutputStream, "properties.store");

				fileOutputStream = new FileOutputStream(AbstractXmlConfig.XML_TO_PROPERTIES);
				try {
					propertiesFromXml.store(fileOutputStream, "propertiesFromXml.store");
				} catch (final IOException e) {
					AbstractXmlConfig.log.error("{}", e);
				}
			} catch (final IOException e) {
				AbstractXmlConfig.log.error("{}", e);
			}
		} catch (final FileNotFoundException e) {
			AbstractXmlConfig.log.error("{}", e);
		}
		return true;
	}

	/**
	 * Save as xml.
	 *
	 * @return true is successful otherwise false
	 */
	public boolean saveAsXml() {
		final String encoding = "UTF-8";
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream("fromProperties.xml");

			try {
				String comment = "properties.storeToXML";
				properties.storeToXML(fileOutputStream, comment, encoding);

				fileOutputStream = new FileOutputStream("propertiesFromXml.xml");

				try {
					comment = "propertiesFromXml.storeToXML";
					propertiesFromXml.storeToXML(fileOutputStream, comment, encoding);
				} catch (final IOException e) {
					AbstractXmlConfig.log.error("{}", e);
				}
			} catch (final IOException e) {
				AbstractXmlConfig.log.error("{}", e);
			}
		} catch (final Exception e) {
			AbstractXmlConfig.log.error("{}", e);
		}
		return true;
	}

	/**
	 * To name.
	 *
	 * @return the string
	 */
	private String toName() {
		return this.getClass().getSimpleName();
	}

	/**
	 * To property filename.
	 *
	 * @param filename the filename
	 * @return the string
	 */
	private String toPropertyFilename(final String filename) {
		return String.format("%s.properties", filename);
	}

	/**
	 * To XML filename.
	 *
	 * @param filename the filename
	 * @return the string
	 */
	protected String toXmlFilename(final String filename) {
		return String.format("%s.xml", filename);
	}

	/**
	 * toXml.
	 *
	 * @return in xml as String Object.
	 */
	protected String toXml() {
		final StringWriter writer = new StringWriter();
		try {
			final DOMSource domSource = new DOMSource(configDocument);
			final StreamResult result = new StreamResult(writer);
			final TransformerFactory tf = TransformerFactory.newInstance();
			final Transformer transformer = tf.newTransformer();
			transformer.transform(domSource, result);
		} catch (final TransformerConfigurationException e) {
			AbstractXmlConfig.log.error("{}", e);
		} catch (final TransformerFactoryConfigurationError e) {
			AbstractXmlConfig.log.error("{}", e);
		} catch (final TransformerException e) {
			AbstractXmlConfig.log.error("{}", e);
		}
		return writer.toString();
	}

	/**
	 * return configuration node as a XML String.
	 *
	 * @param node Node
	 * @return element CDATA as String.
	 */
	protected String xmlToString(final Node node) {
		StringBuffer text = new StringBuffer("");
		if (node != null) {
			final String value = node.getNodeValue();
			if (value != null) {
				text = new StringBuffer(value);
			}
			if (node.hasChildNodes()) {
				final NodeList children = node.getChildNodes();
				for (int i = 0; i < children.getLength(); i++) {
					text.append(xmlToString(children.item(i)));
				}
			}
		}
		return text.toString();
	}

	/**
	 * Dump to log.
	 */
	public void dumpToLog() {
		AbstractXmlConfig.log.info("{}.dumpToLog", this.getClass().getSimpleName());
		AbstractXmlConfig.log.info(toXml());
		AbstractXmlConfig.log.info(xmlToString(configDocument));
		AbstractXmlConfig.log.info(properties.toString());
		AbstractXmlConfig.log.info(propertiesFromXml.toString());
	}

	/**
	 * toString returns this configuration as XML String.
	 *
	 * @return string representation of this object.
	 */
	@Override
	public String toString() {
		return null != configElement ? xmlToString(configElement) : "null";
	}

}
