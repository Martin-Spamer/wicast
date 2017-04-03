package net.wicast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * An Abstract Configuration Class for holding the Configuration from XML.
 */
public abstract class AbstractConfig implements ConfigInterface {

    private static final String XML_TO_PROPERTIES = "fromXml.properties";
    private static final String PROPERTIES_TO_PROPERTIES = "fromProperties.properties";
    private static final Logger log = LoggerFactory.getLogger(AbstractConfig.class);
    private static DocumentBuilderFactory documentBuilderFactory = null;
    private static DocumentBuilder documentBuilder = null;

    static {
        AbstractConfig.documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            AbstractConfig.documentBuilder = AbstractConfig.documentBuilderFactory.newDocumentBuilder();
        } catch (final ParserConfigurationException parserConfigurationException) {
            AbstractConfig.log.error(parserConfigurationException.toString());
        }
    }

    private final Properties properties = new Properties();
    private final Properties propertiesFromXml = new Properties();
    private final Document configDocument = null;
    private final Element configElement = null;
    private NodeList context = null;

    private int index = 0;

    /**
     * default Constructor. loads the default configuration from jar, then loads
     * override configuration from a file. with the same filename as classname +
     * ".xml".
     */
    public AbstractConfig() {

        // use this variation for packaged configuration.
        // loadFromXmlFile(this.getClass().getResourceAsStream(toXmlFilename(this.toName())));
        loadFromXmlFile(this.getClass().getClassLoader().getResourceAsStream(toXmlFilename(toName())));

        // use this variation for packaged configuration.
        // loadFromPropertyFile(this.getClass().getResourceAsStream(toPropertyFilename(this.toName())));
        loadFromPropertyFile(this.getClass().getClassLoader().getResourceAsStream(toPropertyFilename(toName())));

    }

    /**
     * @param filename
     */
    public AbstractConfig(final String filename) {
        // use this variation for packaged configuration.
        // loadFromXmlFile(this.getClass().getResourceAsStream(toXmlFilename(this.toName())));
        loadFromXmlFile(this.getClass().getClassLoader().getResourceAsStream(toXmlFilename(filename)));

        // use this variation for packaged configuration.
        // loadFromPropertyFile(this.getClass().getResourceAsStream(toPropertyFilename(this.toName())));
        loadFromPropertyFile(this.getClass().getClassLoader().getResourceAsStream(toPropertyFilename(filename)));
    }

    /**
     * Dump to log.
     */
    public void dumpToLog() {
        AbstractConfig.log.info(xmlFoo());
        AbstractConfig.log.info(xmlToString(this.configDocument));
        AbstractConfig.log.info(this.properties.toString());
        AbstractConfig.log.info(this.propertiesFromXml.toString());
    }

    /**
     * return first Element with Tag Name.
     *
     * @param elementName the element name
     * @return Element
     */
    protected Element firstElementByTagName(final String elementName) {
        this.context = this.configElement.getElementsByTagName(elementName);
        return (Element) this.context.item(this.index = 0);
    }

    /**
     * get attribute from current element.
     *
     * @param attributeName the attribute name
     * @return attribute value as String.
     */
    protected String getAttribute(final String attributeName) {
        return this.configElement.getAttribute(attributeName);
    }

    /**
     * return a NodeList of nested Elements.
     *
     * @param elementName the element name
     * @return org.w3c.dom.NodeList
     */
    protected NodeList getElementsByTagName(final String elementName) {
        return this.configElement.getElementsByTagName(elementName);
    }

    /**
     * get Tag Name of element.
     *
     * @return element name as String
     */
    protected String getTagName() {
        return this.configElement.getTagName();
    }

    /**
     * Load from property file.
     *
     * @param inputStream the input stream
     */
    private void loadFromPropertyFile(final InputStream inputStream) {
        try {
            this.properties.load(inputStream);
        } catch (final Exception e) {
            AbstractConfig.log.error("{}", e);
        }
    }

    /**
     * Load from xml file.
     *
     * @param inputStream the input stream
     */
    private void loadFromXmlFile(final InputStream inputStream) {
        try {
            this.properties.load(inputStream);
        } catch (final Exception e) {
            AbstractConfig.log.error("{}", e);
        }
    }

    /**
     * return next Element.
     *
     * @return Element
     */
    protected Element nextElementByTagName() {
        return (Element) this.context.item(++this.index);
    }

    /**
     * Save as properties.
     *
     * @return true is successful otherwise false
     */
    public boolean saveAsProperties() {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(PROPERTIES_TO_PROPERTIES);

            try {
                this.properties.store(fileOutputStream, "properties.store");

                fileOutputStream = new FileOutputStream(XML_TO_PROPERTIES);
                try {
                    this.propertiesFromXml.store(fileOutputStream, "propertiesFromXml.store");
                } catch (final IOException e) {
                    AbstractConfig.log.error("{}", e);
                }
            } catch (final IOException e) {
                AbstractConfig.log.error("{}", e);
            }
        } catch (final FileNotFoundException e) {
            AbstractConfig.log.error("{}", e);
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
                this.properties.storeToXML(fileOutputStream, comment, encoding);

                fileOutputStream = new FileOutputStream("propertiesFromXml.xml");

                try {
                    comment = "propertiesFromXml.storeToXML";
                    this.propertiesFromXml.storeToXML(fileOutputStream, comment, encoding);
                } catch (final IOException e) {
                    AbstractConfig.log.error("{}", e);
                }

            } catch (final IOException e) {
                AbstractConfig.log.error("{}", e);
            }

        } catch (final Exception e) {
            AbstractConfig.log.error("{}", e);
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
     * toString returns this configuration as XML String.
     *
     * @return string representation of this object.
     */
    @Override
    public String toString() {
        return null != this.configElement ? xmlToString(this.configElement) : "null";
    }

    /**
     * To xml filename.
     *
     * @param filename the filename
     * @return the string
     */
    private String toXmlFilename(final String filename) {
        return String.format("%s.xml", filename);
    }

    /**
     * xmlFoo.
     *
     * @return in xml as String Object.
     */
    public String xmlFoo() {
        final StringWriter writer = new StringWriter();
        try {
            final DOMSource domSource = new DOMSource(this.configDocument);
            final StreamResult result = new StreamResult(writer);
            final TransformerFactory tf = TransformerFactory.newInstance();
            final Transformer transformer = tf.newTransformer();
            transformer.transform(domSource, result);
        } catch (final TransformerConfigurationException e) {
            AbstractConfig.log.error("{}", e);
        } catch (final TransformerFactoryConfigurationError e) {
            AbstractConfig.log.error("{}", e);
        } catch (final TransformerException e) {
            AbstractConfig.log.error("{}", e);
        }
        return writer.toString();
    }

    /**
     * return configuration node as a XML String.
     *
     * @param node org.w3c.dom.Node
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

}
