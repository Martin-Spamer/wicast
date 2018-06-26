
package net.wicast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Properties;

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
 * Configuration from XML.
 */
public abstract class AbstractXmlConfig implements ConfigInterface {

    /** The Constant XML_TO_PROPERTIES. */
    private static final String XML_TO_PROPERTIES = "./target/fromXml.properties";
    
    /** The Constant PROPERTIES_TO_PROPERTIES. */
    private static final String PROPERTIES_TO_PROPERTIES = "./target/fromProperties.properties";
    
    /** provides logging. */
    protected final Logger log = LoggerFactory.getLogger(AbstractXmlConfig.class);

    /** The properties. */
    private final Properties properties = new Properties();
    
    /** The properties from xml. */
    private final Properties propertiesFromXml = new Properties();
    
    /** The config document. */
    private final Document configDocument = null;
    
    /** The config element. */
    private final Element configElement = null;
    
    /** The context. */
    private NodeList context = null;
    
    /** The index. */
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
     * @return NodeList
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
    protected void loadFromPropertyFile(final InputStream inputStream) {
        try {
            this.properties.load(inputStream);
        } catch (final Exception exception) {
            this.log.error(exception.toString());
        }
    }

    /**
     * Load from xml file.
     *
     * @param inputStream the input stream
     */
    protected void loadFromXmlFile(final InputStream inputStream) {
        try {
            this.properties.load(inputStream);
        } catch (final Exception exception) {
            this.log.error(exception.toString());
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
    protected boolean saveAsProperties() {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(AbstractXmlConfig.PROPERTIES_TO_PROPERTIES);

            try {
                this.properties.store(fileOutputStream, "properties.store");

                fileOutputStream = new FileOutputStream(AbstractXmlConfig.XML_TO_PROPERTIES);
                try {
                    this.propertiesFromXml.store(fileOutputStream, "propertiesFromXml.store");
                } catch (final IOException exception) {
                    this.log.error(exception.toString());
                }
            } catch (final IOException exception) {
                this.log.error(exception.toString());
            }
        } catch (final FileNotFoundException exception) {
            this.log.error(exception.toString());
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
            fileOutputStream = new FileOutputStream("./target/fromProperties.xml");

            try {
                String comment = "properties.storeToXML";
                this.properties.storeToXML(fileOutputStream, comment, encoding);

                fileOutputStream = new FileOutputStream("./target/propertiesFromXml.xml");

                try {
                    comment = "propertiesFromXml.storeToXML";
                    this.propertiesFromXml.storeToXML(fileOutputStream, comment, encoding);
                } catch (final IOException exception) {
                    this.log.error(exception.toString());
                }
            } catch (final IOException exception) {
                this.log.error(exception.toString());
            }
        } catch (final Exception exception) {
            this.log.error(exception.toString());
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
            final DOMSource domSource = new DOMSource(this.configDocument);
            final StreamResult result = new StreamResult(writer);
            final TransformerFactory tf = TransformerFactory.newInstance();
            final Transformer transformer = tf.newTransformer();
            transformer.transform(domSource, result);
        } catch (final TransformerConfigurationException e) {
            this.log.error("{}", e);
        } catch (final TransformerFactoryConfigurationError e) {
            this.log.error("{}", e);
        } catch (final TransformerException e) {
            this.log.error("{}", e);
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
        this.log.info("{}.dumpToLog", this.getClass().getSimpleName());
        this.log.info(toXml());
        this.log.info(xmlToString(this.configDocument));
        this.log.info(this.properties.toString());
        this.log.info(this.propertiesFromXml.toString());
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

}
