/**
 * This file is part of Automated Testing Framework for Java (atf4j).
 *
 * Atf4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Atf4j is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with atf4j.  If not, see http://www.gnu.org/licenses/.
 */
package net.wicast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Properties;

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
import org.xml.sax.SAXException;

/**
 * An Abstract Configuration Class for holding the Configuration from XML.
 *
 * @author <author@wicast.net>
 */
public abstract class AbstractConfig implements ConfigInterface {

    private static final Logger log = LoggerFactory.getLogger(AbstractConfig.class);
    private static javax.xml.parsers.DocumentBuilderFactory documentBuilderFactory = null;
    private static javax.xml.parsers.DocumentBuilder documentBuilder = null;

    static {
        AbstractConfig.documentBuilderFactory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
        try {
            AbstractConfig.documentBuilder = AbstractConfig.documentBuilderFactory.newDocumentBuilder();
        } catch (final ParserConfigurationException parserConfigurationException) {
            log.error("{}", parserConfigurationException);
        }
    }

    private final Properties properties = new Properties();
    private final Properties propertiesFromXml = new Properties();

    private org.w3c.dom.Document configDocument = null;

    private org.w3c.dom.Element configElement = null;
    private org.w3c.dom.NodeList context = null;

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

        try {
            final InputStream resourceAsStream = this.getClass()
                                                     .getClassLoader()
                                                     .getResourceAsStream("Application.xml");
            this.configDocument = AbstractConfig.documentBuilder.parse(resourceAsStream);
            this.configElement = this.configDocument.getDocumentElement();
        } catch (final SAXException e) {
            log.error("{}", e);
        } catch (final IOException e) {
            log.error("{}", e);
        }
    }

    /**
     * Dump to log.
     */
    public void dumpToLog() {
        log.info(xmlFoo());
        log.info(xmlToString(this.configDocument));
        log.info(this.properties.toString());
        log.info(this.propertiesFromXml.toString());
    }

    /**
     * return first Element with Tag Name.
     *
     * @param elementName the element name
     * @return org.w3c.dom.Element
     */
    protected org.w3c.dom.Element firstElementByTagName(final String elementName) {
        this.context = this.configElement.getElementsByTagName(elementName);
        return (org.w3c.dom.Element) this.context.item(this.index = 0);
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
    protected org.w3c.dom.NodeList getElementsByTagName(final String elementName) {
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

    /* (non-Javadoc)
     * @see net.wicast.ConfigInterface#load()
     */
    @Override
    public boolean load() {
        return false;
    }

    /**
     * Load.
     *
     * @param file the file
     * @return true, if successful
     */
    public boolean load(final File file) {
        return false;
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
            log.error("{}", e);
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
            log.error("{}", e);
        }
    }

    /**
     * return next Element.
     *
     * @return org.w3c.dom.Element
     */
    protected org.w3c.dom.Element nextElementByTagName() {
        return (org.w3c.dom.Element) this.context.item(++this.index);
    }

    /**
     * Save as properties.
     *
     * @return true is successful otherwise false
     */
    @Override
    public boolean saveAsProperties() {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream("fromProperties-out.properties");

            try {
                this.properties.store(fileOutputStream, "comment properties.store");

                fileOutputStream = new FileOutputStream("propertiesFromXml-out.properties");
                try {
                    this.propertiesFromXml.store(fileOutputStream, "comment propertiesFromXml.store");
                } catch (final IOException e) {
                    log.error("{}", e);
                }

            } catch (final IOException e) {
                log.error("{}", e);
            }

        } catch (final FileNotFoundException e) {
            log.error("{}", e);
        }

        return true;
    }

    /**
     * Save as xml.
     *
     * @return true is successful otherwise false
     */
    @Override
    public boolean saveAsXml() {
        final String encoding = "UTF-8";
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream("fromProperties.xml");

            try {
                String comment = "comment properties.storeToXML";
                this.properties.storeToXML(fileOutputStream, comment, encoding);

                fileOutputStream = new FileOutputStream("propertiesFromXml.xml");

                try {
                    comment = "comment propertiesFromXml.storeToXML";
                    this.propertiesFromXml.storeToXML(fileOutputStream, comment, encoding);
                } catch (final IOException e) {
                    log.error("{}", e);
                }

            } catch (final IOException e) {
                log.error("{}", e);
            }

        } catch (final Exception e) {
            log.error("{}", e);
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
            log.error("{}", e);
        } catch (final TransformerFactoryConfigurationError e) {
            log.error("{}", e);
        } catch (final TransformerException e) {
            log.error("{}", e);
        }
        return writer.toString();
    }

    /**
     * return configuration node as a XML String.
     *
     * @param node org.w3c.dom.Node
     * @return element CDATA as String.
     */
    protected String xmlToString(final org.w3c.dom.Node node) {
        StringBuffer text = new StringBuffer("");
        if (node != null) {
            final String value = node.getNodeValue();
            if (value != null) {
                text = new StringBuffer(value);
            }
            if (node.hasChildNodes()) {
                final org.w3c.dom.NodeList children = node.getChildNodes();
                for (int i = 0; i < children.getLength(); i++) {
                    text.append(xmlToString(children.item(i)));
                }
            }
        }
        return text.toString();
    }

}
